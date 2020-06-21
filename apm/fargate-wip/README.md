This repo demonstrates a single task example of Splunk SignalFx APM in an ECS Fargate environment.
The single task spins up two containers:
#1 SignalFx-Agent
#2 TraceGenerator

The agent is a standard deployment of a SignalFx Fargate container as documented here:
https://github.com/signalfx/signalfx-agent/blob/master/deployments/fargate/example-fargate-task.json

The agent.yaml file is based on the Fargate Example here:
https://github.com/signalfx/signalfx-agent/blob/master/deployments/fargate/agent.yaml

However it has been slightly customized with instructions here:
https://docs.signalfx.com/en/latest/apm/apm-getting-started/apm-smart-agent.html

The result is this file here- to use this you must change the realm of the trace endpoint url:
https://github.com/slernersplunk/agent/blob/master/fargate/agent.yaml

To deploy this example, you must have a Fargate ECS environment ready to go with VPC, task roles for logs, etc..

Everything to test this example follows the ECS tutorial documentation here:
https://docs.aws.amazon.com/AmazonECS/latest/developerguide/ECS_AWSCLI_Fargate.html

And log environment here:
https://docs.aws.amazon.com/AmazonECS/latest/developerguide/using_cloudwatch_logs.html

Once this is done, you can deploy with the following commands- change the variables in caps to suit your environment.
```
aws ecs register-task-definition --cli-input-json file://tgsfx.json
```
`aws ecs create-service --cluster test-cluster --service-name signalfx-demo --task-definition signalfx-demo:1 \`
`--desired-count 1 --launch-type "FARGATE" \`
`--network-configuration "awsvpcConfiguration={subnets=[subnet-YOURSUBNETIHERE],securityGroups=[sg-YOURSECURITYGROUPIDHERE],assignPublicIp=ENABLED}"`

Note that the task definition will increment each time you try it- from 1 to 2 etc... 
To check which version is current use:

`aws ecs list-task-definitions`

The **commands.md** file offers helpful commands for ECS Fargate management for the AWS CLI.
