#!/bin/sh

mvn compile exec:exec \
  -Dexec.executable="java" \
  -Dexec.args="-cp %classpath sf.main.GetExample"
