# signalfx-node-tracing

Requirements: Debian Linux i.e. Ubuntu with ports 22/80/443/5000 unrestricted

This is a Hello World style exercise to demonstrate tracing with Node using minimal Express framework.
### Step 1

```
$ sudo apt-get install -y nodejs npm
$ npm init
$ npm install express signalfx-tracing
```

### Step 2

Create ```app.js```

```
const tracer = require('signalfx-tracing').init();

const express = require('express')
const app = express()
const port = 3000


app.get('/', (req, res) => {
  const span = tracer.scope().active()
  span.setTag('requestHeader', req.header('x-my-important-header'))
  res.send('Hello World!')
})

app.listen(port, () => console.log(`Example app listening on port ${port}!`))
```

### Step 3

Run the app: ```node app.js```

### Step 4

In another window, exercise the Express service:

```for n in {1..50000}; do curl http://localhost:3000; done```
