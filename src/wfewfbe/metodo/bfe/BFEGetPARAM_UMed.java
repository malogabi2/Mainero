/*
 * Decompiled with CFR 0_124.
 */
package wfewfbe.metodo.bfe;

import wfewfbe.metodo.wfev1.Mensajes;

public class BFEGetPARAM_UMed
extends Mensajes {
    @Override
    protected String cuerpo(String[] parametros, String nombre) {
        return this.cuerpoParametrosBFE(parametros, nombre);
    }

    @Override
    public String soapAction() {
        return "http://ar.gov.afip.dif.bfe/BFEGetPARAM_UMed";
    }

    @Override
    public String nombreMensaje() {
        return "Buscando unidades de Medida";
    }

    @Override
    public boolean esFacturar() {
        return false;
    }

    @Override
    public String nombreMensajeXML() {
        return "BFEGetPARAM_UMed";
    }
}

