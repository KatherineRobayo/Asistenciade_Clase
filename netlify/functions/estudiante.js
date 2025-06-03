const express = require('express');
const { handler } = require('@netlify/functions');
const estudianteRoutes = require("../../Backend/routes/estudiantesRoutes");

const app = express();
app.use(express.json());
app.use('/.netlify/functions/estudiante', estudiantesRoutes);

exports.handler = handler (app);

