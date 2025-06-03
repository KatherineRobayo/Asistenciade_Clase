const express = require("express");
const router = express.Router();
const {
  registrarEstudianteController,
  consultarEstudianteController,
  modificarEstudianteController,
  registrarEnAsignaturaController,
  consultarEstudiantesAsignaturaController
} = require("../controllers/estudiantesController");

// Ruta para registrar estudiante
router.post("/registrar", registrarEstudianteController);

// Ruta para consultar estudiante por tipo y número de documento
router.get("/consultar", consultarEstudianteController);

// Ruta para modificar nombre del estudiante
router.put("/modificar", modificarEstudianteController);

// Ruta para registrar estudiante en asignatura
router.post("/registrar-en-asignatura", registrarEnAsignaturaController);

// Ruta para consultar todos los estudiantes registrados en una asignatura
router.get("/consultar-asignatura", consultarEstudiantesAsignaturaController);

module.exports = router;
