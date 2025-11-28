/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;
import GestionConsultas.Consultas;
import GestionConsultas.OrdenLaboratorio;
import GestionDeConsultorios.Cita;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
/**
 *
 * @author santiago
 */
public class gestorConsultaPanel extends javax.swing.JPanel {
    private DefaultTableModel modeloTabla;
    private DefaultTableModel modeloLab;
    
    private OrdenLaboratorio[] ordenesTemp;
    private int contOrdenesTemp;

    /**
     * Creates new form gestionConsulta
     */
    public gestorConsultaPanel() {
        initComponents();
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Paciente");
        modeloTabla.addColumn("Motivo");
        modeloTabla.addColumn("Diagnóstico");
        modeloTabla.addColumn("Total (S/)");
        modeloTabla.addColumn("Estado");
        this.jtConsultas.setModel(modeloTabla);
        
        modeloLab = new DefaultTableModel();
        modeloLab.addColumn("Examen");
        modeloLab.addColumn("Precio");
        this.jtLaboratorio.setModel(modeloLab);
        
        ordenesTemp = new OrdenLaboratorio[10];
        contOrdenesTemp = 0;
        
        cargarCitasPendientes();
        cargarCatalogoOrdenes();
        cargarTablaConsultas();
        limpiarCampos();
    }
    
    public void recibirReceta(String textoReceta) {
        jcbReceta.removeAllItems();
        jcbReceta.addItem(textoReceta);
        jcbReceta.setSelectedIndex(0);
    }
    
    public void cargarCatalogoOrdenes() {
        jcbOrden.removeAllItems();
        jcbOrden.addItem("-- Seleccione Examen --");
        jcbOrden.addItem("Hemograma Completo");
        jcbOrden.addItem("Examen de Orina");
        jcbOrden.addItem("Glucosa");
        jcbOrden.addItem("Perfil Lipídico");
        jcbOrden.addItem("Rayos X Tórax");
        jcbOrden.addItem("Ecografía Abdominal");
    }
    
    public void cargarCitasPendientes() {
        jcbCitasPendientes.removeAllItems();
        jcbCitasPendientes.addItem("-- Seleccione una Cita --");
        
        Cita[] citas = SistemaClinico.gestionCitas.listar();
        int total = SistemaClinico.gestionCitas.cantidad();
        
        for (int i = 0; i < total; i++) {
            String estado = citas[i].getEstado();
            if (!"Atendida".equals(estado) && !"Cancelada".equals(estado)) {
                String item = i + " - " + citas[i].getPaciente().getNombre() + " (" + citas[i].getFechaHora() + ")";
                jcbCitasPendientes.addItem(item);
            }
        }
    }
    
    public void cargarComboRecetas() {
        jcbReceta.removeAllItems();
        jcbReceta.addItem("Sin Receta");
        
        GestionConsultas.RecetaMedica[] lista = SistemaClinico.listarRecetas();
        for (int i = 0; i < SistemaClinico.cantidadRecetas(); i++) {
            jcbReceta.addItem(lista[i].toString());
        }
    }
    
    public void cargarTablaConsultas() {
        int filas = this.jtConsultas.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloTabla.removeRow(0);
        }

        Consultas[] lista = SistemaClinico.gestionConsulta.listar();
        
        int cantidad = SistemaClinico.cantidadConsultas();
        
