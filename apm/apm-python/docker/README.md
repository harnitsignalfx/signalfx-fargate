to build docker image:
```docker build -t apmpy .```

run flask server container locally with port 5000 exposed:
```docker run --name apm-py -id -p 5000:5000 apmpy python3 /usr/src/signalfx/apm/apm-python/flask-server.py```
