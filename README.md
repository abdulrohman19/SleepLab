<h1> AUTH API ENDPOINTS </h1>
Lakukan testing pada Postman dengan method yang sesuai


### Regis (POST)
`https://test-capstonee.et.r.appspot.com/api/users/regis` <br>
Query for regis :
```
{
    "fullName":"",
    "age":"",
    "gender":"",
    "email":"",
    "password":""
}
```


### Login (POST)
`https://test-capstonee.et.r.appspot.com/api/users/login` <br>
Query for login :
```
{
    "email":"",
    "password":""
}
```
Setelah Login, <strong>Bearer Token</strong> akan muncul dan dapat digunakan untuk melakukan testing pada method dibawah ini


### Get Data (GET)
`https://test-capstonee.et.r.appspot.com/api/users/data`

### Get Data by ID (GET)
`https://test-capstonee.et.r.appspot.com/api/users/data/:id`

### Update by ID (PATCH)
`https://test-capstonee.et.r.appspot.com/api/users/update`

### Delete by ID (DELETE)
`https://test-capstonee.et.r.appspot.com/api/users/delete` 
