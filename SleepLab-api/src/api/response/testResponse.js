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
            message = "Selamat! Pola tidurmu sangat baik. Pertahankan kebiasaan tidur yang sehat untuk kesehatan optimal dan energi positif sepanjang hari."
            suggestions = "semangat1"
        }
        else if (results.disorder_result==1) {
            disorder = "Apnea"
            message = "Kamu luar biasa dapat menghadapi sleep apnea. Ingat, setiap langkah kecil menuju tidur yang lebih baik adalah kemenangan."
            suggestions = "semangat2"
        }
        else if(results.disorder_result==2) {
            disorder = "Insomnia"
            message = "Kesabaranmu menghadapi insomnia sungguh inspiratif. Teruslah berjuang, karena setiap malam adalah kesempatan baru untuk menciptakan tidur yang damai."
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
