/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.mainerofacturero.pantalla;

import Proyecto.GestorPantallas.GestorPrincipal;
import Proyecto.modelo.Usuario;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.GroupLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import utiles.logger.LoggerBitacora;
import utiles.logger.LoggerCAE;

public class FPrincipal
extends JFrame {
    GestorPrincipal gestor;
    private JDesktopPane escritorio;
    private JMenuBar jMenuBar1;
    private JMenuItem menI_buscaLlavesWFE;
    private JMenuItem menI_buscarComprobante;
    private JMenuItem menI_configuracion;
    private JMenuItem menI_facturar;
    private JMenuItem menI_nombreProductos;
    private JMenuItem menI_pruebaConsultaWBFE;
    private JMenuItem menI_pruebaConsultaWFE;
    private JMenuItem menI_puntosVentasValidos;
    private JMenuItem menI_tiposDoc;
    private JMenuItem menI_tiposIVA;
    private JMenuItem menI_tiposMoneda;
    private JMenuItem menI_tiposTributos;
    private JMenuItem menI_ultimoComprobante;
    private JMenuItem menI_ultimoID;
    private JMenuItem menI_usuarios;
    private JMenuItem menI_wsbfe;
    private JMenu men_Wbsfe;
    private JMenu men_Wsfe;
    private JMenu men_afip;
    private JMenu men_archivo;
    private JMenu men_facturar;
    private JMenu men_generales;

    public FPrincipal() {
        this.initComponents();
    }

    private void initComponents() {
        this.escritorio = new JDesktopPane();
        this.jMenuBar1 = new JMenuBar();
        this.men_archivo = new JMenu();
        this.menI_configuracion = new JMenuItem();
        this.menI_usuarios = new JMenuItem();
        this.men_facturar = new JMenu();
        this.menI_facturar = new JMenuItem();
        this.men_afip = new JMenu();
        this.men_generales = new JMenu();
        this.menI_buscaLlavesWFE = new JMenuItem();
        this.menI_wsbfe = new JMenuItem();
        this.menI_buscarComprobante = new JMenuItem();
        this.menI_ultimoComprobante = new JMenuItem();
        this.men_Wsfe = new JMenu();
        this.menI_pruebaConsultaWFE = new JMenuItem();
        this.menI_puntosVentasValidos = new JMenuItem();
        this.menI_tiposDoc = new JMenuItem();
        this.menI_tiposIVA = new JMenuItem();
        this.menI_tiposMoneda = new JMenuItem();
        this.menI_tiposTributos = new JMenuItem();
        this.men_Wbsfe = new JMenu();
        this.menI_pruebaConsultaWBFE = new JMenuItem();
        this.menI_ultimoID = new JMenuItem();
        this.menI_nombreProductos = new JMenuItem();
        this.setDefaultCloseOperation(3);
        this.addComponentListener(new ComponentAdapter(){

            @Override
            public void componentShown(ComponentEvent evt) {
                FPrincipal.this.formComponentShown(evt);
            }
        });
        this.men_archivo.setText("Archivo");
        this.menI_configuracion.setText("Configuracion");
        this.menI_configuracion.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FPrincipal.this.menI_configuracionActionPerformed(evt);
            }
        });
        this.men_archivo.add(this.menI_configuracion);
        this.menI_usuarios.setText("Usuarios");
        this.menI_usuarios.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FPrincipal.this.menI_usuariosActionPerformed(evt);
            }
        });
        this.men_archivo.add(this.menI_usuarios);
        this.jMenuBar1.add(this.men_archivo);
        this.men_facturar.setText("Factura");
        this.menI_facturar.setText("Transferir Afip");
        this.menI_facturar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FPrincipal.this.menI_facturarActionPerformed(evt);
            }
        });
        this.men_facturar.add(this.menI_facturar);
        this.jMenuBar1.add(this.men_facturar);
        this.men_afip.setText("Afip");
        this.men_generales.setText("Generales");
        this.menI_buscaLlavesWFE.setText("Buscar Llaves");
        this.menI_buscaLlavesWFE.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FPrincipal.this.menI_buscaLlavesWFEActionPerformed(evt);
            }
        });
        this.men_generales.add(this.menI_buscaLlavesWFE);
        this.menI_wsbfe.setText("Buscar Comprobantes Validos");
        this.menI_wsbfe.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FPrincipal.this.menI_wsbfeActionPerformed(evt);
            }
        });
        this.men_generales.add(this.menI_wsbfe);
        this.menI_buscarComprobante.setText("Busca Comprobante");
        this.menI_buscarComprobante.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FPrincipal.this.menI_buscarComprobanteActionPerformed(evt);
            }
        });
        this.men_generales.add(this.menI_buscarComprobante);
        this.menI_ultimoComprobante.setText("Ultimo Comprobante");
        this.menI_ultimoComprobante.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FPrincipal.this.menI_ultimoComprobanteActionPerformed(evt);
            }
        });
        this.men_generales.add(this.menI_ultimoComprobante);
        this.men_afip.add(this.men_generales);
        this.men_Wsfe.setText("WSFE");
        this.menI_pruebaConsultaWFE.setText("Prueba Conexion");
        this.menI_pruebaConsultaWFE.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FPrincipal.this.menI_pruebaConsultaWFEActionPerformed(evt);
            }
        });
        this.men_Wsfe.add(this.menI_pruebaConsultaWFE);
        this.menI_puntosVentasValidos.setText("Puntos de Ventas Validos");
        this.menI_puntosVentasValidos.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FPrincipal.this.menI_puntosVentasValidosActionPerformed(evt);
            }
        });
        this.men_Wsfe.add(this.menI_puntosVentasValidos);
        this.menI_tiposDoc.setText("Tipos Doc.");
        this.menI_tiposDoc.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FPrincipal.this.menI_tiposDocActionPerformed(evt);
            }
        });
        this.men_Wsfe.add(this.menI_tiposDoc);
        this.menI_tiposIVA.setText("Tipos IVA");
        this.menI_tiposIVA.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FPrincipal.this.menI_tiposIVAActionPerformed(evt);
            }
        });
        this.men_Wsfe.add(this.menI_tiposIVA);
        this.menI_tiposMoneda.setText("Tipos Moneda");
        this.menI_tiposMoneda.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FPrincipal.this.menI_tiposMonedaActionPerformed(evt);
            }
        });
        this.men_Wsfe.add(this.menI_tiposMoneda);
        this.menI_tiposTributos.setText("Tipos Tributos");
        this.menI_tiposTributos.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FPrincipal.this.menI_tiposTributosActionPerformed(evt);
            }
        });
        this.men_Wsfe.add(this.menI_tiposTributos);
        this.men_afip.add(this.men_Wsfe);
        this.men_Wbsfe.setText("WSBFE");
        this.menI_pruebaConsultaWBFE.setText("Prueba Conexion");
        this.menI_pruebaConsultaWBFE.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FPrincipal.this.menI_pruebaConsultaWBFEActionPerformed(evt);
            }
        });
        this.men_Wbsfe.add(this.menI_pruebaConsultaWBFE);
        this.menI_ultimoID.setText("Ultimo ID");
        this.menI_ultimoID.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FPrincipal.this.menI_ultimoIDActionPerformed(evt);
            }
        });
        this.men_Wbsfe.add(this.menI_ultimoID);
        this.menI_nombreProductos.setText("Nomencladores Productos");
        this.menI_nombreProductos.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FPrincipal.this.menI_nombreProductosActionPerformed(evt);
            }
        });
        this.men_Wbsfe.add(this.menI_nombreProductos);
        this.men_afip.add(this.men_Wbsfe);
        this.jMenuBar1.add(this.men_afip);
        this.setJMenuBar(this.jMenuBar1);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.escritorio, -1, 647, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.escritorio, -1, 405, 32767));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((screenSize.width - 663) / 2, (screenSize.height - 464) / 2, 663, 464);
    }

    public void tomarUsuario(Usuario user) {
        LoggerBitacora.setNombreUsuarioLogueado(user.getUsuarioNombre());
        LoggerCAE.setNombreUsuarioLogueado(user.getUsuarioNombre());
        this.gestor = new GestorPrincipal(this.escritorio, user);
    }

    private void cargarPantallaSegunPermisos() {
        if (!this.gestor.estaHabilitadoPermisoAdministrador()) {
            this.men_archivo.setVisible(false);
        }
        if (!this.gestor.estaHaHabilitadoPermisoFacturarFacturar()) {
            this.menI_facturar.setVisible(false);
        }
        if (!this.gestor.estaHabilitadoPermisoConsultarVariasAfip()) {
            this.men_afip.setVisible(false);
        }
    }

    private void menI_configuracionActionPerformed(ActionEvent evt) {
        this.gestor.llamarConfiguracion();
    }

    private void menI_pruebaConsultaWBFEActionPerformed(ActionEvent evt) {
        this.gestor.llamarComprobacionServidorWBFE();
    }

    private void menI_buscaLlavesWFEActionPerformed(ActionEvent evt) {
        this.gestor.buscarLlaves();
    }

    private void menI_wsbfeActionPerformed(ActionEvent evt) {
        this.gestor.llamarComprobantesValidos();
    }

    private void menI_buscarComprobanteActionPerformed(ActionEvent evt) {
        this.gestor.llamarBuscarComprobantes();
    }

    private void menI_ultimoComprobanteActionPerformed(ActionEvent evt) {
        this.gestor.llamarBuscarUltimoComprobante();
    }

    private void menI_tiposTributosActionPerformed(ActionEvent evt) {
        this.gestor.llamarTiposTributos();
    }

    private void menI_tiposMonedaActionPerformed(ActionEvent evt) {
        this.gestor.llamarTiposMoneda();
    }

    private void menI_tiposIVAActionPerformed(ActionEvent evt) {
        this.gestor.llamarTiposIVa();
    }

    private void menI_tiposDocActionPerformed(ActionEvent evt) {
        this.gestor.llamarTiposDOC();
    }

    private void menI_puntosVentasValidosActionPerformed(ActionEvent evt) {
        this.gestor.buscarPuntosVentasValidos();
    }

    private void menI_pruebaConsultaWFEActionPerformed(ActionEvent evt) {
        this.gestor.llamarComprobacionServidorWFE();
    }

    private void menI_ultimoIDActionPerformed(ActionEvent evt) {
        this.gestor.buscarUltimoID();
    }

    private void menI_nombreProductosActionPerformed(ActionEvent evt) {
        this.gestor.buscarNomencaldores();
    }

    private void menI_facturarActionPerformed(ActionEvent evt) {
        this.gestor.llamarFacturar();
    }

    private void menI_usuariosActionPerformed(ActionEvent evt) {
        this.gestor.llamarUsuarios();
    }

    private void formComponentShown(ComponentEvent evt) {
        this.cargarPantallaSegunPermisos();
    }

}

