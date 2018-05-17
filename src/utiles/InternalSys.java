package utiles;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InternalSys {
    private final static Logger LOGGER = Logger.getLogger("utiles.InternalSys");

    public void llamadaSistema(){
        LOGGER.log(Level.WARNING, "Ocurrio un error de acceso en 0xFF");
    }
}