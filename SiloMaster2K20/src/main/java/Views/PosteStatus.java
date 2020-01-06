/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Model.Boisseau;
import Model.Commande;
import Model.Lot;
import Model.Poste;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author flavi
 */
public class PosteStatus extends javax.swing.JPanel implements Observer {

    private Poste poste;
    private boolean capteur;

    /**
     * Creates new form PosteStatus
     */
    public PosteStatus(Poste p) {
        this.poste = p;
        initComponents();

        jLabel1.setText(this.poste.getClass().getName().substring(6) + " ID:" + this.poste.getId());
        this.setAlarm(false);

        p.addObserver(this);

        this.updateInterface();
    }

    public void setAlarm(boolean b) {
        if (!b) {
            jButton1.setBackground(FrameBasique.OKColor);
            jButton1.setText("");
        } else {
            jButton1.setBackground(FrameBasique.ErrorColor);
            jButton1.setText("Résoudre");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        LabelType = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Labelpoids = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        LabelQualite = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        setMinimumSize(new java.awt.Dimension(430, 118));
        setPreferredSize(new java.awt.Dimension(430, 175));
        setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(FrameBasique.BarColor);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(jLabel1, java.awt.BorderLayout.NORTH);

        jPanel3.setLayout(new java.awt.GridLayout(1, 2));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("jLabel2");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel2, java.awt.BorderLayout.NORTH);

        jPanel12.setLayout(new java.awt.GridLayout(3, 2));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Type");
        jPanel12.add(jLabel4);

        LabelType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelType.setText("jLabel5");
        jPanel12.add(LabelType);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Poids");
        jPanel12.add(jLabel6);

        Labelpoids.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Labelpoids.setText("jLabel7");
        jPanel12.add(Labelpoids);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Qualité");
        jPanel12.add(jLabel8);

        LabelQualite.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelQualite.setText("jLabel9");
        jPanel12.add(LabelQualite);

        jPanel1.add(jPanel12, java.awt.BorderLayout.CENTER);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jButton2.setText("Commande");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 65, 11, 66);
        jPanel5.add(jButton2, gridBagConstraints);

        jPanel1.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        jPanel3.add(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Alarme");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(jLabel3, java.awt.BorderLayout.NORTH);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jButton1.setBackground(FrameBasique.OKColor);
        jButton1.setText("Résoudre");
        jPanel4.add(jButton1, new java.awt.GridBagConstraints());

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel2);

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            Commande ctemp = this.poste.getLot().getCommande();
            try {
                new CommandDialog((JFrame) SwingUtilities.getRoot(this), true, ctemp).setVisible(true);
            } catch (Exception e) {
                new CommandDialog((java.awt.Window) SwingUtilities.getRoot(this), true, ctemp).setVisible(true);
            }
        } catch (NullPointerException e) {
            System.err.println("Poste vide.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelQualite;
    private javax.swing.JLabel LabelType;
    private javax.swing.JLabel Labelpoids;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables

    private void updateInterface() {
        if (this.poste.getLot() != null) {
            jLabel2.setText("Lot: " + poste.getLot().getId());
            Labelpoids.setText(Float.toString(poste.getLot().getPoids()));
            LabelQualite.setText(poste.getLot().getQualite());
            LabelType.setText(poste.getLot().getTypeCereale());
        } else {
            jLabel2.setText("Lot: --- ");
            Labelpoids.setText(" --- ");
            LabelQualite.setText(" --- ");
            LabelType.setText(" --- ");
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        this.updateInterface();
    }
}
