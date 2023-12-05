const mysql = require("mysql2");

const pool = mysql.createConnection({
    port: process.env.APP_PORT,
    socketPath : process.env.DB_SOCKET_PATH,
    host : process.env.DB_HOST,
    user : process.env.DB_USER,
    password : process.env.DB_PASS, 
    database : process.env.MYSQL_DB
});


module.exports = pool;