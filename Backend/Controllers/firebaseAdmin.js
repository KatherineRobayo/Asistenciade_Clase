const admin = require('firebase-admin');
const dotenv = require('dotenv');
const path = require('path');

// Cargar las variables del archivo .env
dotenv.config();

// Obtener la ruta absoluta del archivo de credenciales
const serviceAccountPath = process.env.GOOGLE_APPLICATION_CREDENTIALS;

// Inicializar Firebase Admin con la ruta
admin.initializeApp({
  credential: admin.credential.cert(require(serviceAccountPath))
});

module.exports = admin;
