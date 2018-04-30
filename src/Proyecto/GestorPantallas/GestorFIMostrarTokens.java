/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.GestorPantallas;

import Proyecto.modelo.Configuracion;
import Proyecto.modelo.TokenSign;
import Proyecto.utilerias.Utilerias;
import java.util.Date;

public class GestorFIMostrarTokens {
    Configuracion configu;

    public GestorFIMostrarTokens(Configuracion confi) {
        this.configu = confi;
    }

    public String mostrarTokenWSFE() {
        return this.configu.getTokServer1().getToken();
    }

    public String mostrarSignfWSFE() {
        return this.configu.getTokServer1().getSign();
    }

    public String mostrarMomentoPetisionWSFE() {
        return Utilerias.pasarADateTimeSQL(new Date(this.configu.getTokServer1().getMarcaTiempo()));
    }

    public String mostrarVencimientoTokWSFE() {
        return this.configu.getTokServer1().getExperacion();
    }

    public String mostrarTokenWBSFE() {
        return this.configu.getTokServer2().getToken();
    }

    public String mostrarSignfWBSFE() {
        return this.configu.getTokServer2().getSign();
    }

    public String mostrarMomentoPetisionWBSFE() {
        return Utilerias.pasarADateTimeSQL(new Date(this.configu.getTokServer2().getMarcaTiempo()));
    }

    public String mostrarVencimientoTokWBSFE() {
        return this.configu.getTokServer2().getExperacion();
    }
}

