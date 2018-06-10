/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles.logger;

import java.io.IOException;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

/**
 *
 * @author malog
 */
public class LoggerBitacora {

    private static LoggerBitacora instance;
    public static Logger logueadorMainero;
    private static String nombreUsuarioLogueado = "usuarioDesconocido";

    public static void setNombreUsuarioLogueado(String unNombreDeUsuarioLogueado) {
        nombreUsuarioLogueado = unNombreDeUsuarioLogueado;
    }

    public static LoggerBitacora getInstance(Class unaClass) {
        logueadorMainero = Logger.getLogger(unaClass);
        RollingFileAppender file;
        try {
            file = new RollingFileAppender(new PatternLayout("%d{dd MMM yyyy HH:mm:ss,SSS} %5p %c{1}:%L - %m%n"), 
                    nombreUsuarioLogueado + "LogGeneral.log", true);
            file.setMaxFileSize("100MB");
            logueadorMainero.addAppender(file);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(LoggerBitacora.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (instance == null) {
            instance = new LoggerBitacora();
        }
        return instance;
    }
}
