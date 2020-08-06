APP_PROF=$1
BACKUP_DIR_NAME=$2
APP_NAME=`basename "$PWD"`
BK_DIR="/zserver/backup/$APP_NAME"
BK_PROJECT_DIR="$BK_DIR/$BACKUP_DIR_NAME"

if  [ "$BACKUP_DIR_NAME" = "" -o "$BACKUP_DIR_NAME" = "latest" ]; then
	cd $BK_DIR
	BK_PROJECT_DIR="$BK_DIR/$(ls -td -- */ | head -n 1)"
fi

echo "Restoring source..."

echo $BK_PROJECT_DIR

rsync -a $BK_PROJECT_DIR/ /zserver/java-projects/$APP_NAME/ 

cd /zserver/java-projects/$APP_NAME/
/bin/bash ./runservice restart $APP_PROF
exit 0
