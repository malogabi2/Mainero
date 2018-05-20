/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.mainerofacturero.pantalla;

import Proyecto.GestorPantallas.GestorLogueo;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import org.apache.log4j.Priority;
import utiles.logger.LoggerBitacora;

public class FLogueo
extends JFrame {
    GestorLogueo gestor = new GestorLogueo();
    private JButton bt_aceptar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel lbl_mensaje;
    private JPasswordField txt_pass;
    private JTextField txt_usuario;

    public FLogueo() {
        this.initComponents();
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.txt_pass = new JPasswordField();
        this.txt_usuario = new JTextField();
        this.bt_aceptar = new JButton();
        this.lbl_mensaje = new JLabel();
        this.jLabel3 = new JLabel();
        this.setDefaultCloseOperation(3);
        this.jLabel1.setFont(new Font("Arial", 0, 18));
        this.jLabel1.setText("Usuario");
        this.jLabel2.setFont(new Font("Arial", 0, 18));
        this.jLabel2.setText("Contrase\u00f1a");
        this.txt_pass.setFont(new Font("Tahoma", 0, 14));
        this.txt_pass.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FLogueo.this.txt_passActionPerformed(evt);
            }
        });
        this.txt_usuario.setFont(new Font("Tahoma", 0, 14));
        this.bt_aceptar.setFont(new Font("Arial", 0, 18));
        this.bt_aceptar.setText("OK");
        this.bt_aceptar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FLogueo.this.bt_aceptarActionPerformed(evt);
            }
        });
        this.jLabel3.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/candado mini.png")));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel3, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.lbl_mensaje, -2, 183, -2).addGap(86, 86, 86).addComponent(this.bt_aceptar)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2).addComponent(this.jLabel1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txt_usuario).addComponent(this.txt_pass)))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(12, 12, 12).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txt_usuario, -2, -1, -2).addComponent(this.jLabel1)).addGap(14, 14, 14).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txt_pass, -2, -1, -2).addComponent(this.jLabel2)).addGap(14, 14, 14).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.bt_aceptar).addComponent(this.lbl_mensaje, -2, 31, -2)).addGap(0, 0, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel3, -1, -1, 32767).addContainerGap()));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((screenSize.width - 450) / 2, (screenSize.height - 155) / 2, 450, 155);
    }

    private void bt_aceptarActionPerformed(ActionEvent evt) {
        this.acaptar();
    }

    private void txt_passActionPerformed(ActionEvent evt) {
        this.acaptar();
    }

    private void acaptar() {
        if (this.gestor.contastarLogueo(this.txt_usuario.getText(), new String(this.txt_pass.getPassword()))) {
            this.gestor.llamarAlPrograma();
            this.dispose();
        } else {
            this.lbl_mensaje.setText("Usuario o Clave Incorrectos");
            LoggerBitacora.getInstance(FLogueo.class).
                    logueadorMainero.log("un Mensaje", Priority.WARN, 
                    "usuario incorrecto, usuario: " + this.txt_usuario.getText() + " psw: " 
                    + new String(this.txt_pass.getPassword()), null);
        }      
    }

}

