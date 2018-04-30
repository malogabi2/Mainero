/*
 * Decompiled with CFR 0_124.
 */
package pantalla.interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

public class FEspera
extends JFrame {
    private JButton bt_detalle;
    private JLabel img_gif;
    private JScrollPane lbl_mensa;
    private JTextArea lbl_mensaje;
    private JScrollPane scr_detalle;
    private JTextArea txt_detalle;

    public FEspera() {
        this.initComponents();
        this.ocultarDetalle(true);
        this.setSize(this.getWidth(), this.getHeight() + 200);
    }

    public void mensaje(String mensaje) {
        this.lbl_mensaje.setText(mensaje);
    }

    private void ocultarDetalle(boolean opcion) {
        this.txt_detalle.setVisible(!opcion);
        this.scr_detalle.setVisible(!opcion);
        if (opcion) {
            this.setSize(this.getWidth(), this.getHeight() - 200);
        } else {
            this.setSize(this.getWidth(), this.getHeight() + 200);
        }
    }

    private void initComponents() {
        this.img_gif = new JLabel();
        this.lbl_mensa = new JScrollPane();
        this.lbl_mensaje = new JTextArea();
        this.bt_detalle = new JButton();
        this.scr_detalle = new JScrollPane();
        this.txt_detalle = new JTextArea();
        this.setDefaultCloseOperation(3);
        this.setTitle("Consultando Afip");
        this.img_gif.setHorizontalAlignment(0);
        this.img_gif.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/giffffff/WorkInProgress.gif")));
        this.lbl_mensa.setBorder(null);
        this.lbl_mensaje.setBackground(new Color(224, 223, 227));
        this.lbl_mensaje.setColumns(20);
        this.lbl_mensaje.setEditable(false);
        this.lbl_mensaje.setFont(new Font("Arial", 1, 18));
        this.lbl_mensaje.setRows(5);
        this.lbl_mensaje.setOpaque(false);
        this.lbl_mensa.setViewportView(this.lbl_mensaje);
        this.bt_detalle.setText("Ver Detalle");
        this.bt_detalle.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FEspera.this.bt_detalleActionPerformed(evt);
            }
        });
        this.txt_detalle.setColumns(20);
        this.txt_detalle.setRows(5);
        this.scr_detalle.setViewportView(this.txt_detalle);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.img_gif, -2, 58, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lbl_mensa, -1, 481, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.scr_detalle, -1, 460, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.bt_detalle))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.img_gif, -2, 73, -2).addComponent(this.lbl_mensa, -2, 43, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.bt_detalle).addComponent(this.scr_detalle, -2, 0, 32767)).addContainerGap()));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((screenSize.width - 569) / 2, (screenSize.height - 147) / 2, 569, 147);
    }

    private void bt_detalleActionPerformed(ActionEvent evt) {
        if (this.bt_detalle.getText().contains("Ver")) {
            this.ocultarDetalle(false);
            this.bt_detalle.setText("Ocu. Detalle");
        } else {
            this.ocultarDetalle(true);
            this.bt_detalle.setText("Ver Detalle");
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
            }
        });
    }

    public void setMensajeDetalle(String mensaje) {
        this.txt_detalle.setText(this.txt_detalle.getText() + mensaje);
        this.repaint();
    }

}

