/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edunova.view;

import edunova.controller.ObradaProizvod;
import edunova.controller.ObradaRacun;
import edunova.model.Blagajnik;
import edunova.model.Entitet;
import edunova.model.Proizvod;
import edunova.model.Racun;
import edunova.model.StavkaRacuna;
import edunova.util.Aplikacija;
import edunova.util.EdunovaException;
import edunova.util.Pomocno;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import org.hibernate.Session;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;

/**
 *
 * @author Feecho
 */
public class ProzorRacun extends javax.swing.JFrame {

    /**
     * Creates new form ProzorRacun
     */
    private ObradaRacun obrada;
    private ObradaProizvod obradaProizvod;

    public ProzorRacun() {
        initComponents();

        buttonGroup1.add(btnPoBlagajniku);
        buttonGroup1.add(btnPoBrRacuna);
        spnKolicina.setModel(new SpinnerNumberModel(1, 1, 100, 1));

        btnPoBlagajniku.setSelected(true);

        obrada = new ObradaRacun();
        obradaProizvod = new ObradaProizvod();
        ucitaj();
        ucitajProizvode();
        AutoCompleteDecorator.decorate(cmbProizvodi, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);
        cmbProizvodi.setSelectedIndex(1);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPodaci = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstStavkeNaRacunu = new javax.swing.JList<>();
        txtZaPlatiti = new javax.swing.JTextField();
        txtBlagajnik = new javax.swing.JTextField();
        txtDatum = new javax.swing.JTextField();
        txtBrRacuna = new javax.swing.JTextField();
        btnTrazilica = new javax.swing.JButton();
        btnPoBlagajniku = new javax.swing.JRadioButton();
        btnPoBrRacuna = new javax.swing.JRadioButton();
        txtTrazilica = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnNoviRacun = new javax.swing.JButton();
        btnDodajStavku = new javax.swing.JButton();
        cmbProizvodi = new javax.swing.JComboBox<>();
        spnKolicina = new javax.swing.JSpinner();
        btnSpremiStavke = new javax.swing.JButton();
        btnObrisiRacun = new javax.swing.JButton();
        btnObrisiStavku = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstPodaci.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstPodaci.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPodaciValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstPodaci);

        lstStavkeNaRacunu.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(lstStavkeNaRacunu);

        txtZaPlatiti.setEditable(false);

        txtBlagajnik.setEditable(false);

        txtDatum.setEditable(false);

        txtBrRacuna.setEditable(false);

        btnTrazilica.setText("Trazi");
        btnTrazilica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrazilicaActionPerformed(evt);
            }
        });

        btnPoBlagajniku.setText("Trazi po blagajniku");
        btnPoBlagajniku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPoBlagajnikuActionPerformed(evt);
            }
        });

        btnPoBrRacuna.setText("Trazi po broju racuna");
        btnPoBrRacuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPoBrRacunaActionPerformed(evt);
            }
        });

        txtTrazilica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrazilicaActionPerformed(evt);
            }
        });

        jLabel2.setText("Broj racuna");

        jLabel3.setText("Blagajnik");

        jLabel4.setText("Ukupna cijena");

        jLabel5.setText("Datum unosa");

        jLabel6.setText("Trenutne Stavke racuna");

        btnNoviRacun.setText("Novi racun");
        btnNoviRacun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoviRacunActionPerformed(evt);
            }
        });

        btnDodajStavku.setText("Dodaj Stavku");
        btnDodajStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajStavkuActionPerformed(evt);
            }
        });

        spnKolicina.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnKolicinaStateChanged(evt);
            }
        });
        spnKolicina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                spnKolicinaKeyPressed(evt);
            }
        });

        btnSpremiStavke.setText("Spremi promjene");
        btnSpremiStavke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpremiStavkeActionPerformed(evt);
            }
        });

        btnObrisiRacun.setText("Obrisi racun");
        btnObrisiRacun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiRacunActionPerformed(evt);
            }
        });

        btnObrisiStavku.setText("Obrisi stavku");
        btnObrisiStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiStavkuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTrazilica, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTrazilica))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtBlagajnik)
                        .addComponent(txtZaPlatiti)
                        .addComponent(txtDatum)
                        .addComponent(txtBrRacuna, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                    .addComponent(btnPoBlagajniku)
                    .addComponent(btnPoBrRacuna)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnNoviRacun, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnObrisiRacun, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSpremiStavke, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(295, 295, 295))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbProizvodi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(spnKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(121, 121, 121))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnDodajStavku)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnObrisiStavku)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbProizvodi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDodajStavku)
                            .addComponent(btnObrisiStavku))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSpremiStavke)
                        .addGap(84, 84, 84))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTrazilica)
                            .addComponent(btnPoBlagajniku, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTrazilica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPoBrRacuna)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addGap(7, 7, 7)
                                .addComponent(txtBrRacuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBlagajnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtZaPlatiti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNoviRacun)
                                .addGap(18, 18, 18)
                                .addComponent(btnObrisiRacun)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnTrazilicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrazilicaActionPerformed
        ucitaj();


    }//GEN-LAST:event_btnTrazilicaActionPerformed

    private void txtTrazilicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrazilicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrazilicaActionPerformed

    private void btnPoBlagajnikuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPoBlagajnikuActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnPoBlagajnikuActionPerformed

    private void btnPoBrRacunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPoBrRacunaActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnPoBrRacunaActionPerformed

    private void btnNoviRacunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoviRacunActionPerformed

        obrada.setEntitet(new Racun());
        napuniModel(false);
        try {
            obrada.create();
            ucitaj();
            lstPodaci.setSelectedIndex((lstPodaci.getModel().getSize()) - 1);
        } catch (EdunovaException e) {
            JOptionPane.showMessageDialog(getRootPane(), e.getPoruka());
        }

