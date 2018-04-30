/*
 * Decompiled with CFR 0_124.
 */
package wfewfbe.metodo.bfe;

import wfewfbe.metodo.wfev1.Mensajes;

public class BFEGetPARAM_NCM
extends Mensajes {
    @Override
    protected String cuerpo(String[] parametros, String nombre) {
        return "<BFEGetPARAM_NCM xmlns=\"http://ar.gov.afip.dif.bfe/\" ><Auth><Token>" + parametros[0] + "</Token>" + "<Sign>" + parametros[1] + "</Sign>" + "<Cuit>" + parametros[2] + "</Cuit>" + "<Punto_vta>" + parametros[3] + "</Punto_vta>" + "<Tipo_cbte>" + parametros[4] + "</Tipo_cbte>" + "</Auth>" + "</BFEGetPARAM_NCM>";
    }

    @Override
    public String soapAction() {
        return "http://ar.gov.afip.dif.bfe/BFEGetPARAM_NCM";
    }

    @Override
    public String nombreMensaje() {
        return "Buscando Producto... \nEsto Puede Demorar Varios Minutos \n... Por Favor Espere";
    }

    @Override
    public boolean esFacturar() {
        return false;
    }

    @Override
    public String nombreMensajeXML() {
        return "BFEGetPARAM_NCM";
    }
}

