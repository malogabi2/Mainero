/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.mainerofacturero.pantalla;

import Proyecto.GestorPantallas.GestorFIBuscaComprobante;
import Proyecto.modelo.Configuracion;
import Proyecto.utilerias.Utilerias;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;

public class FIBuscaComprobantes
extends JInternalFrame {
    GestorFIBuscaComprobante gestor;
    private JToggleButton bt_buscarAfip;
    private JComboBox cmb_sucursales;
    private JComboBox cmb_tipoComprobantes;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel lbl_error;
    private JLabel lbl_numero;
    private JTextField txt_numeroComprobante;

    public FIBuscaComprobantes() {
        this.initComponents();
    }

    public void setSucursales(Configuracion sucs) {
        this.gestor = new GestorFIBuscaComprobante(sucs);
    }

    public void ocultarNumero() {
        this.lbl_numero.setVisible(false);
        this.txt_numeroComprobante.setVisible(false);
    }

    private void initComponents() {
        this.cmb_tipoComprobantes = new JComboBox();
        this.txt_numeroComprobante = new JTextField();
        this.cmb_sucursales = new JComboBox();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.lbl_numero = new JLabel();
        this.bt_buscarAfip = new JToggleButton();
        this.lbl_error = new JLabel();
        this.addComponentListener(new ComponentAdapter(){

            @Override
            public void componentShown(ComponentEvent evt) {
                FIBuscaComprobantes.this.formComponentShown(evt);
            }
        });
        this.jLabel5.setFont(new Font("Tahoma", 0, 14));
        this.jLabel5.setText("Tipo Comprobante");
        this.jLabel6.setFont(new Font("Tahoma", 0, 14));
        this.jLabel6.setText("Sucursal");
        this.lbl_numero.setFont(new Font("Tahoma", 0, 14));
        this.lbl_numero.setText("Numero");
        this.bt_buscarAfip.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/afip.png")));
        this.bt_buscarAfip.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIBuscaComprobantes.this.bt_buscarAfipActionPerformed(evt);
            }
        });
        this.lbl_error.setForeground(new Color(255, 0, 0));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel6).addComponent(this.lbl_numero)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.cmb_sucursales, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cmb_tipoComprobantes, -2, 215, -2)).addGroup(layout.createSequentialGroup().addComponent(this.txt_numeroComprobante, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lbl_error, -2, 282, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.bt_buscarAfip))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cmb_sucursales, -2, -1, -2).addComponent(this.jLabel6).addComponent(this.jLabel5).addComponent(this.cmb_tipoComprobantes, -2, -1, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lbl_error, -2, 18, -2).addComponent(this.lbl_numero).addComponent(this.txt_numeroComprobante, -2, -1, -2)).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 15, 32767).addComponent(this.bt_buscarAfip, -2, 32, -2)))));
        this.pack();
    }

    private void formComponentShown(ComponentEvent evt) {
        this.cmb_sucursales.setModel(new DefaultComboBoxModel<String>(this.gestor.sucursalesValidas()));
        this.cmb_tipoComprobantes.setModel(new DefaultComboBoxModel<String>(this.gestor.tiposComprobantes()));
    }

    private void buscaComprobante() {
        if (Utilerias.isNumeric(this.txt_numeroComprobante.getText())) {
            this.gestor.buscarComprobantes(this.cmb_sucursales.getSelectedIndex(), this.cmb_tipoComprobantes.getSelectedIndex(), this.txt_numeroComprobante.getText());
        } else {
            this.lbl_error.setText("El numero de Comprobante no valido");
        }
    }

    private void buscaUltimoAutorizado() {
        this.gestor.buscarUltimoAutorizado(this.cmb_sucursales.getSelectedIndex(), this.cmb_tipoComprobantes.getSelectedIndex());
    }

    private void bt_buscarAfipActionPerformed(ActionEvent evt) {
        if (this.lbl_numero.isVisible()) {
            this.buscaComprobante();
        } else {
            this.buscaUltimoAutorizado();
        }
    }
    
    }

