/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edunova.view;

import edunova.controller.Obrada;
import edunova.controller.ObradaBlagajnik;
import edunova.controller.ObradaProizvod;
import edunova.model.Proizvod;
import edunova.util.Aplikacija;
import edunova.util.EdunovaException;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Feecho
 */
public class ProzorProizvodi extends javax.swing.JFrame {
    
    private ObradaProizvod obrada;
    private DecimalFormat df;

    /**
     * Creates new form ProzorProizvodi
     */
    public ProzorProizvodi() {
        initComponents();
        obrada = new ObradaProizvod();
        DecimalFormatSymbols dfs
                = new DecimalFormatSymbols(
                        new Locale("hr", "HR"));
        df = new DecimalFormat("###,##0.00", dfs);
        
        setTitle(Aplikacija.NAZIV_APP + ": "
                + Aplikacija.OPERATER
                + ": Proizvodi");
        ucitaj();
    }
    
    private void ucitaj() {
        DefaultListModel<Proizvod> m
                = new DefaultListModel<>();
        if (!txtTrazilica.getText().isBlank()) {
            m.addAll(obrada.read(txtTrazilica.getText()));
        } else {
            m.addAll(obrada.read());
        }
        lstPodaci.setModel(m);
        lstPodaci.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstPodaci = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        txtImeProizvoda = new javax.swing.JTextField();
        txtCijenaProizvoda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnDodaj = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        txtTrazilica = new javax.swing.JTextField();
        btnTrazi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstPodaci.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstPodaci.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPodaciValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstPodaci);

        jLabel1.setText("Ime proizvoda");

        txtImeProizvoda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImeProizvodaActionPerformed(evt);
            }
        });

        txtCijenaProizvoda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCijenaProizvodaActionPerformed(evt);
            }
        });

        jLabel2.setText("Cijena proizvoda u Kn");

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnPromjeni.setText("Promjeni");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        txtTrazilica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTrazilicaKeyPressed(evt);
            }
        });

        btnTrazi.setText("Trazi");
        btnTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraziActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTrazilica, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtImeProizvoda, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtCijenaProizvoda, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDodaj)
                    .addComponent(btnPromjeni)
                    .addComponent(btnObrisi))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTrazilica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTrazi)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtImeProizvoda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCijenaProizvoda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDodaj)
                        .addGap(18, 18, 18)
                        .addComponent(btnPromjeni)
                        .addGap(18, 18, 18)
                        .addComponent(btnObrisi)
                        .addContainerGap(70, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtImeProizvodaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImeProizvodaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImeProizvodaActionPerformed

    private void txtCijenaProizvodaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCijenaProizvodaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCijenaProizvodaActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        obrada.setEntitet(new Proizvod());
        napuniModel();
        try {
            obrada.create();
            ucitaj();
        } catch (EdunovaException e) {
            JOptionPane.showMessageDialog(getRootPane(), e.getPoruka());
        }

    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
        if (lstPodaci.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(
                    getRootPane(),
                    "Prvo odaberite proizvod");
            return;
        }
        napuniModel();
        try {
            obrada.update();
            ucitaj();
        } catch (EdunovaException ex) {
            JOptionPane.showMessageDialog(
                    getRootPane(),
                    ex.getPoruka());
        }

    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void lstPodaciValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPodaciValueChanged
        if (evt.getValueIsAdjusting()) {
            return;
        }
        if (lstPodaci.getSelectedValue() == null) {
            return;
        }
        
        obrada.setEntitet(lstPodaci.getSelectedValue());
        
        napuniView();

    }//GEN-LAST:event_lstPodaciValueChanged

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        if (lstPodaci.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(
                    getRootPane(),
                    "Prvo odaberite smjer");
            return;
        }
        try {
            obrada.delete();
            ucitaj();
        } catch (EdunovaException e) {
            JTextArea textArea = new JTextArea(e.getPoruka());
            JScrollPane scrollPane = new JScrollPane(textArea);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            scrollPane.setPreferredSize(new Dimension(300, 200));
            JOptionPane.showMessageDialog(null, scrollPane, "Proizvod brisanje upozorenje",
                    JOptionPane.WARNING_MESSAGE);
            
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziActionPerformed
        ucitaj();

    }//GEN-LAST:event_btnTraziActionPerformed

    private void txtTrazilicaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTrazilicaKeyPressed
      if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ucitaj();
        }
        
// TODO add your handling code here:
    }//GEN-LAST:event_txtTrazilicaKeyPressed
    
    private void napuniModel() {
        var p = obrada.getEntitet();
        
        try {
            p.setImeProizvoda(txtImeProizvoda.getText());
        } catch (Exception e) {
            p.setImeProizvoda("");
        }
        
        try {
            p.setCijena( BigDecimal.valueOf(df.parse(txtCijenaProizvoda.getText()).doubleValue()));
            
        } catch (Exception e) {
            p.setCijena(BigDecimal.ZERO);
        }
        
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JButton btnTrazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Proizvod> lstPodaci;
    private javax.swing.JTextField txtCijenaProizvoda;
    private javax.swing.JTextField txtImeProizvoda;
    private javax.swing.JTextField txtTrazilica;
    // End of variables declaration//GEN-END:variables

    private void napuniView() {
        var p = lstPodaci.getSelectedValue();
        try {
            txtCijenaProizvoda.setText(df.format(p.getCijena()));
        } catch (Exception e) {
            txtCijenaProizvoda.setText("");
        }
        try {
            txtImeProizvoda.setText(p.getImeProizvoda());
        } catch (Exception e) {
            txtImeProizvoda.setText("");
        }
        
    }
    
}
