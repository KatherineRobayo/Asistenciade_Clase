const express = require('express');
const router = express.Router();
const {
    consultarNombreDepartamento,
    modificarNombreDepartamento
} = require('../controllers/departamentoController');

router.get('/consultar', consultarNombreDepartamento);
router.post('/modificar', modificarNombreDepartamento);

module.exports = router;
