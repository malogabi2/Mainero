/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.modelo;

public class TokenSign {
    private String token;
    private String sign;
    private String detalle;
    private long marcaTiempo;
    private String expiracionFecha;

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSign() {
        return this.sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getDetalle() {
        return this.detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public long getMarcaTiempo() {
        return this.marcaTiempo;
    }

    public void setMarcaTiempo(long marcaTiempo) {
        this.marcaTiempo = marcaTiempo;
    }

    public String getExperacion() {
        return this.expiracionFecha;
    }

    public void setExperacion(String experacion) {
        this.expiracionFecha = experacion;
    }
}

