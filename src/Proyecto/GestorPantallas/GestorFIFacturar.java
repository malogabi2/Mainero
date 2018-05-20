/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.GestorPantallas;

import Proyecto.GestorArchivos.GestorAConfiguracion;
import Proyecto.GestorArchivos.GestorAFactura;
import Proyecto.GestorDB.GestorDBFE_Electronica;
import Proyecto.Intermediario.GestorComunicacion;
import Proyecto.Intermediario.GestorPedidoLlaves;
import Proyecto.modelo.Configuracion;
import Proyecto.modelo.DetalleFactura;
import Proyecto.modelo.Factura;
import Proyecto.modelo.Permisos;
import Proyecto.modelo.Producto;
import Proyecto.modelo.Sucursal;
import Proyecto.modelo.TipoComprobante;
import Proyecto.modelo.TokenSign;
import Proyecto.modelo.Usuario;
import Proyecto.utilerias.Utilerias;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.apache.log4j.Priority;
import utiles.logger.LoggerBitacora;

public class GestorFIFacturar {
    Configuracion conf;
    Factura facturaElegida;

    public GestorFIFacturar(Configuracion config) {
        this.conf = config;
    }

    public ComboBoxModel traerSucursales() {
        return new DefaultComboBoxModel<String>(this.conf.getUsuarioLogueado().sucursalesMostrarCombo());
    }

    public ComboBoxModel traerTiposComprobantes() {
        ArrayList<TipoComprobante> tipcon = new ArrayList<TipoComprobante>();
        for (int i = 0; i < this.conf.cantidadItemsTipoComprobante(); ++i) {
            tipcon.add(this.conf.mostrarItemTipoComprobante(i));
        }
        return new DefaultComboBoxModel<Object>(tipcon.toArray());
    }

    private void armarArchivoFacturaWSFE() {
        GestorAFactura gestoa = new GestorAFactura(this.conf.getArchivoFacturar());
        gestoa.crearArchivoFacConsulta(this.conf.getTokServer1(), this.conf.getCuit());
    }

    private void armarArchivoFacturaWSBFE() {
        GestorAFactura gestoa = new GestorAFactura(this.conf.getArchivoFacturar());
        gestoa.crearArchivoFacConsulta(this.conf.getTokServer2(), this.conf.getCuit());
    }

    public void buscarUltimoComprobante(int selectedSucursal, int selectedTipoComprobante) {
        GestorPedidoLlaves.actualizoSiEstaVencido(this.conf);
        GestorComunicacion gesco = new GestorComunicacion(this.conf);
        Sucursal suc = this.conf.getUsuarioLogueado().mostrarItemSucursal(selectedSucursal);
        if (suc.isEsBonosFiscales()) {
            this.armarArchivoFacturaWSBFE();
        } else {
            this.armarArchivoFacturaWSFE();
        }
        gesco.buscarULtimoComprobante(suc.isEsBonosFiscales(), suc.getNumero(), this.conf.mostrarCodigoTipoComprobanteCombo(selectedTipoComprobante));
    }

    public void buscarTiposDocumentos() {
        GestorPedidoLlaves.actualizoSiEstaVencido(this.conf);
        GestorComunicacion gescom = new GestorComunicacion(this.conf);
        gescom.buscarTiposDocValidosWSFE();
    }

    public void buscarTiposIva() {
        GestorPedidoLlaves.actualizoSiEstaVencido(this.conf);
        this.armarArchivoFacturaWSFE();
        GestorComunicacion gescom = new GestorComunicacion(this.conf);
        gescom.buscarTiposIvaValidosWSFE();
    }

    public void buscarTipoMonedas() {
        GestorPedidoLlaves.actualizoSiEstaVencido(this.conf);
        this.armarArchivoFacturaWSFE();
        GestorComunicacion gescom = new GestorComunicacion(this.conf);
        gescom.buscarTiposMonedasValidosWSFE();
    }

    public boolean estaFacturado() {
        return this.facturaElegida.estaFacturado();
    }

    public void buscarComprobante(String comprobanteNum, int indexSucursal, Object indexTipoComprobante) {
        this.facturaElegida = null;
        this.facturaElegida = Utilerias.pasarObjetoAFacturas(this.conf.getGestorDBFacturaElectParaBuscar().traerDatos(new Object[]{comprobanteNum, this.conf.getUsuarioLogueado().mostrarItemSucursal(indexSucursal).getNumero(), ((TipoComprobante)indexTipoComprobante).getNumeroReal()}))[0];
    }

