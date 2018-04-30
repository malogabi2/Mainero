/*
 * Decompiled with CFR 0_124.
 */
package wfewfbe.metodo.bfe;

public class BFEParametrosBFE {
    public String cuerpo(String[] parametros, String nombre) {
        return "<" + nombre + " xmlns=\"http://ar.gov.afip.dif.bfe/\" >" + "<auth>" + "<Token>" + parametros[0] + "</Token>" + "<Sign>" + parametros[1] + "</Sign>" + "<Cuit>" + parametros[2] + "</Cuit>" + "</auth>" + "</" + nombre + ">";
    }
}

