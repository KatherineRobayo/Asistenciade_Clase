const URL = "/.netlify/functions/asignaturas";

// Adicionar
document.getElementById("form-adicionar").addEventListener("submit", async (e) => {
    e.preventDefault();
    const nombre = document.getElementById("nombre").value;
    const codigo = document.getElementById("codigo").value;
    const creditos = parseInt(document.getElementById("creditos").value);
    const seccion = document.getElementById("seccion").value;
    const semestre = document.getElementById("semestre").value;

    const res = await fetch(`${URL}/adicionar`, {
        method: "POST",
        body: JSON.stringify({ nombre, codigo, creditos, seccion, semestre }),
        headers: { "Content-Type": "application/json" }
    });

    const data = await res.json();
    document.getElementById("resultado-adicionar").textContent = data.mensaje || data.error;
});

// Consultar
document.getElementById("form-consultar").addEventListener("submit", async (e) => {
    e.preventDefault();
    const codigo = document.getElementById("codigo-consultar").value;
    const semestre = document.getElementById("semestre-consultar").value;
    const seccion = document.getElementById("seccion-consultar").value;

    const res = await fetch(`${URL}/consultar`, {
        method: "POST",
        body: JSON.stringify({ codigo, semestre, seccion }),
        headers: { "Content-Type": "application/json" }
    });

    const data = await res.json();
    const resultado = document.getElementById("resultado-consultar");

    if (data.nombre) {
        resultado.textContent = `Nombre: ${data.nombre} | Créditos: ${data.creditos}`;
    } else {
        resultado.textContent = data.error;
    }
});

// Modificar
document.getElementById("form-modificar").addEventListener("submit", async (e) => {
    e.preventDefault();
    const codigo = document.getElementById("codigo-modificar").value;
    const semestre = document.getElementById("semestre-modificar").value;
    const seccion = document.getElementById("seccion-modificar").value;
    const nuevoNombre = document.getElementById("nuevo-nombre").value;
    const nuevosCreditos = parseInt(document.getElementById("nuevos-creditos").value);

    const res = await fetch(`${URL}/modificar`, {
        method: "POST",
        body: JSON.stringify({ codigo, semestre, seccion, nuevoNombre, nuevosCreditos }),
        headers: { "Content-Type": "application/json" }
    });

    const data = await res.json();
    document.getElementById("resultado-modificar").textContent = data.mensaje || data.error;
});