        String[] datos = new String[5];
        for (int i = 0; i < cantidad; i++) {
            datos[0] = lista[i].getCita().getPaciente().getNombre();
            datos[1] = lista[i].getMotivo();
            datos[2] = lista[i].getDiagnostico();
            datos[3] = String.valueOf(lista[i].getPrecioTotal());
            datos[4] = lista[i].getEstado();
            
            modeloTabla.addRow(datos);
        }
    }
    
    public void limpiarCampos() {
        jtMotivo.setText("");
        jtDiagnostico.setText("");
        jtPrecio.setText("");
        jcbReceta.removeAllItems();
        jcbReceta.addItem("Sin Receta");

        jtPrecioLab.setText("");
        if(jcbOrden.getItemCount() > 0) jcbOrden.setSelectedIndex(0);
        modeloLab.setRowCount(0);
        contOrdenesTemp = 0;

        cargarCitasPendientes();
        if (jcbCitasPendientes.getItemCount() > 0) {
            jcbCitasPendientes.setSelectedIndex(0);
        }

        configurarCampos(true);
        bVerConsulta.setText("Ver");
        bRegistrarConsulta.setEnabled(true);
        bEliminarConsulta.setEnabled(true);
    }
    
    public void configurarCampos(boolean habilitar) {
        jtMotivo.setEnabled(habilitar);
        jtDiagnostico.setEnabled(habilitar);
        jtPrecio.setEnabled(habilitar);
        jcbCitasPendientes.setEnabled(habilitar);
        
        jcbOrden.setEnabled(habilitar);
        jtPrecioLab.setEnabled(habilitar);
        bRegistrarLab.setEnabled(habilitar);
        bEliminarLab.setEnabled(habilitar);
        
        bRecetas.setEnabled(habilitar);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtMotivo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtDiagnostico = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtPrecio = new javax.swing.JTextField();
        bRegistrarConsulta = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtConsultas = new javax.swing.JTable();
        bVerConsulta = new javax.swing.JButton();
        bEliminarConsulta = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jcbCitasPendientes = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtPrecioLab = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtLaboratorio = new javax.swing.JTable();
        bRecetas = new javax.swing.JButton();
        jcbReceta = new javax.swing.JComboBox<>();
        jcbOrden = new javax.swing.JComboBox<>();
        bRegistrarLab = new javax.swing.JButton();
        bVerLab = new javax.swing.JButton();
        bEliminarLab = new javax.swing.JButton();

        jLabel1.setText("Datos Consulta");

        jLabel2.setText("Motivo");

        jLabel3.setText("Diagnóstico");

        jLabel4.setText("Receta");

        jLabel5.setText("Precio");

        bRegistrarConsulta.setText("Registrar");
        bRegistrarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegistrarConsultaActionPerformed(evt);
            }
        });

        jtConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jtConsultas);

        bVerConsulta.setText("Ver");
        bVerConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVerConsultaActionPerformed(evt);
            }
        });

        bEliminarConsulta.setText("Eliminar");
        bEliminarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarConsultaActionPerformed(evt);
            }
        });

        jLabel6.setText("Cita");

        jLabel7.setText("S/");

        jLabel8.setText("Orden Laboratorio");

        jLabel9.setText("Tipo Muestra");

        jLabel10.setText("Precio");

        jLabel11.setText("S/");

        jtLaboratorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jtLaboratorio);

        bRecetas.setText("Gestion Receta");
        bRecetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRecetasActionPerformed(evt);
            }
        });

        bRegistrarLab.setText("Registrar");
        bRegistrarLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegistrarLabActionPerformed(evt);
            }
        });

        bVerLab.setText("Ver");
        bVerLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVerLabActionPerformed(evt);
            }
        });

        bEliminarLab.setText("Eliminar");
        bEliminarLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarLabActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(jtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(148, 148, 148))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jtPrecioLab, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11))
                                    .addComponent(jcbOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bRegistrarLab))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(bRecetas)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jcbReceta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jcbCitasPendientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(148, 148, 148)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jtDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bRegistrarConsulta)))))
                        .addGap(27, 27, 27)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bVerConsulta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bEliminarConsulta))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bVerLab)
                        .addGap(300, 300, 300)
                        .addComponent(bEliminarLab))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(bRecetas)
                            .addComponent(jcbReceta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(bRegistrarConsulta)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bEliminarConsulta)
                            .addComponent(bVerConsulta))))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jcbCitasPendientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jcbOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(bRegistrarLab)
                                .addGap(1, 1, 1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jtPrecioLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bEliminarLab)
                    .addComponent(bVerLab))
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bRegistrarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegistrarConsultaActionPerformed
        // TODO add your handling code here:
        try {
            if (jcbCitasPendientes.getSelectedIndex() <= 0) {
                JOptionPane.showMessageDialog(this, "Seleccione una Cita.");
                return;
            }
            if (jtMotivo.getText().isEmpty() || jtDiagnostico.getText().isEmpty() || jtPrecio.getText().isEmpty()) {
                 JOptionPane.showMessageDialog(this, "Complete los datos principales.");
                 return;
            }

            String item = (String) jcbCitasPendientes.getSelectedItem();
            int indexCita = Integer.parseInt(item.split(" - ")[0]);
            Cita citaOriginal = SistemaClinico.gestionCitas.listar()[indexCita];
            
            double precioBase = Double.parseDouble(jtPrecio.getText());
            String recetaFinal = (String) jcbReceta.getSelectedItem();
            if (recetaFinal == null) recetaFinal = "Sin Receta";

            Consultas nuevaConsulta = new Consultas(
                jtMotivo.getText(), 
                jtDiagnostico.getText(), 
                recetaFinal, 
                precioBase, 
                citaOriginal
            );

            for(int i = 0; i < contOrdenesTemp; i++) {
                nuevaConsulta.agregarOrden(ordenesTemp[i]);
            }

            String mensaje = SistemaClinico.agregarConsultas(nuevaConsulta);
            SistemaClinico.modificarCita(indexCita, "Atendida");
            
            JOptionPane.showMessageDialog(this, "Consulta registrada. Total a pagar: S/" + nuevaConsulta.getPrecioTotal());
            
            if (!mensaje.startsWith("ERROR")) {
                limpiarCampos();  
                cargarTablaConsultas();
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El precio debe ser numérico.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_bRegistrarConsultaActionPerformed

    private void bVerConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVerConsultaActionPerformed
        // TODO add your handling code here:
        if (bVerConsulta.getText().equals("Ver")) {
            int fila = jtConsultas.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione una consulta del historial.");
                return;
            }

            Consultas[] lista = SistemaClinico.listarConsultas();
            Consultas c = lista[fila];

            if (c != null) {
                jtMotivo.setText(c.getMotivo());
                jtDiagnostico.setText(c.getDiagnostico());
                jtPrecio.setText(String.valueOf(c.getPrecio()));

                jcbReceta.removeAllItems();
                jcbReceta.addItem(c.getReceta());
                
                modeloLab.setRowCount(0);
                for (OrdenLaboratorio ord : c.getOrdenes()) {
                    if (ord != null) {
                        modeloLab.addRow(new Object[]{ord.getTipoMuestra(), ord.getPrecio()});
                    }
                }

                configurarCampos(false);
                bVerConsulta.setText("Dejar de ver");
                bEliminarConsulta.setEnabled(false); 
            }
        } else {
            limpiarCampos();
        }
    }//GEN-LAST:event_bVerConsultaActionPerformed

    private void bEliminarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarConsultaActionPerformed
        // TODO add your handling code here:
        int fila = jtConsultas.getSelectedRow();
        if (fila == -1) {
             JOptionPane.showMessageDialog(this, "Seleccione una consulta para eliminar.");
             return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar registro?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String mensaje = SistemaClinico.eliminarConsulta(fila);
            JOptionPane.showMessageDialog(this, mensaje);
            if (!mensaje.startsWith("ERROR")) {
                cargarTablaConsultas();
                limpiarCampos();
            }
        }
    }//GEN-LAST:event_bEliminarConsultaActionPerformed

    private void bRegistrarLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegistrarLabActionPerformed
        // TODO add your handling code here:
        try {
            if (jcbOrden.getSelectedIndex() == 0) {
                 JOptionPane.showMessageDialog(this, "Seleccione un tipo de examen.");
                 return;
            }
            
            String nombreExamen = (String) jcbOrden.getSelectedItem();
            String precioTexto = jtPrecioLab.getText();
            
            if (precioTexto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el precio del examen.");
                return;
            }
            
            double precioExamen = Double.parseDouble(precioTexto);
            
            if (contOrdenesTemp < ordenesTemp.length) {
                OrdenLaboratorio orden = new OrdenLaboratorio(nombreExamen, precioExamen);
                ordenesTemp[contOrdenesTemp] = orden;
                contOrdenesTemp++;

                modeloLab.addRow(new Object[]{nombreExamen, precioExamen});

                jtPrecioLab.setText("");
                
            } else {
                JOptionPane.showMessageDialog(this, "Límite de órdenes alcanzado (10).");
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un número.");
        }
    }//GEN-LAST:event_bRegistrarLabActionPerformed

    private void bVerLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVerLabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bVerLabActionPerformed

    private void bEliminarLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarLabActionPerformed
        // TODO add your handling code here:
        int fila = jtLaboratorio.getSelectedRow();
        if (fila >= 0) {
            modeloLab.removeRow(fila);

            for (int i = fila; i < contOrdenesTemp - 1; i++) {
                ordenesTemp[i] = ordenesTemp[i+1];
            }
            ordenesTemp[--contOrdenesTemp] = null;
        } else {
             JOptionPane.showMessageDialog(this, "Seleccione una orden para quitar.");
        }
    }//GEN-LAST:event_bEliminarLabActionPerformed

    private void bRecetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRecetasActionPerformed
        // TODO add your handling code here:
        Recetas ventana = new Recetas();

        ventana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                cargarComboRecetas();
            }
        });
        
        ventana.setVisible(true);
    }//GEN-LAST:event_bRecetasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEliminarConsulta;
    private javax.swing.JButton bEliminarLab;
    private javax.swing.JButton bRecetas;
    private javax.swing.JButton bRegistrarConsulta;
    private javax.swing.JButton bRegistrarLab;
    private javax.swing.JButton bVerConsulta;
    private javax.swing.JButton bVerLab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> jcbCitasPendientes;
    private javax.swing.JComboBox<String> jcbOrden;
    private javax.swing.JComboBox<String> jcbReceta;
    private javax.swing.JTable jtConsultas;
    private javax.swing.JTextField jtDiagnostico;
    private javax.swing.JTable jtLaboratorio;
    private javax.swing.JTextField jtMotivo;
    private javax.swing.JTextField jtPrecio;
    private javax.swing.JTextField jtPrecioLab;
    // End of variables declaration//GEN-END:variables
}
