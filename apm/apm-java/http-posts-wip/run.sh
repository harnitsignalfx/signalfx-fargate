#!/bin/sh

mvn compile exec:exec \
  -Dexec.executable="java" \
  -Dexec.args="-javaagent:signalfx-tracing.jar -cp %classpath sf.main.PostExample"
