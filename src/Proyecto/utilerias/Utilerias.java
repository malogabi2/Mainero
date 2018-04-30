/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.utilerias;

import Proyecto.modelo.DetalleFactura;
import Proyecto.modelo.Factura;
import Proyecto.modelo.Producto;
import Proyecto.modelo.Sucursal;
import Proyecto.modelo.Usuario;
import java.util.Calendar;
import java.util.Date;

public class Utilerias {
    public static String mostrarFechaStringString(String fecha) {
        return fecha.substring(0, 4) + "-" + fecha.substring(4, 6) + "-" + fecha.substring(6, 8);
    }

    public static Usuario[] pasarObjetoAUsuario(Object[] objetos) {
        Usuario[] us = new Usuario[objetos.length];
        for (int i = 0; i < objetos.length; ++i) {
            us[i] = (Usuario)objetos[i];
        }
        return us;
    }

    public static Producto[] pasarObjetoAProducto(Object[] objetos) {
        Producto[] us = new Producto[objetos.length];
        for (int i = 0; i < objetos.length; ++i) {
            us[i] = (Producto)objetos[i];
        }
        return us;
    }

    public static Sucursal[] pasarObjetoASucursal(Object[] objetos) {
        Sucursal[] su = new Sucursal[objetos.length];
        for (int i = 0; i < objetos.length; ++i) {
            su[i] = (Sucursal)objetos[i];
        }
        return su;
    }

    public static Factura[] pasarObjetoAFacturas(Object[] objetos) {
        Factura[] us = new Factura[objetos.length];
        for (int i = 0; i < objetos.length; ++i) {
            us[i] = (Factura)objetos[i];
        }
        return us;
    }

    public static DetalleFactura[] pasarObjetoADetalleFacturas(Object[] objetos) {
        DetalleFactura[] us = new DetalleFactura[objetos.length];
        for (int i = 0; i < objetos.length; ++i) {
            us[i] = (DetalleFactura)objetos[i];
        }
        return us;
    }

    public static String pasarADateTimeSQL(Date dia) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dia);
        String di = String.valueOf(cal.get(1)) + "-" + Utilerias.ajustarNumeroDigitos(cal.get(2) + 1, 2) + "-" + Utilerias.ajustarNumeroDigitos(cal.get(5), 2) + " " + Utilerias.ajustarNumeroDigitos(cal.get(11), 2) + ":" + Utilerias.ajustarNumeroDigitos(cal.get(12), 2) + ":" + Utilerias.ajustarNumeroDigitos(cal.get(13), 2);
        return di;
    }

    public static String pasarADateADiaArchivo(Date dia) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dia);
        String di = String.valueOf(cal.get(1)) + Utilerias.ajustarNumeroDigitos(cal.get(2) + 1, 2) + "-" + Utilerias.ajustarNumeroDigitos(cal.get(5), 2);
        return di;
    }

    public static String mostrarEnNDecimales(double numero, int cantidadDeci) {
        int coe = (int)Math.pow(10.0, cantidadDeci);
        numero = Math.rint(numero * (double)coe);
        return String.valueOf(numero /= (double)coe);
    }

    public static String crearExpresionRegular422(String entrada) {
        return entrada.substring(0, 4) + "." + entrada.substring(4, 6) + "." + entrada.substring(6, 8);
    }

    public static String ajustarStringDigitos(String numero, int digitos) {
        if (digitos > numero.length()) {
            String aux1 = String.valueOf(numero);
            for (int i = aux1.length(); i < digitos; ++i) {
                aux1 = "0" + aux1;
            }
            return aux1.trim();
        }
        return String.valueOf(numero).trim();
    }

    public static String ajustarNumeroDigitos(int numero, int digitos) {
        int aux = (digitos - 1) * 10;
        if (aux > numero) {
            String aux1 = String.valueOf(numero);
            for (int i = aux1.length(); i < digitos; ++i) {
                aux1 = "0" + aux1;
            }
            return aux1;
        }
        return String.valueOf(numero);
    }

    public static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        }
        catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    public static boolean filtrarCampoDecimal(String campo) {
        if (campo.matches("[0-9]+[.]?[0-9]*")) {
            return true;
        }
        return false;
    }

    public static boolean filtrarCampoNumero(String campo) {
        if (campo.matches("[0-9]*")) {
            return true;
        }
        return false;
    }
}

