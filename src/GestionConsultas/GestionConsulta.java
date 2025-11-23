
package GestionConsultas;

public class GestionConsulta {
    private Consultas[] consultas;
    private int contador;

    public GestionConsulta(int capacidad) {
        consultas = new Consultas[capacidad];
        contador = 0;
    }

    public String agregar(Consultas c) {
        if (contador >= consultas.length) 
            return "ERROR: No hay espacio para más consultas.";

        consultas[contador++] = c;
        return "Consulta registrada correctamente.";
    }

    public String eliminar(int index) {
        if (index >= 0 && index < contador) {
            consultas[index] = consultas[contador - 1];
            consultas[contador - 1] = null;
            contador--;
            return "Consulta eliminada.";
        }
        return "ERROR: Consulta no encontrada.";
    }

    public Consultas[] listar() {
        return consultas;
    }

    public int cantidad() {
        return contador;
    }
}

