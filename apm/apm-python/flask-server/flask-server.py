from flask import Flask, make_response, request
from signalfx_tracing import auto_instrument, create_tracer, trace
import opentracing

tracer = create_tracer(service_name='SlernerTracedApp')
auto_instrument(tracer)
 
app = Flask(__name__)
  
@trace
def convert_response(message):
    print(opentracing.tracer.active_span)
    return 'You said: {}\n'.format(message)

@app.route('/echo', methods=['POST'])
def echo():
    message = request.data.decode('utf-8')
    return make_response(convert_response(message))

if __name__ == '__main__':
    app.run()
