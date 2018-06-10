/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.GestorDB;

import Proyecto.modelo.Configuracion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.Priority;
import utiles.logger.LoggerBitacora;

public abstract class GestorDB {

    private static Configuracion configu;
    private static Conectar conectar;

    public GestorDB(Configuracion config) {
        if (conectar == null) {
            conectar = new Conectar();
            this.configu = config;
            try {
                conectar.conectarAccess(configu.getNombreODBC(), configu.getUsuarioODBC(), configu.getClaveODBC());
            } catch (ClassNotFoundException | SQLException ex) {
                LoggerBitacora.getInstance(GestorDBFE_Electronica.class).logueadorMainero.log("un Mensaje", Priority.ERROR,
                        "Problema al conectar con la bade de Datos " + configu.getNombreODBC() + " " + configu.getUsuarioODBC()
                        + " " + configu.getClaveODBC(), ex);
                Logger.getLogger(GestorDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (!conectar.isActivaLaConexion()) {
            this.configu = config;
            try {
                conectar.conectarAccess(configu.getNombreODBC(), configu.getUsuarioODBC(), configu.getClaveODBC());
            } catch (ClassNotFoundException | SQLException ex) {
                LoggerBitacora.getInstance(GestorDBFE_Electronica.class).logueadorMainero.log("un Mensaje", Priority.ERROR,
                        "Problema al conectar con la bade de Datos " + configu.getNombreODBC() + " " + configu.getUsuarioODBC()
                        + " " + configu.getClaveODBC(), ex);
                Logger.getLogger(GestorDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public abstract Object[] traerDatos();

    public abstract Object[] traerDatos(Object[] var1);

    public abstract int ultimoId();

    public abstract int guardar(Object var1);

    protected final Conectar getConectar() {
        return conectar;
    }

    protected final Conectar getConectarErrorGrave() {
        conectar = new Conectar();
        try {
            conectar.conectarAccess(configu.getNombreODBC(), configu.getUsuarioODBC(), configu.getClaveODBC());
        } catch (ClassNotFoundException | SQLException ex) {
            LoggerBitacora.getInstance(GestorDBFE_Electronica.class).logueadorMainero.log("un Mensaje", Priority.ERROR,
                    "Problema al conectar con la bade de Datos " + configu.getNombreODBC() + " " + configu.getUsuarioODBC()
                    + " " + configu.getClaveODBC(), ex);
            Logger.getLogger(GestorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conectar;
    }

    public Configuracion getConfigu() {
        return this.configu;
    }

    public void setConfigu(Configuracion configu) {
        this.configu = configu;
    }

    public void espera(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            LoggerBitacora.getInstance(GestorDB.class).logueadorMainero.log("un Mensaje", Priority.ERROR,
                    "Error al dormir por " + segundos, ex);

            Logger.getLogger(GestorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
