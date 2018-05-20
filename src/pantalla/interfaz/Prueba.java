/*
 * Decompiled with CFR 0_124.
 */
package pantalla.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Priority;
import todojuntowsawfe.ItemsBFE;
import todojuntowsawfe.Salida;
import todojuntowsawfe.SalidaBFE;
import todojuntowsawfe.SalidaFE;
import utiles.MensajeError;
import utiles.Util;
import utiles.logger.LoggerBitacora;
import wfewfbe.pantalla.gestor.GestorPrueba;

public class Prueba
extends JFrame {
    MensajeError err;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JLabel lbl_caeVencimiento;
    private JLabel lbl_caeVencimiento1;
    private JLabel lbl_caeVencimiento2;
    private JLabel lbl_caeVencimiento4;
    private JLabel lbl_caeVencimiento5;
    private JLabel lbl_caeVencimiento6;
    private JLabel lbl_caeVencimiento7;
    private JLabel lbl_caeVencimiento8;
    private JLabel lbl_cuitCliente;
    private JLabel lbl_cuitCliente1;
    private JLabel lbl_fechaCompro;
    private JLabel lbl_fechaCompro1;
    private JLabel lbl_impEx;
    private JLabel lbl_imporTotal;
    private JLabel lbl_imporTotalImpu;
    private JLabel lbl_imporTotalIva;
    private JLabel lbl_nroCae;
    private JLabel lbl_nroCae1;
    private JLabel lbl_nroCae2;
    private JLabel lbl_nroCae3;
    private JLabel lbl_nroCae4;
    private JLabel lbl_nroCae5;
    private JLabel lbl_numeroCompro;
    private JLabel lbl_numeroCompro1;
    private JLabel lbl_sucursalCompro;
    private JLabel lbl_sucursalCompro1;
    private JLabel lbl_tipoCompro;
    private JLabel lbl_tipoCompro1;
    private JLabel lbl_tipoCompro2;
    private JLabel lbl_totalNeto;
    private JTabbedPane pesa_pantalla;
    private JPanel pnl_InformeRespuesta;
    private JTextPane preguntaXML;
    private JTextArea respuesta;
    private JTextPane respuestaXML;
    private JTable tbl_tablitaItemsBFE;
    private JTextField txt_CaeVencimiento;
    private JTextField txt_CaeVencimientoBFE;
    private JTextField txt_ImpConNoNetoBFE;
    private JTextField txt_ImpExBFE;
    private JTextField txt_ImpIIBBBFE;
    private JTextField txt_ImpInterBFE;
    private JTextField txt_ImpNetoBFE;
    private JTextField txt_ImpPercMunBFE;
    private JTextField txt_ImpPerceBFE;
    private JTextField txt_ImpTotalBFE;
    private JTextField txt_cuitCliente;
    private JTextField txt_cuitClienteBFE;
    private JTextField txt_fecha;
    private JTextField txt_fechaBFE;
    private JTextField txt_id;
    private JTextField txt_impTotal;
    private JTextField txt_imporEx;
    private JTextField txt_imporIva;
    private JTextField txt_imporNeto;
    private JTextField txt_imporTrib;
    private JTextField txt_numero;
    private JTextField txt_numeroBFE;
    private JTextField txt_numeroCae;
    private JTextField txt_numeroCaeBFE;
    private JTextField txt_obsBFE;
    private JTextField txt_resultadoBFE;
    private JTextField txt_sucursal;
    private JTextField txt_sucursalBFE;
    private JTextField txt_tipoCompro;
    private JTextField txt_tipoComproBFE;

    public Prueba(MensajeError error) {
        this.initComponents();
        this.err = error;
    }

    public void pruebaToken(String[] parametros, String archivoRepuesta) {
        this.respuestaXML.setText("Token " + parametros[0] + "\nSign: " + parametros[1]);
        this.preguntaXML.setText(parametros[4]);
        this.pesa_pantalla.remove(0);
        this.pesa_pantalla.remove(0);
        this.pesa_pantalla.remove(0);
        GestorPrueba gp = new GestorPrueba(this.err);
        gp.escribir(archivoRepuesta, new String[]{"Token=" + parametros[0], "Sign=" + parametros[1], "Vencimiento=" + parametros[2], "Respuesta=" + parametros[3], "Pregunta=" + parametros[4]});
    }

    public void pruebaMensaje(String repuesta, String pregunta, String archivorespuesta, boolean esConsulta, String servicio) {
        Date dt = new Date();
        System.out.println(dt + " entro a pantalla de muestra... Prueba.pruebaMensaje()");
        LoggerBitacora.getInstance(Prueba.class).logueadorMainero.log("un Mensaje", Priority.INFO,
                                "Respuesta: " + repuesta + " Pregunta: " + pregunta , null);
            
        this.respuestaXML.setText("Respuesta: " + repuesta);
        this.preguntaXML.setText("Pregunta: " + pregunta);
        GestorPrueba gp = new GestorPrueba(this.err);
        this.respuesta.setText(this.concatenarString(gp.resultadoSinXML(repuesta)));
        this.repuestaInforme(repuesta, esConsulta, servicio);
        gp.escribir(archivorespuesta, new String[]{"Respuesta: " + repuesta, " "});
        this.repaint();
    }

    private void repuestaInforme(String respuesta, boolean esConsulta, String servicio) {
        Salida sal;
        this.mostrarResultadoInforme(esConsulta, servicio);
        GestorPrueba gp = new GestorPrueba(this.err);
        if (esConsulta && !(sal = gp.armarResultadoInforme(respuesta, esConsulta, this, servicio)).esError()) {
            if (servicio.equals("wfe")) {
                this.llenarInformeFE((SalidaFE)sal);
            } else {
                this.llenarInformeBFE((SalidaBFE)sal);
            }
        }
    }

    private void mostrarResultadoInforme(boolean opcion, String servicio) {
        if (opcion) {
            if (servicio.equals("wfe")) {
                this.pesa_pantalla.remove(1);
            } else {
                this.pesa_pantalla.remove(0);
            }
        } else {
            this.pesa_pantalla.remove(0);
            this.pesa_pantalla.remove(0);
        }
    }

    private void llenarInformeBFE(SalidaBFE salida) {
        this.txt_numeroCaeBFE.setText(salida.getCae());
        this.txt_numeroBFE.setText(salida.getCbte_nro());
        this.txt_cuitClienteBFE.setText(salida.getNro_doc());
        this.txt_CaeVencimientoBFE.setText(salida.getFch_venc_Cae());
        this.txt_fechaBFE.setText(salida.getFecha_cbte_orig());
        this.txt_id.setText(salida.getId());
        this.txt_ImpIIBBBFE.setText(salida.getImp_iibb());
        this.txt_ImpInterBFE.setText(salida.getImp_internos());
        this.txt_ImpNetoBFE.setText(salida.getImp_neto());
        this.txt_ImpExBFE.setText(salida.getImp_op_ex());
        this.txt_ImpPerceBFE.setText(salida.getImp_perc());
        this.txt_ImpPercMunBFE.setText(salida.getImp_perc_mun());
        this.txt_ImpConNoNetoBFE.setText(salida.getImp_tot_conc());
        this.txt_ImpTotalBFE.setText(salida.getImp_total());
        this.txt_obsBFE.setText(salida.getObs());
        this.txt_sucursalBFE.setText(salida.getPunto_vta());
        this.txt_resultadoBFE.setText(salida.getResultado());
        this.txt_tipoComproBFE.setText(salida.getTipo_cbte());
        this.tbl_tablitaItemsBFE.setModel(this.llenarItems(salida.getItems()));
    }

    private DefaultTableModel llenarItems(ArrayList<ItemsBFE> itms) {
        ItemsBFE it = new ItemsBFE();
        return new DefaultTableModel(this.llevarModelosATablas(this.pasarObjetoAModelos(itms.toArray())), it.nombreColumnas());
    }

    private ItemsBFE[] pasarObjetoAModelos(Object[] objetos) {
        ItemsBFE[] aux = new ItemsBFE[objetos.length];
        for (int i = 0; i < objetos.length; ++i) {
            aux[i] = (ItemsBFE)objetos[i];
        }
        return aux;
    }

    private Object[][] llevarModelosATablas(ItemsBFE[] modelos) {
        Object[][] aux = new Object[modelos.length][modelos[0].mostrarFila().length];
        for (int i = 0; i < modelos[0].mostrarFila().length; ++i) {
            for (int j = 0; j < modelos.length; ++j) {
                aux[j][i] = modelos[j].mostrarFila()[i];
            }
        }
        return aux;
    }

    private void llenarInformeFE(SalidaFE salida) {
        this.txt_CaeVencimiento.setText(salida.getFchVto());
        this.txt_cuitCliente.setText(salida.getNroCuit());
        this.txt_numeroCae.setText(salida.getCaeNro());
        this.txt_imporEx.setText(salida.getImpEx());
        this.txt_imporIva.setText(salida.getImpIVA());
        this.txt_imporNeto.setText(salida.getImpNeto());
        this.txt_imporTrib.setText(salida.getImpTrib());
        this.txt_tipoCompro.setText(salida.getCbteTipo());
        this.txt_numero.setText(salida.getNumeroComprobante());
        this.txt_sucursal.setText(salida.getSucursal());
        this.txt_fecha.setText(salida.getFechaComprobante());
        this.txt_impTotal.setText(salida.getImpTotal());
    }

    private String concatenarString(String[] mensaje) {
        return Util.concatenarString(mensaje);
    }

    private void initComponents() {
        this.pesa_pantalla = new JTabbedPane();
        this.pnl_InformeRespuesta = new JPanel();
        this.jPanel2 = new JPanel();
        this.lbl_tipoCompro = new JLabel();
        this.lbl_sucursalCompro = new JLabel();
        this.lbl_numeroCompro = new JLabel();
        this.lbl_fechaCompro = new JLabel();
        this.txt_tipoCompro = new JTextField();
        this.txt_fecha = new JTextField();
        this.txt_sucursal = new JTextField();
        this.txt_numero = new JTextField();
        this.jPanel3 = new JPanel();
        this.lbl_cuitCliente = new JLabel();
        this.lbl_nroCae = new JLabel();
        this.lbl_caeVencimiento = new JLabel();
        this.txt_cuitCliente = new JTextField();
        this.txt_numeroCae = new JTextField();
        this.txt_CaeVencimiento = new JTextField();
        this.jPanel4 = new JPanel();
        this.lbl_imporTotalIva = new JLabel();
        this.lbl_imporTotalImpu = new JLabel();
        this.lbl_totalNeto = new JLabel();
        this.lbl_impEx = new JLabel();
        this.txt_imporEx = new JTextField();
        this.txt_imporTrib = new JTextField();
        this.txt_imporNeto = new JTextField();
        this.txt_imporIva = new JTextField();
        this.jPanel5 = new JPanel();
        this.lbl_imporTotal = new JLabel();
        this.txt_impTotal = new JTextField();
        this.jPanel1 = new JPanel();
        this.jPanel6 = new JPanel();
        this.lbl_tipoCompro1 = new JLabel();
        this.lbl_sucursalCompro1 = new JLabel();
        this.lbl_numeroCompro1 = new JLabel();
        this.lbl_fechaCompro1 = new JLabel();
        this.txt_id = new JTextField();
        this.txt_fechaBFE = new JTextField();
        this.txt_sucursalBFE = new JTextField();
        this.txt_numeroBFE = new JTextField();
        this.txt_tipoComproBFE = new JTextField();
        this.lbl_tipoCompro2 = new JLabel();
        this.lbl_cuitCliente1 = new JLabel();
        this.txt_cuitClienteBFE = new JTextField();
        this.jPanel7 = new JPanel();
        this.lbl_nroCae1 = new JLabel();
        this.lbl_caeVencimiento1 = new JLabel();
        this.txt_ImpConNoNetoBFE = new JTextField();
        this.txt_ImpNetoBFE = new JTextField();
        this.lbl_caeVencimiento2 = new JLabel();
        this.txt_ImpExBFE = new JTextField();
        this.txt_ImpInterBFE = new JTextField();
        this.lbl_caeVencimiento4 = new JLabel();
        this.jPanel8 = new JPanel();
        this.lbl_nroCae2 = new JLabel();
        this.lbl_caeVencimiento5 = new JLabel();
        this.txt_numeroCaeBFE = new JTextField();
        this.txt_CaeVencimientoBFE = new JTextField();
        this.lbl_caeVencimiento6 = new JLabel();
        this.txt_resultadoBFE = new JTextField();
        this.lbl_caeVencimiento7 = new JLabel();
        this.txt_obsBFE = new JTextField();
        this.txt_ImpTotalBFE = new JTextField();
        this.lbl_caeVencimiento8 = new JLabel();
        this.jPanel9 = new JPanel();
        this.lbl_nroCae3 = new JLabel();
        this.txt_ImpPerceBFE = new JTextField();
        this.lbl_nroCae4 = new JLabel();
        this.txt_ImpIIBBBFE = new JTextField();
        this.lbl_nroCae5 = new JLabel();
        this.txt_ImpPercMunBFE = new JTextField();
        this.jScrollPane3 = new JScrollPane();
        this.tbl_tablitaItemsBFE = new JTable();
        this.jScrollPane4 = new JScrollPane();
        this.respuesta = new JTextArea();
        this.jScrollPane2 = new JScrollPane();
        this.preguntaXML = new JTextPane();
        this.jScrollPane1 = new JScrollPane();
        this.respuestaXML = new JTextPane();
        this.setDefaultCloseOperation(2);
        this.pnl_InformeRespuesta.setOpaque(false);
        this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
        this.lbl_tipoCompro.setFont(new Font("Arial", 1, 12));
        this.lbl_tipoCompro.setText("Tipo Comprobante:");
        this.lbl_sucursalCompro.setFont(new Font("Arial", 1, 12));
        this.lbl_sucursalCompro.setText("Sucursal:");
        this.lbl_numeroCompro.setFont(new Font("Arial", 1, 12));
        this.lbl_numeroCompro.setText("Numero:");
        this.lbl_fechaCompro.setFont(new Font("Arial", 1, 12));
        this.lbl_fechaCompro.setText("Fecha:");
        this.txt_tipoCompro.setFont(new Font("Tahoma", 1, 12));
        this.txt_tipoCompro.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_tipoCompro.setEnabled(false);
        this.txt_tipoCompro.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_tipoComproActionPerformed(evt);
            }
        });
        this.txt_fecha.setFont(new Font("Tahoma", 1, 12));
        this.txt_fecha.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_fecha.setEnabled(false);
        this.txt_fecha.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_fechaActionPerformed(evt);
            }
        });
        this.txt_sucursal.setFont(new Font("Tahoma", 1, 12));
        this.txt_sucursal.setHorizontalAlignment(4);
        this.txt_sucursal.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_sucursal.setEnabled(false);
        this.txt_sucursal.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_sucursalActionPerformed(evt);
            }
        });
        this.txt_numero.setFont(new Font("Tahoma", 1, 12));
        this.txt_numero.setHorizontalAlignment(4);
        this.txt_numero.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_numero.setEnabled(false);
        this.txt_numero.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_numeroActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.lbl_tipoCompro).addGap(18, 18, 18).addComponent(this.txt_tipoCompro, -2, 138, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 47, 32767).addComponent(this.lbl_fechaCompro).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txt_fecha, -2, 115, -2).addGap(53, 53, 53).addComponent(this.lbl_sucursalCompro).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_sucursal, -2, 51, -2).addGap(58, 58, 58).addComponent(this.lbl_numeroCompro).addGap(18, 18, 18).addComponent(this.txt_numero, -2, 108, -2).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lbl_tipoCompro).addComponent(this.txt_numero, -2, -1, -2).addComponent(this.lbl_numeroCompro).addComponent(this.txt_tipoCompro, -2, 21, -2).addComponent(this.lbl_fechaCompro).addComponent(this.txt_fecha, -2, -1, -2).addComponent(this.lbl_sucursalCompro).addComponent(this.txt_sucursal, -2, -1, -2)).addContainerGap()));
        this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
        this.lbl_cuitCliente.setFont(new Font("Arial", 1, 12));
        this.lbl_cuitCliente.setText("Cuit Cliente:");
        this.lbl_nroCae.setFont(new Font("Arial", 1, 12));
        this.lbl_nroCae.setText("Numero CAE:");
        this.lbl_caeVencimiento.setFont(new Font("Arial", 1, 12));
        this.lbl_caeVencimiento.setText("Fecha CAE Vencimiento:");
        this.txt_cuitCliente.setFont(new Font("Tahoma", 1, 12));
        this.txt_cuitCliente.setHorizontalAlignment(4);
        this.txt_cuitCliente.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_cuitCliente.setEnabled(false);
        this.txt_cuitCliente.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_cuitClienteActionPerformed(evt);
            }
        });
        this.txt_numeroCae.setFont(new Font("Tahoma", 1, 12));
        this.txt_numeroCae.setHorizontalAlignment(4);
        this.txt_numeroCae.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_numeroCae.setEnabled(false);
        this.txt_numeroCae.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_numeroCaeActionPerformed(evt);
            }
        });
        this.txt_CaeVencimiento.setFont(new Font("Tahoma", 1, 12));
        this.txt_CaeVencimiento.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_CaeVencimiento.setEnabled(false);
        this.txt_CaeVencimiento.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_CaeVencimientoActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.lbl_cuitCliente).addGap(14, 14, 14).addComponent(this.txt_cuitCliente, -2, 125, -2).addGap(46, 46, 46).addComponent(this.lbl_nroCae).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_numeroCae, -2, 167, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 40, 32767).addComponent(this.lbl_caeVencimiento).addGap(50, 50, 50).addComponent(this.txt_CaeVencimiento, -2, 142, -2).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txt_cuitCliente, -2, 21, -2).addComponent(this.lbl_cuitCliente).addComponent(this.lbl_caeVencimiento).addComponent(this.txt_numeroCae, -2, 21, -2).addComponent(this.lbl_nroCae).addComponent(this.txt_CaeVencimiento, -2, 21, -2)).addContainerGap(-1, 32767)));
        this.jPanel4.setBorder(BorderFactory.createEtchedBorder());
        this.lbl_imporTotalIva.setFont(new Font("Arial", 1, 12));
        this.lbl_imporTotalIva.setText("Imp. Tot. Iva:");
        this.lbl_imporTotalImpu.setFont(new Font("Arial", 1, 12));
        this.lbl_imporTotalImpu.setText("Imp Tot. Imp.:");
        this.lbl_totalNeto.setFont(new Font("Arial", 1, 12));
        this.lbl_totalNeto.setText("Imp. Tot. Neto:");
        this.lbl_impEx.setFont(new Font("Arial", 1, 12));
        this.lbl_impEx.setText("Imp Total Exento:");
        this.txt_imporEx.setFont(new Font("Tahoma", 1, 12));
        this.txt_imporEx.setHorizontalAlignment(4);
        this.txt_imporEx.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_imporEx.setEnabled(false);
        this.txt_imporEx.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_imporExActionPerformed(evt);
            }
        });
        this.txt_imporTrib.setFont(new Font("Tahoma", 1, 12));
        this.txt_imporTrib.setHorizontalAlignment(4);
        this.txt_imporTrib.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_imporTrib.setEnabled(false);
        this.txt_imporTrib.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_imporTribActionPerformed(evt);
            }
        });
        this.txt_imporNeto.setFont(new Font("Tahoma", 1, 12));
        this.txt_imporNeto.setHorizontalAlignment(4);
        this.txt_imporNeto.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_imporNeto.setEnabled(false);
        this.txt_imporNeto.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_imporNetoActionPerformed(evt);
            }
        });
        this.txt_imporIva.setFont(new Font("Tahoma", 1, 12));
        this.txt_imporIva.setHorizontalAlignment(4);
        this.txt_imporIva.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_imporIva.setEnabled(false);
        this.txt_imporIva.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_imporIvaActionPerformed(evt);
            }
        });
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.lbl_impEx).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_imporEx, -1, 141, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.lbl_totalNeto).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_imporNeto, -1, 140, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.lbl_imporTotalIva).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_imporIva, -2, 112, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lbl_imporTotalImpu).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_imporTrib, -2, 111, -2).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lbl_impEx, -2, 22, -2).addComponent(this.txt_imporEx, -2, 21, -2).addComponent(this.lbl_totalNeto).addComponent(this.txt_imporNeto, -2, 21, -2).addComponent(this.lbl_imporTotalIva).addComponent(this.txt_imporIva, -2, -1, -2).addComponent(this.lbl_imporTotalImpu, -2, 26, -2).addComponent(this.txt_imporTrib, -2, 21, -2)).addContainerGap(-1, 32767)));
        this.jPanel5.setBorder(BorderFactory.createBevelBorder(0));
        this.lbl_imporTotal.setFont(new Font("Arial", 1, 12));
        this.lbl_imporTotal.setText("Importe Total:");
        this.txt_impTotal.setFont(new Font("Tahoma", 1, 12));
        this.txt_impTotal.setHorizontalAlignment(4);
        this.txt_impTotal.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_impTotal.setEnabled(false);
        this.txt_impTotal.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_impTotalActionPerformed(evt);
            }
        });
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.lbl_imporTotal).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txt_impTotal, -1, 174, 32767).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lbl_imporTotal).addComponent(this.txt_impTotal, -2, 21, -2)).addContainerGap(-1, 32767)));
        GroupLayout pnl_InformeRespuestaLayout = new GroupLayout(this.pnl_InformeRespuesta);
        this.pnl_InformeRespuesta.setLayout(pnl_InformeRespuestaLayout);
        pnl_InformeRespuestaLayout.setHorizontalGroup(pnl_InformeRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pnl_InformeRespuestaLayout.createSequentialGroup().addGroup(pnl_InformeRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pnl_InformeRespuestaLayout.createSequentialGroup().addContainerGap().addGroup(pnl_InformeRespuestaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel4, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel3, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, -1, 32767))).addGroup(pnl_InformeRespuestaLayout.createSequentialGroup().addGap(138, 138, 138).addComponent(this.jPanel5, -2, -1, -2))).addContainerGap(23, 32767)));
        pnl_InformeRespuestaLayout.setVerticalGroup(pnl_InformeRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pnl_InformeRespuestaLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -2, -1, -2).addGap(11, 11, 11).addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel4, -2, -1, -2).addGap(33, 33, 33).addComponent(this.jPanel5, -2, -1, -2).addContainerGap(68, 32767)));
        this.pesa_pantalla.addTab("Informe Respuesta FE", this.pnl_InformeRespuesta);
        this.jPanel6.setBorder(BorderFactory.createEtchedBorder());
        this.lbl_tipoCompro1.setFont(new Font("Arial", 1, 12));
        this.lbl_tipoCompro1.setText("ID:");
        this.lbl_sucursalCompro1.setFont(new Font("Arial", 1, 12));
        this.lbl_sucursalCompro1.setText("Suc:");
        this.lbl_numeroCompro1.setFont(new Font("Arial", 1, 12));
        this.lbl_numeroCompro1.setText("Num:");
        this.lbl_fechaCompro1.setFont(new Font("Arial", 1, 12));
        this.lbl_fechaCompro1.setText("Fecha:");
        this.txt_id.setFont(new Font("Tahoma", 1, 12));
        this.txt_id.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_id.setEnabled(false);
        this.txt_id.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_idActionPerformed(evt);
            }
        });
        this.txt_fechaBFE.setFont(new Font("Tahoma", 1, 12));
        this.txt_fechaBFE.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_fechaBFE.setEnabled(false);
        this.txt_fechaBFE.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_fechaBFEActionPerformed(evt);
            }
        });
        this.txt_sucursalBFE.setFont(new Font("Tahoma", 1, 12));
        this.txt_sucursalBFE.setHorizontalAlignment(4);
        this.txt_sucursalBFE.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_sucursalBFE.setEnabled(false);
        this.txt_sucursalBFE.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_sucursalBFEActionPerformed(evt);
            }
        });
        this.txt_numeroBFE.setFont(new Font("Tahoma", 1, 12));
        this.txt_numeroBFE.setHorizontalAlignment(4);
        this.txt_numeroBFE.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_numeroBFE.setEnabled(false);
        this.txt_numeroBFE.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_numeroBFEActionPerformed(evt);
            }
        });
        this.txt_tipoComproBFE.setFont(new Font("Tahoma", 1, 12));
        this.txt_tipoComproBFE.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_tipoComproBFE.setEnabled(false);
        this.txt_tipoComproBFE.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_tipoComproBFEActionPerformed(evt);
            }
        });
        this.lbl_tipoCompro2.setFont(new Font("Arial", 1, 12));
        this.lbl_tipoCompro2.setText("Tip Comprob:");
        this.lbl_cuitCliente1.setFont(new Font("Arial", 1, 12));
        this.lbl_cuitCliente1.setText("Cuit:");
        this.txt_cuitClienteBFE.setFont(new Font("Tahoma", 1, 12));
        this.txt_cuitClienteBFE.setHorizontalAlignment(4);
        this.txt_cuitClienteBFE.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_cuitClienteBFE.setEnabled(false);
        this.txt_cuitClienteBFE.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_cuitClienteBFEActionPerformed(evt);
            }
        });
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.lbl_tipoCompro1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txt_id, -2, 84, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lbl_fechaCompro1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_fechaBFE, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lbl_tipoCompro2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_tipoComproBFE, -2, 138, -2).addGap(2, 2, 2).addComponent(this.lbl_sucursalCompro1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_sucursalBFE, -2, 51, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lbl_numeroCompro1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_numeroBFE, -2, 98, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lbl_cuitCliente1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.txt_cuitClienteBFE, -2, 125, -2).addContainerGap()));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txt_id, -2, 21, -2).addComponent(this.lbl_fechaCompro1).addComponent(this.txt_fechaBFE, -2, -1, -2).addComponent(this.lbl_tipoCompro2).addComponent(this.txt_tipoComproBFE, -2, 21, -2).addComponent(this.lbl_sucursalCompro1).addComponent(this.txt_sucursalBFE, -2, -1, -2).addComponent(this.lbl_numeroCompro1).addComponent(this.txt_numeroBFE, -2, -1, -2).addComponent(this.lbl_cuitCliente1).addComponent(this.txt_cuitClienteBFE, -2, 21, -2).addComponent(this.lbl_tipoCompro1)).addContainerGap()));
        this.jPanel7.setBorder(BorderFactory.createEtchedBorder());
        this.lbl_nroCae1.setFont(new Font("Arial", 1, 12));
        this.lbl_nroCae1.setText("Imp. Con. No Neto");
        this.lbl_caeVencimiento1.setFont(new Font("Arial", 1, 12));
        this.lbl_caeVencimiento1.setText("Imp. Neto");
        this.txt_ImpConNoNetoBFE.setFont(new Font("Tahoma", 1, 12));
        this.txt_ImpConNoNetoBFE.setHorizontalAlignment(4);
        this.txt_ImpConNoNetoBFE.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_ImpConNoNetoBFE.setEnabled(false);
        this.txt_ImpConNoNetoBFE.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_ImpConNoNetoBFEActionPerformed(evt);
            }
        });
        this.txt_ImpNetoBFE.setFont(new Font("Tahoma", 1, 12));
        this.txt_ImpNetoBFE.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_ImpNetoBFE.setEnabled(false);
        this.txt_ImpNetoBFE.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_ImpNetoBFEActionPerformed(evt);
            }
        });
        this.lbl_caeVencimiento2.setFont(new Font("Arial", 1, 12));
        this.lbl_caeVencimiento2.setText("Imp. Exento:");
        this.txt_ImpExBFE.setFont(new Font("Tahoma", 1, 12));
        this.txt_ImpExBFE.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_ImpExBFE.setEnabled(false);
        this.txt_ImpExBFE.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_ImpExBFEActionPerformed(evt);
            }
        });
        this.txt_ImpInterBFE.setFont(new Font("Tahoma", 1, 12));
        this.txt_ImpInterBFE.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_ImpInterBFE.setEnabled(false);
        this.txt_ImpInterBFE.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_ImpInterBFEActionPerformed(evt);
            }
        });
        this.lbl_caeVencimiento4.setFont(new Font("Arial", 1, 12));
        this.lbl_caeVencimiento4.setText("Imp. Internos");
        GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
        this.jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.lbl_nroCae1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_ImpConNoNetoBFE).addGap(18, 18, 18).addComponent(this.lbl_caeVencimiento1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txt_ImpNetoBFE, -2, 121, -2).addGap(34, 34, 34).addComponent(this.lbl_caeVencimiento2).addGap(18, 18, 18).addComponent(this.txt_ImpExBFE, -2, 121, -2).addGap(18, 18, 18).addComponent(this.lbl_caeVencimiento4).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txt_ImpInterBFE, -2, 100, -2).addContainerGap()));
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txt_ImpConNoNetoBFE, -2, 21, -2).addComponent(this.txt_ImpInterBFE, -2, 21, -2).addComponent(this.lbl_caeVencimiento4).addComponent(this.lbl_nroCae1).addComponent(this.lbl_caeVencimiento1).addComponent(this.txt_ImpExBFE, -2, 21, -2).addComponent(this.lbl_caeVencimiento2).addComponent(this.txt_ImpNetoBFE, -2, 21, -2)).addContainerGap(-1, 32767)));
        this.jPanel8.setBorder(BorderFactory.createEtchedBorder());
        this.lbl_nroCae2.setFont(new Font("Arial", 1, 12));
        this.lbl_nroCae2.setText("Num. CAE:");
        this.lbl_caeVencimiento5.setFont(new Font("Arial", 1, 12));
        this.lbl_caeVencimiento5.setText("Fch. CAE Venc:");
        this.txt_numeroCaeBFE.setFont(new Font("Tahoma", 1, 12));
        this.txt_numeroCaeBFE.setHorizontalAlignment(4);
        this.txt_numeroCaeBFE.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_numeroCaeBFE.setEnabled(false);
        this.txt_numeroCaeBFE.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_numeroCaeBFEActionPerformed(evt);
            }
        });
        this.txt_CaeVencimientoBFE.setFont(new Font("Tahoma", 1, 12));
        this.txt_CaeVencimientoBFE.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_CaeVencimientoBFE.setEnabled(false);
        this.txt_CaeVencimientoBFE.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_CaeVencimientoBFEActionPerformed(evt);
            }
        });
        this.lbl_caeVencimiento6.setFont(new Font("Arial", 1, 12));
        this.lbl_caeVencimiento6.setText("Resultado:");
        this.txt_resultadoBFE.setFont(new Font("Tahoma", 1, 12));
        this.txt_resultadoBFE.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_resultadoBFE.setEnabled(false);
        this.txt_resultadoBFE.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_resultadoBFEActionPerformed(evt);
            }
        });
        this.lbl_caeVencimiento7.setFont(new Font("Arial", 1, 12));
        this.lbl_caeVencimiento7.setText("Obs:");
        this.txt_obsBFE.setFont(new Font("Tahoma", 1, 12));
        this.txt_obsBFE.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_obsBFE.setEnabled(false);
        this.txt_obsBFE.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_obsBFEActionPerformed(evt);
            }
        });
        this.txt_ImpTotalBFE.setFont(new Font("Tahoma", 1, 12));
        this.txt_ImpTotalBFE.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_ImpTotalBFE.setEnabled(false);
        this.txt_ImpTotalBFE.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_ImpTotalBFEActionPerformed(evt);
            }
        });
        this.lbl_caeVencimiento8.setFont(new Font("Arial", 1, 12));
        this.lbl_caeVencimiento8.setText("Imp. Tot.");
        GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
        this.jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addComponent(this.lbl_nroCae2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_numeroCaeBFE, -2, 129, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lbl_caeVencimiento5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_CaeVencimientoBFE, -2, 122, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lbl_caeVencimiento6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_resultadoBFE, -2, 37, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.lbl_caeVencimiento7).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txt_obsBFE).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.lbl_caeVencimiento8).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_ImpTotalBFE, -2, 139, -2).addContainerGap()));
        jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lbl_nroCae2).addComponent(this.txt_numeroCaeBFE, -2, 21, -2).addComponent(this.lbl_caeVencimiento5).addComponent(this.txt_CaeVencimientoBFE, -2, 21, -2).addComponent(this.lbl_caeVencimiento6).addComponent(this.txt_resultadoBFE, -2, 21, -2).addComponent(this.lbl_caeVencimiento7).addComponent(this.txt_obsBFE, -2, 21, -2).addComponent(this.txt_ImpTotalBFE, -2, 21, -2).addComponent(this.lbl_caeVencimiento8)).addContainerGap(-1, 32767)));
        this.jPanel9.setBorder(BorderFactory.createEtchedBorder());
        this.lbl_nroCae3.setFont(new Font("Arial", 1, 12));
        this.lbl_nroCae3.setText("Imp. De Percep");
        this.txt_ImpPerceBFE.setFont(new Font("Tahoma", 1, 12));
        this.txt_ImpPerceBFE.setHorizontalAlignment(4);
        this.txt_ImpPerceBFE.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_ImpPerceBFE.setEnabled(false);
        this.txt_ImpPerceBFE.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_ImpPerceBFEActionPerformed(evt);
            }
        });
        this.lbl_nroCae4.setFont(new Font("Arial", 1, 12));
        this.lbl_nroCae4.setText("Imp. IIBB");
        this.txt_ImpIIBBBFE.setFont(new Font("Tahoma", 1, 12));
        this.txt_ImpIIBBBFE.setHorizontalAlignment(4);
        this.txt_ImpIIBBBFE.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_ImpIIBBBFE.setEnabled(false);
        this.txt_ImpIIBBBFE.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_ImpIIBBBFEActionPerformed(evt);
            }
        });
        this.lbl_nroCae5.setFont(new Font("Arial", 1, 12));
        this.lbl_nroCae5.setText("Imp. Percep Mun.");
        this.txt_ImpPercMunBFE.setFont(new Font("Tahoma", 1, 12));
        this.txt_ImpPercMunBFE.setHorizontalAlignment(4);
        this.txt_ImpPercMunBFE.setDisabledTextColor(new Color(0, 0, 0));
        this.txt_ImpPercMunBFE.setEnabled(false);
        this.txt_ImpPercMunBFE.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                Prueba.this.txt_ImpPercMunBFEActionPerformed(evt);
            }
        });
        GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
        this.jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addContainerGap().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.lbl_nroCae3).addGap(18, 18, 18).addComponent(this.txt_ImpPerceBFE, -2, 115, -2)).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.lbl_nroCae4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.txt_ImpIIBBBFE, -2, 115, -2))).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.lbl_nroCae5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txt_ImpPercMunBFE, -2, 115, -2))).addContainerGap(28, 32767)));
        jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addGap(24, 24, 24).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lbl_nroCae3).addComponent(this.txt_ImpPerceBFE, -2, 21, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lbl_nroCae4).addComponent(this.txt_ImpIIBBBFE, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lbl_nroCae5).addComponent(this.txt_ImpPercMunBFE, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.tbl_tablitaItemsBFE.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null, null, null, null, null, null}}, new String[]{"C\u00f3d. Pro.segun Mercosur", "C\u00f3d. de Pro. segun Secretaria", "Descripcion Producto", "Cantidad", "C\u00f3d. Uni. Med", "Precio Unitario", "Imp. Bonif.", "Imp. Total", "C\u00f3digo Iva"}));
        this.jScrollPane3.setViewportView(this.tbl_tablitaItemsBFE);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jPanel9, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane3)).addComponent(this.jPanel6, -1, -1, 32767).addComponent(this.jPanel8, -1, -1, 32767).addComponent(this.jPanel7, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel6, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel8, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel7, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel9, -1, -1, 32767).addComponent(this.jScrollPane3, -2, 146, -2)).addContainerGap()));
        this.pesa_pantalla.addTab("Informe Respuesta BFE", this.jPanel1);
        this.respuesta.setColumns(20);
        this.respuesta.setRows(5);
        this.jScrollPane4.setViewportView(this.respuesta);
        this.pesa_pantalla.addTab("Respuesta", this.jScrollPane4);
        this.jScrollPane2.setViewportView(this.preguntaXML);
        this.pesa_pantalla.addTab("PreguntaXML", this.jScrollPane2);
        this.jScrollPane1.setViewportView(this.respuestaXML);
        this.pesa_pantalla.addTab("RespuestaXML", this.jScrollPane1);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.pesa_pantalla, -1, 918, 32767).addGap(41, 41, 41)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.pesa_pantalla)));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((screenSize.width - 967) / 2, (screenSize.height - 400) / 2, 967, 400);
    }

    private void txt_tipoComproActionPerformed(ActionEvent evt) {
    }

    private void txt_fechaActionPerformed(ActionEvent evt) {
    }

    private void txt_sucursalActionPerformed(ActionEvent evt) {
    }

    private void txt_numeroActionPerformed(ActionEvent evt) {
    }

    private void txt_cuitClienteActionPerformed(ActionEvent evt) {
    }

    private void txt_numeroCaeActionPerformed(ActionEvent evt) {
    }

    private void txt_CaeVencimientoActionPerformed(ActionEvent evt) {
    }

    private void txt_imporExActionPerformed(ActionEvent evt) {
    }

    private void txt_imporTribActionPerformed(ActionEvent evt) {
    }

    private void txt_imporNetoActionPerformed(ActionEvent evt) {
    }

    private void txt_imporIvaActionPerformed(ActionEvent evt) {
    }

    private void txt_impTotalActionPerformed(ActionEvent evt) {
    }

    private void txt_idActionPerformed(ActionEvent evt) {
    }

    private void txt_fechaBFEActionPerformed(ActionEvent evt) {
    }

    private void txt_sucursalBFEActionPerformed(ActionEvent evt) {
    }

    private void txt_numeroBFEActionPerformed(ActionEvent evt) {
    }

    private void txt_tipoComproBFEActionPerformed(ActionEvent evt) {
    }

    private void txt_cuitClienteBFEActionPerformed(ActionEvent evt) {
    }

    private void txt_ImpConNoNetoBFEActionPerformed(ActionEvent evt) {
    }

    private void txt_ImpNetoBFEActionPerformed(ActionEvent evt) {
    }

    private void txt_ImpExBFEActionPerformed(ActionEvent evt) {
    }

    private void txt_ImpInterBFEActionPerformed(ActionEvent evt) {
    }

    private void txt_numeroCaeBFEActionPerformed(ActionEvent evt) {
    }

    private void txt_CaeVencimientoBFEActionPerformed(ActionEvent evt) {
    }

    private void txt_resultadoBFEActionPerformed(ActionEvent evt) {
    }

    private void txt_obsBFEActionPerformed(ActionEvent evt) {
    }

    private void txt_ImpTotalBFEActionPerformed(ActionEvent evt) {
    }

    private void txt_ImpPerceBFEActionPerformed(ActionEvent evt) {
    }

    private void txt_ImpIIBBBFEActionPerformed(ActionEvent evt) {
    }

    private void txt_ImpPercMunBFEActionPerformed(ActionEvent evt) {
    }

}

