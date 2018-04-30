/*
 * Decompiled with CFR 0_124.
 */
package wfewfbe.metodo.wfev1;

public class FEParametros {
    protected String cuerpo(String[] parametros, String nombre) {
        return "<" + nombre + " xmlns=\"http://ar.gov.afip.dif.FEV1/\" >" + "<Auth>" + "<Token>" + parametros[0] + "</Token>" + "<Sign>" + parametros[1] + "</Sign>" + "<Cuit>" + parametros[2] + "</Cuit>" + "</Auth>" + "</" + nombre + ">";
    }
}

