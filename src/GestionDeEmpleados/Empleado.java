
package GestionDeEmpleados;

import Model.Persona;

public abstract class Empleado extends Persona {

    protected String Usuario;
    protected String password;
    protected String rol;

    public Empleado(String dni, String nombre, String apellido,
                    String telefono, String email,
                    String usuario, String password, String rol) {

        super(dni, nombre, apellido, telefono, email);
        this.Usuario = usuario;
        this.password = password;
        this.rol = rol;
    }

    public String getRol() { 
        return rol; 
    }
    
    public String getUsuario(){  
        return Usuario; }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }
    
    public String getPassword() { 
        return password; 
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEspecialidad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
