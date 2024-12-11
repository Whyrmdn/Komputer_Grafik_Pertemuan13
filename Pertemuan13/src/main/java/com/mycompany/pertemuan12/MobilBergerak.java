package com.mycompany.pertemuan12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MobilBergerak extends JPanel implements ActionListener {
    private int carX = -50; // Posisi awal mobil di luar layar
    private final int carY = 200; // Posisi Y tetap
    private int cloudX = 600; // Posisi awal awan di luar layar kanan
    private final int cloudY = 50; // Posisi Y awan tetap
    private final int PANEL_WIDTH = 600;
    private final int PANEL_HEIGHT = 400;
    private final Timer timer;

    public MobilBergerak() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.WHITE);
        
        // Inisialisasi timer untuk animasi
        timer = new Timer(20, this); // 20ms delay antara setiap frame
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;

        // Menggambar jalan
        g2D.setColor(Color.DARK_GRAY);
        g2D.fillRect(0, 250, PANEL_WIDTH, 100);

        // Menggambar garis jalan
        g2D.setColor(Color.WHITE);
        for (int i = 0; i < PANEL_WIDTH; i += 100) {
            g2D.fillRect(i, 300, 50, 5);
        }

        // Menggambar mobil
        // Badan mobil
        g2D.setColor(Color.RED);
        g2D.fillRect(carX, carY, 100, 30);
        
        // Jendela mobil
        g2D.setColor(Color.CYAN);
        g2D.fillRect(carX + 30, carY - 20, 40, 20);
        
        // Roda
        g2D.setColor(Color.BLACK);
        g2D.fillOval(carX + 20, carY + 30, 30, 30);
        g2D.fillOval(carX + 50, carY + 30, 30, 30);

        // Menggambar awan
        g2D.setColor(Color.LIGHT_GRAY);
        g2D.fillOval(cloudX, cloudY, 60, 40);
        g2D.fillOval(cloudX - 30, cloudY + 10, 50, 30);
        g2D.fillOval(cloudX + 30, cloudY + 10, 50, 30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Menggerakkan mobil
        carX += 3; // Kecepatan pergerakan mobil
        
        // Reset posisi mobil jika keluar dari layar
        if (carX > PANEL_WIDTH) {
            carX = -50;
        }

        // Menggerakkan awan
        cloudX -= 2; // Kecepatan pergerakan awan

        // Reset posisi awan jika keluar dari layar
        if (cloudX < -100) {
            cloudX = PANEL_WIDTH;
        }
        
        // Memperbarui tampilan
        repaint();
    }
}
