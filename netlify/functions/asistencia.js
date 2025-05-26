const serverless = require("serverless-http");
const express = require("express");
const app = express();
const cors = require("cors");
const asistenciaRoutes = require("../../routes/asistenciaRoutes");

app.use(cors());
app.use(express.json());

app.use("/.netlify/functions/asistencia", asistenciaRoutes);

module.exports.handler = serverless(app);
