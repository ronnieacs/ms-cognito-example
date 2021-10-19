# Getting Started

### Run project

```bash
$ export AWS_REGION="us-east-1"
$ export AWS_COGNITO_USER_POOL="us-east-1_OlP8LGWhh"
$ ./mvnw spring-boot:run
```

### Get access token
```bash
$ export AWS_COGNITO_CLIENT_ID="980jmlk5nzgck01u1fshdhu1l7"
$ export AWS_COGNITO_AUTH_FLOW="USER_PASSWORD_AUTH"
$ export AWS_COGNITO_AUTH_PARAMETERS="USERNAME=admin,PASSWORD=123456"
$ aws cognito-idp initiate-auth --auth-flow $AWS_COGNITO_AUTH_FLOW --client-id $AWS_COGNITO_CLIENT_ID --auth-parameters $AWS_COGNITO_AUTH_PARAMETERS | jq -r .AuthenticationResult.AccessToken
```

### Consume API

```bash
$ curl http://localhost:8080/all -H "Accept: application/json" -H "Authorization: Bearer {token}"
$ curl http://localhost:8080/admin -H "Accept: application/json" -H "Authorization: Bearer {token}"
$ curl http://localhost:8080/no-admin -H "Accept: application/json" -H "Authorization: Bearer {token}"
```

