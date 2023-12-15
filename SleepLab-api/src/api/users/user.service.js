const pool = require("../../config/database");
const {nanoid} = require("nanoid");

module.exports = {
    create: (data, callBack) => {
      const id = nanoid(9);
        pool.query(
          `insert into registration(id, full_name, age, gender, email, password) 
                    values(?,?,?,?,?,?)`,
          [
            id,
            data.fullName,
            data.age,
            data.gender,
            data.email,
            data.password
          ],
          (error, results, fields) => {
            if (error) {
              callBack(error);
            }
            return callBack(null, results);
          }
        );
    },
    getAll: callBack => {
        pool.query(
          `select id,full_name,age,gender,email from registration`,
          [],
          (error, results, fields) => {
            if (error) {
              callBack(error);
            }
            return callBack(null, results);
          }
        );
    },
    getAllById: (id, callBack) => {
        pool.query(
          `select id,full_name,age,gender,email from registration where id = ?`,
          [id],
          (error, results, fields) => {
            if (error) {
              callBack(error);
            }
            return callBack(null, results[0]);
          }
        );
    },
    updateById: (data, callBack) => {
        pool.query(
          `update registration set full_name=?, age=?, gender=?, email=?, password=? where id = ?`,
          [
            data.fullName,
            data.age,
            data.gender,
            data.email,
            data.password,
            data.id
          ],
          (error, results, fields) => {
            if (error) {
              callBack(error);
            }
            return callBack(null, results);
          }
        );
    },
    deleteById: (data, callBack) => {
        pool.query(
          `delete from registration where id = ?`,
          [data.id],
          (error, results, fields) => {
            if (error) {
              callBack(error);
            }
            return callBack(null, results);
          }
        );
    },
    login: (email, callBack) => {
      pool.query(
        `select * from registration where email = ?`,
        [email],
        (error, results, fields) => {
          if (error) {
            callBack(error);
          }
          return callBack(null, results[0]);
        }
      );
  },
}