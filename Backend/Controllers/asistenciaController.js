const admin = require("../firebaseAdmin");
const db = admin.firestore();

exports.crearListaVacia = async (req, res) => {
  const { codigo, semestre, seccion, fecha, hora } = req.body;

  try {
    const idLista = `${codigo}_${semestre}_${seccion}_${fecha}_${hora}`;
    await db.collection("asistencias").doc(idLista).set({
      codigo,
      semestre,
      seccion,
      fecha,
      hora,
      estudiantes: [],
    });
    res.status(200).json({ mensaje: "Lista de asistencia creada." });
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
};

exports.registrarAsistencia = async (req, res) => {
  const {
    codigo,
    semestre,
    seccion,
    fecha,
    hora,
    tipoDocumento,
    numeroDocumento,
    estado,
  } = req.body;

  const idLista = `${codigo}_${semestre}_${seccion}_${fecha}_${hora}`;

  try {
    const listaRef = db.collection("asistencias").doc(idLista);
    const listaDoc = await listaRef.get();

    if (!listaDoc.exists) {
      return res.status(404).json({ mensaje: "Lista no encontrada." });
    }

    const data = listaDoc.data();
    const estudiantes = data.estudiantes || [];

    const index = estudiantes.findIndex(
      (e) =>
        e.tipoDocumento === tipoDocumento &&
        e.numeroDocumento === numeroDocumento
    );

    if (index === -1) {
      estudiantes.push({ tipoDocumento, numeroDocumento, estado });
    } else {
      estudiantes[index].estado = estado;
    }

    await listaRef.update({ estudiantes });

    res.status(200).json({ mensaje: "Asistencia registrada." });
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
};

exports.modificarAsistencia = async (req, res) => {
  const {
    codigo,
    semestre,
    seccion,
    fecha,
    hora,
    tipoDocumento,
    numeroDocumento,
    nuevoEstado,
  } = req.body;

  const idLista = `${codigo}_${semestre}_${seccion}_${fecha}_${hora}`;

  try {
    const listaRef = db.collection("asistencias").doc(idLista);
    const listaDoc = await listaRef.get();

    if (!listaDoc.exists) {
      return res.status(404).json({ mensaje: "Lista no encontrada." });
    }

    const data = listaDoc.data();
    const estudiantes = data.estudiantes || [];

    const index = estudiantes.findIndex(
      (e) =>
        e.tipoDocumento === tipoDocumento &&
        e.numeroDocumento === numeroDocumento
    );

    if (index === -1) {
      return res.status(404).json({ mensaje: "Estudiante no registrado." });
    }

    estudiantes[index].estado = nuevoEstado;

    await listaRef.update({ estudiantes });

    res.status(200).json({ mensaje: "Asistencia modificada." });
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
};

exports.listarAsistencias = async (req, res) => {
  try {
    const snapshot = await db.collection("asistencias").get();
    const lista = snapshot.docs.map((doc) => ({ id: doc.id, ...doc.data() }));
    res.status(200).json(lista);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
};
