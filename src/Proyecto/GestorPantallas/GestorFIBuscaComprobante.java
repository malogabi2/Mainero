/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.GestorPantallas;

import Proyecto.GestorArchivos.GestorAFactura;
import Proyecto.Intermediario.GestorComunicacion;
import Proyecto.modelo.Configuracion;
import Proyecto.modelo.Sucursal;
import Proyecto.modelo.TokenSign;
import Proyecto.modelo.Usuario;

public class GestorFIBuscaComprobante {
    Configuracion config;

    public GestorFIBuscaComprobante(Configuracion conf) {
        this.config = conf;
    }

    public String[] tiposComprobantes() {
        return this.config.tiposComprobantesValidosAfipCombo();
    }

    public String[] sucursalesValidas() {
        String[] sucNum = this.config.getUsuarioLogueado().sucursalesNumero();
        String[] sucDetalle = this.config.getUsuarioLogueado().sucursalesDetalle();
        String[] suc = new String[sucNum.length];
        for (int i = 0; i < sucNum.length; ++i) {
            suc[i] = sucNum[i] + " " + sucDetalle[i];
        }
        return suc;
    }

    public void buscarComprobantes() {
    }

    private int mostrarCodigoTipoComprobante(int tipoComprob) {
        return this.config.mostrarCodigoTipoComprobanteCombo(tipoComprob);
    }

    public void buscarComprobantes(int selectedIndexSucursal, int selectedIndexTipoComprobante, String numeroComprobante) {
        GestorAFactura gesa;
        if (this.config.getUsuarioLogueado().sucursalesEsBonoFiscales()[selectedIndexSucursal].booleanValue()) {
            gesa = new GestorAFactura(this.config.getArchivoFacturar());
            gesa.crearArchivoFacConsulta(this.config.getTokServer2(), this.config.getCuit());
        } else {
            gesa = new GestorAFactura(this.config.getArchivoFacturar());
            gesa.crearArchivoFacConsulta(this.config.getTokServer1(), this.config.getCuit());
        }
        GestorComunicacion gesco = new GestorComunicacion(this.config);
        gesco.buscarComprobate(this.config.getUsuarioLogueado().sucursalesEsBonoFiscales()[selectedIndexSucursal], this.config.getUsuarioLogueado().mostrarItemSucursal(selectedIndexSucursal).getNumero(), this.mostrarCodigoTipoComprobante(selectedIndexTipoComprobante), Integer.valueOf(numeroComprobante));
    }

    public void buscarUltimoAutorizado(int sucursal, int tipo) {
        GestorAFactura gesa;
        if (this.config.getUsuarioLogueado().sucursalesEsBonoFiscales()[sucursal].booleanValue()) {
            gesa = new GestorAFactura(this.config.getArchivoFacturar());
            gesa.crearArchivoFacConsulta(this.config.getTokServer2(), this.config.getCuit());
        } else {
            gesa = new GestorAFactura(this.config.getArchivoFacturar());
            gesa.crearArchivoFacConsulta(this.config.getTokServer1(), this.config.getCuit());
        }
        GestorComunicacion gsc = new GestorComunicacion(this.config);
        gsc.buscarULtimoComprobante(this.config.getUsuarioLogueado().sucursalesEsBonoFiscales()[sucursal], this.config.getUsuarioLogueado().mostrarItemSucursal(sucursal).getNumero(), this.mostrarCodigoTipoComprobante(tipo));
    }
}

