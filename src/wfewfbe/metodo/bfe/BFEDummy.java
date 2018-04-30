/*
 * Decompiled with CFR 0_124.
 */
package wfewfbe.metodo.bfe;

import wfewfbe.metodo.wfev1.Mensajes;

public class BFEDummy
extends Mensajes {
    @Override
    public String soapAction() {
        return "http://ar.gov.afip.dif.bfe/BFEDummy";
    }

    @Override
    public String nombreMensaje() {
        return "Analizando estado de conexi\u00f3n del servidor";
    }

    @Override
    protected String cuerpo(String[] parametros, String nombre) {
        return "<BFEDummy xmlns=\"http://ar.gov.afip.dif.bfe/\" />";
    }

    @Override
    public boolean esFacturar() {
        return false;
    }

    @Override
    public String nombreMensajeXML() {
        return "BFEDummy";
    }
}

