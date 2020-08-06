#!/bin/bash
DEV_SERVER=$1
APP_NAME=`basename "$PWD"`

BK_DIR="/zserver/backup/$APP_NAME/`date +%y%m%d_%H%M`"

echo "Backing up to $BK_DIR ..."
if ! [ -d $BK_DIR ]; then
        mkdir -p $BK_DIR
        rsync -aur /zserver/java-projects/$APP_NAME/ $BK_DIR/
fi

echo;echo "Syncing new code ....";echo
rsync --delete -aurv $DEV_SERVER::java-projects/$APP_NAME/cmd /zserver/java-projects/$APP_NAME/
rsync --delete -aurv $DEV_SERVER::java-projects/$APP_NAME/conf /zserver/java-projects/$APP_NAME/
rsync --delete -aurv $DEV_SERVER::java-projects/$APP_NAME/dist /zserver/java-projects/$APP_NAME/
rsync --delete -aurv $DEV_SERVER::java-projects/$APP_NAME/runservice /zserver/java-projects/$APP_NAME/

exit 0
