#!/bin/bash 

PROJECT_NAME=`basename "$PWD"`
SOURCE_DIR=/zserver/java-projects/$PROJECT_NAME
USER=zdeploy
ZAPPPROF=production
SERVICE_PORT=10610
DEV_SERVER=10.30.80.68
LIVE_SERVER=(
    10.30.65.178
)

echo;echo "Deploying $PROJECT_NAME mode $ZAPPPROF from  DEV_SERVER:$DEV_SERVER ";echo

echo;echo "Are you sure? Press \"yes\" to continue!"
read line
if [ "$line" != "yes" ]; then
    echo;echo "Cancelled Deploying!";
    exit 1
fi

i=0
massdeploy=0
while [ "x${LIVE_SERVER[i]}" != "x" ]
do
	srv=${LIVE_SERVER[i]}
	echo echo "Update and restart $srv";echo

        echo "Rsync... ";echo
        
        ssh $USER@$srv "rsync --delete -aurv $DEV_SERVER::java-projects/$PROJECT_NAME/rsync.sh /zserver/java-projects/$PROJECT_NAME/ "
        ssh $USER@$srv "rsync --delete -aurv $DEV_SERVER::java-projects/$PROJECT_NAME/restart.sh /zserver/java-projects/$PROJECT_NAME/ "
        ssh $USER@$srv "rsync --delete -aurv $DEV_SERVER::java-projects/$PROJECT_NAME/rollback.sh /zserver/java-projects/$PROJECT_NAME/ "

        ssh $USER@$srv "cd $SOURCE_DIR && /bin/bash ./rsync.sh $DEV_SERVER "

        echo "Restart... ";echo
    	ssh $USER@$srv "cd $SOURCE_DIR && /bin/bash ./restart.sh $ZAPPPROF $SERVICE_PORT"

	echo;echo "Done $srv"

	i=$(( $i + 1 ))
	if [ "x${LIVE_SERVER[i]}" != "x" ]; then
                if [ $massdeploy -eq 0 ]; then
                        echo;echo "Press Enter to continue update --- ${LIVE_SERVER[i]}"
                        echo "Press \"1 + Enter\" to update all other"
                        read line
                        if [ "$line" == "1" ]; then
                                massdeploy=1
                        fi
                else
                        continue
                fi

	else
		echo "Done!!!"
	fi
done
