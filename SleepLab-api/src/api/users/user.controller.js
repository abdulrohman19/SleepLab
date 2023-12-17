const { 
  create, 
  validation,
  getAll, 
  getAllById, 
  updateById, 
  deleteById, 
  login
} = require("./user.service");

const { 
  hashSync, 
  genSaltSync, 
  compareSync 
} = require("bcrypt");

const { sign } = require("jsonwebtoken");

module.exports = {
    create: async (req, res) => {
      try {
        const body = req.body;
        const email = body.email;

    //=========================validation for email================================
        const emailExists = await new Promise((resolve) => {
          validation(email, (err, results) => {
            resolve(results);
          });
        });
    
        if (emailExists) {
          return res.json({
            success: 0,
            message: "Email already exists"
          });
        }
    //=============================================================================
    
        const salt = genSaltSync(10);
        body.password = hashSync(body.password, salt);
    
        create(body, async (err, results) => {
          if (err) {
            console.log(err);
            return res.status(500).json({
              success: 0,
              message: "Database connection error"
            });
          }
          
          return res.status(200).json({
            success: 1,
            data: results
          });
        });
      } catch (error) {
        console.error(error);
        return res.status(500).json({
          success: 0,
          message: "Internal server error"
        });
      }
    },    
    getAll: (req, res) => {
        getAll((err, results) => {
          if (err) {
            console.log(err);
            return;
          }
           return res.json({
            success: 1,
            data: results
          });
        });
    },
    getAllById: (req, res) => {
        const id = req.params.id;
        getAllById(id, (err, results) => {
          if (err) {
            console.log(err);
            return;
          }
          if (!results) {
            return res.json({
              success: 0,
              message: "Record not Found"
            });
          }
          results.password = undefined;
          return res.json({
            success: 1,
            data: results
          });
        });
    },
    updateById: (req, res) => {
        const body = req.body;
        const salt = genSaltSync(10);
        body.password = hashSync(body.password, salt);
        updateById(body, (err, results) => {
          if (err) {
            console.log(err);
            return;
          }
          if (!results) {
            return res.json({
              success: 0,
              message: "Update unsuccessful"
            });
          }
          return res.json({
            success: 1,
            message: "Updated successfully"
          });
        });
    },
    deleteById: (req, res) => {
        const data = req.body;
        deleteById(data, (err, results) => {
          if (err) {
            console.log(err);
            return;
          }
          if (!results) {
            return res.json({
              success: 0,
              message: "Record Not Found"
            });
          }
          return res.json({
            success: 1,
            message: "user deleted successfully"
          });
        });
    },
    login: (req, res) => {
        const body = req.body;
        login(body.email, (err, results) => {
          if (err) {
            console.log(err);
          }
          if (!results) {
            return res.json({
              success: 0,
              data: "No Results Found"
            });
          }
          const result = compareSync(body.password, results.password);
          if (result) {
            results.password = undefined;
            const jsontoken = sign({ result: results }, process.env.JWT_KEY, {
              expiresIn: "1h"
            });
            return res.json({
              success: 1,
              message: "login successfully",
              loginResult:{
                id: results.id,
                name: results.full_name,
                token: jsontoken
              }
            });
          } else {
            return res.json({
              success: 0,
              data: "Invalid email or password"
            });
          }
        });
    }
}