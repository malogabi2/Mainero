/*
 * Decompiled with CFR 0_124.
 */
package wfewfbe.pantalla.interfaz;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DError
extends JDialog {
    private JLabel jLabel1;
    private JLabel lbl_mensaje;

    public DError(Frame parent, boolean modal) {
        super(parent, modal);
        this.initComponents();
    }

    public void setMensaje(String mensaje) {
        this.lbl_mensaje.setText(mensaje);
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.lbl_mensaje = new JLabel();
        this.setDefaultCloseOperation(2);
        this.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/error-64.png")));
        this.lbl_mensaje.setFont(new Font("Tahoma", 1, 18));
        this.lbl_mensaje.setText("A VER.... ESTAMOS HASTA LAS MANOS");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.lbl_mensaje).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1, -2, 69, -2)).addGroup(layout.createSequentialGroup().addGap(30, 30, 30).addComponent(this.lbl_mensaje))).addContainerGap(-1, 32767)));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((screenSize.width - 464) / 2, (screenSize.height - 125) / 2, 464, 125);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                DError dialog = new DError(new JFrame(), true);
                dialog.addWindowListener(new WindowAdapter(){

                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }

        });
    }

}

