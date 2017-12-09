try {

    timeout(time: 20, unit: 'MINUTES') {

        def project=""
        def mavenCommand=""

        node {

            stage("initialize") {

                echo "initializing ..."

                project = env.PROJECT_NAME
                mavenCommand = "mvn -s openshift/nexus-settings.xml"
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

                stash name:"war", includes:"target/session-servlet.war"
            }

            stage("tests") {

                parallel(

                        "unit tests": {

                            sh "${mavenCommand} clean test"
                        },
                        "coverage tests": {

                            sh "${mavenCommand} clean test"
                        }
                )
            }
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