### User

Use following users:

------------------------------------
username | password     | role
---------|--------------|-----------
nmquyet  | random_token | ROLE_USER
longnc   | random_token | ROLE_ADMIN

### Resource Owner Password Grant

#### Get Access Token 

```sh
curl -X "POST" "http://localhost:8080/oauth/token" \
    -H "Authorization: Basic dHJ1c3RlZDoqKioqKiBIaWRkZW4gY3JlZGVudGlhbHMgKioqKio=" \
    -H "Content-Type: application/x-www-form-urlencoded; charset=utf-8" \
    --data-urlencode "grant_type=password" \
    --data-urlencode "username=nmquyet" \
    --data-urlencode "password=random_token"
```

#### Access secured resource

```sh
curl -X "GET" "http://localhost:8081/secured/user" \
    -H "Authorization: Bearer <access_token>"
```

```sh
curl -X "GET" "http://localhost:8081/secured/admin" \
    -H "Authorization: Bearer <access_token>"
```
