/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class Factura {
    private String tipo_comprobante;
    private String suc_comprobante;
    private String num_nombrante;
    private String fecha;
    private String tipo_documento;
    private String clienteNumDoc;
    private String clienteTipoIva;
    private String clienteNombre;
    private String tipoCliente;
    private String cae = "0";
    private String fechaCae = "";
    private String importeGrafado;
    private String importeNoGravado = "0";
    private String importeIvaInscripto;
    private String importeIvaNoInscripto;
    private String importeExento;
    private String percep_nac;
    private String percep_IIBB;
    private String percep_mun;
    private String impuestoInter;
    private int codigoMoneda;
    private int tipoCambio;
    private String producto;
    private String importeTotal;
    private ArrayList<DetalleFactura> facDeta = new ArrayList();
    private ArrayList<Producto> producs = new ArrayList();
    private ArrayList<ComprobanteAsociado> comprobanteAsociados = new ArrayList();
    private ArrayList<PeriodoAsoc> periodoAsoc = new ArrayList();

    public Object[] filas() {
        boolean bol = false;
        return new Object[]{bol, this.estaFacturado(), this.tipo_comprobante, this.suc_comprobante, this.num_nombrante, this.tipo_documento, this.clienteNumDoc, this.clienteNombre, this.clienteTipoIva, this.importeGrafado, this.importeNoGravado, this.importeIvaInscripto, this.importeIvaNoInscripto, this.importeExento, this.percep_nac, this.percep_IIBB, this.percep_mun, this.impuestoInter, this.codigoMoneda, this.tipoCambio, this.importeTotal, this.cae};
    }

    public void agregarItemDetalleFactura(DetalleFactura item) {
        this.facDeta.add(item);
    }
    
    public void agregarComprobanteAsoc(ComprobanteAsociado item) {
        this.comprobanteAsociados.add(item);
    }
    
    public void agregarPeriodoAsoc(PeriodoAsoc item) {
        this.periodoAsoc.add(item);
    }

    public DetalleFactura mostrarItemDetalleFactura(int pos) {
        return this.facDeta.get(pos);
    }

    public void borrarItemDetalleFactura(int pos) {
        this.facDeta.remove(pos);
    }

    public boolean existeItemDetalleFactura(DetalleFactura item) {
        return this.facDeta.contains(item);
    }

    public void agregarItemsDetalleFactura(DetalleFactura[] itms) {
        this.facDeta.addAll(Arrays.asList(itms));
    }

    public int cantidadItemsDetalleFactura() {
        return this.facDeta.size();
    }

    public void agregarItemProducto(Producto item) {
        this.producs.add(item);
    }

    public Producto mostrarItemProducto(int pos) {
        return this.producs.get(pos);
    }

    public void borrarItemProducto(int pos) {
        this.producs.remove(pos);
    }

    public boolean existeItemProducto(Producto item) {
        return this.producs.contains(item);
    }

    public void agregarItemsProducto(Producto[] itms) {
        this.producs.addAll(Arrays.asList(itms));
    }

    public int cantidadItemsProducto() {
        return this.producs.size();
    }

    public boolean filtrarPorTipoComprobante(String tipo) {
        return this.tipo_comprobante.equals(tipo);
    }

    public boolean filtrarPorSucursal(String sucursal) {
        return this.suc_comprobante.equals(sucursal);
    }

    public String getFecha() {
        return this.fecha;
    }

    public boolean estaFacturado() {
        if (this.cae.length() > 5) {
            return true;
        }
        return false;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo_documento() {
        return this.tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getClienteTipoIva() {
        return this.clienteTipoIva;
    }

    public void setClienteTipoIva(String clienteTipoIva) {
        this.clienteTipoIva = clienteTipoIva;
    }

    public String getClienteNombre() {
        return this.clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public String getImporteGrafado() {
        return this.importeGrafado;
    }

    public void setImporteGrafado(String importeGrafado) {
        this.importeGrafado = importeGrafado;
    }

    public String getImporteNoGravado() {
        return this.importeNoGravado;
    }

    public void setImporteNoGravado(String importeNoGravado) {
        this.importeNoGravado = importeNoGravado;
    }

    public String getImporteIvaInscripto() {
        return this.importeIvaInscripto;
    }

    public void setImporteIvaInscripto(String importeIvaInscripto) {
        this.importeIvaInscripto = importeIvaInscripto;
    }

    public String getImporteIvaNoInscripto() {
        return this.importeIvaNoInscripto;
    }

    public void setImporteIvaNoInscripto(String importeIvaNoInscripto) {
        this.importeIvaNoInscripto = importeIvaNoInscripto;
    }

    public String getImporteExento() {
        return this.importeExento;
    }

    public void setImporteExento(String importeExento) {
        this.importeExento = importeExento;
    }

    public Float totalTributos() {
        return Float.valueOf(Float.valueOf(this.getImpuestoInter()).floatValue() + Float.valueOf(this.getPercep_IIBB()).floatValue() + Float.valueOf(this.getPercep_mun()).floatValue() + Float.valueOf(this.getPercep_nac()).floatValue());
    }

    public Float totalIva() {
        return Float.valueOf(Float.valueOf(this.getImporteIvaInscripto()).floatValue() + Float.valueOf(this.getImporteIvaNoInscripto()).floatValue());
    }

    public String getPercep_nac() {
        return this.percep_nac;
    }

    public void setPercep_nac(String percep_nac) {
        this.percep_nac = percep_nac;
    }

    public String getPercep_IIBB() {
        return this.percep_IIBB;
    }

    public void setPercep_IIBB(String percep_IIBB) {
        this.percep_IIBB = percep_IIBB;
    }

    public String getPercep_mun() {
        return this.percep_mun;
    }

    public void setPercep_mun(String percep_mun) {
        this.percep_mun = percep_mun;
    }

    public String getImpuestoInter() {
        return this.impuestoInter;
    }

    public void setImpuestoInter(String impuestoInter) {
        this.impuestoInter = impuestoInter;
    }

    public int getCodigoMoneda() {
        return this.codigoMoneda;
    }

    public void setCodigoMoneda(int codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
    }

    public int getTipoCambio() {
        return this.tipoCambio;
    }

    public void setTipoCambio(int tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public String getImporteTotal() {
        return this.importeTotal;
    }

    public void setImporteTotal(String importeTotal) {
        this.importeTotal = importeTotal;
    }

    public String getTipo_comprobante() {
        return this.tipo_comprobante;
    }

    public void setTipo_comprobante(String tipo_comprobante) {
        this.tipo_comprobante = tipo_comprobante;
    }

    public String getSuc_comprobante() {
        return this.suc_comprobante;
    }

    public void setSuc_comprobante(String suc_comprobante) {
        this.suc_comprobante = suc_comprobante;
    }

    public String getNum_nombrante() {
        return this.num_nombrante;
    }

    public void setNum_nombrante(String num_nombrante) {
        this.num_nombrante = num_nombrante;
    }

    public String getClienteNumDoc() {
        return this.clienteNumDoc;
    }

    public void setClienteNumDoc(String clienteNumDoc) {
        this.clienteNumDoc = clienteNumDoc;
    }

    public String getTipoCliente() {
        return this.tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getCae() {
        return this.cae;
    }

    public void setCae(String cae) {
        this.cae = cae;
    }

    public String getFechaCae() {
        return this.fechaCae;
    }

    public void setFechaCae(String fechaCae) {
        this.fechaCae = fechaCae;
    }

    public String getProducto() {
        return this.producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * @return the comprobanteAsociados
     */
    public ArrayList<ComprobanteAsociado> getComprobanteAsociados() {
        return comprobanteAsociados;
    }

    /**
     * @param comprobanteAsociados the comprobanteAsociados to set
     */
    public void setComprobanteAsociados(ArrayList<ComprobanteAsociado> comprobanteAsociados) {
        this.comprobanteAsociados = comprobanteAsociados;
    }

    /**
     * @return the periodoAsoc
     */
    public ArrayList<PeriodoAsoc> getPeriodoAsoc() {
        return periodoAsoc;
    }

    /**
     * @param periodoAsoc the periodoAsoc to set
     */
    public void setPeriodoAsoc(ArrayList<PeriodoAsoc> periodoAsoc) {
        this.periodoAsoc = periodoAsoc;
    }
}

