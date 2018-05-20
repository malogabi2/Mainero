/*
 * Decompiled with CFR 0_124.
 */
package utiles;

import java.util.Date;
import org.apache.log4j.Priority;
import utiles.logger.LoggerBitacora;

public class Util {
    public static String concatenarString(String[] mensaje) {
        String aux = "";
        Date dt = new Date();
        LoggerBitacora.getInstance(Util.class).logueadorMainero.log("un Mensaje", Priority.INFO,
                                dt + " sigo dandole formato a arbol...elemtos:" + mensaje.length + " Prueba.concatenarString()" , null);
        System.out.println();
        for (int i = 1; i < mensaje.length; ++i) {
            if (mensaje[i].isEmpty()) {
                LoggerBitacora.getInstance(Util.class).logueadorMainero.log("un Mensaje", Priority.INFO,
                                "es vacia:" + mensaje[i], null);
                System.out.println("es vacia:" + mensaje[i]);
            } else if (mensaje[i].equals("")) {
                LoggerBitacora.getInstance(Util.class).logueadorMainero.log("un Mensaje", Priority.INFO,
                                "es vacia1:" + mensaje[i], null);
                System.out.println("es vacia1:" + mensaje[i]);
            }
            aux = mensaje[i].contains("Pro_codigo_ncm") ? aux + mensaje[i] : aux + mensaje[i] + "\n";
        }
        dt = new Date();
        LoggerBitacora.getInstance(Util.class).logueadorMainero.log("un Mensaje", Priority.INFO,
                                dt + " termine sigo dandole formato a arbol... Prueba.concatenarString()", null);
        System.out.println(dt + " termine sigo dandole formato a arbol... Prueba.concatenarString()");
        return aux;
    }
}

