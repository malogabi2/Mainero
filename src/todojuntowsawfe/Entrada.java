/*
 * Decompiled with CFR 0_124.
 */
package todojuntowsawfe;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import wfewfbe.metodo.bfe.BFEAuthorize;
import wfewfbe.metodo.bfe.BFEDummy;
import wfewfbe.metodo.bfe.BFEGetCMP;
import wfewfbe.metodo.bfe.BFEGetLast_CMP;
import wfewfbe.metodo.bfe.BFEGetLast_ID;
import wfewfbe.metodo.bfe.BFEGetPARAM_MON;
import wfewfbe.metodo.bfe.BFEGetPARAM_NCM;
import wfewfbe.metodo.bfe.BFEGetPARAM_Tipo_Cbte;
import wfewfbe.metodo.bfe.BFEGetPARAM_Tipo_IVA;
import wfewfbe.metodo.bfe.BFEGetPARAM_Tipo_doc;
import wfewfbe.metodo.bfe.BFEGetPARAM_UMed;
import wfewfbe.metodo.bfe.BFEGetPARAM_Zonas;
import wfewfbe.metodo.wfev1.FECAESolicitar;
import wfewfbe.metodo.wfev1.FEComConsultar;
import wfewfbe.metodo.wfev1.FECompUltimoAutorizado;
import wfewfbe.metodo.wfev1.FEDummy;
import wfewfbe.metodo.wfev1.FEParamGetPtosVenta;
import wfewfbe.metodo.wfev1.FEParamGetTiposCbte;
import wfewfbe.metodo.wfev1.FEParamGetTiposDoc;
import wfewfbe.metodo.wfev1.FEParamGetTiposIva;
import wfewfbe.metodo.wfev1.FEParamGetTiposMonedas;
import wfewfbe.metodo.wfev1.FEParamGetTiposTributos;
import wfewfbe.metodo.wfev1.Mensajes;

public class Entrada {
    private String nombreSer;
    private String archivoConf;
    private String esPantalla;
    private String cuitEmpresa;
    private String archivoRep;
    private String archivoError;
    private String puntoVta;
    private String tipoComprobante;
    private String archivoFactura;
    private Mensajes mensaje;
    private String nombreServerWSFE;
    private String nombreServerWSBE;
    private String[] parametrosParaFacturar;
    private String nroComprobate = "0";

    public String getNombreServicio() {
        return this.nombreSer;
    }

    public void setNombreServicio(String nombreSer) {
        this.nombreSer = nombreSer;
    }

    public String getArchivoConfiguracion() {
        return this.archivoConf;
    }

    public void setArchivoConfiguracion(String archivoConf) {
        this.archivoConf = archivoConf;
    }

    public String getEsPantalla() {
        return this.esPantalla;
    }

    public void setEsPantalla(String esPantalla) {
        this.esPantalla = esPantalla;
    }

    public String getCuitEmpresa() {
        return this.cuitEmpresa;
    }

    public void setCuitEmpresa(String cuitEmpresa) {
        this.cuitEmpresa = cuitEmpresa;
    }

    public String getArchivoRespuesta() {
        return this.archivoRep;
    }

    public void setArchivoRespuesta(String archivoRep) {
        this.archivoRep = archivoRep;
    }

    public String getArchivoError() {
        return this.archivoError;
    }

    public void setArchivoError(String archivoError) {
        this.archivoError = archivoError;
    }

    public String getPuntoVta() {
        return this.puntoVta;
    }

    public void setPuntoVta(String puntoVta) {
        this.puntoVta = puntoVta;
    }

