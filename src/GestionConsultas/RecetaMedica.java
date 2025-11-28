/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionConsultas;

/**
 *
 * @author santiago
 */
public class RecetaMedica {
    private String medicamento;
    private String dosis;
    private String duracion;

    public RecetaMedica(String medicamento, String dosis, String duracion) {
        this.medicamento = medicamento;
        this.dosis = dosis;
        this.duracion = duracion;
    }

    public String getMedicamento() { return medicamento; }
    public String getDosis() { return dosis; }
    public String getDuracion() { return duracion; }

    @Override
    public String toString() {
        return medicamento + " - " + dosis + " (" + duracion + ")";
    }
}