// TODO add your handling code here:
    }//GEN-LAST:event_btnNoviRacunActionPerformed

    private void btnDodajStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajStavkuActionPerformed
        if (lstStavkeNaRacunu.getModel() == null
                || !(lstStavkeNaRacunu.getModel() instanceof DefaultListModel<StavkaRacuna>)) {
            lstStavkeNaRacunu.setModel(new DefaultListModel<StavkaRacuna>());
        }
        DefaultListModel<StavkaRacuna> m
                = (DefaultListModel<StavkaRacuna>) lstStavkeNaRacunu.getModel();

        DefaultListModel<StavkaRacuna> stavke
                = (DefaultListModel<StavkaRacuna>) lstStavkeNaRacunu.getModel();
        Proizvod p = (Proizvod) cmbProizvodi.getSelectedItem();
        StavkaRacuna sr = new StavkaRacuna();
        sr.setProizvod(p);
        sr.setKolicina((int) spnKolicina.getValue());
        sr.setCijenaProizvoda(p.getCijena());
        sr.setUkupnaCijenaProizvoda(p.getCijena().multiply(BigDecimal.valueOf(sr.getKolicina())));
        sr.setBrojRacuna(123);
        stavke.addElement(sr);
        lstStavkeNaRacunu.repaint();
    }//GEN-LAST:event_btnDodajStavkuActionPerformed

    private void btnSpremiStavkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpremiStavkeActionPerformed
        if (lstPodaci.getSelectedValue() == null) {
            return;
        }
        int index = lstPodaci.getSelectedIndex();
        obrada.getEntitet().getStavkeRacuna().clear();
        napuniModel(true);
        try {
            obrada.update();
            ucitaj();
            lstPodaci.setSelectedIndex(index);
        } catch (EdunovaException ex) {
            JOptionPane.showMessageDialog(getParent(), ex.getPoruka());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSpremiStavkeActionPerformed

    private void btnObrisiRacunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiRacunActionPerformed
        if (lstPodaci.getSelectedValue() == null) {
            return;
        }
        obrada.getEntitet().getStavkeRacuna().clear();
        try {
            obrada.delete();
            ucitaj();
        } catch (EdunovaException ex) {
            JOptionPane.showMessageDialog(getParent(), ex.getPoruka());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnObrisiRacunActionPerformed

    private void btnObrisiStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiStavkuActionPerformed
        if (lstStavkeNaRacunu.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(getRootPane(),
                    "Prvo odaberite stavku na racunu");
            return;
        }

        DefaultListModel<StavkaRacuna> m
                = (DefaultListModel<StavkaRacuna>) lstStavkeNaRacunu.getModel();

        m.removeElement(lstStavkeNaRacunu.getSelectedValue());

        lstStavkeNaRacunu.repaint();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnObrisiStavkuActionPerformed

    private void spnKolicinaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spnKolicinaKeyPressed
            
    }//GEN-LAST:event_spnKolicinaKeyPressed

    private void spnKolicinaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnKolicinaStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_spnKolicinaStateChanged

    /**
     * @param args the command line arguments
     */
    private void ucitaj() {
        DefaultListModel<Racun> m
                = new DefaultListModel<>();
        if (!txtTrazilica.getText().isBlank()) {
            m.addAll(obrada.read(txtTrazilica.getText(), getSelectedButtonIndex(buttonGroup1)));
        } else {
            m.addAll(obrada.read());
        }

        lstPodaci.setModel(m);
        lstPodaci.repaint();
    }

    public int getSelectedButtonIndex(ButtonGroup buttonGroup) {
        int index = 0;
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return index;
            }
            index++;
        }

        return 0;
    }

    private void napuniView() {
        var e = obrada.getEntitet();
        try {
            txtBlagajnik.setText(e.getBlagajnik().toString());
        } catch (Exception ex) {
            txtBlagajnik.setText("null");
        }

        txtZaPlatiti.setText(e.getZaPlatiti().toString());
        txtDatum.setText(Aplikacija.df.format(e.getDatum()));
        txtBrRacuna.setText(String.valueOf(e.getBrojRacuna()));

        DefaultListModel<StavkaRacuna> m = new DefaultListModel<>();
        if (e.getStavkeRacuna() != null) {
            m.addAll(e.getStavkeRacuna());
        }

        lstStavkeNaRacunu.setModel(m);
        lstStavkeNaRacunu.repaint();

    }

    private void ucitajProizvode() {
        DefaultComboBoxModel<Proizvod> m
                = new DefaultComboBoxModel<>();
        m.addAll(new ObradaProizvod().read());
        cmbProizvodi.setModel(m);
        cmbProizvodi.repaint();
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajStavku;
    private javax.swing.JButton btnNoviRacun;
    private javax.swing.JButton btnObrisiRacun;
    private javax.swing.JButton btnObrisiStavku;
    private javax.swing.JRadioButton btnPoBlagajniku;
    private javax.swing.JRadioButton btnPoBrRacuna;
    private javax.swing.JButton btnSpremiStavke;
    private javax.swing.JButton btnTrazilica;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<Proizvod> cmbProizvodi;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Racun> lstPodaci;
    private javax.swing.JList<StavkaRacuna> lstStavkeNaRacunu;
    private javax.swing.JSpinner spnKolicina;
    private javax.swing.JTextField txtBlagajnik;
    private javax.swing.JTextField txtBrRacuna;
    private javax.swing.JTextField txtDatum;
    private javax.swing.JTextField txtTrazilica;
    private javax.swing.JTextField txtZaPlatiti;
    // End of variables declaration//GEN-END:variables

    private void napuniModel(boolean PovuciStavke) {
        var e = obrada.getEntitet();
        e.setBlagajnik(Aplikacija.ULOGIRANIBLAGAJNIK);

        e.setDatum(new Date());
        BigDecimal zaPlatit = new BigDecimal(BigInteger.ONE);
        e.setZaPlatiti(zaPlatit);

        if (!PovuciStavke) {
            e.setBrojRacuna(Pomocno.brojIzmedju(100000, 999999));
        }

        if (PovuciStavke) {

            List<StavkaRacuna> stavke = new ArrayList<>();
            try {
                DefaultListModel<StavkaRacuna> m = (DefaultListModel<StavkaRacuna>) lstStavkeNaRacunu.getModel();
                for (int i = 0; i < m.getSize(); i++) {
                    stavke.add(m.getElementAt(i));
                }
            } catch (Exception ex) {

            }
            e.setStavkeRacuna(stavke);

            for (StavkaRacuna stavka : stavke) {
                zaPlatit = zaPlatit.add(stavka.getUkupnaCijenaProizvoda());
            }
            e.setZaPlatiti(zaPlatit);
        }
    }

}
