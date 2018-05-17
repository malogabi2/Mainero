/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author malog
 */
public class LoggerBitacora {

    private final static Logger LOGGER = Logger.getAnonymousLogger();

    public static void setArchivoLogguer(String usuario){
          try {
            // Los handler (manejadores) indican a donde mandar la salida ya sea consola o archivo
            // En este caso ConsoleHandler envia los logs a la consola
            Handler consoleHandler = new ConsoleHandler();
            // Con el manejador de archivo, indicamos el archivo donde se mandaran los logs
            // El segundo argumento controla si se sobre escribe el archivo o se agregan los logs al final
            // Para sobre escribir pase un true para agregar al final, false para sobre escribir
            // todo el archivo
            Handler fileHandler = new FileHandler("./" + usuario + "bitacora.log", true);

            // El formateador indica como presentar los datos, en este caso usaremos el formaro sencillo
            // el cual es mas facil de leer, si no usamos esto el log estara en formato xml por defecto
            SimpleFormatter simpleFormatter = new SimpleFormatter();

            // Se especifica que formateador usara el manejador (handler) de archivo
            fileHandler.setFormatter(simpleFormatter);

            // Asignamos los handles previamente declarados al log *raiz* esto es muy importante ya que
            // permitira que los logs de todas y cada una de las clases del programa que esten en ese paquete
            // o sus subpaquetes se almacenen en el archivo y aparescan en consola
            LOGGER.addHandler(consoleHandler);
            LOGGER.addHandler(fileHandler);

            // Indicamos a partir de que nivel deseamos mostrar los logs, podemos especificar un nivel en especifico
            // para ignorar informacion que no necesitemos
            consoleHandler.setLevel(Level.ALL);
            fileHandler.setLevel(Level.ALL);
        } catch (IOException ex) {
            Logger.getLogger(LoggerBitacora.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(LoggerBitacora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void log(String toLog, Level level) {
        LOGGER.log(level, toLog);
    }
    
}
