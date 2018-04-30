/*
 * Decompiled with CFR 0_124.
 */
package utiles;

import java.util.Observable;

public class MensajeError
extends Observable {
    String mensaje = "";

    public void addMensajeError(String men) {
        this.mensaje = men + "\n";
        this.setChanged();
        this.notifyObservers(this.mensaje);
    }
}

