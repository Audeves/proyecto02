/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.CategoriaRepository;
import ObjetosNegocio.Categoria;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class MenuCategoria extends javax.swing.JInternalFrame {

    private CategoriaRepository cR;

    /**
     * Creates new form Producto
     */
    public MenuCategoria() {
        cR = new CategoriaRepository();
        initComponents();
        campoDescripcion.setLineWrap(true);
        campoDescripcion.setWrapStyleWord(true);
        hacerTabla();
    }

    private void hacerTabla() {
        eliminarDatos();
        String[] dato = new String[3];
        DefaultTableModel tb = (DefaultTableModel) tablaCategorias.getModel();
        List<Categoria> categorias = cR.mostrarTodas();
        try {
            for (Categoria categoria : categorias) {
                dato[0] = Integer.toString(categoria.getId());
                dato[1] = categoria.getNombre();
                dato[2] = categoria.getDescripcion();
                tb.addRow(dato);
            }

        } catch (Exception e) {
        }

    }

    private void hacerTablaPorNombre() {
        eliminarDatos();
        String[] dato = new String[3];
        Categoria a = new Categoria();
        a.setNombre(campoBusqueda.getText());
        DefaultTableModel tb = (DefaultTableModel) tablaCategorias.getModel();
        List<Categoria> categorias = cR.buscarPorNombre(a);
        try {
           for (Categoria categoria : categorias) {
                dato[0] = Integer.toString(categoria.getId());
                dato[1] = categoria.getNombre();
                dato[2] = categoria.getDescripcion();
                tb.addRow(dato);
            }
        } catch (Exception e) {
        }
    }
    
    private void validarLetras(java.awt.event.KeyEvent evt, int longitud,String mensaje,String textoCompleto) {

        String letra = String.valueOf(evt.getKeyChar());
        if (!letra.matches("[a-z A-Z\b]") || textoCompleto.length()>= longitud) {
            evt.consume();
            JOptionPane.showMessageDialog(this, mensaje, "Codigo de informacion", INFORMATION_MESSAGE);
        }
    }
    
    /**
     * 
     */
    private void hacerTablaPorID() {
        eliminarDatos();
        String[] dato = new String[3];
        Categoria a = new Categoria();
        a.setId(Integer.parseInt(campoBusqueda.getText()));
        DefaultTableModel tb = (DefaultTableModel) tablaCategorias.getModel();
        Categoria categoria = cR.buscarPorId(a);
        try {
            dato[0] = Integer.toString(categoria.getId());
            dato[1] = categoria.getNombre();
            dato[2] = categoria.getDescripcion();
            tb.addRow(dato);
        } catch (Exception e) {
        }
    }
    
        private void hacerTablaPorDescripcion() {
        eliminarDatos();
        String[] dato = new String[3];
        DefaultTableModel tb = (DefaultTableModel) tablaCategorias.getModel();
        List<Categoria> categorias = cR.buscarPorDescripcion(campoBusqueda.getText());
        try {
            for (Categoria categoria : categorias) {
                dato[0] = Integer.toString(categoria.getId());
                dato[1] = categoria.getNombre();
                dato[2] = categoria.getDescripcion();
                tb.addRow(dato);
            }
        } catch (Exception e) {
        }
    }
        
//        
        
    


    public void eliminarDatos() {
        DefaultTableModel tb = (DefaultTableModel) tablaCategorias.getModel();
        tb.setRowCount(0);

        //cargaTicket();
    }
    private void validarNumero(java.awt.event.KeyEvent evt, int longitud, String mensaje,String textoCompleto) {

        String letra = String.valueOf(evt.getKeyChar());
        if (!letra.matches("[0-9\b]") || textoCompleto.length() >= longitud) {
            evt.consume();
            JOptionPane.showMessageDialog(this, mensaje, "Codigo de informacion", INFORMATION_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        campoID = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        campoBusqueda = new javax.swing.JTextField();
        opcionBusqueda = new javax.swing.JComboBox<>();
        jScrollPaneTabla = new javax.swing.JScrollPane();
        tablaCategorias = new javax.swing.JTable();
        buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoDescripcion = new javax.swing.JTextArea();
        agregar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Ventana Categoria");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/categoria.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(1300, 445));
        setPreferredSize(new java.awt.Dimension(1300, 445));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("ID Categoría");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("Nombre*");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("Descripción");

        campoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNombreKeyTyped(evt);
            }
        });

        campoID.setEditable(false);
        campoID.setEnabled(false);
        campoID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoIDActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscador de Categorias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        campoBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoBusquedaKeyTyped(evt);
            }
        });

        opcionBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ID", "Nombre", "Descripcion" }));

        jScrollPaneTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPaneTablaMouseClicked(evt);
            }
        });

        tablaCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCategorias.getTableHeader().setReorderingAllowed(false);
        tablaCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCategoriasMouseClicked(evt);
            }
        });
        jScrollPaneTabla.setViewportView(tablaCategorias);
        if (tablaCategorias.getColumnModel().getColumnCount() > 0) {
            tablaCategorias.getColumnModel().getColumn(0).setResizable(false);
            tablaCategorias.getColumnModel().getColumn(1).setResizable(false);
            tablaCategorias.getColumnModel().getColumn(2).setResizable(false);
        }

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(campoBusqueda)
                        .addGap(18, 18, 18)
                        .addComponent(opcionBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPaneTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opcionBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar))
                .addGap(8, 8, 8)
                .addComponent(jScrollPaneTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        campoDescripcion.setColumns(20);
        campoDescripcion.setRows(5);
        campoDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoDescripcionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(campoDescripcion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(campoID, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNombre)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, 0)
                        .addComponent(campoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel13)
                        .addGap(0, 0, 0)
                        .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addGap(0, 0, 0))
        );

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        actualizar.setText("Actualizar");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(agregar)
                .addGap(20, 20, 20)
                .addComponent(eliminar)
                .addGap(20, 20, 20)
                .addComponent(actualizar)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar)
                    .addComponent(eliminar)
                    .addComponent(actualizar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoIDActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
        Categoria a = new Categoria();
        a.setId(Integer.parseInt(campoID.getText()));
        cR.eliminar(a);
        hacerTabla();

    }//GEN-LAST:event_eliminarActionPerformed

    private void jScrollPaneTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPaneTablaMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jScrollPaneTablaMouseClicked

    private void tablaCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCategoriasMouseClicked
        try {
            int fila = tablaCategorias.getSelectedRow();
            campoID.setText(tablaCategorias.getModel().getValueAt(fila, 0).toString());
            campoNombre.setText(tablaCategorias.getModel().getValueAt(fila, 1).toString());
            campoDescripcion.setText(tablaCategorias.getModel().getValueAt(fila, 2).toString());

        } catch (Exception e) {
        }
    }//GEN-LAST:event_tablaCategoriasMouseClicked

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        Categoria a = new Categoria(campoNombre.getText(), campoDescripcion.getText());
        a.setId(Integer.parseInt(campoID.getText()));
        cR.actualizar(a);
        hacerTabla();
    }//GEN-LAST:event_actualizarActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        // TODO add your handling code here:
        Categoria a = new Categoria(campoNombre.getText(), campoDescripcion.getText());
        // a.setNombre(jTextField12.getText());
        cR.agregar(a);
        hacerTabla();
    }//GEN-LAST:event_agregarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        try {
            switch (opcionBusqueda.getSelectedItem().toString()) {
                case "Todos":
                    hacerTabla();
                    break;
                case "ID":
                    hacerTablaPorID();
                    break;
                case "Nombre":
                    hacerTablaPorNombre();
                    break;
                case "Descripcion":
                    hacerTablaPorDescripcion();
                    break;

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void campoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNombreKeyTyped
        validarLetras(evt, 45, "Solo se pueden poner caracteres en este campo", campoNombre.getText());
    }//GEN-LAST:event_campoNombreKeyTyped

    private void campoBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBusquedaKeyTyped
         try {
            switch (opcionBusqueda.getSelectedItem().toString()) {
                case "Todos":
                   // hacerTabla();
                    break;
                case "ID":
                    validarNumero(evt, 11, "Solo se pueden poner numeros en este campo", campoBusqueda.getText());
                    break;
                case "Nombre":
                    validarLetras(evt, 45, "Solo se pueden poner caracteres en este campo", campoBusqueda.getText());
                    break;
                case "Descripcion":
                    if (campoBusqueda.getText().length()>=100) {
                        JOptionPane.showMessageDialog(this, "Has sobrepasado los caracteres que se pueden poner", "Codigo de confirmacion", INFORMATION_MESSAGE);
                    }
                    break;

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_campoBusquedaKeyTyped

    private void campoDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDescripcionKeyTyped
       if (campoDescripcion.getText().length()>=100) {
                        JOptionPane.showMessageDialog(this, "Has sobrepasado los caracteres que se pueden poner", "Codigo de confirmacion", INFORMATION_MESSAGE);
                        evt.consume();
                    }
    }//GEN-LAST:event_campoDescripcionKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JButton agregar;
    private javax.swing.JButton buscar;
    private javax.swing.JTextField campoBusqueda;
    private javax.swing.JTextArea campoDescripcion;
    private javax.swing.JTextField campoID;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneTabla;
    private javax.swing.JComboBox<String> opcionBusqueda;
    private javax.swing.JTable tablaCategorias;
    // End of variables declaration//GEN-END:variables
}
