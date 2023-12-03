const router = require("express").Router();
const { create, getAll, getAllById, updateById, deleteById, login} = require("./user.controller");
const { token } = require("../../auth/token_validate");

router.post("/", create);
router.get("/", token, getAll);
router.get("/:id", token, getAllById);
router.patch("/", token, updateById);
router.delete("/", token, deleteById);

router.post("/login", login);

module.exports = router;
