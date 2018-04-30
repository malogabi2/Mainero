/*
 * Decompiled with CFR 0_124.
 */
package wfewfbe.LectorFactura;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class LectorEntradaFactura {
    public abstract String[] lectorPropiedadesMensaje(String var1) throws FileNotFoundException, IOException;

    public abstract String[] lectorPropiedadesFacturar(String var1) throws IOException, FileNotFoundException;
}

