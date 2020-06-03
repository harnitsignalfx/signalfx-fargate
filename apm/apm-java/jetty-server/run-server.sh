#!/bin/sh

set -x

export SIGNALFX_SERVICE_NAME=EchoServer-JavaTagDemo

mvn compile exec:exec \
  -Dexec.executable="java" \
  -Dexec.args="-javaagent:signalfx-tracing.jar -cp %classpath sf.main.EchoDemo 5000"
