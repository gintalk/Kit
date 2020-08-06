#!/bin/bash 
LOCAL_DIR=./
PROJECT_NAME=`basename "$PWD"`
SERVER_DIR=/zserver/java-projects/$PROJECT_NAME
DEV_SERVER=10.30.80.68
SERVICE_PORT=10610
USER=zdeploy
ZAPPPROF=development

echo "Deploying $PROJECT_NAME mode $ZAPPPROF to $USER:$DEV_SERVER ";echo

echo "Build... ";echo
#./build.cmd

echo "Rsync... ";echo
rsync -auvr --delete $LOCAL_DIR/restart.sh $USER@$DEV_SERVER:$SERVER_DIR/
rsync -auvr --delete $LOCAL_DIR/rsync.sh $USER@$DEV_SERVER:$SERVER_DIR/
rsync -auvr --delete $LOCAL_DIR/rollback.sh $USER@$DEV_SERVER:$SERVER_DIR/

rsync -auvr --delete $LOCAL_DIR/cmd $USER@$DEV_SERVER:$SERVER_DIR/
rsync -auvr --delete $LOCAL_DIR/dist $USER@$DEV_SERVER:$SERVER_DIR/
rsync -auvr --delete $LOCAL_DIR/conf $USER@$DEV_SERVER:$SERVER_DIR/
rsync -auvr --delete $LOCAL_DIR/runservice $USER@$DEV_SERVER:$SERVER_DIR/

echo "Restart... ";echo
ssh $USER@$DEV_SERVER "cd $SERVER_DIR && /bin/bash ./restart.sh $ZAPPPROF $SERVICE_PORT"

echo "Done!!!"
