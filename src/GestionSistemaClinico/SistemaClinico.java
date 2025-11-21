package GestionSistemaClinico;

import GestionDePacientes.GestionPacientes;
import GestionDeEmpleados.GestionEmpleados;
import GestionDeConsultorios.gestionConsultorio;
import GestionDeConsultorios.GestionCitas;
import GestionDeFacturacion.GestionFacturas;

// Importa tus clases modelo:
import GestionDePacientes.Paciente;
import GestionDeEmpleados.Empleado;
import GestionDeConsultorios.Consultorio;
import GestionDeConsultorios.Cita;
import GestionDeFacturacion.Factura;

public class SistemaClinico {
    private GestionPacientes gestionPacientes;
    private GestionEmpleados gestionEmpleados;
    private gestionConsultorio gestionConsultorios;
    private GestionCitas gestionCitas;
    private GestionFacturas gestionFacturas;
    public SistemaClinico() {
        gestionPacientes = new GestionPacientes(200);
        gestionEmpleados = new GestionEmpleados(100);
        gestionConsultorios = new gestionConsultorio(50);
        gestionCitas = new GestionCitas(200);
        gestionFacturas = new GestionFacturas(100);
    }
    public boolean agregarPaciente(Paciente p) {
        return gestionPacientes.crearPaciente(p);
    }

    public Paciente buscarPaciente(String dni) {
        return gestionPacientes.buscar(dni);
    }

    public Paciente[] listarPacientes() {
        return gestionPacientes.listar();
    }

    public int cantidadPacientes() {
        return gestionPacientes.cantidad();
    }
    public String agregarEmpleado(Empleado e) {
        return gestionEmpleados.crearEmpleado(e);
    }

    public Empleado buscarEmpleado(String dni) {
        return gestionEmpleados.buscarPorDni(dni);
    }

    public Empleado[] listarEmpleados() {
        return gestionEmpleados.listar();
    }
    public String agregarConsultorio(Consultorio c) {
        return gestionConsultorios.crearConsultorio(c);
    }

    public Consultorio[] listarConsultorios() {
        return gestionConsultorios.listar();
    }
    public String crearCita(Cita c) {
        return gestionCitas.agregar(c);
    }

    public String modificarCita(int i, String estado) {
        return gestionCitas.modificar(i, estado);
    }

    public Cita[] listarCitas() {
        return gestionCitas.listar();
    }
    public String crearFactura(Factura f) {
        return gestionFacturas.crearFactura(f);
    }

    public Factura[] listarFacturas() {
        return gestionFacturas.listar();
    }
}
