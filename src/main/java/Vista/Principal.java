package Vista;

import Controlador.El_Controlador;
import Modelo.Estudiante;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        El_Controlador controlador = new El_Controlador();
        Scanner scanner = new Scanner(System.in);
        String opcion = "";

        while (!opcion.equals("15")) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Consultar nombre del departamento");
            System.out.println("2. Modificar nombre del departamento");
            System.out.println("3. Registrar estudiante");
            System.out.println("4. Consultar estudiante");
            System.out.println("5. Modificar estudiante");
            System.out.println("6. Adicionar asignatura");
            System.out.println("7. Consultar asignatura");
            System.out.println("8. Modificar asignatura");
            System.out.println("9. Registrar estudiante en asignatura");
            System.out.println("10. Consultar estudiantes en asignatura");
            System.out.println("11. Crear  lista de asistencia vacia");
            System.out.println("12. Llenar asistencia");
            System.out.println("13. Modificar asistencia");
            System.out.println("14. Listar asistencias detalladas");
            System.out.println("15. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            if (opcion.equals("1")) {
                String nombre = controlador.consultarNombreDepartamento();
                System.out.println("Nombre del departamento: " + nombre);

            } else if (opcion.equals("2")) {
                System.out.print("Ingrese nuevo nombre del departamento: ");
                String nuevoNombre = scanner.nextLine();
                controlador.modificarNombreDepartamento(nuevoNombre);
                System.out.println("Nombre del departamento modificado.");

            } else if (opcion.equals("3")) {
                System.out.print("Ingrese el nombre del estudiante: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese el tipo de documento: ");
                String tipo = scanner.nextLine();
                System.out.print("Ingrese el número de documento: ");
                String numero = scanner.nextLine();
                controlador.registrarEstudiante(nombre, tipo, numero);
                System.out.println("Estudiante registrado correctamente.");

            } else if (opcion.equals("4")) {
                System.out.print("Ingrese el ipo de documento: ");
                String tipo = scanner.nextLine();
                System.out.print("Ingrese el número de documento: ");
                String numero = scanner.nextLine();
                Estudiante est = controlador.consultarEstudiante(tipo, numero);
                if (est != null) {
                    System.out.println("Estudiante: " + est.getNombre_completo());
                } else {
                    System.out.println("Estudiante no encontrado.");
                }

            } else if (opcion.equals("5")) {
                System.out.print("Ingrese el tipo de documento actual: ");
                String tipo = scanner.nextLine();
                System.out.print("Ingrese el número de documento: ");
                String numero = scanner.nextLine();
                System.out.print("Ingrese el nuevo nombre: ");
                String nuevoNombre = scanner.nextLine();
                System.out.print("Ingrese el nuevo tipo de documento: ");
                String nuevoTipo = scanner.nextLine();
                boolean resultado = controlador.modificarEstudiante(tipo, numero, nuevoNombre, nuevoTipo);
                if (resultado) {
                    System.out.println("Estudiante modificado.");
                } else {
                    System.out.println("No se encontró el estudiante.");
                }

            } else if (opcion.equals("6")) {
                System.out.print("Ingrese el nombre de la asignatura: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese el Código de la asignatura: ");
                String codigo = scanner.nextLine();
                System.out.print("Ingrese la cantidad de Créditos: ");
                int creditos = Integer.parseInt(scanner.nextLine());
                System.out.print("Ingrese la sección: ");
                String seccion = scanner.nextLine();
                System.out.print("Ingrese el semestre: ");
                String semestre = scanner.nextLine();
                controlador.adicionarAsignatura(nombre, codigo, creditos, seccion, semestre);
                System.out.println("Asignatura registrada correctamente.");

            } else if (opcion.equals("7")) {
                System.out.print("Ingrese el Código de la asignatura: ");
                String codigo = scanner.nextLine();
                System.out.print("Ingrese el semestre: ");
                String semestre = scanner.nextLine();
                System.out.print("Ingrese la sección: ");
                String seccion = scanner.nextLine();
                if (controlador.existeAsignatura(codigo, semestre, seccion)) {
                    System.out.println("Asignatura encontrada.");
                } else {
                    System.out.println("Asignatura no encontrada.");
                }

            } else if (opcion.equals("8")) {
                System.out.print("Ingrese el código: ");
                String codigo = scanner.nextLine();
                System.out.print("Ingrese el semestre: ");
                String semestre = scanner.nextLine();
                System.out.print("Ingrese la sección: ");
                String seccion = scanner.nextLine();
                System.out.print("Ingrese el nuevo nombre: ");
                String nuevoNombre = scanner.nextLine();
                System.out.print("Ingrese los nuevos créditos: ");
                int nuevosCreditos = Integer.parseInt(scanner.nextLine());
                boolean resultado = controlador.modificarAsignatura(codigo, semestre, seccion, nuevoNombre, nuevosCreditos);
                if (resultado) {
                    System.out.println("Asignatura modificada.");
                } else {
                    System.out.println("No se encontró la asignatura.");
                }

            } else if (opcion.equals("9")) {
                System.out.print("Ingrese el tipo de documento: ");
                String tipo = scanner.nextLine();
                System.out.print("Ingrese el número de documento: ");
                String numero = scanner.nextLine();
                System.out.print("Ingrese el código de asignatura: ");
                String codigo = scanner.nextLine();
                System.out.print("Ingrese el semestre: ");
                String semestre = scanner.nextLine();
                System.out.print("Ingrese la sección: ");
                String seccion = scanner.nextLine();
                boolean resultado = controlador.registrarEstudianteEnAsignatura(tipo, numero, codigo, semestre, seccion);
                if (resultado) {
                    System.out.println("Estudiante registrado en asignatura.");
                } else {
                    System.out.println("No se encontró la asignatura.");
                }

            } else if (opcion.equals("10")) {
                System.out.print("Ingrese el código de la asignatura: ");
                String codigo = scanner.nextLine();
                System.out.print("Ingrese el semestre: ");
                String semestre = scanner.nextLine();
                System.out.print("Ingrese la sección: ");
                String seccion = scanner.nextLine();
                ArrayList<String> estudiantes = controlador.consultarEstudiantesAsignatura(codigo, semestre, seccion);
                if (!estudiantes.isEmpty()) {
                    System.out.println("Estudiantes:");
                    for (String e : estudiantes) {
                        System.out.println(e);
                    }
                } else {
                    System.out.println("No hay estudiantes registrados en esta asignatura.");
                }

            } else if (opcion.equals("11")) {
                System.out.print("Ingrese el código de la asignatura: ");
                String codigo = scanner.nextLine();
                System.out.print("Ingrese el semestre: ");
                String semestre = scanner.nextLine();
                System.out.print("Ingrese la sección: ");
                String seccion = scanner.nextLine();
                System.out.print("Ingrese la Fecha: ");
                String fecha = scanner.nextLine();
                System.out.print(" Ingrese la hora de inicio: ");
                String hora = scanner.nextLine();
                boolean resultado= controlador.crearAsistencia(codigo, semestre, seccion, fecha, hora);
                if (resultado) {
                    System.out.println("Asistencia creada.");
                } else {
                    System.out.println("No se encontró la asignatura.");
                }

            } else if (opcion.equals("12")) {
                System.out.print("Ingrese el código de asignatura: ");
                String codigo = scanner.nextLine();
                System.out.print("Ingrese el semestre: ");
                String semestre = scanner.nextLine();
                System.out.print("Inrese la sección: ");
                String seccion = scanner.nextLine();
                System.out.print("Ingrese la fecha: ");
                String fecha = scanner.nextLine();
                System.out.print("Ingrese la hora de inicio: ");
                String hora = scanner.nextLine();
                System.out.print("Ingrese el tipo de documento del estudiante: ");
                String tipo = scanner.nextLine();
                System.out.print("Ingrese el número de documento del estudiante: ");
                String numero = scanner.nextLine();
                System.out.print("Ingrese el Estado (asistió, No asistió): ");
                String estado = scanner.nextLine().toLowerCase();

                if (!estado.equals("asistió") && !estado.equals("no asistió")) {
                    System.out.println("Solo puede ingresar 'asistió' o 'no asistió'.");
                } else {
                    boolean resultado = controlador.llenarAsistencia(codigo, semestre, seccion, fecha, hora, tipo, numero, estado);
                    if (resultado) {
                        System.out.println("Asistencia registrada.");
                    } else {
                        System.out.println("Error al registrar asistencia.");
                    }
                }


            } else if (opcion.equals("13")) {
                System.out.print("Ingrese el código de asignatura: ");
                String codigo = scanner.nextLine();
                System.out.print("Ingrese el semestre: ");
                String semestre = scanner.nextLine();
                System.out.print("Ingrese la sección: ");
                String seccion = scanner.nextLine();
                System.out.print("Ingrese la fecha: ");
                String fecha = scanner.nextLine();
                System.out.print("Ingrese la hora de inicio: ");
                String hora = scanner.nextLine();
                System.out.print("Ingrese el tipo de documento del estudiante: ");
                String tipo = scanner.nextLine();
                System.out.print("Ingrese el número de documento del estudiante: ");
                String numero = scanner.nextLine();
                boolean ok = controlador.modificarAsistencia(codigo, semestre, seccion, fecha, hora, tipo, numero);
                if (ok) {
                    System.out.println("Asistencia modificada a 'llegó tarde'.");
                } else {
                    System.out.println("Error al modificar asistencia.");
                }

            } else if (opcion.equals("14")) {
                ArrayList<String> asistencias = controlador.listarAsistenciasDetalladas();
                if (!asistencias.isEmpty()) {
                    for (String detalle : asistencias) {
                        System.out.println(detalle);
                    }
                } else {
                    System.out.println("No hay asistencias registradas.");
                }

            } else if (!opcion.equals("15")) {
                System.out.println("Opción no válida.");
            }
        }

        System.out.println("Saliendo del programa...");
    }
}



