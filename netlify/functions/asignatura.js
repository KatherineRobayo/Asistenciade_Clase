const express = require('express');
const serverless = require('@netlify/functions');
const path = require('path');

const app = express();
app.use(express.json());

const rutasAsignatura = require(path.resolve(__dirname, '../../Backend/routes/asignaturaRoutes'));

app.use('/.netlify/functions/asignatura', rutasAsignatura);

module.exports.handler = serverless(app);
