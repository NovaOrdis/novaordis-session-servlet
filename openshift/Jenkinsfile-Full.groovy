try {

    timeout(time: 20, unit: 'MINUTES') {

        def project=""
        def mavenCommand="mvn"

        node {

            stage("initialize") {

                echo "initializing ..."

                project = env.PROJECT_NAME
                mavenCommand = "mvn -s openshift/nexus-settings.xml -Djavax.net.ssl.trustStore=openshift/nexus.truststore -Djavax.net.ssl.trustStorePassword=nexus123"
            }
        }

        node("maven") {

            stage("checkout") {

                echo "checking out from ${GIT_REPOSITORY_URL} ..."

                git url: "${GIT_REPOSITORY_URL}", branch: "master"

                echo "check out ok"
            }

            stage("build") {

                echo "building maven artifacts without tests ..."

                sh "${mavenCommand} clean package -Dmaven.test.skip=true"

                echo "build ok"

                stash name:"build-artifacts", includes:"target/session-servlet.war"
            }

            stage("tests") {

                parallel(

                        "unit tests": {

                            sh "${mavenCommand} clean test"
                        },
                        "coverage tests": {

                            sh "${mavenCommand} sonar:sonar -Dsonar.host.url=http://sonarqube:9000 -DskipTests=true"
                        }
                )
            }

            stage ("publish to Nexus") {

                // sh "${mavenCommand} deploy -DskipTests=true"
            }

            stage("deploy dev") {

                echo "deploying in dev ..."

                sh "rm -rf oc-build && mkdir -p oc-build/deployments"
                sh "cp target/session-servlet.war oc-build/deployments"
                sh "oc delete bc,dc,svc,route -l app=noss-dev"
                sh "oc new-build --name=binary -labels=app=noss-dev --image-stream=jboss-eap70-openshift:1.5 --binary=true"
                sh "oc start-build binary --from-dir=oc-build --wait=true"
                sh "oc new-app noss-dev:latest"
                sh "oc expose svc/noss-dev"
            }
        }


        node {

//            stage("deploy dev") {
//
//                echo "deploying in dev ..."
//
//                unstash name:"build-artifacts", includes:"target/session-servlet.war"

            }

            stage("deploy test") {

                echo "deploying in test ..."
            }

            stage("deploy prod") {

                echo "deploying in prod ..."
            }

        }


//        node {
//
//            stage("build image") {
//
//                echo "building image ..."
//
//                unstash name:"war"
//
//                sh "oc start-build ${appName}-docker --from-file=target/ROOT.war -n ${project}"
//
//                openshiftVerifyBuild bldCfg: "${appName}-docker", namespace: project, waitTime: '20', waitUnit: 'min'
//            }
//
//            stage("Deploy") {
//
//                openshiftDeploy deploymentConfig: appName, namespace: project
//            }
//        }

}
catch (err) {

    echo "build failure: ${err}"
    currentBuild.result = 'FAILURE'
    throw err
}