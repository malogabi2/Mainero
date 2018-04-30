/*
 * Decompiled with CFR 0_124.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.Layout
 */
package Proyecto.GestorArchivos;

import Proyecto.GestorArchivos.GestorAConfiguracion;
import Proyecto.modelo.TokenSign;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.Layout;

public class GestorATokenSign {
    String archivo = "token.txt";

    public void guardar(TokenSign[] tok) {
        try {
            File file = new File(this.archivo);
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Token1" + tok[0].getDetalle() + "=" + tok[0].getToken());
            bw.write(Layout.LINE_SEP);
            bw.write("Sing1" + tok[0].getDetalle() + "=" + tok[0].getSign());
            bw.write(Layout.LINE_SEP);
            bw.write("MarcaTiempo1" + tok[0].getDetalle() + "=" + tok[0].getMarcaTiempo());
            bw.write(Layout.LINE_SEP);
            bw.write("Experiacion1" + tok[0].getDetalle() + "=" + tok[0].getExperacion());
            bw.write(Layout.LINE_SEP);
            bw.write("Detalle1" + tok[0].getDetalle() + "=" + tok[0].getDetalle());
            bw.write(Layout.LINE_SEP);
            bw.write("Token2" + tok[1].getDetalle() + "=" + tok[1].getToken());
            bw.write(Layout.LINE_SEP);
            bw.write("Sing2" + tok[1].getDetalle() + "=" + tok[1].getSign());
            bw.write(Layout.LINE_SEP);
            bw.write("MarcaTiempo2" + tok[1].getDetalle() + "=" + tok[1].getMarcaTiempo());
            bw.write(Layout.LINE_SEP);
            bw.write("Experiacion2" + tok[1].getDetalle() + "=" + tok[1].getExperacion());
            bw.write(Layout.LINE_SEP);
            bw.write("Detalle2" + tok[1].getDetalle() + "=" + tok[1].getDetalle());
            bw.close();
        }
        catch (IOException ex) {
            Logger.getLogger(GestorAConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public TokenSign[] traerToken() throws IOException {
        InputStreamReader fr = null;
        String linea = null;
        TokenSign tok1 = new TokenSign();
        TokenSign tok2 = new TokenSign();
        fr = new FileReader(this.archivo);
        BufferedReader br = new BufferedReader(fr);
        while ((linea = br.readLine()) != null) {
            if (this.esToken1(linea)) {
                tok1.setToken(this.sacarValor(linea));
            }
            if (this.esSign1(linea)) {
                tok1.setSign(this.sacarValor(linea));
            }
            if (this.esMomento1(linea)) {
                tok1.setMarcaTiempo(Long.valueOf(this.sacarValor(linea)));
            }
            if (this.esDetalle1(linea)) {
                tok1.setDetalle(this.sacarValor(linea));
            }
            if (this.esExpiracion1(linea)) {
                tok1.setExperacion(this.sacarValor(linea));
            }
            if (this.esToken2(linea)) {
                tok2.setToken(this.sacarValor(linea));
            }
            if (this.esSign2(linea)) {
                tok2.setSign(this.sacarValor(linea));
            }
            if (this.esMomento2(linea)) {
                tok2.setMarcaTiempo(Long.valueOf(this.sacarValor(linea)));
            }
            if (this.esDetalle2(linea)) {
                tok2.setDetalle(this.sacarValor(linea));
            }
            if (!this.esExpiracion2(linea)) continue;
            tok2.setExperacion(this.sacarValor(linea));
        }
        fr.close();
        TokenSign[] arrtokenSign = new TokenSign[]{tok1, tok2};
        try {
            fr.close();
            return new TokenSign[]{tok1, tok2};
        }
        catch (IOException ex2) {
            Logger.getLogger(GestorAConfiguracion.class.getName()).log(Level.SEVERE, null, ex2);
            return arrtokenSign;
        }       
    }

    private boolean esToken1(String linea) {
        return linea.contains("Token1");
    }

    private boolean esToken2(String linea) {
        return linea.contains("Token2");
    }

    private boolean esSign1(String linea) {
        return linea.contains("Sing1");
    }

    private boolean esSign2(String linea) {
        return linea.contains("Sing2");
    }

    private boolean esMomento1(String linea) {
        return linea.contains("MarcaTiempo1");
    }

    private boolean esMomento2(String linea) {
        return linea.contains("MarcaTiempo2");
    }

    private boolean esDetalle1(String linea) {
        return linea.contains("Detalle1");
    }

    private boolean esDetalle2(String linea) {
        return linea.contains("Detalle2");
    }

    private boolean esExpiracion1(String linea) {
        return linea.contains("Experiacion1");
    }

    private boolean esExpiracion2(String linea) {
        return linea.contains("Experiacion2");
    }

    private String sacarValor(String linea) {
        return linea.substring(linea.indexOf("=") + 1);
    }
}

