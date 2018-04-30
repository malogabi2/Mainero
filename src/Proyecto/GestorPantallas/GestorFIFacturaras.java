/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.GestorPantallas;

import Proyecto.GestorArchivos.GestorAFactura;
import Proyecto.GestorDB.GestorDBFE_Electronica;
import Proyecto.Intermediario.GestorComunicacion;
import Proyecto.Intermediario.GestorPedidoLlaves;
import Proyecto.modelo.Configuracion;
import Proyecto.modelo.Factura;
import Proyecto.modelo.Sucursal;
import Proyecto.modelo.TokenSign;
import Proyecto.utilerias.Utilerias;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class GestorFIFacturaras {
    Configuracion config;
    Factura[] facs;
    DefaultTableModel tablita;

    public GestorFIFacturaras(Configuracion unaConfig) {
        this.setConfiguracion(unaConfig);
        this.buscarFacturas();
    }

    private void buscarFacturas() {
        try {
            GestorDBFE_Electronica gesdb = new GestorDBFE_Electronica(this.config);
            if (gesdb.traerDatos() != null) {
                this.facs = Utilerias.pasarObjetoAFacturas(gesdb.traerDatos());
            }
            gesdb.cerrarConector();
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorFIFacturaras.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(GestorFIFacturaras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setConfiguracion(Configuracion unaConfig) {
        this.config = unaConfig;
    }

    public TableModel traerFacturas(TableModel model) {
        this.tablita = (DefaultTableModel)model;
        for (int i = 0; i < this.facs.length; ++i) {
            this.tablita.addRow(this.facs[i].filas());
        }
        return this.tablita;
    }

    private DefaultTableModel borrarLasFilas(DefaultTableModel mod) {
        while (mod.getRowCount() != 0) {
            mod.removeRow(0);
        }
        return mod;
    }

    public TableModel mostrarFacturadas(TableModel model, String cantidad) {
        int cant = Integer.valueOf(cantidad);
        this.tablita = this.borrarLasFilas((DefaultTableModel)model);
        for (int i = 0; i < this.facs.length; ++i) {
            if (!this.facs[i].estaFacturado() || this.tablita.getRowCount() >= cant) continue;
            this.tablita.addRow(this.facs[i].filas());
        }
        return this.tablita;
    }

    public TableModel mostrarNoFacturadas(TableModel model, String cantidad) {
        int cant = Integer.valueOf(cantidad);
        this.tablita = this.borrarLasFilas((DefaultTableModel)model);
        for (int i = 0; i < this.facs.length; ++i) {
            if (this.facs[i].estaFacturado() || this.tablita.getRowCount() >= cant) continue;
            this.tablita.addRow(this.facs[i].filas());
        }
        return this.tablita;
    }

    public TableModel mostrarTodoFacturadas(TableModel model, String cantidad) {
        int cant = Integer.valueOf(cantidad);
        this.tablita = this.borrarLasFilas((DefaultTableModel)model);
        for (int i = 0; i < this.facs.length; ++i) {
            this.tablita.addRow(this.facs[i].filas());
        }
        return this.tablita;
    }

    public String[] traerSucursales() {
        return this.agregarItemTodos(this.config.sucursalesMostrarCombo());
    }

    public String[] traerComprobantes() {
        return this.agregarItemTodos(new String[]{"1-Factura A", "2-Notas Debitos A", "1-Credito A", "6-Factura B", "7-Debito B", "8-Credito B"});
    }

    private String[] agregarItemTodos(String[] campos) {
        String[] item = new String[campos.length + 1];
        item[0] = "Todos";
        for (int i = 0; i < campos.length; ++i) {
            item[i + 1] = campos[i].trim();
        }
        return item;
    }

    private int mostrarCodigoTipoComprobante(int tipoComprob) {
        if (tipoComprob < 4) {
            return tipoComprob + 1;
        }
        return tipoComprob + 4;
    }

    private boolean filtrarSucursal(int intSucursal, Factura fac) {
        if (intSucursal == 0) {
            return true;
        }
        return fac.filtrarPorSucursal(String.valueOf(this.config.mostrarItemSucursal(intSucursal - 1).getNumero()));
    }

    private boolean filtrarTipoComprobante(int tipoComprob, Factura fac) {
        if (tipoComprob == 0) {
            return true;
        }
        return fac.filtrarPorTipoComprobante(String.valueOf(this.mostrarCodigoTipoComprobante(tipoComprob - 1)));
    }

    public TableModel filtrar(int intSucursal, int intTipoComprobante, TableModel model, String cantidad) {
        int cant = Integer.valueOf(cantidad);
        this.tablita = this.borrarLasFilas((DefaultTableModel)model);
        for (int i = 0; i < this.facs.length; ++i) {
            if (!this.filtrarSucursal(intSucursal, this.facs[i]) || !this.filtrarTipoComprobante(intTipoComprobante, this.facs[i]) || this.tablita.getRowCount() >= cant) continue;
            this.tablita.addRow(this.facs[i].filas());
        }
        return this.tablita;
    }

    private int buscarColumnaSucursal() {
        for (int i = 0; i < this.tablita.getColumnCount(); ++i) {
            if (!this.tablita.getColumnName(i).equals("Suc")) continue;
            return i;
        }
        return -1;
    }

    private int buscarColumnaTipoComprob() {
        for (int i = 0; i < this.tablita.getColumnCount(); ++i) {
            if (!this.tablita.getColumnName(i).equals("Tip Com")) continue;
            return i;
        }
        return -1;
    }

    private int buscarColumnaNumComprob() {
        for (int i = 0; i < this.tablita.getColumnCount(); ++i) {
            if (!this.tablita.getColumnName(i).equals("Num Com")) continue;
            return i;
        }
        return -1;
    }

    private boolean esFiscalLaSucursal(int sucursal) {
        return this.config.esFiscalLaSucursal(sucursal);
    }

    public String consultarComprobante(int selectedRow) {
        int sucursal = Integer.valueOf(String.valueOf(this.tablita.getValueAt(selectedRow, this.buscarColumnaSucursal())));
        int tipoComprob = this.config.mostrarNumeroComproAfipDeReal(Integer.valueOf(String.valueOf(this.tablita.getValueAt(selectedRow, this.buscarColumnaTipoComprob()))));
        int numeroComprob = Integer.valueOf(String.valueOf(this.tablita.getValueAt(selectedRow, this.buscarColumnaNumComprob())));
        if (tipoComprob == -1) {
            return "No se Ha configurado el tipo de Comprobante: " + Integer.valueOf(String.valueOf(this.tablita.getValueAt(selectedRow, this.buscarColumnaTipoComprob()))) + " configuralo para poder operar con el";
        }
        this.buscarComprobantes(sucursal, tipoComprob, String.valueOf(numeroComprob));
        return "";
    }

    public void buscarComprobantes(int sucursal, int tipoComprobante, String numeroComprobante) {
        GestorAFactura gesa;
        GestorPedidoLlaves.actualizoSiEstaVencido(this.config);
        if (this.config.esFiscalLaSucursal(sucursal)) {
            gesa = new GestorAFactura(this.config.getArchivoFacturar());
            gesa.crearArchivoFacConsulta(this.config.getTokServer2(), this.config.getCuit());
        } else {
            gesa = new GestorAFactura(this.config.getArchivoFacturar());
            gesa.crearArchivoFacConsulta(this.config.getTokServer1(), this.config.getCuit());
        }
        GestorComunicacion gesco = new GestorComunicacion(this.config);
        gesco.buscarComprobate(this.config.esFiscalLaSucursal(sucursal), sucursal, tipoComprobante, Integer.valueOf(numeroComprobante));
    }

    public void facturar(int selectedRow) {
        Factura fac = this.facs[selectedRow];
        GestorAFactura ges = new GestorAFactura(this.config.getArchivoFacturar());
        if (this.config.esFiscalLaSucursal(Integer.valueOf(fac.getSuc_comprobante()))) {
            ges.crearArchivoFacFacturarWFE(this.config.getTokServer1(), this.config.getCuit(), fac);
        } else {
            ges.crearArchivoFacFacturarWBFE(this.config.getTokServer2(), this.config.getCuit(), this.config.getIdWSBFE(), fac);
        }
    }
}

