/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Model.*;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Flavien
 */
public class CellStatus extends javax.swing.JPanel implements Simulable, Observer {

    private Cellule cell;

    protected boolean isFanOn;

    protected static String pathFanOn;
    protected static String pathFanOff;
    protected static ImageIcon fanOn;
    protected static ImageIcon fanOff;
    protected static BufferedImage tempFanOn;
    protected static BufferedImage tempFanOff;

    /**
     * Creates new form CellStatus
     *
     * @param c Cellule observée
     */
    public CellStatus(Cellule c) {

        cell = c;

        isFanOn = false;
        initComponents();
        try {
            pathFanOn = getClass().getClassLoader().getResource("fan-gif.gif").getFile();
            pathFanOff = getClass().getClassLoader().getResource("fan-gif2.gif").getFile();
        } catch (Exception e) {

        }
        setAlarm(false);
        cell.addObserver(this);

        updateData();
    }

    @Override
    public void updateData() {

        if (cell.getLot() != null) {
            Lot l = cell.getLot();
            grainType.setText(l.getTypeCereale());
            grainMeanTemperature.setText(String.format("%.2g%n", cell.getTemperature()) + "°C");
            grainHumidity.setText(String.format("%.3g%n", cell.getHumidite()) + "%");
            cellCurrentVolumeBar.setValue((int) (l.getPoids() / cell.poidsMax * 100));
            fanSpeed.setValue(cell.getVent().getPuissance());
            cellNumber.setText("Cellule numéro " + cell.getId());
            cellVolume.setText(Cellule.poidsMax + "m^3");
            isFanOn = (cell.getVent().getPuissance() > 0);
            this.setAlarm(cell.isPanne());
        } else {
            grainType.setText(" --- ");
            grainMeanTemperature.setText("-- °C");
            grainHumidity.setText("-- %");
            cellCurrentVolumeBar.setValue(0);
            fanSpeed.setValue(cell.getVent().getPuissance());
            cellNumber.setText("Cellule numéro " + cell.getId());
            cellVolume.setText(Cellule.poidsMax + "m^3");
            isFanOn = (cell.getVent().getPuissance() > 0);
        }

        autoResizeFan();
        updateFan();
        this.repaint();
    }

