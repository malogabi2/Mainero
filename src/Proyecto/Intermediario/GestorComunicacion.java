/*
 * Decompiled with CFR 0_124.
 * 
 * Could not load the following classes:
 *  org.dom4j.DocumentException
 */
package Proyecto.Intermediario;

import Proyecto.GestorArchivos.GestorARespuesta;
import Proyecto.GestorArchivos.GestorATokenSign;
import Proyecto.GestorDB.GestorDBFE_Electronica;
import Proyecto.mainerofacturero.pantalla.DError;
import Proyecto.modelo.Configuracion;
import Proyecto.modelo.Factura;
import Proyecto.modelo.TokenSign;
import java.awt.Frame;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dom4j.DocumentException;
import todojuntowsawfe.Main;
import utiles.MensajeError;
import wfewfbe.LectorFactura.LectorRespuesta;
import wsa.coneccion.Wsaa;

public class GestorComunicacion {
    private Configuracion configur;
    private Factura facturaElegida;
    private boolean isFistal;
    private Main main = new Main();

    public GestorComunicacion(Configuracion configur) {
        this.configur = configur;
    }

    public void probarConexionSevidorWFE() {
        this.probarConexionFE();
    }

    public void actualizarLlaveSiEstanVencidas(TokenSign tok, int horas) {
        if (this.estaVencidaLlane(tok, horas)) {
            this.buscarLlaves(this.configur);
        }
    }

    private boolean estaVencidaLlane(TokenSign tok, int horas) {
        if (new Date().getTime() > tok.getMarcaTiempo() + (long)(horas * 60 * 60 * 1000)) {
            return true;
        }
        return false;
    }

    public void probarConexionSevidorWBFE() {
        this.probarConexionBonos();
    }

    private void probarConexionBonos() {
        this.main.comienzo(new String[]{"wbfe", this.configur.getArchivoConfiguracionWs(), "true", this.configur.getArchivoRespuesta(), this.configur.getArchivoError(), this.configur.getArchivoFacturar(), "BFEDummy"});
    }

    private void probarConexionFE() {
        this.main.comienzo(new String[]{"wfe", this.configur.getArchivoConfiguracionWs(), "true", this.configur.getArchivoRespuesta(), this.configur.getArchivoError(), this.configur.getArchivoFacturar(), "FEDummy"});
    }

    public void buscarComprobantesValidos() {
        this.main.comienzo(new String[]{"wfe", this.configur.getArchivoConfiguracionWs(), "true", this.configur.getArchivoRespuesta(), this.configur.getArchivoError(), this.configur.getArchivoFacturar(), "FEParamGetTiposCbte"});
    }

    public void buscarSucursalesHabilitadas(boolean bonos) {
        this.main.comienzo(new String[]{"wfe", this.configur.getArchivoConfiguracionWs(), "true", this.configur.getArchivoRespuesta(), this.configur.getArchivoError(), this.configur.getArchivoFacturar(), "FEParamGetPtosVenta"});
    }

    private TokenSign armarToken(String[] sal, String servicio) {
        TokenSign tok = new TokenSign();
        tok.setMarcaTiempo(new Date().getTime());
        tok.setSign(sal[1]);
        tok.setToken(sal[0]);
        tok.setExperacion(sal[2]);
        tok.setDetalle(servicio);
        return tok;
    }

    public void buscarComprobate(boolean esBonos, int sucursal, int tipoComprobante, int numeroComprobante) {
        if (!esBonos) {
            this.main.comienzo(new String[]{"wfe", this.configur.getArchivoConfiguracionWs(), "true", this.configur.getArchivoRespuesta(), this.configur.getArchivoError(), this.configur.getArchivoFacturar(), "FECompConsultar", String.valueOf(sucursal), String.valueOf(tipoComprobante), String.valueOf(numeroComprobante)});
        } else {
            this.main.comienzo(new String[]{"wbfe", this.configur.getArchivoConfiguracionWs(), "true", this.configur.getArchivoRespuesta(), this.configur.getArchivoError(), this.configur.getArchivoFacturar(), "BFEGetCMP", String.valueOf(sucursal), String.valueOf(tipoComprobante), String.valueOf(numeroComprobante)});
        }
    }

