const express = require('express');
const serverless = require('@netlify/functions');
const path = require('path');

const app = express();
app.use(express.json());

const rutasDepartamento = require(path.resolve(__dirname, '../../Backend/routes/departamentoRoutes'));

app.use('/.netlify/functions/departamento', rutasDepartamento);

module.exports.handler = serverless(app);
