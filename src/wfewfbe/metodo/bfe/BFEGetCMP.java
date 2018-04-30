/*
 * Decompiled with CFR 0_124.
 */
package wfewfbe.metodo.bfe;

import wfewfbe.metodo.wfev1.Mensajes;

public class BFEGetCMP
extends Mensajes {
    @Override
    public boolean esFacturar() {
        return false;
    }

    @Override
    protected String cuerpo(String[] parametros, String nombre) {
        return "<BFEGetCMP xmlns=\"http://ar.gov.afip.dif.bfe/\" ><Auth><Token>" + parametros[0] + "</Token>" + "<Sign>" + parametros[1] + "</Sign>" + "<Cuit>" + parametros[2] + "</Cuit>" + "</Auth>" + "<Cmp>" + "<Tipo_cbte>" + parametros[4] + "</Tipo_cbte>" + "<Cbte_nro>" + parametros[5] + "</Cbte_nro>" + "<Punto_vta>" + parametros[3] + "</Punto_vta>" + "</Cmp>" + "</BFEGetCMP>";
    }

    @Override
    public String nombreMensaje() {
        return "Buscando comprobante";
    }

    @Override
    public String soapAction() {
        return "http://ar.gov.afip.dif.bfe/BFEGetCMP";
    }

    @Override
    public String nombreMensajeXML() {
        return "BFEGetCMP";
    }

    @Override
    public boolean esConsulta() {
        return true;
    }
}

