/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionDePacientes;

public class GestionPacientes {
    private Paciente[] pacientes;
    private int contador;

    public GestionPacientes(int capacidad) {
        pacientes = new Paciente[capacidad];
        contador = 0;
    }
    // Crear paciente
    public boolean crearPaciente(Paciente p){
        if(p.getDni()==null || p.getDni().length() !=8 ){
            System.out.println(" ERROR: EL DNI DEBE CONTENER 8 DIGITOS.");
            return false;
        }if(contador>=pacientes.length) {
            return false;
        }if (buscar(p.getDni()) != null){
            return false;
        }
        pacientes[contador++]=p;
        return true;
    }

    // Buscar por DNI
    public Paciente buscar(String dni) {
        for (int i = 0; i < contador; i++) {
            if (pacientes[i].getDni().equals(dni)) {
                return pacientes[i];
            }
        }
        return null;
    }

    // Modificar datos generales
    public boolean modificarPaciente(String dni, String nuevoTelefono, String nuevoEmail,
                                     String nuevoContactoEmergencia) {

        Paciente p = buscar(dni);
        if (p == null) return false;

        p.setTelefono(nuevoTelefono);
        p.setEmail(nuevoEmail);
        p.setContactoDeEmergencia(nuevoContactoEmergencia);

        return true;
    }

    // Eliminar paciente
    public boolean eliminarPaciente(String dni) {
        for (int i = 0; i < contador; i++) {
            if (pacientes[i].getDni().equals(dni)) {

                pacientes[i] = pacientes[contador - 1];
                pacientes[contador - 1] = null;
                contador--;

                return true;
            }
        }
        return false;
    }


    // Obtener lista completa
    public Paciente[] listar() {
        return pacientes;
    }

    // Cantidad actual
    public int cantidad() {
        return contador;
    }

}
