/*
 * Decompiled with CFR 0_124.
 */
package wfewfbe.LectorFactura;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LectorEntradaFacturaFE
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
        String[] prtos = new String[25];
        config.load(new FileInputStream(archivo));
        prtos[0] = config.getProperty("token", "error");
        prtos[1] = config.getProperty("sign", "error");
        prtos[2] = config.getProperty("cuit", "error");
        prtos[3] = config.getProperty("cantreq", "error");
        prtos[4] = config.getProperty("ptoVta", "error");
        prtos[5] = config.getProperty("CbteTipo", "error");
        prtos[6] = config.getProperty("Concepto", "error");
        prtos[7] = config.getProperty("DocTipo", "error");
        prtos[8] = config.getProperty("DocNro", "error");
        prtos[9] = config.getProperty("CbteDesde", "error");
        prtos[10] = config.getProperty("CbteHasta", "error");
        prtos[11] = config.getProperty("CbteFch", "error");
        prtos[12] = config.getProperty("ImpTotal", "error");
        prtos[13] = config.getProperty("ImpTotConc", "error");
        prtos[14] = config.getProperty("ImpNeto", "error");
        prtos[15] = config.getProperty("ImpOpEx", "error");
        prtos[16] = config.getProperty("ImpTrib", "error");
        prtos[17] = config.getProperty("ImpIVA", "error");
        prtos[18] = config.getProperty("FchServDesde", "error");
        prtos[19] = config.getProperty("FchServHasta", "error");
        prtos[20] = config.getProperty("FchVtoPago", "error");
        prtos[21] = config.getProperty("MonId", "error");
        prtos[22] = config.getProperty("MonCotiz", "error");
        prtos[23] = config.getProperty("CantidadIva", "error");
        prtos[24] = config.getProperty("CantidadTrib", "error");
        prtos = this.rutinaDeIvas(prtos, config);
        prtos = this.rutinaDeTributos(prtos, config);
        prtos = this.rutinaDeComproAsociados(prtos, config);
        prtos = this.rutinaDePeriodoAsociados(prtos, config);
        return prtos;
    }

    private String[] rutinaDeIvas(String[] parametros, Properties config) {
        int cantidadIva = parametros[23].equals("error") ? 0 : Integer.valueOf(parametros[23]);
        int conta = 1;
        String[] aux = new String[parametros.length + cantidadIva * 3];
        System.arraycopy(parametros, 0, aux, 0, 25);
        if (cantidadIva != 0) {
            for (int i = 25; i < parametros.length + (cantidadIva + 2); ++i) {
                aux[i] = config.getProperty("id" + String.valueOf(conta));
                aux[i + 1] = config.getProperty("BaseImp" + String.valueOf(conta));
                aux[i + 2] = config.getProperty("Importe" + String.valueOf(conta));
                ++conta;
                ++i;
                ++i;
            }
        }
        return aux;
    }

    private String[] rutinaDeTributos(String[] parametros, Properties config) {
        int cantidadTributos = parametros[24].equals("error") ? 0 : Integer.valueOf(parametros[24]);
        int conta = 1;
        String[] aux = new String[parametros.length + cantidadTributos * 5];
        System.arraycopy(parametros, 0, aux, 0, parametros.length);
        if (cantidadTributos != 0) {
            for (int i = parametros.length; i < parametros.length + cantidadTributos * 5; ++i) {
                aux[i] = config.getProperty("idT" + String.valueOf(conta));
                aux[i + 1] = config.getProperty("descT" + String.valueOf(conta));
                aux[i + 2] = config.getProperty("BaseImpT" + String.valueOf(conta));
                aux[i + 3] = config.getProperty("alicT" + String.valueOf(conta));
                aux[i + 4] = config.getProperty("ImporteT" + String.valueOf(conta));
                ++conta;
                i += 4;
            }
        }
        return aux;
    }

    private String[] rutinaDeComproAsociados(String[] parametros, Properties config) {
        String cantidadComprobanteAsociados = config.getProperty("CantidadComprobanteAsociados", "error");
        int cantidadCompro = cantidadComprobanteAsociados.equals("error") ? 0 : Integer.valueOf(cantidadComprobanteAsociados);
        if(cantidadCompro == 0) {
            String[] aux = new String[parametros.length + 1];
            System.arraycopy(parametros, 0, aux, 0, parametros.length);
            aux[parametros.length] = "0";
            return aux;
        }
        String[] aux = new String[parametros.length + (cantidadCompro * 3) + 1];
        System.arraycopy(parametros, 0, aux, 0, parametros.length);
        aux[parametros.length] = String.valueOf(cantidadCompro);
        int conta = 1;
        for (int i = parametros.length; i < aux.length; ++i) {
            aux[i+1] = config.getProperty("CompoAsocTipo" + String.valueOf(conta));
            aux[i+2] = config.getProperty("CompoAsocPtoVta" + String.valueOf(conta));
            aux[i+3] = config.getProperty("CompoAsocNro" + String.valueOf(conta));
            conta++;
            ++i;
            ++i;
        }
        return aux;
    }
    
    private String[] rutinaDePeriodoAsociados(String[] parametros, Properties config) {
        int cantidadTributo = parametros[24].equals("error") ? 1 : Integer.valueOf(parametros[24]);
        int cantidadIva = parametros[23].equals("error") ? 1 : Integer.valueOf(parametros[23]);
        int posCantidadComprobante = (24 + (cantidadIva * 3) + (cantidadTributo * 5) ) + 1;
        int cantidadComprobante = parametros[posCantidadComprobante].equals("error") ? 0 : Integer.valueOf(parametros[posCantidadComprobante]);
        int posPeriodoAsociado = posCantidadComprobante + (cantidadComprobante * 3);
        if(posPeriodoAsociado >= parametros.length) {
            return parametros;
        }
        String[] aux = new String[parametros.length + 2];
        System.arraycopy(parametros, 0, aux, 0, parametros.length);
        aux[parametros.length] = config.getProperty("PeriodoAsocFchDesde");
        aux[parametros.length + 1] = config.getProperty("PeriodoAsocFchHasta");               
               
        return aux;
    }
}

