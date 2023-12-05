const router = require("express").Router();
const { create, getAll, getAllById, updateById, deleteById, login} = require("./user.controller");
const { token } = require("../../auth/token_validate");

router.post("/regis", create);
router.get("/data", token, getAll);
router.get("/data/:id", token, getAllById);
router.patch("/update", token, updateById);
router.delete("/delete", token, deleteById);

router.post("/login", login);

module.exports = router;
