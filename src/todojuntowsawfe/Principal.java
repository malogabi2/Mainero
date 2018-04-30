/*
 * Decompiled with CFR 0_124.
 * 
 * Could not load the following classes:
 *  org.dom4j.DocumentException
 */
package todojuntowsawfe;

import Proyecto.Intermediario.GestorComunicacion;
import Proyecto.modelo.Configuracion;
import Proyecto.modelo.Factura;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.dom4j.DocumentException;
import pantalla.interfaz.Prueba;
import todojuntowsawfe.Entrada;
import todojuntowsawfe.GestorErrores;
import utiles.MensajeError;
import wfewfbe.LectorFactura.LectorEntradaFactura;
import wfewfbe.LectorFactura.LectorEntradaFacturaBFE;
import wfewfbe.LectorFactura.LectorEntradaFacturaFE;
import wfewfbe.LectorFactura.LectorRespuesta;
import wfewfbe.coneccion.Ejecutor;
import wfewfbe.metodo.wfev1.Mensajes;
import wfewfbe.pantalla.gestor.GestorPrueba;
import wsa.coneccion.Wsaa;

public class Principal
extends Thread {
    Prueba pantalla;
    private Entrada entrada = new Entrada();
    String servicioWsa;
    MensajeError error;
    private Configuracion confi;
    private Factura facEle;

    public Principal(MensajeError error) {
        this.error = error;
        this.pantalla = new Prueba(error);
    }

    private void llamar(Entrada entrada) {
        if (entrada.getNombreServicio().equals("wsa")) {
            this.wsa(entrada, this.servicioWsa);
        } else {
            this.wfe(entrada);
        }
    }

    private void wfe(Entrada parametros) {
        GestorErrores ge = null;
        try {
            ge = new GestorErrores(parametros.getArchivoError());
            LectorEntradaFactura le = this.entrada.getNombreServicio().equals("wfe") ? new LectorEntradaFacturaFE() : new LectorEntradaFacturaBFE();
            if (parametros.getMensaje().esFacturar()) {
                parametros.setParametrosParaFacturar(le.lectorPropiedadesFacturar(parametros.getArchivoFactura()));
            } else {
                parametros.setParametrosParaFacturar(le.lectorPropiedadesMensaje(parametros.getArchivoFactura()));
            }
            this.wsfe(parametros);
        }
        catch (Exception ex) {
            ge.escribir(ex.toString());
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            this.cerrar();
        }
        try {
            ge.cerrarArchivo();
        }
        catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void wsfe(Entrada parametros) throws IOException {
        Ejecutor ej = new Ejecutor(this.error);
        this.esbribirResultado(ej.ejecutar(parametros), parametros);
    }

    private void esbribirResultado(String resultado, Entrada parametros) {
        Date dt = new Date();
        System.out.println(dt + " armando pantalla con repuesta... Principal.escribitResultado()");
        this.pantalla.pruebaMensaje(resultado, parametros.getMensaje().getMensaje(), parametros.getArchivoRespuesta(), parametros.getMensaje().esConsulta(), parametros.getNombreServicio());
        this.pantalla.setVisible(true);
        LectorRespuesta lr = new LectorRespuesta(this.error);
        if (parametros.getNombreServicio().equals("wfe")) {
            lr.setCamposNecesarios(new String[]{"Resultado", "Reproceso", "Msg", "CAE", "CAEFchVto"});
        } else {
            lr.setCamposNecesarios(new String[]{"Id", "Cuit", "Cae", "Fch_venc_Cae", "Fch_cbte", 
                "Resultado", "Reproceso", "Obs", "ErrCode", "ErrMsg"});
        }        
        
        GestorPrueba gesP = new GestorPrueba(this.error);
        this.mostrarResultadoFacturacion(parametros.getNombreServicio(), lr.getParametros(resultado, parametros.getMensaje().esFacturar()), parametros.getMensaje().nombreMensajeXML());
        gesP.escribir(parametros.getArchivoRespuesta(), lr.getParametros(resultado, parametros.getMensaje().esFacturar()));
        if (this.entrada.getMensaje().esFacturar()) {
            GestorComunicacion.guardarCAEEnBaseDeDatos(confi, lr, facEle, this.error);            
        }
    }

    private void mostrarResultadoFacturacion(String nombreServicio, String[] respuestas, String nombreMensaje) {
        int resulpos = 0;
        int reprospos = 0;
        for (int i = 0; i < respuestas.length; ++i) {
            if (respuestas[i].contains("Resultado")) {
                resulpos = i;
            }
            if (!respuestas[i].contains("Reproceso")) continue;
            reprospos = i;
        }
        if (nombreServicio.equals("wfe") && nombreMensaje.equals("FECAESolicitar")) {
            if (respuestas[resulpos].equals("Resultado=A") && respuestas[reprospos].equals("Reproceso=N")) {
                JOptionPane.showMessageDialog(null, "Factura Enviada Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Problemas al Facturar", "Afip Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (!nombreServicio.equals("wfe") && nombreMensaje.equals("BFEAuthorize")) {
            if (respuestas[resulpos].equals("Resultado=A") && respuestas[reprospos].equals("Reproceso=N")) {
                JOptionPane.showMessageDialog(null, "Factura Enviada Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Problemas al Facturar", "Afip Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void wsa(Entrada entra, String servicio) {
        GestorErrores ge = null;
        try {
            ge = new GestorErrores(entra.getArchivoError());
            this.wsfa(entra.getEsPantalla(), entra.getArchivoConfiguracion(), entra.getArchivoRespuesta(), servicio);
        }
        catch (FileNotFoundException ex) {
            ge.escribir(ex.toString());
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            this.cerrar();
        }
        catch (IOException ex) {
            ge.escribir(ex.toString());
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            this.cerrar();
        }
        catch (DocumentException ex) {
            ge.escribir(ex.toString());
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, (Throwable)ex);
            this.cerrar();
        }
        catch (Exception ex) {
            ge.escribir(ex.toString());
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            this.cerrar();
        }
        try {
            ge.cerrarArchivo();
        }
        catch (IOException ex) {
            ge.escribir(ex.toString());
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            this.cerrar();
        }
    }

    private void wsfa(String esPantalla, String archivoConfig, String archivoRespuesta, String servicio) throws FileNotFoundException, IOException, DocumentException, Exception {
        Wsaa wsa = new Wsaa();
        String[] resultado = wsa.conectarWsa(archivoConfig, servicio);
        if (esPantalla.equals("true")) {
            this.pantalla.pruebaToken(resultado, archivoRespuesta);
            this.pantalla.setVisible(true);
        } else {
            GestorPrueba gep = new GestorPrueba(this.error);
            gep.escribir(archivoRespuesta, new String[]{"Token=" + resultado[0], "Sign=" + resultado[1], "Vencimiento=" + resultado[2], "Respuesta=" + resultado[3], "Pregunta=" + resultado[4]});
            this.cerrar();
        }
    }

    public void cerrar() {
        this.pantalla.dispose();
    }

    @Override
    public void run() {
        this.llamar(this.getEntrada());
    }

    public Entrada getEntrada() {
        return this.entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public void setServicioWsa(String servicioWSA) {
        this.servicioWsa = servicioWSA;
    }

    public void setConfiguracion(Configuracion config, Factura factEleg) {
        this.confi = config;
        this.facEle = factEleg;
    }
}

