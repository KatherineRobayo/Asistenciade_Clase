const admin = require("./firebaseAdmin");
const db = admin.firestore();

exports.registrarEstudianteController = async (req, res) => {
  const { nombre, tipoDocumento, numeroDocumento } = req.body;
  try {
    await db.collection("estudiantes").doc(`${tipoDocumento}-${numeroDocumento}`).set({
      nombre,
      tipoDocumento,
      numeroDocumento
    });
    res.json({ mensaje: "Estudiante registrado con éxito" });
  } catch (e) {
    console.error("ERROR al registrar estudiante:", e);
    res.status(500).json({ error: e.message || "Error desconocido" });
  }
};

exports.consultarEstudianteController = async (req, res) => {
  const { tipoDocumento, numeroDocumento } = req.query;
  try {
    const doc = await db.collection("estudiantes").doc(`${tipoDocumento}-${numeroDocumento}`).get();
    if (!doc.exists) {
      return res.json({ mensaje: "Estudiante no encontrado" });
    }
    res.json(doc.data());
  } catch (e) {
    console.error("ERROR al consultar estudiante:", e);
    res.status(500).json({ error: e.message || "Error desconocido" });
  }
};

exports.modificarEstudianteController = async (req, res) => {
  const { tipoDocumento, numeroDocumento, nuevoNombre } = req.body;
  try {
    const ref = db.collection("estudiantes").doc(`${tipoDocumento}-${numeroDocumento}`);
    await ref.update({ nombre: nuevoNombre });
    res.json({ mensaje: "Estudiante modificado con éxito" });
  } catch (e) {
    console.error("ERROR al modificar estudiante:", e);
    res.status(500).json({ error: e.message || "Error desconocido" });
  }
};

exports.registrarEnAsignaturaController = async (req, res) => {
  const { codigo, tipoDocumento, numeroDocumento, semestre, seccion } = req.body;
  try {
    const estudianteRef = db.collection("estudiantes").doc(`${tipoDocumento}-${numeroDocumento}`);
    const estudiante = await estudianteRef.get();
    if (!estudiante.exists) {
      return res.json({ mensaje: "Estudiante no existe" });
    }

    const nombre = estudiante.data().nombre;
    await db.collection("asignaturas")
      .doc(`${codigo}-${semestre}-${seccion}`)
      .collection("estudiantes")
      .doc(`${tipoDocumento}-${numeroDocumento}`)
      .set({ nombre });

    res.json({ mensaje: "Estudiante registrado en la asignatura" });
  } catch (e) {
    console.error("ERROR al registrar en asignatura:", e);
    res.status(500).json({ error: e.message || "Error desconocido" });
  }
};

exports.consultarEstudiantesAsignaturaController = async (req, res) => {
  const { codigo, semestre, seccion } = req.query;
  try {
    const snapshot = await db.collection("asignaturas")
      .doc(`${codigo}-${semestre}-${seccion}`)
      .collection("estudiantes")
      .get();

    const estudiantes = snapshot.docs.map(doc => doc.data().nombre);
    res.json({ estudiantes });
  } catch (e) {
    console.error("ERROR al consultar estudiantes en asignatura:", e);
    res.status(500).json({ error: e.message || "Error desconocido" });
  }
};
