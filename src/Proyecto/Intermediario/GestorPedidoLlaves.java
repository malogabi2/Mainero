/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.Intermediario;

import Proyecto.GestorArchivos.GestorAConfiguracion;
import Proyecto.Intermediario.GestorComunicacion;
import Proyecto.modelo.Configuracion;
import Proyecto.modelo.TokenSign;

public class GestorPedidoLlaves {
    public static boolean actualizoSiEstaVencido(Configuracion config) {
        if (config.isEsAutoPedidoLlaves()) {
            GestorComunicacion gscom = new GestorComunicacion(config);
            gscom.actualizarLlaveSiEstanVencidas(config.getTokServer1(), config.getCantidadHorasPedidoLlaves());
            gscom.actualizarLlaveSiEstanVencidas(config.getTokServer1(), config.getCantidadHorasPedidoLlaves());
            GestorAConfiguracion gesA = new GestorAConfiguracion(config);
            gesA.guardar(config);
            return true;
        }
        return false;
    }
}

