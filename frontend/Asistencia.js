document.addEventListener("DOMContentLoaded", function () {
  // Crear lista de asistencia vacía
  document.querySelector(".card:nth-of-type(1) form").addEventListener("submit", async function (e) {
    e.preventDefault();
    const [codigo, semestre, seccion, fecha, hora] = this.querySelectorAll("input");
    const datos = {
      codigo: codigo.value,
      semestre: semestre.value,
      seccion: seccion.value,
      fecha: fecha.value,
      hora: hora.value,
    };

    const res = await fetch("/.netlify/functions/asistencia/crear-lista", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(datos),
    });
    const json = await res.json();
    alert(json.message || json.error);
  });

  // Registrar asistencia
  document.querySelector(".card:nth-of-type(2) form").addEventListener("submit", async function (e) {
    e.preventDefault();
    const [codigo, semestre, seccion, fecha, hora, tipo, numero, estado] = this.querySelectorAll("input, select");
    const datos = {
      codigo: codigo.value,
      semestre: semestre.value,
      seccion: seccion.value,
      fecha: fecha.value,
      hora: hora.value,
      tipoDocumento: tipo.value,
      numero: numero.value,
      estado: estado.value.toLowerCase(),
    };

    const res = await fetch("/.netlify/functions/asistencia/registrar", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(datos),
    });
    const json = await res.json();
    alert(json.message || json.error);
  });

  // Modificar asistencia
  document.querySelector(".card:nth-of-type(3) form").addEventListener("submit", async function (e) {
    e.preventDefault();
    const [codigo, semestre, seccion, fecha, hora, tipo, numero, nuevoEstado] = this.querySelectorAll("input, select");
    const datos = {
      codigo: codigo.value,
      semestre: semestre.value,
      seccion: seccion.value,
      fecha: fecha.value,
      hora: hora.value,
      tipoDocumento: tipo.value,
      numero: numero.value,
      nuevoEstado: nuevoEstado.value.toLowerCase(),
    };

    const res = await fetch("/.netlify/functions/asistencia/modificar", {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(datos),
    });
    const json = await res.json();
    alert(json.message || json.error);
  });

  // Listar asistencias detalladas
  document.querySelector(".card:nth-of-type(4) form button").addEventListener("click", async function () {
    const res = await fetch("/.netlify/functions/asistencia/listar");
    const json = await res.json();
    alert(JSON.stringify(json, null, 2));
  });
});
