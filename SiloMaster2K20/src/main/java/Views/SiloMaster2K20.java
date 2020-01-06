/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Engine.GestionEvenement;
import Model.*;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author flavi
 */
public class SiloMaster2K20 extends javax.swing.JFrame {

    private ArrayList<Poste> postes;
    private Silo silo;

    public Silo getSilo() {
        return silo;
    }

    /**
     * Creates new form SiloMaster2K20
     */
    public SiloMaster2K20(ArrayList<Poste> l) {
        postes = l;
        initComponents();

        for (Poste p : postes) {
            PosteStatus ps = new PosteStatus(p);
            switch (p.getClass().getSimpleName()) {
                case "FosseReception":
                    panelFosses.add(ps);
                    break;
                case "Tremie":
                    panelTremies.add(ps);
                    break;
                case "Boisseau":
                    panelBoisseau.add(ps);
            }
        }
        autoResizeGithub();
        silo = new Silo();
        loadTree();

    }

    public void loadTree() {

        this.jTree1.removeAll();

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Commandes terminées");
        DefaultTreeModel model = new DefaultTreeModel(root);
        jTree1.setModel(model);
        jTree1.setRootVisible(true);
        jTree1.setShowsRootHandles(true);

        List<Lot> lstCommande = GestionEvenement.getInstance().getArchivage().getLstLot().stream().filter(c -> c.getCommande().isTraitementTermine()).collect(Collectors.toList());
        int i = 0;
        for (Lot l : lstCommande) {
            Commande c = l.getCommande();

            DefaultMutableTreeNode n1 = new DefaultMutableTreeNode(c.getId());
            model.insertNodeInto(n1, root, i);
            model.insertNodeInto(new DefaultMutableTreeNode("Arrivée: " + c.getArrivee().toString()), n1, 0);
            model.insertNodeInto(new DefaultMutableTreeNode("Depart: " + c.getDepart().toString()), n1, 1);
            model.insertNodeInto(new DefaultMutableTreeNode("Description: " + c.getDescription()), n1, 2);

            DefaultMutableTreeNode lo = new DefaultMutableTreeNode("Lot");
            model.insertNodeInto(new DefaultMutableTreeNode("Id: " + l.getId()), lo, 0);
            model.insertNodeInto(new DefaultMutableTreeNode("Type: " + l.getTypeCereale()), lo, 1);
            model.insertNodeInto(new DefaultMutableTreeNode("Poids: " + l.getPoids()), lo, 2);
            model.insertNodeInto(new DefaultMutableTreeNode("Qualité: " + l.getQualite()), lo, 3);
            model.insertNodeInto(lo, n1, 3);

            i++;
        }
        model.reload(root);

        //this.repaint();
    }

    public void autoResizeGithub() {
        try {
            BufferedImage BImgGitHub = ImageIO.read(new File(getClass().getClassLoader().getResource("git.png").getFile()));
            BImgGitHub = toBufferedImage(resize(BImgGitHub));
            jButton2.setIcon(new ImageIcon(BImgGitHub));

        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    public Image resize(BufferedImage I) {
        Dimension D = (this.jButton2.getSize().height == 0) ? this.jButton2.getPreferredSize() : this.jButton2.getSize();
        int size = (D.height == D.width) ? D.height : (D.height < D.width) ? D.height : D.width;
        return I.getScaledInstance(size - 10, size - 10, Image.SCALE_SMOOTH);
    }

    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panelFosses = new javax.swing.JPanel();
        panelTremies = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        panelBoisseau = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SiloMaster2K20");
        setMinimumSize(new java.awt.Dimension(800, 800));

        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(4, 1));

        panelFosses.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        panelFosses.setLayout(new java.awt.GridLayout(1, 2));
        jPanel2.add(panelFosses);

        panelTremies.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        panelTremies.setLayout(new java.awt.GridLayout(1, 2));
        jPanel2.add(panelTremies);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("Silo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new java.awt.GridBagConstraints());

        jPanel2.add(jPanel3);

        panelBoisseau.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        panelBoisseau.setLayout(new java.awt.GridLayout(1, 3));
        jPanel2.add(panelBoisseau);

        jPanel6.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridLayout(3, 1));

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SiloMaster2K20");
        jPanel1.add(jLabel1);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jButton2.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton2.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new java.awt.GridBagConstraints());

        jPanel1.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(6, 1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("RIGLET Flavien");
        jPanel5.add(jLabel2);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LOTH Alexandre");
        jPanel5.add(jLabel3);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("SCHIRMANN Alexandre");
        jPanel5.add(jLabel4);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("PITOIS Léa");
        jPanel5.add(jLabel5);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("MAZERON Lucas");
        jPanel5.add(jLabel6);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("BELTRAMO Emeric");
        jPanel5.add(jLabel7);

        jPanel1.add(jPanel5);

        jPanel6.add(jPanel1, java.awt.BorderLayout.WEST);

        jTabbedPane1.addTab("Interface Principale", jPanel6);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel8.setLayout(new java.awt.BorderLayout());

        jButton3.setText("Refresh");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton3, java.awt.BorderLayout.WEST);

        jPanel7.add(jPanel8, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setViewportView(jTree1);

        jPanel7.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Historique des commandes", jPanel7);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new StatusSilo(silo).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            java.awt.Desktop.getDesktop().browse(new URI("https://github.com/SenmentyCorp/SiloMaster2K20"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.loadTree();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SiloMaster2K20.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SiloMaster2K20.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SiloMaster2K20.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SiloMaster2K20.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SiloMaster2K20(new ArrayList<Poste>()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JPanel panelBoisseau;
    private javax.swing.JPanel panelFosses;
    private javax.swing.JPanel panelTremies;
    // End of variables declaration//GEN-END:variables
}
