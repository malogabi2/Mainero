/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.mainerofacturero.pantalla;

import Proyecto.GestorPantallas.GestorFIBuscarWSer;
import Proyecto.modelo.Configuracion;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.net.URL;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

public class FIBuscarWEBSERVICE
extends JInternalFrame {
    GestorFIBuscarWSer gestor = new GestorFIBuscarWSer();
    private JLabel jLabel1;
    private JScrollPane lbl_mensa;
    private JTextArea lbl_mensaje;

    public FIBuscarWEBSERVICE(Configuracion config) {
        this.gestor.setConfiguracion(config);
        this.initComponents();
    }

    public void setMensaje(String mensaje) {
        this.lbl_mensaje.setText(mensaje);
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.lbl_mensa = new JScrollPane();
        this.lbl_mensaje = new JTextArea();
        this.addComponentListener(new ComponentAdapter(){

            @Override
            public void componentShown(ComponentEvent evt) {
                FIBuscarWEBSERVICE.this.formComponentShown(evt);
            }
        });
        this.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/giffffff/WorkInProgress.gif")));
        this.lbl_mensa.setBorder(null);
        this.lbl_mensaje.setBackground(new Color(224, 223, 227));
        this.lbl_mensaje.setColumns(20);
        this.lbl_mensaje.setEditable(false);
        this.lbl_mensaje.setFont(new Font("Arial", 1, 18));
        this.lbl_mensaje.setRows(5);
        this.lbl_mensaje.setOpaque(false);
        this.lbl_mensa.setViewportView(this.lbl_mensaje);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.lbl_mensa, -2, 307, -2).addGap(37, 37, 37)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.jLabel1, -2, 57, -2).addGap(0, 23, 32767)).addComponent(this.lbl_mensa, -2, 0, 32767)).addContainerGap()));
        this.pack();
    }

    private void formComponentShown(ComponentEvent evt) {
    }

}

