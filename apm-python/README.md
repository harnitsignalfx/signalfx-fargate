# signalfx-apm2-python

Requirements: Debian Linux i.e. Ubuntu with ports 22/80/443/5000 unrestricted

This is a Hello World style exercise to demonstrate SignalFx APM2.0 instrumentation and tracing with Python using a minimal flask server example. 

This is not official product documentation. Official SignalFx documentation is here: [https://docs.signalfx.com](https://docs.signalfx.com)

### Step #1 Install SignalFx Agent 5.02 or higher

You can do this from the integrations tab in your SignalFx account

### Step #2 Update /etc/signalfx/agent.yaml configuration for tracing

Use the example in ```./etc/signaltx/agent.yaml``` and replace the variables indicated for realm, hostname, service, etc

### Step #3 Install SignalFx tracing library and boostrap instrumentation

```
sudo apt-get -y update
sudo apt install python3.7
sudo update-alternatives --install /usr/bin/python3 python3 /usr/bin/python3.7 1
sudo apt install -y python3-pip
python3 -m pip install signalfx_tracing flask
export PATH="$HOME/.local/bin:$PATH"
sfx-py-trace-bootstrap 
```

### Step #4 Run Flask Server

```
$ python3 flask-server.py
```

### Step #5 Exercise Flask Server

Open another terminal window and exercise the server. It takes 90 seconds or more for initial service registration so 10,000 or more traces are recommended:

```
for n in {1..10000}; do curl -XPOST -d'Hello, world' -H'Content-Type:text/plain' http://localhost:5000/echo; done
```

### Step #6 Traces / service will now be viewable in the APM dashboard

Additionally span IDs will print in the terminal where flask-server.py is running.
