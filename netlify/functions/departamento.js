const express = require("express");
const serverless = require("@netlify/functions");
const cors = require("cors");
const app = express();
const router = express.Router();

const rutas = require("../../Backend/routes/departamentoRoutes");

app.use(cors());
app.use(express.json());
app.use("/.netlify/functions/departamento", rutas);

// Middleware de error (agrega esto al final)
app.use((err, req, res, next) => {
  console.error("Error en la función:", err);
  res.status(500).json({ error: err.message || "Error interno del servidor" });
});

module.exports.handler = serverless.handler(app);
