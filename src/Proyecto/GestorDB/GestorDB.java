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
    private Configuracion configu;

    public GestorDB(Configuracion config) {        
        this.configu = config;
    }

    public abstract Object[] traerDatos();

    public abstract Object[] traerDatos(Object[] var1);

    public abstract int ultimoId();

    public abstract int guardar(Object var1);

    protected final Conectar getConectar() {
        try {
            Conectar conectar = new Conectar();
            conectar.conectarAccess(configu.getNombreODBC(), configu.getUsuarioODBC(), configu.getClaveODBC());
            return conectar;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
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

