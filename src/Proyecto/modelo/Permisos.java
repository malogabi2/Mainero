/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.modelo;

public class Permisos {
    private String permisoNombre;
    private String puerta;

    public Permisos(String permisoNombre, String puerta) {
        this.permisoNombre = permisoNombre;
        this.puerta = puerta;
    }

    public Permisos() {
    }

    public Object[] filas(Object idUser) {
        return new Object[]{idUser, this.permisoNombre, this.puerta};
    }

    public int numeroColumna() {
        return 3;
    }

    public static int numeroColumnas() {
        return 3;
    }

    public void setPermisosPuerta(String puerta) {
        this.puerta = puerta;
    }

    public void setPermisosNombre(String permisoNombre) {
        this.permisoNombre = permisoNombre;
    }

    public String getPermisoNombre() {
        return this.permisoNombre;
    }

    public String getPuerta() {
        return this.puerta;
    }

    public String toString() {
        return this.permisoNombre + " - " + this.puerta;
    }

    public boolean equals(Object unObjeto) {
        if (unObjeto instanceof Permisos) {
            return ((Permisos)unObjeto).getPermisoNombre().equals(this.getPermisoNombre()) && ((Permisos)unObjeto).getPuerta().equals(this.getPuerta());
        }
        return false;
    }

    public String[] guardarEnArchivo() {
        return new String[]{"puerta=" + this.puerta, "permisoNombre=" + this.permisoNombre};
    }
}

