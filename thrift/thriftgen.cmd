#!/bin/sh

xrpcgen-0.9.0 --gen java zmp3_publishermw_service.thrift

cp gen-java/* ../src/ -rf
rm gen-java -rf

