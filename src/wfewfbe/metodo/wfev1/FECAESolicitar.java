/*
 * Decompiled with CFR 0_124.
 */
package wfewfbe.metodo.wfev1;

import wfewfbe.metodo.wfev1.Mensajes;

public class FECAESolicitar
extends Mensajes {
    private String mensajeInicioParte(String[] parametros) {
        return "<FECAESolicitar xmlns=\"http://ar.gov.afip.dif.FEV1/\"><Auth><Token>" + parametros[0] + "</Token>" + "<Sign>" + parametros[1] + "</Sign>" + "<Cuit>" + parametros[2] + "</Cuit>" + "</Auth>" + "<FeCAEReq>" + "<FeCabReq>" + "<CantReg>" + parametros[3] + "</CantReg>" + "<PtoVta>" + parametros[4] + "</PtoVta>" + "<CbteTipo>" + parametros[5] + "</CbteTipo>" + "</FeCabReq>" + "<FeDetReq>" + "<FECAEDetRequest>" + "<Concepto>" + parametros[6] + "</Concepto>" + "<DocTipo>" + parametros[7] + "</DocTipo>" + "<DocNro>" + parametros[8] + "</DocNro>" + "<CbteDesde>" + parametros[9] + "</CbteDesde>" + "<CbteHasta>" + parametros[10] + "</CbteHasta>" + "<CbteFch>" + parametros[11] + "</CbteFch>" + "<ImpTotal>" + parametros[12] + "</ImpTotal>" + "<ImpTotConc>" + parametros[13] + "</ImpTotConc>" + "<ImpNeto>" + parametros[14] + "</ImpNeto>" + "<ImpOpEx>" + parametros[15] + "</ImpOpEx>" + "<ImpTrib>" + parametros[16] + "</ImpTrib>" + "<ImpIVA>" + parametros[17] + "</ImpIVA>" + "<MonId>" + parametros[21] + "</MonId>" + "<MonCotiz>" + parametros[22] + "</MonCotiz>";
    }

    private String mensajeTributo(String[] parametros, String mensajeParcial) {
        int cantidad = parametros[24].equals("error") ? 0 : Integer.valueOf(parametros[24]);
        int limite = parametros[23].equals("error") ? 0 : Integer.valueOf(parametros[23]);
        limite = limite * 3 + 25;
        if (cantidad == 0) {
            return mensajeParcial;
        }
        mensajeParcial = mensajeParcial + "<Tributos>";
        for (int i = 0; i < cantidad * 5; ++i) {
            mensajeParcial = mensajeParcial + "<Tributo>" + "<Id>" + parametros[limite + i] + "</Id>" + "<Desc>" + parametros[limite + i + 1] + "</Desc>" + "<BaseImp>" + parametros[limite + i + 2] + "</BaseImp>" + "<Alic>" + parametros[limite + i + 3] + "</Alic>" + "<Importe>" + parametros[limite + i + 4] + "</Importe>" + "</Tributo>";
            i += 4;
        }
        mensajeParcial = mensajeParcial + "</Tributos>";
        return mensajeParcial;
    }

    private String mensajeIvaParte(String[] parametros, String mensajeParcial) {
        int cantidad = parametros[23].equals("error") ? 0 : Integer.valueOf(parametros[23]);
        if (cantidad == 0) {
            return mensajeParcial;
        }
        mensajeParcial = mensajeParcial + "<Iva>";
        for (int i = 0; i < cantidad * 3; ++i) {
            mensajeParcial = mensajeParcial + "<AlicIva>" + "<Id>" + parametros[24 + i + 1] + "</Id>" + "<BaseImp>" + parametros[24 + i + 2] + "</BaseImp>" + "<Importe>" + parametros[24 + i + 3] + "</Importe>" + "</AlicIva>";
            ++i;
            ++i;
        }
        mensajeParcial = mensajeParcial + "</Iva>";
        return mensajeParcial;
    }

    private String mensajeFinalParte(String mensajeParcial) {
        return mensajeParcial + "</FECAEDetRequest>" + "</FeDetReq>" + "</FeCAEReq>" + "</FECAESolicitar>";
    }

    @Override
    protected String cuerpo(String[] parametros, String nombre) {
        return this.mensajeFinalParte(this.mensajeIvaParte(parametros, this.mensajeTributo(parametros, this.mensajeInicioParte(parametros))));
    }

    @Override
    public String soapAction() {
        return "http://ar.gov.afip.dif.FEV1/FECAESolicitar";
    }

    @Override
    public String nombreMensaje() {
        return "Validando Comprobante";
    }

    @Override
    public boolean esFacturar() {
        return true;
    }

    @Override
    public String nombreMensajeXML() {
        return "FECAESolicitar";
    }
}

