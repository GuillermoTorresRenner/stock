/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.CodigoBarras;
import controller.ControladorItem;
import java.awt.Image;
import java.io.File;
import java.io.FilenameFilter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Categoria;
import model.Marca;
import model.Subcategoria;
import model.CodigoBarras;
import model.Item;

/**
 *
 * @author guille
 */
public class AgregarItem extends javax.swing.JInternalFrame {

    Categoria categoria;
    Subcategoria subcategoria;
    Marca marca;
    ControladorItem cs;
    String n = "", c = "", sc = "", ma = "", mo = "", codigo = "";
    private File archivoFoto;
    private CodigoBarras codigoBarras = new CodigoBarras();
    private Item item;

    public AgregarItem() {
        initComponents();
        this.setSize(1200, 800);
        this.setTitle("Agregar Ítem");
        this.setVisible(true);
        txtNombre.requestFocus();
        cs = new ControladorItem();

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

    private void validarDatos() {
        if (cbCategoria.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una categoría antes de guardar", "Aviso categoria", JOptionPane.WARNING_MESSAGE);
        } else if (cbSubcategoria.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una subcategoría antes de guardar", "Aviso subcategoria", JOptionPane.WARNING_MESSAGE);
        } else if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una Nombre para el ítem antes de  guardar", "Aviso Elemento", JOptionPane.WARNING_MESSAGE);
        } else {
            if (txtCodigo.getText().length() < 4) {
                int o;
                boolean exito;
                o = JOptionPane.showConfirmDialog(null, "DESEA GUARDAR EL ÍTEM: " + txtNombre.getText(), "guardado de item", JOptionPane.YES_NO_OPTION);
                if (o == JOptionPane.YES_OPTION) {
                    txtCodigo.setText(cs.dameCodigo(cbCategoria.getSelectedItem().toString(), cbSubcategoria.getSelectedItem().toString(), cbMarca.getSelectedItem().toString()));
                    JOptionPane.showMessageDialog(this, "se auto genró el código: " + txtCodigo.getText().toString(), "Aviso subcategoria", JOptionPane.WARNING_MESSAGE);
                    Icon i = codigoBarras.dameimagenCodigoBarras(txtCodigo.getText(), lblCodigoBarras);
                    lblCodigoBarras.setIcon(i);
                    lblCodigoBarras.setText(txtCodigo.getText());
                    guardarDatos(item);

                } else {
                    JOptionPane.showMessageDialog(this, "INGRESE UN CÓDIGO DE PRODUCTO VÁLIDO", "AVISO CÓDIGO INCORRECTO", JOptionPane.WARNING_MESSAGE);
                }

            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        VentanaChooser = new javax.swing.JDialog();
        chooser = new javax.swing.JFileChooser();
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
        lblFoto = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnAgregarSubcategoría = new javax.swing.JButton();
        btnAgregarCategoria = new javax.swing.JButton();
        btnAgregarMarca = new javax.swing.JButton();
        btnSeleccionarImg = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblPathFoto = new javax.swing.JLabel();
        lblCodigoBarras = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();

        javax.swing.GroupLayout VentanaChooserLayout = new javax.swing.GroupLayout(VentanaChooser.getContentPane());
        VentanaChooser.getContentPane().setLayout(VentanaChooserLayout);
        VentanaChooserLayout.setHorizontalGroup(
            VentanaChooserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaChooserLayout.createSequentialGroup()
                .addComponent(chooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        VentanaChooserLayout.setVerticalGroup(
            VentanaChooserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaChooserLayout.createSequentialGroup()
                .addComponent(chooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setText("Código Ítem: ");
        jLabel2.setToolTipText("Código de Barra");
        jLabel2.setEnabled(false);

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

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

        txtModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModeloActionPerformed(evt);
            }
        });
        txtModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtModeloKeyTyped(evt);
            }
        });

        txtDescripcion.setColumns(20);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(5);
        txtDescripcion.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtDescripcion);

        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sinImagen.png"))); // NOI18N
        lblFoto.setIconTextGap(1);

