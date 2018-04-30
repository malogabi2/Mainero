/*
 * Decompiled with CFR 0_124.
 */
package wfewfbe.metodo.wfev1;

import wfewfbe.metodo.wfev1.Mensajes;

public class FEDummy
extends Mensajes {
    @Override
    public String soapAction() {
        return "http://ar.gov.afip.dif.FEV1/FEDummy";
    }

    @Override
    public String nombreMensaje() {
        return "Analizando estado de conexi\u00f3n del servidor";
    }

    @Override
    protected String cuerpo(String[] parametros, String nombre) {
        return "<FEDummy xmlns=\"http://ar.gov.afip.dif.FEV1/\" />";
    }

    @Override
    public boolean esFacturar() {
        return false;
    }

    @Override
    public String nombreMensajeXML() {
        return "FEDummy";
    }
}