    public String getCodMoneda() {
        return "PES";
    }

    public String getMontoExento() {
        return String.valueOf(this.facturaElegida.getImporteExento());
    }

    public String getFechaComprobante() {
        return Utilerias.mostrarFechaStringString(this.facturaElegida.getFecha());
    }

    public String getGravadoComp() {
        return String.valueOf(this.facturaElegida.getImporteGrafado());
    }

    public String getImpuestoInterno() {
        return String.valueOf(this.facturaElegida.getImpuestoInter());
    }

    public String getIvaInscripto() {
        return String.valueOf(this.facturaElegida.getImporteIvaInscripto());
    }

    public String getIvaNoInscripto() {
        return String.valueOf(this.facturaElegida.getImporteIvaNoInscripto());
    }

    public String getNoGravado() {
        return String.valueOf(this.facturaElegida.getImporteNoGravado());
    }

    public String getpercepMunicipales() {
        return String.valueOf(this.facturaElegida.getPercep_mun());
    }

    public String getpercepIngresosBrutos() {
        return String.valueOf(this.facturaElegida.getPercep_IIBB());
    }

    public String getpercepNacionales() {
        return String.valueOf(this.facturaElegida.getPercep_nac());
    }

    public String getRazonSocial() {
        return this.facturaElegida.getClienteNombre();
    }

    public String getresponsableIva() {
        return this.facturaElegida.getClienteTipoIva();
    }

    public String getTipoCambio() {
        return "1";
    }

    public String getTipoDocumento() {
        return this.facturaElegida.getTipo_documento();
    }

    public String getTotal() {
        return String.valueOf(this.facturaElegida.getImporteTotal());
    }

    public String getDetallePercepNacionalesPorcep() {
        return String.valueOf(this.facturaElegida.mostrarItemDetalleFactura(0).getRg3337());
    }

    public String getDetallePercepIngBrutosPorcep() {
        return String.valueOf(this.facturaElegida.mostrarItemDetalleFactura(0).getIng_brutos());
    }

    public String getDetallePercepMunicipalesPercep() {
        return String.valueOf(this.facturaElegida.mostrarItemDetalleFactura(0).getMunicipalidad());
    }

    public String getDetallePercepInternos() {
        return String.valueOf(this.facturaElegida.mostrarItemDetalleFactura(0).getInterno());
    }

    public String getNumComprobante() {
        return String.valueOf(this.facturaElegida.getNum_nombrante());
    }

    public String getBocMostrar() {
        return String.valueOf(this.facturaElegida.getSuc_comprobante());
    }

    public String getTipoComproMostrar() {
        return this.conf.mostrarNumeroComproAfipDeRealObjeto(Integer.valueOf(this.facturaElegida.getTipo_comprobante())).toString();
    }
    
