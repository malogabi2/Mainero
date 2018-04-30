/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.modelo;

import Proyecto.modelo.Permisos;
import Proyecto.modelo.Sucursal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Usuario {
    private String usuarioNombre;
    private String passs;
    private long idUser;
    ArrayList<Sucursal> useSuc = new ArrayList();
    ArrayList<Permisos> usePer = new ArrayList();

    public Usuario() {
    }

    public Object[] filas() {
        return new Object[]{this.idUser, this.usuarioNombre, this.passs};
    }

    public void agregarItemSucursal(Sucursal item) {
        this.useSuc.add(item);
    }

    public Sucursal mostrarItemSucursal(int pos) {
        return this.useSuc.get(pos);
    }

    public void borrarItemSucursal(int pos) {
        this.useSuc.remove(pos);
    }

    public boolean existeItemDetalleSucursal(Sucursal item) {
        return this.useSuc.contains(item);
    }

    public void agregarItemsDetalleSucursal(Sucursal[] itms) {
        this.useSuc.addAll(Arrays.asList(itms));
    }

    public int cantidadItemsSucursal() {
        return this.useSuc.size();
    }

    public void agregarItemPermisos(Permisos item) {
        this.usePer.add(item);
    }

    public Permisos mostrarItemPermisos(int pos) {
        return this.usePer.get(pos);
    }

    public void borrarItemPermisos(int pos) {
        this.usePer.remove(pos);
    }

    public void borrarItemPermisos(Permisos permABorrar) {
        this.usePer.remove(permABorrar);
    }

    public void borrarItemSucursal(Sucursal sucursal) {
        this.useSuc.remove(sucursal);
    }

    public boolean existeItemPermisos(Permisos item) {
        return this.usePer.contains(item);
    }

    public void agregarItemsPermisos(Permisos[] itms) {
        this.usePer.addAll(Arrays.asList(itms));
    }

    public int cantidadItemsPermisos() {
        return this.usePer.size();
    }

    public String[] sucursalesNumero() {
        String[] sucNum = new String[this.cantidadItemsSucursal()];
        for (int i = 0; i < this.cantidadItemsSucursal(); ++i) {
            sucNum[i] = String.valueOf(this.mostrarItemSucursal(i).getNumero());
        }
        return sucNum;
    }

    public String[] sucursalesDetalle() {
        String[] sucNum = new String[this.cantidadItemsSucursal()];
        for (int i = 0; i < this.cantidadItemsSucursal(); ++i) {
            sucNum[i] = String.valueOf(this.mostrarItemSucursal(i).getDescripcion());
        }
        return sucNum;
    }

    public String[] sucursalesMostrarCombo() {
        String[] sucNum = new String[this.cantidadItemsSucursal()];
        for (int i = 0; i < this.cantidadItemsSucursal(); ++i) {
            sucNum[i] = this.mostrarItemSucursal(i).toString();
        }
        return sucNum;
    }

    public boolean esFiscalLaSucursal(int numeroSucursal) {
        for (int i = 0; i < this.cantidadItemsSucursal(); ++i) {
            if (this.mostrarItemSucursal(i).getNumero() != numeroSucursal || !this.mostrarItemSucursal(i).isEsBonosFiscales()) continue;
            return true;
        }
        return false;
    }

    public Boolean[] sucursalesEsBonoFiscales() {
        Boolean[] sucNum = new Boolean[this.cantidadItemsSucursal()];
        for (int i = 0; i < this.cantidadItemsSucursal(); ++i) {
            sucNum[i] = this.mostrarItemSucursal(i).isEsBonosFiscales();
        }
        return sucNum;
    }

    public boolean estaPermiso(String permisoToString) {
        for (int i = 0; i < this.cantidadItemsPermisos(); ++i) {
            if (!this.mostrarItemPermisos(i).toString().equals(permisoToString)) continue;
            return true;
        }
        return false;
    }

    public Usuario(String usuarioN, String Passw, long idUser) {
        this.idUser = idUser;
        this.passs = Passw;
        this.usuarioNombre = usuarioN;
    }

    public String getUsuarioNombre() {
        return this.usuarioNombre;
    }

    public String getPasss() {
        return this.passs;
    }

    public long getIdUser() {
        return this.idUser;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public void setPasss(String passs) {
        this.passs = passs;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public boolean equals(Object unObj) {
        if (unObj instanceof Usuario) {
            Usuario unUsur = (Usuario)unObj;
            return unUsur.idUser == this.idUser;
        }
        return false;
    }
}

