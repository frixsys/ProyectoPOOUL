/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionDeFacturacion;
public class Factura {
    private int numero;
    private String descripcion;
    private double Monto;

    public Factura(int numero, String descripcion, double Monto) {
        this.numero = numero;
        this.descripcion = descripcion;
        this.Monto = Monto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double Monto) {
        this.Monto = Monto;
    }
    
    @Override
    public String toString() {
        return "Factura [Número: " + numero + 
                ", Descripción: " + descripcion + 
                ", Monto: " + Monto + "]";
    }
}
