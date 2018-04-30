/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.GestorPantallas;

import Proyecto.GestorArchivos.GestorABuscaUsuarios;
import Proyecto.mainerofacturero.pantalla.FPrincipal;
import Proyecto.modelo.Usuario;

public class GestorLogueo {
    GestorABuscaUsuarios gestorA = new GestorABuscaUsuarios();
    Usuario user;

    public boolean contastarLogueo(String user, String psw) {
        return this.estaElUsuario(this.gestorA.traerUsuarios(), user, psw);
    }

    private boolean estaElUsuario(Usuario[] user, String userN, String psw) {
        this.user = user[0];
        for (int i = 0; i < user.length; ++i) {
            if (!user[i].getUsuarioNombre().equals(userN) || !user[i].getPasss().equals(psw)) continue;
            this.user = user[i];
            return true;
        }
        return false;
    }

    public void llamarAlPrograma() {
        FPrincipal prin = new FPrincipal();
        prin.tomarUsuario(this.user);
        prin.setVisible(true);
    }
}

