/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles.logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.log4j.Layout;
import org.apache.log4j.Priority;

/**
 *
 * @author malog
 */
public class LoggerCAE {

    private static LoggerCAE instance;
    private static String usuario = "usuarioDesconocido";

    public static LoggerCAE getInstance() {
        if (instance == null) {
            instance = new LoggerCAE();
        }
        return instance;
    }

    public static void setNombreUsuarioLogueado(String usuario) {
        LoggerCAE.usuario = usuario;
    }

    public void guardarCAE(String... campos) throws IOException {
        String linea = crearNuevaLineaAGuardar(campos);
        String lineasGuardadas[] = leerContenido();        
        lineasGuardadas = crearNuevaListaAgregando(lineasGuardadas, linea);
        guardar(lineasGuardadas);
    }

    public boolean borrarCAEYaGuardado(String... campos) throws IOException {
        String lineaABorrar = crearNuevaLineaAGuardar(campos);
        String lineasGuardadas[] = leerContenido();        
        boolean seEncontro = false;
        if(lineasGuardadas == null) {
            System.out.println("No se encontraron lineas guardadas ");
            return false;
        }
        else {
            System.out.println("Cantidad de Lineas guardadas :" + lineasGuardadas.length);
        }
        for (String linea : lineasGuardadas) {
            if (linea.equals(lineaABorrar)) {
                seEncontro = true;
                System.out.println("Se Encontro CAE a borrar");
            }
        }
        if (!seEncontro) {
            return false;
        }
        lineasGuardadas = crearNuevaListaBorrando(lineasGuardadas, lineaABorrar);
        guardar(lineasGuardadas);
        return true;
    }

    protected void guardar(String lineaAEscribir[]) throws IOException {
        File file = new File(usuario + "ArchivoCAE.db");
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        for (String linea : lineaAEscribir) {
            bw.write(linea);
            bw.write(Layout.LINE_SEP);
        }
        bw.close();
    }

    protected String crearNuevaLineaAGuardar(String... campos) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String campo : campos) {
            if (stringBuilder.length() == 0) {
                stringBuilder.append(campo);
            } else {
                stringBuilder.append(";").append(campo);
            }
        }
        System.out.println("Linea a guardar archivo cae: " + stringBuilder.toString());
        return stringBuilder.toString();
    }

    protected String[] mostrarCamposDesdeUnaLinea(String linea) {
        return linea.split(";");
    }

    protected String[] crearNuevaListaAgregando(String[] listaDePalabras, String lineaAAgregar) {
        ArrayList<String> nuevaLista = new ArrayList<>();
        if(listaDePalabras != null) {
            nuevaLista.addAll(Arrays.asList(listaDePalabras));
        }            
        nuevaLista.add(lineaAAgregar);
        String[] elementosArray = new String[nuevaLista.size()];
        return nuevaLista.toArray(elementosArray);
    }

    protected String[] crearNuevaListaBorrando(String[] listaDePalabras, String lineaABorrar) {
        ArrayList<String> nuevaLista = new ArrayList<>();
        for (String linea : listaDePalabras) {
            if (!lineaABorrar.equals(linea)) {
                nuevaLista.add(linea);
            }
        }
        String[] elementosArray = new String[nuevaLista.size()];
        return nuevaLista.toArray(elementosArray);
    }

    protected String[] leerContenido() throws IOException {
        ArrayList<String> elementos = new ArrayList<>();
        FileReader fr = null;
        String linea = null;
        String[] elementosArray = null;
        try {
            fr = new FileReader(usuario + "ArchivoCAE.db");
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                linea = br.readLine();
                if (linea == null) {
                    break;
                }
                elementos.add(linea);
            }
            elementosArray = new String[elementos.size()];
            return elementos.toArray(elementosArray);
        } catch (FileNotFoundException ex) {
              LoggerBitacora.getInstance(LoggerCAE.class).logueadorMainero.log("un Mansaje", Priority.ERROR,
                                    "No se se encontro el archivo CAE respado - " + ex.toString() + " - " + ex.getMessage(), null);
        }
        return null;
    }

}
