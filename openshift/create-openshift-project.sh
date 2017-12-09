#!/bin/bash

oc process -f $(dirname $0)/noss-template.yaml | oc create -f -
