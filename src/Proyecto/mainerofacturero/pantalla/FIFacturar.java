/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.mainerofacturero.pantalla;

import Proyecto.GestorPantallas.GestorFIFacturar;
import Proyecto.modelo.Configuracion;
import Proyecto.utilerias.Utilerias;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

public class FIFacturar
extends JInternalFrame {
    private GestorFIFacturar gestor;
    private JButton bt_buscaComprobante;
    private JButton bt_enviarFactura;
    private JButton bt_help_buscaMonedas;
    private JButton bt_help_comprobarProximoNumero;
    private JButton bt_help_consultarComprobanteAfip;
    private JButton bt_help_tiposDocumento;
    private JButton bt_help_tiposIva;
    private JComboBox cmb_sucursalBoca;
    private JComboBox cmb_tipoComprobante;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel24;
    private JLabel jLabel25;
    private JLabel jLabel26;
    private JLabel jLabel27;
    private JLabel jLabel28;
    private JLabel jLabel29;
    private JLabel jLabel3;
    private JLabel jLabel30;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JLabel lbl_error;
    private JPanel pnl_productos;
    private JTextField txt_codMoneda;
    private JTextField txt_compNumMostrar;
    private JTextField txt_comproNum;
    private JTextField txt_documentoNum;
    private JTextField txt_exento;
    private JTextField txt_fechaComprobante;
    private JTextField txt_gravadoComp;
    private JTextField txt_impuestoInterno_porcep;
    private JTextField txt_impuestoInternos;
    private JTextField txt_montoIvaInscripto;
    private JTextField txt_montoIvaNoInscripto;
    private JTextField txt_noGravado;
    private JTextField txt_percep_Municipales;
    private JTextField txt_percep_ingresosBrutos;
    private JTextField txt_percep_nacionales;
    private JTextField txt_percep_nacionales_porcentaje;
    private JTextField txt_precep_ingresosBrutos_porcep;
    private JTextField txt_precep_municapales_porcep;
    private JTextField txt_productoCodigo;
    private JTextField txt_productoNomenclador;
    private JTextField txt_razonSocial;
    private JTextField txt_responsableIva;
    private JTextField txt_sucBocMostrar;
    private JTextField txt_tipoCambio;
    private JTextField txt_tipoCompoMostrar;
    private JTextField txt_tipoDocumento;
    private JTextField txt_total;

    public FIFacturar(Configuracion config) {
        this.gestor = new GestorFIFacturar(config);
        this.initComponents();
        this.setResizable(true);
        this.bt_help_consultarComprobanteAfip.setVisible(false);
        this.bt_enviarFactura.setEnabled(false);
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.txt_fechaComprobante = new JTextField();
        this.jLabel1 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel11 = new JLabel();
        this.txt_gravadoComp = new JTextField();
        this.txt_noGravado = new JTextField();
        this.jLabel12 = new JLabel();
        this.txt_montoIvaInscripto = new JTextField();
        this.jLabel13 = new JLabel();
        this.txt_montoIvaNoInscripto = new JTextField();
        this.jLabel14 = new JLabel();
        this.txt_exento = new JTextField();
        this.jLabel15 = new JLabel();
        this.jPanel4 = new JPanel();
        this.jLabel16 = new JLabel();
        this.jLabel17 = new JLabel();
        this.jLabel18 = new JLabel();
        this.jLabel19 = new JLabel();
        this.txt_percep_nacionales = new JTextField();
        this.txt_percep_ingresosBrutos = new JTextField();
        this.txt_percep_Municipales = new JTextField();
        this.txt_percep_nacionales_porcentaje = new JTextField();
        this.txt_precep_municapales_porcep = new JTextField();
        this.txt_precep_ingresosBrutos_porcep = new JTextField();
        this.jLabel20 = new JLabel();
        this.jLabel21 = new JLabel();
        this.txt_impuestoInternos = new JTextField();
        this.txt_impuestoInterno_porcep = new JTextField();
        this.txt_codMoneda = new JTextField();
        this.jLabel22 = new JLabel();
        this.jLabel23 = new JLabel();
        this.txt_tipoCambio = new JTextField();
        this.jLabel24 = new JLabel();
        this.txt_total = new JTextField();
        this.bt_help_buscaMonedas = new JButton();
        this.jLabel25 = new JLabel();
        this.jLabel26 = new JLabel();
        this.txt_compNumMostrar = new JTextField();
        this.txt_tipoCompoMostrar = new JTextField();
        this.txt_sucBocMostrar = new JTextField();
        this.jLabel27 = new JLabel();
        this.jPanel2 = new JPanel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.cmb_tipoComprobante = new JComboBox();
        this.txt_comproNum = new JTextField();
        this.jLabel2 = new JLabel();
        this.bt_help_comprobarProximoNumero = new JButton();
        this.bt_buscaComprobante = new JButton();
        this.jLabel6 = new JLabel();
        this.cmb_sucursalBoca = new JComboBox();
        this.jPanel3 = new JPanel();
        this.jLabel7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.txt_tipoDocumento = new JTextField();
        this.bt_help_tiposDocumento = new JButton();
        this.txt_responsableIva = new JTextField();
        this.jLabel9 = new JLabel();
        this.bt_help_tiposIva = new JButton();
        this.jLabel10 = new JLabel();
        this.txt_razonSocial = new JTextField();
        this.jLabel28 = new JLabel();
        this.txt_documentoNum = new JTextField();
        this.lbl_error = new JLabel();
        this.bt_enviarFactura = new JButton();
        this.pnl_productos = new JPanel();
        this.jLabel29 = new JLabel();
        this.jLabel30 = new JLabel();
        this.txt_productoCodigo = new JTextField();
        this.txt_productoNomenclador = new JTextField();
        this.bt_help_consultarComprobanteAfip = new JButton();
        this.addComponentListener(new ComponentAdapter(){

            @Override
            public void componentHidden(ComponentEvent evt) {
                FIFacturar.this.formComponentHidden(evt);
            }

            @Override
            public void componentShown(ComponentEvent evt) {
                FIFacturar.this.formComponentShown(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.txt_fechaComprobante.setEditable(false);
        this.txt_fechaComprobante.setFont(new Font("Tahoma", 0, 14));
        this.jLabel1.setFont(new Font("Tahoma", 0, 14));
        this.jLabel1.setText("Fecha:");
        this.jLabel3.setFont(new Font("Tahoma", 1, 14));
        this.jLabel3.setText("Datos Comprobantes");
        this.jLabel11.setFont(new Font("Tahoma", 0, 14));
        this.jLabel11.setText("Gravado:");
        this.txt_gravadoComp.setEditable(false);
        this.txt_gravadoComp.setFont(new Font("Tahoma", 0, 14));
        this.txt_gravadoComp.setHorizontalAlignment(4);
        this.txt_noGravado.setEditable(false);
        this.txt_noGravado.setFont(new Font("Tahoma", 0, 14));
        this.txt_noGravado.setHorizontalAlignment(4);
        this.jLabel12.setFont(new Font("Tahoma", 0, 14));
        this.jLabel12.setText("No Gravado:");
        this.txt_montoIvaInscripto.setEditable(false);
        this.txt_montoIvaInscripto.setFont(new Font("Tahoma", 0, 14));
        this.txt_montoIvaInscripto.setHorizontalAlignment(4);
        this.jLabel13.setFont(new Font("Tahoma", 0, 14));
        this.jLabel13.setText("Monto IVA Inscripto:");
        this.txt_montoIvaNoInscripto.setEditable(false);
        this.txt_montoIvaNoInscripto.setFont(new Font("Tahoma", 0, 14));
        this.txt_montoIvaNoInscripto.setHorizontalAlignment(4);
        this.jLabel14.setFont(new Font("Tahoma", 0, 14));
        this.jLabel14.setText("Monto IVA No Inscripto:");
        this.txt_exento.setEditable(false);
        this.txt_exento.setFont(new Font("Tahoma", 0, 14));
        this.txt_exento.setHorizontalAlignment(4);
        this.jLabel15.setFont(new Font("Tahoma", 0, 14));
        this.jLabel15.setText("Exento:");
        this.jPanel4.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel16.setFont(new Font("Tahoma", 1, 14));
        this.jLabel16.setText("Percepciones");
        this.jLabel17.setFont(new Font("Tahoma", 0, 14));
        this.jLabel17.setText("Nacionales:");
        this.jLabel18.setFont(new Font("Tahoma", 0, 14));
        this.jLabel18.setText("De Ingresos Brutos:");
        this.jLabel19.setFont(new Font("Tahoma", 0, 14));
        this.jLabel19.setText("Municipales:");
        this.txt_percep_nacionales.setEditable(false);
        this.txt_percep_nacionales.setFont(new Font("Tahoma", 0, 14));
        this.txt_percep_nacionales.setHorizontalAlignment(4);
        this.txt_percep_ingresosBrutos.setEditable(false);
        this.txt_percep_ingresosBrutos.setFont(new Font("Tahoma", 0, 14));
        this.txt_percep_ingresosBrutos.setHorizontalAlignment(4);
        this.txt_percep_Municipales.setEditable(false);
        this.txt_percep_Municipales.setFont(new Font("Tahoma", 0, 14));
        this.txt_percep_Municipales.setHorizontalAlignment(4);
        this.txt_percep_nacionales_porcentaje.setEditable(false);
        this.txt_percep_nacionales_porcentaje.setFont(new Font("Tahoma", 0, 14));
        this.txt_percep_nacionales_porcentaje.setHorizontalAlignment(4);
        this.txt_precep_municapales_porcep.setEditable(false);
        this.txt_precep_municapales_porcep.setFont(new Font("Tahoma", 0, 14));
        this.txt_precep_municapales_porcep.setHorizontalAlignment(4);
        this.txt_precep_ingresosBrutos_porcep.setEditable(false);
        this.txt_precep_ingresosBrutos_porcep.setFont(new Font("Tahoma", 0, 14));
        this.txt_precep_ingresosBrutos_porcep.setHorizontalAlignment(4);
        this.jLabel20.setFont(new Font("Tahoma", 0, 14));
        this.jLabel20.setText("%");
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel16).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jLabel20).addGap(30, 30, 30)).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel18).addComponent(this.jLabel19).addComponent(this.jLabel17)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txt_percep_nacionales, -1, 136, 32767).addComponent(this.txt_percep_ingresosBrutos, GroupLayout.Alignment.TRAILING).addComponent(this.txt_percep_Municipales, GroupLayout.Alignment.TRAILING)).addGap(33, 33, 33).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txt_percep_nacionales_porcentaje, -1, 59, 32767).addComponent(this.txt_precep_ingresosBrutos_porcep).addComponent(this.txt_precep_municapales_porcep)).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel16).addComponent(this.jLabel20)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel17).addComponent(this.txt_percep_nacionales, -2, -1, -2).addComponent(this.txt_percep_nacionales_porcentaje, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel18).addComponent(this.txt_percep_ingresosBrutos, -2, -1, -2).addComponent(this.txt_precep_ingresosBrutos_porcep, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, 32767).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel19).addComponent(this.txt_percep_Municipales, -2, -1, -2).addComponent(this.txt_precep_municapales_porcep, -2, -1, -2)).addContainerGap()));
        this.jLabel21.setFont(new Font("Tahoma", 0, 14));
        this.jLabel21.setText("Impuestos Internos:");
        this.txt_impuestoInternos.setEditable(false);
        this.txt_impuestoInternos.setFont(new Font("Tahoma", 0, 14));
        this.txt_impuestoInternos.setHorizontalAlignment(4);
        this.txt_impuestoInterno_porcep.setEditable(false);
        this.txt_impuestoInterno_porcep.setFont(new Font("Tahoma", 0, 14));
        this.txt_impuestoInterno_porcep.setHorizontalAlignment(4);
        this.txt_codMoneda.setEditable(false);
        this.txt_codMoneda.setFont(new Font("Tahoma", 0, 14));
        this.jLabel22.setFont(new Font("Tahoma", 0, 14));
        this.jLabel22.setText("Tip de Cam:");
        this.jLabel23.setFont(new Font("Tahoma", 0, 14));
        this.jLabel23.setText("C\u00f3digo Moneda: ");
        this.txt_tipoCambio.setEditable(false);
        this.txt_tipoCambio.setFont(new Font("Tahoma", 0, 14));
        this.jLabel24.setFont(new Font("Tahoma", 1, 14));
        this.jLabel24.setText("Importe Total:");
        this.txt_total.setEditable(false);
        this.txt_total.setFont(new Font("Tahoma", 1, 14));
        this.txt_total.setHorizontalAlignment(4);
        this.bt_help_buscaMonedas.setFont(new Font("Tahoma", 0, 14));
        this.bt_help_buscaMonedas.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/signo de pregunta mini.jpg")));
        this.bt_help_buscaMonedas.setToolTipText("Consultar En Afip Proximo Numero");
        this.bt_help_buscaMonedas.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIFacturar.this.bt_help_buscaMonedasActionPerformed(evt);
            }
        });
        this.jLabel25.setFont(new Font("Tahoma", 0, 14));
        this.jLabel25.setText("Comp Num");
        this.jLabel26.setFont(new Font("Tahoma", 0, 14));
        this.jLabel26.setText("Tip Comp");
        this.txt_compNumMostrar.setEditable(false);
        this.txt_compNumMostrar.setFont(new Font("Tahoma", 0, 14));
        this.txt_tipoCompoMostrar.setEditable(false);
        this.txt_tipoCompoMostrar.setFont(new Font("Tahoma", 0, 14));
        this.txt_sucBocMostrar.setEditable(false);
        this.txt_sucBocMostrar.setFont(new Font("Tahoma", 0, 14));
        this.jLabel27.setFont(new Font("Tahoma", 0, 14));
        this.jLabel27.setText("Suc/Boc");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel3).addGap(74, 74, 74).addComponent(this.jLabel25).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_compNumMostrar, -2, 75, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel26).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_tipoCompoMostrar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel27).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_sucBocMostrar, -2, 86, -2)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel13).addComponent(this.jLabel12).addComponent(this.jLabel11)).addGap(39, 39, 39).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txt_montoIvaInscripto).addComponent(this.txt_noGravado).addComponent(this.txt_gravadoComp))).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel14).addComponent(this.jLabel15).addComponent(this.jLabel23)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txt_codMoneda, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel22).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_tipoCambio, -2, 61, -2)).addComponent(this.txt_montoIvaNoInscripto).addComponent(this.txt_exento)))).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel4, GroupLayout.Alignment.TRAILING, -2, -1, -2).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.bt_help_buscaMonedas, -2, 25, -2).addGap(70, 70, 70).addComponent(this.jLabel24).addGap(26, 26, 26).addComponent(this.txt_total)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel21).addGap(18, 18, 18).addComponent(this.txt_impuestoInternos, -2, 137, -2).addGap(32, 32, 32).addComponent(this.txt_impuestoInterno_porcep, -2, 59, -2).addGap(0, 0, 32767))).addGap(14, 14, 14)))).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.txt_fechaComprobante, -2, 107, -2))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jLabel25).addComponent(this.jLabel26).addComponent(this.txt_compNumMostrar, -2, -1, -2).addComponent(this.txt_tipoCompoMostrar, -2, -1, -2).addComponent(this.txt_sucBocMostrar, -2, -1, -2).addComponent(this.jLabel27)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txt_fechaComprobante, -2, -1, -2).addComponent(this.jLabel1)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel21).addComponent(this.txt_impuestoInternos, -2, -1, -2).addComponent(this.txt_impuestoInterno_porcep, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.bt_help_buscaMonedas, GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel24).addComponent(this.txt_total, -2, -1, -2)))).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel11).addComponent(this.txt_gravadoComp, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel12).addComponent(this.txt_noGravado, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel13).addComponent(this.txt_montoIvaInscripto, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel14).addComponent(this.txt_montoIvaNoInscripto, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel15).addComponent(this.txt_exento, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel23).addComponent(this.txt_codMoneda, -2, -1, -2)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel22).addComponent(this.txt_tipoCambio, -2, -1, -2))))).addContainerGap(14, 32767)));
        this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel4.setFont(new Font("Tahoma", 0, 14));
        this.jLabel4.setText("Tipo Comprobante");
        this.jLabel5.setFont(new Font("Tahoma", 0, 14));
        this.jLabel5.setText("Sucursal/Boca");
        this.cmb_tipoComprobante.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIFacturar.this.cmb_tipoComprobanteActionPerformed(evt);
            }
        });
        this.txt_comproNum.setFont(new Font("Tahoma", 0, 14));
        this.txt_comproNum.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIFacturar.this.txt_comproNumActionPerformed(evt);
            }
        });
        this.txt_comproNum.addFocusListener(new FocusAdapter(){

            @Override
            public void focusLost(FocusEvent evt) {
                FIFacturar.this.txt_comproNumFocusLost(evt);
            }
        });
        this.jLabel2.setFont(new Font("Tahoma", 0, 14));
        this.jLabel2.setText("Comprobante Numero");
        this.bt_help_comprobarProximoNumero.setFont(new Font("Tahoma", 0, 14));
        this.bt_help_comprobarProximoNumero.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/signo de pregunta mini.jpg")));
        this.bt_help_comprobarProximoNumero.setToolTipText("Consultar En Afip Proximo Numero");
        this.bt_help_comprobarProximoNumero.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIFacturar.this.bt_help_comprobarProximoNumeroActionPerformed(evt);
            }
        });
        this.bt_buscaComprobante.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/buscar Archivos mini.gif")));
        this.bt_buscaComprobante.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIFacturar.this.bt_buscaComprobanteActionPerformed(evt);
            }
        });
        this.jLabel6.setFont(new Font("Tahoma", 1, 14));
        this.jLabel6.setText("Buscar Comprobante");
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_comproNum, -2, 63, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel4).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.cmb_tipoComprobante, -2, 145, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel5).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.cmb_sucursalBoca, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.bt_buscaComprobante, -2, 46, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.bt_help_comprobarProximoNumero, -2, 25, -2)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel6).addGap(0, 0, 32767))).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.jLabel6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txt_comproNum).addComponent(this.bt_buscaComprobante, -2, 22, -2).addComponent(this.bt_help_comprobarProximoNumero, -2, 19, -2).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jLabel4).addComponent(this.cmb_tipoComprobante, -2, -1, -2).addComponent(this.jLabel5).addComponent(this.cmb_sucursalBoca, -2, -1, -2))).addContainerGap()));
        this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel7.setFont(new Font("Tahoma", 1, 14));
        this.jLabel7.setText("Datos Clientes");
        this.jLabel8.setFont(new Font("Tahoma", 0, 14));
        this.jLabel8.setText("Nombre / Raz\u00f3n Social:");
        this.txt_tipoDocumento.setEditable(false);
        this.txt_tipoDocumento.setFont(new Font("Tahoma", 0, 14));
        this.bt_help_tiposDocumento.setFont(new Font("Tahoma", 0, 14));
        this.bt_help_tiposDocumento.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/signo de pregunta mini.jpg")));
        this.bt_help_tiposDocumento.setToolTipText("Consultar En Afip Tipos Doc");
        this.bt_help_tiposDocumento.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIFacturar.this.bt_help_tiposDocumentoActionPerformed(evt);
            }
        });
        this.txt_responsableIva.setEditable(false);
        this.txt_responsableIva.setFont(new Font("Tahoma", 0, 14));
        this.jLabel9.setFont(new Font("Tahoma", 0, 14));
        this.jLabel9.setText("Responsable Rente al IVA");
        this.bt_help_tiposIva.setFont(new Font("Tahoma", 0, 14));
        this.bt_help_tiposIva.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/signo de pregunta mini.jpg")));
        this.bt_help_tiposIva.setToolTipText("Consultar En Afip Tipo Responsable IVA");
        this.bt_help_tiposIva.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIFacturar.this.bt_help_tiposIvaActionPerformed(evt);
            }
        });
        this.jLabel10.setFont(new Font("Tahoma", 0, 14));
        this.jLabel10.setText("Tipo Documento");
        this.txt_razonSocial.setEditable(false);
        this.txt_razonSocial.setFont(new Font("Tahoma", 0, 14));
        this.jLabel28.setFont(new Font("Tahoma", 0, 14));
        this.jLabel28.setText("Num Doc");
        this.txt_documentoNum.setEditable(false);
        this.txt_documentoNum.setFont(new Font("Tahoma", 0, 14));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel7).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel8).addGap(18, 18, 18).addComponent(this.txt_razonSocial)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel10).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_tipoDocumento, -2, 65, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.bt_help_tiposDocumento, -2, 25, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel28).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txt_documentoNum).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel9).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_responsableIva, -2, 79, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.bt_help_tiposIva, -2, 25, -2))))).addGap(0, 33, 33)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel7).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.bt_help_tiposDocumento, -2, 0, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txt_tipoDocumento).addComponent(this.jLabel10)).addComponent(this.bt_help_tiposIva, -2, 0, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel9).addComponent(this.txt_responsableIva).addComponent(this.jLabel28).addComponent(this.txt_documentoNum))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txt_razonSocial).addComponent(this.jLabel8)).addContainerGap()));
        this.lbl_error.setForeground(new Color(255, 51, 51));
        this.bt_enviarFactura.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/afip.png")));
        this.bt_enviarFactura.setText("Pedir Autorizacion");
        this.bt_enviarFactura.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIFacturar.this.bt_enviarFacturaActionPerformed(evt);
            }
        });
        this.jLabel29.setFont(new Font("Tahoma", 0, 14));
        this.jLabel29.setText("Producto Codigo");
        this.jLabel30.setFont(new Font("Tahoma", 0, 14));
        this.jLabel30.setText("Producto Nomenclador");
        this.txt_productoCodigo.setEditable(false);
        this.txt_productoCodigo.setFont(new Font("Tahoma", 0, 14));
        this.txt_productoCodigo.setHorizontalAlignment(4);
        this.txt_productoCodigo.addKeyListener(new KeyAdapter(){

            @Override
            public void keyPressed(KeyEvent evt) {
                FIFacturar.this.txt_productoCodigoKeyPressed(evt);
            }
        });
        this.txt_productoNomenclador.setEditable(false);
        this.txt_productoNomenclador.setFont(new Font("Tahoma", 0, 14));
        this.txt_productoNomenclador.setHorizontalAlignment(4);
        this.txt_productoNomenclador.addKeyListener(new KeyAdapter(){

            @Override
            public void keyPressed(KeyEvent evt) {
                FIFacturar.this.txt_productoNomencladorKeyPressed(evt);
            }
        });
        GroupLayout pnl_productosLayout = new GroupLayout(this.pnl_productos);
        this.pnl_productos.setLayout(pnl_productosLayout);
        pnl_productosLayout.setHorizontalGroup(pnl_productosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pnl_productosLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel29).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txt_productoCodigo, -2, 154, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel30).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_productoNomenclador, -2, 182, -2).addContainerGap(16, 32767)));
        pnl_productosLayout.setVerticalGroup(pnl_productosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pnl_productosLayout.createSequentialGroup().addContainerGap().addGroup(pnl_productosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel29).addComponent(this.jLabel30).addComponent(this.txt_productoCodigo, -2, -1, -2).addComponent(this.txt_productoNomenclador, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.bt_help_consultarComprobanteAfip.setFont(new Font("Tahoma", 0, 14));
        this.bt_help_consultarComprobanteAfip.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/signo de pregunta mini.jpg")));
        this.bt_help_consultarComprobanteAfip.setToolTipText("Consultar En Afip Comprobante Guardado");
        this.bt_help_consultarComprobanteAfip.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIFacturar.this.bt_help_consultarComprobanteAfipActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(79, 79, 79).addComponent(this.lbl_error, -2, 421, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.bt_help_consultarComprobanteAfip, -2, 25, -2).addContainerGap()).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(layout.createSequentialGroup().addComponent(this.pnl_productos, -2, -1, -2).addGap(4, 4, 4).addComponent(this.bt_enviarFactura)).addComponent(this.jPanel3, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGap(0, 18, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel2, -2, 51, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lbl_error, -2, 27, -2).addComponent(this.bt_help_consultarComprobanteAfip, -2, 19, -2)).addGap(1, 1, 1).addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.pnl_productos, -1, -1, 32767).addComponent(this.bt_enviarFactura, -1, -1, 32767)).addContainerGap(20, 32767)));
        this.pack();
    }

    private void bt_help_comprobarProximoNumeroActionPerformed(ActionEvent evt) {
        this.gestor.buscarUltimoComprobante(this.cmb_sucursalBoca.getSelectedIndex(), this.cmb_tipoComprobante.getSelectedIndex());
    }

    private void bt_help_tiposDocumentoActionPerformed(ActionEvent evt) {
        this.gestor.buscarTiposDocumentos();
    }

    private void bt_help_tiposIvaActionPerformed(ActionEvent evt) {
        this.gestor.buscarTiposIva();
    }

    private void cmb_tipoComprobanteActionPerformed(ActionEvent evt) {
    }

    private void bt_help_buscaMonedasActionPerformed(ActionEvent evt) {
        this.gestor.buscarTipoMonedas();
    }

    private void formComponentShown(ComponentEvent evt) {
        this.cmb_sucursalBoca.setModel(this.gestor.traerSucursales());
        this.cmb_tipoComprobante.setModel(this.gestor.traerTiposComprobantes());
    }

    private void facturaProcesa() {
        this.buscaComprobante();
        if (this.gestor.tengoFactura() && this.gestor.tengoMovimientosFactura()) {
            if (this.gestor.estaFacturado()) {
                this.bt_help_consultarComprobanteAfip.setVisible(true);
                if (this.gestor.tengoPermisoParaFacturarFacturado()) {
                    this.bt_enviarFactura.setEnabled(true);
                    this.lbl_error.setText(this.lbl_error.getText() + " - El Comprobante Ya Fue Facturado!");
                } else {
                    this.bt_enviarFactura.setEnabled(false);
                    this.lbl_error.setText(this.lbl_error.getText() + " - -El Comprobante Ya Fue Facturado!, Necesita de Permiso para Poder Volver a Hacerlo");
                }
            } else {
                this.bt_help_consultarComprobanteAfip.setVisible(false);
                if (this.lbl_error.getText().equals("")) {
                    this.bt_enviarFactura.setEnabled(true);
                }
            }
        } else {
            this.bt_enviarFactura.setEnabled(false);
        }
    }

    private void txt_comproNumActionPerformed(ActionEvent evt) {
    }

    private void buscaComprobante() {
        this.bt_help_consultarComprobanteAfip.setVisible(false);
        try {
            if (Utilerias.isNumeric(this.txt_comproNum.getText())) {
                this.gestor.buscarComprobante(this.txt_comproNum.getText(), this.cmb_sucursalBoca.getSelectedIndex(), this.cmb_tipoComprobante.getSelectedItem());
                this.cargarPantallaFactura();
                if (!this.gestor.tengoMovimientosFactura()) {
                    this.lbl_error.setText("No se encuentran Detalle Imputaciones");
                }
            }
        }
        catch (Exception ex) {
            this.limpiarPantalla();
            this.lbl_error.setText("No se encuentra el Comprobante");
        }
    }

    private void bt_buscaComprobanteActionPerformed(ActionEvent evt) {
        this.facturaProcesa();
    }

    private void bt_enviarFacturaActionPerformed(ActionEvent evt) {
        if (!this.gestor.tengoProductos()) {
            this.gestor.tomarProductos(this.txt_productoCodigo.getText(), this.txt_productoNomenclador.getText());
        }
        this.gestor.enviarFactura();
    }

    private void bt_help_consultarComprobanteAfipActionPerformed(ActionEvent evt) {
        if (Utilerias.isNumeric(this.txt_comproNum.getText())) {
            this.gestor.buscarComprobante(this.cmb_sucursalBoca.getSelectedIndex(), this.cmb_tipoComprobante.getSelectedIndex(), this.txt_comproNum.getText());
        }
    }

    private void txt_comproNumFocusLost(FocusEvent evt) {
        this.facturaProcesa();
    }

    private void formComponentHidden(ComponentEvent evt) {
        this.gestor.cerrarConexiones();
    }

    private void txt_productoCodigoKeyPressed(KeyEvent evt) {
        if (this.txt_productoCodigo.getText().length() > 0 && this.txt_productoNomenclador.getText().length() > 0) {
            this.bt_enviarFactura.setEnabled(true);
        } else {
            this.bt_enviarFactura.setEnabled(false);
        }
    }

    private void txt_productoNomencladorKeyPressed(KeyEvent evt) {
        if (this.txt_productoCodigo.getText().length() > 0 && this.txt_productoNomenclador.getText().length() > 0) {
            this.bt_enviarFactura.setEnabled(true);
        } else {
            this.bt_enviarFactura.setEnabled(false);
        }
    }

    private void buscarValoresGestor() {
        this.txt_compNumMostrar.setText(this.gestor.getNumComprobante());
        this.txt_sucBocMostrar.setText(this.gestor.getBocMostrar());
        this.txt_tipoCompoMostrar.setText(this.gestor.getTipoComproMostrar());
        this.txt_codMoneda.setText(this.gestor.getCodMoneda());
        this.txt_exento.setText(this.gestor.getMontoExento());
        this.txt_fechaComprobante.setText(this.gestor.getFechaComprobante());
        this.txt_gravadoComp.setText(this.gestor.getGravadoComp());
        this.txt_impuestoInternos.setText(this.gestor.getImpuestoInterno());
        this.txt_montoIvaInscripto.setText(this.gestor.getIvaInscripto());
        this.txt_montoIvaNoInscripto.setText(this.gestor.getIvaNoInscripto());
        this.txt_noGravado.setText(this.gestor.getNoGravado());
        this.txt_percep_Municipales.setText(this.gestor.getpercepMunicipales());
        this.txt_percep_ingresosBrutos.setText(this.gestor.getpercepIngresosBrutos());
        this.txt_percep_nacionales.setText(this.gestor.getpercepNacionales());
        this.txt_razonSocial.setText(this.gestor.getRazonSocial());
        this.txt_responsableIva.setText(this.gestor.getresponsableIva());
        this.txt_tipoCambio.setText(this.gestor.getTipoCambio());
        this.txt_tipoDocumento.setText(this.gestor.getTipoDocumento());
        this.txt_total.setText(this.gestor.getTotal());
        this.txt_documentoNum.setText(this.gestor.getdocumentoNumero());
        if (this.gestor.esFiscal()) {
            this.pnl_productos.setVisible(true);
            if (this.gestor.tengoProductos()) {
                this.txt_productoCodigo.setText(this.gestor.getproductoCodigo());
                this.txt_productoNomenclador.setText(this.gestor.getproductoNomenclador());
            } else {
                this.txt_productoCodigo.setEditable(true);
                this.txt_productoNomenclador.setEditable(true);
                this.lbl_error.setText("Debe Ingresar Producto, No Cargado");
            }
        } else {
            this.pnl_productos.setVisible(false);
        }
        this.txt_percep_nacionales_porcentaje.setText(this.gestor.getDetallePercepNacionalesPorcep());
        this.txt_precep_ingresosBrutos_porcep.setText(this.gestor.getDetallePercepIngBrutosPorcep());
        this.txt_precep_municapales_porcep.setText(this.gestor.getDetallePercepMunicipalesPercep());
        this.txt_impuestoInterno_porcep.setText(this.gestor.getDetallePercepInternos());
    }

    private void cargarPantallaFactura() {
        this.limpiarPantalla();
        this.buscarValoresGestor();
    }

    private void limpiarPantalla() {
        this.txt_codMoneda.setText("");
        this.txt_exento.setText("");
        this.txt_fechaComprobante.setText("");
        this.txt_gravadoComp.setText("");
        this.txt_impuestoInterno_porcep.setText("");
        this.txt_impuestoInternos.setText("");
        this.txt_montoIvaInscripto.setText("");
        this.txt_montoIvaNoInscripto.setText("");
        this.txt_noGravado.setText("");
        this.txt_percep_Municipales.setText("");
        this.txt_percep_ingresosBrutos.setText("");
        this.txt_percep_nacionales.setText("");
        this.txt_percep_nacionales_porcentaje.setText("");
        this.txt_precep_ingresosBrutos_porcep.setText("");
        this.txt_precep_municapales_porcep.setText("");
        this.txt_razonSocial.setText("");
        this.txt_responsableIva.setText("");
        this.txt_tipoCambio.setText("");
        this.txt_tipoDocumento.setText("");
        this.txt_total.setText("");
        this.lbl_error.setText("");
        this.txt_compNumMostrar.setText("");
        this.txt_sucBocMostrar.setText("");
        this.txt_tipoCompoMostrar.setText("");
        this.txt_documentoNum.setText("");
        this.txt_productoCodigo.setText("");
        this.txt_productoNomenclador.setText("");
        this.txt_productoCodigo.setEditable(false);
        this.txt_productoNomenclador.setEditable(false);
    }

}