        btnGuardar.setText("Guardar Registro");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

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

        btnSeleccionarImg.setText("Seleccionar imagen");
        btnSeleccionarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarImgActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel9.setText("Agregar Items al sistema");

        lblCodigoBarras.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel10.setText("Nombre");
        jLabel10.setToolTipText("Código de Barra");
        jLabel10.setEnabled(false);

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cbMarca, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbSubcategoria, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbCategoria, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbAutogenerarCodigo)
                                        .addGap(36, 36, 36)
                                        .addComponent(rbIntroducirPistola))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnAgregarCategoria)
                                                .addComponent(btnAgregarSubcategoría)
                                                .addComponent(btnAgregarMarca))
                                            .addGap(18, 18, 18)
                                            .addComponent(lblCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lblPathFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblFoto)
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnSeleccionarImg)))))))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbAutogenerarCodigo)
                            .addComponent(rbIntroducirPistola))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarCategoria))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbSubcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAgregarSubcategoría)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(btnAgregarMarca)
                            .addComponent(cbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txtModelo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPathFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(btnSeleccionarImg)))))
                .addGap(18, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(129, Short.MAX_VALUE))
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


    }//GEN-LAST:event_cbCategoriaItemStateChanged

    private void cbSubcategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSubcategoriaItemStateChanged


    }//GEN-LAST:event_cbSubcategoriaItemStateChanged

    private void cbMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMarcaItemStateChanged

    }//GEN-LAST:event_cbMarcaItemStateChanged

    private void txtModeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloKeyTyped


    }//GEN-LAST:event_txtModeloKeyTyped

    private void btnSeleccionarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarImgActionPerformed
        VentanaChooser.pack();
        VentanaChooser.setLocationRelativeTo(null);
        VentanaChooser.setVisible(true);
        FileNameExtensionFilter formatoBusqueda = new FileNameExtensionFilter("JPG, PNG, y GIF", "jpg", "jpeg", "png", "gif");
        chooser.setFileFilter(formatoBusqueda);
        int resultado = chooser.showOpenDialog(null);
        if (JFileChooser.APPROVE_OPTION == resultado) {
            archivoFoto = chooser.getSelectedFile();
            lblPathFoto.setText(archivoFoto.getAbsolutePath());
            try {
                ImageIcon imageIcon = new ImageIcon(archivoFoto.toString());
                Icon icono = new ImageIcon(imageIcon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
                lblFoto.setIcon(icono);

            } catch (Exception e) {
            }
        }


    }//GEN-LAST:event_btnSeleccionarImgActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        validarDatos();

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
      this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModeloActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog VentanaChooser;
    private javax.swing.JButton btnAgregarCategoria;
    private javax.swing.JButton btnAgregarMarca;
    private javax.swing.JButton btnAgregarSubcategoría;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSeleccionarImg;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbMarca;
    private javax.swing.JComboBox<String> cbSubcategoria;
    private javax.swing.JFileChooser chooser;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigoBarras;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblPathFoto;
    private javax.swing.JRadioButton rbAutogenerarCodigo;
    private javax.swing.JRadioButton rbIntroducirPistola;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private void guardarDatos(Item item) {
        item = new Item();
        item.setCodigo(txtCodigo.getText());
        item.setNombre(txtNombre.getText().toUpperCase());
        item.setCategoria(cs.dameIdCombo(1, cbCategoria.getSelectedItem().toString()));
        item.setSubcategoria(cs.dameIdCombo(2, cbSubcategoria.getSelectedItem().toString()));
        item.setMarca(cs.dameIdCombo(3, cbMarca.getSelectedItem().toString()));
        item.setModelo(txtModelo.getText().toUpperCase());
        item.setDescripcion(txtDescripcion.getText().toUpperCase());
        item.setFoto(archivoFoto);
        cs.guardarItem(item);

    }

}
