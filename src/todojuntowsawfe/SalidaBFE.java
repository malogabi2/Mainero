/*
 * Decompiled with CFR 0_124.
 */
package todojuntowsawfe;

import java.util.ArrayList;
import todojuntowsawfe.ItemsBFE;
import todojuntowsawfe.Salida;

public class SalidaBFE
extends Salida {
    private String Id;
    private String Cuit = "error";
    private String Tipo_doc;
    private String Nro_doc;
    private String Tipo_cbte;
    private String Punto_vta;
    private String Cbte_nro;
    private String Imp_total;
    private String Imp_tot_conc;
    private String Imp_neto;
    private String Impto_liq;
    private String Impto_liq_rni;
    private String Imp_op_ex;
    private String Imp_perc;
    private String Imp_iibb;
    private String Imp_perc_mun;
    private String Imp_internos;
    private String Fch_venc_Cae;
    private String Fecha_cbte_orig;
    private String Resultado;
    private String obs;
    private String Cae;
    private ArrayList<ItemsBFE> items = new ArrayList();

    @Override
    public void getParametro(ArrayList campos, ArrayList valor) {
        for (int i = 0; i < campos.size(); ++i) {
            if (campos.get(i).equals("Id")) {
                this.setId(valor.get(i).toString());
            }
            if (campos.get(i).equals("Cuit")) {
                this.setCuit(valor.get(i).toString());
            }
            if (campos.get(i).equals("Tipo_doc")) {
                this.setTipo_doc(valor.get(i).toString());
            }
            if (campos.get(i).equals("Nro_doc")) {
                this.setNro_doc(valor.get(i).toString());
            }
            if (campos.get(i).equals("Tipo_cbte")) {
                this.setTipo_cbte(valor.get(i).toString());
            }
            if (campos.get(i).equals("Punto_vta")) {
                this.setPunto_vta(valor.get(i).toString());
            }
            if (campos.get(i).equals("Cbte_nro")) {
                this.setCbte_nro(valor.get(i).toString());
            }
            if (campos.get(i).equals("Imp_total")) {
                this.setImp_total(valor.get(i).toString());
            }
            if (campos.get(i).equals("Imp_tot_conc")) {
                this.setImp_tot_conc(valor.get(i).toString());
            }
            if (campos.get(i).equals("Imp_neto")) {
                this.setImp_neto(valor.get(i).toString());
            }
            if (campos.get(i).equals("Impto_liq")) {
                this.setImpto_liq(valor.get(i).toString());
            }
            if (campos.get(i).equals("Impto_liq_rni")) {
                this.setImpto_liq_rni(valor.get(i).toString());
            }
            if (campos.get(i).equals("Imp_op_ex")) {
                this.setImp_op_ex(valor.get(i).toString());
            }
            if (campos.get(i).equals("Imp_perc")) {
                this.setImp_perc(valor.get(i).toString());
            }
            if (campos.get(i).equals("Imp_iibb")) {
                this.setImp_iibb(valor.get(i).toString());
            }
            if (campos.get(i).equals("Imp_perc_mun")) {
                this.setImp_perc_mun(valor.get(i).toString());
            }
            if (campos.get(i).equals("Imp_internos")) {
                this.setImp_internos(valor.get(i).toString());
            }
            if (campos.get(i).equals("Fecha_cbte_cae")) {
                this.setFecha_cbte_orig(valor.get(i).toString());
            }
            if (campos.get(i).equals("Fch_venc_Cae")) {
                this.setFch_venc_Cae(valor.get(i).toString());
            }
            if (campos.get(i).equals("Cae")) {
                this.setCae(valor.get(i).toString());
            }
            if (campos.get(i).equals("Resultado")) {
                this.setResultado(valor.get(i).toString());
            }
            if (!campos.get(i).equals("Obs")) continue;
            this.setObs(valor.get(i).toString());
        }
        this.rutinaItems(campos, valor);
    }

    private void rutinaItems(ArrayList campos, ArrayList valor) {
        int cantidadItm = (campos.size() - 24) / 9;
        int ult = 0;
        for (int i = 0; i < cantidadItm; ++i) {
            ItemsBFE it = new ItemsBFE();
            for (int j = ult; j < campos.size(); ++j) {
                if (campos.get(j).equals("Pro_codigo_ncm")) {
                    it.setPro_codigo_ncm(valor.get(j).toString());
                }
                if (campos.get(j).equals("Pro_codigo_sec")) {
                    it.setPro_codigo_sec(valor.get(j).toString());
                }
                if (campos.get(j).equals("Pro_ds")) {
                    it.setPro_ds(valor.get(j).toString());
                }
                if (campos.get(j).equals("Pro_qty")) {
                    it.setPro_qty(valor.get(j).toString());
                }
                if (campos.get(j).equals("Pro_umed")) {
                    it.setPro_umed(valor.get(j).toString());
                }
                if (campos.get(j).equals("Pro_precio_uni")) {
                    it.setPro_precio_uni(valor.get(j).toString());
                }
                if (campos.get(j).equals("Imp_bonif")) {
                    it.setImp_bonif(valor.get(j).toString());
                }
                if (campos.get(j).equals("Imp_total")) {
                    it.setImp_total(valor.get(j).toString());
                }
                if (!campos.get(j).equals("Iva_id")) continue;
                it.setIva_id(valor.get(j).toString());
                ult = j + 1;
                j = campos.size();
            }
            this.agregarItem(it);
        }
    }

    private String darFormatoFecha(String fecha) {
        String anio = fecha.substring(0, 4);
        String mes = fecha.substring(4, 6);
        String dia = fecha.substring(6, 8);
        return dia + "/" + mes + "/" + anio;
    }

    public String getId() {
        return this.Id;
    }

    private String llenoNumero(String numero, int cantidad) {
        if (numero.length() >= cantidad) {
            return numero;
        }
        for (int i = numero.length(); i < cantidad; ++i) {
            numero = "0" + numero;
        }
        return numero;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getCuit() {
        return this.Cuit;
    }

    public void setCuit(String Cuit) {
        this.Cuit = Cuit;
    }

    public String getTipo_doc() {
        return this.Tipo_doc;
    }

    public void setTipo_doc(String Tipo_doc) {
        this.Tipo_doc = Tipo_doc;
    }

    public String getNro_doc() {
        return this.Nro_doc;
    }

    public void setNro_doc(String Nro_doc) {
        this.Nro_doc = Nro_doc;
    }

    public String getTipo_cbte() {
        return this.Tipo_cbte;
    }

    private void setCbteTipo(String CbteTipo) {
        if (CbteTipo.equals("1")) {
            this.Tipo_cbte = "Factura A";
        }
        if (CbteTipo.equals("2")) {
            this.Tipo_cbte = "Debito A";
        }
        if (CbteTipo.equals("3")) {
            this.Tipo_cbte = "Credito A";
        }
        if (CbteTipo.equals("6")) {
            this.Tipo_cbte = "Factura B";
        }
        if (CbteTipo.equals("7")) {
            this.Tipo_cbte = "Debito B";
        }
        if (CbteTipo.equals("8")) {
            this.Tipo_cbte = "Credito B";
        }
    }

    public void setTipo_cbte(String Tipo_cbte) {
        this.setCbteTipo(Tipo_cbte);
    }

    public String getPunto_vta() {
        return this.Punto_vta;
    }

    public void setPunto_vta(String Punto_vta) {
        this.Punto_vta = this.llenoNumero(Punto_vta, 4);
    }

    public String getCbte_nro() {
        return this.Cbte_nro;
    }

    public void setCbte_nro(String Cbte_nro) {
        this.Cbte_nro = this.llenoNumero(Cbte_nro, 8);
    }

    public String getImp_total() {
        return this.Imp_total;
    }

    public void setImp_total(String Imp_total) {
        this.Imp_total = Imp_total;
    }

    public String getImp_tot_conc() {
        return this.Imp_tot_conc;
    }

    public void setImp_tot_conc(String Imp_tot_conc) {
        this.Imp_tot_conc = Imp_tot_conc;
    }

    public String getImp_neto() {
        return this.Imp_neto;
    }

    public void setImp_neto(String Imp_neto) {
        this.Imp_neto = Imp_neto;
    }

    public String getImpto_liq() {
        return this.Impto_liq;
    }

    public void setImpto_liq(String Impto_liq) {
        this.Impto_liq = Impto_liq;
    }

    public String getImpto_liq_rni() {
        return this.Impto_liq_rni;
    }

    public void setImpto_liq_rni(String Impto_liq_rni) {
        this.Impto_liq_rni = Impto_liq_rni;
    }

    public String getImp_op_ex() {
        return this.Imp_op_ex;
    }

    public void setImp_op_ex(String Imp_op_ex) {
        this.Imp_op_ex = Imp_op_ex;
    }

    public String getImp_perc() {
        return this.Imp_perc;
    }

    public void setImp_perc(String Imp_perc) {
        this.Imp_perc = Imp_perc;
    }

    public String getImp_iibb() {
        return this.Imp_iibb;
    }

    public void setImp_iibb(String Imp_iibb) {
        this.Imp_iibb = Imp_iibb;
    }

    public String getImp_perc_mun() {
        return this.Imp_perc_mun;
    }

    public void setImp_perc_mun(String Imp_perc_mun) {
        this.Imp_perc_mun = Imp_perc_mun;
    }

    public String getImp_internos() {
        return this.Imp_internos;
    }

    public void setImp_internos(String Imp_internos) {
        this.Imp_internos = Imp_internos;
    }

    public String getFch_venc_Cae() {
        return this.Fch_venc_Cae;
    }

    public void setFch_venc_Cae(String Fch_venc_Cae) {
        this.Fch_venc_Cae = Fch_venc_Cae;
    }

    public String getCae() {
        return this.Cae;
    }

    public void setCae(String Cae) {
        this.Cae = Cae;
    }

    public void agregarItem(ItemsBFE ite) {
        this.items.add(ite);
    }

    public ArrayList<ItemsBFE> getItems() {
        return this.items;
    }

    public String getFecha_cbte_orig() {
        return this.Fecha_cbte_orig;
    }

    public void setFecha_cbte_orig(String Fecha_cbte_orig) {
        this.Fecha_cbte_orig = Fecha_cbte_orig;
    }

    public String getResultado() {
        return this.Resultado;
    }

    public void setResultado(String Resultado) {
        this.Resultado = Resultado;
    }

    public String getObs() {
        return this.obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public boolean esError() {
        if (this.Cae == null) {
            return true;
        }
        return false;
    }
}

