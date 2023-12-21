const pool = require('../../config/database')

module.exports ={
    newInput: (data, callBack) => {
        pool.query(
          `insert into user_input(id, job, sleep_duration, activity_level, bmi, timeStamp) 
                    values(?,?,?,?,?,?)`,
          [
            data.id,
            data.job,
            data.sleep_duration,
            data.activity_level,
            data.bmi,
            new Date().toDateString()
          ],
          (error, results, fields) => {
            if (error) {
              callBack(error);
            }
            return callBack(null, results);
          }
        );
    },
    getUserInput: callBack => {
        pool.query(
          `select 
          registration.id,
          registration.full_name, 
          user_input.sleep_duration, 
          user_input.activity_level,  
          user_result.disorder_result,
          user_input.bmi,
          user_input.timeStamp
          from registration 
          join user_input on registration.id = user_input.id 
          join user_result on user_input.inputId = user_result.inputId`, 
          [],
          (error, results, fields) => {
            if (error) {
              callBack(error);
            }
            return callBack(null, results);
          }
        );
    },
    getInputById: (id, callBack) => {
        pool.query(
          `select 
          registration.full_name, 
          user_input.sleep_duration, 
          user_input.activity_level,  
          user_result.disorder_result,
          user_input.bmi,
          user_input.timeStamp
          from registration 
          join user_input on registration.id = user_input.id 
          join user_result on user_input.inputId = user_result.inputId 
          where user_input.id = ?`,
          [id],
          (error, results, fields) => {
            if (error) {
              callBack(error);
            }
            return callBack(null, results);
          }
        );
    },
    updateInputById: (data, callBack) => {
        pool.query(
          `update user_input set job=?, sleep_duration=?, activity_level=?, bmi=? where inputId = ?`,
          [
            data.job,
            data.sleep_duration,
            data.activity_level,
            data.bmi,
            data.inputId
          ],
          (error, results, fields) => {
            if (error) {
              callBack(error);
            }
            return callBack(null, results);
          }
        );
    },
    deleteInputById: (data, callBack) => {
        pool.query(
          `delete from user_input where inputId = ?`,
          [data.inputId],
          (error, results, fields) => {
            if (error) {
              callBack(error);
            }
            return callBack(null, results);
          }
        );
    },


    //separator for service methods-----------------------------------------------------------------

    addResults: (data, callBack) => {
        pool.query(
          `insert into user_result(inputId, disorder_result, bmi_category) 
                    values(?,?,?)`,
          [
            data.inputId,
            data.disorder_result,
            data.bmi_category
          ],
          (error, results, fields) => {
            if (error) {
              callBack(error);
            }
            return callBack(null, results);
          }
        );
    },
    getDataResults: callBack => {
        pool.query(
          `select inputId, disorder_result, bmi_category from user_result`,
          [],
          (error, results, fields) => {
            if (error) {
              callBack(error);
            }
            return callBack(null, results);
          }
        );
    },
    getResultById: (id, callBack) => {
        pool.query(
          `select user_input.id, user_result.disorder_result from user_input inner join user_result on user_input.inputId = user_result.inputId where user_input.id = ?`,
          [id],
          (error, results, fields) => {
            if (error) {
              callBack(error);
            }
            return callBack(null, results[0]);
          }
        );
    },
    updateResultById: (data, callBack) => {
        pool.query(
          `update user_result set disorder_result=?, bmi_category=? where id = ?`,
          [
            data.disorder_result,
            data.bmi_category,
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
    deleteResultById: (data, callBack) => {
        pool.query(
          `delete from user_result where id = ?`,
          [data.id],
          (error, results, fields) => {
            if (error) {
              callBack(error);
            }
            return callBack(null, results);
          }
        );
    }
}