    private void guardarLlavesEnArchivo(TokenSign[] tokaux) {
        GestorATokenSign a = new GestorATokenSign();
        a.guardar(tokaux);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public TokenSign[] buscarLlaves(Configuracion config) {
        TokenSign[] tokaux = new TokenSign[2];
        try {
            Wsaa wsa = new Wsaa();
            tokaux[0] = this.armarToken(wsa.conectarWsa(this.configur.getArchivoConfiguracionWs(), "wsfe"), "wsfe");
            tokaux[1] = this.armarToken(wsa.conectarWsa(this.configur.getArchivoConfiguracionWs(), "wsbfe"), "wsbfe");
            this.guardarLlavesEnArchivo(tokaux);
            return tokaux;
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(GestorComunicacion.class.getName()).log(Level.SEVERE, null, ex);
            DError ed = new DError(null, false);
            ed.setMensajeUsuario("Error a Buscar Llaves 1");
            ed.setMensajeAdmin(ex.toString() + " - " + ex.getMessage());
            ed.setVisible(true);
            return tokaux;
        }
        catch (IOException ex) {
            Logger.getLogger(GestorComunicacion.class.getName()).log(Level.SEVERE, null, ex);
            DError ed = new DError(null, false);
            ed.setMensajeUsuario("Error a Buscar Llaves 1");
            ed.setMensajeAdmin(ex.toString() + " - " + ex.getMessage());
            ed.setVisible(true);
            return tokaux;
        }
        catch (DocumentException ex) {
            Logger.getLogger(GestorComunicacion.class.getName()).log(Level.SEVERE, null, (Throwable)ex);
            DError ed = new DError(null, false);
            ed.setMensajeUsuario("Error a Buscar Llaves 1");
            ed.setMensajeAdmin(ex.toString() + " - " + ex.getMessage());
            ed.setVisible(true);
            return tokaux;
        }
        catch (Exception ex) {
            Logger.getLogger(GestorComunicacion.class.getName()).log(Level.SEVERE, null, ex);
            DError ed = new DError(null, false);
            ed.setMensajeUsuario("Error a Buscar Llaves 1");
            ed.setMensajeAdmin(ex.toString() + " - " + ex.getMessage());
            ed.setVisible(true);
            return tokaux;
        }
    }

    public void buscarULtimoComprobante(boolean isBono, int numeroSucursal, int mostrarCodigoTipoComprobante) {
        if (!isBono) {
            this.main.comienzo(new String[]{"wfe", this.configur.getArchivoConfiguracionWs(), "true", this.configur.getArchivoRespuesta(), this.configur.getArchivoError(), this.configur.getArchivoFacturar(), "FECompUltimoAutorizado", String.valueOf(numeroSucursal), String.valueOf(mostrarCodigoTipoComprobante)});
        } else {
            this.main.comienzo(new String[]{"wbfe", this.configur.getArchivoConfiguracionWs(), "true", this.configur.getArchivoRespuesta(), this.configur.getArchivoError(), this.configur.getArchivoFacturar(), "BFEGetLast_CMP", String.valueOf(numeroSucursal), String.valueOf(mostrarCodigoTipoComprobante)});
        }
    }

    public void buscarConceptosValidosWSFE() {
        this.main.comienzo(new String[]{"wfe", this.configur.getArchivoConfiguracionWs(), "true", this.configur.getArchivoRespuesta(), this.configur.getArchivoError(), this.configur.getArchivoFacturar(), "FEParamGetTiposConcepto"});
    }

    public void buscarTiposIvaValidosWSFE() {
        this.main.comienzo(new String[]{"wfe", this.configur.getArchivoConfiguracionWs(), "true", this.configur.getArchivoRespuesta(), this.configur.getArchivoError(), this.configur.getArchivoFacturar(), "FEParamGetTiposIva"});
    }

    public void facturar(boolean esfiscal, Factura factElegida) {
        this.facturaElegida = factElegida;
        this.main.setConfiguracion(this.configur, factElegida);
        this.isFistal = esfiscal;
        if (this.isFistal) {
            this.main.comienzo(new String[]{"wbfe", this.configur.getArchivoConfiguracionWs(), "tue", this.configur.getArchivoRespuesta(), this.configur.getArchivoError(), this.configur.getArchivoFacturar(), "BFEAuthorize"});
        } else {
            this.main.comienzo(new String[]{"wfe", this.configur.getArchivoConfiguracionWs(), "tue", this.configur.getArchivoRespuesta(), this.configur.getArchivoError(), this.configur.getArchivoFacturar(), "FECAESolicitar"});
        }
    }

    public void buscarTiposMonedasValidosWSFE() {
        this.main.comienzo(new String[]{"wfe", this.configur.getArchivoConfiguracionWs(), "true", this.configur.getArchivoRespuesta(), this.configur.getArchivoError(), this.configur.getArchivoFacturar(), "FEParamGetTiposMonedas"});
    }

    public void buscarTiposOpcionalValidosWSFE() {
        this.main.comienzo(new String[]{"wfe", this.configur.getArchivoConfiguracionWs(), "true", this.configur.getArchivoRespuesta(), this.configur.getArchivoError(), this.configur.getArchivoFacturar(), "FEParamGetTiposOpcional"});
    }

    public void buscarTiposTributosValidosWSFE() {
        this.main.comienzo(new String[]{"wfe", this.configur.getArchivoConfiguracionWs(), "true", this.configur.getArchivoRespuesta(), this.configur.getArchivoError(), this.configur.getArchivoFacturar(), "FEParamGetTiposTributos"});
    }

    public void buscarTiposDocValidosWSFE() {
        this.main.comienzo(new String[]{"wfe", this.configur.getArchivoConfiguracionWs(), "true", this.configur.getArchivoRespuesta(), this.configur.getArchivoError(), this.configur.getArchivoFacturar(), "FEParamGetTiposDoc"});
    }

    public void buscarUltimoID() {
        this.main.comienzo(new String[]{"wbfe", this.configur.getArchivoConfiguracionWs(), "true", this.configur.getArchivoRespuesta(), this.configur.getArchivoError(), this.configur.getArchivoFacturar(), "BFEGetLast_ID"});
    }

    public void buscarNomencladorProducto(String traerUnaSucursalBonosFiscales) {
        this.main.comienzo(new String[]{"wbfe", this.configur.getArchivoConfiguracionWs(), "true", this.configur.getArchivoRespuesta(), this.configur.getArchivoError(), this.configur.getArchivoFacturar(), "BFEGetPARAM_NCM", traerUnaSucursalBonosFiscales, "1"});
    }

    public static void guardarCAEEnBaseDeDatos(Configuracion configur, LectorRespuesta lr, Factura facturaElegida, MensajeError err) {
        err.addMensajeError("Guardando en base de datos la respuesta campos: " + lr.getCamposResul() + " resultado: " + lr.getValoresResul() ); 
        configur.getGestorDBFacturaElect().guardarCae(lr.getCamposResul(), lr.getValoresResul(), 
                facturaElegida.getTipo_comprobante(), facturaElegida.getSuc_comprobante(), facturaElegida.getNum_nombrante(),
                configur.esFiscalLaSucursal(Integer.valueOf(facturaElegida.getSuc_comprobante())), err);
        
        configur.getGestorDBFacturaElect().cerrarConector();
    }
}

