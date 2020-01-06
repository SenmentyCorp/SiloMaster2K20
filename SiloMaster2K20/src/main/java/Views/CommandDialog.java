/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Model.Commande;

/**
 *
 * @author flavi
 */
public class CommandDialog extends javax.swing.JDialog {

    /**
     * Creates new form CommandDialog
     */
    public CommandDialog(java.awt.Frame parent, boolean modal,Commande c) {
        super(parent, modal);
        initComponents();
        jLabel1.setText("Commande "+c.getId());
        jFormattedTextField1.setText(c.getDescription());
        try{
        jLabel5.setText(c.getDepart().toString());
        }catch(Exception e){
            jLabel5.setText("Non définie");
        }
        jLabel4.setText(c.getArrivee().toString());
    }
    
        public CommandDialog(java.awt.Window parent, boolean modal,Commande c) {
        super(parent, java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        initComponents();
        jLabel1.setText("Commande "+c.getId());
        jFormattedTextField1.setText(c.getDescription());
        try{
        jLabel5.setText(c.getDepart().toString());
        }catch(Exception e){
            jLabel5.setText("Non définie");
        }
        jLabel4.setText(c.getArrivee().toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 200));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, java.awt.BorderLayout.NORTH);

        jPanel3.setLayout(new java.awt.GridLayout(2, 1));

        jPanel1.setLayout(new java.awt.GridLayout(2, 2));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Date d'arrivée");
        jPanel1.add(jLabel2);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Date de départ");
        jPanel1.add(jLabel3);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5);

        jPanel3.add(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jFormattedTextField1.setEditable(false);
        jFormattedTextField1.setText("jFormattedTextField1");
        jScrollPane1.setViewportView(jFormattedTextField1);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel2);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
