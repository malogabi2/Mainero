/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.GestorPantallas;

import Proyecto.GestorArchivos.GestorAConfiguracion;
import Proyecto.GestorArchivos.GestorAFactura;
import Proyecto.Intermediario.GestorComunicacion;
import Proyecto.Intermediario.GestorPedidoLlaves;
import Proyecto.mainerofacturero.pantalla.FITokens;
import Proyecto.modelo.Configuracion;
import Proyecto.modelo.Sucursal;
import Proyecto.modelo.TipoComprobante;
import Proyecto.modelo.TokenSign;
import java.awt.Component;
import java.io.File;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class GestorFIConfiguracion {
    JDesktopPane escritorioPrincipal;
    GestorAConfiguracion gesa;
    Configuracion config;

    public GestorFIConfiguracion(JDesktopPane escr, Configuracion config) {
        this.buscarConfiguracion(config);
        this.escritorioPrincipal = escr;
        this.config = config;
    }

    public String mostrarArchivoConfig() {
        return this.config.getArchivoConfiguracionWs();
    }

    public DefaultTableModel buscarItemsSucursal(TableModel dfmol) {
        DefaultTableModel dfm = (DefaultTableModel)dfmol;
        for (int i = 0; i < this.config.cantidadItemsSucursal(); ++i) {
            dfm.addRow(new Object[]{this.config.mostrarItemSucursal(i).getNumero(), this.config.mostrarItemSucursal(i).getDescripcion(), this.config.mostrarItemSucursal(i).isEsBonosFiscales()});
        }
        return dfm;
    }

    public String traerArchivoConfiguracion() {
        JFileChooser fch_buscarArchivo = new JFileChooser();
        if (fch_buscarArchivo.showOpenDialog(null) == 0) {
            this.config.setArchivoConfiguracionWs(fch_buscarArchivo.getSelectedFile().getPath());
        } else {
            this.config.setArchivoConfiguracionWs("");
        }
        return this.config.getArchivoConfiguracionWs();
    }

    private void cargarConfiguracionSucursal(String numSuc, String nombreSuc, boolean esFiscal) {
        Sucursal suc = new Sucursal();
        suc.setDescripcion(nombreSuc);
        suc.setNumero(Integer.valueOf(numSuc));
        suc.setEsBonosFiscales(esFiscal);
        this.config.agregarItemSucursal(suc);
    }

    private void cargarConfiguracionTipoComprobante(int numComReal, int numAfip, String comprobTipo) {
        TipoComprobante tipo = new TipoComprobante();
        tipo.setNombre(comprobTipo);
        tipo.setNumeroAfip(numAfip);
        tipo.setNumeroReal(numComReal);
        this.config.agregarItemTipoComprobante(tipo);
    }

    public TableModel agregarSucursal(String numSuc, String nombreSuc, boolean esFiscal, TableModel model) {
        DefaultTableModel tblm = (DefaultTableModel)model;
        tblm.addRow(new Object[]{numSuc, nombreSuc, esFiscal});
        this.cargarConfiguracionSucursal(numSuc, nombreSuc, esFiscal);
        return model;
    }

    public boolean estaSucursal(int sucursal) {
        Sucursal suc = new Sucursal();
        suc.setNumero(sucursal);
        return this.config.existeItemSucursal(suc);
    }

    public boolean estaTipoDocumento(int tipoComproReal, int tipoComprovAfip) {
        TipoComprobante tipo = new TipoComprobante();
        tipo.setNumeroReal(tipoComproReal);
        tipo.setNumeroAfip(this.config.mostrarCodigoTipoComprobanteCombo(tipoComprovAfip));
        return this.config.existeItemTipoComprobante(tipo);
    }

    public TableModel borrarSucursal(int selectedRow, TableModel model) {
        DefaultTableModel tblm = (DefaultTableModel)model;
        tblm.removeRow(selectedRow);
        this.config.borrarItemSucursal(selectedRow);
        return model;
    }

    public void guardarConfiguracion(String nombreODBC, String usuarioODBC, String claveODBC, String cuit, boolean isAutomaticoToken, Integer cantidadHoras, Integer numeroId, Integer numMaxFila, Integer tiempoEspera) {
        this.config.setNombreODBC(nombreODBC);
        this.config.setUsuarioODBC(usuarioODBC);
        this.config.setClaveODBC(claveODBC);
        this.config.setCuit(cuit);
        this.config.setEsAutoPedidoLlaves(isAutomaticoToken);
        this.config.setCantidadHorasPedidoLlaves(cantidadHoras);
        this.config.setIdWSBFE(numeroId.intValue());
        this.config.setMaximaFila(numMaxFila);
        this.config.setTiempoEspera(tiempoEspera);
        this.gesa = new GestorAConfiguracion(this.config);
        this.gesa.guardar(this.config);
    }

    private void buscarConfiguracion(Configuracion config) {
        this.gesa = new GestorAConfiguracion();
        this.config = this.gesa.traerConfiguracion(config);
    }

    public String mostrarNombreODBC() {
        return this.config.getNombreODBC();
    }

    public String mostrarCuit() {
        return this.config.getCuit();
    }

    public String mostrarUsuario() {
        return this.config.getUsuarioODBC();
    }

    public int mostrarCantFilaFact() {
        return this.config.getMaximaFila();
    }

    public int mostrarTiempoEspera() {
        return this.config.getTiempoEspera();
    }

    public String mostrarClave() {
        return this.config.getClaveODBC();
    }

    public boolean mostrarSiEsAutoPedidoLlave() {
        return this.config.isEsAutoPedidoLlaves();
    }

    public int mostrarCantidadHorasPedidoLlanve() {
        return this.config.getCantidadHorasPedidoLlaves();
    }

    public void consultarAfipSucursales(boolean isBonos) {
        GestorPedidoLlaves.actualizoSiEstaVencido(this.config);
        GestorAFactura gesa = new GestorAFactura(this.config.getArchivoFacturar());
        gesa.crearArchivoFacConsulta(this.config.getTokServer1(), this.config.getCuit());
        GestorComunicacion gec = new GestorComunicacion(this.config);
        gec.buscarSucursalesHabilitadas(isBonos);
    }

    public void mostrarTokens() {
        FITokens fitok = new FITokens();
        fitok.setConfiguracion(this.config);
        fitok.setClosable(true);
        fitok.setVisible(true);
        this.escritorioPrincipal.add(fitok);
    }

    public void buscarTiposComprobantesEnAfip() {
        GestorPedidoLlaves.actualizoSiEstaVencido(this.config);
        GestorAFactura gesa = new GestorAFactura(this.config.getArchivoFacturar());
        gesa.crearArchivoFacConsulta(this.config.getTokServer1(), this.config.getCuit());
        GestorComunicacion gec = new GestorComunicacion(this.config);
        gec.buscarComprobantesValidos();
    }

    public String[] mostrarTiposComprobantesAFIPCombo() {
        return this.config.tiposComprobantesValidosAfipCombo();
    }

    public TableModel agregarTipoComprobantes(String numeroComprabanteReal, int selectedItem, TableModel model) {
        DefaultTableModel tblm = (DefaultTableModel)model;
        tblm.addRow(new Object[]{this.config.mostrarTipoComprobante(selectedItem), this.config.mostrarCodigoTipoComprobanteCombo(selectedItem), numeroComprabanteReal});
        this.cargarConfiguracionTipoComprobante(Integer.valueOf(numeroComprabanteReal), this.config.mostrarCodigoTipoComprobanteCombo(selectedItem), this.config.mostrarTipoComprobante(selectedItem));
        return model;
    }

    public TableModel buscarItmsTipoComprobante(TableModel model) {
        DefaultTableModel dfm = (DefaultTableModel)model;
        for (int i = 0; i < this.config.cantidadItemsTipoComprobante(); ++i) {
            dfm.addRow(new Object[]{this.config.mostrarItemTipoComprobante(i).getNombre(), this.config.mostrarItemTipoComprobante(i).getNumeroAfip(), this.config.mostrarItemTipoComprobante(i).getNumeroReal()});
        }
        return dfm;
    }

    public TableModel borrarTipoComprobante(int selectedRow, TableModel model) {
        DefaultTableModel tblm = (DefaultTableModel)model;
        tblm.removeRow(selectedRow);
        this.config.borrarItemTipoComprobante(selectedRow);
        return model;
    }

    public void buscarIDWSFEAfip() {
        GestorPedidoLlaves.actualizoSiEstaVencido(this.config);
        GestorAFactura gesa = new GestorAFactura(this.config.getArchivoFacturar());
        gesa.crearArchivoFacConsulta(this.config.getTokServer2(), this.config.getCuit());
        GestorComunicacion gec = new GestorComunicacion(this.config);
        gec.buscarUltimoID();
    }

    public String mostrarIDWSBFE() {
        return String.valueOf(this.config.getIdWSBFE());
    }
}

