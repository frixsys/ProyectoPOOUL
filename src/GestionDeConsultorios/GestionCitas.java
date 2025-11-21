package GestionDeConsultorios;

import GestionDeConsultorios.Cita;

public class GestionCitas {

    private Cita[] citas;
    private int contador;

    public GestionCitas(int capacidad) {
        citas = new Cita[capacidad];
        contador = 0;
    }

    // Crear citas
    public String agregar(Cita c) {
        if (contador >= citas.length) {
            return "ERROR: No se pueden agregar más citas.";
        }

        citas[contador++] = c;
        return "Cita agregada correctamente.";
    }

    // Modificar citas
    public String modificar(int i, String nuevoEstado) {
        if (i >= 0 && i < contador) {
            citas[i].setEstado(nuevoEstado);
            return "Cita modificada correctamente.";
        }
        return "ERROR: Cita no encontrada.";
    }

  
    public String eliminar(int i) {
        if (i >= 0 && i < contador) {
            citas[i] = citas[contador - 1];
            citas[contador - 1] = null;
            contador--;
            return "Cita eliminada correctamente.";
        }
        return "ERROR: Cita no encontrada.";
    }
    
    
    
    public Cita[] listar() {
        return citas;
    }

    // Obtener la cantidad de citas registradas
    public int cantidad() {
        return contador;
    }
}
