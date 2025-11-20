package GestionDeConsultorios;

import GestionDeConsultorios.Cita;

public class Consultorio {

    private String codigo;
    private String especialidad;
    private String estado;  
    private Cita[] citas;  
    private int contadorCitas;

    public Consultorio(String codigo, String especialidad, String estado) {
        this.codigo = codigo;
        this.especialidad = especialidad;
        this.estado = estado;
        this.citas = new Cita[10]; 
        this.contadorCitas = 0;
    }
    
    public String getCodigo() {
      return codigo; 
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEspecialidad() { 
        return especialidad; 
    }
    public void setEspecialidad(String especialidad) { 
        this.especialidad = especialidad; 
    }

    public String getEstado() { 
        return estado; 
    }
    public void setEstado(String estado) { 
        this.estado = estado; 
    }

    public Cita[] getCitas() { 
        return citas; 
    }
    public int getContadorCitas() { 
        return contadorCitas; 
    }
    public void agregarCita(Cita cita) {
        if (contadorCitas < citas.length) {
            citas[contadorCitas++] = cita;
        }
    }
    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }
    
}

