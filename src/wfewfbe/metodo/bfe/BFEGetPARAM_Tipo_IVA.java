/*
 * Decompiled with CFR 0_124.
 */
package wfewfbe.metodo.bfe;

import wfewfbe.metodo.wfev1.Mensajes;

public class BFEGetPARAM_Tipo_IVA
extends Mensajes {
    @Override
    protected String cuerpo(String[] parametros, String nombre) {
        return this.cuerpoParametrosBFE(parametros, nombre);
    }

    @Override
    public String soapAction() {
        return "http://ar.gov.afip.dif.bfe/BFEGetPARAM_Tipo_IVA";
    }

    @Override
    public String nombreMensaje() {
        return "Buscando tipos de Iva";
    }

    @Override
    public boolean esFacturar() {
        return false;
    }

    @Override
    public String nombreMensajeXML() {
        return "BFEGetPARAM_Tipo_IVA";
    }
}

