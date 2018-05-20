/*
 * Decompiled with CFR 0_124.
 */
package wfewfbe.coneccion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.net.URLConnection;
import java.util.Date;
import org.apache.log4j.Priority;
import todojuntowsawfe.Entrada;
import utiles.MensajeError;
import utiles.logger.LoggerBitacora;
import wfewfbe.metodo.wfev1.Mensajes;

public class Ejecutor {
    MensajeError err;

    public Ejecutor(MensajeError error) {
        this.err = error;
    }

    private URLConnection tomaParametros(URLConnection connection, String[] parametros, Mensajes mensaje) throws IOException {
        OutputStream out = connection.getOutputStream();
        OutputStreamWriter wout = new OutputStreamWriter(out);
        Date dt = new Date();
        LoggerBitacora.getInstance(Ejecutor.class).logueadorMainero.log("un Mensaje", Priority.INFO,
                                " A punto de escribir en Server.. Ejecutor.tomaParametros()", null);
        this.err.addMensajeError("" + dt.getHours() + ":" + dt.getMinutes() + ":" + dt.getSeconds() + " A punto de escribir en Server.. Ejecutor.tomaParametros()");
        System.out.println(mensaje.mensaje(parametros, mensaje.nombreMensajeXML()));
        LoggerBitacora.getInstance(Ejecutor.class).logueadorMainero.log("un Mensaje", Priority.INFO,
                                mensaje.mensaje(parametros, mensaje.nombreMensajeXML()), null);
        
        wout.write(mensaje.mensaje(parametros, mensaje.nombreMensajeXML()));
        wout.flush();
        dt = new Date();
        this.err.addMensajeError("" + dt.getHours() + ":" + dt.getMinutes() + ":" + dt.getSeconds() + " ya escribi en Server.. Ejecutor.tomaParametros()");
        wout.close();
        return connection;
    }

    private String leerRepuesta(URLConnection connection) throws IOException {
        Date dt = new Date();
        this.err.addMensajeError("" + dt.getHours() + ":" + dt.getMinutes() + ":" + dt.getSeconds() + " A punto de leer respuesta en Server..  Ejecutor.leerRepuesta()");
        InputStreamReader isr = new InputStreamReader(connection.getInputStream());
        BufferedReader inbuf = new BufferedReader(isr);
        String inputLine = "";
        inputLine = inbuf.readLine();
        dt = new Date();
        this.err.addMensajeError("" + dt.getHours() + ":" + dt.getMinutes() + ":" + dt.getSeconds() + " ya lei respuesta en Server .. Ejecutor.leerRepuesta()");
        return inputLine;
    }

    public String ejecutar(Entrada parametros) throws IOException {
        Conectar cone = new Conectar();
        Date dt = new Date();
        this.err.addMensajeError("" + dt.getHours() + ":" + dt.getMinutes() + ":" + dt.getSeconds() + " Conectando con Server .. Ejecutor.ejecutar()");
        String nombreSe = parametros.getNombreServicio().equals("wfe") ? parametros.getNombreServerFE() : parametros.getNombreServerBE();
        return this.leerRepuesta(this.tomaParametros(cone.conectar(parametros.getMensaje().soapAction(), nombreSe), parametros.getParametrosParaFacturar(), parametros.getMensaje()));
    }
}

