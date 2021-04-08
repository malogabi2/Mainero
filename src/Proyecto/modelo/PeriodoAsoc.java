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
public class PeriodoAsoc {
    private String fechDesde;
    private String fechHasta;

    
    public Object[] filas() {        
        return new Object[]{this.fechDesde, this.fechHasta};
    }
    
    /**
     * @return the fechDesde
     */
    public String getFechDesde() {
        return fechDesde;
    }

    /**
     * @param fechDesde the fechDesde to set
     */
    public void setFechDesde(String fechDesde) {
        this.fechDesde = fechDesde;
    }

    /**
     * @return the fechHasta
     */
    public String getFechHasta() {
        return fechHasta;
    }

    /**
     * @param fechHasta the fechHasta to set
     */
    public void setFechHasta(String fechHasta) {
        this.fechHasta = fechHasta;
    }
}
