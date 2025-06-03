const express = require("express");
const router = express.Router();
const {
  registrarEstudianteController,
  consultarEstudianteController,
  modificarEstudianteController,
  registrarEnAsignaturaController,
  consultarEstudiantesAsignaturaController
} = require("../Controllers/estudiantesController"); // corregido "controllers"

router.post("/registrar", registrarEstudianteController);
router.get("/consultar", consultarEstudianteController);
router.put("/modificar", modificarEstudianteController);
router.post("/registrar-en-asignatura", registrarEnAsignaturaController);
router.get("/consultar-asignatura", consultarEstudiantesAsignaturaController);

module.exports = router;

