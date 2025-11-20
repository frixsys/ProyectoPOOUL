/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionDeEmpleados;
public class Administrador extends Empleado {

    public Administrador(String dni, String nombre, String apellido, String telefono, 
            String email, String usuario, String password, String rol) {
        super(dni, nombre, apellido, telefono, email, usuario, password, "Administrador");
    }
    
}