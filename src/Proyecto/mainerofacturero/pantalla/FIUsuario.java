/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.mainerofacturero.pantalla;

import Proyecto.GestorPantallas.GestorFIUsuario;
import Proyecto.modelo.Permisos;
import Proyecto.modelo.Sucursal;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class FIUsuario
extends JInternalFrame {
    GestorFIUsuario gestor = new GestorFIUsuario();
    private JButton bt_aceptar;
    private JButton bt_agregarPermiso;
    private JButton bt_agregarSucursal;
    private JButton bt_agregarUsuario;
    private JButton bt_borrarUsuario;
    private JButton bt_eliminarPermiso;
    private JButton bt_eliminarSucursal;
    private JButton bt_modificarUsuario;
    private JComboBox cmb_permisos;
    private JComboBox cmb_sucursalesDelSistema;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel13;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPopupMenu jPopupMenu1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JTable tbl_permisos;
    private JTable tbl_sucursal;
    private JTable tbl_usuarios;
    private JTextField txt_idUser_permisos;
    private JTextField txt_idUser_user;
    private JTextField txt_idUsserSucursal;
    private JTextField txt_pswUsuario;
    private JTextField txt_usuarioNombre;

    public FIUsuario() {
        this.initComponents();
    }

    private void initComponents() {
        this.jPopupMenu1 = new JPopupMenu();
        this.jScrollPane1 = new JScrollPane();
        this.tbl_usuarios = new JTable();
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.txt_pswUsuario = new JTextField();
        this.txt_usuarioNombre = new JTextField();
        this.txt_idUser_user = new JTextField();
        this.jLabel3 = new JLabel();
        this.jLabel2 = new JLabel();
        this.bt_agregarUsuario = new JButton();
        this.bt_borrarUsuario = new JButton();
        this.bt_modificarUsuario = new JButton();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jPanel2 = new JPanel();
        this.jLabel6 = new JLabel();
        this.txt_idUser_permisos = new JTextField();
        this.jLabel8 = new JLabel();
        this.bt_agregarPermiso = new JButton();
        this.bt_eliminarPermiso = new JButton();
        this.cmb_permisos = new JComboBox();
        this.jPanel3 = new JPanel();
        this.jLabel10 = new JLabel();
        this.txt_idUsserSucursal = new JTextField();
        this.bt_agregarSucursal = new JButton();
        this.bt_eliminarSucursal = new JButton();
        this.cmb_sucursalesDelSistema = new JComboBox();
        this.jLabel13 = new JLabel();
        this.jLabel9 = new JLabel();
        this.jScrollPane4 = new JScrollPane();
        this.tbl_permisos = new JTable();
        this.jScrollPane5 = new JScrollPane();
        this.tbl_sucursal = new JTable();
        this.bt_aceptar = new JButton();
        this.addComponentListener(new ComponentAdapter(){

            @Override
            public void componentHidden(ComponentEvent evt) {
                FIUsuario.this.formComponentHidden(evt);
            }

            @Override
            public void componentShown(ComponentEvent evt) {
                FIUsuario.this.formComponentShown(evt);
            }
        });
        this.tbl_usuarios.setModel(new DefaultTableModel(new Object[0][], new String[]{"UserID", "User Nombre", "User Psw"}){
            boolean[] canEdit;
            {
               // super(x0, x1);
                this.canEdit = new boolean[]{false, false, false};
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.tbl_usuarios.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent evt) {
                FIUsuario.this.tbl_usuariosMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.tbl_usuarios);
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel1.setText("User ID");
        this.txt_idUser_user.setEditable(false);
        this.jLabel3.setFont(new Font("Tahoma", 0, 14));
        this.jLabel3.setText("Usuario Psw");
        this.jLabel2.setFont(new Font("Tahoma", 0, 14));
        this.jLabel2.setText("Usuario Nombre");
        this.bt_agregarUsuario.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/sumar.jpg")));
        this.bt_agregarUsuario.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIUsuario.this.bt_agregarUsuarioActionPerformed(evt);
            }
        });
        this.bt_borrarUsuario.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/menos.png")));
        this.bt_borrarUsuario.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIUsuario.this.bt_borrarUsuarioActionPerformed(evt);
            }
        });
        this.bt_modificarUsuario.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/modificar.GIF")));
        this.bt_modificarUsuario.setToolTipText("Modificar");
        this.bt_modificarUsuario.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIUsuario.this.bt_modificarUsuarioActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_idUser_user).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txt_usuarioNombre, -2, 150, -2).addGap(16, 16, 16).addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txt_pswUsuario, -2, 216, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.bt_modificarUsuario, -2, 32, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.bt_borrarUsuario, -2, 22, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.bt_agregarUsuario, -2, 37, -2)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.bt_borrarUsuario, GroupLayout.Alignment.LEADING, -2, 0, 32767).addComponent(this.txt_usuarioNombre, GroupLayout.Alignment.LEADING).addComponent(this.txt_idUser_user, GroupLayout.Alignment.LEADING).addComponent(this.bt_agregarUsuario, -2, 0, 32767).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jLabel3).addComponent(this.jLabel1)).addComponent(this.txt_pswUsuario).addComponent(this.bt_modificarUsuario, -2, 0, 32767)).addContainerGap(-1, 32767)));
        this.jLabel4.setFont(new Font("Tahoma", 1, 14));
        this.jLabel4.setText("Permisos");
        this.jLabel5.setFont(new Font("Tahoma", 1, 14));
        this.jLabel5.setText("Usuario");
        this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel6.setText("User ID");
        this.txt_idUser_permisos.setEditable(false);
        this.jLabel8.setFont(new Font("Tahoma", 0, 14));
        this.jLabel8.setText("Permisos Del Siestema");
        this.bt_agregarPermiso.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/sumar.jpg")));
        this.bt_agregarPermiso.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIUsuario.this.bt_agregarPermisoActionPerformed(evt);
            }
        });
        this.bt_eliminarPermiso.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/menos.png")));
        this.bt_eliminarPermiso.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIUsuario.this.bt_eliminarPermisoActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_idUser_permisos, -2, 161, -2).addGap(70, 70, 70).addComponent(this.jLabel8).addGap(18, 18, 18).addComponent(this.cmb_permisos, -2, 291, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 120, 32767).addComponent(this.bt_eliminarPermiso, -2, 22, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.bt_agregarPermiso, -2, 37, -2)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.txt_idUser_permisos, GroupLayout.Alignment.LEADING).addComponent(this.cmb_permisos, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel6).addComponent(this.jLabel8)).addComponent(this.bt_agregarPermiso, GroupLayout.Alignment.LEADING, -2, 0, 32767).addComponent(this.bt_eliminarPermiso, GroupLayout.Alignment.LEADING, -2, 0, 32767)).addContainerGap(-1, 32767)));
        this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel10.setText("User ID");
        this.txt_idUsserSucursal.setEditable(false);
        this.bt_agregarSucursal.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/sumar.jpg")));
        this.bt_agregarSucursal.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIUsuario.this.bt_agregarSucursalActionPerformed(evt);
            }
        });
        this.bt_eliminarSucursal.setIcon(new ImageIcon(this.getClass().getResource("/Proyecto/imagenes/menos.png")));
        this.bt_eliminarSucursal.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIUsuario.this.bt_eliminarSucursalActionPerformed(evt);
            }
        });
        this.jLabel13.setFont(new Font("Tahoma", 0, 14));
        this.jLabel13.setText("Sucursales Del Sistema");
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel10).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txt_idUsserSucursal, -2, 161, -2).addGap(30, 30, 30).addComponent(this.jLabel13).addGap(47, 47, 47).addComponent(this.cmb_sucursalesDelSistema, -2, 282, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.bt_eliminarSucursal, -2, 22, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.bt_agregarSucursal, -2, 37, -2)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel10).addComponent(this.txt_idUsserSucursal, -2, -1, -2).addComponent(this.jLabel13).addComponent(this.cmb_sucursalesDelSistema, -2, -1, -2)).addGap(5, 5, 5)).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.bt_eliminarSucursal, GroupLayout.Alignment.TRAILING, -2, 0, 32767).addComponent(this.bt_agregarSucursal, -2, 21, -2))).addContainerGap()));
        this.jLabel9.setFont(new Font("Tahoma", 1, 14));
        this.jLabel9.setText("Sucursal");
        this.tbl_permisos.setModel(new DefaultTableModel(new Object[0][], new String[]{"UserID", "Permiso Nombre", "Puerta"}){
            boolean[] canEdit;
            {
               // super(x0, x1);
                this.canEdit = new boolean[]{false, false, false};
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.tbl_permisos.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent evt) {
                FIUsuario.this.tbl_permisosMouseClicked(evt);
            }
        });
        this.jScrollPane4.setViewportView(this.tbl_permisos);
        this.tbl_sucursal.setModel(new DefaultTableModel(new Object[0][], new String[]{"numero", "descripci\u00f3n", "Es Bono Fiscales"}){
            boolean[] canEdit;
            {
              //  super(x0, x1);
                this.canEdit = new boolean[]{false, false, false};
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.tbl_sucursal.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent evt) {
                FIUsuario.this.tbl_sucursalMouseClicked(evt);
            }
        });
        this.jScrollPane5.setViewportView(this.tbl_sucursal);
        this.bt_aceptar.setText("Aceptar");
        this.bt_aceptar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FIUsuario.this.bt_aceptarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jScrollPane4).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel5).addComponent(this.jLabel4).addComponent(this.jLabel9)).addContainerGap()).addComponent(this.jPanel3, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.bt_aceptar)).addComponent(this.jScrollPane5));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel5, -2, 17, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 91, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, 41, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel4, -2, 17, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane4, -2, 91, -2).addGap(16, 16, 16).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel9, -2, 17, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane5, -2, 91, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.bt_aceptar)));
        this.pack();
    }

    private void bt_agregarUsuarioActionPerformed(ActionEvent evt) {
        this.gestor.agregarUsuario(this.tbl_usuarios.getModel(), this.txt_pswUsuario.getText(), this.txt_usuarioNombre.getText(), this.tbl_sucursal.getModel(), this.tbl_permisos.getModel());
        this.limpiarTodo();
    }

    private void bt_agregarPermisoActionPerformed(ActionEvent evt) {
        if (this.cmb_permisos.getItemCount() > 0) {
            this.gestor.agregarPermisos(this.cmb_permisos.getSelectedItem(), this.tbl_permisos.getModel());
        } else {
            this.cmb_permisos.setModel(this.gestor.mostrarPermisos());
        }
    }

    private void bt_agregarSucursalActionPerformed(ActionEvent evt) {
        if (this.cmb_sucursalesDelSistema.getItemCount() > 0) {
            this.gestor.agregarSucursal(this.cmb_sucursalesDelSistema.getSelectedItem(), this.tbl_sucursal.getModel());
        } else {
            this.cmb_sucursalesDelSistema.setModel(this.gestor.mostrarSucursal());
        }
    }

    private void formComponentHidden(ComponentEvent evt) {
    }

    public void setPermisosDeslSistema(Permisos[] permisos) {
        this.gestor.tomarPermisosDelSistema(permisos);
    }

    public void setSucursalesDelSistema(Sucursal[] sucursales) {
        this.gestor.tomarSucursalesDelSistema(sucursales);
    }

    private void formComponentShown(ComponentEvent evt) {
        this.tbl_usuarios.setModel(this.gestor.motrarUsuarios(this.tbl_usuarios.getModel()));
    }

    private void tbl_usuariosMouseClicked(MouseEvent evt) {
        this.gestor.tomarUsuarioSeleccionado(this.tbl_usuarios.getSelectedRow(), this.tbl_usuarios.getModel());
        this.tbl_sucursal.setModel(this.gestor.cargarTablaSucursal(this.tbl_sucursal.getModel()));
        this.tbl_permisos.setModel(this.gestor.cargarTablaPermisos(this.tbl_permisos.getModel()));
        this.txt_idUser_user.setText(this.gestor.mostrarIdUsuario());
        this.txt_pswUsuario.setText(this.gestor.mostrarPswUsuario());
    }

    private void tbl_permisosMouseClicked(MouseEvent evt) {
        this.gestor.tomarPermososSeleccionado(this.tbl_permisos.getSelectedRow());
        this.txt_idUser_permisos.setText(this.gestor.mostrarIdUsuario());
        this.cmb_permisos.setModel(this.gestor.mostrarPermisos());
    }

    private void tbl_sucursalMouseClicked(MouseEvent evt) {
        this.gestor.tomarSucursalSeleccionado(this.tbl_sucursal.getSelectedRow());
        this.txt_idUsserSucursal.setText(this.gestor.mostrarIdUsuario());
        this.cmb_sucursalesDelSistema.setModel(this.gestor.mostrarSucursal());
    }

    private void bt_modificarUsuarioActionPerformed(ActionEvent evt) {
        this.gestor.modificarUsuario(this.tbl_usuarios.getModel(), this.txt_pswUsuario.getText(), this.txt_usuarioNombre.getText(), this.txt_idUser_user.getText(), this.tbl_sucursal.getModel(), this.tbl_permisos.getModel());
        this.limpiarTodo();
    }

    private void limpiarTodo() {
        this.txt_pswUsuario.setText("");
        this.txt_usuarioNombre.setText("");
        this.txt_idUser_user.setText("");
        this.txt_idUser_permisos.setText("");
        this.txt_idUsserSucursal.setText("");
        this.tbl_usuarios.setEnabled(true);
    }

    private void bt_borrarUsuarioActionPerformed(ActionEvent evt) {
        this.gestor.eliminarUsuario(this.tbl_usuarios.getModel(), this.tbl_sucursal.getModel(), this.tbl_permisos.getModel());
        this.limpiarTodo();
    }

    private void bt_eliminarPermisoActionPerformed(ActionEvent evt) {
        this.tbl_permisos.setModel(this.gestor.eliminarPermisos(this.tbl_permisos.getModel()));
    }

    private void bt_eliminarSucursalActionPerformed(ActionEvent evt) {
        this.tbl_sucursal.setModel(this.gestor.eliminarSucursal(this.tbl_sucursal.getModel()));
    }

    private void bt_aceptarActionPerformed(ActionEvent evt) {
        this.gestor.guardarUsuarios();
        this.dispose();
    }

}

