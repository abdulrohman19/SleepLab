const router = require("express").Router();
const { 
    create, 
    getAll, 
    getAllById, 
    updateById, 
    deleteById, 
    login
} = require("./api/users/user.controller");

const {
    newInput,
    getUserInput,
    getInputById,
    updateInputById,
    deleteInputById
} = require("./api/response/testInput");

const{
    getResultById
} = require("./api/response/testResponse");

const { token } = require("./auth/token_validate");

//login regis
router.post("/regis", create);
router.get("/user", token, getAll);
router.get("/user/:id", token, getAllById);
router.patch("/user/update", token, updateById);
router.delete("/user/delete", token, deleteById);
router.post("/login", login);

//user input
router.post("/form/:id", newInput);
router.get("/input", getUserInput);
router.get("/input/:id", getInputById);
router.patch("/input/update", updateInputById);
router.post("/input/delete", deleteInputById);

//test result
router.get("/result/:id", getResultById);

module.exports = router;
