const express = require("express");
const router = express.Router();
const asignaturaCtrl = require("../Controllers/asignaturasController");

router.post("/adicionar", asignaturaCtrl.adicionarAsignatura);
router.post("/consultar", asignaturaCtrl.consultarAsignatura);
router.post("/modificar", asignaturaCtrl.modificarAsignatura);

module.exports = router;
