/*
 * Decompiled with CFR 0_124.
 */
package todojuntowsawfe;

public class ItemsBFE {
    private String Pro_codigo_ncm;
    private String Pro_codigo_sec;
    private String Pro_ds;
    private String Pro_qty;
    private String Pro_umed;
    private String Pro_precio_uni;
    private String Imp_bonif;
    private String Imp_total;
    private String Iva_id;

    public String getPro_codigo_ncm() {
        return this.Pro_codigo_ncm;
    }

    public void setPro_codigo_ncm(String Pro_codigo_ncm) {
        this.Pro_codigo_ncm = Pro_codigo_ncm;
    }

    public String getPro_codigo_sec() {
        return this.Pro_codigo_sec;
    }

    public void setPro_codigo_sec(String Pro_codigo_sec) {
        this.Pro_codigo_sec = Pro_codigo_sec;
    }

    public String getPro_ds() {
        return this.Pro_ds;
    }

    public void setPro_ds(String Pro_ds) {
        this.Pro_ds = Pro_ds;
    }

    public String getPro_qty() {
        return this.Pro_qty;
    }

    public void setPro_qty(String Pro_qty) {
        this.Pro_qty = Pro_qty;
    }

    public String getPro_umed() {
        return this.Pro_umed;
    }

    public void setPro_umed(String Pro_umed) {
        this.Pro_umed = Pro_umed;
    }

    public String getPro_precio_uni() {
        return this.Pro_precio_uni;
    }

    public void setPro_precio_uni(String Pro_precio_uni) {
        this.Pro_precio_uni = Pro_precio_uni;
    }

    public String getImp_bonif() {
        return this.Imp_bonif;
    }

    public void setImp_bonif(String Imp_bonif) {
        this.Imp_bonif = Imp_bonif;
    }

    public String getImp_total() {
        return this.Imp_total;
    }

    public void setImp_total(String Imp_total) {
        this.Imp_total = Imp_total;
    }

    public String getIva_id() {
        return this.Iva_id;
    }

    public void setIva_id(String Iva_id) {
        this.Iva_id = Iva_id;
    }

    public String[] nombreColumnas() {
        return new String[]{"C\u00f3d. Pro. Seg MerCoSur", "C\u00f3d. Pro. Seg Secretaria", "Descrip. Prod", "Cantidad", "Precio Unit.", "Imp. Bonif.", "Impor Total", "Codigo Iva"};
    }

    public Object[] mostrarFila() {
        return new Object[]{this.Pro_codigo_ncm, this.Pro_codigo_sec, this.Pro_ds, this.Pro_qty, this.Pro_precio_uni, this.Imp_bonif, this.Imp_total, this.Iva_id};
    }
}

