package GestionDeEmpleados;

public class GestionEmpleados {

    private Empleado[] empleados;
    private int contador;

    public GestionEmpleados(int capacidad) {
        empleados = new Empleado[capacidad];
        contador = 0;
    }
    public String crearEmpleado(Empleado e) {
        if (e.getDni() == null || e.getDni().length() != 8) {
            return "ERROR: DNI inválido (debe tener 8 dígitos).";
        }
        if (buscarPorDni(e.getDni()) != null) {
            return "ERROR: Un empleado con ese DNI ya existe, introduzca un DNI valido.";
        }
        if (buscarPorUsuario(e.getUsuario()) != null) {
            return "ERROR: El nombre de usuario ya está usado.";
        }
        if (contador >= empleados.length) {
            return "ERROR: No hay espacio para más empleados.";
        }
        empleados[contador++] = e;
        return "Empleado registrado correctamente.";
    }
    
    public Empleado buscarPorDni(String dni) {
        for (int i = 0; i < contador; i++) {
            if (empleados[i].getDni().equals(dni)) {
                return empleados[i];
            }
        }
        return null;
    }

    public Empleado buscarPorUsuario(String usuario) {
        for (int i = 0; i < contador; i++) {
            if (empleados[i].getUsuario().equals(usuario)) {
                return empleados[i];
            }
        }
        return null;
    }
    public void eliminarEmpleado(String dni) {
        for (int i = 0; i < contador; i++) {
            if (empleados[i].getDni().equals(dni)) {
                empleados[i] = empleados[contador - 1]; 
                empleados[contador - 1] = null;
                contador-- ;
                return ;
            }
        }
    }

    public String modificarEmpleado(String dni, String nuevoTelefono, String nuevoEmail) {
        Empleado e = buscarPorDni(dni);
        if (e == null) {
            return "ERROR: Empleado no encontrado.";
        }

        e.setTelefono(nuevoTelefono);
        e.setEmail(nuevoEmail);
        return "Empleado modificado correctamente.";
    }
    public Empleado[] listar() {
        return empleados;
    }

    public int cantidad() {
        return contador;
    }
}
