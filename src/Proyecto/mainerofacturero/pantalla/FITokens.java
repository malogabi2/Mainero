/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.mainerofacturero.pantalla;

import Proyecto.GestorPantallas.GestorFIMostrarTokens;
import Proyecto.modelo.Configuracion;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;

public class FITokens
extends JInternalFrame {
    GestorFIMostrarTokens gestor;
    private JToggleButton bt_aceptar;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel2;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JTextArea txA_ultimoSigWSBFE;
    private JTextArea txA_ultimoSigWSFE;
    private JTextArea txA_utimoTokWSBFE;
    private JTextArea txA_utimoTokWSFE;
    private JTextField txt_fechaVencimientoWSBFE;
    private JTextField txt_fechaVencimientoWSFE;
    private JTextField txt_momentoPidioWSBFE;
    private JTextField txt_momentoPidioWSFE;

    public FITokens() {
        this.initComponents();
    }

    public void setConfiguracion(Configuracion conf) {
        this.gestor = new GestorFIMostrarTokens(conf);
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel2 = new JLabel();
        this.jLabel9 = new JLabel();
        this.jScrollPane3 = new JScrollPane();
        this.txA_utimoTokWSBFE = new JTextArea();
        this.jLabel10 = new JLabel();
        this.jScrollPane4 = new JScrollPane();
        this.txA_ultimoSigWSBFE = new JTextArea();
        this.jLabel11 = new JLabel();
        this.txt_momentoPidioWSBFE = new JTextField();
        this.txt_fechaVencimientoWSBFE = new JTextField();
        this.jLabel12 = new JLabel();
        this.jPanel2 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jScrollPane1 = new JScrollPane();
        this.txA_utimoTokWSFE = new JTextArea();
        this.jLabel5 = new JLabel();
        this.jScrollPane2 = new JScrollPane();
        this.txA_ultimoSigWSFE = new JTextArea();
        this.jLabel6 = new JLabel();
        this.jLabel8 = new JLabel();
        this.txt_fechaVencimientoWSFE = new JTextField();
        this.jLabel7 = new JLabel();
        this.txt_momentoPidioWSFE = new JTextField();
        this.bt_aceptar = new JToggleButton();
        this.addComponentListener(new ComponentAdapter(){

            @Override
            public void componentShown(ComponentEvent evt) {
                FITokens.this.formComponentShown(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel2.setFont(new Font("Tahoma", 0, 18));
        this.jLabel2.setText("WBSFE - Factura Electronica Bonos Fiscales");
        this.jLabel9.setFont(new Font("Tahoma", 0, 14));
        this.jLabel9.setText("Ultimo Token:");
        this.txA_utimoTokWSBFE.setColumns(20);
        this.txA_utimoTokWSBFE.setEditable(false);
        this.txA_utimoTokWSBFE.setFont(new Font("Arial", 0, 14));
        this.txA_utimoTokWSBFE.setLineWrap(true);
        this.txA_utimoTokWSBFE.setRows(5);
        this.jScrollPane3.setViewportView(this.txA_utimoTokWSBFE);
        this.jLabel10.setFont(new Font("Tahoma", 0, 14));
        this.jLabel10.setText("Ultimo Sign:");
        this.txA_ultimoSigWSBFE.setColumns(20);
        this.txA_ultimoSigWSBFE.setEditable(false);
        this.txA_ultimoSigWSBFE.setFont(new Font("Arial", 0, 14));
        this.txA_ultimoSigWSBFE.setLineWrap(true);
        this.txA_ultimoSigWSBFE.setRows(5);
        this.jScrollPane4.setViewportView(this.txA_ultimoSigWSBFE);
        this.jLabel11.setFont(new Font("Tahoma", 0, 14));
        this.jLabel11.setText("Momento que se Pidio:");
        this.txt_momentoPidioWSBFE.setEditable(false);
        this.txt_momentoPidioWSBFE.setFont(new Font("Arial", 0, 14));
        this.txt_fechaVencimientoWSBFE.setEditable(false);
        this.txt_fechaVencimientoWSBFE.setFont(new Font("Arial", 0, 14));
        this.jLabel12.setFont(new Font("Tahoma", 0, 14));
        this.jLabel12.setText("Fecha Vencimiento");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel9).addComponent(this.jLabel10).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane3).addComponent(this.jScrollPane4))).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel11).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.txt_momentoPidioWSBFE, -2, 216, -2))).addGap(76, 76, 76).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.txt_fechaVencimientoWSBFE, -2, 250, -2)).addComponent(this.jLabel12)))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel9).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jLabel10).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel11).addComponent(this.jLabel12)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txt_momentoPidioWSBFE, -2, -1, -2).addComponent(this.txt_fechaVencimientoWSBFE, -2, -1, -2)).addGap(0, 0, 32767)));
        this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel1.setFont(new Font("Tahoma", 0, 18));
        this.jLabel1.setText("WSFE - Factura Electronica");
        this.txA_utimoTokWSFE.setColumns(20);
        this.txA_utimoTokWSFE.setEditable(false);
        this.txA_utimoTokWSFE.setFont(new Font("Arial", 0, 14));
        this.txA_utimoTokWSFE.setLineWrap(true);
        this.txA_utimoTokWSFE.setRows(5);
        this.jScrollPane1.setViewportView(this.txA_utimoTokWSFE);
        this.jLabel5.setFont(new Font("Tahoma", 0, 14));
        this.jLabel5.setText("Ultimo Token:");
        this.txA_ultimoSigWSFE.setColumns(20);
        this.txA_ultimoSigWSFE.setEditable(false);
        this.txA_ultimoSigWSFE.setFont(new Font("Arial", 0, 14));
        this.txA_ultimoSigWSFE.setLineWrap(true);
        this.txA_ultimoSigWSFE.setRows(5);
        this.jScrollPane2.setViewportView(this.txA_ultimoSigWSFE);
        this.jLabel6.setFont(new Font("Tahoma", 0, 14));
        this.jLabel6.setText("Ultimo Sign:");
        this.jLabel8.setFont(new Font("Tahoma", 0, 14));
        this.jLabel8.setText("Fecha Vencimiento");
        this.txt_fechaVencimientoWSFE.setEditable(false);
        this.txt_fechaVencimientoWSFE.setFont(new Font("Arial", 0, 14));
        this.jLabel7.setFont(new Font("Tahoma", 0, 14));
        this.jLabel7.setText("Momento que se Pidio:");
        this.txt_momentoPidioWSFE.setEditable(false);
        this.txt_momentoPidioWSFE.setFont(new Font("Arial", 0, 14));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel5).addComponent(this.jLabel6).addGroup(jPanel2Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1).addComponent(this.jScrollPane2))).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel7).addGroup(jPanel2Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.txt_momentoPidioWSFE, -2, 216, -2))).addGap(76, 76, 76).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.txt_fechaVencimientoWSFE, -1, 250, 32767)).addComponent(this.jLabel8)))))).addContainerGap(-1, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jLabel6).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel7).addComponent(this.jLabel8)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txt_momentoPidioWSFE, -2, -1, -2).addComponent(this.txt_fechaVencimientoWSFE, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.bt_aceptar.setText("Aceptar");
        this.bt_aceptar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FITokens.this.bt_aceptarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.jPanel2, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel1, -2, -1, -2).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.bt_aceptar))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 19, 32767).addComponent(this.bt_aceptar)));
        this.pack();
    }

    private void bt_aceptarActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    private void formComponentShown(ComponentEvent evt) {
        this.txA_ultimoSigWSBFE.setText(this.gestor.mostrarSignfWBSFE());
        this.txA_ultimoSigWSFE.setText(this.gestor.mostrarSignfWSFE());
        this.txA_utimoTokWSBFE.setText(this.gestor.mostrarTokenWBSFE());
        this.txA_utimoTokWSFE.setText(this.gestor.mostrarTokenWSFE());
        this.txt_fechaVencimientoWSBFE.setText(this.gestor.mostrarVencimientoTokWBSFE());
        this.txt_fechaVencimientoWSFE.setText(this.gestor.mostrarVencimientoTokWSFE());
        this.txt_momentoPidioWSBFE.setText(this.gestor.mostrarMomentoPetisionWBSFE());
        this.txt_momentoPidioWSFE.setText(this.gestor.mostrarMomentoPetisionWSFE());
    }

}

