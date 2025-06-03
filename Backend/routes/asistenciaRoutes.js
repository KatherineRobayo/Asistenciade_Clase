const express = require("express");
const router = express.Router();
const {
  crearListaVacia,
  registrarAsistencia,
  modificarAsistencia,
  listarAsistencias,
} = require("../Controllers/asistenciaController");

router.post("/crear-lista", crearListaVacia);
router.post("/registrar", registrarAsistencia);
router.put("/modificar", modificarAsistencia);
router.get("/listar", listarAsistencias);

module.exports = router;
