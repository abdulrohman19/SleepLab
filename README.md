<h1> AUTH API ENDPOINTS </h1>
Lakukan testing pada Postman dengan method yang sesuai sebagai berikut :


### Registration (POST)
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
Setelah Login, <strong>Bearer Token</strong> akan muncul dan dapat digunakan untuk melakukan testing pada beberapa method dibawah ini.


### Get All Data (GET)
`https://test-capstonee.et.r.appspot.com/api/users/data`

### Get Data by ID (GET)
`https://test-capstonee.et.r.appspot.com/api/users/data/:id`

### Update by ID (PATCH)
`https://test-capstonee.et.r.appspot.com/api/users/update` <br>
Query for update :
```
{
    "fullName":"",
    "age":"",
    "gender":"",
    "email":"",
    "password":"",
    "id":""
}
```
Tidak harus menggunakan semua query yg ada diatas, cukup yang perlu di Update saja misalnya "fullName", maka query lain dapat dihapus menyisakan fullName dan id user yang akan di Update

### Delete by ID (DELETE)
`https://test-capstonee.et.r.appspot.com/api/users/delete` <br>
Query for delete :
```
{
    "id":""
}
```
| METHOD | FUNCTION | LINK | QUERY |
|--------|----------|------|-------|
|        |          |      |       |
