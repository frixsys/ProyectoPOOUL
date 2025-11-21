package GestionDeConsultorios;

import GestionDeConsultorios.Cita;

public class Consultorio {

    private int codigo;
    private String especialidad;
    private String estado;  
    private Cita[] citas;  
    private int contadorCitas;
    private boolean[] horarioDisponible;

    public Consultorio(int codigo, String especialidad, String estado) {
        this.codigo = codigo;
        this.especialidad = especialidad;
        this.estado = estado;
        this.citas = new Cita[10]; 
        this.contadorCitas = 0;
        this.horarioDisponible = new boolean[7];
        
    }
       
    public int getCodigo() {
      return codigo; 
    }
    public void setCodigo(int codigo) {
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

    public boolean[] getHorarioDisponible() {
        return horarioDisponible;
    }

    public void setHorarioDisponible(boolean[] horarioDisponible) {
        this.horarioDisponible = horarioDisponible;
    }
    
}

