# Java Tag Generator Using HTTP GET request libraries

GetExample.java is an example of how to send GET request traces using two different libraries
JMX metrics are enable to monitor the java stats to be seen by the SignalFx agent.
Note that these will not generate RED service dashboard! Only spans/traces.

## Building

## Step 0

Install SignalFx Agent and configure for APM: https://docs.signalfx.com/en/latest/apm/apm-getting-started/apm-smart-agent.html

## Step 1

Download current SignalFx Java autoinstrumentation .jar:

```
curl -L https://github.com/signalfx/signalfx-java-tracing/releases/latest/download/signalfx-tracing.jar -o signalfx-tracing.jar
```

Set the proper environment variables:

export SIGNALFX_SERVICE_NAME="http-req-generator"   
export SIGNALFX_ENDPOINT_URL="http://localhost:9080/v1/trace"   

## Step 2: Build and run Java trace generator

```
$ sh run.sh
```

1000 traces using two different libraries will be sent
