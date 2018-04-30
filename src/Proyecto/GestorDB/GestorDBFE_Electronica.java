/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.GestorDB;

import Proyecto.GestorDB.Conectar;
import Proyecto.GestorDB.GestorDB;
import Proyecto.mainerofacturero.pantalla.DError;
import Proyecto.modelo.Configuracion;
import Proyecto.modelo.DetalleFactura;
import Proyecto.modelo.Factura;
import Proyecto.modelo.Producto;
import Proyecto.utilerias.Utilerias;
import java.awt.Frame;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utiles.MensajeError;

public class GestorDBFE_Electronica
extends GestorDB {
    public GestorDBFE_Electronica(Configuracion cong) throws ClassNotFoundException, SQLException {
        super(cong);
    }

    private Producto[] buscaProducto(Factura fac) {
        try {
            String con = "select ma_codigo, ma_nomenclatura from maquinas_vta where ma_codigo=" + fac.getProducto();
            System.out.println(con);
            ResultSet rs = this.getConectar().Select(con);
            ArrayList<Producto> detpro = new ArrayList<Producto>();
            while (rs.next()) {
                Producto pro = new Producto();
                pro.setCodigoProducto(fac.getProducto());
                String num = Utilerias.ajustarStringDigitos(rs.getString("ma_nomenclatura"), 8);
                num = Utilerias.crearExpresionRegular422(num);
                pro.setNomenclador(num);
                detpro.add(pro);
            }
            return Utilerias.pasarObjetoAProducto(detpro.toArray());
        }
        catch (SQLException ex) {
            Logger.getLogger(GestorDBFE_Electronica.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private DetalleFactura[] buscaDetalles(Factura fac) {
        try {
            String con = "select ft_electas.ftt_iva, ft_electas.ftt_rg3337, ft_electas.ftt_brutos,ft_electas.ftt_interno from ft_electas where  ft_electas.ftt_tipo=" + fac.getTipo_comprobante() + " and ft_electas.ftt_boca=" + fac.getSuc_comprobante() + " and ft_electas.ftt_comprobante=" + fac.getNum_nombrante();
            System.out.println(con);
            ResultSet rs = this.getConectar().Select(con);
            ArrayList<DetalleFactura> detfac = new ArrayList<DetalleFactura>();
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
            return Utilerias.pasarObjetoADetalleFacturas(detfac.toArray());
        }
        catch (SQLException ex) {
            Logger.getLogger(GestorDBFE_Electronica.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Object[] traerDatos() {
        return null;
    }

    private String siEsNulo(Object objeto) {
        if (objeto == null) {
            return "";
        }
        return (String)objeto;
    }

    @Override
    public Object[] traerDatos(Object[] parametros) {
        try {
            int numeroCompro = Integer.valueOf(String.valueOf(parametros[0]));
            int sucursalCompro = Integer.valueOf(String.valueOf(parametros[1]));
            int tipoCompro = Integer.valueOf(String.valueOf(parametros[2]));
            String con = "select ft_electronica.fte_tipo,ft_electronica.fte_boca,ft_electronica.fte_comprobante, ft_electronica.fte_razon_social,ft_electronica.fte_fecha,ft_electronica.fte_cuit,ft_electronica.fte_responsable,ft_electronica.fte_gravado,ft_electronica.fte_1, ft_electronica.fte_iva, ft_electronica.fte_2, ft_electronica.fte_exento, ft_electronica.fte_rg3337,ft_electronica.fte_tucuman,ft_electronica.fte_3,ft_electronica.fte_4, ft_electronica.fte_total, ft_electronica.fte_tipo_cont,ft_electronica.fte_cae,ft_electronica.fte_fecha_cae from ft_electronica  where ft_electronica.fte_tipo=" + tipoCompro + " and ft_electronica.fte_boca=" + sucursalCompro + " and ft_electronica.fte_comprobante=" + numeroCompro + " order by ft_electronica.fte_tipo desc,ft_electronica.fte_boca desc,ft_electronica.fte_comprobante ";
            System.out.println(con);
            ResultSet rs = this.getConectar().Select(con);
            ArrayList<Factura> lfac = new ArrayList<Factura>();
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
            return Utilerias.pasarObjetoAFacturas(lfac.toArray());
        }
        catch (SQLException ex) {
            Logger.getLogger(GestorDBFE_Electronica.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private String agregarValorFloat(String valor) {
        if (valor == null || valor.equals("") || valor.equals("null")) {
            return "0";
        }
        return valor;
    }
    
    public boolean existElCae(String tipoCompro, String sucursal, String numeroComprobante, String cae) throws SQLException{        
        String con = "select ft_electronica where ft_electronica.fte_tipo=" + tipoCompro + " and ft_electronica.fte_boca=" 
                + sucursal + " and ft_electronica.fte_comprobante=" + numeroComprobante + " and ft_electronica.fte_cae=" + cae;
        ResultSet rs = this.getConectar().Select(con);
        
        return rs.next();         
    }

    public void guardarCae(ArrayList<String> capmos, ArrayList<String> valores, String tipoCompro, 
            String sucursal, String numeroCompro, boolean esFiscal, MensajeError err) {
        if (!valores.get(capmos.indexOf("Reproceso")).equals("S") && valores.get(capmos.indexOf("Resultado")).equals("A")) {
            try {
                String con = "";
                con = !esFiscal ? "update ft_electronica set ft_electronica.fte_cae = '" + valores.get(capmos.indexOf("CAE")) + "' " + ", ft_electronica.fte_fecha_cae='" + valores.get(capmos.indexOf("CAEFchVto")) + "' where ft_electronica.fte_tipo=" + tipoCompro + " and ft_electronica.fte_boca=" + sucursal + " and ft_electronica.fte_comprobante=" + numeroCompro : "update ft_electronica set ft_electronica.fte_cae = '" + valores.get(capmos.indexOf("Cae")) + "' " + ", ft_electronica.fte_fecha_cae='" + valores.get(capmos.indexOf("Fch_venc_Cae")) + "' where ft_electronica.fte_tipo=" + tipoCompro + " and ft_electronica.fte_boca=" + sucursal + " and ft_electronica.fte_comprobante=" + numeroCompro;
                System.out.println(con);
                this.getConectar().ejecutaConsulta(con);
            }
            catch (SQLException ex) {
                DError ed = new DError(null, false);
                ed.setMensajeUsuario("Error al guardar CAE");
                ed.setMensajeAdmin(ex.toString() + " - " + ex.getMessage());
                ed.setVisible(true);
            }
        }
        else {
            err.addMensajeError("Comprobante invalido para ser guardado Reproceso: " + capmos.indexOf("Reproceso")
                    + " Resultado: " + valores.get(capmos.indexOf("Resultado") ));
            
            DError ed = new DError(null, false);
                ed.setMensajeUsuario("Error al guardar CAE, Comprobante invalido para ser guardado "
                        + "Reproceso: " + capmos.indexOf("Reproceso") + " Resultado: " 
                        + valores.get(capmos.indexOf("Resultado")));
                
            ed.setVisible(true);
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
}

