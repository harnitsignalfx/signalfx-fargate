Sends 1000 traces to SignalFx.

You must edit the dockerfile to update with your environment variables or set these in your orchestration system.
Make sure to replace the variables in CAPS with yours:

```
export SIGNALFX_ENDPOINT_URL="http://localhost:9080/v1/trace"
export SIGNALFX_SERVICE_NAME="YOURSERVICENAMEHERE"
export SIGNALFX_ACCESS_TOKEN="YOURTOKENHERE"
```
