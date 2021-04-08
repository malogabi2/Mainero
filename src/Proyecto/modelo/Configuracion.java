/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.modelo;

import Proyecto.GestorDB.GestorDBFE_Electronica;
import Proyecto.mainerofacturero.pantalla.DError;
import Proyecto.utilerias.Utilerias;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.log4j.Priority;
import utiles.logger.LoggerBitacora;

public class Configuracion {
    private String archivoConfiguracionWs;
    private String archivoConfigEste;
    private String archivoFacturar;
    private String archivoError;
    private String archivoRespuesta;
    private ArrayList<Sucursal> sucursales = new ArrayList();
    private ArrayList<TipoComprobante> tiposComprobs = new ArrayList();
    private String nombreODBC;
    private String usuarioODBC;
    private String claveODBC;
    private TokenSign tokServer1;
    private TokenSign tokServer2;
    private String cuit;
    private Usuario usuarioLogueado;
    private boolean esAutoPedidoLlaves = false;
    private int cantidadHorasPedidoLlaves;
    private long idWSBFE;
    private int maximaFila;
    private int tiempoEspera;
    private GestorDBFE_Electronica gestorDBFacturaElect;
    private Permisos[] permisos = new Permisos[]{new Permisos("Facturar", "Ver Tabla Factura"), new Permisos("Facturar", "Facturar"), new Permisos("Consultar", "Consultas Varias AFIP"), new Permisos("Administrador", "Configuraciones"), new Permisos("Administrador", "Facturar-Facturado")};

    public String[] tiposComprobantesValidosAfipCombo() {
        return new String[]{"1-Factura A", "2-Notas Debitos A", "3-Credito A", "6-Factura B", "7-Debito B", "8-Credito B"};
    }

    public Permisos[] permisosDelSistema() {
        return this.permisos;
    }

    public Sucursal[] sucursalDelSistema() {
        return Utilerias.pasarObjetoASucursal(this.sucursales.toArray());
    }

    public int mostrarCodigoTipoComprobanteCombo(int tipoComprob) {
        if (tipoComprob == 0) {
            return 1;
        }
        if (tipoComprob == 1) {
            return 2;
        }
        if (tipoComprob == 2) {
            return 3;
        }
        if (tipoComprob == 3) {
            return 6;
        }
        if (tipoComprob == 4) {
            return 7;
        }
        return 8;
    }

    public String mostrarTipoComprobante(int tipoComprob) {
        if (tipoComprob == 0) {
            return "Factura A";
        }
        if (tipoComprob == 1) {
            return "Notas Debitos A";
        }
        if (tipoComprob == 2) {
            return "Notas Credito A";
        }
        if (tipoComprob == 3) {
            return "Factura B";
        }
        if (tipoComprob == 4) {
            return "Notas Debito B";
        }
        return "Notas Credito B";
    }

    public void agregarItemSucursal(Sucursal item) {
        if (!this.existeItemSucursal(item)) {
            this.sucursales.add(item);
        }
    }

    public Sucursal mostrarItemSucursal(int pos) {
        return this.sucursales.get(pos);
    }

    public boolean esFiscalLaSucursal(int numeroSucursal) {
        for (int i = 0; i < this.cantidadItemsSucursal(); ++i) {
            if (this.mostrarItemSucursal(i).getNumero() != numeroSucursal || !this.mostrarItemSucursal(i).isEsBonosFiscales()) continue;
            return true;
        }
        return false;
    }

    public void borrarItemSucursal(int pos) {
        this.sucursales.remove(pos);
    }

    public boolean existeItemSucursal(Sucursal item) {
        return this.sucursales.contains(item);
    }

    public void agregarItemsSucursal(Sucursal[] itms) {
        this.sucursales.addAll(Arrays.asList(itms));
    }

    public int cantidadItemsSucursal() {
        return this.sucursales.size();
    }

    public void agregarItemTipoComprobante(TipoComprobante item) {
        if (!this.existeItemTipoComprobante(item)) {
            this.tiposComprobs.add(item);
        }
    }

