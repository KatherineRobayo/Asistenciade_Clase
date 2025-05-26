const admin = require("../firebaseAdmin");
const db = admin.firestore();

const getDocId = (codigo, semestre, seccion) => `${codigo}_${semestre}_${seccion}`;

exports.adicionarAsignatura = async (req, res) => {
    const { nombre, codigo, creditos, seccion, semestre } = req.body;
    const docId = getDocId(codigo, semestre, seccion);

    try {
        await db.collection("asignaturas").doc(docId).set({
            nombre,
            codigo,
            creditos,
            seccion,
            semestre
        });
        res.status(200).json({ mensaje: "Asignatura registrada correctamente" });
    } catch (error) {
        res.status(500).json({ error: "Error al registrar asignatura" });
    }
};

exports.consultarAsignatura = async (req, res) => {
    const { codigo, semestre, seccion } = req.body;
    const docId = getDocId(codigo, semestre, seccion);

    try {
        const doc = await db.collection("asignaturas").doc(docId).get();
        if (!doc.exists) {
            return res.status(404).json({ error: "Asignatura no encontrada" });
        }
        res.status(200).json(doc.data());
    } catch (error) {
        res.status(500).json({ error: "Error al consultar asignatura" });
    }
};

exports.modificarAsignatura = async (req, res) => {
    const { codigo, semestre, seccion, nuevoNombre, nuevosCreditos } = req.body;
    const docId = getDocId(codigo, semestre, seccion);

    try {
        await db.collection("asignaturas").doc(docId).update({
            nombre: nuevoNombre,
            creditos: nuevosCreditos
        });
        res.status(200).json({ mensaje: "Asignatura modificada correctamente" });
    } catch (error) {
        res.status(500).json({ error: "Error al modificar asignatura" });
    }
};
