require("dotenv").config(); // debe estar al inicio
const express = require("express");
const serverless = require("@netlify/functions");
const estudianteRoutes = require("../../Backend/routes/estudiantesRoutes"); // <- debe ser "../../routes", NO "controllers"

const app = express();
app.use(express.json());
app.use("/.netlify/functions/estudiante", estudiantesRoutes);

module.exports.handler = serverless.handler(app);


