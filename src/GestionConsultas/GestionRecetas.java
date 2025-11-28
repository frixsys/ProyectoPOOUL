/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionConsultas;

/**
 *
 * @author santiago
 */
public class GestionRecetas {
    private RecetaMedica[] recetas;
    private int contador;

    public GestionRecetas(int capacidad) {
        recetas = new RecetaMedica[capacidad];
        contador = 0;
    }

    public String agregar(RecetaMedica r) {
        if (contador < recetas.length) {
            recetas[contador++] = r;
            return "Receta agregada al catálogo.";
        }
        return "Error: No hay espacio.";
    }

    public void eliminar(int index) {
        if (index >= 0 && index < contador) {
            for (int i = index; i < contador - 1; i++) {
                recetas[i] = recetas[i+1];
            }
            recetas[--contador] = null;
        }
    }

    public RecetaMedica[] listar() {
        return recetas;
    }

    public int cantidad() {
        return contador;
    }
}
