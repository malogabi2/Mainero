/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.mainerofacturero.pantalla;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;

public class DError
extends JDialog {
    private JButton bt_muestraErrorTecnico;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JTextArea lbl_errorTecnico;
    private JLabel lbl_errorUsuario;

    public DError(Frame parent, boolean modal) {
        super(parent, modal);
        this.initComponents();
        this.lbl_errorTecnico.setVisible(false);
    }

    public void setMensajeUsuario(String usuerMensaje) {
        this.lbl_errorUsuario.setText(usuerMensaje);
    }

    public void setMensajeAdmin(String tecMensaje) {
        this.lbl_errorTecnico.setText(tecMensaje);
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.lbl_errorUsuario = new JLabel();
        this.bt_muestraErrorTecnico = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.lbl_errorTecnico = new JTextArea();
        this.setDefaultCloseOperation(2);
        this.jLabel1.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/peligro.gif")));
        this.bt_muestraErrorTecnico.setText(".....");
        this.bt_muestraErrorTecnico.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DError.this.bt_muestraErrorTecnicoActionPerformed(evt);
            }
        });
        this.lbl_errorTecnico.setColumns(20);
        this.lbl_errorTecnico.setRows(5);
        this.jScrollPane1.setViewportView(this.lbl_errorTecnico);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.lbl_errorUsuario, -1, -1, 32767).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jScrollPane1, -1, 341, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.bt_muestraErrorTecnico)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addContainerGap().addComponent(this.lbl_errorUsuario, -1, -1, 32767)).addComponent(this.jLabel1, -2, 64, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -2, 0, 32767).addComponent(this.bt_muestraErrorTecnico, -1, 53, 32767))));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((screenSize.width - 416) / 2, (screenSize.height - 161) / 2, 416, 161);
    }

    private void bt_muestraErrorTecnicoActionPerformed(ActionEvent evt) {
        this.lbl_errorTecnico.setVisible(!this.lbl_errorTecnico.isVisible());
    }

}

