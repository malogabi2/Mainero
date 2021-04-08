/*
 * Decompiled with CFR 0_124.
 * 
 * Could not load the following classes:
 *  org.jdesktop.swingx.JXTable
 */
package Proyecto.mainerofacturero.pantalla;

import Proyecto.GestorPantallas.GestorFIFacturaras;
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
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jdesktop.swingx.JXTable;

public class FIFacturas
extends JInternalFrame {
    GestorFIFacturaras gestor;
    private JButton bt_EnviarFacturaAfip;
    private JToggleButton bt_consultarAfip;
    private JToggleButton bt_facturas;
    private JToggleButton bt_filtrar;
    private JToggleButton bt_noFacturadas;
    private JToggleButton bt_todasFacturadas;
    private JComboBox cmb_sucursal;
    private JComboBox cmb_tipoComprobante;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JLabel lbl_error;
    private JXTable tbl_facturas;
    private JTextField txt_cantidadFilas;

    public FIFacturas() {
        this.initComponents();
    }

    public void setConfiguracion(Configuracion conf) {
        this.gestor = new GestorFIFacturaras(conf);
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel3 = new JLabel();
        this.cmb_sucursal = new JComboBox();
        this.jLabel2 = new JLabel();
        this.cmb_tipoComprobante = new JComboBox();
        this.txt_cantidadFilas = new JTextField();
        this.jLabel1 = new JLabel();
        this.bt_filtrar = new JToggleButton();
        this.jPanel2 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.tbl_facturas = new JXTable();
        this.bt_todasFacturadas = new JToggleButton();
        this.bt_noFacturadas = new JToggleButton();
        this.bt_facturas = new JToggleButton();
        this.lbl_error = new JLabel();
        this.bt_EnviarFacturaAfip = new JButton();
        this.bt_consultarAfip = new JToggleButton();
        this.addComponentListener(new ComponentAdapter(){

            @Override
            public void componentShown(ComponentEvent evt) {
                FIFacturas.this.formComponentShown(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel3.setFont(new Font("Tahoma", 0, 18));
        this.jLabel3.setText("Sucursal");
        this.cmb_sucursal.setFont(new Font("Tahoma", 0, 14));
        this.jLabel2.setFont(new Font("Tahoma", 0, 18));
        this.jLabel2.setText("Tipo Comprobantes");
        this.cmb_tipoComprobante.setFont(new Font("Tahoma", 0, 14));
        this.txt_cantidadFilas.setFont(new Font("Tahoma", 0, 18));
        this.txt_cantidadFilas.setHorizontalAlignment(4);
        this.txt_cantidadFilas.setText("100");
        this.txt_cantidadFilas.addFocusListener(new FocusAdapter(){

            @Override
            public void focusLost(FocusEvent evt) {
                FIFacturas.this.txt_cantidadFilasFocusLost(evt);
            }
        });
        this.jLabel1.setFont(new Font("Tahoma", 0, 18));
        this.jLabel1.setText("Ver Las Primeras:");
        this.bt_filtrar.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/buscar mini.jpg")));
        this.bt_filtrar.setText("Filtrar");
        this.bt_filtrar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIFacturas.this.bt_filtrarActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_cantidadFilas, -2, 84, -2).addGap(18, 18, 18).addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.cmb_sucursal, -2, 143, -2).addGap(18, 18, 18).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.cmb_tipoComprobante, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.bt_filtrar).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.txt_cantidadFilas, -2, -1, -2).addComponent(this.jLabel3).addComponent(this.cmb_sucursal, -2, -1, -2).addComponent(this.jLabel2).addComponent(this.cmb_tipoComprobante, -2, -1, -2).addComponent(this.bt_filtrar, -2, 24, -2)));
        this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
        this.tbl_facturas.setModel((TableModel)new DefaultTableModel(new Object[0][], new String[]{"Sel", "Esta Facturada", "Tip Com", "Suc", "Num Com", "Tip Doc Cli", "Nume Doc Cli", "Nom Cli", "Tip Iva", "Imp Grav", "Imp No Grav", "Iva Ins", "Iva No Insc", "Imp Ex", "Perp. Nac", "Perp. IIBB", "Perp Mun", "Imp Int", "Codi Mon", "Tip Cambio", "CAE", "Imp Tot"}){
            Class[] types;
            boolean[] canEdit;
            {
              //  super(x0, x1);
                this.types = new Class[]{Boolean.class, Boolean.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class};
                this.canEdit = new boolean[]{true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false};
            }

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.tbl_facturas.setFont(new Font("Tahoma", 0, 12));
        this.jScrollPane1.setViewportView((Component)this.tbl_facturas);
        this.bt_todasFacturadas.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/archivero.png")));
        this.bt_todasFacturadas.setText("Todas");
        this.bt_todasFacturadas.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIFacturas.this.bt_todasFacturadasActionPerformed(evt);
            }
        });
        this.bt_noFacturadas.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/servidor-icono-7136-128.png")));
        this.bt_noFacturadas.setText("No Facturadas");
        this.bt_noFacturadas.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIFacturas.this.bt_noFacturadasActionPerformed(evt);
            }
        });
        this.bt_facturas.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/carpetaConFacturas.jpg")));
        this.bt_facturas.setText("Facturadas");
        this.bt_facturas.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIFacturas.this.bt_facturasActionPerformed(evt);
            }
        });
        this.lbl_error.setFont(new Font("Tahoma", 0, 14));
        this.lbl_error.setForeground(new Color(255, 0, 0));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 1223, 32767).addGroup(jPanel2Layout.createSequentialGroup().addGap(38, 38, 38).addComponent(this.lbl_error, -2, 620, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.bt_facturas).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.bt_noFacturadas, -2, 147, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.bt_todasFacturadas).addGap(1, 1, 1)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.bt_todasFacturadas, -2, 36, -2).addComponent(this.bt_noFacturadas, -2, 33, -2).addComponent(this.bt_facturas, -2, 32, -2).addComponent(this.lbl_error, -2, 36, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 451, 32767)));
        this.bt_EnviarFacturaAfip.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/conexion.jpg")));
        this.bt_EnviarFacturaAfip.setText("Enviar Factura AFIP");
        this.bt_EnviarFacturaAfip.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIFacturas.this.bt_EnviarFacturaAfipActionPerformed(evt);
            }
        });
        this.bt_consultarAfip.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/afip.png")));
        this.bt_consultarAfip.setText("Consultar AFIP");
        this.bt_consultarAfip.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIFacturas.this.bt_consultarAfipActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.bt_consultarAfip).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.bt_EnviarFacturaAfip)).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(0, 301, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -1, -1, 32767).addGap(21, 21, 21).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.bt_EnviarFacturaAfip, -2, 32, -2).addComponent(this.bt_consultarAfip))));
        this.pack();
    }

    private void formComponentShown(ComponentEvent evt) {
        this.tbl_facturas.setModel(this.gestor.traerFacturas(this.tbl_facturas.getModel()));
        this.cmb_sucursal.setModel(new DefaultComboBoxModel<String>(this.gestor.traerSucursales()));
        this.cmb_tipoComprobante.setModel(new DefaultComboBoxModel<String>(this.gestor.traerComprobantes()));
    }

    private void bt_facturasActionPerformed(ActionEvent evt) {
        if (Utilerias.filtrarCampoNumero(this.txt_cantidadFilas.getText())) {
            this.tbl_facturas.setModel(this.gestor.mostrarFacturadas(this.tbl_facturas.getModel(), this.txt_cantidadFilas.getText()));
        }
    }

    private void bt_noFacturadasActionPerformed(ActionEvent evt) {
        if (Utilerias.filtrarCampoNumero(this.txt_cantidadFilas.getText())) {
            this.tbl_facturas.setModel(this.gestor.mostrarNoFacturadas(this.tbl_facturas.getModel(), this.txt_cantidadFilas.getText()));
        }
    }

    private void bt_todasFacturadasActionPerformed(ActionEvent evt) {
        this.tbl_facturas.setModel(this.gestor.mostrarTodoFacturadas(this.tbl_facturas.getModel(), this.txt_cantidadFilas.getText()));
    }

    private void bt_filtrarActionPerformed(ActionEvent evt) {
        if (Utilerias.filtrarCampoNumero(this.txt_cantidadFilas.getText())) {
            this.tbl_facturas.setModel(this.gestor.filtrar(this.cmb_sucursal.getSelectedIndex(), this.cmb_tipoComprobante.getSelectedIndex(), this.tbl_facturas.getModel(), this.txt_cantidadFilas.getText()));
        }
    }

    private void txt_cantidadFilasFocusLost(FocusEvent evt) {
        if (!Utilerias.filtrarCampoNumero(this.txt_cantidadFilas.getText())) {
            this.lbl_error.setText("Numero de Fila no valido");
        } else {
            this.lbl_error.setText("");
        }
    }

    private void bt_consultarAfipActionPerformed(ActionEvent evt) {
        this.lbl_error.setText(this.gestor.consultarComprobante(this.tbl_facturas.getSelectedRow()));
    }

    private void bt_EnviarFacturaAfipActionPerformed(ActionEvent evt) {
        this.gestor.facturar(this.tbl_facturas.getSelectedRow());
    }

}

