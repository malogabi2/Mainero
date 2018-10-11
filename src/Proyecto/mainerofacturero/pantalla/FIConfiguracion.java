/*
 * Decompiled with CFR 0_124.
 * 
 * Could not load the following classes:
 *  org.jdesktop.swingx.JXTable
 */
package Proyecto.mainerofacturero.pantalla;

import Proyecto.GestorPantallas.GestorFIConfiguracion;
import Proyecto.modelo.Configuracion;
import Proyecto.utilerias.Utilerias;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jdesktop.swingx.JXTable;

public class FIConfiguracion
extends JInternalFrame {
    GestorFIConfiguracion gestor;
    private JButton bt_aceptar;
    private JToggleButton bt_agregarSuc;
    private JToggleButton bt_agregarTipoCompro;
    private JToggleButton bt_borrarSuc;
    private JToggleButton bt_borrarTipoCompro;
    private JButton bt_buscarArchivos;
    private JToggleButton bt_help_BuscarIDWsbfe;
    private JToggleButton bt_help_BuscarSucursales;
    private JToggleButton bt_help_BuscarTiposComprobantes;
    private JToggleButton bt_help_BuscarToken;
    private JCheckBox chk_esAutomaticoPedido;
    private JCheckBox chk_esBonosFiscales;
    private JComboBox cmb_tiposComprobAfip;
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
    private JLabel jLabel3;
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
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JLabel lbl_error;
    private JPanel pnl_archivos;
    private JSpinner spn_cantidadHoras;
    private JXTable tbl_tablitasSucursales;
    private JXTable tbl_tablitasTipoComprobantes;
    private JTextField txt_archivoConf;
    private JTextField txt_cantidadMaximaFact;
    private JPasswordField txt_claveODBC;
    private JTextField txt_cuit;
    private JTextField txt_idWBSFE;
    private JTextField txt_nombreODBC;
    private JTextField txt_nombreSuc;
    private JTextField txt_numSuc;
    private JTextField txt_numeroComprobReal;
    private JTextField txt_tiempoEspera;
    private JTextField txt_usuarioODBC;

    public FIConfiguracion(JDesktopPane escr, Configuracion config) {
        this.initComponents();
        this.gestor = new GestorFIConfiguracion(escr, config);
    }

    private void initComponents() {
        this.pnl_archivos = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel3 = new JLabel();
        this.txt_archivoConf = new JTextField();
        this.bt_buscarArchivos = new JButton();
        this.jPanel1 = new JPanel();
        this.jLabel4 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jPanel2 = new JPanel();
        this.jLabel5 = new JLabel();
        this.txt_numSuc = new JTextField();
        this.jLabel6 = new JLabel();
        this.txt_nombreSuc = new JTextField();
        this.chk_esBonosFiscales = new JCheckBox();
        this.bt_agregarSuc = new JToggleButton();
        this.bt_borrarSuc = new JToggleButton();
        this.bt_help_BuscarSucursales = new JToggleButton();
        this.jScrollPane1 = new JScrollPane();
        this.tbl_tablitasSucursales = new JXTable();
        this.jLabel13 = new JLabel();
        this.jPanel5 = new JPanel();
        this.chk_esAutomaticoPedido = new JCheckBox();
        this.jLabel15 = new JLabel();
        this.spn_cantidadHoras = new JSpinner();
        this.jLabel16 = new JLabel();
        this.bt_help_BuscarToken = new JToggleButton();
        this.jPanel6 = new JPanel();
        this.jLabel17 = new JLabel();
        this.jLabel18 = new JLabel();
        this.txt_numeroComprobReal = new JTextField();
        this.bt_agregarTipoCompro = new JToggleButton();
        this.bt_borrarTipoCompro = new JToggleButton();
        this.bt_help_BuscarTiposComprobantes = new JToggleButton();
        this.cmb_tiposComprobAfip = new JComboBox();
        this.jScrollPane2 = new JScrollPane();
        this.tbl_tablitasTipoComprobantes = new JXTable();
        this.jLabel19 = new JLabel();
        this.lbl_error = new JLabel();
        this.jLabel14 = new JLabel();
        this.jPanel7 = new JPanel();
        this.txt_idWBSFE = new JTextField();
        this.jLabel20 = new JLabel();
        this.bt_help_BuscarIDWsbfe = new JToggleButton();
        this.jPanel3 = new JPanel();
        this.jLabel7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.txt_nombreODBC = new JTextField();
        this.jLabel9 = new JLabel();
        this.txt_cantidadMaximaFact = new JTextField();
        this.jLabel10 = new JLabel();
        this.txt_claveODBC = new JPasswordField();
        this.jLabel21 = new JLabel();
        this.txt_usuarioODBC = new JTextField();
        this.jLabel22 = new JLabel();
        this.txt_tiempoEspera = new JTextField();
        this.bt_aceptar = new JButton();
        this.jPanel4 = new JPanel();
        this.jLabel11 = new JLabel();
        this.jLabel12 = new JLabel();
        this.txt_cuit = new JTextField();
        this.addComponentListener(new ComponentAdapter(){

            @Override
            public void componentShown(ComponentEvent evt) {
                FIConfiguracion.this.formComponentShown(evt);
            }
        });
        this.pnl_archivos.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel1.setFont(new Font("Tahoma", 0, 14));
        this.jLabel1.setText("Configuracion Servidores Web Afip:");
        this.jLabel3.setFont(new Font("Tahoma", 1, 14));
        this.jLabel3.setText("Archivos");
        this.txt_archivoConf.setEditable(false);
        this.bt_buscarArchivos.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/buscar Archivos mini.gif")));
        this.bt_buscarArchivos.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIConfiguracion.this.bt_buscarArchivosActionPerformed(evt);
            }
        });
        GroupLayout pnl_archivosLayout = new GroupLayout(this.pnl_archivos);
        this.pnl_archivos.setLayout(pnl_archivosLayout);
        pnl_archivosLayout.setHorizontalGroup(pnl_archivosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pnl_archivosLayout.createSequentialGroup().addGroup(pnl_archivosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pnl_archivosLayout.createSequentialGroup().addComponent(this.jLabel3).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, pnl_archivosLayout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txt_archivoConf).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.bt_buscarArchivos, -2, 41, -2))).addContainerGap()));
        pnl_archivosLayout.setVerticalGroup(pnl_archivosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pnl_archivosLayout.createSequentialGroup().addComponent(this.jLabel3).addGap(5, 5, 5).addGroup(pnl_archivosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pnl_archivosLayout.createSequentialGroup().addComponent(this.bt_buscarArchivos, -2, 22, 32767).addContainerGap()).addGroup(pnl_archivosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.txt_archivoConf)))));
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel4.setFont(new Font("Tahoma", 1, 14));
        this.jLabel4.setText("Configuracion General");
        this.jLabel2.setFont(new Font("Tahoma", 0, 14));
        this.jLabel2.setText("Sucursales");
        this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel5.setFont(new Font("Tahoma", 0, 14));
        this.jLabel5.setText("Num Suc");
        this.txt_numSuc.setFont(new Font("Tahoma", 0, 13));
        this.jLabel6.setFont(new Font("Tahoma", 0, 14));
        this.jLabel6.setText("Nombre Suc");
        this.txt_nombreSuc.setFont(new Font("Tahoma", 0, 13));
        this.chk_esBonosFiscales.setFont(new Font("Tahoma", 0, 14));
        this.chk_esBonosFiscales.setText("Es Bono Fiscales");
        this.bt_agregarSuc.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/sumar.jpg")));
        this.bt_agregarSuc.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIConfiguracion.this.bt_agregarSucActionPerformed(evt);
            }
        });
        this.bt_borrarSuc.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/menos.png")));
        this.bt_borrarSuc.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIConfiguracion.this.bt_borrarSucActionPerformed(evt);
            }
        });
        this.bt_help_BuscarSucursales.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/signo de pregunta mini.jpg")));
        this.bt_help_BuscarSucursales.setToolTipText("Buscar Sucursales Habilitadas");
        this.bt_help_BuscarSucursales.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIConfiguracion.this.bt_help_BuscarSucursalesActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_numSuc, -2, 47, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel6).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txt_nombreSuc).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.chk_esBonosFiscales).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.bt_agregarSuc, -2, 38, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.bt_borrarSuc, -2, 31, -2).addGap(18, 18, 18).addComponent(this.bt_help_BuscarSucursales, -2, 32, -2)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.txt_numSuc, -2, -1, -2).addComponent(this.jLabel6).addComponent(this.txt_nombreSuc, -2, -1, -2).addComponent(this.chk_esBonosFiscales)).addComponent(this.bt_agregarSuc, -2, 18, -2).addComponent(this.bt_borrarSuc, -2, 18, -2)).addGap(0, 0, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.bt_help_BuscarSucursales, -2, 20, -2).addContainerGap()));
        this.tbl_tablitasSucursales.setModel((TableModel)new DefaultTableModel(new Object[0][], new String[]{"Numero Sucursal", "Nombre / Detalle Surcursal", "Es Bono Fiscal?"}){
            Class[] types;
            boolean[] canEdit;
            {
                //super(x0, x1);
                this.types = new Class[]{Object.class, Object.class, Boolean.class};
                this.canEdit = new boolean[]{false, false, false};
            }

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.jScrollPane1.setViewportView((Component)this.tbl_tablitasSucursales);
        this.jLabel13.setFont(new Font("Tahoma", 0, 14));
        this.jLabel13.setText("Gestion de Llaves AFIP");
        this.jPanel5.setBorder(BorderFactory.createEtchedBorder());
        this.chk_esAutomaticoPedido.setFont(new Font("Tahoma", 0, 14));
        this.chk_esAutomaticoPedido.setText("Es Automatico El pedido?");
        this.jLabel15.setFont(new Font("Tahoma", 0, 14));
        this.jLabel15.setText("Se Renueva cada");
        this.spn_cantidadHoras.setFont(new Font("Tahoma", 0, 14));
        this.spn_cantidadHoras.setToolTipText("");
        this.jLabel16.setFont(new Font("Tahoma", 0, 14));
        this.jLabel16.setText("Horas");
        this.bt_help_BuscarToken.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/signo de pregunta mini.jpg")));
        this.bt_help_BuscarToken.setToolTipText("Ver Token Pedidos");
        this.bt_help_BuscarToken.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIConfiguracion.this.bt_help_BuscarTokenActionPerformed(evt);
            }
        });
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.chk_esAutomaticoPedido, -2, 203, -2).addGap(50, 50, 50).addComponent(this.jLabel15).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.spn_cantidadHoras, -2, 98, -2).addGap(41, 41, 41).addComponent(this.jLabel16).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.bt_help_BuscarToken, -2, 28, -2)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.bt_help_BuscarToken, GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.chk_esAutomaticoPedido, -2, 22, -2).addComponent(this.jLabel15).addComponent(this.spn_cantidadHoras, -2, -1, -2).addComponent(this.jLabel16)));
        this.jPanel6.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel17.setFont(new Font("Tahoma", 0, 14));
        this.jLabel17.setText("Tipo Comprobante AFIP");
        this.jLabel18.setFont(new Font("Tahoma", 0, 14));
        this.jLabel18.setText("Numero Sistema");
        this.txt_numeroComprobReal.setFont(new Font("Tahoma", 0, 13));
        this.bt_agregarTipoCompro.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/sumar.jpg")));
        this.bt_agregarTipoCompro.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIConfiguracion.this.bt_agregarTipoComproActionPerformed(evt);
            }
        });
        this.bt_borrarTipoCompro.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/menos.png")));
        this.bt_borrarTipoCompro.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIConfiguracion.this.bt_borrarTipoComproActionPerformed(evt);
            }
        });
        this.bt_help_BuscarTiposComprobantes.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/signo de pregunta mini.jpg")));
        this.bt_help_BuscarTiposComprobantes.setToolTipText("Buscar Sucursales Habilitadas");
        this.bt_help_BuscarTiposComprobantes.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIConfiguracion.this.bt_help_BuscarTiposComprobantesActionPerformed(evt);
            }
        });
        this.tbl_tablitasTipoComprobantes.setModel((TableModel)new DefaultTableModel(new Object[0][], new String[]{"Comprobante", "Numero AFIP", "Numero Real"}){
            boolean[] canEdit;
            {
                //super(x0, x1);
                this.canEdit = new boolean[]{false, false, false};
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.jScrollPane2.setViewportView((Component)this.tbl_tablitasTipoComprobantes);
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.jLabel17).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cmb_tiposComprobAfip, 0, -1, 32767).addGap(47, 47, 47).addComponent(this.jLabel18).addGap(18, 18, 18).addComponent(this.txt_numeroComprobReal, -2, 58, -2).addGap(70, 70, 70).addComponent(this.bt_agregarTipoCompro, -2, 38, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.bt_borrarTipoCompro, -2, 31, -2).addGap(18, 18, 18).addComponent(this.bt_help_BuscarTiposComprobantes, -2, 28, -2)).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.jScrollPane2, -2, 783, -2).addGap(0, 0, 32767)));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel17).addComponent(this.cmb_tiposComprobAfip, -2, -1, -2).addComponent(this.jLabel18).addComponent(this.txt_numeroComprobReal, -2, -1, -2)).addComponent(this.bt_agregarTipoCompro, -2, 18, -2).addComponent(this.bt_borrarTipoCompro, -2, 18, -2).addComponent(this.bt_help_BuscarTiposComprobantes, -2, 20, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 73, -2).addGap(0, 0, 32767)));
        this.jLabel19.setFont(new Font("Tahoma", 0, 14));
        this.jLabel19.setText("Tipo Comprobante");
        this.lbl_error.setForeground(new Color(255, 0, 0));
        this.jLabel14.setFont(new Font("Tahoma", 0, 14));
        this.jLabel14.setText("ID WSBFE Server Facturacion");
        this.jPanel7.setBorder(BorderFactory.createEtchedBorder());
        this.txt_idWBSFE.setFont(new Font("Tahoma", 0, 14));
        this.txt_idWBSFE.addFocusListener(new FocusAdapter(){

            @Override
            public void focusLost(FocusEvent evt) {
                FIConfiguracion.this.txt_idWBSFEFocusLost(evt);
            }
        });
        this.jLabel20.setFont(new Font("Tahoma", 0, 14));
        this.jLabel20.setText("Ultimo ID WBFS");
        this.bt_help_BuscarIDWsbfe.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/signo de pregunta mini.jpg")));
        this.bt_help_BuscarIDWsbfe.setToolTipText("Ver Token Pedidos");
        this.bt_help_BuscarIDWsbfe.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIConfiguracion.this.bt_help_BuscarIDWsbfeActionPerformed(evt);
            }
        });
        GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
        this.jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.jLabel20).addGap(18, 18, 18).addComponent(this.txt_idWBSFE, -2, 88, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.bt_help_BuscarIDWsbfe, -2, 30, -2)));
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txt_idWBSFE, -2, -1, -2).addComponent(this.jLabel20)).addComponent(this.bt_help_BuscarIDWsbfe, -2, 20, -2));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel4).addGap(0, 0, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel14).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel2).addGap(141, 141, 141).addComponent(this.lbl_error, -2, 364, -2)).addComponent(this.jLabel13).addComponent(this.jLabel19).addComponent(this.jPanel6, -1, -1, 32767).addComponent(this.jScrollPane1).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jPanel7, -1, -1, 32767).addComponent(this.jPanel5, -1, -1, 32767)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel4, -2, 17, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel2)).addComponent(this.lbl_error, -2, 38, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, 29, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 72, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel19).addGap(7, 7, 7).addComponent(this.jPanel6, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel13).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel5, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel14).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel7, -2, -1, -2)));
        this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel7.setFont(new Font("Tahoma", 1, 14));
        this.jLabel7.setText("Configuracion ODBC");
        this.jLabel8.setFont(new Font("Tahoma", 0, 14));
        this.jLabel8.setText("Usuario");
        this.txt_nombreODBC.setFont(new Font("Tahoma", 0, 13));
        this.jLabel9.setFont(new Font("Tahoma", 0, 14));
        this.jLabel9.setText("Nombre ODBC");
        this.txt_cantidadMaximaFact.setFont(new Font("Tahoma", 0, 13));
        this.jLabel10.setFont(new Font("Tahoma", 0, 14));
        this.jLabel10.setText("Clave");
        this.txt_claveODBC.setFont(new Font("Tahoma", 0, 13));
        this.jLabel21.setFont(new Font("Tahoma", 0, 14));
        this.jLabel21.setText("Cantidad Maxima Filas DB Facturar");
        this.txt_usuarioODBC.setFont(new Font("Tahoma", 0, 13));
        this.jLabel22.setFont(new Font("Tahoma", 0, 14));
        this.jLabel22.setText("Time Espera (segundos)");
        this.txt_tiempoEspera.setFont(new Font("Tahoma", 0, 13));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel7).addGap(0, 0, 32767)).addGroup(jPanel3Layout.createSequentialGroup().addGap(27, 27, 27).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel22).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel9).addComponent(this.jLabel10)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.txt_nombreODBC, -2, 234, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel8).addGap(33, 33, 33).addComponent(this.txt_usuarioODBC)).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.txt_claveODBC, -2, 234, -2).addComponent(this.txt_tiempoEspera, -2, 182, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel21).addGap(18, 18, 18).addComponent(this.txt_cantidadMaximaFact, -2, 89, -2))))).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel7).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txt_nombreODBC, -2, -1, -2).addComponent(this.jLabel8).addComponent(this.jLabel9).addComponent(this.txt_usuarioODBC, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel10).addComponent(this.txt_claveODBC, -2, -1, -2).addComponent(this.jLabel21).addComponent(this.txt_cantidadMaximaFact, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel22).addComponent(this.txt_tiempoEspera, -2, -1, -2)).addGap(14, 14, 14)));
        this.bt_aceptar.setText("Aceptar");
        this.bt_aceptar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIConfiguracion.this.bt_aceptarActionPerformed(evt);
            }
        });
        this.jPanel4.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel11.setFont(new Font("Tahoma", 1, 14));
        this.jLabel11.setText("Datos Empresa");
        this.jLabel12.setFont(new Font("Tahoma", 0, 14));
        this.jLabel12.setText("CUIT de La Empresa");
        this.txt_cuit.setFont(new Font("Tahoma", 0, 13));
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel11).addGap(0, 0, 32767)).addGroup(jPanel4Layout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.jLabel12).addGap(18, 18, 18).addComponent(this.txt_cuit, -2, 290, -2).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel11).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel12).addComponent(this.txt_cuit, -2, -1, -2)).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jPanel4, -1, -1, 32767).addComponent(this.jPanel3, -1, -1, 32767).addComponent(this.pnl_archivos, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.bt_aceptar).addContainerGap()))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.pnl_archivos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel4, -2, 54, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.bt_aceptar)));
        this.pack();
    }

    private void bt_buscarArchivosActionPerformed(ActionEvent evt) {
        this.txt_archivoConf.setText(this.gestor.traerArchivoConfiguracion());
    }

    private boolean controlarAgregarSuc() {
        if (!Utilerias.isNumeric(this.txt_numSuc.getText())) {
            this.lbl_error.setText("Numero Sucursal no Valido");
            return false;
        }
        if (this.gestor.estaSucursal(Integer.valueOf(this.txt_numSuc.getText()))) {
            this.lbl_error.setText("Sucursal Ya Cargada");
            return false;
        }
        return true;
    }

    private boolean controlarAgregarTipoComprobante() {
        if (!Utilerias.isNumeric(this.txt_numeroComprobReal.getText())) {
            this.lbl_error.setText("Numero de Comprobante real no Valido");
            return false;
        }
        if (this.gestor.estaTipoDocumento(Integer.valueOf(this.txt_numeroComprobReal.getText()), this.cmb_tiposComprobAfip.getSelectedIndex())) {
            this.lbl_error.setText("Numero de Comprobante Ya Cargado");
            return false;
        }
        return true;
    }

    private void bt_agregarSucActionPerformed(ActionEvent evt) {
        if (this.controlarAgregarSuc()) {
            this.tbl_tablitasSucursales.setModel(this.gestor.agregarSucursal(this.txt_numSuc.getText(), this.txt_nombreSuc.getText(), this.chk_esBonosFiscales.isSelected(), this.tbl_tablitasSucursales.getModel()));
            this.limpiarTxtSucursal();
        }
    }

    private void bt_borrarSucActionPerformed(ActionEvent evt) {
        this.tbl_tablitasSucursales.setModel(this.gestor.borrarSucursal(this.tbl_tablitasSucursales.getSelectedRow(), this.tbl_tablitasSucursales.getModel()));
    }

    private void bt_aceptarActionPerformed(ActionEvent evt) {
        if (this.txt_cuit.getText().equals("")) {
            this.lbl_error.setText("Debe escribir un CUIT");
        } else if (this.lbl_error.getText().contains("Debe escribir un CUIT")) {
            this.lbl_error.setText("");
        }
        if (this.txt_archivoConf.getText().equals("")) {
            this.lbl_error.setText("Debe Seleccionar un Archivo de Configuracion");
        } else if (this.lbl_error.getText().contains("Debe Seleccionar un Archivo de Configuracion")) {
            this.lbl_error.setText("");
        }
        if (this.tbl_tablitasSucursales.getRowCount() == 0) {
            this.lbl_error.setText("Debe agregar al menos una Sucursal");
        } else if (this.lbl_error.getText().contains("Debe agregar al menos una Sucursal")) {
            this.lbl_error.setText("");
        }
        if (this.txt_nombreODBC.getText().equals("") || !Utilerias.isNumeric(this.txt_cantidadMaximaFact.getText()) || this.txt_cantidadMaximaFact.getText().equals("") || new String(this.txt_claveODBC.getPassword()).equals("") || !Utilerias.isNumeric(this.txt_tiempoEspera.getText()) || this.txt_tiempoEspera.getText().equals("")) {
            this.lbl_error.setText("Problemas en la carga del ODBC");
        } else if (this.lbl_error.getText().contains("Problemas en la carga del ODBC")) {
            this.lbl_error.setText("");
        }
        if (this.lbl_error.getText().equals("")) {
            this.gestor.guardarConfiguracion(this.txt_nombreODBC.getText(), this.txt_usuarioODBC.getText(), new String(this.txt_claveODBC.getPassword()), this.txt_cuit.getText(), this.chk_esAutomaticoPedido.isSelected(), Integer.valueOf(String.valueOf(this.spn_cantidadHoras.getValue())), Integer.valueOf(this.txt_idWBSFE.getText()), Integer.valueOf(this.txt_cantidadMaximaFact.getText()), Integer.valueOf(this.txt_tiempoEspera.getText()));
            this.dispose();
        }
    }

    private void formComponentShown(ComponentEvent evt) {
        this.tbl_tablitasSucursales.setModel((TableModel)this.gestor.buscarItemsSucursal(this.tbl_tablitasSucursales.getModel()));
        this.tbl_tablitasTipoComprobantes.setModel(this.gestor.buscarItmsTipoComprobante(this.tbl_tablitasTipoComprobantes.getModel()));
        this.txt_archivoConf.setText(this.gestor.mostrarArchivoConfig());
        this.txt_nombreODBC.setText(this.gestor.mostrarNombreODBC());
        this.txt_cantidadMaximaFact.setText(this.gestor.mostrarUsuario());
        this.txt_claveODBC.setText(this.gestor.mostrarClave());
        this.txt_cuit.setText(this.gestor.mostrarCuit());
        this.chk_esAutomaticoPedido.setSelected(this.gestor.mostrarSiEsAutoPedidoLlave());
        this.spn_cantidadHoras.setValue(this.gestor.mostrarCantidadHorasPedidoLlanve());
        this.cmb_tiposComprobAfip.setModel(new DefaultComboBoxModel<String>(this.gestor.mostrarTiposComprobantesAFIPCombo()));
        this.txt_idWBSFE.setText(this.gestor.mostrarIDWSBFE());
        this.txt_cantidadMaximaFact.setText(String.valueOf(this.gestor.mostrarCantFilaFact()));
        this.txt_usuarioODBC.setText(this.gestor.mostrarUsuario());
        this.txt_tiempoEspera.setText(String.valueOf(this.gestor.mostrarTiempoEspera()));
    }

    private void bt_help_BuscarSucursalesActionPerformed(ActionEvent evt) {
        this.gestor.consultarAfipSucursales(this.chk_esBonosFiscales.isSelected());
    }

    private void bt_help_BuscarTokenActionPerformed(ActionEvent evt) {
        this.gestor.mostrarTokens();
    }

    private void bt_agregarTipoComproActionPerformed(ActionEvent evt) {
        if (this.controlarAgregarTipoComprobante()) {
            this.tbl_tablitasTipoComprobantes.setModel(this.gestor.agregarTipoComprobantes(this.txt_numeroComprobReal.getText(), this.cmb_tiposComprobAfip.getSelectedIndex(), this.tbl_tablitasTipoComprobantes.getModel()));
            this.limpiarTxtTipoComprobante();
            this.lbl_error.setText("");
        }
    }

    private void bt_borrarTipoComproActionPerformed(ActionEvent evt) {
        this.tbl_tablitasTipoComprobantes.setModel(this.gestor.borrarTipoComprobante(this.tbl_tablitasTipoComprobantes.getSelectedRow(), this.tbl_tablitasTipoComprobantes.getModel()));
    }

    private void bt_help_BuscarTiposComprobantesActionPerformed(ActionEvent evt) {
        this.gestor.buscarTiposComprobantesEnAfip();
    }

    private void bt_help_BuscarIDWsbfeActionPerformed(ActionEvent evt) {
        this.gestor.buscarIDWSFEAfip();
    }

    private void txt_idWBSFEFocusLost(FocusEvent evt) {
        if (!Utilerias.isNumeric(this.txt_idWBSFE.getText())) {
            this.lbl_error.setText("El ID Cargado En WSFBE no es un Numero Valido");
        } else {
            this.lbl_error.setText("");
        }
    }

    private void limpiarTxtSucursal() {
        this.txt_nombreSuc.setText("");
        this.txt_numSuc.setText("");
        this.lbl_error.setText("");
    }

    private void limpiarTxtTipoComprobante() {
        this.txt_numeroComprobReal.setText("");
    }

}

