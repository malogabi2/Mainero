/*
 * Decompiled with CFR 0_124.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.Layout
 */
package todojuntowsawfe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.apache.log4j.Layout;

public class GestorErrores {
    Writer archivoErrores;

    public GestorErrores(String archivoNombre) throws FileNotFoundException {
        File archivo = new File(archivoNombre);
        FileOutputStream filout = new FileOutputStream(archivo);
        this.archivoErrores = new OutputStreamWriter(filout);
    }

    public boolean escribir(String mensaje) {
        try {
            this.archivoErrores.write(mensaje);
            this.archivoErrores.write(Layout.LINE_SEP);
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public void cerrarArchivo() throws IOException {
        this.archivoErrores.flush();
        this.archivoErrores.close();
    }
}

