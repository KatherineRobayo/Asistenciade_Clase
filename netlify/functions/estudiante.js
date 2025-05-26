const express = require('express');
const serverless = require('@netlify/functions');
const path = require('path');

const app = express();
app.use(express.json());

const rutasEstudiante = require(path.resolve(__dirname, '../../Backend/routes/estudiantesRoutes'));

app.use('/.netlify/functions/estudiante', rutasEstudiante);

module.exports.handler = serverless(app);
