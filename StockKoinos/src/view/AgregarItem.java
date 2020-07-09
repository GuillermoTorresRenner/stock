/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControladorStock;
import javax.swing.JOptionPane;
import model.Categoria;
import model.Marca;
import model.Subcategoria;

/**
 *
 * @author guille
 */
public class AgregarItem extends javax.swing.JInternalFrame {

    Categoria categoria;
    Subcategoria subcategoria;
    Marca marca;
    ControladorStock cs;
    String n="", c="", sc="", ma="", mo="", codigo="";

    public AgregarItem() {
        initComponents();
        this.setSize(1200, 800);
        this.setTitle("Agregar Ítem");
        this.setVisible(true);
        cs = new ControladorStock();

        //inicialización de combos
        actualizarCbCategoria();
        actualizarCbSubcategoria();
       actualizarCbMarca();
        
        txtNombre.setText("");
    }

    //Declaración de métodos de la clase
    private void actualizarCbCategoria() {
        cbCategoria.removeAllItems();
        cbCategoria.setModel(cs.dameComboCategorias());
    }

    private void actualizarCbSubcategoria() {
        cbSubcategoria.removeAllItems();
        cbSubcategoria.setModel(cs.dameComboSubCategorias());
    }

    private void actualizarCbMarca() {
        cbMarca.removeAllItems();
        cbMarca.setModel(cs.dameComboMarcas());
        
    }
        
        
     private void dameCodigo(){
         
     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rbAutogenerarCodigo = new javax.swing.JRadioButton();
        rbIntroducirPistola = new javax.swing.JRadioButton();
        cbSubcategoria = new javax.swing.JComboBox<>();
        cbCategoria = new javax.swing.JComboBox<>();
        cbMarca = new javax.swing.JComboBox<>();
        txtModelo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAgregarSubcategoría = new javax.swing.JButton();
        btnAgregarCategoria = new javax.swing.JButton();
        btnAgregarMarca = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        rbAutogenerarNombre = new javax.swing.JRadioButton();
        rbEscribirManual = new javax.swing.JRadioButton();

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setText("Código Ítem: ");
        jLabel2.setToolTipText("Código de Barra");
        jLabel2.setEnabled(false);

        txtCodigo.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setText("Categoría:");
        jLabel3.setToolTipText("Código de Barra");
        jLabel3.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setText("Sub Categoría:");
        jLabel4.setToolTipText("Código de Barra");
        jLabel4.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel5.setText("Marca:");
        jLabel5.setToolTipText("Código de Barra");
        jLabel5.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel6.setText("Modelo:");
        jLabel6.setToolTipText("Código de Barra");
        jLabel6.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel7.setText("Descripción:");
        jLabel7.setToolTipText("Código de Barra");
        jLabel7.setEnabled(false);

        buttonGroup1.add(rbAutogenerarCodigo);
        rbAutogenerarCodigo.setSelected(true);
        rbAutogenerarCodigo.setText("Autogenerar");
        rbAutogenerarCodigo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbAutogenerarCodigoStateChanged(evt);
            }
        });
        rbAutogenerarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAutogenerarCodigoActionPerformed(evt);
            }
        });
        rbAutogenerarCodigo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                rbAutogenerarCodigoPropertyChange(evt);
            }
        });

        buttonGroup1.add(rbIntroducirPistola);
        rbIntroducirPistola.setText("Introducir con pistola");
        rbIntroducirPistola.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbIntroducirPistolaStateChanged(evt);
            }
        });

        cbSubcategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbSubcategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSubcategoriaItemStateChanged(evt);
            }
        });

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCategoriaItemStateChanged(evt);
            }
        });

        cbMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMarcaItemStateChanged(evt);
            }
        });

        txtModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtModeloKeyTyped(evt);
            }
        });

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sinImagen.png"))); // NOI18N
        jLabel1.setIconTextGap(1);

        jButton1.setText("Buscar");

        btnGuardar.setText("Guardar Registro");

        btnLimpiar.setText("Limpiar Campos");

        btnCancelar.setText("Cancelar");

        btnAgregarSubcategoría.setText("Agregar");
        btnAgregarSubcategoría.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarSubcategoríaActionPerformed(evt);
            }
        });

        btnAgregarCategoria.setText("Agregar");
        btnAgregarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCategoriaActionPerformed(evt);
            }
        });

        btnAgregarMarca.setText("Agregar");
        btnAgregarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMarcaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel8.setText("Nombre:");
        jLabel8.setToolTipText("Código de Barra");
        jLabel8.setEnabled(false);

        txtNombre.setEditable(false);

        buttonGroup2.add(rbAutogenerarNombre);
        rbAutogenerarNombre.setSelected(true);
        rbAutogenerarNombre.setText("Autogenerar");

        buttonGroup2.add(rbEscribirManual);
        rbEscribirManual.setText("Escribir Manualmente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rbAutogenerarCodigo)
                            .addComponent(rbAutogenerarNombre))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbEscribirManual)
                            .addComponent(rbIntroducirPistola)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtModelo)
                            .addComponent(jScrollPane1)
                            .addComponent(btnGuardar)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbCategoria, 0, 447, Short.MAX_VALUE)
                            .addComponent(cbSubcategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnCancelar)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(143, 143, 143))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnAgregarSubcategoría)
                                            .addComponent(btnAgregarCategoria)
                                            .addComponent(btnAgregarMarca))
                                        .addGap(64, 64, 64))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbAutogenerarCodigo)
                    .addComponent(rbIntroducirPistola))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbAutogenerarNombre)
                    .addComponent(rbEscribirManual))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarCategoria))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbSubcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarSubcategoría))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarMarca))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnLimpiar)
                            .addComponent(btnCancelar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbAutogenerarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAutogenerarCodigoActionPerformed

    }//GEN-LAST:event_rbAutogenerarCodigoActionPerformed

    private void rbAutogenerarCodigoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_rbAutogenerarCodigoPropertyChange

    }//GEN-LAST:event_rbAutogenerarCodigoPropertyChange

    private void rbIntroducirPistolaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbIntroducirPistolaStateChanged
        if (rbIntroducirPistola.isSelected()) {
            txtCodigo.setEditable(true);
            txtCodigo.requestFocus();
        } else {
            txtCodigo.setEditable(false);
        }
    }//GEN-LAST:event_rbIntroducirPistolaStateChanged

    private void rbAutogenerarCodigoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbAutogenerarCodigoStateChanged
        if (rbAutogenerarCodigo.isSelected()) {
            txtCodigo.setEditable(false);
        } else {
            txtCodigo.setEditable(true);
            txtCodigo.requestFocus();
        }
    }//GEN-LAST:event_rbAutogenerarCodigoStateChanged

    private void btnAgregarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCategoriaActionPerformed
        String c = JOptionPane.showInputDialog(null, "Introduzca nueva CATEGORÍA", "AGREGAR CATEGORIA", JOptionPane.OK_CANCEL_OPTION).toUpperCase();
        if (c != null) {
            int o = JOptionPane.showConfirmDialog(null, "Se creará la Categoria: " + c, "confirmación de creación", JOptionPane.OK_CANCEL_OPTION);
            if (o == JOptionPane.YES_OPTION) {
                categoria = new Categoria(c);
                cs.agregarCategoria(categoria);
                actualizarCbCategoria();
                cbCategoria.setSelectedItem(c);
            }

        }
    }//GEN-LAST:event_btnAgregarCategoriaActionPerformed

    private void btnAgregarSubcategoríaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarSubcategoríaActionPerformed
        String sc = JOptionPane.showInputDialog(null, "Introduzca nueva SUBCATEGORÍA", "AGREGAR CATEGORIA", JOptionPane.OK_CANCEL_OPTION).toUpperCase();
        if (sc != null) {
            int o = JOptionPane.showConfirmDialog(null, "Se creará la SubCategoria: " + sc, "confirmación de creación", JOptionPane.OK_CANCEL_OPTION);
            if (o == JOptionPane.YES_OPTION) {
                subcategoria = new Subcategoria(sc);
                cs.agregarSubCategoria(subcategoria);
                actualizarCbSubcategoria();
                cbSubcategoria.setSelectedItem(sc);
            }
        }
    }//GEN-LAST:event_btnAgregarSubcategoríaActionPerformed

    private void btnAgregarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMarcaActionPerformed
        String m = JOptionPane.showInputDialog(null, "Introduzca nueva MARCA", "AGREGAR CATEGORIA", JOptionPane.OK_CANCEL_OPTION).toUpperCase();
        if (m != null) {
            int o = JOptionPane.showConfirmDialog(null, "Se creará la Marca " + m, "confirmación de creación", JOptionPane.OK_CANCEL_OPTION);
            if (o == JOptionPane.YES_OPTION) {
                marca = new Marca(m);
                cs.agregarMarca(marca);
                actualizarCbMarca();
                cbMarca.setSelectedItem(m);

            }

        }
    }//GEN-LAST:event_btnAgregarMarcaActionPerformed

    private void cbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCategoriaItemStateChanged
        if (rbAutogenerarNombre.isSelected()) {
              txtNombre.setText("");
        c = String.valueOf(cbCategoria.getSelectedItem());
        n = c + " " + sc + " " + ma + " " + mo;
        txtNombre.setText(n);
        }else{
            txtNombre.setText("");
        }

    }//GEN-LAST:event_cbCategoriaItemStateChanged

    private void cbSubcategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSubcategoriaItemStateChanged
        if (rbAutogenerarNombre.isSelected()) {
             txtNombre.setText("");
        sc = String.valueOf(cbSubcategoria.getSelectedItem());
        n = c + " " + sc + " " + ma + " " + mo;
        txtNombre.setText(n);
        }else{
            txtNombre.setText("");
        }
       
    }//GEN-LAST:event_cbSubcategoriaItemStateChanged

    private void cbMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMarcaItemStateChanged
        if (rbAutogenerarNombre.isSelected()) {
            txtNombre.setText("");
         ma= String.valueOf(cbMarca.getSelectedItem());
        n = c + " " + sc + " " + ma + " " + mo;
        txtNombre.setText(n);
        }else{
            txtNombre.setText("");
        }
    }//GEN-LAST:event_cbMarcaItemStateChanged

    private void txtModeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloKeyTyped
            txtNombre.setText("");
            mo = txtModelo.getText();
            n = c + " " + sc + " " + ma + " " + mo;
            
            txtNombre.setText(n);
       
    }//GEN-LAST:event_txtModeloKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCategoria;
    private javax.swing.JButton btnAgregarMarca;
    private javax.swing.JButton btnAgregarSubcategoría;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbMarca;
    private javax.swing.JComboBox<String> cbSubcategoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbAutogenerarCodigo;
    private javax.swing.JRadioButton rbAutogenerarNombre;
    private javax.swing.JRadioButton rbEscribirManual;
    private javax.swing.JRadioButton rbIntroducirPistola;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
