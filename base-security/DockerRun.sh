#!/bin/bash

if [ $1 == "staging" ]; then
    HOST_PORT=8091
elif [ $1 == "production" ]; then
    HOST_PORT=8092
else
    HOST_PORT=8090
fi

if [ -z "$2" ]; then
    IMAGE_VERSION=latest
else
    IMAGE_VERSION=$2
fi

DOCKER_REGISTRY=registry-vpc.cn-zhangjiakou.aliyuncs.com
DOCKER_IMAGE="$DOCKER_REGISTRY/randy0098/yummy-map-backend:$IMAGE_VERSION"
DOCKER_NAME="yummy-map-backend-$1"
DOCKER_PORT=8090
CAS_DOMAIN=cas.example.org
CAS_IP=39.98.185.90

echo "DOCKER_IMAGE:$DOCKER_IMAGE"

docker rm -f -v $DOCKER_NAME
docker run --name $DOCKER_NAME -d -p $HOST_PORT:$DOCKER_PORT --add-host=$CAS_DOMAIN:$CAS_IP --restart=always $DOCKER_IMAGE

#clean unused docker image
docker image prune -a -f