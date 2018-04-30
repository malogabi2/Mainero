/*
 * Decompiled with CFR 0_124.
 */
package wfewfbe.metodo.wfev1;

import wfewfbe.metodo.bfe.BFEParametrosBFE;
import wfewfbe.metodo.wfev1.FEParametros;

public abstract class Mensajes {
    private String mensaje = "No Ejecutado";

    public String mensaje(String[] parametros, String nombre) {
        this.setMensaje(this.cabecera(this.cuerpo(parametros, nombre)));
        return this.getMensaje();
    }

    public abstract boolean esFacturar();

    public boolean esConsulta() {
        return false;
    }

    protected abstract String cuerpo(String[] var1, String var2);

    public abstract String nombreMensaje();

    public abstract String soapAction();

    public abstract String nombreMensajeXML();

    public String cabecera(String cuerpo) {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?> <soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"  xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"> <soap:Body>" + cuerpo + " </soap:Body>" + " </soap:Envelope>";
    }

    public String cuerpoParametrosFE(String[] parametros, String nombre) {
        FEParametros par = new FEParametros();
        return par.cuerpo(parametros, nombre);
    }

    public String cuerpoParametrosBFE(String[] parametros, String nombre) {
        BFEParametrosBFE par = new BFEParametrosBFE();
        return par.cuerpo(parametros, nombre);
    }

    public String getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}

