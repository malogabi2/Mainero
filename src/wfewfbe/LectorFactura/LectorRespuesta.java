/*
 * Decompiled with CFR 0_124.
 * 
 * Could not load the following classes:
 *  org.dom4j.Document
 *  org.dom4j.DocumentException
 *  org.dom4j.Element
 *  org.dom4j.io.SAXReader
 *  org.dom4j.tree.DefaultElement
 *  org.dom4j.tree.DefaultText
 */
package wfewfbe.LectorFactura;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.Priority;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.DefaultElement;
import org.dom4j.tree.DefaultText;
import utiles.MensajeError;
import utiles.logger.LoggerBitacora;

public class LectorRespuesta {
    private String[] camposRespuesta;
    private ArrayList camposResul = new ArrayList();
    private ArrayList valoresResul = new ArrayList();
    private ArrayList resultado = new ArrayList();
    private MensajeError err;

    public LectorRespuesta(MensajeError error) {
        this.err = error;
    }

    public void setCamposNecesarios(String[] camposR) {
        this.camposRespuesta = camposR;
    }

    public String[] getParametros(String respuesta, boolean esFactura) {
        StringReader tokenReader = new StringReader(respuesta);
        Document doc = null;
        this.resultado.add(respuesta);
        try {
            doc = new SAXReader(false).read((Reader)tokenReader);
        }
        catch (DocumentException ex) {
            LoggerBitacora.getInstance(LectorRespuesta.class).logueadorMainero.log("un Mensaje", Priority.ERROR,
                        "Error al el leer el parametros de respuesta", ex);
            
            Logger.getLogger(LectorRespuesta.class.getName()).log(Level.SEVERE, null, (Throwable)ex);
        }
        Element el = doc.getRootElement();
        Iterator it = el.nodeIterator();
        Date dt = new Date();
        this.err.addMensajeError("" + dt.getHours() + ":" + dt.getMinutes() + ":" + dt.getSeconds() + " empiezo a armar Arbol ...  LectorRespuesta.getParametro()");
        this.recorreArbol(it, esFactura);
        if (esFactura) {
            this.armoRepuestaFacturacion();
        } else {
            this.armoRepuestaNoFacturacion();
        }
        dt = new Date();
        this.err.addMensajeError("" + dt.getHours() + ":" + dt.getMinutes() + ":" + dt.getSeconds() + "  termine de armar Arbol ... hojas:" + this.resultado.size() + " ..  LectorRespuesta.getParametro()");
        return this.pasoObjetosAString(this.resultado.toArray());
    }

    private String[] pasoObjetosAString(Object[] objetos) {
        String[] aux = new String[objetos.length];
        for (int i = 0; i < objetos.length; ++i) {
            aux[i] = objetos[i].toString();
        }
        Date dt = new Date();
        this.err.addMensajeError("" + dt.getHours() + ":" + dt.getMinutes() + ":" + dt.getSeconds() + " termine de darle formato a las hojas del Arbol ... hojas:" + objetos.length + " ..  LectorRespuesta.getParametro()");
        return aux;
    }

    private void recorreArbol(Iterator it, boolean esFacturar) {
        while (it.hasNext()) {
            Object ob = it.next();
            if (ob instanceof DefaultElement) {
                DefaultElement df = (DefaultElement)ob;
                List ele = df.content();
                this.recorreArbol(ele.iterator(), esFacturar);
                continue;
            }
            if (!(ob instanceof DefaultText)) continue;
            DefaultText de = (DefaultText)ob;
            if (esFacturar) {
                if (!this.filtrado(de.getParent().getName())) continue;
                this.getCamposResul().add(de.getParent().getName());
                this.getValoresResul().add(de.getText());
                continue;
            }
            this.getCamposResul().add(de.getParent().getName());
            this.getValoresResul().add(de.getText());
        }
    }

    private boolean filtrado(String campoResultado) {
        for (int i = 0; i < this.camposRespuesta.length; ++i) {
            if (!this.camposRespuesta[i].equals(campoResultado)) continue;
            return true;
        }
        return false;
    }

    private void armoRepuestaFacturacion() {
        for (int i = 0; i < this.camposRespuesta.length; ++i) {
            boolean encotro = false;
            for (int j = 0; j < this.getCamposResul().size(); ++j) {
                if (!this.camposRespuesta[i].equals(this.getCamposResul().get(j))) continue;
                this.resultado.add(this.camposRespuesta[i] + "=" + this.getValoresResul().get(j));
                encotro = true;
            }
            if (encotro) continue;
            this.resultado.add(this.camposRespuesta[i] + "=");
        }
    }

    private void armoRepuestaNoFacturacion() {
        for (int i = 0; i < this.getCamposResul().size(); ++i) {
            this.resultado.add(this.getCamposResul().get(i) + "=" + this.getValoresResul().get(i));
        }
    }

    public ArrayList getCamposResul() {
        return this.camposResul;
    }

    public ArrayList getValoresResul() {
        return this.valoresResul;
    }
}

