/*
 * Decompiled with CFR 0_124.
 */
package wfewfbe.LectorFactura;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import wfewfbe.LectorFactura.LectorEntradaFactura;

public class LectorEntradaFacturaBFE
extends LectorEntradaFactura {
    @Override
    public String[] lectorPropiedadesMensaje(String archivo) throws FileNotFoundException, IOException {
        Properties config = new Properties();
        String[] prtos = new String[3];
        config.load(new FileInputStream(archivo));
        prtos[0] = config.getProperty("token", "error");
        prtos[1] = config.getProperty("sign", "error");
        prtos[2] = config.getProperty("cuit", "error");
        return prtos;
    }

    @Override
    public String[] lectorPropiedadesFacturar(String archivo) throws IOException, FileNotFoundException {
        Properties config = new Properties();
        String[] prtos = new String[24];
        config.load(new FileInputStream(archivo));
        prtos[0] = config.getProperty("token", "error");
        prtos[1] = config.getProperty("sign", "error");
        prtos[2] = config.getProperty("cuit", "error");
        prtos[3] = config.getProperty("id", "error");
        prtos[4] = config.getProperty("docTipo", "error");
        prtos[5] = config.getProperty("docNro", "error");
        prtos[6] = config.getProperty("zona", "error");
        prtos[7] = config.getProperty("CbteTipo", "error");
        prtos[8] = config.getProperty("ptoVta", "error");
        prtos[9] = config.getProperty("cbteNro", "error");
        prtos[10] = config.getProperty("ImpTotal", "error");
        prtos[11] = config.getProperty("Imp_tot_conc", "error");
        prtos[12] = config.getProperty("Imp_neto", "error");
        prtos[13] = config.getProperty("Impto_liq", "error");
        prtos[14] = config.getProperty("Impto_liq_rni", "error");
        prtos[15] = config.getProperty("Imp_op_ex", "error");
        prtos[16] = config.getProperty("Imp_perc", "error");
        prtos[17] = config.getProperty("Imp_iibb", "error");
        prtos[18] = config.getProperty("Imp_perc_mun", "error");
        prtos[19] = config.getProperty("Imp_internos", "error");
        prtos[20] = config.getProperty("Imp_moneda_Id", "error");
        prtos[21] = config.getProperty("Imp_moneda_ctz", "error");
        prtos[22] = config.getProperty("fecha_cbte", "error");
        prtos[23] = config.getProperty("CantidadItem", "error");
        prtos = this.rutinaItems(prtos, config);
        return prtos;
    }

    private String[] rutinaItems(String[] parametros, Properties config) {
        int cantidadItem = parametros[23].equals("error") ? 0 : Integer.valueOf(parametros[23]);
        int conta = 1;
        String[] aux = new String[parametros.length + cantidadItem * 9];
        System.arraycopy(parametros, 0, aux, 0, 24);
        if (cantidadItem != 0) {
            for (int i = 24; i < parametros.length + cantidadItem * 8; ++i) {
                aux[i] = config.getProperty("Pro_codigo_ncm" + String.valueOf(conta));
                aux[i + 1] = config.getProperty("Pro_codigo_sec" + String.valueOf(conta));
                aux[i + 2] = config.getProperty("Pro_ds" + String.valueOf(conta));
                aux[i + 3] = config.getProperty("Pro_qty" + String.valueOf(conta));
                aux[i + 4] = config.getProperty("Pro_umed" + String.valueOf(conta));
                aux[i + 5] = config.getProperty("Pro_precio_uni" + String.valueOf(conta));
                aux[i + 6] = config.getProperty("Imp_bonif" + String.valueOf(conta));
                aux[i + 7] = config.getProperty("Imp_total" + String.valueOf(conta));
                aux[i + 8] = config.getProperty("Iva_id" + String.valueOf(conta));
                ++conta;
                i += 8;
            }
        }
        return aux;
    }
}

