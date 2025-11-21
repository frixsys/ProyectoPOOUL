package GestionDeConsultorios;

import Model.Persona;
import GestionDeEmpleados.Medico;

public class Cita {
    private String fechaHora;
    private String estado;
    private Persona paciente;   
    private Medico medico;     
    private Consultorio consultorio; 

    public Cita(String fechaHora, String estado, Persona paciente, Medico medico, Consultorio consultorio) {
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.paciente = paciente;
        this.medico = medico;
        this.consultorio = consultorio;
    }

    // Métodos getters y setters
    public String getFechaHora() { 
        return fechaHora; 
    }
    public void setFechaHora(String fechaHora) { 
        this.fechaHora = fechaHora; 
    }

    public String getEstado() { 
        return estado; 
    }
    public void setEstado(String estado) { 
        this.estado = estado; 
    }

    public Persona getPaciente() { 
        return paciente; 
    }
    public void setPaciente(Persona paciente) { 
        this.paciente = paciente; 
    }

    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) { 
        this.medico = medico; 
    }

    public Consultorio getConsultorio() { 
        return consultorio; 
    }
    public void setConsultorio(Consultorio consultorio) { 
        this.consultorio = consultorio; 
    }

    // metodos
    public void confirmar() {
        this.estado = "Confirmada";
    }

    public void cancelar() {
        this.estado = "Cancelada";
    }
}
