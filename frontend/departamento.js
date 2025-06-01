async function consultarNombre() {
    try {
        const response = await fetch('/.netlify/functions/departamento?accion=consultar');
        const data = await response.json();

        if (response.ok) {
            document.getElementById("resultado").textContent =
                `Nombre actual del departamento: ${data.nombre}`;
        } else {
            document.getElementById("resultado").textContent = `Error: ${data.error}`;
        }
    } catch (error) {
        document.getElementById("resultado").textContent = `Error de red: ${error.message}`;
    }
}

async function modificarNombre() {
    const nuevoNombre = document.getElementById("nombreDepto").value.trim();

    if (!nuevoNombre) {
        alert("Por favor ingresa un nombre válido.");
        return;
    }

    try {
        const response = await fetch('/.netlify/functions/departamento', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ nombre: nuevoNombre })
        });

        const data = await response.json();

        if (response.ok) {
            alert("Nombre del departamento actualizado correctamente.");
            document.getElementById("nombreDepto").value = "";
        } else {
            alert(`Error: ${data.error}`);
        }
    } catch (error) {
        alert(`Error de red: ${error.message}`);
    }
}


