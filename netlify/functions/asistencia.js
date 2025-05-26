const express = require('express');
const serverless = require('@netlify/functions');
const path = require('path');

const app = express();
app.use(express.json());

const rutasAsistencia = require(path.resolve(__dirname, '../../Backend/routes/asistenciaRoutes'));

app.use('/.netlify/functions/asistencia', rutasAsistencia);

module.exports.handler = serverless(app);
