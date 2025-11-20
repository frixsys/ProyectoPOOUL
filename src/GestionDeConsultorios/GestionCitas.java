package GestionDeConsultorios;

import GestionDeConsultorios.Cita;

public class GestionCitas {

    private Cita[] citas;
    private int contador;

    public GestionCitas(int capacidad) {
        citas = new Cita[capacidad];
        contador = 0;
    }

    // Crear cita
    public String agregar(Cita c) {
        if (contador >= citas.length) {
            return "ERROR: No se pueden agregar más citas.";
        }

        citas[contador++] = c;
        return "Cita agregada correctamente.";
    }

    // Modificar cita
    public String modificar(int index, String nuevoEstado) {
        if (index >= 0 && index < contador) {
            citas[index].setEstado(nuevoEstado);
            return "Cita modificada correctamente.";
        }
        return "ERROR: Cita no encontrada.";
    }

    // Eliminar cita
    public String eliminar(int index) {
        if (index >= 0 && index < contador) {
            citas[index] = citas[contador - 1];  // Reemplaza por la última cita
            citas[contador - 1] = null;
            contador--;
            return "Cita eliminada correctamente.";
        }
        return "ERROR: Cita no encontrada.";
    }

    // Listar citas
    public Cita[] listar() {
        return citas;
    }

    // Obtener cantidad de citas registradas
    public int cantidad() {
        return contador;
    }
}
