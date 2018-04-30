/*
 * Decompiled with CFR 0_124.
 */
package todojuntowsawfe;

import Proyecto.modelo.Configuracion;
import Proyecto.modelo.Factura;
import pantalla.gestor.GestorEspera;

public class Main {
    private Configuracion config;
    private Factura factElegida;

    public static void main(String[] args) {
        Main main = new Main();
        main.comienzo(args);
    }

    public void comienzo(String[] args) {
        this.start(args);
    }
    
    public static void pruebaAfuera(String [] args) {
        new Main().start(args);        
    }

    private void start(String[] parametros) {
        GestorEspera ges = new GestorEspera();
        ges.setConfiguracion(this.config, this.factElegida);
        ges.setArchivoError(parametros[4]);
        ges.setParametros(parametros);
        ges.setServicioWsa(parametros[5]);
        ges.start();
    }

    public void setConfiguracion(Configuracion condig, Factura factElegida) {
        this.config = condig;
        this.factElegida = factElegida;
    }

    private static String[] pruebawsa() {
        return new String[]{"wsa", "./wsconfiguracion.ini", "true", "salidxxa.txt", "errores.txt", "wsfe"};
    }

    private static String[] pruebawfe() {
        return new String[]{"wfe", "./wsconfiguracion.ini", "tue", "salidxxa.txt", "errores.txt", "./facturar1Iva.txt", "FECAESolicitar"};
    }

    private static String[] pruebaBwfe() {
        return new String[]{"wbfe", "./wsconfiguracion.ini", "true", "salidxxa.txt", "errores.txt", "./facturar1IvaBFE.txt", "BFEAuthorize"};
    }

    private static String[] ultimoComprobante() {
        return new String[]{"wfe", "./wsconfiguracion.ini", "true", "salidxxa.txt", "errores.txt", "./facturar1Iva.txt", "FECompUltimoAutorizado", "15", "3"};
    }

    private static String[] getParam() {
        return new String[]{"wfe", "./wsconfiguracion.ini", "true", "salidxxa.txt", "errores.txt", "./facturar1Iva.txt", "FEParamGetPtosVenta"};
    }

    private static String[] getDummy() {
        return new String[]{"wfe", "./wsconfiguracion.ini", "tue", "salidxxa.txt", "errores.txt", "./facturar1Iva.txt", "FEDummy"};
    }

    private static String[] getCom() {
        return new String[]{"wfe", "./wsconfiguracion.ini", "true", "salidxxa.txt", "errores.txt", "./facturar1Iva.txt", "FECompConsultar", "13", "3", "10"};
    }

    private static String[] getBFEConsultaProducto() {
        return new String[]{"wbfe", "./wsconfiguracion.ini", "tru", "salidxxa.txt", "errores.txt", "./facturar1IvaBFE.txt", "BFEGetPARAM_NCM"};
    }

    private static String[] getBFEGetCMP() {
        return new String[]{"wbfe", "./wsconfiguracion.ini", "tue", "salidxxa.txt", "errores.txt", "./facturar1IvaBFE.txt", "BFEGetCMP", "160", "1", "1"};
    }

    private static String[] getBFEGetZonas() {
        return new String[]{"wbfe", "./wsconfiguracion.ini", "true", "salidxxa.txt", "errores.txt", "./facturar1IvaBFE.txt", "BFEGetPARAM_Zonas", "9", "1", "1"};
    }

    private static String[] getBFEGetUltimoComprobante() {
        return new String[]{"wbfe", "./wsconfiguracion.ini", "true", "salidxxa.txt", "errores.txt", "./facturar1Iva.txt", "BFEGetLast_CMP", "25", "1"};
    }

    private static String[] getBFEGetUltimoID() {
        return new String[]{"wbfe", "./wsconfiguracion.ini", "true", "salidxxa.txt", "errores.txt", "./facturar1IvaBFE.txt", "BFEGetLast_ID"};
    }

    private static String[] getBDummy() {
        return new String[]{"wbfe", "./wsconfiguracion.ini", "true", "salidxxa.txt", "errores.txt", "./facturar1Iva.txt", "BFEDummy"};
    }

    private static String[] getParamBE() {
        return new String[]{"wbfe", "./wsconfiguracion.ini", "tue", "salidxxa.txt", "errores.txt", "./facturar1IvaBFE.txt", "BFEGetPARAM_Tipo_IVA"};
    }

    private static String[] getParamBFEMonedas() {
        return new String[]{"wbfe", "./wsconfiguracion.ini", "true", "salidxxa.txt", "errores.txt", "./fact.txt", "BFEGetPARAM_Tipo_Cbte"};
    }
}

