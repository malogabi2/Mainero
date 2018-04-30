/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.GestorArchivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utiles.MensajeError;
import wfewfbe.LectorFactura.LectorRespuesta;

public class GestorARespuesta {
    String archivoRespuesta;
    ArrayList<String> campos;
    ArrayList<String> camposResul;

    public GestorARespuesta(String archivoRespuesta) {
        this.archivoRespuesta = archivoRespuesta;
    }

    public void leer(boolean esBonoFiscales) {
        try {
            FileReader fr = null;
            String linea = null;
            fr = new FileReader(this.archivoRespuesta);
            BufferedReader br = new BufferedReader(fr);
            linea = br.readLine();
            LectorRespuesta lr = new LectorRespuesta(new MensajeError());
            if (!esBonoFiscales) {
                lr.setCamposNecesarios(new String[]{"Resultado", "Reproceso", "Msg", "CAE", "CAEFchVto"});
            } else {
                lr.setCamposNecesarios(new String[]{"Id", "Cuit", "Cae", "Fch_venc_Cae", "Fch_cbte", "Resultado", "Reproceso", "Obs", "ErrCode", "ErrMsg"});
            }
            lr.getParametros(linea, true);
            this.campos = lr.getCamposResul();
            this.camposResul = lr.getValoresResul();
        }
        catch (IOException ex) {
            Logger.getLogger(GestorARespuesta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<String> camposNombre() {
        return this.campos;
    }

    public ArrayList<String> camposResult() {
        return this.camposResul;
    }
}

