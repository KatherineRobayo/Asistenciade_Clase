const admin = require("../../Backend/Controllers/firebaseAdmin");

exports.handler = async function(event, context) {
    const firestore = admin.firestore();

    try {
        if (event.httpMethod === 'GET') {
            const doc = await firestore.collection('departamento').doc('info').get();
            const nombre = doc.exists ? doc.data().nombre : "No encontrado";
            return {
                statusCode: 200,
                body: JSON.stringify({ nombre }),
            };
        }

        if (event.httpMethod === 'POST') {
            const body = JSON.parse(event.body);
            const nuevoNombre = body.nombre;
            await firestore.collection('departamento').doc('info').set({ nombre: nuevoNombre });
            return {
                statusCode: 200,
                body: JSON.stringify({ mensaje: "Nombre modificado correctamente" }),
            };
        }

        return {
            statusCode: 405,
            body: JSON.stringify({ error: "Método HTTP no permitido" }),
        };
    } catch (error) {
        return {
            statusCode: 500,
            body: JSON.stringify({ error: error.message }),
        };
    }
};
