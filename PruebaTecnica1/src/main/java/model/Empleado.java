package model;



import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class Empleado implements Serializable {
    
    //No hay ninguna instruccion de un numero de control asi que tomaramos un id para cada empleado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String apellido;
    private String cargo;
    private double salario;
    private LocalDate date;

    public Empleado() {
    }

    public Empleado(String name, String apellido, String cargo, double salario, LocalDate date) {
        this.name = name;
        this.apellido = apellido;
        this.cargo = cargo;
        this.salario = salario;
        this.date = date;
    }
    
    
    
    public Empleado(int id, String name, String apellido, String cargo, double salario, LocalDate date) {
        this.id = id;
        this.name = name;
        this.apellido = apellido;
        this.cargo = cargo;
        this.salario = salario;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDatee(LocalDate date) {
        this.date = date;
    }
    
    

    
    
}
