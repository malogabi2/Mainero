/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.GestorPantallas;

import Proyecto.GestorArchivos.GestorAConfiguracion;
import Proyecto.GestorArchivos.GestorAFactura;
import Proyecto.Intermediario.GestorComunicacion;
import Proyecto.Intermediario.GestorPedidoLlaves;
import Proyecto.mainerofacturero.pantalla.FIBuscaComprobantes;
import Proyecto.mainerofacturero.pantalla.FIConfiguracion;
import Proyecto.mainerofacturero.pantalla.FIFacturar;
import Proyecto.mainerofacturero.pantalla.FIFacturas;
import Proyecto.mainerofacturero.pantalla.FIUsuario;
import Proyecto.modelo.Configuracion;
import Proyecto.modelo.Usuario;
import javax.swing.JDesktopPane;

public class GestorPrincipal {

    JDesktopPane escritorio;
    private Configuracion configuracionPrivada;
    private boolean seModificoConfiguracion = false;

    public GestorPrincipal(JDesktopPane desto, Usuario usuario) {
        this.escritorio = desto;
        this.configuracionPrivada = new Configuracion();
        this.configuracionPrivada.setUsuarioLogueado(usuario);
        this.setConfiguracionPrivada(this.traerConfiguracion(this.configuracionPrivada));
        this.configuracionPrivada.ConectarBasesODBC();
    }

    private Configuracion traerConfiguracion(Configuracion config) {
        GestorAConfiguracion gconf = new GestorAConfiguracion();
        return gconf.traerConfiguracion(config);
    }

    public JDesktopPane llamarFacturero() {
        FIFacturas fac = new FIFacturas();
        fac.setConfiguracion(this.getConfiguracionPrivada());
        fac.setClosable(true);
        fac.setMaximizable(true);
        fac.setVisible(true);
        this.escritorio.add(fac);
        return this.escritorio;
    }

    public JDesktopPane llamarConfiguracion() {
        FIConfiguracion fi = new FIConfiguracion(this.escritorio, this.configuracionPrivada);
        fi.setClosable(true);
        fi.setVisible(true);
        this.escritorio.add(fi);
        this.seModificoConfiguracion = true;
        return this.escritorio;
    }

    public void llamarComprobacionServidorWFE() {
        GestorComunicacion gescom = new GestorComunicacion(this.getConfiguracionPrivada());
        gescom.probarConexionSevidorWFE();
    }

    public void llamarComprobacionServidorWBFE() {
        GestorComunicacion gescom = new GestorComunicacion(this.getConfiguracionPrivada());
        gescom.probarConexionSevidorWBFE();
    }

    private void armarArchivoFacturaWSFE() {
        GestorAFactura gestoa = new GestorAFactura(this.getConfiguracionPrivada().getArchivoFacturar());
        gestoa.crearArchivoFacConsulta(this.getConfiguracionPrivada().getTokServer1(), this.getConfiguracionPrivada().getCuit());
    }

    private void armarArchivoFacturaWSBFE() {
        GestorAFactura gestoa = new GestorAFactura(this.getConfiguracionPrivada().getArchivoFacturar());
        gestoa.crearArchivoFacConsulta(this.getConfiguracionPrivada().getTokServer2(), this.getConfiguracionPrivada().getCuit());
    }

    public void buscarLlaves() {
        GestorComunicacion gescom = new GestorComunicacion(this.getConfiguracionPrivada());
        gescom.buscarLlaves(this.getConfiguracionPrivada());
        this.seModificoConfiguracion = true;
    }

    public void buscarPuntosVentasValidos() {
        this.seModificoConfiguracion = GestorPedidoLlaves.actualizoSiEstaVencido(this.getConfiguracionPrivada());
        this.armarArchivoFacturaWSFE();
        GestorComunicacion gescom = new GestorComunicacion(this.getConfiguracionPrivada());
        gescom.buscarSucursalesHabilitadas(true);
    }

    public void llamarComprobantesValidos() {
        this.seModificoConfiguracion = GestorPedidoLlaves.actualizoSiEstaVencido(this.getConfiguracionPrivada());
        this.armarArchivoFacturaWSFE();
        GestorComunicacion gescom = new GestorComunicacion(this.getConfiguracionPrivada());
        gescom.buscarComprobantesValidos();
    }

    public JDesktopPane llamarBuscarComprobantes() {
        this.seModificoConfiguracion = GestorPedidoLlaves.actualizoSiEstaVencido(this.getConfiguracionPrivada());
        FIBuscaComprobantes fibu = new FIBuscaComprobantes();
        fibu.setSucursales(this.getConfiguracionPrivada());
        fibu.setClosable(true);
        fibu.setVisible(true);
        this.escritorio.add(fibu);
        return this.escritorio;
    }

    public Configuracion getConfiguracionPrivada() {
        if (this.seModificoConfiguracion) {
            this.setConfiguracionPrivada(this.traerConfiguracion(this.configuracionPrivada));
            this.seModificoConfiguracion = false;
        }
        return this.configuracionPrivada;
    }

    public void setConfiguracionPrivada(Configuracion configuracionPrivada) {
        this.configuracionPrivada = configuracionPrivada;
    }

