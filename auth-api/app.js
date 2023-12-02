require("dotenv").config();
const express = require("express");
const app = express();
const userRouter = require("./api/users/user.router");

app.use(express.json()); // converts json to javascript object
app.use("/api/users", userRouter);

app.get("/api", (req, res) => {
    res.json({
        success: 1,
        message: "This is rest Api"
    });
});

app.listen(process.env.APP_PORT, () => {
    console.log("Server up and running on PORT : ", process.env.APP_PORT)
})  