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
    public AgregarItem() {
        initComponents();
        this.setSize(1200, 800);
        this.setTitle("Agregar Ítem");
        this.setVisible(true);
        cs=new ControladorStock();
        
        //inicialización de combos
        actualizarCbCategoria();
    }

   
    //Declaración de métodos de la clase
    
    private void actualizarCbCategoria(){
        cbCategoria.removeAllItems();
        cbCategoria.setModel(cs.dameComboCategorias());
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rbAutogenerar = new javax.swing.JRadioButton();
        rbIntroducir = new javax.swing.JRadioButton();
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

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setText("Código Ítem: ");
        jLabel2.setToolTipText("Código de Barra");
        jLabel2.setEnabled(false);

        txtCodigo.setEnabled(false);

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

        buttonGroup1.add(rbAutogenerar);
        rbAutogenerar.setSelected(true);
        rbAutogenerar.setText("Autogenerar");
        rbAutogenerar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbAutogenerarStateChanged(evt);
            }
        });
        rbAutogenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAutogenerarActionPerformed(evt);
            }
        });
        rbAutogenerar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                rbAutogenerarPropertyChange(evt);
            }
        });

        buttonGroup1.add(rbIntroducir);
        rbIntroducir.setText("Introducir con pistola");
        rbIntroducir.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbIntroducirStateChanged(evt);
            }
        });

        cbSubcategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtModelo)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCodigo)
                                .addComponent(cbSubcategoria, 0, 447, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbAutogenerar)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbIntroducir))
                                    .addComponent(btnAgregarCategoria)
                                    .addComponent(btnAgregarMarca))
                                .addGap(64, 64, 64))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbAutogenerar)
                    .addComponent(rbIntroducir))
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
                .addContainerGap(98, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbAutogenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAutogenerarActionPerformed
           
    }//GEN-LAST:event_rbAutogenerarActionPerformed

    private void rbAutogenerarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_rbAutogenerarPropertyChange
     
    }//GEN-LAST:event_rbAutogenerarPropertyChange

    private void rbIntroducirStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbIntroducirStateChanged
       if(rbIntroducir.isSelected()){
               txtCodigo.setEnabled(true);
               txtCodigo.requestFocus();
           }else{
               txtCodigo.setEnabled(false);
           }
    }//GEN-LAST:event_rbIntroducirStateChanged

    private void rbAutogenerarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbAutogenerarStateChanged
       if(rbAutogenerar.isSelected()){
               txtCodigo.setEnabled(false);
           }else{
               txtCodigo.setEnabled(true);
               txtCodigo.requestFocus();
           }
    }//GEN-LAST:event_rbAutogenerarStateChanged

    private void btnAgregarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCategoriaActionPerformed
        String c=JOptionPane.showInputDialog(null, "Introduzca nueva CATEGORÍA", "AGREGAR CATEGORIA", JOptionPane.OK_CANCEL_OPTION);
        categoria = new Categoria(c);
        cs.agregarCategoria(categoria);
    }//GEN-LAST:event_btnAgregarCategoriaActionPerformed

    private void btnAgregarSubcategoríaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarSubcategoríaActionPerformed
        String sc=JOptionPane.showInputDialog(null, "Introduzca nueva CATEGORÍA", "AGREGAR CATEGORIA", JOptionPane.OK_CANCEL_OPTION);
        subcategoria = new Subcategoria(sc);
        cs.agregarSubCategoria(subcategoria);
    }//GEN-LAST:event_btnAgregarSubcategoríaActionPerformed

    private void btnAgregarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMarcaActionPerformed
       String m=JOptionPane.showInputDialog(null, "Introduzca nueva CATEGORÍA", "AGREGAR CATEGORIA", JOptionPane.OK_CANCEL_OPTION);
       marca= new Marca(m);
       cs.agregarMarca(marca);
    }//GEN-LAST:event_btnAgregarMarcaActionPerformed

    
    
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCategoria;
    private javax.swing.JButton btnAgregarMarca;
    private javax.swing.JButton btnAgregarSubcategoría;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.ButtonGroup buttonGroup1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbAutogenerar;
    private javax.swing.JRadioButton rbIntroducir;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtModelo;
    // End of variables declaration//GEN-END:variables
}
