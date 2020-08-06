#!/bin/bash
PROJECT_NAME=`basename "$PWD"`
ZAPPPROF=$1
PORT=$2
HOST=0.0.0.0
HOME_DIR="/zserver/java-projects/$PROJECT_NAME"

CMD_START="$HOME_DIR/runservice start $ZAPPPROF"
CMD_STOP="$HOME_DIR/runservice stop $ZAPPPROF"
PID_FILE="/tmp/$PROJECT_NAME/$PROJECT_NAME.pid"

if [ -z "$PROJECT_NAME" ]; then
    echo "PROJECT_NAME is empty"
    exit 1
fi

if [ -z "$ZAPPPROF" ]; then
    echo "ZAPPPROF is empty"
    exit 1
fi

if [ -z "$PORT" ]; then
    echo "PORT is empty"
    exit 1
fi

cd $HOME_DIR

if [ "$HOME_DIR" != "$PWD" ]; then
    echo "Only start project in /zserver/java-project/"
    exit 1
fi

func_start() {
	echo "Starting service $PROJECT_NAME mode $ZAPPPROF ..........."
	$CMD_START
	sleep 1
	echo "Checking .."
	PID=`cat $PID_FILE`
	## check process
	while (true); do
        	/usr/local/nagios/libexec/check_tcp -H $HOST -p $PORT
	        if [ $? -eq 0 ];then
        	        break
        	fi
	        echo  "Waiting process $PROJECT_NAME start ..."
        	sleep 1
	done
	echo;echo "Started.";echo

}
func_stop() {
	if ! [ -f $PID_FILE ]; then
		echo "PID file of $PROJECT_NAME not found"
        ##Check process
		PID=`ps -ef|grep -v grep|grep -w $PROJECT_NAME|awk '{print $2}'`
		if ! [ -z $PID ]; then
			echo "Process $PROJECT_NAME is running !!!!. Kill -9 $PROJECT_NAME"
			kill -9 $PID
		fi
		return 1
	fi
	PID=`cat $PID_FILE`
	if  [ -z $PID ]; then
		echo "PID of $PROJECT_NAME not found"
		PID=`ps -ef|grep -v grep|grep -w $PROJECT_NAME|awk '{print $2}'`
		if ! [ -z $PID ]; then
			echo "Process $PROJECT_NAME is running !!!!. Kill -9 $PROJECT_NAME"
			kill -9 $PID
		fi
		rm -f $PID_FILE
		return 2
	fi
	PID=`cat $PID_FILE`
	echo "Stoping service $PROJECT_NAME ..........."
	$CMD_STOP
	## check listen port
	while (true); do
        	/usr/local/nagios/libexec/check_tcp -H $HOST -p $PORT
		if [ $? -eq 2 ];then
			break
		fi
		echo  "Waiting process $PROJECT_NAME stop ..."
		sleep 1 
	done
	## check process
	while (true); do
		ps -ef|grep -v grep|grep -w $PID
		if [ $? -eq 1 ];then
        	        break
	        fi
	        echo "Waiting process $PROJECT_NAME stop ..."
	        sleep 1
	done

	echo;echo "Stoped.";echo
}

##Main
if [ "$PORT" == "_port" ]; then
	echo "pls update running port.."
	exit 1
fi

##restart
func_stop
sleep 5
func_start

