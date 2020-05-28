# signalfx-node-tracing

This is a Hello World style exercise to demonstrate tracing with Node using minimal Express framework.

### Step 1

```
$ sudo apt-get install -y nodejs npm
$ npm init
$ npm install express signalfx-tracing
```

### Step 2

Run the app: ```node app.js```

### Step 3

In another window, exercise the Express service:

```for n in {1..50000}; do curl http://localhost:3000; done```
