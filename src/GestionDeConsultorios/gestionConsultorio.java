/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionDeConsultorios;

/**
 *
 * @author santiago
 */
public class gestionConsultorio {
    private Consultorio[] consultorios;
    private int cont;
    
    public gestionConsultorio(int capacidad) {
        consultorios = new Consultorio[capacidad];
        cont = 0;
    }
    
    public String crearConsultorio(Consultorio c) {
        if (c.getCodigo() <= 0) { 
        return "ERROR: El código no puede ser 0 o negativo.";
    }
        if (buscar(c.getCodigo()) != null) { 
        return "ERROR: Ya existe un consultorio con ese código."; 
    }
        if (cont >= consultorios.length) {
        return "ERROR: No hay espacio para más consultorios."; 
    }
        consultorios[cont++] = c;
        return "Consultorio registrado correctamente.";
    }

    public Consultorio buscar(int codigo) {
        for (int i = 0; i < cont; i++) {
            if (consultorios[i].getCodigo() == codigo) {
                return consultorios[i];
            }
        }
        return null;
    }

    public String modificarConsultorio(int codigo, String nuevaEspecialidad, String nuevoEstado) {
        Consultorio c = buscar(codigo);
        if (c == null) {
            return "ERROR: Consultorio no encontrado.";
        }

        c.setEspecialidad(nuevaEspecialidad);
        c.setEstado(nuevoEstado);
        return "Consultorio modificado correctamente.";
    }


    public String eliminarConsultorio(int codigo) {
        for (int i = 0; i < cont; i++) {
            if (consultorios[i].getCodigo() == codigo) {
                consultorios[i] = consultorios[cont - 1]; 
                consultorios[cont - 1] = null;
                cont--;
                return "Consultorio eliminado correctamente.";
            }
        }
        return "ERROR: Consultorio no encontrado.";
    }

    public Consultorio[] listar() {
        Consultorio[] listaActual = new Consultorio[cont];
        for (int i = 0; i < cont; i++) {
            listaActual[i] = consultorios[i];
        }
        return listaActual;
    }
    
    public int cantidad() {
        return cont;
    }
}
