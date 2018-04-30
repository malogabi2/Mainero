/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.GestorPantallas;

import Proyecto.GestorArchivos.GestorABuscaUsuarios;
import Proyecto.modelo.Permisos;
import Proyecto.modelo.Sucursal;
import Proyecto.modelo.Usuario;
import Proyecto.utilerias.Utilerias;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class GestorFIUsuario {
    ArrayList<Usuario> usuarios = new ArrayList();
    Permisos[] permisosDelSistema;
    Sucursal[] sucursalesDelSistema;
    Usuario userSelec;
    Permisos permiSelec;
    Sucursal sucSelect;

    public TableModel motrarUsuarios(TableModel model) {
        GestorABuscaUsuarios gesu = new GestorABuscaUsuarios();
        this.cargarUsuarios(gesu.traerUsuarios());
        if (this.usuarios == null) {
            return model;
        }
        DefaultTableModel dfm = (DefaultTableModel)model;
        for (int i = 0; i < this.usuarios.size(); ++i) {
            dfm.addRow(this.usuarios.get(i).filas());
        }
        return dfm;
    }

    private void cargarUsuarios(Usuario[] uss) {
        for (int i = 0; i < uss.length; ++i) {
            this.usuarios.add(uss[i]);
        }
    }

    public void tomarUsuarioSeleccionado(int selectedRow, TableModel model) {
        this.userSelec = this.usuarios.get(selectedRow);
    }

    private Object[][] mostrarFilasSucursal() {
        if (this.userSelec.cantidadItemsSucursal() > 0) {
            Object[][] filas = new Object[this.userSelec.cantidadItemsSucursal()][this.userSelec.mostrarItemSucursal(0).numeroColumnas()];
            for (int i = 0; i < this.userSelec.cantidadItemsSucursal(); ++i) {
                for (int j = 0; j < this.userSelec.mostrarItemSucursal(i).numeroColumnas(); ++j) {
                    filas[i][j] = this.userSelec.mostrarItemSucursal(i).filas()[j];
                }
            }
            return filas;
        }
        return new Object[0][Sucursal.numeroColumna()];
    }

    private Object[][] mostrarFilasPermisos() {
        if (this.userSelec.cantidadItemsPermisos() > 0) {
            Object[][] filas = new Object[this.userSelec.cantidadItemsPermisos()][this.userSelec.mostrarItemPermisos(0).numeroColumna()];
            for (int i = 0; i < this.userSelec.cantidadItemsPermisos(); ++i) {
                for (int j = 0; j < this.userSelec.mostrarItemPermisos(i).numeroColumna(); ++j) {
                    filas[i][j] = this.userSelec.mostrarItemPermisos(i).filas(this.userSelec.getIdUser())[j];
                }
            }
            return filas;
        }
        return new Object[0][Sucursal.numeroColumna()];
    }

    public TableModel cargarTablaSucursal(TableModel model) {
        Object[][] filas = this.mostrarFilasSucursal();
        DefaultTableModel dfmol = this.borrarContenidoTabla((DefaultTableModel)model);
        for (int i = 0; i < filas.length; ++i) {
            dfmol.addRow(filas[i]);
        }
        return dfmol;
    }

    public TableModel cargarTablaPermisos(TableModel model) {
        Object[][] filas = this.mostrarFilasPermisos();
        DefaultTableModel dfmol = this.borrarContenidoTabla((DefaultTableModel)model);
        for (int i = 0; i < filas.length; ++i) {
            dfmol.addRow(filas[i]);
        }
        return dfmol;
    }

    private DefaultTableModel borrarContenidoTabla(DefaultTableModel tabla) {
        int canFil = tabla.getRowCount();
        for (int i = 0; i < canFil; ++i) {
            tabla.removeRow(0);
        }
        return tabla;
    }

    public String mostrarIdUsuario() {
        return String.valueOf(this.userSelec.getIdUser());
    }

    public String mostrarNombreUsuario() {
        return this.userSelec.getUsuarioNombre();
    }

    public String mostrarPswUsuario() {
        return this.userSelec.getPasss();
    }

    public TableModel agregarUsuario(TableModel tblUsuarios, String pswUser, String usUser, TableModel tblSucusal, TableModel tblPermisos) {
        Usuario user = new Usuario(usUser, pswUser, this.usuarios.get(this.usuarios.size() - 1).getIdUser() + 1L);
        user = this.agregarPermisos(tblPermisos, user);
        user = this.agregarSuacursales(tblSucusal, user);
        this.usuarios.add(user);
        DefaultTableModel defm = (DefaultTableModel)tblUsuarios;
        defm.addRow(user.filas());
        this.borrarContenidoTabla((DefaultTableModel)tblSucusal);
        this.borrarContenidoTabla((DefaultTableModel)tblPermisos);
        return defm;
    }

    private Usuario agregarSuacursales(TableModel tblSucursal, Usuario user) {
        DefaultTableModel dfm = (DefaultTableModel)tblSucursal;
        for (int i = 0; i < tblSucursal.getRowCount(); ++i) {
            Sucursal scu = new Sucursal();
            for (int j = 0; j < tblSucursal.getColumnCount(); ++j) {
                if (tblSucursal.getColumnName(j).equals("descripci\u00f3n")) {
                    scu.setDescripcion(tblSucursal.getValueAt(i, j).toString());
                }
                if (tblSucursal.getColumnName(j).equals("numero")) {
                    scu.setNumero(Integer.valueOf(tblSucursal.getValueAt(i, j).toString()));
                }
                if (!tblSucursal.getColumnName(j).equals("Es Bono Fiscales")) continue;
                scu.setEsBonosFiscales(Boolean.valueOf(tblSucursal.getValueAt(i, j).toString()));
            }
            user.agregarItemSucursal(scu);
        }
        return user;
    }

    private Usuario agregarPermisos(TableModel tblPermisos, Usuario user) {
        DefaultTableModel dfm = (DefaultTableModel)tblPermisos;
        for (int i = 0; i < tblPermisos.getRowCount(); ++i) {
            Permisos per = new Permisos();
            for (int j = 0; j < tblPermisos.getColumnCount(); ++j) {
                if (tblPermisos.getColumnName(j).equals("Permiso Nombre")) {
                    per.setPermisosNombre(tblPermisos.getValueAt(i, j).toString());
                }
                if (!tblPermisos.getColumnName(j).equals("Puerta")) continue;
                per.setPermisosPuerta(tblPermisos.getValueAt(i, j).toString());
            }
            user.agregarItemPermisos(per);
        }
        return user;
    }

    private void borrarUserSeletDeLaLista() {
        if (this.usuarios.contains(this.userSelec)) {
            this.usuarios.remove(this.usuarios.indexOf(this.userSelec));
        }
    }

    public DefaultTableModel modificarUsuario(TableModel tblUsuario, String pswUser, String usUser, String idUser, TableModel tblSucursal, TableModel tblPermisos) {
        Usuario user = new Usuario(usUser, pswUser, Long.valueOf(idUser));
        user = this.agregarPermisos(tblPermisos, user);
        user = this.agregarSuacursales(tblSucursal, user);
        for (int i = 0; i < this.usuarios.size(); ++i) {
            if (this.usuarios.get(i).getIdUser() != user.getIdUser()) continue;
            this.usuarios.set(i, user);
        }
        this.borrarContenidoTabla((DefaultTableModel)tblSucursal);
        this.borrarContenidoTabla((DefaultTableModel)tblPermisos);
        DefaultTableModel defm = this.borrarContenidoTabla((DefaultTableModel)tblUsuario);
        return this.actualizarTablaUsuario(defm);
    }

    private DefaultTableModel actualizarTablaUsuario(DefaultTableModel model) {
        for (int i = 0; i < this.usuarios.size(); ++i) {
            model.addRow(this.usuarios.get(i).filas());
        }
        return model;
    }

    private DefaultTableModel actualizarTablaPermisos(DefaultTableModel model) {
        for (int i = 0; i < this.userSelec.cantidadItemsPermisos(); ++i) {
            model.addRow(this.userSelec.mostrarItemPermisos(i).filas(this.userSelec.getIdUser()));
        }
        return model;
    }

    private DefaultTableModel actualizarTablaSucursal(DefaultTableModel model) {
        for (int i = 0; i < this.userSelec.cantidadItemsSucursal(); ++i) {
            model.addRow(this.userSelec.mostrarItemSucursal(i).filas());
        }
        return model;
    }

    public void tomarPermososSeleccionado(int selectedRow) {
        this.permiSelec = this.usuarios.get(this.usuarios.indexOf(this.userSelec)).mostrarItemPermisos(selectedRow);
    }

    public void tomarSucursalSeleccionado(int selectedRow) {
        this.sucSelect = this.usuarios.get(this.usuarios.indexOf(this.userSelec)).mostrarItemSucursal(selectedRow);
    }

    public String mostrarPermisosNombre() {
        return this.permiSelec.getPermisoNombre();
    }

    public String mostrarPermisosPuerta() {
        return this.permiSelec.getPuerta();
    }

    public String mostrarSucursalDetalle() {
        return this.sucSelect.getDescripcion();
    }

    public String mostrarSucursalNumero() {
        return String.valueOf(this.sucSelect.getNumero());
    }

    public Boolean mostrarSucursalIsBonoFiscales() {
        return this.sucSelect.isEsBonosFiscales();
    }

    public void tomarPermisosDelSistema(Permisos[] permisos) {
        this.permisosDelSistema = permisos;
    }

    public ComboBoxModel mostrarPermisos() {
        DefaultComboBoxModel<Permisos> df = new DefaultComboBoxModel<Permisos>(this.permisosDelSistema);
        for (int i = 0; i < this.permisosDelSistema.length; ++i) {
            if (this.permiSelec == null || !this.permisosDelSistema[i].toString().equals(this.permiSelec.toString())) continue;
            df.setSelectedItem(this.permisosDelSistema[i]);
        }
        return df;
    }

    private Permisos buscarPermiso(String permisoToString) {
        for (int i = 0; i < this.permisosDelSistema.length; ++i) {
            if (!permisoToString.equals(this.permisosDelSistema[i].toString())) continue;
            return this.permisosDelSistema[i];
        }
        return null;
    }

    private Sucursal buscarSucursal(String sucursalToString) {
        for (int i = 0; i < this.sucursalesDelSistema.length; ++i) {
            if (!sucursalToString.equals(this.sucursalesDelSistema[i].toString())) continue;
            return this.sucursalesDelSistema[i];
        }
        return null;
    }

    public void agregarPermisos(Object selectedItem, TableModel model) {
        Permisos perSelec = this.buscarPermiso(selectedItem.toString());
        if (perSelec != null && !this.userSelec.existeItemPermisos(perSelec)) {
            this.userSelec.agregarItemPermisos(perSelec);
            DefaultTableModel modl = (DefaultTableModel)model;
            modl.addRow(perSelec.filas(this.userSelec.getIdUser()));
        }
    }

    public DefaultTableModel eliminarUsuario(TableModel tblUsuario, TableModel tblSucursal, TableModel tblPermisos) {
        this.usuarios.remove(this.userSelec);
        this.borrarContenidoTabla((DefaultTableModel)tblSucursal);
        this.borrarContenidoTabla((DefaultTableModel)tblPermisos);
        DefaultTableModel defm = this.borrarContenidoTabla((DefaultTableModel)tblUsuario);
        return this.actualizarTablaUsuario(defm);
    }

    public DefaultTableModel eliminarPermisos(TableModel tblPermisos) {
        this.usuarios.get(this.usuarios.indexOf(this.userSelec)).borrarItemPermisos(this.permiSelec);
        this.borrarContenidoTabla((DefaultTableModel)tblPermisos);
        return this.actualizarTablaPermisos((DefaultTableModel)tblPermisos);
    }

    public DefaultTableModel eliminarSucursal(TableModel tblSucursal) {
        this.usuarios.get(this.usuarios.indexOf(this.userSelec)).borrarItemSucursal(this.sucSelect);
        this.borrarContenidoTabla((DefaultTableModel)tblSucursal);
        return this.actualizarTablaSucursal((DefaultTableModel)tblSucursal);
    }

    public void tomarSucursalesDelSistema(Sucursal[] sucursales) {
        this.sucursalesDelSistema = sucursales;
    }

    public ComboBoxModel mostrarSucursal() {
        DefaultComboBoxModel<Sucursal> df = new DefaultComboBoxModel<Sucursal>(this.sucursalesDelSistema);
        for (int i = 0; i < this.sucursalesDelSistema.length; ++i) {
            if (this.sucSelect == null || !this.sucursalesDelSistema[i].toString().equals(this.sucSelect.toString())) continue;
            df.setSelectedItem(this.sucursalesDelSistema[i]);
        }
        return df;
    }

    public void agregarSucursal(Object selectedItem, TableModel model) {
        Sucursal sucSelec = this.buscarSucursal(selectedItem.toString());
        if (sucSelec != null && !this.userSelec.existeItemDetalleSucursal(sucSelec)) {
            this.userSelec.agregarItemSucursal(sucSelec);
            DefaultTableModel modl = (DefaultTableModel)model;
            modl.addRow(sucSelec.filas());
        }
    }

    public void guardarUsuarios() {
        GestorABuscaUsuarios gus = new GestorABuscaUsuarios();
        gus.guardar(Utilerias.pasarObjetoAUsuario(this.usuarios.toArray()));
    }
}

