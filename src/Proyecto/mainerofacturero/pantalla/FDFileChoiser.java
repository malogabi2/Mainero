/*
 * Decompiled with CFR 0_124.
 */
package Proyecto.mainerofacturero.pantalla;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

public class FDFileChoiser
extends JDialog {
    String archivo;
    private JFileChooser fch_buscarArchivo;

    public FDFileChoiser(Frame parent, boolean modal) {
        super(parent, modal);
        this.initComponents();
    }

    private void initComponents() {
        this.fch_buscarArchivo = new JFileChooser();
        this.setDefaultCloseOperation(2);
        this.fch_buscarArchivo.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                FDFileChoiser.this.fch_buscarArchivoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.fch_buscarArchivo, -2, 634, -2).addGap(0, 10, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.fch_buscarArchivo, -2, 397, -2).addContainerGap(-1, 32767)));
        this.pack();
    }

    private void fch_buscarArchivoActionPerformed(ActionEvent evt) {
        if (this.fch_buscarArchivo.showOpenDialog(null) == 0) {
            this.archivo = this.fch_buscarArchivo.getSelectedFile().getAbsolutePath();
        } else {
            this.archivo = "";
            this.dispose();
        }
    }

    public String mostrarArchivoSelec() {
        return this.archivo;
    }

}

