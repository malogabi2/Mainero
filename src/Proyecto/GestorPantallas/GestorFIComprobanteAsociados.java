/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto.GestorPantallas;

import Proyecto.modelo.Factura;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Mariano
 */
public class GestorFIComprobanteAsociados {
    private Factura facturaElegida;
    private DefaultTableModel tablita;
    /**
     * @return the facturaElegida
     */
    public Factura getFacturaElegida() {
        return facturaElegida;
    }

    /**
     * @param facturaElegida the facturaElegida to set
     */
    public void setFacturaElegida(Factura facturaElegida) {
        this.facturaElegida = facturaElegida;
    }
    
    public void traerComprobateAsociado(TableModel model) {
        this.tablita = (DefaultTableModel)model;
        for (int i = 0; i < this.facturaElegida.getComprobanteAsociados().size(); ++i) {
            this.tablita.addRow(this.facturaElegida.getComprobanteAsociados().get(i).filas());
        }
    }
    
    public void traerPeriodoAsociado(TableModel model) {
        this.tablita = (DefaultTableModel)model;
        this.tablita.addRow(this.facturaElegida.getPeriodoAsoc().filas());
    }
}
