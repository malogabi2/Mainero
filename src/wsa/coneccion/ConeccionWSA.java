/*
 * Decompiled with CFR 0_124.
 */
package wsa.coneccion;

import wsa.metodo.WsaXML;

public class ConeccionWSA {
    private String server;
    private String servicio;
    private String lineaConecion;
    private String archivoKeyStore;
    private String claveDesencriptacionPublica = "";
    private String claveDesencriptacionPrivada = "";
    private Long tiketTiempo;
    private String mensajeXML;

    public String getServer() {
        return this.server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getServicio() {
        return this.servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getLineaConecion() {
        return this.lineaConecion;
    }

    public void setLineaConecion(String lineaConecion) {
        this.lineaConecion = lineaConecion;
    }

    public String getArchivoKeyStore() {
        return this.archivoKeyStore;
    }

    public void setArchivoKeyStore(String archivoConeccion) {
        this.archivoKeyStore = archivoConeccion;
    }

    public String getClaveDesencriptacionPublica() {
        return this.claveDesencriptacionPublica;
    }

    public void setClaveDesencriptacionPublica(String claveDesencriptacionPublica) {
        this.claveDesencriptacionPublica = claveDesencriptacionPublica;
    }

    public String getClaveDesencriptacionPrivada() {
        return this.claveDesencriptacionPrivada;
    }

    public void setClaveDesencriptacionPrivada(String claveDesencriptacionPrivada) {
        this.claveDesencriptacionPrivada = claveDesencriptacionPrivada;
    }

    public Long getTiketTiempo() {
        return this.tiketTiempo;
    }

    public void setTiketTiempo(Long tiketTiempo) {
        this.tiketTiempo = tiketTiempo;
    }

    public String getMensajeXML(String cuit) {
        this.mensajeXML = WsaXML.create_LoginTicketRequest(cuit, this.getLineaConecion(), this.getServicio(), this.getTiketTiempo());
        return this.mensajeXML;
    }
}

