/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edunova.view;

import edunova.controller.ObradaBlagajnik;
import edunova.controller.ObradaGrafPodaci;
import edunova.controller.ObradaProizvod;
import edunova.model.GrafPodaci;
import edunova.model.Proizvod;
import edunova.util.Aplikacija;
import java.awt.BorderLayout;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Feecho
 */
public class ProzorIzbornik extends javax.swing.JFrame {

    private ObradaGrafPodaci obrada;
    private ObradaProizvod obradaProizvod;
    private ObradaBlagajnik obradaBlagajnik;

    /**
     * Creates new form prozorIzbornik
     */
    public ProzorIzbornik() {
        initComponents();
        ucitajProizvode();
        setTitle("Trenutno ulogiran: " + Aplikacija.OPERATER);
        new Vrijeme().start();
        obrada = new ObradaGrafPodaci();
        obradaBlagajnik = new ObradaBlagajnik();
        obradaProizvod = new ObradaProizvod();
        AutoCompleteDecorator.decorate(cmbProizvodi, ObjectToStringConverter.DEFAULT_IMPLEMENTATION);

        spnGodina.setModel(new SpinnerNumberModel(2013, 2013, LocalDate.now().getYear() - 4, 1));
        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(spnGodina, "0000");
        spnGodina.setEditor(editor);

    }

    private void definirajGraf(String imeProizvoda, int godina) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        GrafPodaci gf = obrada.read(imeProizvoda, godina);
        dataset.addValue(gf.getKolicina(), imeProizvoda, godina);
        gf = obrada.read(imeProizvoda, godina + 1);
        dataset.addValue(gf.getKolicina(), imeProizvoda, godina + 1);
        gf = obrada.read(imeProizvoda, godina + 2);
        dataset.addValue(gf.getKolicina(), imeProizvoda, godina + 2);
        gf = obrada.read(imeProizvoda, godina + 3);
        dataset.addValue(gf.getKolicina(), imeProizvoda, godina + 3);
        gf = obrada.read(imeProizvoda, godina + 4);
        dataset.addValue(gf.getKolicina(), imeProizvoda, godina + 4);

        JFreeChart chart = ChartFactory.createLineChart("Broj prodanih " + imeProizvoda + " kroz 5 godina", "Godina", "Broj prodanih", dataset,
                PlotOrientation.VERTICAL, false, true, false);

        ChartPanel cp = new ChartPanel(chart);
        pnlGraf.removeAll();
        pnlGraf.setLayout(new BorderLayout());
        pnlGraf.add(cp, BorderLayout.CENTER);
        pnlGraf.validate();
    }

    private class Vrijeme extends Thread {

        private SimpleDateFormat df;

        public Vrijeme() {
            df = new SimpleDateFormat(
                    "dd.MM.YYYY. hh:mm:ss");
        }

        @Override
        public void run() {
            while (true) {
                lblVrijeme.setText(
                        df.format(new Date())
                );
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {

                }
            }
        }

    }

    private void ucitajProizvode() {
        DefaultComboBoxModel<Proizvod> m
                = new DefaultComboBoxModel<>();
        m.addAll(new ObradaProizvod().read());
        cmbProizvodi.setModel(m);
        cmbProizvodi.repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        lblVrijeme = new javax.swing.JLabel();
        btnUcitaj = new javax.swing.JButton();
        cmbProizvodi = new javax.swing.JComboBox<>();
        spnGodina = new javax.swing.JSpinner();
        pnlGraf = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblGitLink = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);
        jToolBar1.add(lblVrijeme);

        btnUcitaj.setText("Ucitaj");
        btnUcitaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUcitajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlGrafLayout = new javax.swing.GroupLayout(pnlGraf);
        pnlGraf.setLayout(pnlGrafLayout);
        pnlGrafLayout.setHorizontalGroup(
            pnlGrafLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlGrafLayout.setVerticalGroup(
            pnlGrafLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 248, Short.MAX_VALUE)
        );

        jLabel1.setText("Godina");

        jLabel2.setText("Proizvod");

        lblGitLink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/githubLogo.png"))); // NOI18N
        lblGitLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGitLinkMouseClicked(evt);
            }
        });

        jMenu1.setText("Aplikacija");

        jMenuItem5.setText("Racun -> PDF");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Odjavi se");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem1.setText("Izlaz");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Programi");

        jMenuItem2.setText("Proizvodi");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Blagajnici");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Racuni");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlGraf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblGitLink)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spnGodina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cmbProizvodi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addComponent(btnUcitaj)
                                .addGap(243, 243, 243)))
                        .addGap(44, 44, 44))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlGraf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spnGodina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbProizvodi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUcitaj))
                    .addComponent(lblGitLink))
                .addGap(18, 18, 18)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        new ProzorProizvodi().setVisible(true);

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        new ProzorBlagajnik().setVisible(true);

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if (obradaBlagajnik.read().isEmpty() || obradaProizvod.read().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Nema unesenih blagajnika ili proizvoda");
            return;
        }
        new ProzorRacun().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new ProzorPDF().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void btnUcitajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUcitajActionPerformed
        if (cmbProizvodi.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(rootPane, "Prvo odaberite proizvod");
            return;
        }
        definirajGraf(cmbProizvodi.getItemAt(cmbProizvodi.getSelectedIndex()).getImeProizvoda(), (int) spnGodina.getValue());    // TODO add your handling code here:
    }//GEN-LAST:event_btnUcitajActionPerformed

    private void lblGitLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGitLinkMouseClicked
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://github.com/FHorvat9/Zavrsni-rad-netbeans"));
            // TODO add your handling code here:
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_lblGitLinkMouseClicked

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        new ProzorLogin().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUcitaj;
    private javax.swing.JComboBox<Proizvod> cmbProizvodi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblGitLink;
    private javax.swing.JLabel lblVrijeme;
    private javax.swing.JPanel pnlGraf;
    private javax.swing.JSpinner spnGodina;
    // End of variables declaration//GEN-END:variables
}