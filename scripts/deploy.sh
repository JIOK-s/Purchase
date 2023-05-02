#!/bin/bash

REPOSITORY=/home/ec2-user/app/jiok-service
PROJECT_NAME=Purchase

echo "> 현재 구동중인 애플리케이션 pid 확인"

CURRENT_PID=$(pgrep -fl jiok-service | grep jar | awk '{print $1}')

echo "현재 구동중인 애플리케이션pid: $CURRENT_PID"

if [ -z $CURRENT_PID ]; then
        echo "> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다."
else
        echo "> kill -15 $CURRENT_PID"
        kill -15 $CURRENT_PID
        sleep 5
fi

echo "> 새 애플리케이션 배포"

JAR_NAME=$(ls -tr $REPOSITORY/$PROJECT_NAME/*.jar | tail -n 1)

echo "> JAR NAME: $JAR_NAME"

echo "> $JAR_NAME에 실행권한 추가"

chmod +x $JAR_NAME

nohup java -jar -Dspring.config.location=classpath:/application.yml,/home/ec2-user/app/jiok-service/Purchase/application-db.yml $JAR_NAME 2>&1 &
