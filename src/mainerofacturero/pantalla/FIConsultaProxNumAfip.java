/*
 * Decompiled with CFR 0_124.
 */
package mainerofacturero.pantalla;

import java.awt.Component;
import java.awt.Container;
import java.awt.LayoutManager;
import java.net.URL;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;

public class FIConsultaProxNumAfip
extends JInternalFrame {
    private JButton jButton1;
    private JComboBox jComboBox1;
    private JComboBox jComboBox2;
    private JLabel jLabel1;
    private JLabel jLabel2;

    public FIConsultaProxNumAfip() {
        this.initComponents();
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jComboBox1 = new JComboBox();
        this.jLabel2 = new JLabel();
        this.jComboBox2 = new JComboBox();
        this.jButton1 = new JButton();
        this.jLabel1.setText("Sucursal");
        this.jLabel2.setText("Tipo Comprobante");
        this.jButton1.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/afip.png")));
        this.jButton1.setText("Consultar");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.jComboBox1, -2, 91, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jComboBox2, -2, 98, -2).addGap(0, 24, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jButton1))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jComboBox1, -2, -1, -2).addComponent(this.jLabel2).addComponent(this.jComboBox2, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, 32767).addComponent(this.jButton1)));
        this.pack();
    }
}

