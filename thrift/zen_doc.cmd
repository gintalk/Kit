#!/bin/sh

USER=zdeploy
DOC_SERVER=10.60.28.69
DOC_DIR=/zserver/java-projects/ZMP3Docs
LOCAL_DIR=./
PROJECT_NAME=`basename "$(cd ../ && pwd)"`
PRODUCT=zmp3
FEATURE=publisher

xrpcgen-0.9.0 --gen html ../../../../zcommon/common/ZMediaCommonLib/thrift/zmedia_common_shared.thrift
xrpcgen-0.9.0 --gen html ../../../../zmp3-new/common/ZMP3Engine/thrift/zmp3_publisher_shared.thrift
xrpcgen-0.9.0 --gen html zmp3_publishermw_service.thrift

mkdir -p $LOCAL_DIR/$PRODUCT/$FEATURE/$PROJECT_NAME/

cp -r $LOCAL_DIR/gen-html/* $LOCAL_DIR//$PRODUCT/$FEATURE/$PROJECT_NAME/

rsync -auvrR --delete $LOCAL_DIR/$PRODUCT/$FEATURE/$PROJECT_NAME/ $USER@$DOC_SERVER:$DOC_DIR/

rm -rf $LOCAL_DIR/$PRODUCT/
rm -rf $LOCAL_DIR/gen-html/