#!/bin/sh
_DEBUG=true
_COMPRESS=true
DIR_NAME=jz-mw-thrift
THRIFT_PACKAGE_DIR=com/vng/zing/media/mp3/publisher/mw
PROJECT_NAME=$DIR_NAME
PROJECT_DIR=$DIR_NAME
JAR_DIR=jar
JAR_NAME=zmp3-publisher-mw
VERSION=0.9.0.0

#common variables
DEPLOY_DIR=$(pwd)/"$JAR_DIR"
DEPLOY_JAR="$PROJECT_NAME""$THRIFT_VER"-"$VERSION".jar

#copy Java src
rm -rf $DIR_NAME/src/*

mkdir -p $DIR_NAME/src/$THRIFT_PACKAGE_DIR

cp -r ../src/$THRIFT_PACKAGE_DIR/* $DIR_NAME/src/$THRIFT_PACKAGE_DIR


mkdir -p $DIR_NAME/src/conf
cp -r ./conf/* $DIR_NAME/src/conf

#-------------------------------------------------------------------------------
#Java build & deploy

#build
#cd $DIR_NAME
#./build.cmd
#cd ..
ant -f $PROJECT_DIR/build.xml clean
ant -f $PROJECT_DIR/build.xml jar -Djavac.debug=$_DEBUG -Djar.compress=$_COMPRESS

#move to jar dir
mkdir -p $DEPLOY_DIR
cp $PROJECT_DIR/dist/"$DIR_NAME".jar $DEPLOY_DIR/"$JAR_NAME"-"$VERSION".jar
cp $DEPLOY_DIR/"$JAR_NAME"-"$VERSION".jar ../../../Lib/

#clean build output
ant -f $PROJECT_DIR/build.xml clean

#clean Java src
rm -rf $DIR_NAME/src/*
