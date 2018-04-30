/*
 * Decompiled with CFR 0_124.
 */
package todojuntowsawfe;

import java.util.ArrayList;
import todojuntowsawfe.Salida;

public class SalidaFE
extends Salida {
    private String nroCuit = "error";
    private String numeroComprobante;
    private String fechaComprobante;
    private String impTotal;
    private String impNeto;
    private String ImpEx;
    private String ImpTrib;
    private String ImpIVA;
    private String caeNro;
    private String fchVto;
    private String sucursal;
    private String CbteTipo;

    @Override
    public void getParametro(ArrayList campos, ArrayList valor) {
        for (int i = 0; i < campos.size(); ++i) {
            if (campos.get(i).equals("DocNro")) {
                this.setNroCuit(valor.get(i).toString());
            }
            if (campos.get(i).equals("CbteDesde")) {
                this.setNumeroComprobante(valor.get(i).toString());
            }
            if (campos.get(i).equals("CbteFch")) {
                this.setFechaComprobante(valor.get(i).toString());
            }
            if (campos.get(i).equals("ImpTotal")) {
                this.setImpTotal(valor.get(i).toString());
            }
            if (campos.get(i).equals("ImpNeto")) {
                this.setImpNeto(valor.get(i).toString());
            }
            if (campos.get(i).equals("ImpOpEx")) {
                this.setImpEx(valor.get(i).toString());
            }
            if (campos.get(i).equals("ImpTrib")) {
                this.setImpTrib(valor.get(i).toString());
            }
            if (campos.get(i).equals("ImpIVA")) {
                this.setImpIVA(valor.get(i).toString());
            }
            if (campos.get(i).equals("CodAutorizacion")) {
                this.setCaeNro(valor.get(i).toString());
            }
            if (campos.get(i).equals("FchVto")) {
                this.setFchVto(valor.get(i).toString());
            }
            if (campos.get(i).equals("PtoVta")) {
                this.setSucursal(valor.get(i).toString());
            }
            if (!campos.get(i).equals("CbteTipo")) continue;
            this.setCbteTipo(valor.get(i).toString());
        }
    }

    public String getNroCuit() {
        return this.nroCuit;
    }

    public String getNumeroComprobante() {
        return this.numeroComprobante;
    }

    public String getFechaComprobante() {
        return this.fechaComprobante;
    }

    public String getImpTotal() {
        return this.impTotal;
    }

    public String getImpNeto() {
        return this.impNeto;
    }

    public String getImpEx() {
        return this.ImpEx;
    }

    public void setImpEx(String ImpEx) {
        this.ImpEx = ImpEx;
    }

    public String getImpTrib() {
        return this.ImpTrib;
    }

    public String getImpIVA() {
        return this.ImpIVA;
    }

    public String getCaeNro() {
        return this.caeNro;
    }

    public String getFchVto() {
        return this.fchVto;
    }

    public String getSucursal() {
        return this.sucursal;
    }

    public String getCbteTipo() {
        return this.CbteTipo;
    }

    private void setNroCuit(String nroCuit) {
        this.nroCuit = nroCuit;
    }

    private void setNumeroComprobante(String numeroComprobante) {
        this.numeroComprobante = this.llenoNumero(numeroComprobante, 8);
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

    private void setFechaComprobante(String fechaComprobante) {
        this.fechaComprobante = this.darFormatoFecha(fechaComprobante);
    }

    private void setImpTotal(String impTotal) {
        this.impTotal = impTotal;
    }

    private void setImpNeto(String impNeto) {
        this.impNeto = impNeto;
    }

    private void setImpTrib(String ImpTrib) {
        this.ImpTrib = ImpTrib;
    }

    private void setImpIVA(String ImpIVA) {
        this.ImpIVA = ImpIVA;
    }

    private void setCaeNro(String caeNro) {
        this.caeNro = caeNro;
    }

    private void setFchVto(String fchVto) {
        this.fchVto = this.darFormatoFecha(fchVto);
    }

    private String darFormatoFecha(String fecha) {
        String anio = fecha.substring(0, 4);
        String mes = fecha.substring(4, 6);
        String dia = fecha.substring(6, 8);
        return dia + "/" + mes + "/" + anio;
    }

    private void setSucursal(String sucursal) {
        this.sucursal = this.llenoNumero(sucursal, 4);
    }

    private void setCbteTipo(String CbteTipo) {
        if (CbteTipo.equals("1")) {
            this.CbteTipo = "Factura A";
        }
        if (CbteTipo.equals("2")) {
            this.CbteTipo = "Debito A";
        }
        if (CbteTipo.equals("3")) {
            this.CbteTipo = "Credito A";
        }
        if (CbteTipo.equals("6")) {
            this.CbteTipo = "Factura B";
        }
        if (CbteTipo.equals("7")) {
            this.CbteTipo = "Debito B";
        }
        if (CbteTipo.equals("8")) {
            this.CbteTipo = "Credito B";
        }
    }

    @Override
    public boolean esError() {
        if (this.nroCuit.equals("error")) {
            return true;
        }
        return false;
    }
}

