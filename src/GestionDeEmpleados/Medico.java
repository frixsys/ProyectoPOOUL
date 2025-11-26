/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionDeEmpleados;
public class Medico extends Empleado {
    private String especialidad;

    public Medico(String especialidad, String dni, String nombre, String apellido, String telefono, String email, String usuario, String password, String rol) {
        super(dni, nombre, apellido, telefono, email, usuario, password, "Médico");
        this.especialidad = especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public String getEspecialidad() { 
        return especialidad; 
    }
}

