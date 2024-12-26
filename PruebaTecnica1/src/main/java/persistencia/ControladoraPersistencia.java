package persistencia;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Empleado;
import persistencia.exceptions.NonexistentEntityException;



public class ControladoraPersistencia {
   
    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();
    
    public void crearEmpleado(Empleado empleado){
        
        empleadoJpa.create(empleado);
    }
    
     public void borrarEmpleado(int id){
        try {
            empleadoJpa.destroy(id);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //traer una sola
        public Empleado traerEmpleado(int id){

            return empleadoJpa.findEmpleado(id);

        }

        //traer varias personas
        public List<Empleado> traerEmpleado(){
            return empleadoJpa.findEmpleadoEntities();
        }

        //persona que llega como parmatro es la persona con datos a modificar
        public void modificarEmpleado(Empleado empleado){
            try {
                empleadoJpa.edit(empleado);
            } catch (Exception ex) {
                Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
}
    
   

