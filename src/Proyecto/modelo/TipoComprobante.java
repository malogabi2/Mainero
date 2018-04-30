/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.modelo;

public class TipoComprobante {
    private int numeroAfip;
    private String nombre;
    private int numeroReal;

    public int getNumeroAfip() {
        return this.numeroAfip;
    }

    public void setNumeroAfip(int numeroAfip) {
        this.numeroAfip = numeroAfip;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroReal() {
        return this.numeroReal;
    }

    public void setNumeroReal(int numeroReal) {
        this.numeroReal = numeroReal;
    }

    public String[] guardarEnArchivo() {
        return new String[]{"numeroComproReal=" + String.valueOf(this.numeroReal), "numeroComproAfip=" + String.valueOf(this.numeroAfip), "nombreCompro=" + this.nombre};
    }

    public boolean equals(Object unTipoComprov) {
        if (unTipoComprov instanceof TipoComprobante && ((TipoComprobante)unTipoComprov).numeroReal == this.numeroReal) {
            return true;
        }
        if (((TipoComprobante)unTipoComprov).numeroAfip == this.numeroAfip) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "" + this.numeroReal + " " + this.nombre;
    }
}

