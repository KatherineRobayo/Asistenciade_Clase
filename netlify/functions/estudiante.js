

require("dotenv").config(); // debe estar al inicio
const express = require("express");
const serverless = require("@netlify/functions");
const estudiantesRoutes = require("../../Backend/routes/estudiantesRoutes");

const app = express();
app.use(express.json());
app.use("/.netlify/functions/estudiante", estudiantesRoutes);

module.exports.handler = serverless.handler(app);