    public void autoResizeFan() {
        try {
            BufferedImage BImgFanOn = ImageIO.read(new File(pathFanOn));
            BImgFanOn = toBufferedImage(resize(BImgFanOn));
            fanOn = new ImageIcon(BImgFanOn);

            BufferedImage BImgFanOff = ImageIO.read(new File(pathFanOff));
            BImgFanOff = toBufferedImage(resize(BImgFanOff));
            fanOff = new ImageIcon(BImgFanOff);
            this.updateFan();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    public Image resize(BufferedImage I) {
        Dimension D = (this.fanImagePanel.getSize().height == 0) ? this.fanImagePanel.getPreferredSize() : this.fanImagePanel.getSize();
        int size = (D.height == D.width) ? D.height : (D.height < D.width) ? D.height : D.width;
        return I.getScaledInstance(size, size, Image.SCALE_SMOOTH);
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

    public void updateFan() {
        try {
            if (isFanOn) {
                this.fanImageLabel.setIcon(fanOn);
            } else {
                this.fanImageLabel.setIcon(fanOff);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setAlarm(boolean b) {
        if (!b) {
            alarmbutton.setBackground(FrameBasique.OKColor);
            alarmbutton.setText("");
        } else {
            alarmbutton.setBackground(FrameBasique.ErrorColor);
            alarmbutton.setText("Résoudre");
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

        topPanel = new javax.swing.JPanel();
        cellNumber = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        acPanel = new javax.swing.JPanel();
        fanImagePanel = new javax.swing.JPanel();
        fanImageLabel = new javax.swing.JLabel();
        fanStatusPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        fanSpeed = new javax.swing.JProgressBar();
        cellCurrentVolumeBar = new javax.swing.JProgressBar();
        jPanel3 = new javax.swing.JPanel();
        statusPanel = new javax.swing.JPanel();
        typeLabel = new javax.swing.JLabel();
        grainType = new javax.swing.JLabel();
        temperatureLabel = new javax.swing.JLabel();
        grainMeanTemperature = new javax.swing.JLabel();
        humidityLabel = new javax.swing.JLabel();
        grainHumidity = new javax.swing.JLabel();
        volumeLabel = new javax.swing.JLabel();
        cellVolume = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        alarmbutton = new javax.swing.JButton();

        setBackground(FrameBasique.BackgroundColor);
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMinimumSize(new java.awt.Dimension(320, 160));
        setPreferredSize(new java.awt.Dimension(320, 160));
        setLayout(new java.awt.BorderLayout());

        topPanel.setBackground(FrameBasique.BackgroundColor);
        topPanel.setMaximumSize(new java.awt.Dimension(135, 135));
        topPanel.setLayout(new java.awt.GridLayout(1, 2));

        cellNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cellNumber.setText("-1");
        topPanel.add(cellNumber);

        add(topPanel, java.awt.BorderLayout.NORTH);

        jPanel1.setBackground(FrameBasique.BackgroundColor);
        jPanel1.setMaximumSize(new java.awt.Dimension(405, 135));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.X_AXIS));

        acPanel.setBackground(FrameBasique.BackgroundColor);
        acPanel.setMaximumSize(new java.awt.Dimension(200, 200));
        acPanel.setMinimumSize(new java.awt.Dimension(135, 135));
        acPanel.setPreferredSize(new java.awt.Dimension(135, 135));
        acPanel.setLayout(new java.awt.GridLayout(2, 1));

        fanImagePanel.setBackground(FrameBasique.BackgroundColor);
        fanImagePanel.setMinimumSize(new java.awt.Dimension(1, 1));
        fanImagePanel.setPreferredSize(new java.awt.Dimension(135, 73));
        fanImagePanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                fanImagePanelComponentResized(evt);
            }
        });
        fanImagePanel.setLayout(new java.awt.BorderLayout());

        fanImageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fanImagePanel.add(fanImageLabel, java.awt.BorderLayout.CENTER);

        acPanel.add(fanImagePanel);

        fanStatusPanel.setBackground(FrameBasique.BackgroundColor);
        fanStatusPanel.setLayout(new java.awt.GridLayout(2, 1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Puissance de la ventilation");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        fanStatusPanel.add(jLabel1);

        jPanel2.setBackground(FrameBasique.BackgroundColor);
        jPanel2.setMinimumSize(new java.awt.Dimension(20, 40));
        jPanel2.setPreferredSize(new java.awt.Dimension(125, 51));
        jPanel2.setLayout(new java.awt.CardLayout(10, 10));

        fanSpeed.setBackground(FrameBasique.BarBackgroundColor);
        fanSpeed.setValue(50);
        fanSpeed.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        fanSpeed.setPreferredSize(new java.awt.Dimension(20, 16));
        fanSpeed.setStringPainted(true);
        jPanel2.add(fanSpeed, "card2");

        fanStatusPanel.add(jPanel2);

        acPanel.add(fanStatusPanel);

        jPanel1.add(acPanel);

        cellCurrentVolumeBar.setBackground(FrameBasique.BarBackgroundColor);
        cellCurrentVolumeBar.setOrientation(1);
        cellCurrentVolumeBar.setValue(50);
        cellCurrentVolumeBar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        cellCurrentVolumeBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cellCurrentVolumeBar.setMaximumSize(new java.awt.Dimension(200, 200));
        cellCurrentVolumeBar.setMinimumSize(new java.awt.Dimension(20, 135));
        cellCurrentVolumeBar.setPreferredSize(new java.awt.Dimension(20, 135));
        cellCurrentVolumeBar.setStringPainted(true);
        jPanel1.add(cellCurrentVolumeBar);

        jPanel3.setMaximumSize(new java.awt.Dimension(200, 200));
        jPanel3.setMinimumSize(new java.awt.Dimension(135, 135));
        jPanel3.setPreferredSize(new java.awt.Dimension(135, 135));
        jPanel3.setLayout(new java.awt.BorderLayout());

        statusPanel.setBackground(FrameBasique.BackgroundColor);
        statusPanel.setMinimumSize(new java.awt.Dimension(100, 200));
        statusPanel.setPreferredSize(new java.awt.Dimension(135, 100));
        statusPanel.setLayout(new java.awt.GridLayout(4, 2));

        typeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        typeLabel.setText("Grain:");
        typeLabel.setMaximumSize(new java.awt.Dimension(100, 50));
        typeLabel.setMinimumSize(new java.awt.Dimension(65, 14));
        typeLabel.setPreferredSize(new java.awt.Dimension(65, 14));
        statusPanel.add(typeLabel);

        grainType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        grainType.setText("N/A");
        grainType.setMaximumSize(new java.awt.Dimension(100, 50));
        grainType.setMinimumSize(new java.awt.Dimension(65, 14));
        grainType.setPreferredSize(new java.awt.Dimension(65, 14));
        statusPanel.add(grainType);

        temperatureLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        temperatureLabel.setText("Temperature ");
        temperatureLabel.setMaximumSize(new java.awt.Dimension(100, 50));
        statusPanel.add(temperatureLabel);

        grainMeanTemperature.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        grainMeanTemperature.setText("-1");
        grainMeanTemperature.setMaximumSize(new java.awt.Dimension(100, 50));
        grainMeanTemperature.setMinimumSize(new java.awt.Dimension(65, 14));
        grainMeanTemperature.setPreferredSize(new java.awt.Dimension(65, 14));
        statusPanel.add(grainMeanTemperature);

        humidityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        humidityLabel.setText("Humidité");
        humidityLabel.setMaximumSize(new java.awt.Dimension(100, 50));
        humidityLabel.setMinimumSize(new java.awt.Dimension(65, 14));
        humidityLabel.setPreferredSize(new java.awt.Dimension(65, 14));
        statusPanel.add(humidityLabel);

        grainHumidity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        grainHumidity.setText("-1");
        grainHumidity.setMaximumSize(new java.awt.Dimension(100, 50));
        grainHumidity.setMinimumSize(new java.awt.Dimension(65, 14));
        grainHumidity.setPreferredSize(new java.awt.Dimension(65, 14));
        statusPanel.add(grainHumidity);

        volumeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        volumeLabel.setText("Volume");
        volumeLabel.setMaximumSize(new java.awt.Dimension(100, 50));
        volumeLabel.setMinimumSize(new java.awt.Dimension(65, 14));
        volumeLabel.setPreferredSize(new java.awt.Dimension(65, 14));
        statusPanel.add(volumeLabel);

        cellVolume.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cellVolume.setText("-1");
        cellVolume.setMaximumSize(new java.awt.Dimension(100, 50));
        cellVolume.setMinimumSize(new java.awt.Dimension(65, 14));
        cellVolume.setPreferredSize(new java.awt.Dimension(65, 14));
        statusPanel.add(cellVolume);

        jPanel3.add(statusPanel, java.awt.BorderLayout.CENTER);

        jPanel4.setBackground(FrameBasique.BackgroundColor);
        jPanel4.setLayout(new java.awt.GridLayout(2, 1));

        jButton1.setText("Infos Lot");
        jButton1.setMaximumSize(new java.awt.Dimension(135, 23));
        jButton1.setMinimumSize(new java.awt.Dimension(10, 23));
        jButton1.setPreferredSize(new java.awt.Dimension(135, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);

        jPanel5.setBackground(FrameBasique.BackgroundColor);
        jPanel5.setAlignmentX(0.0F);
        jPanel5.setAlignmentY(0.0F);
        jPanel5.setLayout(new java.awt.GridBagLayout());

        alarmbutton.setText("Résoudre");
        alarmbutton.setAlignmentY(0.0F);
        alarmbutton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        alarmbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alarmbuttonActionPerformed(evt);
            }
        });
        jPanel5.add(alarmbutton, new java.awt.GridBagConstraints());

        jPanel4.add(jPanel5);

        jPanel3.add(jPanel4, java.awt.BorderLayout.SOUTH);

        jPanel1.add(jPanel3);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void fanImagePanelComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_fanImagePanelComponentResized
        autoResizeFan();
    }//GEN-LAST:event_fanImagePanelComponentResized

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (cell.getLot() != null) {
            new PosteStatusSolo(SwingUtilities.getWindowAncestor(this), true, new PosteStatus(cell)).setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void alarmbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alarmbuttonActionPerformed
        this.cell.setPanne(false);
        this.setAlarm(false);
    }//GEN-LAST:event_alarmbuttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel acPanel;
    private javax.swing.JButton alarmbutton;
    private javax.swing.JProgressBar cellCurrentVolumeBar;
    private javax.swing.JLabel cellNumber;
    private javax.swing.JLabel cellVolume;
    private javax.swing.JLabel fanImageLabel;
    private javax.swing.JPanel fanImagePanel;
    private javax.swing.JProgressBar fanSpeed;
    private javax.swing.JPanel fanStatusPanel;
    private javax.swing.JLabel grainHumidity;
    private javax.swing.JLabel grainMeanTemperature;
    private javax.swing.JLabel grainType;
    private javax.swing.JLabel humidityLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JLabel temperatureLabel;
    private javax.swing.JPanel topPanel;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JLabel volumeLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        updateData();
    }
}
