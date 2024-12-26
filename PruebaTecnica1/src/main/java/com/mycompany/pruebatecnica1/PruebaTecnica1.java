package com.mycompany.pruebatecnica1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Empleado;
import persistencia.ControladoraPersistencia;

public class PruebaTecnica1 {

    public static void main(String[] args) {

        int op = 0;
        int op2=0;
        Scanner teclado = new Scanner(System.in);
        ControladoraPersistencia controlPersis = new ControladoraPersistencia();

        List<Empleado> listEmpleado = new ArrayList<>(controlPersis.traerEmpleado());
        System.out.println("Se han cargado " + listEmpleado.size() + " empleados de la base de datos.");

        while (true) {
            System.out.println("|---------------------------------------------|");
            System.out.println("|   Seleccione la acción que desea realizar:  |");
            System.out.println("|---------------------------------------------|");
            System.out.println("| 1. Alta                                     |");
            System.out.println("|---------------------------------------------|");
            System.out.println("| 2. Actualizar Información                   |");
            System.out.println("|---------------------------------------------|");
            System.out.println("| 3. Baja De Empleado                         |");
            System.out.println("|---------------------------------------------|");
            System.out.println("| 4. Listado De Empleados                     |");
            System.out.println("|---------------------------------------------|");
            System.out.println("| 5. Salir                                    |");
            System.out.println("|---------------------------------------------|");
            System.out.print("Seleccione una opción: ");
            op = teclado.nextInt();
            teclado.nextLine();

            switch (op) {
                case 1:
                    System.out.println("Bienvenido ha elegido la opción agregar un nuevo empleado.");
                    String nombre;
                    do {
                        System.out.println("Ingrese el Nombre del empleado:");
                        nombre = teclado.nextLine().trim();
                        if (nombre.isEmpty()) {
                            System.out.println("El nombre no puede estar vacío. Intente nuevamente.");
                        }
                    } while (nombre.isEmpty());

                    String apellido;
                    do {
                        System.out.println("Ingrese el Apellido del empleado:");
                        apellido = teclado.nextLine().trim();
                        if (apellido.isEmpty()) {
                            System.out.println("El apellido no puede estar vacío. Intente nuevamente.");
                        }
                    } while (apellido.isEmpty());

                    String cargo;
                    do {
                        System.out.println("Ingrese el cargo del empleado:");
                        cargo = teclado.nextLine().trim();
                        if (cargo.isEmpty()) {
                            System.out.println("El cargo no puede estar vacío. Intente nuevamente.");
                        }
                    } while (cargo.isEmpty());

                    System.out.println("Ingrese el salario del empleado:");
                    double salario = teclado.nextDouble();
                    teclado.nextLine();

                    LocalDate fechaIngreso = null;
                    boolean fechaValida = false;

                    while (!fechaValida) {
                        try {
                            System.out.println("Ingrese la fecha de ingreso del empleado (dd/MM/yyyy):");
                            String fechaa = teclado.nextLine().trim();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            fechaIngreso = LocalDate.parse(fechaa, formatter);
                            fechaValida = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Formato de fecha inválido. Intente nuevamente.");
                        }
                    }

                    Empleado nuevoEmpleado = new Empleado(nombre, apellido, cargo, salario, fechaIngreso);
                    controlPersis.crearEmpleado(nuevoEmpleado);
                    listEmpleado = new ArrayList<>(controlPersis.traerEmpleado());

                    System.out.println("Empleado agregado exitosamente.");
                    break;


                case 2:
                    System.out.println("Ha seleccionado la opción de actualizar la información de un empleado.");
                    System.out.println("Ingrese el ID del empleado a modificar:");
                    int modId = teclado.nextInt();
                    teclado.nextLine();

                    Empleado empleadoAMod = controlPersis.traerEmpleado(modId);

                    if (empleadoAMod != null) {
                        System.out.println("Los datos del empleado que desea modificar son:");
                        System.out.println("ID: " + empleadoAMod.getId());
                        System.out.println("Nombre: " + empleadoAMod.getName());
                        System.out.println("Apellido: " + empleadoAMod.getApellido());
                        System.out.println("Cargo: " + empleadoAMod.getCargo());
                        System.out.println("Salario: " + empleadoAMod.getSalario());
                        System.out.println("Fecha de Ingreso: " + empleadoAMod.getDate());

                        System.out.println("Ingrese el nuevo nombre (o presione Enter para no cambiar):");
                        String nuevoNombre = teclado.nextLine();
                        if (!nuevoNombre.isBlank()) {
                            empleadoAMod.setName(nuevoNombre);
                        }
                        System.out.println("Ingrese el nuevo apellido (o presione Enter para no cambiar):");
                        String nuevoApellido = teclado.nextLine();
                        if (!nuevoApellido.isBlank()) {
                            empleadoAMod.setApellido(nuevoApellido);
                        }
                        System.out.println("Ingrese el nuevo cargo (o presione Enter para no cambiar):");
                        String nuevoCargo = teclado.nextLine();
                        if (!nuevoCargo.isBlank()) {
                            empleadoAMod.setCargo(nuevoCargo);
                        }
                        System.out.println("Ingrese el nuevo salario (o presione Enter para no cambiar):");
                        String nuevoSalario = teclado.nextLine();
                        if (!nuevoSalario.isBlank()) {
                            empleadoAMod.setSalario(Double.parseDouble(nuevoSalario));
                        }

                        LocalDate nuevaFechaIngreso = null;
                        boolean fechaValida2 = false;

                        while (!fechaValida2) {
                            try {
                                System.out.println("Ingrese la nueva fecha de ingreso (dd/MM/yyyy) (o presione Enter para no cambiar):");
                                String nuevaFecha = teclado.nextLine();
                                if (nuevaFecha.isBlank()) {
                                    fechaValida2 = true;
                                } else {
                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                    nuevaFechaIngreso = LocalDate.parse(nuevaFecha, formatter);
                                    empleadoAMod.setDatee(nuevaFechaIngreso);
                                    fechaValida2 = true;
                                }
                            } catch (Exception e) {
                                System.out.println("Formato de fecha inválido. Intente nuevamente.");
                            }
                        }

                        controlPersis.modificarEmpleado(empleadoAMod);
                        listEmpleado = new ArrayList<>(controlPersis.traerEmpleado());
                        System.out.println("La información del empleado ha sido actualizada exitosamente.");
                    } else {
                        System.out.println("No se encontró un empleado con el ID proporcionado.");
                    }

                    break;

                case 3:
                    System.out.println("Ha seleccionado la opción eliminar empleado.");
                    System.out.println("Ingrese el ID de la persona que desea borrar:");
                    int idDelete = teclado.nextInt();
                    teclado.nextLine();

                    Empleado empleadoAEliminar = controlPersis.traerEmpleado(idDelete);

                    if (empleadoAEliminar != null) {
                        System.out.println("Los datos del empleado que desea eliminar son:");
                        System.out.println("ID: " + empleadoAEliminar.getId());
                        System.out.println("Nombre: " + empleadoAEliminar.getName());
                        System.out.println("Apellido: " + empleadoAEliminar.getApellido());
                        System.out.println("Cargo: " + empleadoAEliminar.getCargo());
                        System.out.println("Salario: " + empleadoAEliminar.getSalario());
                        System.out.println("Fecha de Ingreso: " + empleadoAEliminar.getDate());

                        System.out.println("¿Está seguro de que desea eliminar a este empleado? (s/n)");
                        String confirmacion = teclado.nextLine();

                        if (confirmacion.equalsIgnoreCase("s")) {
                            controlPersis.borrarEmpleado(idDelete);
                            listEmpleado = new ArrayList<>(controlPersis.traerEmpleado());
                            System.out.println("Empleado eliminado exitosamente.");
                        } else {
                            System.out.println("Operación cancelada. El empleado no fue eliminado.");
                        }
                    } else {
                        System.out.println("No se encontró un empleado con el ID proporcionado.");
                    }
                    break;

                case 4:
                   
                    System.out.println("   Ha seleccionado el listado de empleados");
                    System.out.println("|---------------------------------------------|");
                    System.out.println("|   Seleccione la acción que desea realizar:  |");
                    System.out.println("|---------------------------------------------|");
                    System.out.println("| 1. Listado de todos los empleados           |");
                    System.out.println("|---------------------------------------------|");
                    System.out.println("| 2. Listado de empleados por cargo           |");
                    System.out.println("|---------------------------------------------|");
                    op2 = teclado.nextInt();
                    teclado.nextLine();
                    switch(op2){
                        case 1:
                            System.out.println("Lista de Empleados");
                            for (Empleado emp : listEmpleado) {
                                System.out.println("ID: " + emp.getId() + ", Nombre: " + emp.getName() + ", Apellido: " + emp.getApellido());
                                System.out.println("Salario: " + emp.getSalario() + ", Fecha de Ingreso: " + emp.getDate());
                                System.out.println("---------------------------------------------");
                            }
                            
                            break;
                        case 2:
                            
                            System.out.println("Ha seleccionado la opción de búsqueda por cargo de trabajo.");
                            System.out.println("Ingrese el cargo que desea buscar:");
                            String cargoLookF = teclado.nextLine();

                            System.out.println("Resultados de la búsqueda para el cargo: " + cargoLookF);
                            boolean encontrado = false;

                            for (Empleado emp : listEmpleado) {
                                if (emp.getCargo().equalsIgnoreCase(cargoLookF)) {
                                    System.out.println("ID: " + emp.getId() + ", Nombre: " + emp.getName() + ", Apellido: " + emp.getApellido());
                                    System.out.println("Salario: " + emp.getSalario() + ", Fecha de Ingreso: " + emp.getDate());
                                    System.out.println("---------------------------------------------");
                                    encontrado = true;
                                }
                            }

                            if (!encontrado) {
                                System.out.println("No se encontraron empleados con el cargo: " + cargoLookF);
                            }
                            break;
                            
                        default:
                            
                            System.out.println("Opción no válida. Inténtelo de nuevo.");
                            break;
                    
                    }
                    
                   
                    break;

                case 5:
                    System.out.println("Gracias por usar nuestro sistema. ¡Hasta pronto!");
                    return;

                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }
    }
}