    private long buscarIdWSBFE() {
        try {
            String idWSBFE = GestorAConfiguracion.traerIdWSBFE();
            if(!idWSBFE.isEmpty()) {
                return Long.valueOf(idWSBFE);
            }
            else {
                try {
                    Thread.sleep(500);
                    idWSBFE = GestorAConfiguracion.traerIdWSBFE();
                    if(!idWSBFE.isEmpty()) {
                        return Long.valueOf(idWSBFE);
                    }
                    Thread.sleep(500);
                    idWSBFE = GestorAConfiguracion.traerIdWSBFE();
                    if(!idWSBFE.isEmpty()) {
                        return Long.valueOf(idWSBFE);
                    }
                } catch (InterruptedException ex) {
                    LoggerBitacora.getInstance(GestorFIFacturar.class).logueadorMainero.log("un Mensaje", Priority.ERROR,
                        "Error al buscar id de bonos fiscales", ex);
                    Logger.getLogger(GestorFIFacturar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }            
        } catch (IOException ex) {
            LoggerBitacora.getInstance(GestorFIFacturar.class).logueadorMainero.log("un Mensaje", Priority.ERROR,
                        "Error al buscar id de bonos fiscales", ex);
            Logger.getLogger(GestorFIFacturar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    private void guardarNuevoNumero(long id){
        try {
            GestorAConfiguracion.guardarIdWSBFE(id);
        } catch (IOException ex) {
            LoggerBitacora.getInstance(GestorFIFacturar.class).logueadorMainero.log("un Mensaje", Priority.ERROR,
                        "Error al guardar id de bonos fiscales", ex);
            Logger.getLogger(GestorFIFacturar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarFactura() {
        GestorPedidoLlaves.actualizoSiEstaVencido(this.conf);
        GestorAFactura gesf = new GestorAFactura(this.conf.getArchivoFacturar());
        GestorComunicacion gecom = new GestorComunicacion(this.conf);
        if (this.conf.esFiscalLaSucursal(Integer.valueOf(this.facturaElegida.getSuc_comprobante()))) {           
            long id = buscarIdWSBFE();
            this.conf.setIdWSBFE(buscarIdWSBFE() + 1L);
            gesf.crearArchivoFacFacturarWBFE(this.conf.getTokServer2(), this.conf.getCuit(), (id + 1L), this.facturaElegida);
            gecom.facturar(true, this.facturaElegida); 
            GestorAConfiguracion gcon = new GestorAConfiguracion(this.conf);
            gcon.guardar(this.conf);
            guardarNuevoNumero(id + 1L);
        } else {
            gesf.crearArchivoFacFacturarWFE(this.conf.getTokServer1(), this.conf.getCuit(), this.facturaElegida);
            gecom.facturar(false, this.facturaElegida);
        }
    }

    public String getdocumentoNumero() {
        return this.facturaElegida.getClienteNumDoc();
    }

    public String getproductoCodigo() {
        return this.facturaElegida.mostrarItemProducto(0).getCodigoProducto();
    }

    public String getproductoNomenclador() {
        return this.facturaElegida.mostrarItemProducto(0).getNomenclador();
    }

    public boolean esFiscal() {
        return this.conf.esFiscalLaSucursal(Integer.valueOf(this.facturaElegida.getSuc_comprobante()));
    }

    private boolean buscarPermisoFacturarFacturado() {
        for (int i = 0; i < this.conf.getUsuarioLogueado().cantidadItemsPermisos(); ++i) {
            if (!this.conf.getUsuarioLogueado().mostrarItemPermisos(i).getPermisoNombre().equals("Administrador") || !this.conf.getUsuarioLogueado().mostrarItemPermisos(i).getPuerta().equals("Facturar-Facturado")) continue;
            return true;
        }
        return false;
    }

    public boolean tengoPermisoParaFacturarFacturado() {
        return this.buscarPermisoFacturarFacturado();
    }

    public void buscarComprobante(int selectSucursal, int selectTipoCompro, String textNumCompro) {
        GestorAFactura gesa;
        if (this.conf.getUsuarioLogueado().mostrarItemSucursal(selectSucursal).isEsBonosFiscales()) {
            gesa = new GestorAFactura(this.conf.getArchivoFacturar());
            gesa.crearArchivoFacConsulta(this.conf.getTokServer2(), this.conf.getCuit());
        } else {
            gesa = new GestorAFactura(this.conf.getArchivoFacturar());
            gesa.crearArchivoFacConsulta(this.conf.getTokServer1(), this.conf.getCuit());
        }
        GestorComunicacion gsc = new GestorComunicacion(this.conf);
        gsc.buscarComprobate(this.conf.getUsuarioLogueado().mostrarItemSucursal(selectSucursal).isEsBonosFiscales(), this.conf.getUsuarioLogueado().mostrarItemSucursal(selectSucursal).getNumero(), this.conf.mostrarItemTipoComprobante(selectTipoCompro).getNumeroAfip(), Integer.valueOf(textNumCompro));
    }

    public boolean tengoProductos() {
        if (this.facturaElegida.getProducto().equals("null") || this.facturaElegida.getProducto().equals("0.00")) {
            return false;
        }
        return true;
    }

    public boolean tengoFactura() {
        if (this.facturaElegida != null) {
            return true;
        }
        return false;
    }

    public void tomarProductos(String codigo, String nomenclador) {
        ArrayList<Producto> detpro = new ArrayList<Producto>();
        Producto pro = new Producto();
        pro.setCodigoProducto(codigo);
        pro.setNomenclador(nomenclador);
        detpro.add(pro);
        this.facturaElegida.agregarItemsProducto(Utilerias.pasarObjetoAProducto(detpro.toArray()));
    }

    public boolean tengoMovimientosFactura() {
        if (this.facturaElegida.cantidadItemsDetalleFactura() > 0) {
            return true;
        }
        return false;
    }
   
}