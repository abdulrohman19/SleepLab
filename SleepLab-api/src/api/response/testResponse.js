const {
    getResultById
} = require("./testService");

module.exports = {
    getResultById: (req, res) => {
        const id = req.params.id;
        getResultById(id, (err, results) => {
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
        let message = ""
        let suggestions = ""
        let disorder = ""
        if (results.disorder_result==0) {
            disorder = "None"
            message = "Record1"
            suggestions = "semangat1"
        }
        else if (results.disorder_result==1) {
            disorder = "Apnea"
            message = "Record2"
            suggestions = "semangat2"
        }
        else if(results.disorder_result==2) {
            disorder = "Insomnia"
            message = "Record3"
            suggestions= "semangat3"
        }
          return res.json({
            success: 1,
            data: {
                results: disorder,
                message: message,
                suggestions: suggestions
            }
          });
        });

    }
}
