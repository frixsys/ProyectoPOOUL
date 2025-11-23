/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionConsultas;
import GestionDeConsultorios.Cita;

public class Consultas {  
    private String motivo;
    private String diagnostico;
    private String receta;
    private double precio;
    private String estado;
    private Cita cita;           

    public Consultas(String motivo, String diagnostico, String receta, double precio, Cita cita) {
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.receta = receta;
        this.precio = precio;
        this.estado = "Abierta";
        this.cita = cita;
    }
     public String getMotivo() {
         return motivo;
    }
    public void setMotivo(String motivo){  
        this.motivo=motivo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getReceta() {
        return receta;
    }
    public void setReceta(String receta) {
        this.receta = receta;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }
    public void cerrar() {
        this.estado = "Cerrada";
    }

    public Cita getCita() {
        return cita;
    }
}        