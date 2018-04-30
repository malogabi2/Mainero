/*
 * Decompiled with CFR 0_124.
 */
package wfewfbe.metodo.bfe;

import wfewfbe.metodo.wfev1.Mensajes;

public class BFEAuthorize
extends Mensajes {
    private String mensajeInicioParte(String[] parametros) {
        return "<BFEAuthorize xmlns=\"http://ar.gov.afip.dif.bfe/\"><Auth><Token>" + parametros[0] + "</Token>" + "<Sign>" + parametros[1] + "</Sign>" + "<Cuit>" + parametros[2] + "</Cuit>" + "</Auth>" + "<Cmp>" + "<Id>" + parametros[3] + "</Id>" + "<Tipo_doc>" + parametros[4] + "</Tipo_doc>" + "<Nro_doc>" + parametros[5] + "</Nro_doc>" + "<Zona>" + parametros[6] + "</Zona>" + "<Tipo_cbte>" + parametros[7] + "</Tipo_cbte>" + "<Punto_vta>" + parametros[8] + "</Punto_vta>" + "<Cbte_nro>" + parametros[9] + "</Cbte_nro>" + "<Imp_total>" + parametros[10] + "</Imp_total>" + "<Imp_tot_conc>" + parametros[11] + "</Imp_tot_conc>" + "<Imp_neto>" + parametros[12] + "</Imp_neto>" + "<Impto_liq>" + parametros[13] + "</Impto_liq>" + "<Impto_liq_rni>" + parametros[14] + "</Impto_liq_rni>" + "<Imp_op_ex>" + parametros[15] + "</Imp_op_ex>" + "<Imp_perc>" + parametros[16] + "</Imp_perc>" + "<Imp_iibb>" + parametros[17] + "</Imp_iibb>" + "<Imp_perc_mun>" + parametros[18] + "</Imp_perc_mun>" + "<Imp_internos>" + parametros[19] + "</Imp_internos>" + "<Imp_moneda_Id>" + parametros[20] + "</Imp_moneda_Id>" + "<Imp_moneda_ctz>" + parametros[21] + "</Imp_moneda_ctz>" + "<fecha_cbte>" + parametros[22] + "</fecha_cbte>";
    }

    private String mensajeItems(String[] parametros, String mensajeParcial) {
        int cantidad = parametros[23].equals("error") ? 0 : Integer.valueOf(parametros[23]);
        if (cantidad == 0) {
            return mensajeParcial;
        }
        mensajeParcial = mensajeParcial + "<Items>";
        for (int i = 0; i < cantidad * 9; ++i) {
            mensajeParcial = mensajeParcial + "<Item>" + "<Pro_codigo_ncm>" + parametros[24 + i] + "</Pro_codigo_ncm>" + "<Pro_codigo_sec>" + parametros[24 + i + 1] + "</Pro_codigo_sec>" + "<Pro_ds>" + parametros[24 + i + 2] + "</Pro_ds>" + "<Pro_qty>" + parametros[24 + i + 3] + "</Pro_qty>" + "<Pro_umed>" + parametros[24 + i + 4] + "</Pro_umed>" + "<Pro_precio_uni>" + parametros[24 + i + 5] + "</Pro_precio_uni>" + "<Imp_bonif>" + parametros[24 + i + 6] + "</Imp_bonif>" + "<Imp_total>" + parametros[24 + i + 7] + "</Imp_total>" + "<Iva_id>" + parametros[24 + i + 8] + "</Iva_id>" + "</Item>";
            i += 8;
        }
        mensajeParcial = mensajeParcial + "</Items>";
        return mensajeParcial;
    }

    private String mensajeFinalParte(String mensajeParcial) {
        return mensajeParcial + "</Cmp>" + "</BFEAuthorize>";
    }

    @Override
    protected String cuerpo(String[] parametros, String nombre) {
        return this.mensajeFinalParte(this.mensajeItems(parametros, this.mensajeInicioParte(parametros)));
    }

    @Override
    public String soapAction() {
        return "http://ar.gov.afip.dif.bfe/BFEAuthorize";
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
        return "BFEAuthorize";
    }
}

