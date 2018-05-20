/*
 * Decompiled with CFR 0_124.
 */
package pantalla.gestor;

import Proyecto.modelo.Configuracion;
import Proyecto.modelo.Factura;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.Priority;
import pantalla.interfaz.FEspera;
import todojuntowsawfe.Entrada;
import todojuntowsawfe.GestorErrores;
import todojuntowsawfe.Principal;
import utiles.MensajeError;
import utiles.logger.LoggerBitacora;

public class GestorEspera
extends Thread
implements Observer {
    private String Error = "";
    private String archivoError;
    private Entrada entrada = new Entrada();
    private String serviWsa;
    private FEspera es;
    private MensajeError err = new MensajeError();
    private Configuracion config;
    private Factura facElegida;

    public GestorEspera() {
        this.err.addObserver(this);
        this.es = new FEspera();
    }

    private long marcaTiempo() {
        Date dt = new Date();
        return dt.getTime();
    }

    public void setConfiguracion(Configuracion config, Factura factEle) {
        this.config = config;
        this.facElegida = factEle;
    }

    @Override
    public void run() {
        boolean bandera = true;
        long mar = this.marcaTiempo();
        Principal prin = new Principal(this.err);
        prin.setConfiguracion(this.config, this.facElegida);
        prin.setEntrada(this.entrada);
        prin.setServicioWsa(this.serviWsa);
        prin.setPriority(5);
        prin.start();
        if (this.entrada.getMensaje() == null) {
            this.es.mensaje("Solicitando Autorizaci\u00f3n");
        } else {
            this.es.mensaje(this.entrada.getMensaje().nombreMensaje());
        }
        this.es.setVisible(true);
        while (bandera) {
            long mar1;
            if (!prin.isAlive()) {
                bandera = false;
            }
            if ((mar1 = this.marcaTiempo()) - mar <= 180000L) continue;
            this.setError("Se Acabo Tiempo");
            this.reportarErrorDemora();
            bandera = false;
        }
        this.es.dispose();
    }

    private void reportarErrorDemora() {
        try {
            GestorErrores ger = new GestorErrores(this.getArchivoError());
            ger.escribir("Tiempo De Espera Agotado");
            try {
                ger.cerrarArchivo();
            }
            catch (IOException ex) {
                LoggerBitacora.getInstance(GestorEspera.class).logueadorMainero.log("un Mensaje", Priority.ERROR,
                        "Error al cerrar achivo", ex);
                Logger.getLogger(GestorEspera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch (FileNotFoundException ex) {
            LoggerBitacora.getInstance(GestorEspera.class).logueadorMainero.log("un Mensaje", Priority.ERROR,
                        "Error al cerrar achivo", ex);
            Logger.getLogger(GestorEspera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametros(String[] parametros) {
        GestorErrores ge = null;
        try {
            this.entrada.setearParametros(parametros);
        }
        catch (Exception ex) {
            LoggerBitacora.getInstance(GestorEspera.class).logueadorMainero.log("un Mensaje", Priority.ERROR,
                        "Error al setear parametros", ex);
            Logger.getLogger(GestorEspera.class.getName()).log(Level.SEVERE, null, ex);
            try {
                ge = new GestorErrores("Error.txt");
            }
            catch (FileNotFoundException ex1) {
                LoggerBitacora.getInstance(GestorEspera.class).logueadorMainero.log("un Mensaje", Priority.ERROR,
                        "Error al setear parametros", ex1);
                Logger.getLogger(GestorEspera.class.getName()).log(Level.SEVERE, null, ex1);
            }
            ge.escribir("Error En los Parametros");
        }
    }

    public String getError() {
        return this.Error;
    }

    public void setError(String Error) {
        this.Error = Error;
    }

    public String getArchivoError() {
        return this.archivoError;
    }

    public void setArchivoError(String archivoError) {
        this.archivoError = archivoError;
    }

    public void setServicioWsa(String serWsa) {
        this.serviWsa = serWsa;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.es.setMensajeDetalle(arg.toString());
    }
}

