<h1> API ENDPOINTS </h1>
Lakukan testing pada Postman dengan method yang sesuai sebagai berikut : <br><br>

| METHOD | FUNCTION | LINK | QUERY |
|--------|----------|------|-------|
|POST       |Registration                     |`https://capstone-sleeplab.et.r.appspot.com/api/v1/regis`|<pre>{<br>"fullName":"",<br>"age":"",<br>"gender":"",<br>"email":"",<br>"password":""<br>}<pre>|
|GET        |Get All Data User                |`https://capstone-sleeplab.et.r.appspot.com/api/v1/user`||
|GET        |Get All Data User by ID          |`https://capstone-sleeplab.et.r.appspot.com/api/v1/user/:id`      ||
|PATCH        |Update Data User by ID          |`https://capstone-sleeplab.et.r.appspot.com/api/v1/user/update`      |<pre>{<br>"fullName":"",<br>"age":"",<br>"gender":"",<br>"email":"",<br>"password":"",<br>"id":""<br>}<pre>|
|DELETE        |Delete Data User by ID          |`https://capstone-sleeplab.et.r.appspot.com/api/v1/user/delete`      |<pre>{<br>"id":""<br>}<pre>|
|POST        |Login          |`https://capstone-sleeplab.et.r.appspot.com/api/v1/login`      |<pre>{<br>"email":"",<br>"password":""<br>}<pre>|
|POST        |Input Data          |`https://capstone-sleeplab.et.r.appspot.com/api/v1/form/:id`      |<pre>{<br>"job":"",<br>"sleep_duration":"",<br>"activity_level":"",<br>"height":"",<br>"weight":""<br>}<pre>|
|GET        |Get User Input          |`https://capstone-sleeplab.et.r.appspot.com/api/v1/input`      ||
|GET        |Get User Input by ID          |`https://capstone-sleeplab.et.r.appspot.com/api/v1/input/:id`      ||
|PATCH        |Update User Input by ID          |`https://capstone-sleeplab.et.r.appspot.com/api/v1/input/update`      ||
|POST        |Delete User Input          |`https://capstone-sleeplab.et.r.appspot.com/api/v1/input/delete`      ||
|GET        |Get Result by ID          |`https://capstone-sleeplab.et.r.appspot.com/api/v1/result/:id`      ||
