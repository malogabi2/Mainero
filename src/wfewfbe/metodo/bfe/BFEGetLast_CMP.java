/*
 * Decompiled with CFR 0_124.
 */
package wfewfbe.metodo.bfe;

import wfewfbe.metodo.wfev1.Mensajes;

public class BFEGetLast_CMP
extends Mensajes {
    @Override
    public boolean esFacturar() {
        return false;
    }

    @Override
    protected String cuerpo(String[] parametros, String nombre) {
        return "<BFEGetLast_CMP xmlns=\"http://ar.gov.afip.dif.bfe/\" ><Auth><Token>" + parametros[0] + "</Token>" + "<Sign>" + parametros[1] + "</Sign>" + "<Cuit>" + parametros[2] + "</Cuit>" + "<Pto_venta>" + parametros[3] + "</Pto_venta>" + "<Tipo_cbte>" + parametros[4] + "</Tipo_cbte>" + "</Auth>" + "</BFEGetLast_CMP>";
    }

    @Override
    public String nombreMensaje() {
        return "Buscando ultimo comprobante autorizado";
    }

    @Override
    public String soapAction() {
        return "http://ar.gov.afip.dif.bfe/BFEGetLast_CMP";
    }

    @Override
    public String nombreMensajeXML() {
        return "BFEGetLast_CMP";
    }
}

