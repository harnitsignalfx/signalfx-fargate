import time
import requests
from signalfx_tracing import auto_instrument, create_tracer, trace
import opentracing
from opentracing.ext import tags

tracer = create_tracer()
auto_instrument(tracer)

@trace
def pythonrequests():
    try:
        print(opentracing.tracer.active_span)
        with opentracing.tracer.active_span as span:
            span.set_tag(tags.SPAN_KIND, tags.SPAN_KIND_RPC_SERVER)
        requests.get('http://localhost')
    except requests.exceptions.RequestException as err:
        print(err)
for x in range (1,1000):
    pythonrequests()
    time.sleep(1)
