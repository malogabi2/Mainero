/*
 * Decompiled with CFR 0_124.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.Layout
 */
package Proyecto.GestorArchivos;

import Proyecto.GestorArchivos.GestorAConfiguracion;
import Proyecto.modelo.DetalleFactura;
import Proyecto.modelo.Factura;
import Proyecto.modelo.Producto;
import Proyecto.modelo.TokenSign;
import Proyecto.utilerias.Utilerias;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.Layout;

public class GestorAFactura {
    String archivoFactura;

    public GestorAFactura(String archivo) {
        this.archivoFactura = archivo;
    }

    public void crearArchivoFacConsulta(TokenSign tok, String cuit) {
        try {
            File file = new File(this.archivoFactura);
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("token=" + tok.getToken());
            bw.write(Layout.LINE_SEP);
            bw.write("sign=" + tok.getSign());
            bw.write(Layout.LINE_SEP);
            bw.write("cuit=" + cuit);
            bw.close();
        }
        catch (IOException ex) {
            Logger.getLogger(GestorAConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearArchivoFacFacturarWFE(TokenSign tok, String cuit, Factura fac) {
        try {
            File file = new File(this.archivoFactura);
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("token=" + tok.getToken());
            bw.write(Layout.LINE_SEP);
            bw.write("sign=" + tok.getSign());
            bw.write(Layout.LINE_SEP);
            bw.write("cuit=" + cuit);
            bw.write(Layout.LINE_SEP);
            bw.write("cantreq=1");
            bw.write(Layout.LINE_SEP);
            bw.write("ptoVta=" + fac.getSuc_comprobante());
            bw.write(Layout.LINE_SEP);
            bw.write("CbteTipo=" + fac.getTipo_comprobante());
            bw.write(Layout.LINE_SEP);
            bw.write("Concepto=1");
            bw.write(Layout.LINE_SEP);
            bw.write("DocTipo=" + fac.getTipo_documento());
            bw.write(Layout.LINE_SEP);
            bw.write("DocNro=" + fac.getClienteNumDoc());
            bw.write(Layout.LINE_SEP);
            bw.write("CbteDesde=" + fac.getNum_nombrante());
            bw.write(Layout.LINE_SEP);
            bw.write("CbteHasta=" + fac.getNum_nombrante());
            bw.write(Layout.LINE_SEP);
            bw.write("CbteFch=" + fac.getFecha());
            bw.write(Layout.LINE_SEP);
            bw.write("ImpTotal=" + fac.getImporteTotal());
            bw.write(Layout.LINE_SEP);
            bw.write("ImpTotConc=0");
            bw.write(Layout.LINE_SEP);
            bw.write("ImpNeto=" + fac.getImporteGrafado());
            bw.write(Layout.LINE_SEP);
            bw.write("ImpOpEx=" + fac.getImporteExento());
            bw.write(Layout.LINE_SEP);
            bw.write("ImpTrib=" + Utilerias.mostrarEnNDecimales(fac.totalTributos().floatValue(), 2));
            bw.write(Layout.LINE_SEP);
            bw.write("ImpIVA=" + Utilerias.mostrarEnNDecimales(fac.totalIva().floatValue(), 2));
            bw.write(Layout.LINE_SEP);
            bw.write("FchServDesde=" + fac.getFecha());
            bw.write(Layout.LINE_SEP);
            bw.write("FchServHasta=" + fac.getFecha());
            bw.write(Layout.LINE_SEP);
            bw.write("FchServHasta=" + fac.getFecha());
            bw.write(Layout.LINE_SEP);
            bw.write("FchVtoPago=" + fac.getFecha());
            bw.write(Layout.LINE_SEP);
            bw.write("MonId=PES");
            bw.write(Layout.LINE_SEP);
            bw.write("MonCotiz=1");
            bw = this.armarIva(bw, fac);
            bw = this.armarTributo(bw, fac);
            bw.close();
        }
        catch (IOException ex) {
            Logger.getLogger(GestorAConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private BufferedWriter armarTributo(BufferedWriter bw, Factura fac) {
        try {
            double base;
            String basSt;
            int cantTrib = 0;
            int punt = 0;
            if (Double.valueOf(fac.getPercep_IIBB()) > 0.0) {
                ++cantTrib;
            }
            if (Double.valueOf(fac.getPercep_mun()) > 0.0) {
                ++cantTrib;
            }
            if (Double.valueOf(fac.getPercep_nac()) > 0.0) {
                ++cantTrib;
            }
            if (Double.valueOf(fac.getImpuestoInter()) > 0.0) {
                ++cantTrib;
            }
            bw.write(Layout.LINE_SEP);
            bw.write("CantidadTrib=" + cantTrib);
            if (Double.valueOf(fac.getPercep_mun()) > 0.0) {
                base = 100.0 * Double.valueOf(fac.getPercep_mun()) / (double)fac.mostrarItemDetalleFactura(0).getMunicipalidad();
                basSt = Utilerias.mostrarEnNDecimales(base, 2);
                bw.write(Layout.LINE_SEP);
                bw.write("idT" + ++punt + "=3");
                bw.write(Layout.LINE_SEP);
                bw.write("descT" + punt + "= ");
                bw.write(Layout.LINE_SEP);
                bw.write("BaseImpT" + punt + "=" + basSt);
                bw.write(Layout.LINE_SEP);
                bw.write("alicT" + punt + "=" + fac.mostrarItemDetalleFactura(0).getMunicipalidad());
                bw.write(Layout.LINE_SEP);
                bw.write("ImporteT" + punt + "=" + fac.getPercep_mun());
            }
            if (Double.valueOf(fac.getPercep_IIBB()) > 0.0) {
                base = 100.0 * Double.valueOf(fac.getPercep_IIBB()) / (double)fac.mostrarItemDetalleFactura(0).getIng_brutos();
                basSt = Utilerias.mostrarEnNDecimales(base, 2);
                bw.write(Layout.LINE_SEP);
                bw.write("idT" + ++punt + "=2");
                bw.write(Layout.LINE_SEP);
                bw.write("descT" + punt + "= ");
                bw.write(Layout.LINE_SEP);
                bw.write("BaseImpT" + punt + "=" + basSt);
                bw.write(Layout.LINE_SEP);
                bw.write("alicT" + punt + "=" + fac.mostrarItemDetalleFactura(0).getIng_brutos());
                bw.write(Layout.LINE_SEP);
                bw.write("ImporteT" + punt + "=" + fac.getPercep_IIBB());
            }
            if (Double.valueOf(fac.getPercep_nac()) > 0.0) {
                base = 100.0 * Double.valueOf(fac.getPercep_nac()) / (double)fac.mostrarItemDetalleFactura(0).getRg3337();
                basSt = Utilerias.mostrarEnNDecimales(base, 2);
                bw.write(Layout.LINE_SEP);
                bw.write("idT" + ++punt + "=1");
                bw.write(Layout.LINE_SEP);
                bw.write("descT" + punt + "= ");
                bw.write(Layout.LINE_SEP);
                bw.write("BaseImpT" + punt + "=" + basSt);
                bw.write(Layout.LINE_SEP);
                bw.write("alicT" + punt + "=" + fac.mostrarItemDetalleFactura(0).getRg3337());
                bw.write(Layout.LINE_SEP);
                bw.write("ImporteT" + punt + "=" + fac.getPercep_nac());
            }
            if (Double.valueOf(fac.getImpuestoInter()) > 0.0) {
                base = 100.0 * Double.valueOf(fac.getImpuestoInter()) / (double)fac.mostrarItemDetalleFactura(0).getInterno();
                basSt = Utilerias.mostrarEnNDecimales(base, 2);
                bw.write(Layout.LINE_SEP);
                bw.write("idT" + ++punt + "=99");
                bw.write(Layout.LINE_SEP);
                bw.write("descT" + punt + "= ");
                bw.write(Layout.LINE_SEP);
                bw.write("BaseImpT" + punt + "=" + basSt);
                bw.write(Layout.LINE_SEP);
                bw.write("alicT" + punt + "=" + fac.mostrarItemDetalleFactura(0).getInterno());
                bw.write(Layout.LINE_SEP);
                bw.write("ImporteT" + punt + "=" + fac.getImpuestoInter());
            }
        }
        catch (IOException ex) {
            Logger.getLogger(GestorAFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bw;
    }

    private BufferedWriter armarIva(BufferedWriter bw, Factura fac) {
        try {
            int cantiva = 0;
            int punt = 0;
            if (Double.valueOf(fac.getImporteIvaInscripto()) > 0.0) {
                ++cantiva;
            }
            if (Double.valueOf(fac.getImporteIvaNoInscripto()) > 0.0) {
                ++cantiva;
            }
            bw.write(Layout.LINE_SEP);
            bw.write("CantidadIva=" + cantiva);
            if (Double.valueOf(fac.getImporteIvaInscripto()) > 0.0) {
                bw.write(Layout.LINE_SEP);
                bw.write("id" + ++punt + "=4");
                bw.write(Layout.LINE_SEP);
                bw.write("BaseImp" + punt + "=" + fac.getImporteGrafado());
                bw.write(Layout.LINE_SEP);
                bw.write("Importe" + punt + "=" + fac.getImporteIvaInscripto());
            }
            if (Double.valueOf(fac.getImporteIvaNoInscripto()) > 0.0) {
                bw.write(Layout.LINE_SEP);
                bw.write("id" + ++punt + "=5");
                bw.write(Layout.LINE_SEP);
                bw.write("BaseImp" + punt + "=" + fac.getImporteGrafado());
                bw.write(Layout.LINE_SEP);
                bw.write("Importe" + punt + "" + "=" + fac.getImporteIvaNoInscripto());
            }
        }
        catch (IOException ex) {
            Logger.getLogger(GestorAFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bw;
    }

    public void crearArchivoFacFacturarWBFE(TokenSign tok, String cuit, long id, Factura fac) {
        try {
            File file = new File(this.archivoFactura);
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("token=" + tok.getToken());
            bw.write(Layout.LINE_SEP);
            bw.write("sign=" + tok.getSign());
            bw.write(Layout.LINE_SEP);
            bw.write("cuit=" + cuit);
            bw.write(Layout.LINE_SEP);
            bw.write("id=" + id);
            bw.write(Layout.LINE_SEP);
            bw.write("docTipo=" + fac.getTipo_documento());
            bw.write(Layout.LINE_SEP);
            bw.write("docNro=" + fac.getClienteNumDoc());
            bw.write(Layout.LINE_SEP);
            bw.write("zona=0");
            bw.write(Layout.LINE_SEP);
            bw.write("CbteTipo=" + fac.getTipo_comprobante());
            bw.write(Layout.LINE_SEP);
            bw.write("ptoVta=" + fac.getSuc_comprobante());
            bw.write(Layout.LINE_SEP);
            bw.write("cbteNro=" + fac.getNum_nombrante());
            bw.write(Layout.LINE_SEP);
            bw.write("ImpTotal=" + fac.getImporteTotal());
            bw.write(Layout.LINE_SEP);
            bw.write("Imp_tot_conc=0");
            bw.write(Layout.LINE_SEP);
            bw.write("Imp_neto=" + fac.getImporteGrafado());
            bw.write(Layout.LINE_SEP);
            bw.write("Impto_liq=0");
            bw.write(Layout.LINE_SEP);
            bw.write("Impto_liq_rni=0");
            bw.write(Layout.LINE_SEP);
            bw.write("Imp_op_ex=" + fac.getImporteNoGravado());
            bw.write(Layout.LINE_SEP);
            bw.write("Imp_perc=" + fac.getPercep_nac());
            bw.write(Layout.LINE_SEP);
            bw.write("Imp_iibb=" + fac.getPercep_IIBB());
            bw.write(Layout.LINE_SEP);
            bw.write("Imp_perc_mun=" + fac.getPercep_mun());
            bw.write(Layout.LINE_SEP);
            bw.write("Imp_internos=" + fac.getImpuestoInter());
            bw.write(Layout.LINE_SEP);
            bw.write("Imp_moneda_Id=PES");
            bw.write(Layout.LINE_SEP);
            bw.write("Imp_moneda_ctz=1");
            bw.write(Layout.LINE_SEP);
            bw.write("fecha_cbte=" + fac.getFecha());
            bw.write(Layout.LINE_SEP);
            bw.write("CantidadItem=1");
            bw.write(Layout.LINE_SEP);
            bw.write("Pro_codigo_ncm1=" + fac.mostrarItemProducto(0).getNomenclador().trim());
            bw.write(Layout.LINE_SEP);
            bw.write("Pro_codigo_sec1=" + fac.mostrarItemProducto(0).getCodigoProducto().trim());
            bw.write(Layout.LINE_SEP);
            bw.write("Pro_des1= ");
            bw.write(Layout.LINE_SEP);
            bw.write("Pro_qty1=1");
            bw.write(Layout.LINE_SEP);
            bw.write("Pro_umed1=7");
            bw.write(Layout.LINE_SEP);
            bw.write("Pro_precio_uni1=" + fac.getImporteGrafado());
            bw.write(Layout.LINE_SEP);
            bw.write("Imp_bonif1=0");
            bw.write(Layout.LINE_SEP);
            bw.write("Imp_total1=" + fac.getImporteTotal());
            bw.write(Layout.LINE_SEP);
            bw.write("Iva_id1=4");
            bw.close();
        }
        catch (IOException ex) {
            Logger.getLogger(GestorAConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

