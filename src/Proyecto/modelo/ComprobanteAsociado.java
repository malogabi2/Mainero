/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto.modelo;

/**
 *
 * @author Mariano
 */
public class ComprobanteAsociado {
    private String tipo_comprobante;
    private String suc_comprobante;
    private String num_nombrante;
    private String fecha; 

    /**
     * @return the tipo_comprobante
     */
    public String getTipo_comprobante() {
        return tipo_comprobante;
    }

    public Object[] filas() {        
        return new Object[]{this.tipo_comprobante, this.suc_comprobante, this.num_nombrante, this.fecha};
    }
    /**
     * @param tipo_comprobante the tipo_comprobante to set
     */
    public void setTipo_comprobante(String tipo_comprobante) {
        this.tipo_comprobante = tipo_comprobante;
    }

    /**
     * @return the suc_comprobante
     */
    public String getSuc_comprobante() {
        return suc_comprobante;
    }

    /**
     * @param suc_comprobante the suc_comprobante to set
     */
    public void setSuc_comprobante(String suc_comprobante) {
        this.suc_comprobante = suc_comprobante;
    }

    /**
     * @return the num_nombrante
     */
    public String getNum_nombrante() {
        return num_nombrante;
    }

    /**
     * @param num_nombrante the num_nombrante to set
     */
    public void setNum_nombrante(String num_nombrante) {
        this.num_nombrante = num_nombrante;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
