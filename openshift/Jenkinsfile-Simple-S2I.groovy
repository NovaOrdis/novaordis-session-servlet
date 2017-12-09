node {

    stage ("S2I") {

        echo 'starting an s2i build ...'

        openshiftBuild apiURL: 'https://openshift.default.svc.cluster.local', authToken: '', bldCfg: 's2i', buildName: '', checkForTriggeredDeployments: 'false', commitID: '', namespace: '', showBuildLogs: 'true', verbose: 'true', waitTime: ''

        echo 's2i build complete'
    }
}