#!/bin/bash

for i in {1..100}
do 
	aws lambda invoke --function-name PythonDemo /dev/stdout 1>/dev/null &
done
for i in {1..50}
do 
	aws lambda invoke --function-name PythonBite /dev/stdout 1>/dev/null &
done
