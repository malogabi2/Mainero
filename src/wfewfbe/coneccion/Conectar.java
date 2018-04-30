/*
 * Decompiled with CFR 0_124.
 */
package wfewfbe.coneccion;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conectar {
    private URLConnection cabeceraConeccion(String soapAction, String server) {
        String SOAP_ACTION = soapAction;
        URL u = null;
        try {
            u = new URL(server);
            URLConnection uc = null;
            uc = u.openConnection();
            HttpURLConnection connection = (HttpURLConnection)uc;
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-type", "text/xml; charset=utf-8");
            connection.setRequestProperty("SOAPAction", SOAP_ACTION);
            return connection;
        }
        catch (Exception ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public URLConnection conectar(String soapAction, String server) {
        return this.cabeceraConeccion(soapAction, server);
    }

    public void cerrar() {
    }
}

