/*
 * Decompiled with CFR 0_124.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.Layout
 */
package Proyecto.GestorArchivos;

import Proyecto.modelo.Permisos;
import Proyecto.modelo.Sucursal;
import Proyecto.modelo.Usuario;
import Proyecto.utilerias.Utilerias;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.Layout;
import org.apache.log4j.Priority;
import utiles.logger.LoggerBitacora;

public class GestorABuscaUsuarios {

    String usuarioArchivo = "pas.txt";

    public void guardar(Usuario[] user) {
        try {
            File file = new File(this.usuarioArchivo);
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < user.length; ++i) {
                int j;
                bw.write("usuarioNombre=" + user[i].getUsuarioNombre());
                bw.write(Layout.LINE_SEP);
                bw.write("pass=" + user[i].getPasss());
                bw.write(Layout.LINE_SEP);
                bw.write("iduser=" + user[i].getIdUser());
                for (j = 0; j < user[i].cantidadItemsSucursal(); ++j) {
                    this.guardarItem(user[i].mostrarItemSucursal(j).guardarEnArchivo(), bw);
                }
                for (j = 0; j < user[i].cantidadItemsPermisos(); ++j) {
                    this.guardarItem(user[i].mostrarItemPermisos(j).guardarEnArchivo(), bw);
                }
                bw.write(Layout.LINE_SEP);
            }
            bw.close();
        } catch (IOException ex) {
            LoggerBitacora.getInstance(GestorAConfiguracion.class).
                    logueadorMainero.log("un Mensaje", Priority.ERROR, 
                    "Error al guardar usuario", ex); 
            Logger.getLogger(GestorABuscaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void guardarItem(String[] paraItem, BufferedWriter bw) {
        for (int i = 0; i < paraItem.length; ++i) {
            try {
                bw.write(Layout.LINE_SEP);
                bw.write(paraItem[i]);
                continue;
            } catch (IOException ex) {
                LoggerBitacora.getInstance(GestorABuscaUsuarios.class).
                    logueadorMainero.log("un Mensaje", Priority.ERROR, 
                    "Error al guardar item", ex); 
                Logger.getLogger(GestorAConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Usuario[] traerUsuarios() {
        FileReader fr = null;
        String linea = null;
        ArrayList ussrs = new ArrayList();
        try {
            fr = new FileReader(this.usuarioArchivo);
            BufferedReader br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                if (esAlgunValorUsuario(linea)) {
                    if (esUsuario(linea)) {
                        Usuario user = new Usuario();
                        user.setUsuarioNombre(sacarValor(linea));
                        ussrs.add(user);
                    }
                    if (esPass(linea)) {
                        ((Usuario) ussrs.get(ussrs.size() - 1)).setPasss(sacarValor(linea));
                    }
                    if (esidUser(linea)) {
                        ((Usuario) ussrs.get(ussrs.size() - 1)).setIdUser(Long.valueOf(sacarValor(linea)).longValue());
                    }
                }
                if (esAlggunValorDeSucursal(linea)) {
                    if (esNumeroSuc(linea)) {
                        Sucursal suc = new Sucursal();
                        suc.setNumero(Integer.valueOf(sacarValor(linea)).intValue());
                        ((Usuario) ussrs.get(ussrs.size() - 1)).agregarItemSucursal(suc);
                    } else {
                        if (esNombreSuc(linea)) {
                            ((Usuario) ussrs.get(ussrs.size() - 1)).mostrarItemSucursal(((Usuario) ussrs.get(ussrs.size() - 1)).cantidadItemsSucursal() - 1).setDescripcion(sacarValor(linea));
                        }
                        if (esBonoFiscal(linea)) {
                            ((Usuario) ussrs.get(ussrs.size() - 1)).mostrarItemSucursal(((Usuario) ussrs.get(ussrs.size() - 1)).cantidadItemsSucursal() - 1).setEsBonosFiscales(pasarStringABoolean(sacarValor(linea)));
                        }
                    }
                }
                if (esAlggunValorDePermisos(linea)) {
                    if (esPermisoPuerta(linea)) {
                        Permisos per = new Permisos();
                        per.setPermisosPuerta(sacarValor(linea));
                        ((Usuario) ussrs.get(ussrs.size() - 1)).agregarItemPermisos(per);
                    } else if (esPermisoNombre(linea)) {
                        ((Usuario) ussrs.get(ussrs.size() - 1)).mostrarItemPermisos(((Usuario) ussrs.get(ussrs.size() - 1)).cantidadItemsPermisos() - 1).setPermisosNombre(sacarValor(linea));
                    }

                }

            }

            try {
                fr.close();
                return Utilerias.pasarObjetoAUsuario(ussrs.toArray());
            } catch (IOException ex1) {
                LoggerBitacora.getInstance(GestorABuscaUsuarios.class).
                    logueadorMainero.log("un Mensaje", Priority.ERROR, 
                    "Error al traer usuarios", ex1); 
                Logger.getLogger(GestorAConfiguracion.class.getName()).log(Level.SEVERE, null, ex1);
                return Utilerias.pasarObjetoAUsuario(ussrs.toArray());
            }
        } catch (IOException ex2) {
            LoggerBitacora.getInstance(GestorABuscaUsuarios.class).
                    logueadorMainero.log("un Mensaje", Priority.ERROR, 
                    "Error al traer usuarios", ex2); 
            Logger.getLogger(GestorAConfiguracion.class.getName()).log(Level.SEVERE, null, ex2);
            try {
                fr.close();
                return Utilerias.pasarObjetoAUsuario(ussrs.toArray());
            } catch (IOException ex3) {
                LoggerBitacora.getInstance(GestorABuscaUsuarios.class).
                    logueadorMainero.log("un Mensaje", Priority.ERROR, 
                    "Error al traer usuarios", ex3); 
                Logger.getLogger(GestorAConfiguracion.class.getName()).log(Level.SEVERE, null, ex3);
                return Utilerias.pasarObjetoAUsuario(ussrs.toArray());
            }
        } finally {
            try {
                fr.close();
                return Utilerias.pasarObjetoAUsuario(ussrs.toArray());
            } catch (IOException ex) {
                LoggerBitacora.getInstance(GestorABuscaUsuarios.class).
                    logueadorMainero.log("un Mensaje", Priority.ERROR, 
                    "Error al traer usuarios", ex); 
                Logger.getLogger(GestorAConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private boolean esAlggunValorDeSucursal(String linea) {
        return this.esBonoFiscal(linea) || this.esNombreSuc(linea) || this.esNumeroSuc(linea);
    }

    private boolean esAlggunValorDePermisos(String linea) {
        return this.esPermisoNombre(linea) || this.esPermisoPuerta(linea);
    }

    private boolean esAlgunValorUsuario(String linea) {
        return !this.esAlggunValorDeSucursal(linea) && !this.esAlggunValorDePermisos(linea);
    }

    private boolean esBonoFiscal(String linea) {
        return linea.contains("esBonoFiscal");
    }

    private boolean esNombreSuc(String linea) {
        return linea.contains("nombreSuc");
    }

    private boolean esNumeroSuc(String linea) {
        return linea.contains("numeroSuc");
    }

    private boolean esPermisoPuerta(String linea) {
        return linea.contains("puerta");
    }

    private boolean esPermisoNombre(String linea) {
        return linea.contains("permisoNombre");
    }

    public boolean esUsuario(String linea) {
        return linea.contains("usuarioNombre");
    }

    public boolean esPass(String linea) {
        return linea.contains("pass");
    }

    public boolean esidUser(String linea) {
        return linea.contains("iduser");
    }

    private String sacarValor(String linea) {
        return linea.substring(linea.indexOf("=") + 1);
    }

    private boolean pasarStringABoolean(String bonos) {
        return bonos.contains("true");
    }
}
