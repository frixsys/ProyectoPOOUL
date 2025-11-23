
package GestionDeFacturacion;

public class GestionFacturas {

    private Factura[] facturas;
    private int contador;

    public GestionFacturas(int capacidad) {
        facturas = new Factura[capacidad];
        contador = 0;
    }
    public String crearFactura(Factura f) {
        if (contador >= facturas.length) {
            return "ERROR: No se pueden agregar más facturas.";
        }
        
        facturas[contador++] = f;
        return "Factura creada correctamente.";
    }
    public String eliminarFactura(int numero) {
        for (int i = 0; i < contador; i++) {
            if (facturas[i].getNumero() == numero) {
                facturas[i] = facturas[contador - 1];
                facturas[contador - 1] = null;
                contador--;
                return "Factura eliminada correctamente.";
            }
        }
        return "ERROR: Factura no encontrada.";
    }
    public Factura[] listar() {
        return facturas;
    }
    public int cantidad() {
        return contador;
        
    }
    
    public Factura buscarFactura(int numero) {
        for (int i = 0; i < contador; i++) {
            if (facturas[i].getNumero() == numero) {
                return facturas[i];
            }
        }
        return null;
    }

    public String modificarFactura(int numero, String nuevaDescripcion, double nuevoMonto) {
        Factura f = buscarFactura(numero);
        if (f == null) {
            return "ERROR: Factura no encontrada.";
        }
        f.setDescripcion(nuevaDescripcion);
        f.setMonto(nuevoMonto);
        return "Factura modificada correctamente.";
    }
}