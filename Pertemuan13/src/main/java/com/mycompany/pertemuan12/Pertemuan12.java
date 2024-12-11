/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pertemuan12;

import javax.swing.JFrame;

/**
 *
 * @author THINKPAD
 */
public class Pertemuan12 {

    public static void main(String[] args) {
        // Membuat frame untuk animasi
        JFrame frame = new JFrame();
        frame.setTitle("Animasi 2D - <Mobil Bergerak>");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menambahkan panel animasi ke frame
        MobilBergerak panel = new MobilBergerak();
        frame.setSize(400, 400); // Ukuran jendela
        frame.getContentPane().add(panel);
        frame.setVisible(true); // Menampilkan frame
    }
}
