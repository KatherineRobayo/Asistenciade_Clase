const serverless = require("serverless-http");
const express = require("express");
const cors = require("cors");
const app = express();

const asignaturasRoutes = require("./routes/asignaturasRoutes");

app.use(cors());
app.use(express.json());

app.use("/.netlify/functions/asignaturas", asignaturasRoutes);

module.exports.handler = serverless(app);
