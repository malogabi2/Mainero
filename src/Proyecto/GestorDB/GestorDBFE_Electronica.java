/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.GestorDB;

import Proyecto.GestorPantallas.FError;
import Proyecto.mainerofacturero.pantalla.DError;
import Proyecto.modelo.ComprobanteAsociado;
import Proyecto.modelo.Configuracion;
import Proyecto.modelo.DetalleFactura;
import Proyecto.modelo.Factura;
import Proyecto.modelo.PeriodoAsoc;
import Proyecto.modelo.Producto;
import Proyecto.utilerias.Utilerias;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Period;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.log4j.Priority;
import utiles.MensajeError;
import utiles.logger.LoggerBitacora;
import utiles.logger.LoggerCAE;

public class GestorDBFE_Electronica extends GestorDB {

    private int intentosDeGuardarCAE = 0;

    public GestorDBFE_Electronica(Configuracion cong) throws ClassNotFoundException, SQLException {
        super(cong);
    }

    private Producto[] buscaProducto(Factura fac) {
        ArrayList<Producto> detpro = new ArrayList<>();
        String con = "select ma_codigo, ma_nomenclatura from maquinas_vta where ma_codigo=" + fac.getProducto();
        /*  LoggerBitacora.getInstance(GestorDBFE_Electronica.class).logueadorMainero.log("un Mensaje", Priority.INFO,
                "Consulta : " + con, null);*/
        System.out.println(con);
        ResultSet rs;
        Conectar conectar = this.getConectar();
        if (conectar.isActivaLaConexion()) {
            try {
                rs = conectar.Select(con);
                while (rs.next()) {
                    Producto pro = new Producto();
                    pro.setCodigoProducto(fac.getProducto());
                    String num = Utilerias.ajustarStringDigitos(rs.getString("ma_nomenclatura"), 8);
                    num = Utilerias.crearExpresionRegular422(num);
                    pro.setNomenclador(num);
                    detpro.add(pro);
                }
            } catch (SQLException ex) {
                LoggerBitacora.getInstance(GestorDBFE_Electronica.class).logueadorMainero.log("un Mensaje", Priority.ERROR,
                        "Error al buscar producto", ex);
                Logger.getLogger(GestorDBFE_Electronica.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                /* if (conectar.isActivaLaConexion()) {
                    conectar.cerrarConexion();
                }*/
            }
        }

        return Utilerias.pasarObjetoAProducto(detpro.toArray());

    }

    private DetalleFactura[] buscaDetalles(Factura fac) {
        String con = "select ft_electas.ftt_iva, ft_electas.ftt_rg3337, ft_electas.ftt_brutos,ft_electas.ftt_interno from ft_electas where  ft_electas.ftt_tipo=" + fac.getTipo_comprobante() + " and ft_electas.ftt_boca=" + fac.getSuc_comprobante() + " and ft_electas.ftt_comprobante=" + fac.getNum_nombrante();
        /*    LoggerBitacora.getInstance(GestorDBFE_Electronica.class).logueadorMainero.log("un Mensaje", Priority.INFO,
                "Consulta : " + con, null);*/
        System.out.println(con);
        ArrayList<DetalleFactura> detfac = new ArrayList<DetalleFactura>();
        Conectar conectar = this.getConectar();
        if (conectar.isActivaLaConexion()) {
            try {
                ResultSet rs = conectar.Select(con);
                while (rs.next()) {
                    DetalleFactura deetfac = new DetalleFactura();
                    deetfac.setInterno(rs.getFloat("ftt_interno"));
                    deetfac.setIva(rs.getFloat("ftt_iva"));
                    deetfac.setNum_nombrante(fac.getNum_nombrante());
                    deetfac.setRg3337(rs.getFloat("ftt_rg3337"));
                    deetfac.setIng_brutos(rs.getFloat("ftt_brutos"));
                    deetfac.setSuc_comprobante(fac.getSuc_comprobante());
                    deetfac.setTipo_comprobante(fac.getTipo_comprobante());
                    detfac.add(deetfac);
                }

            } catch (SQLException ex) {
                LoggerBitacora.getInstance(GestorDBFE_Electronica.class).logueadorMainero.log("un Mensaje", Priority.ERROR,
                        "Error al buscar detalle factura", ex);
                Logger.getLogger(GestorDBFE_Electronica.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                /*   if (conectar.isActivaLaConexion()) {
                    conectar.cerrarConexion();
                }*/
            }
        }
        return Utilerias.pasarObjetoADetalleFacturas(detfac.toArray());
    }

    @Override
    public Object[] traerDatos() {
        return null;
    }

    private String siEsNulo(Object objeto) {
        if (objeto == null) {
            return "";
        }
        return (String) objeto;
    }
    
    public void traerComprobantesAsociados(Factura fac) {
        String con = "select ft_electroasoc.fta2_tipo, ft_electroasoc.fta2_boca, ft_electroasoc.fta2_comprobante,"
                + " ft_electroasoc.fta2_fecha, ft_electroasoc.fta2_fechah "
                + "from ft_electroasoc  where ft_electroasoc.fta_tipo=" + fac.getTipo_comprobante() + 
                " and ft_electroasoc.fta_boca=" + fac.getSuc_comprobante() + " and ft_electroasoc.fta_comprobante=" + fac.getNum_nombrante() + 
                " and ft_electroasoc.fta_tipo <> 999 order by "
                + "ft_electroasoc.fta2_tipo,ft_electroasoc.fta2_boca";
        FError error = new FError();
        error.setMensaje(con);
        JOptionPane.showMessageDialog(null, con);
        Conectar conectar = this.getConectar();
        if (conectar.isActivaLaConexion()) {
            try {
                ResultSet rs = conectar.Select(con);
                while (rs.next()) {
                    ComprobanteAsociado comproAsociado = new ComprobanteAsociado();
                    comproAsociado.setTipo_comprobante(rs.getString(1));
                    comproAsociado.setSuc_comprobante(rs.getString(2));
                    comproAsociado.setNum_nombrante(rs.getString(3));
                    comproAsociado.setFecha(rs.getString(4));
                    error.setMensaje("Comprobante Tipo: " 
                            + comproAsociado.getTipo_comprobante()
                            + ", Suc: " + comproAsociado.getSuc_comprobante()
                            + ", Nun Compro: " + comproAsociado.getNum_nombrante()
                            + ", Fecha: " + comproAsociado.getFecha());
                   
                    fac.agregarComprobanteAsoc(comproAsociado);
                    String fechaHasta = rs.getString(5);
                    if(comproAsociado.getFecha()!=null 
                            && !comproAsociado.getFecha().equals("null") 
                            && !comproAsociado.getFecha().equals("")
                            && fechaHasta != null 
                            && !fechaHasta.equals("null")
                            && !fechaHasta.equals("")) {
                        PeriodoAsoc periodoAsoc = new PeriodoAsoc();
                        periodoAsoc.setFechDesde(comproAsociado.getFecha());
                        periodoAsoc.setFechHasta(rs.getString(5));
                        error.setMensaje("Periodo Fecha Desde " + periodoAsoc.getFechDesde()
                                        + " Fecha Hasta: " + periodoAsoc.getFechHasta());        
                    
                        fac.setPeriodoAsoc(periodoAsoc);
                    }
                    
                }
            } catch (SQLException ex) {
                error.setMensaje("Error al traer datos");
                error.setMensaje(ex.toString());
                error.setMensaje(ex.getSQLState());
                error.setMensaje(ex.getMessage());
                LoggerBitacora.getInstance(GestorDBFE_Electronica.class).logueadorMainero.log("un Mensaje", Priority.ERROR,
                        "Error al traer datos", ex);
                Logger.getLogger(GestorDBFE_Electronica.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                error.setVisible(true);
            }
        }
    }

    @Override
    public Object[] traerDatos(Object[] parametros) {
        int numeroCompro = Integer.valueOf(String.valueOf(parametros[0]));
        int sucursalCompro = Integer.valueOf(String.valueOf(parametros[1]));
        int tipoCompro = Integer.valueOf(String.valueOf(parametros[2]));
        String con = "select ft_electronica.fte_tipo,ft_electronica.fte_boca,ft_electronica.fte_comprobante, ft_electronica.fte_razon_social,ft_electronica.fte_fecha,ft_electronica.fte_cuit,ft_electronica.fte_responsable,ft_electronica.fte_gravado,ft_electronica.fte_1, ft_electronica.fte_iva, ft_electronica.fte_2, ft_electronica.fte_exento, ft_electronica.fte_rg3337,ft_electronica.fte_tucuman,ft_electronica.fte_3,ft_electronica.fte_4, ft_electronica.fte_total, ft_electronica.fte_tipo_cont,ft_electronica.fte_cae,ft_electronica.fte_fecha_cae from ft_electronica  where ft_electronica.fte_tipo=" + tipoCompro + " and ft_electronica.fte_boca=" + sucursalCompro + " and ft_electronica.fte_comprobante=" + numeroCompro + " order by ft_electronica.fte_tipo desc,ft_electronica.fte_boca desc,ft_electronica.fte_comprobante ";
        System.out.println(con);
        ArrayList<Factura> lfac = new ArrayList<Factura>();
        Conectar conectar = this.getConectar();
        if (conectar.isActivaLaConexion()) {
            try {
                ResultSet rs = conectar.Select(con);
                int conta = 0;
                while (rs.next()) {
                    ++conta;
                    Factura fac = new Factura();
                    fac.setNum_nombrante(rs.getString(3));
                    fac.setCae(String.valueOf(rs.getString(19)));
                    fac.setFechaCae(rs.getString(20));
                    String var = rs.getString(2);
                    fac.setSuc_comprobante(var);
                    fac.setTipo_comprobante(rs.getString(1));
                    fac.setClienteNombre(rs.getString(4));
                    fac.setCodigoMoneda(0);
                    fac.setFecha(rs.getString(5));
                    fac.setImporteExento(this.agregarValorFloat(rs.getString(12)));
                    fac.setImporteGrafado(this.agregarValorFloat(rs.getString(8)));
                    fac.setImporteIvaInscripto(this.agregarValorFloat(rs.getString(11)));
                    fac.setImporteIvaNoInscripto(this.agregarValorFloat(rs.getString(10)));
                    fac.setImporteNoGravado("0");
                    fac.setProducto(String.valueOf(rs.getString(9)));
                    fac.setImporteTotal(rs.getString(17));
                    fac.setImpuestoInter(this.agregarValorFloat(rs.getString(16)));
                    fac.setPercep_IIBB(this.agregarValorFloat(rs.getString(14)));
                    fac.setPercep_mun(this.agregarValorFloat(rs.getString(15)));
                    fac.setPercep_nac(this.agregarValorFloat(rs.getString(13)));
                    fac.setTipoCambio(0);
                    fac.setTipo_documento(this.siEsNulo(rs.getString(18)));
                    fac.setClienteNumDoc(rs.getString(6));
                    fac.setClienteTipoIva(rs.getString(7));
                    fac.agregarItemsDetalleFactura(this.buscaDetalles(fac));
                    if (this.getConfigu().esFiscalLaSucursal(Integer.valueOf(fac.getSuc_comprobante())) && !fac.getProducto().equals("null") && !fac.getProducto().equals("0.00")) {
                        fac.agregarItemsProducto(this.buscaProducto(fac));
                    }
                    lfac.add(fac);
                }
            } catch (SQLException ex) {
                LoggerBitacora.getInstance(GestorDBFE_Electronica.class).logueadorMainero.log("un Mensaje", Priority.ERROR,
                        "Error al traer datos", ex);
                Logger.getLogger(GestorDBFE_Electronica.class.getName()).log(Level.SEVERE, null, ex);
            }
            /* finally {
                if(conectar.isActivaLaConexion()) conectar.cerrarConexiones();
            }*/
        }
        return Utilerias.pasarObjetoAFacturas(lfac.toArray());
    }

    private String agregarValorFloat(String valor) {
        if (valor == null || valor.equals("") || valor.equals("null")) {
            return "0";
        }
        return valor;
    }

    public boolean existElCae(String tipoCompro, String sucursal, String numeroComprobante, String cae) {
        String con = "select * from ft_electronica where ft_electronica.fte_tipo=" + tipoCompro + " and ft_electronica.fte_boca="
                + sucursal + " and ft_electronica.fte_comprobante=" + numeroComprobante + " and ft_electronica.fte_cae=" + cae;
        LoggerBitacora.getInstance(GestorDBFE_Electronica.class).logueadorMainero.log("un Mensaje", Priority.INFO,
                "Consulta Busco Cae: tipoCom" + tipoCompro + " sucursal: " + sucursal + " numeroCompro " + numeroComprobante + " cae: " + cae, null);
        System.out.println("busco Cae: " + con);
        Conectar conectar = this.getConectar();
        boolean result = false;
        if (conectar.isActivaLaConexion()) {
            try {
                ResultSet rs = conectar.Select(con);
                result = rs.next();
            } catch (SQLException ex) {
                LoggerBitacora.getInstance(GestorDBFE_Electronica.class).logueadorMainero.log("un Mensaje", Priority.ERROR,
                        "Error al ver si existe el cae", ex);
                Logger.getLogger(GestorDBFE_Electronica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public void guardarCae(ArrayList<String> capmos, ArrayList<String> valores, String tipoCompro,
            String sucursal, String numeroCompro, boolean esFiscal, MensajeError err) {
        
        String caeParaLoguear = !esFiscal ? valores.get(capmos.indexOf("CAE")) : valores.get(capmos.indexOf("Cae"));

        String caeFchaVto = !esFiscal ? valores.get(capmos.indexOf("CAEFchVto")) : valores.get(capmos.indexOf("Fch_venc_Cae"));

        String valoresParaLoguear = !esFiscal ? "cae = " + caeParaLoguear + " "
                + " fte_fecha_cae=" + valores.get(capmos.indexOf("CAEFchVto"))
                + " fte_tipo=" + tipoCompro + " fte_boca=" + sucursal + " fte_comprobante=" + numeroCompro
                : "cae = '" + valores.get(capmos.indexOf("Cae")) + "' "
                + ", fte_fecha_cae='" + valores.get(capmos.indexOf("Fch_venc_Cae"))
                + "' fte_tipo=" + tipoCompro + " fte_boca=" + sucursal + " fte_comprobante=" + numeroCompro;

        if (intentosDeGuardarCAE > 6) {
            LoggerBitacora.getInstance(GestorDBFE_Electronica.class).logueadorMainero.log("un Mensaje", Priority.ERROR,
                    "Demasiados intentos, CAE no se ha guardado correctamente, llame al administrador intentos = " + intentosDeGuardarCAE, null);
            System.out.println("Demasiados intentos, CAE no se ha guardado correctamente, llame al administrador");
            JOptionPane.showMessageDialog(null, "Demasiados intentos, CAE no se ha guardado correctamente, llame al administrador");
        } else if (!valores.get(capmos.indexOf("Reproceso")).equals("S") && valores.get(capmos.indexOf("Resultado")).equals("A")) {
            try {
                LoggerCAE.getInstance().guardarCAE(caeParaLoguear, caeFchaVto, tipoCompro, sucursal, numeroCompro, String.valueOf(esFiscal));
            } catch (IOException ex) {
                LoggerBitacora.getInstance(GestorDBFE_Electronica.class).logueadorMainero.log("un Mansaje", Priority.ERROR,
                        "No se pudo guardar CAE en el archivo de respado - " + ex.toString() + " - " + ex.getMessage(), null);
            }
            try {
                String cae = !esFiscal ? valores.get(capmos.indexOf("CAE")) : valores.get(capmos.indexOf("Cae"));
                String con = !esFiscal ? "update ft_electronica set ft_electronica.fte_cae = '" + cae + "' "
                        + ", ft_electronica.fte_fecha_cae='" + valores.get(capmos.indexOf("CAEFchVto"))
                        + "' where ft_electronica.fte_tipo=" + tipoCompro + " and ft_electronica.fte_boca="
                        + sucursal + " and ft_electronica.fte_comprobante=" + numeroCompro
                        : "update ft_electronica set ft_electronica.fte_cae = '" + valores.get(capmos.indexOf("Cae")) + "' "
                        + ", ft_electronica.fte_fecha_cae='" + valores.get(capmos.indexOf("Fch_venc_Cae"))
                        + "' where ft_electronica.fte_tipo=" + tipoCompro + " and ft_electronica.fte_boca="
                        + sucursal + " and ft_electronica.fte_comprobante=" + numeroCompro;
                System.out.println("updating : " + con);
                /*      LoggerBitacora.getInstance(GestorDBFE_Electronica.class).logueadorMainero.log("un Mensaje", Priority.INFO,
                        "Consulta  updating: " + con + " ******* intento: " + intentosDeGuardarCAE, null);*/
                Conectar conectar = this.getConectar();
                if (conectar.isActivaLaConexion()) {
                    intentosDeGuardarCAE++;
                    conectar.ejecutaConsulta(con);
                    this.espera(1);
                    //  conectar.cerrarConexion();                    
                    if (!this.existElCae(tipoCompro, sucursal, numeroCompro, cae)) {
                        LoggerBitacora.getInstance(GestorDBFE_Electronica.class).logueadorMainero.log("un Mensaje", Priority.WARN,
                                "Fallo de encontrar el CAE, intento: " + (intentosDeGuardarCAE), null);
                        System.out.println("Fallo de encontrar el CAE, intento: " + (intentosDeGuardarCAE));
                        guardarCae(capmos, valores, tipoCompro, sucursal, numeroCompro, esFiscal, err);
                    } else {
                        LoggerBitacora.getInstance(GestorDBFE_Electronica.class).logueadorMainero.log("un Mensaje", Priority.INFO,
                                "CAE guardo correctamente, despues de " + (intentosDeGuardarCAE) + "consulta: " + valoresParaLoguear, null);
                        System.out.println("CAE guardo correctamente, despues de " + (intentosDeGuardarCAE));
                        JOptionPane.showMessageDialog(null, "CAE guardo correctamente, despues de " + (intentosDeGuardarCAE) + " intentos", "CAE",
                                JOptionPane.INFORMATION_MESSAGE);
                        try {
                            LoggerCAE.getInstance().borrarCAEYaGuardado(caeParaLoguear, caeFchaVto, tipoCompro, sucursal, numeroCompro,
                                    String.valueOf(esFiscal));
                        } catch (IOException ex) {
                            LoggerBitacora.getInstance(GestorDBFE_Electronica.class).logueadorMainero.log("un Mansaje", Priority.ERROR,
                                    "No se pudo borrar el CAE en el archivo de respado - " + ex.toString() + " - " + ex.getMessage(), null);
                        }                        
                    }
                } else {
                    LoggerBitacora.getInstance(GestorDBFE_Electronica.class).logueadorMainero.log("un Mensaje", Priority.ERROR,
                            "La conexion de base de datos no esta lista", null);
                }
            } catch (SQLException ex) {
                LoggerBitacora.getInstance(GestorDBFE_Electronica.class).logueadorMainero.log("un Mensaje", Priority.ERROR,
                        " Error a guardar CAE, " + ex.toString() + " - " + ex.getMessage() + "consulta: "
                        + valoresParaLoguear + " intentos: " + intentosDeGuardarCAE, ex);
                System.out.println("Error a guardar CAE, " + ex.toString() + " - " + ex.getMessage());
                JOptionPane.showMessageDialog(null, "ERROR GRAVE al guardar CAE cae: " + caeParaLoguear + ", "
                        + "el error se auto reparara al entrar y salir del programa", "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            err.addMensajeError("Comprobante invalido para ser guardado Reproceso: " + capmos.indexOf("Reproceso")
                    + " Resultado: " + valores.get(capmos.indexOf("Resultado")));

            DError ed = new DError(null, false);
            ed.setMensajeUsuario("Error al guardar CAE, Comprobante invalido para ser guardado "
                    + "Reproceso: " + capmos.indexOf("Reproceso") + " Resultado: "
                    + valores.get(capmos.indexOf("Resultado")));

            ed.setVisible(true);
            /*     LoggerBitacora.getInstance(GestorDBFE_Electronica.class).logueadorMainero.log("un Mensaje", Priority.WARN,
                    "Error al guardar CAE, Comprobante invalido para ser guardado "
                    + "Reproceso: " + capmos.indexOf("Reproceso") + " Resultado: "
                    + valores.get(capmos.indexOf("Resultado")), null);*/
        }
    }

    @Override
    public int ultimoId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int guardar(Object objetoAGuardar) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void ponerEn0Intentos() {
        intentosDeGuardarCAE = 0;
    }

    public void guardarCae(String tipoCompro, String sucursal, String numeroCompro, String cae, String fechaVto, String esFiscal, MensajeError err) {
        if (intentosDeGuardarCAE > 6) {
            LoggerBitacora.getInstance(GestorDBFE_Electronica.class).logueadorMainero.log("un Mensaje", Priority.ERROR,
                    "Demasiados intentos, CAE no se ha guardado correctamente, llame al administrador intentos = " + intentosDeGuardarCAE, null);
            System.out.println("Demasiados intentos, CAE no se ha guardado correctamente, llame al administrador");
            JOptionPane.showMessageDialog(null, "Demasiados intentos, CAE no se ha guardado correctamente, llame al administrador");
        } else {
            try {
                String con = "update ft_electronica set ft_electronica.fte_cae = '" + cae + "' "
                        + ", ft_electronica.fte_fecha_cae='" + fechaVto
                        + "' where ft_electronica.fte_tipo=" + tipoCompro + " and ft_electronica.fte_boca="
                        + sucursal + " and ft_electronica.fte_comprobante=" + numeroCompro;
                
                System.out.println("updating : " + con);
                /*      LoggerBitacora.getInstance(GestorDBFE_Electronica.class).logueadorMainero.log("un Mensaje", Priority.INFO,
                        "Consulta  updating: " + con + " ******* intento: " + intentosDeGuardarCAE, null);*/
                Conectar conectar = this.getConectar();
                if (conectar.isActivaLaConexion()) {
                    intentosDeGuardarCAE++;
                    conectar.ejecutaConsulta(con);
                    this.espera(1);
                    //  conectar.cerrarConexion();                    
                    if (!this.existElCae(tipoCompro, sucursal, numeroCompro, cae)) {
                        LoggerBitacora.getInstance(GestorDBFE_Electronica.class).logueadorMainero.log("un Mensaje", Priority.WARN,
                                "Fallo de encontrar el CAE, intento: " + (intentosDeGuardarCAE), null);
                        System.out.println("Fallo de encontrar el CAE, intento: " + (intentosDeGuardarCAE));
                        guardarCae(tipoCompro, sucursal, numeroCompro, cae, fechaVto, esFiscal, err);
                    } else {
                        LoggerBitacora.getInstance(GestorDBFE_Electronica.class).logueadorMainero.log("un Mensaje", Priority.INFO,
                                "CAE guardo correctamente, despues de " + (intentosDeGuardarCAE), null);
                        System.out.println("CAE guardo correctamente, despues de " + (intentosDeGuardarCAE));
                        JOptionPane.showMessageDialog(null, "CAE guardo correctamente, despues de " + (intentosDeGuardarCAE) + " intentos", "CAE",
                                JOptionPane.INFORMATION_MESSAGE);
                        try {
                            LoggerCAE.getInstance().borrarCAEYaGuardado(cae, fechaVto, tipoCompro, sucursal, numeroCompro, esFiscal);
                        } catch (IOException ex) {
                            LoggerBitacora.getInstance(GestorDBFE_Electronica.class).logueadorMainero.log("un Mansaje", Priority.ERROR,
                                    "No se pudo borrar el CAE en el archivo de respado - " + ex.toString() + " - " + ex.getMessage(), null);
                        }
                    }
                } else {
                    LoggerBitacora.getInstance(GestorDBFE_Electronica.class).logueadorMainero.log("un Mensaje", Priority.ERROR,
                            "La conexion de base de datos no esta lista", null);
                }
            } catch (SQLException ex) {
                System.out.println("Error a guardar CAE, " + ex.toString() + " - " + ex.getMessage());
                JOptionPane.showMessageDialog(null, "ERROR GRAVE al guardar CAE cae: " + cae + ", "
                        + "el error se auto reparara al entrar y salir del programa", "ERROR GRAVE", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
