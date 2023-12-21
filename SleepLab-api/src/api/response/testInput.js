const {
    newInput,
    getUserInput,
    getInputById,
    updateInputById,
    deleteInputById,
    addResults
  } = require("./testService");

  const {default: axios} = require("axios")

module.exports={
    newInput: async (req, res) =>{
        const body = req.body;
        const id = req.params.id;
        body.id = id;
        newInput(body, async (err, results) => {
          if (err) {
            console.log(err);
            return res.status(500).json({
              success: 0,
              message: "Database connection error"
            });
          }
          try {
            const { data: apiResponse } = await axios.post(
                "http://34.101.59.226:5000/predict",
                {
                  sleep_duration: body.sleep_duration,
                  physical_activity_level: body.activity_level,
                  bmi_category: body.bmi,
                }
              );
              console.log(apiResponse.prediction);
              addResults({
                inputId : results.insertId,
                disorder_result: apiResponse.prediction,
                bmi_category: body.bmi
            }, (err, results) => {
                console.log(results);
            });
          return res.status(200).json({
            success: 1,
            data: results
          });
        }
        catch(error){
          console.log(error);
          return res.status(500).json({
            success: 0,
            message: "Error processing prediction or saving results to the database"
        });
        }
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
                  disorder = 'None'
              }
              else if(result.disorder_result === 1){
                  disorder = 'Sleep Apnea'
              }
              else if(result.disorder_result === 2){
                  disorder = 'Insomnia'
              }

              let bmi_result = ''
              if(result.bmi === 0){
                  bmi_result = 'Underweight'
              }
              else if(result.bmi === 1){
                  bmi_result = 'Normal'
              }
              else if(result.bmi === 2){
                  bmi_result = 'Overweight'
              }
              const {disorder_result,bmi, ...result_fix} = result
              response.push(
                  {
                      ...result_fix,
                      bmi_result: bmi_result,
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
                  disorder = 'None'
              }
              else if(result.disorder_result === 1){
                  disorder = 'Sleep Apnea'
              }
              else if(result.disorder_result === 2){
                  disorder = 'Insomnia'
              }

              let bmi_result = ''
              if(result.bmi === 0){
                  bmi_result = 'Underweight'
              }
              else if(result.bmi === 1){
                  bmi_result = 'Normal'
              }
              else if(result.bmi === 2){
                  bmi_result = 'Overweight'
              }
              const {disorder_result,bmi, ...result_fix} = result
              response.push(
                  {
                      ...result_fix,
                      bmi_result: bmi_result,
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