/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionConsultas;

/**
 *
 * @author santiago
 */

public class OrdenLaboratorio {
    private String tipoMuestra;
    private double precio;

    
    public OrdenLaboratorio(String tipoMuestra, double precio) {
        this.tipoMuestra = tipoMuestra;
        this.precio = precio;
    }

    public String getTipoMuestra() {
        return tipoMuestra;
    }

    public double getPrecio() {
        return precio;
    }
    
    

    @Override
    public String toString() {
        return tipoMuestra + " (S/ " + precio + ")";
    }
}