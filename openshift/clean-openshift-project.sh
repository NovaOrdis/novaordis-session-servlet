#!/bin/bash

[ -f ~/playground/openshift/oc-bash/functions ] && . ~/playground/openshift/oc-bash/functions || { echo "~/playground/openshift/oc-bash/functions not found" 1>&2; exit 1; }

openshift_project_name="noss-dev-pipeline"

function main() {

    verify-project-name ${openshift_project_name}

    oc-delete is/builder-image-eap7
    oc-delete is/noss

    oc-delete bc/s2i
    oc-delete bc/pipeline-s2i
    oc-delete bc/pipeline-full

    oc delete dc, route, svc -l app=noss-dev

    oc-delete dc/jenkins
    oc-delete routes/jenkins
    oc-delete svc/jenkins
    oc-delete svc/jenkins-jnlp

}

main $@