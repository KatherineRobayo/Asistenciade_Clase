const admin = require('./firebaseAdmin');
const db = admin.firestore();

const consultarNombreDepartamento = async (req, res) => {
    try {
        const docRef = db.collection('departamento').doc('principal');
        const doc = await docRef.get();

        if (doc.exists) {
            res.status(200).json({ nombre: doc.data().nombre });
        } else {
            // Si no existe, lo crea con un nombre por defecto
            const nombrePorDefecto = 'Ingenieria de Sistemas y Computación';
            await docRef.set({ nombre: nombrePorDefecto });

            res.status(200).json({ nombre: nombrePorDefecto });
        }
    } catch (error) {
        res.status(500).json({ error: 'Error al consultar el departamento' });
    }
};

const modificarNombreDepartamento = async (req, res) => {
    const { nombre } = req.body;
    if (!nombre) {
        return res.status(400).json({ error: 'El nombre es requerido' });
    }

    try {
        await db.collection('departamento').doc('principal').set({ nombre });
        res.status(200).json({ mensaje: 'Nombre del departamento modificado correctamente' });
    } catch (error) {
        res.status(500).json({ error: 'Error al modificar el departamento' });
    }
};

module.exports = {
    consultarNombreDepartamento,
    modificarNombreDepartamento
};
