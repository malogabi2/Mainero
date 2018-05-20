/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.mainerofacturero;

import Proyecto.mainerofacturero.pantalla.FLogueo;
import todojuntowsawfe.Main;

public class MaineroFacturero {

    public static void main(String[] args) {
        if (args != null && args.length > 3) {
            Main.pruebaAfuera(args);
        } else {
            FLogueo log = new FLogueo();
            log.setVisible(true);
        }
    }
}
