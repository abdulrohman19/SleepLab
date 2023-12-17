const {
    newInput,
    getUserInput,
    getInputById,
    updateInputById,
    deleteInputById
  } = require("./testService");

module.exports={
    newInput: (req, res) =>{
        const body = req.body;
        const id = req.params.id;
        body.id = id;
        newInput(body, (err, results) => {
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
    },

    getUserInput: (req, res) =>{
        getUserInput((err, results) => {
          if (err) {
            console.log(err);
            return;
          }
          let response = []
          results.map((result) => {
              let disorder = ''
              if(result.disorder_result === 0){
                  disorder = 'Tidak ada gangguan'
              }
              else if(result.disorder_result === 1){
                  disorder = 'Gangguan'
              }
              else if(result.disorder_result === 2){
                  disorder = 'Gangguan'
              }
              const {disorder_result, ...result_fix} = result
              response.push(
                  {
                      ...result_fix,
                      disorder: disorder,
                  }
              )
          })

          return res.json({
              success: 1,
              data: response
          })
        });
    },

    getInputById: (req, res) =>{
        const id = req.params.id;
        getInputById(id, (err, results) => {
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
          let response = []
          results.map((result) => {
              let disorder = ''
              if(result.disorder_result === 0){
                  disorder = 'Tidak ada gangguan'
              }
              else if(result.disorder_result === 1){
                  disorder = 'Gangguan'
              }
              else if(result.disorder_result === 2){
                  disorder = 'Gangguan'
              }
              const {disorder_result, ...result_fix} = result
              response.push(
                  {
                      ...result_fix,
                      disorder: disorder,
                  }
              )
          })
          return res.json({
            success: 1,
            data: response
          });
        });
    },

    updateInputById: (req, res)=>{
        const body = req.body;
        updateInputById(body, (err, results) => {
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

    deleteInputById: (req, res)=>{
        const data = req.body;
        deleteInputById(data, (err, results) => {
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
            message: "Data Deleted Successfully"
          });
        });
    }
}