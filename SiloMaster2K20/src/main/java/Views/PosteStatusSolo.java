/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

/**
 *
 * @author flavi
 */
public class PosteStatusSolo extends javax.swing.JDialog {

    /**
     * Creates new form PosteInfoSolo
     */
    public PosteStatusSolo(java.awt.Window parent, boolean modal, PosteStatus p) {
        super(parent, java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        initComponents();
        this.add(p);
        this.setSize(p.getPreferredSize().width, p.getPreferredSize().height);
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