    public TipoComprobante mostrarItemTipoComprobante(int pos) {
        return this.tiposComprobs.get(pos);
    }

    public int mostrarNumeroComproAfipDeReal(int numConproReal) {
        for (int i = 0; i < this.cantidadItemsTipoComprobante(); ++i) {
            if (this.mostrarItemTipoComprobante(i).getNumeroReal() != numConproReal) continue;
            return this.mostrarItemTipoComprobante(i).getNumeroAfip();
        }
        return -1;
    }

    public TipoComprobante mostrarNumeroComproAfipDeRealObjeto(int numConproReal) {
        for (int i = 0; i < this.cantidadItemsTipoComprobante(); ++i) {
            if (this.mostrarItemTipoComprobante(i).getNumeroReal() != numConproReal) continue;
            return this.mostrarItemTipoComprobante(i);
        }
        return null;
    }

    public void borrarItemTipoComprobante(int pos) {
        this.tiposComprobs.remove(pos);
    }

    public boolean existeItemTipoComprobante(TipoComprobante item) {
        return this.tiposComprobs.contains(item);
    }

    public void agregarItemsTipoComprobante(TipoComprobante[] itms) {
        this.tiposComprobs.addAll(Arrays.asList(itms));
    }

    public int cantidadItemsTipoComprobante() {
        return this.tiposComprobs.size();
    }

    public String getArchivoConfiguracionWs() {
        return this.archivoConfiguracionWs;
    }

    public void setArchivoConfiguracionWs(String archivoConfiguracion) {
        this.archivoConfiguracionWs = archivoConfiguracion;
    }

    public String getNombreODBC() {
        return this.nombreODBC;
    }

    public String getUsuarioODBC() {
        return this.usuarioODBC;
    }

    public String getClaveODBC() {
        return this.claveODBC;
    }

    public void ConectarBasesODBC() {
        try {
            this.gestorDBFacturaElect = new GestorDBFE_Electronica(this);
        }
        catch (ClassNotFoundException ex) {
            LoggerBitacora.getInstance(Configuracion.class).logueadorMainero.log("un Mensaje", Priority.FATAL,
                        "Eror al conectar con base de Datos", ex);
            DError ed = new DError(null, false);
            ed.setMensajeUsuario("Error a Buscar Comprobante ClassNotFoundException");
            ed.setMensajeAdmin(ex.toString() + " - " + ex.getMessage());
            ed.setVisible(true);
        }
        catch (SQLException ex) {
            LoggerBitacora.getInstance(Configuracion.class).logueadorMainero.log("un Mensaje", Priority.FATAL,
                        "Eror al conectar con base de Datos", ex);
            DError ed = new DError(null, false);
            ed.setMensajeUsuario("Error a Buscar Comprobante 2SQLException");
            ed.setMensajeAdmin(ex.toString() + " - " + ex.getMessage());
            ed.setVisible(true);
        }
    }

    public String getArchivoFacturar() {
        return this.archivoFacturar;
    }

    public void setArchivoFacturar(String archivoFacturar) {
        this.archivoFacturar = archivoFacturar;
    }

    public String getArchivoError() {
        return this.archivoError;
    }

    public void setArchivoError(String archivoError) {
        this.archivoError = archivoError;
    }

    public String getArchivoRespuesta() {
        return this.archivoRespuesta;
    }

    public void setArchivoRespuesta(String archivoRespuesta) {
        this.archivoRespuesta = archivoRespuesta;
    }

    public TokenSign getTokServer1() {
        return this.tokServer1;
    }

    public void setTokServer1(TokenSign tokServer1) {
        this.tokServer1 = tokServer1;
    }

    public TokenSign getTokServer2() {
        return this.tokServer2;
    }

    public void setTokServer2(TokenSign tokServer2) {
        this.tokServer2 = tokServer2;
    }

    public void setLlaves(TokenSign[] llaves) {
        this.tokServer1 = llaves[0];
        this.tokServer2 = llaves[1];
    }

