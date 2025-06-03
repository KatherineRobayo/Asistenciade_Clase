const express = require('express');
const router = express.Router();
const {
    consultarNombreDepartamento,
    modificarNombreDepartamento
} = require('../Controllers/departamentoController');

router.get('/consultar', consultarNombreDepartamento);
router.post('/modificar', modificarNombreDepartamento);

module.exports = router;
