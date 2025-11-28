package Vista;

import GestionDePacientes.GestionPacientes;
import GestionDeEmpleados.GestionEmpleados;
import GestionDeConsultorios.gestionConsultorio;
import GestionDeConsultorios.GestionCitas;
import GestionDeFacturacion.GestionFacturas;
import GestionConsultas.GestionConsulta;
import GestionDePacientes.Paciente;
import GestionDeEmpleados.Empleado;
import GestionDeConsultorios.Consultorio;
import GestionDeConsultorios.Cita;
import GestionDeFacturacion.Factura;
import GestionConsultas.Consultas;
import GestionConsultas.GestionRecetas;
import GestionConsultas.RecetaMedica;

public class SistemaClinico {
    static GestionPacientes gestionPacientes;
    static GestionEmpleados gestionEmpleados;
    static gestionConsultorio gestionConsultorios;
    static GestionCitas gestionCitas;
    static GestionFacturas gestionFacturas;
    static GestionConsulta gestionConsulta; 
    static GestionRecetas gestionRecetas;
    public SistemaClinico() {}
    
    public static void inicializarvariable() {
        if (gestionEmpleados == null) {
            
            gestionPacientes = new GestionPacientes(200);
            gestionEmpleados = new GestionEmpleados(100);
            gestionConsultorios = new gestionConsultorio(50);
            gestionCitas = new GestionCitas(200);
            gestionFacturas = new GestionFacturas(100);
            gestionConsulta = new GestionConsulta(100);
            gestionRecetas = new GestionRecetas(100);
            
            // SUPERUSUARIO
            GestionDeEmpleados.Administrador admin = new GestionDeEmpleados.Administrador(
                    "00000000", "Super", "Admin", "000", "admin@clinica.com", 
                    "admin", "admin", "Administrador"
            );
            gestionEmpleados.crearEmpleado(admin);
            
            // DATOS DE PRUEBAA
            GestionDeEmpleados.Medico medico1 = new GestionDeEmpleados.Medico(
                    "Medicina General", "11111111", "Gregory", "House", "999111222", "house@clinica.com",
                    "123", "123", "Médico"
            );
            gestionEmpleados.crearEmpleado(medico1);

            GestionDeEmpleados.Cajero cajero1 = new GestionDeEmpleados.Cajero(
                    "22222222", "Don", "Cangrejo", "999333444", "cajero@clinica.com",
                    "cajero", "123", "Cajero"
            );
            gestionEmpleados.crearEmpleado(cajero1);

            GestionDeEmpleados.Recepcionista recep1 = new GestionDeEmpleados.Recepcionista(
                    "33333333", "Pam", "Beesly", "999555666", "pam@clinica.com",
                    "recep", "123", "Recepcionista"
            );
            gestionEmpleados.crearEmpleado(recep1);

            GestionDePacientes.Paciente paciente1 = new GestionDePacientes.Paciente(
                    "10/05/1990", "Masculino", "999-EMERGENCIA", 
                    "44444444", "Juan", "Perez", "987654321", "juan@gmail.com"
            );
            gestionPacientes.crearPaciente(paciente1);

            GestionDePacientes.Paciente paciente2 = new GestionDePacientes.Paciente(
                    "25/12/1985", "Femenino", "999-MAMA", 
                    "55555555", "Maria", "Gomez", "912345678", "maria@hotmail.com"
            );
            gestionPacientes.crearPaciente(paciente2);

            Consultorio cons1 = new Consultorio(101, "Medicina General", "Disponible");
            boolean[] horario = {true, true, true, true, true, true, true}; 
            cons1.setHorarioDisponible(horario);
            gestionConsultorios.crearConsultorio(cons1);

            Consultorio cons2 = new Consultorio(202, "Pediatría", "Ocupado");
            cons2.setHorarioDisponible(horario);
            gestionConsultorios.crearConsultorio(cons2);

            Cita cita1 = new Cita("25/11/2023 10:00", "Programada", paciente1, medico1, cons1);
            gestionCitas.agregar(cita1);

            Cita cita2 = new Cita("20/11/2023 09:00", "Atendida", paciente2, medico1, cons1);
            gestionCitas.agregar(cita2);

            Consultas consulta1 = new Consultas(
                    "Dolor de cabeza", 
                    "Migraña tensional", 
                    "Paracetamol 500mg cada 8h", 
                    50.0, 
                    cita2
            );
            gestionConsulta.agregar(consulta1);

            GestionDeFacturacion.Factura factura1 = new GestionDeFacturacion.Factura(
                    1001, "Consulta Médica - Juan Perez", 80.0
            );
            gestionFacturas.crearFactura(factura1);
        }
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

    public static String modificarCita(int index, String estado) {
        return gestionCitas.modificar(index, estado);
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
    public static String agregarConsultas(Consultas c) {
        return gestionConsulta.agregar(c);
    }
    public static Consultas[] listarConsultas() {
        return gestionConsulta.listar();
    }

    public static String eliminarConsulta(int index) {
        return gestionConsulta.eliminar(index);
    }

    public static int cantidadConsultas() {
        return gestionConsulta.cantidad();
    }
    
    public static String agregarReceta(RecetaMedica r) { 
        return gestionRecetas.agregar(r); 
    }
    public static void eliminarReceta(int i) {
        gestionRecetas.eliminar(i); 
    }
    public static RecetaMedica[] listarRecetas() { 
        return gestionRecetas.listar(); 
    }
    public static int cantidadRecetas() { 
        return gestionRecetas.cantidad(); 
    }
    
}
