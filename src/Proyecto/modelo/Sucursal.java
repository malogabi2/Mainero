/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.modelo;

public class Sucursal {
    private int numero;
    private String descripcion;
    private boolean esBonosFiscales;

    public int getNumero() {
        return this.numero;
    }

    public Object[] filas() {
        return new Object[]{this.numero, this.descripcion, this.esBonosFiscales};
    }

    public int numeroColumnas() {
        return 3;
    }

    public static int numeroColumna() {
        return 3;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEsBonosFiscales() {
        return this.esBonosFiscales;
    }

    public void setEsBonosFiscales(boolean esBonosFiscales) {
        this.esBonosFiscales = esBonosFiscales;
    }

    public String toString() {
        return String.valueOf(this.numero) + " " + this.getDescripcion();
    }

    public boolean equals(Object unaSucursal) {
        if (unaSucursal instanceof Sucursal && ((Sucursal)unaSucursal).numero == this.numero) {
            return true;
        }
        return false;
    }

    public String[] guardarEnArchivo() {
        return new String[]{"numeroSuc=" + String.valueOf(this.numero), "nombreSuc=" + this.descripcion, "esBonoFiscal=" + String.valueOf(this.esBonosFiscales)};
    }
}

