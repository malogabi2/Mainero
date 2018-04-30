/*
 * Decompiled with CFR 0_124.
 * 
 * Could not load the following classes:
 *  org.dom4j.Document
 *  org.dom4j.DocumentException
 *  org.dom4j.io.SAXReader
 */
package wsa.coneccion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.Properties;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import wsa.coneccion.AfipWsaaConeccion;
import wsa.coneccion.ConeccionWSA;
import wsa.coneccion.Encriptador;

public class Wsaa {
    private ConeccionWSA cargarConeccion(String archivoConf, String servicio) throws FileNotFoundException, IOException {
        Properties config = new Properties();
        config.load(new FileInputStream(archivoConf));
        ConeccionWSA con = new ConeccionWSA();
        con.setServer(config.getProperty("endpoint", "error"));
        con.setServicio(servicio);
        con.setLineaConecion(config.getProperty("dstdn", "error"));
        con.setArchivoKeyStore(config.getProperty("keystore", "error"));
        con.setClaveDesencriptacionPublica(config.getProperty("keystore-signer", "error"));
        con.setClaveDesencriptacionPrivada(config.getProperty("keystore-password", "error"));
        con.setTiketTiempo(new Long(config.getProperty("TicketTime", "0")));
        return con;
    }

    private String comunicarConWsa(byte[] objetoEncriptado, String server) throws Exception {
        return AfipWsaaConeccion.llamadoWsaa(objetoEncriptado, server);
    }

    private String[] leorespuesta(String respuesta) throws DocumentException {
        System.out.println(respuesta);
        StringReader tokenReader = new StringReader(respuesta);
        Document tokenDoc = null;
        tokenDoc = new SAXReader(false).read((Reader)tokenReader);
        String token = tokenDoc.valueOf("/loginTicketResponse/credentials/token");
        String sign = tokenDoc.valueOf("/loginTicketResponse/credentials/sign");
        String vencimiento = tokenDoc.valueOf("/loginTicketResponse/header/expirationTime");
        System.out.println(vencimiento);
        return new String[]{token, sign, vencimiento, respuesta};
    }

    public String[] conectarWsa(String archivoConf, String servicio) throws FileNotFoundException, IOException, DocumentException, Exception {
        ConeccionWSA conec = this.cargarConeccion(archivoConf, servicio);
        Encriptador en = new Encriptador();
        byte[] pregunta = en.create_cms(conec);
        String[] repuesta = new String[5];
        String[] aux = this.leorespuesta(this.comunicarConWsa(pregunta, conec.getServer()));
        System.arraycopy(aux, 0, repuesta, 0, aux.length);
        repuesta[4] = en.getXMLMensaje();
        return repuesta;
    }
}

