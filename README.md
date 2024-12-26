# SierraAngel_pruebatec1

En este código se presenta un sistema para gestionar a los empleados en una base de datos utilizando Java Persistence API (JPA).

## Funcionamiento
El código muestra un menú interactivo con 5 opciones ordenadas de manera donde se pueden gestionar los empleados para dar de alta un nuevo empleado, actualizar la información de un empleado en caso de que el usuario haya cometido un erro en el ingreso de sus datos o alguno de estos haya sido modificado, dar de baja la información de un empleado, listar a todos los empleados o listarlos solo por cargo y por último una opción para terminar la ejecución del código.

## Características

- **Alta de empleados**: Agrega nuevos empleados al sistema.
- **Actualización de datos**: Modifica información de empleados existentes.
- **Eliminación de empleados**: Borra empleados del sistema.
- **Búsqueda por cargo**: Filtra empleados por su cargo laboral.
- **Persistencia de datos**: Guarda la información en una base de datos relacional.

## Supuestos

-**Alta de empleados**: La consigna no pide un identificador de cada empleado por lo que se le asigna uno a cada empleado al darlo de alta en la base de datos
-****:

## Clases
-**Empleado**: Es la clase donde creamos el objeto empleado y definimos los datos que vamos a obtener nombre, apellido, cargo, salario y la fecha de ingreso, ademas de agreegar y asignar un id a cada empleado.  
-**ControladoraPersistencia**: Es la clase que usamos para no mezclar la capas y evitar codigo de persistencia en model y viceversa.

## Metodos 
-**borrarEmpleado**: En este método borramos un empleado de la base de datos

-**traerEmpleado**: En este método buscamos un empleado por su id

-**List<Empleado> traerEmplead**: En este método traemos la lista de empleados completa

-**modificarEmpleado**: En este método se implementa para la modificación de los datos de los empleados

## Requisitos
- **JDK**: Versión 17
- **Apache Maven**: Para la gestión de dependencias.
- **IDE**: NetBeans
- **Base de datos relacional**:Mysql

  
