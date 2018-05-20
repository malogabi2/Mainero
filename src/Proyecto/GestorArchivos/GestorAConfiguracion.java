/*
 * Decompiled with CFR 0_124.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.Layout
 */
package Proyecto.GestorArchivos;

import Proyecto.modelo.Configuracion;
import Proyecto.modelo.Sucursal;
import Proyecto.modelo.TipoComprobante;
import Proyecto.modelo.TokenSign;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.Layout;
import org.apache.log4j.Priority;
import utiles.logger.LoggerBitacora;


public class GestorAConfiguracion {
    public GestorAConfiguracion(Configuracion configuracion) {
    }

    public GestorAConfiguracion() {
    }

    
    public void guardar(Configuracion config) {
        try {
            int i;
            this.FileCopy(config.getArchivoConfigEste(), config.getArchivoConfigEste() + "aux");
            File file = new File(config.getArchivoConfigEste());
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("archivoConfig=" + config.getArchivoConfiguracionWs());
            bw.write(Layout.LINE_SEP);
            bw.write("nombreODBC=" + config.getNombreODBC());
            bw.write(Layout.LINE_SEP);
            bw.write("usuarioODBC=" + config.getUsuarioODBC());
            bw.write(Layout.LINE_SEP);
            bw.write("claveODBC=" + config.getClaveODBC());
            bw.write(Layout.LINE_SEP);
            bw.write("archivoFacturar=" + config.getArchivoFacturar());
            bw.write(Layout.LINE_SEP);
            bw.write("archivoError=" + config.getArchivoError());
            bw.write(Layout.LINE_SEP);
            bw.write("archivoRespuesta=" + config.getArchivoRespuesta());
            bw.write(Layout.LINE_SEP);
            bw.write("cuit=" + config.getCuit());
            bw.write(Layout.LINE_SEP);
            bw.write("esAutoPedidoLlaves=" + config.isEsAutoPedidoLlaves());
            bw.write(Layout.LINE_SEP);
            bw.write("cantidadHorasPedidoLlave=" + config.getCantidadHorasPedidoLlaves());
            bw.write(Layout.LINE_SEP);
            bw.write("idWSBFE=" + config.getIdWSBFE());
            bw.write(Layout.LINE_SEP);
            bw.write("maxFilaCant=" + config.getMaximaFila());
            bw.write(Layout.LINE_SEP);
            bw.write("tiempoEspera=" + config.getTiempoEspera());
            for (i = 0; i < config.cantidadItemsSucursal(); ++i) {
                this.guardarItem(config.mostrarItemSucursal(i).guardarEnArchivo(), bw);
            }
            for (i = 0; i < config.cantidadItemsTipoComprobante(); ++i) {
                this.guardarItem(config.mostrarItemTipoComprobante(i).guardarEnArchivo(), bw);
            }
            bw.close();
        }
        catch (IOException ex) {
            LoggerBitacora.getInstance(GestorAConfiguracion.class).
                    logueadorMainero.log("un Mensaje", Priority.ERROR, 
                    "Error al guardar configuracion", ex); 
            Logger.getLogger(GestorAConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
            this.FileCopy(config.getArchivoConfigEste() + "aux", config.getArchivoConfigEste());
        }
    }

    public void FileCopy(String sourceFile, String destinationFile) {
        LoggerBitacora.getInstance(GestorAConfiguracion.class).
                    logueadorMainero.log("un Mensaje", Priority.INFO, 
                    "Desde: " + sourceFile + "*** Hacia: " + destinationFile, null);
        
        System.out.println("Desde: " + sourceFile);
        System.out.println("Hacia: " + destinationFile);
        try {
            int c;
            File inFile = new File(sourceFile);
            File outFile = new File(destinationFile);
            FileInputStream in = new FileInputStream(inFile);
            FileOutputStream out = new FileOutputStream(outFile);
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            in.close();
            out.close();
        }
        catch (IOException e) {
             LoggerBitacora.getInstance(GestorAConfiguracion.class).
                    logueadorMainero.log("un Mensaje", Priority.ERROR, 
                    "Hubo un error de entrada/salida!!!", e);            
        }
    }

    private void guardarItem(String[] paraItem, BufferedWriter bw) {
        for (int i = 0; i < paraItem.length; ++i) {
            try {
                bw.write(Layout.LINE_SEP);
                bw.write(paraItem[i]);
                continue;
            }
            catch (IOException ex) {
                 LoggerBitacora.getInstance(GestorAConfiguracion.class).
                    logueadorMainero.log("un Mensaje", Priority.ERROR, 
                    "Error al guardar Item", ex);
                Logger.getLogger(GestorAConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void guardarIdWSBFE(long id) throws IOException {
            File file = new File("idWSBFE");
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            fw.write(String.valueOf(id));
            fw.close();
    }
    
    public static String traerIdWSBFE() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("idWSBFE");
        BufferedReader br = new BufferedReader(fr);
        String id = br.readLine();
        fr.close();
        return id;

    }       

    public Configuracion traerConfiguracion(Configuracion configEntrada) {
        FileReader fr = null;
        String linea = null;
        try {
            fr = new FileReader(configEntrada.getArchivoConfigEste());
            BufferedReader br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                if ((!esAlggunValorDeSucursal(linea)) && (!esAlggunValorDeTipoComprobante(linea))) {
                    if (esArchivo(linea)) {
                        configEntrada.setArchivoConfiguracionWs(sacarValor(linea));
                    }
                    if (esNombreODBC(linea)) {
                        configEntrada.setNombreODBC(sacarValor(linea));
                    }
                    if (esUsuarioODBC(linea)) {
                        configEntrada.setUsuarioODBC(sacarValor(linea));
                    }
                    if (esClave(linea)) {
                        configEntrada.setClaveODBC(sacarValor(linea));
                    }
                    if (esArchivoFacturar(linea)) {
                        configEntrada.setArchivoFacturar(sacarValor(linea));
                    }
                    if (esArchivoError(linea)) {
                        configEntrada.setArchivoError(sacarValor(linea));
                    }
                    if (esArchivoRespuesta(linea)) {
                        configEntrada.setArchivoRespuesta(sacarValor(linea));
                    }
                    if (esCuit(linea)) {
                        configEntrada.setCuit(sacarValor(linea));
                    }
                    if (esCantidadHorasRenuevaLlaves(linea)) {
                        configEntrada.setCantidadHorasPedidoLlaves(Integer.valueOf(sacarValor(linea)).intValue());
                    }
                    if (esIsAutoPedidoLlave(linea)) {
                        configEntrada.setEsAutoPedidoLlaves(pasarStringABoolean(sacarValor(linea)));
                    }
                    if (esWBSFEID(linea)) {
                        configEntrada.setIdWSBFE(Long.valueOf(sacarValor(linea)).longValue());
                    }
                    if (esMaxCantFila(linea)) {
                        configEntrada.setMaximaFila(Integer.valueOf(sacarValor(linea)).intValue());
                    }
                    if (esTiempoEspera(linea)) {
                        configEntrada.setTiempoEspera(Integer.valueOf(sacarValor(linea)).intValue());
                    }
                }
                if (esAlggunValorDeSucursal(linea)) {
                    if (esNumeroSuc(linea)) {
                        Sucursal suc = new Sucursal();
                        suc.setNumero(Integer.valueOf(sacarValor(linea)).intValue());
                        configEntrada.agregarItemSucursal(suc);
                    } else {
                        if (esNombreSuc(linea)) {
                            configEntrada.mostrarItemSucursal(configEntrada.cantidadItemsSucursal() - 1).setDescripcion(sacarValor(linea));
                        }
                        if (esBonoFiscal(linea)) {
                            configEntrada.mostrarItemSucursal(configEntrada.cantidadItemsSucursal() - 1).setEsBonosFiscales(pasarStringABoolean(sacarValor(linea)));
                        }
                    }
                }
                if (esAlggunValorDeTipoComprobante(linea)) {
                    if (esNumeroTipoComproReal(linea)) {
                        TipoComprobante tip = new TipoComprobante();
                        tip.setNumeroReal(Integer.valueOf(sacarValor(linea)).intValue());
                        configEntrada.agregarItemTipoComprobante(tip);
                    } else {
                        if (esNumeroTipoComproAfip(linea)) {
                            configEntrada.mostrarItemTipoComprobante(configEntrada.cantidadItemsTipoComprobante() - 1).setNumeroAfip(Integer.valueOf(sacarValor(linea)).intValue());
                        }
                        if (esNombreTipoCompro(linea)) {
                            configEntrada.mostrarItemTipoComprobante(configEntrada.cantidadItemsTipoComprobante() - 1).setNombre(sacarValor(linea));
                        }
                    }
                }
            }

            GestorATokenSign gesTok = new GestorATokenSign();
            TokenSign[] tok = gesTok.traerToken();
            configEntrada.setTokServer1(tok[0]);
            configEntrada.setTokServer2(tok[1]);
            try {
                fr.close();
                return configEntrada;
            } catch (IOException ex) {
                 LoggerBitacora.getInstance(GestorAConfiguracion.class).
                    logueadorMainero.log("un Mensaje", Priority.ERROR, 
                    "Error al traer configuracion", ex);
                Logger.getLogger(GestorAConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
                return configEntrada;
            }
        } catch (IOException ex) {
             LoggerBitacora.getInstance(GestorAConfiguracion.class).
                    logueadorMainero.log("un Mensaje", Priority.ERROR, 
                    "Error al traer configuracion", ex);
            Logger.getLogger(GestorAConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
            try {
                fr.close();
                return configEntrada;
            } catch (IOException ex1) {
                 LoggerBitacora.getInstance(GestorAConfiguracion.class).
                    logueadorMainero.log("un Mensaje", Priority.ERROR, 
                    "Error al traer configuracion", ex1);
                Logger.getLogger(GestorAConfiguracion.class.getName()).log(Level.SEVERE, null, ex1);
                return configEntrada;
            }
        } finally {
            try {
                fr.close();
                return configEntrada;
            } catch (IOException ex2) {
                 LoggerBitacora.getInstance(GestorAConfiguracion.class).
                    logueadorMainero.log("un Mensaje", Priority.ERROR, 
                    "Error al traer configuracion", ex2);
                Logger.getLogger(GestorAConfiguracion.class.getName()).log(Level.SEVERE, null, ex2);
            }
        }        
    }

    private boolean esAlggunValorDeSucursal(String linea) {
        return this.esBonoFiscal(linea) || this.esNombreSuc(linea) || this.esNumeroSuc(linea);
    }

    private boolean esAlggunValorDeTipoComprobante(String linea) {
        return this.esNombreTipoCompro(linea) || this.esNumeroTipoComproReal(linea) || this.esNumeroTipoComproAfip(linea);
    }

    private boolean esArchivo(String linea) {
        return linea.contains("archivoConfig");
    }

    private boolean esNombreODBC(String linea) {
        return linea.contains("nombreODBC");
    }

    private boolean esUsuarioODBC(String linea) {
        return linea.contains("usuarioODBC");
    }

    private boolean esClave(String linea) {
        return linea.contains("claveODBC");
    }

    private String sacarValor(String linea) {
        return linea.substring(linea.indexOf("=") + 1);
    }

    private boolean esNumeroSuc(String linea) {
        return linea.contains("numeroSuc");
    }

    private boolean esCuit(String linea) {
        return linea.contains("cuit");
    }

    private boolean esNombreSuc(String linea) {
        return linea.contains("nombreSuc");
    }

    private boolean esNumeroTipoComproReal(String linea) {
        return linea.contains("numeroComproReal");
    }

    private boolean esNumeroTipoComproAfip(String linea) {
        return linea.contains("numeroComproAfip");
    }

    private boolean esNombreTipoCompro(String linea) {
        return linea.contains("nombreCompro");
    }

    private boolean esBonoFiscal(String linea) {
        return linea.contains("esBonoFiscal");
    }

    private boolean pasarStringABoolean(String bonos) {
        return bonos.contains("true");
    }

    private boolean esArchivoFacturar(String linea) {
        return linea.contains("archivoFacturar");
    }

    private boolean esArchivoError(String linea) {
        return linea.contains("archivoError");
    }

    private boolean esArchivoRespuesta(String linea) {
        return linea.contains("archivoRespuesta");
    }

    private boolean esIsAutoPedidoLlave(String linea) {
        return linea.contains("esAutoPedidoLlaves");
    }

    private boolean esCantidadHorasRenuevaLlaves(String linea) {
        return linea.contains("cantidadHorasPedidoLlave");
    }

    private boolean esWBSFEID(String linea) {
        return linea.contains("idWSBFE");
    }

    private boolean esMaxCantFila(String linea) {
        return linea.contains("maxFilaCant");
    }

    private boolean esTiempoEspera(String linea) {
        return linea.contains("tiempoEspera");
    }
}

