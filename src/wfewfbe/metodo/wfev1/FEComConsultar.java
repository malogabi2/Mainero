/*
 * Decompiled with CFR 0_124.
 */
package wfewfbe.metodo.wfev1;

import wfewfbe.metodo.wfev1.Mensajes;

public class FEComConsultar
extends Mensajes {
    @Override
    public boolean esFacturar() {
        return false;
    }

    @Override
    protected String cuerpo(String[] parametros, String nombre) {
        String con = "<FECompConsultar xmlns=\"http://ar.gov.afip.dif.FEV1/\" ><Auth><Token>" + parametros[0] + "</Token>" + "<Sign>" + parametros[1] + "</Sign>" + "<Cuit>" + parametros[2] + "</Cuit>" + "</Auth>" + "<FECompConsReq>" + "<CbteTipo>" + parametros[4] + "</CbteTipo>" + "<CbteNro>" + parametros[5] + "</CbteNro>" + "<PtoVta>" + parametros[3] + "</PtoVta>" + "</FECompConsReq>" + "</FECompConsultar>";
        return "<FECompConsultar xmlns=\"http://ar.gov.afip.dif.FEV1/\" ><Auth><Token>" + parametros[0] + "</Token>" + "<Sign>" + parametros[1] + "</Sign>" + "<Cuit>" + parametros[2] + "</Cuit>" + "</Auth>" + "<FeCompConsReq>" + "<CbteTipo>" + parametros[4] + "</CbteTipo>" + "<CbteNro>" + parametros[5] + "</CbteNro>" + "<PtoVta>" + parametros[3] + "</PtoVta>" + "</FeCompConsReq>" + "</FECompConsultar>";
    }

    @Override
    public String nombreMensaje() {
        return "Buscando comprobante";
    }

    @Override
    public String soapAction() {
        return "http://ar.gov.afip.dif.FEV1/FECompConsultar";
    }

    @Override
    public String nombreMensajeXML() {
        return "FECompConsultar";
    }

    @Override
    public boolean esConsulta() {
        return true;
    }
}

