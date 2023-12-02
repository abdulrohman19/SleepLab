# API
NodeJs API for Register and Login using JWT Authentication

Steps :
code . -> to open vs code

npm init / npm init -y   -> installs package.json file

npm install express -save

npm install mysql

npm install dotenv

npm install --save-dev nodemon

npm install bcrypt

npm i jsonwebtoken

create app.js file

create a folder name it : config > create a file database.js

Add this in package.json file "start" : "nodemon app.js" then npm start // this will restart server whenever you save anything

// To protect .env file from pushing it into the gitHub..
-> create a file called .gitignore and add the filenames/ folder you dont want to push it to github.

create folde api -> inside create another folder called -> users 

inside users add 3 files
> user.router.js
> user.controller.js
> user.service.js

create a folder auth > inside create a file token_validate.js
