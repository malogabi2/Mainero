/*
 * Decompiled with CFR 0_124.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.Layout
 */
package wfewfbe.pantalla.gestor;

import java.awt.Frame;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.apache.log4j.Layout;
import todojuntowsawfe.Salida;
import todojuntowsawfe.SalidaBFE;
import todojuntowsawfe.SalidaFE;
import utiles.MensajeError;
import wfewfbe.LectorFactura.LectorRespuesta;
import wfewfbe.pantalla.interfaz.DError;

public class GestorPrueba {
    private MensajeError err;

    public GestorPrueba(MensajeError error) {
        this.err = error;
    }

    public boolean escribir(String archivo, String[] mensaje) {
        File fil = new File(archivo);
        try {
            Date dt = new Date();
            this.err.addMensajeError("" + dt.getHours() + ":" + dt.getMinutes() + ":" + dt.getSeconds() + " Abriendo archivos para escribir respuesta .. GestorPrueba.escribir()");
            FileOutputStream filout = new FileOutputStream(fil);
            OutputStreamWriter wout = new OutputStreamWriter(filout);
            for (int i = 0; i < mensaje.length; ++i) {
                wout.write(mensaje[i]);
                wout.write(Layout.LINE_SEP);
            }
            wout.flush();
            wout.close();
            dt = new Date();
            this.err.addMensajeError("" + dt.getHours() + ":" + dt.getMinutes() + ":" + dt.getSeconds() + " Archivos escritos .. GestorPrueba.escribir()");
            return true;
        }
        catch (Exception ex) {
            Logger.getLogger(GestorPrueba.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public String[] resultadoSinXML(String mensajeXML) {
        LectorRespuesta ler = new LectorRespuesta(this.err);
        return ler.getParametros(mensajeXML, false);
    }

    public Salida armarResultadoInforme(String mensajeXML, boolean esConsulta, JFrame frame, String servicio) {
        Date dt = new Date();
        this.err.addMensajeError("" + dt.getHours() + ":" + dt.getMinutes() + ":" + dt.getSeconds() + " armando informe... GestorPrueba.armarResultadoInforme()");
        LectorRespuesta ler = new LectorRespuesta(this.err);
        ler.getParametros(mensajeXML, false);
        Salida sal = servicio.equals("wfe") ? new SalidaFE() : new SalidaBFE();
        sal.getParametro(ler.getCamposResul(), ler.getValoresResul());
        if (sal.esError() && esConsulta) {
            DError ed = new DError(frame, true);
            ed.setMensaje("El comprobante no se encontr\u00f3 en Afip");
            ed.setVisible(true);
        }
        return sal;
    }
}