    public String getCuit() {
        return this.cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String traerUnaSucursalBonosFiscales() {
        String[] sucx = this.sucursalesNumero();
        Boolean[] suct = this.sucursalesEsBonoFiscales();
        for (int i = 0; i < sucx.length; ++i) {
            if (!suct[i].booleanValue()) continue;
            return sucx[i];
        }
        return "";
    }

    public String[] sucursalesMostrarCombo() {
        String[] sucNum = new String[this.cantidadItemsSucursal()];
        for (int i = 0; i < this.cantidadItemsSucursal(); ++i) {
            sucNum[i] = this.mostrarItemSucursal(i).toString();
        }
        return sucNum;
    }

    public String[] sucursalesNumero() {
        String[] sucNum = new String[this.cantidadItemsSucursal()];
        for (int i = 0; i < this.cantidadItemsSucursal(); ++i) {
            sucNum[i] = String.valueOf(this.mostrarItemSucursal(i).getNumero());
        }
        return sucNum;
    }

    public String[] sucursalesDetalle() {
        String[] sucNum = new String[this.cantidadItemsSucursal()];
        for (int i = 0; i < this.cantidadItemsSucursal(); ++i) {
            sucNum[i] = String.valueOf(this.mostrarItemSucursal(i).getDescripcion());
        }
        return sucNum;
    }

    public Boolean[] sucursalesEsBonoFiscales() {
        Boolean[] sucNum = new Boolean[this.cantidadItemsSucursal()];
        for (int i = 0; i < this.cantidadItemsSucursal(); ++i) {
            sucNum[i] = this.mostrarItemSucursal(i).isEsBonosFiscales();
        }
        return sucNum;
    }

    public boolean isEsAutoPedidoLlaves() {
        return this.esAutoPedidoLlaves;
    }

    public void setEsAutoPedidoLlaves(boolean esAutoPedidoLlaves) {
        this.esAutoPedidoLlaves = esAutoPedidoLlaves;
    }

    public int getCantidadHorasPedidoLlaves() {
        return this.cantidadHorasPedidoLlaves;
    }

    public void setCantidadHorasPedidoLlaves(int cantidadHorasPedidoLlaves) {
        this.cantidadHorasPedidoLlaves = cantidadHorasPedidoLlaves;
    }

    public long getIdWSBFE() {
        return this.idWSBFE;
    }

    public void setIdWSBFE(long idWSBFE) {
        this.idWSBFE = idWSBFE;
    }

    public int getMaximaFila() {
        return this.maximaFila;
    }

    public void setMaximaFila(int maximaFila) {
        this.maximaFila = maximaFila;
    }

    public int getTiempoEspera() {
        return this.tiempoEspera;
    }

    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    public Usuario getUsuarioLogueado() {
        return this.usuarioLogueado;
    }

    public void setUsuarioLogueado(Usuario usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
        this.archivoFacturar = "fact_" + this.usuarioLogueado.getUsuarioNombre() + ".txt";
        this.archivoError = "er_" + this.usuarioLogueado.getUsuarioNombre() + ".txt";
        this.archivoRespuesta = "res_" + this.usuarioLogueado.getUsuarioNombre() + ".txt";
        this.archivoConfigEste = "config_" + this.usuarioLogueado.getUsuarioNombre() + ".txt";
    }

    public String getArchivoConfigEste() {
        return this.archivoConfigEste;
    }

    public void setNombreODBC(String nomODBC) {
        this.nombreODBC = nomODBC;
    }

    public void setUsuarioODBC(String usODBC) {
        this.usuarioODBC = usODBC;
    }

    public void setClaveODBC(String pswODBC) {
        this.claveODBC = pswODBC;
    }

    public GestorDBFE_Electronica getGestorDBFacturaElectParaGuardar() {
        this.gestorDBFacturaElect.ponerEn0Intentos();
        return this.gestorDBFacturaElect;
    }
    
     public GestorDBFE_Electronica getGestorDBFacturaElectParaBuscar() {
        return this.gestorDBFacturaElect;
    }
     
    public static Configuracion getMockConfiguration() {
        Configuracion conf = new Configuracion();
        Usuario user = new Usuario("mockUser", "mockPassw", 0);
        conf.setUsuarioLogueado(user);
        return conf;
    }
            
}

