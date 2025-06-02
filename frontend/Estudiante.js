const URL = "/.netlify/functions/estudiante";
function mostrarRespuesta(data) {
  if (data.mensaje) {
    alert(data.mensaje);
  } else if (data.error) {
    alert("Error: " + data.error);
  } else {
    alert("Respuesta desconocida del servidor.");
  }
}

async function registrarEstudiante() {
  const nombre = document.getElementById("nombre").value;
  const tipoDocumento = document.getElementById("tipoDocumento").value;
  const numeroDocumento = document.getElementById("numeroDocumento").value;

  try {
    const res = await fetch(`${URL}/registrar`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ nombre, tipoDocumento, numeroDocumento }),
    });

    const data = await res.json();
    mostrarRespuesta(data);
  } catch (error) {
    alert("Error al registrar estudiante.");
  }
}

async function consultarEstudiante() {
  const tipoDocumento = document.getElementById("tipoDocConsulta").value;
  const numeroDocumento = document.getElementById("numDocConsulta").value;

  try {
    const res = await fetch(`${URL}/consultar?tipoDocumento=${tipoDocumento}&numeroDocumento=${numeroDocumento}`);
    const data = await res.json();
    document.getElementById("resultadoConsulta").innerText = data.nombre || data.mensaje;
  } catch (error) {
    document.getElementById("resultadoConsulta").innerText = "Error en la consulta.";
  }
}

async function modificarEstudiante() {
  const tipoDocumento = document.getElementById("tipoDocModificar").value;
  const numeroDocumento = document.getElementById("numDocModificar").value;
  const nuevoNombre = document.getElementById("nuevoNombre").value;
  const nuevoTipoDocumento = document.getElementById("nuevoTipoDocumento").value;

  try {
    const res = await fetch(`${URL}/modificar`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ tipoDocumento, numeroDocumento, nuevoNombre,nuevoTipoDocumento }),
    });

    const data = await res.json();
    mostrarRespuesta(data);
  } catch (error) {
    alert("Error al modificar estudiante.");
  }
}

async function registrarEnAsignatura() {
  const tipoDocumento = document.getElementById("tipoDocAsigReg").value;
  const numeroDocumento = document.getElementById("numDocAsigReg").value;
  const codigo = document.getElementById("codigoAsignaturaRegistro").value;
  const semestre = document.getElementById("semestreAsignaturaRegistro").value;
  const seccion = document.getElementById("seccionAsignaturaRegistro").value;

  try {
    const res = await fetch(`${URL}/registrarAsignatura`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ tipoDocumento, numeroDocumento, codigo, semestre, seccion }),
    });

    const data = await res.json();
    mostrarRespuesta(data);
  } catch (error) {
    alert("Error al registrar en asignatura.");
  }
}

async function consultarEstudiantesAsignatura() {
  const codigo = document.getElementById("codigoAsignaturaConsulta").value;
  const semestre = document.getElementById("semestreAsignaturaConsulta").value;
   const seccion = document.getElementById("seccionAsignaturaConsulta").value;

  try {
    const res = await fetch(`${URL}/consultarAsignatura?codigo=${codigo}&semestre=${semestre}&seccion=${seccion}`);
    const data = await res.json();

    const ul = document.getElementById("listaEstudiantesAsignatura");
    ul.innerHTML = "";

    if (data.estudiantes && data.estudiantes.length > 0) {
      data.estudiantes.forEach(est => {
        const li = document.createElement("li");
        li.textContent = est;
        ul.appendChild(li);
      });
    } else {
      const li = document.createElement("li");
      li.textContent = data.mensaje || "No se encontraron estudiantes.";
      ul.appendChild(li);
    }
  } catch (error) {
    const ul = document.getElementById("listaEstudiantesAsignatura");
    ul.innerHTML = "<li>Error al consultar estudiantes.</li>";
  }
}

document.addEventListener("DOMContentLoaded", () => {
  document.getElementById("formRegistrar").addEventListener("submit", function(e) {
    e.preventDefault();
    registrarEstudiante();
  });

  document.getElementById("formConsultar").addEventListener("submit", function(e) {
    e.preventDefault();
    consultarEstudiante();
  });

  document.getElementById("formModificar").addEventListener("submit", function(e) {
    e.preventDefault();
    modificarEstudiante();
  });

  document.getElementById("formRegistrarAsignatura").addEventListener("submit", function(e) {
    e.preventDefault();
    registrarEnAsignatura();
  });

  document.getElementById("formConsultarAsignatura").addEventListener("submit", function(e) {
    e.preventDefault();
    consultarEstudiantesAsignatura();
  });
});

