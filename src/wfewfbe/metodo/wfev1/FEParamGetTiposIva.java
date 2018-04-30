/*
 * Decompiled with CFR 0_124.
 */
package wfewfbe.metodo.wfev1;

import wfewfbe.metodo.wfev1.Mensajes;

public class FEParamGetTiposIva
extends Mensajes {
    @Override
    protected String cuerpo(String[] parametros, String nombre) {
        return this.cuerpoParametrosFE(parametros, nombre);
    }

    @Override
    public String nombreMensaje() {
        return "Buscando tipos de al\u00edcuotas de iva";
    }

    @Override
    public String soapAction() {
        return "http://ar.gov.afip.dif.FEV1/FEParamGetTiposIva";
    }

    @Override
    public boolean esFacturar() {
        return false;
    }

    @Override
    public String nombreMensajeXML() {
        return "FEParamGetTiposIva";
    }
}