    public String getTipoComprobante() {
        return this.tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public void setearParametros(String[] parametros) throws Exception {
        this.setNombreServicio(parametros[0]);
        this.setArchivoConfiguracion(parametros[1]);
        this.setEsPantalla(parametros[2]);
        this.setArchivoRespuesta(parametros[3]);
        this.setArchivoError(parametros[4]);
        this.setNombreServerFE(this.buscarNombreServerFE(this.getArchivoConfiguracion()));
        this.setNombreServerBE(this.buscarNombreServerBE(this.getArchivoConfiguracion()));
        if (parametros.length > 5 && !this.getNombreServicio().equals("wsa")) {
            if (parametros[5] != null) {
                this.setArchivoFactura(parametros[5]);
            }
            if (parametros[6] != null) {
                this.setMensaje(this.tipoMensaje(parametros[6]));
            }
            if (parametros.length > 7) {
                if (parametros[7] != null) {
                    this.setPuntoVta(parametros[7]);
                }
                if (parametros[8] != null) {
                    this.setTipoComprobante(parametros[8]);
                }
                if (parametros.length > 9 && parametros[9] != null) {
                    this.setNroComprobate(parametros[9]);
                }
            }
        }
    }

    private String buscarNombreServerFE(String archivoConfig) throws IOException {
        Properties config = new Properties();
        config.load(new FileInputStream(archivoConfig));
        return config.getProperty("endpointWFese", "error");
    }

    private String buscarNombreServerBE(String archivoConfig) throws IOException {
        Properties config = new Properties();
        config.load(new FileInputStream(archivoConfig));
        return config.getProperty("endpointWBese", "error");
    }

    private String[] expandir(String[] parametros) {
        String[] aux = new String[6];
        System.arraycopy(parametros, 0, aux, 0, parametros.length);
        aux[3] = this.puntoVta;
        aux[4] = this.tipoComprobante;
        aux[5] = this.getNroComprobate();
        return aux;
    }

    private Mensajes tipoMensaje(String mensaje) {
        Mensajes men = null;
        if (mensaje.equals("FEDummy")) {
            men = new FEDummy();
        }
        if (mensaje.equals("FEParamGetPtosVenta")) {
            men = new FEParamGetPtosVenta();
        }
        if (mensaje.equals("FEParamGetTiposCbte")) {
            men = new FEParamGetTiposCbte();
        }
        if (mensaje.equals("FEParamGetTiposMonedas")) {
            men = new FEParamGetTiposMonedas();
        }
        if (mensaje.equals("FEParamGetTiposCbte")) {
            men = new FEParamGetTiposCbte();
        }
        if (mensaje.equals("FEParamGetTiposDoc")) {
            men = new FEParamGetTiposDoc();
        }
        if (mensaje.equals("FEParamGetTiposIva")) {
            men = new FEParamGetTiposIva();
        }
        if (mensaje.equals("FECAESolicitar")) {
            men = new FECAESolicitar();
        }
        if (mensaje.equals("FECompUltimoAutorizado")) {
            men = new FECompUltimoAutorizado();
        }
        if (mensaje.equals("FEParamGetTiposTributos")) {
            men = new FEParamGetTiposTributos();
        }
        if (mensaje.equals("FECompConsultar")) {
            men = new FEComConsultar();
        }
        if (mensaje.equals("BFEGetPARAM_NCM")) {
            men = new BFEGetPARAM_NCM();
        }
        if (mensaje.equals("BFEGetCMP")) {
            men = new BFEGetCMP();
        }
        if (mensaje.equals("BFEGetPARAM_Zonas")) {
            men = new BFEGetPARAM_Zonas();
        }
        if (mensaje.equals("BFEGetLast_CMP")) {
            men = new BFEGetLast_CMP();
        }
        if (mensaje.equals("BFEGetLast_ID")) {
            men = new BFEGetLast_ID();
        }
        if (mensaje.equals("BFEDummy")) {
            men = new BFEDummy();
        }
        if (mensaje.equals("BFEGetPARAM_MON")) {
            men = new BFEGetPARAM_MON();
        }
        if (mensaje.equals("BFEGetPARAM_Tipo_Cbte")) {
            men = new BFEGetPARAM_Tipo_Cbte();
        }
        if (mensaje.equals("BFEGetPARAM_Tipo_IVA")) {
            men = new BFEGetPARAM_Tipo_IVA();
        }
        if (mensaje.equals("BFEGetPARAM_UMed")) {
            men = new BFEGetPARAM_UMed();
        }
        if (mensaje.equals("BFEGetPARAM_Tipo_doc")) {
            men = new BFEGetPARAM_Tipo_doc();
        }
        if (mensaje.equals("BFEAuthorize")) {
            men = new BFEAuthorize();
        }
        return men;
    }

    public String getArchivoFactura() {
        return this.archivoFactura;
    }

    public void setArchivoFactura(String archivoFactura) {
        this.archivoFactura = archivoFactura;
    }

    public Mensajes getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(Mensajes mensaje) {
        this.mensaje = mensaje;
    }

    public String[] getParametrosParaFacturar() {
        return this.parametrosParaFacturar;
    }

    public void setParametrosParaFacturar(String[] parametrosParaFacturar) {
        if (parametrosParaFacturar.length == 3) {
            parametrosParaFacturar = this.expandir(parametrosParaFacturar);
        }
        this.parametrosParaFacturar = parametrosParaFacturar;
    }

    public String getNombreServerFE() {
        return this.nombreServerWSFE;
    }

    public void setNombreServerFE(String nombreServer) {
        this.nombreServerWSFE = nombreServer;
    }

    public String getNombreServerBE() {
        return this.nombreServerWSBE;
    }

    public void setNombreServerBE(String nombreServer) {
        this.nombreServerWSBE = nombreServer;
    }

    public String getNroComprobate() {
        return this.nroComprobate;
    }

    public void setNroComprobate(String nroComprobate) {
        this.nroComprobate = nroComprobate;
    }
}

