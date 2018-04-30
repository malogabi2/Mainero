/*
 * Decompiled with CFR 0_124.
 */
package utiles;

import java.io.PrintStream;
import java.util.Date;

public class Util {
    public static String concatenarString(String[] mensaje) {
        String aux = "";
        Date dt = new Date();
        System.out.println(dt + " sigo dandole formato a arbol...elemtos:" + mensaje.length + " Prueba.concatenarString()");
        for (int i = 1; i < mensaje.length; ++i) {
            if (mensaje[i].isEmpty()) {
                System.out.println("es vacia:" + mensaje[i]);
            } else if (mensaje[i].equals("")) {
                System.out.println("es vacia1:" + mensaje[i]);
            }
            aux = mensaje[i].contains("Pro_codigo_ncm") ? aux + mensaje[i] : aux + mensaje[i] + "\n";
        }
        dt = new Date();
        System.out.println(dt + " termine sigo dandole formato a arbol... Prueba.concatenarString()");
        return aux;
    }
}

