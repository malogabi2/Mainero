/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles.logger;

import Proyecto.GestorDB.GestorDBFE_Electronica;
import Proyecto.modelo.Configuracion;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.Priority;
import utiles.MensajeError;

/**
 *
 * @author malog
 */
public class GestorDeCheckeoInicial extends Thread{

    private GestorDBFE_Electronica gestorDB; 
    
    public GestorDeCheckeoInicial(Configuracion config) throws SQLException, ClassNotFoundException {       
        this.gestorDB = new GestorDBFE_Electronica(config);       
    }
    
    @Override
    public void run() {
        try {            
            LoggerBitacora.getInstance(GestorDeCheckeoInicial.class).logueadorMainero.log("un Mensaje", Priority.INFO,
                        "Buscando CAE que faltaron por guardar", null);           
            String[] lineas = LoggerCAE.getInstance().leerContenido();
            if(lineas != null && lineas.length > 0) {
                LoggerBitacora.getInstance(GestorDeCheckeoInicial.class).logueadorMainero.log("un Mensaje", Priority.INFO,
                        "Buscando CAE que faltaron por guardar encontrados: " + lineas.length + " sin almacenar ", null);
                guardarCAEs(lineas, null);
            }
            else {
                LoggerBitacora.getInstance(GestorDeCheckeoInicial.class).logueadorMainero.log("un Mensaje", Priority.INFO,
                        "No se encontraron CAE sin guardar ", null);                
            }
        } catch (IOException ex) {
            LoggerBitacora.getInstance(GestorDeCheckeoInicial.class).logueadorMainero.log("un Mensaje", Priority.WARN,
                        "No se encontro el archivo de caes ", ex);           
        }        
    }
    
    private void guardarCAEs(String[] lineas, MensajeError err) {
        for(String linea : lineas) {
            String[] campos = LoggerCAE.getInstance().mostrarCamposDesdeUnaLinea(linea);
            LoggerBitacora.getInstance(GestorDeCheckeoInicial.class).logueadorMainero.log("un Mensaje", Priority.INFO,
                        "Guardando CAE: " + linea, null); 
            if(!gestorDB.existElCae(campos[2], campos[3], campos[4], campos[0])) {
                gestorDB.guardarCae(campos[2], campos[3], campos[4], campos[0], campos[1], campos[5], err);
            }
            else {
                try {
                    LoggerCAE.getInstance().borrarCAEYaGuardado(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5]);
                } catch (IOException ex) {
                     LoggerBitacora.getInstance(GestorDeCheckeoInicial.class).logueadorMainero.log("un Mensaje", Priority.ERROR,
                        "Problema al borrar Cae ya guarados al iniciar ", null);
                    Logger.getLogger(GestorDeCheckeoInicial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }    
    
}