    public void llamarBuscarUltimoComprobante() {
        this.seModificoConfiguracion = GestorPedidoLlaves.actualizoSiEstaVencido(this.getConfiguracionPrivada());
        FIBuscaComprobantes fib = new FIBuscaComprobantes();
        fib.ocultarNumero();
        fib.setSucursales(this.getConfiguracionPrivada());
        fib.setVisible(true);
        fib.setClosable(true);
        this.escritorio.add(fib);
    }

    public void llamarTiposConcepto() {
        this.seModificoConfiguracion = GestorPedidoLlaves.actualizoSiEstaVencido(this.getConfiguracionPrivada());
        GestorComunicacion gescom = new GestorComunicacion(this.getConfiguracionPrivada());
        gescom.buscarConceptosValidosWSFE();
    }

    public void llamarTiposDOC() {
        this.seModificoConfiguracion = GestorPedidoLlaves.actualizoSiEstaVencido(this.getConfiguracionPrivada());
        this.armarArchivoFacturaWSFE();
        GestorComunicacion gescom = new GestorComunicacion(this.getConfiguracionPrivada());
        gescom.buscarTiposDocValidosWSFE();
    }

    public void llamarTiposIVa() {
        this.seModificoConfiguracion = GestorPedidoLlaves.actualizoSiEstaVencido(this.getConfiguracionPrivada());
        this.armarArchivoFacturaWSFE();
        GestorComunicacion gescom = new GestorComunicacion(this.getConfiguracionPrivada());
        gescom.buscarTiposIvaValidosWSFE();
    }

    public void llamarTiposMoneda() {
        this.seModificoConfiguracion = GestorPedidoLlaves.actualizoSiEstaVencido(this.getConfiguracionPrivada());
        this.armarArchivoFacturaWSFE();
        GestorComunicacion gescom = new GestorComunicacion(this.getConfiguracionPrivada());
        gescom.buscarTiposMonedasValidosWSFE();
    }

    public void llamarTiposOpcional() {
        this.seModificoConfiguracion = GestorPedidoLlaves.actualizoSiEstaVencido(this.getConfiguracionPrivada());
        this.armarArchivoFacturaWSFE();
        GestorComunicacion gescom = new GestorComunicacion(this.getConfiguracionPrivada());
        gescom.buscarTiposOpcionalValidosWSFE();
    }

    public void llamarTiposTributos() {
        this.seModificoConfiguracion = GestorPedidoLlaves.actualizoSiEstaVencido(this.getConfiguracionPrivada());
        this.armarArchivoFacturaWSFE();
        GestorComunicacion gescom = new GestorComunicacion(this.getConfiguracionPrivada());
        gescom.buscarTiposTributosValidosWSFE();
    }

    public void buscarUltimoID() {
        this.seModificoConfiguracion = GestorPedidoLlaves.actualizoSiEstaVencido(this.getConfiguracionPrivada());
        this.armarArchivoFacturaWSBFE();
        GestorComunicacion gescom = new GestorComunicacion(this.getConfiguracionPrivada());
        gescom.buscarUltimoID();
    }

    public void buscarNomencaldores() {
        this.seModificoConfiguracion = GestorPedidoLlaves.actualizoSiEstaVencido(this.getConfiguracionPrivada());
        this.armarArchivoFacturaWSBFE();
        GestorComunicacion gescom = new GestorComunicacion(this.getConfiguracionPrivada());
        gescom.buscarNomencladorProducto(this.getConfiguracionPrivada().traerUnaSucursalBonosFiscales());
    }

    public void llamarFacturar() {
        this.seModificoConfiguracion = GestorPedidoLlaves.actualizoSiEstaVencido(this.getConfiguracionPrivada());
        FIFacturar fac = new FIFacturar(this.getConfiguracionPrivada());
        fac.setClosable(true);
        fac.setMaximizable(true);
        fac.setVisible(true);
        this.escritorio.add(fac);
    }

    public void llamarUsuarios() {
        FIUsuario fiuse = new FIUsuario();
        fiuse.setPermisosDeslSistema(this.getConfiguracionPrivada().permisosDelSistema());
        fiuse.setSucursalesDelSistema(this.getConfiguracionPrivada().sucursalDelSistema());
        fiuse.setClosable(true);
        fiuse.setMaximizable(true);
        fiuse.setVisible(true);
        this.escritorio.add(fiuse);
    }

    public boolean estaHabilitadoPermisoAdministrador() {
        return this.getConfiguracionPrivada().getUsuarioLogueado().estaPermiso("Administrador - Configuraciones");
    }

    public boolean estaHaHabilitadoPermisoFacturarFacturar() {
        return this.getConfiguracionPrivada().getUsuarioLogueado().estaPermiso("Facturar - Facturar");
    }

    public boolean estaHabilitadoPermisoFacturarVerTablaFactura() {
        return this.getConfiguracionPrivada().getUsuarioLogueado().estaPermiso("Facturar - Ver Tabla Factura");
    }

    public boolean estaHabilitadoPermisoConsultarVariasAfip() {
        return this.getConfiguracionPrivada().getUsuarioLogueado().estaPermiso("Consultar - Consultas Varias AFIP");
    }
}
