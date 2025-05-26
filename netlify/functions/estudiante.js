const express = require("express");
const { builder } = require("@netlify/functions");
const cors = require("cors");
const estudiantesRoutes = require("./Backend/routes/estudiantesRoutes");

const app = express();

app.use(cors());
app.use(express.json());

// Ruta base
app.use("/.netlify/functions/estudiante", estudiantesRoutes);


exports.handler = builder(app);
