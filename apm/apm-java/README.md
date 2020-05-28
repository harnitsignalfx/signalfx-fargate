# Java Custom Tag Example Using Jetty

EchoDemo.java is an example of how to set custom tags for a span in Java.
Tags for the span name along with a customer key:value tag are easily set.

## Building

The example EchoServer.java example has comments indicating proper place for setting a custom operation name and span tag.
EchoServer.java will run a Jetty Embeded HTTP Server.

## Step 1

Download current SignalFx Java autoinstrumentation .jar:

```
curl -L https://github.com/signalfx/signalfx-java-tracing/releases/latest/download/signalfx-tracing.jar -o signalfx-tracing.jar
```

## Step 2: Build and run Java server

```
$ sh run-server.sh
```

## Step 3: Generating Traces

To execute many times and generate a large number of traces for testing use:
```
$ for n in {1..5000}; do curl http://localhost:5000/echo; done
```
