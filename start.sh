#!/usr/bin/env bash

basePath=$(cd $(dirname "$0"); pwd)


function start() {
    project=$1
    ${basePath}/gradlew :${project}:bootRun
}


#启动时带参数，根据参数执行
if [ ${#} -eq 1 ]
then
   start "$1"
else
    echo "
    project is [ecommerce-product-service, ecommerce-order-service]
    示例命令如：./start <project>
    "
fi


