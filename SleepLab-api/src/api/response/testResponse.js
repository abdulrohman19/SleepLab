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
            suggestions = "Keren, coba pertahankan kualitas tidurmu dengan saran berikut yuk!\n - Pastikan untuk menetapkan jadwal tidur yang konsisten, termasuk waktu bangun dan tidur, guna menciptakan rutinitas yang baik.\n - Upayakan agar kamar tidur Anda nyaman, sejuk, dan gelap, serta pilih perlengkapan tidur yang mendukung kenyamanan.\n - Perhatikan untuk membatasi konsumsi kafein dan nikotin, terutama menjelang tidur, dan hindari alkohol sebelum waktu tidur.\n - Lakukan olahraga secara teratur, tetapi hindari aktivitas fisik yang terlalu intens menjelang waktu tidur.\n - Hindari penggunaan perangkat elektronik sebelum tidur, dan pilih kegiatan yang lebih menenangkan untuk membantu relaksasi.\n - Terapkan teknik relaksasi seperti meditasi atau pernapasan dalam untuk membantu meredakan stres dan mempersiapkan tubuh untuk tidur.\n - Jaga pola makan yang sehat, hindari makan berlebihan sebelum tidur, dan pilih makanan ringan yang mendukung tidur nyenyak.\n - Temukan cara efektif untuk mengelola stres, baik melalui kegiatan yang menyenangkan, olahraga, atau praktik meditasi.\n - Jika mengalami gejala gangguan tidur, coba lakukan cek kembali di SleepLab."
        }
        else if (results.disorder_result==1) {
            disorder = "Sleep Apnea"
            message = "Kamu luar biasa dapat menghadapi sleep apnea. Ingat, setiap langkah kecil menuju tidur yang lebih baik adalah kemenangan."
            suggestions = "Coba terapkan saran dari Dokter Spesialis Kedokteran Jiwa berikut ya! \n - Terapkan teknik relaksasi pernafasan untuk menenangkan tubuh dan pikiran sebelum tidur.\n - Ciptakan suasana kamar yang nyaman dengan pencahayaan yang lembut dan suhu yang sesuai.\n - Rutin melakukan olahraga sebagai bagian dari kebiasaan tidur yang sehat.\n - Hindari konsumsi alkohol, nikotin, dan kafein yang dapat mengganggu pola tidur.\n - Pilih konsumsi makanan sehat untuk mendukung tidur yang baik.\n - Mempertahankan pemikiran positif untuk mengurangi stres dan kecemasan sebelum tidur.\n\n Selain itu, coba terapkan saran dari jurnal kesehatan ini jika saran dari dokter kurang membantu ya!\n - Hindari konsumsi alkohol dan sedatif dekat waktu tidur untuk mendukung kualitas tidur yang optimal.\n - Disarankan untuk mengutamakan pengurangan berat badan sebagai langkah kunci untuk mengurangi deposit lemak di sekitar leher, yang dapat mengurangi risiko kolaps pada saluran napas.\n - Pertimbangkan untuk tidur dalam posisi yang tidak telentang guna mengurangi gejala sleep apnea.\n - Nasal CPAP (Continuous Positive Airway Pressure) direkomendasikan sebagai terapi utama yang sangat efektif dalam penanganan sleep apnea.\n - Pertimbangkan penggunaan oral appliances sebagai alternatif terapi yang dapat membantu mengatasi gejala sleep apnea.\n - Operasi saluran udara atas dapat menjadi pilihan sekunder, terutama bagi pasien yang tidak merespons terapi lainnya.\n - Mandibular surgery, dengan tingkat keberhasilan yang tinggi, bisa menjadi opsi terapi yang efektif dan layak dipertimbangkan."
        }
        else if(results.disorder_result==2) {
            disorder = "Insomnia"
            message = "Kesabaranmu menghadapi insomnia sungguh inspiratif. Teruslah berjuang, karena setiap malam adalah kesempatan baru untuk menciptakan tidur yang damai."
            suggestions= "Coba terapkan saran dari Dokter Spesialis Kedokteran Jiwa berikut ya!\n - Terapkan teknik relaksasi pernafasan untuk menenangkan tubuh dan pikiran sebelum tidur.\n - Ciptakan suasana kamar yang nyaman dengan pencahayaan yang lembut dan suhu yang sesuai.\n - Rutin melakukan olahraga sebagai bagian dari kebiasaan tidur yang sehat.\n - Hindari konsumsi alkohol, nikotin, dan kafein yang dapat mengganggu pola tidur.\n - Pilih konsumsi makanan sehat untuk mendukung tidur yang baik.\n - Mempertahankan pemikiran positif untuk mengurangi stres dan kecemasan sebelum tidur.\n\n Selain itu, coba pertimbangkan menerapkan saran dari jurnal kesehatan jika saran dari dokter kurang membantu ya!\n - Pertimbangkan merendam kaki dalam air hangat dengan suhu 30-39 derajat Celcius sebagai cara alami untuk mencapai relaksasi sebelum tidur.\n - Terapi akupuntur dapat menjadi opsi tambahan untuk meningkatkan kualitas tidur.\n - Lakukan olahraga dengan intensitas sedang, namun hindari melakukannya sesaat sebelum tidur.\n - Hindari menghabiskan waktu di tempat tidur jika tidak ada kegiatan yang berhubungan dengan tidur.\n - Kurangi paparan cahaya terang, termasuk televisi, untuk membantu tubuh bersiap untuk tidur.\n - Minimalkan asupan makan, kafein, tembakau, dan alkohol di malam hari untuk menghindari gangguan tidur.\n - Atur waktu bangun secara konsisten setiap hari untuk membentuk rutinitas tidur yang stabil.\n - Pertahankan durasi tidur siang minimal agar tidak memengaruhi tidur malam."
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
