/*
 * Decompiled with CFR 0_124.
 */
package wfewfbe.metodo.wfev1;

import wfewfbe.metodo.wfev1.Mensajes;

public class FECompUltimoAutorizado
extends Mensajes {
    @Override
    protected String cuerpo(String[] parametros, String nombre) {
        return "<FECompUltimoAutorizado xmlns=\"http://ar.gov.afip.dif.FEV1/\" ><Auth><Token>" + parametros[0] + "</Token>" + "<Sign>" + parametros[1] + "</Sign>" + "<Cuit>" + parametros[2] + "</Cuit>" + "</Auth>" + "<PtoVta>" + parametros[3] + "</PtoVta>" + "<CbteTipo>" + parametros[4] + "</CbteTipo>" + "</FECompUltimoAutorizado>";
    }

    @Override
    public String soapAction() {
        return "http://ar.gov.afip.dif.FEV1/FECompUltimoAutorizado";
    }

    @Override
    public String nombreMensaje() {
        return "Buscando \u00faltimo comprobante autorizado";
    }

    @Override
    public boolean esFacturar() {
        return false;
    }

    @Override
    public String nombreMensajeXML() {
        return "FECompUltimoAutorizado";
    }
}

