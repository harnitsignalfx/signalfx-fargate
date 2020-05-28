# Java Custom Tag Example Using Jetty

EchoDemo.java is an example of how to set custom tags for a span in Java.
Tags for the span name along with a customer key:value tag are easily set.

## Building

The example EchoServer.java example has comments indicating proper place for setting a custom operation name and span tag.

EchoServer.java will run a Jetty Embeded HTTP Server.

## Step 1:

To build and run the server, use the included shell script:
```
$ sh run-server.sh
```
You can change the name of the demo application by editing ```run-server.sh```

## Step 2: Generating Traces

To execute many times and generate a large number of traces for testing use:
```
$ for n in {1..5000}; do curl http://localhost:5000/echo; done
```
