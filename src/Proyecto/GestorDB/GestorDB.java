/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.GestorDB;

import Proyecto.GestorDB.Conectar;
import Proyecto.modelo.Configuracion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class GestorDB {   
    private static Configuracion configu;
    private static Conectar conectar;
    static {
        conectar = new Conectar();       
    }
    public GestorDB(Configuracion config) {        
        this.configu = config;
         try {
            conectar.conectarAccess(configu.getNombreODBC(), configu.getUsuarioODBC(), configu.getClaveODBC());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GestorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public abstract Object[] traerDatos();

    public abstract Object[] traerDatos(Object[] var1);

    public abstract int ultimoId();

    public abstract int guardar(Object var1);

    protected final Conectar getConectar() {
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
        }
        catch (InterruptedException ex) {
            Logger.getLogger(GestorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

