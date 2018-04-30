/*
 * Decompiled with CFR 0_124.
 */
package wfewfbe.metodo.bfe;

import wfewfbe.metodo.wfev1.Mensajes;

public class BFEGetLast_ID
extends Mensajes {
    @Override
    protected String cuerpo(String[] parametros, String nombre) {
        return "<" + nombre + " xmlns=\"http://ar.gov.afip.dif.bfe/\" >" + "<Auth>" + "<Token>" + parametros[0] + "</Token>" + "<Sign>" + parametros[1] + "</Sign>" + "<Cuit>" + parametros[2] + "</Cuit>" + "</Auth>" + "</" + nombre + ">";
    }

    @Override
    public String soapAction() {
        return "http://ar.gov.afip.dif.bfe/BFEGetLast_ID";
    }

    @Override
    public String nombreMensaje() {
        return "Buscando Ultimo ID";
    }

    @Override
    public boolean esFacturar() {
        return false;
    }

    @Override
    public String nombreMensajeXML() {
        return "BFEGetLast_ID";
    }
}

