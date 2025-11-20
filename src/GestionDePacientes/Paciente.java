/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionDePacientes;

import Model.Persona;

public class Paciente extends Persona{
    private String FechaNacimiento;
    private String sexo;
    private String ContactoDeEmergencia;

    public Paciente(String FechaNacimiento, String sexo, String ContactoDeEmergencia, String Dni, String Nombre, String Apellido, String Telefono, String email) {
        super(Dni, Nombre, Apellido, Telefono, email);
        this.FechaNacimiento = FechaNacimiento;
        this.sexo = sexo;
        this.ContactoDeEmergencia = ContactoDeEmergencia;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public String getContactoDeEmergencia() {
        return ContactoDeEmergencia;
    }

    public void setContactoDeEmergencia(String ContactoDeEmergencia) {
        this.ContactoDeEmergencia = ContactoDeEmergencia;
    }
    
}
