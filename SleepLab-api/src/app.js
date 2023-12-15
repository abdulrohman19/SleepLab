require("dotenv").config();
const express = require("express");
const app = express();
const userRouter = require("./routes");

app.use(express.urlencoded({ extended: true }));
app.use(express.json());
app.use("/api/v1", userRouter);

app.get("/api", (req, res) => {
    res.json({
        success: 1,
        message: "This is rest Api"
    });
});

app.listen(process.env.APP_PORT, () => {
    console.log("Server up and running on PORT : ", process.env.APP_PORT);
})  