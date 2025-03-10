/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latkuis;

import javax.swing.*;

/**
 *
 * @author lenovo
 */
public class HomePage extends JFrame{
    JLabel welcome = new JLabel("Selamat Datang");
    JLabel option = new JLabel("Silahkan pilih menu di bawah ini untuk membeli DVD.");
    
    JButton dvdanak = new JButton("DVD Anak");
    JButton dvddewasa = new JButton("DVD Dewasa");
    JButton dvdlansia = new JButton("DVD Lansia");
    JButton logoutButton = new JButton("Logout");
    
    
    HomePage(String username){
        //Setting Frame
        setVisible(true);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(600, 300);
        setTitle("Toko DVD");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Add Komponen GUI
        add(welcome);
        add(option);
        add(logoutButton);
        add(dvdanak);
        add(dvddewasa);
        add(dvdlansia);
     
        //Set Bounds
        welcome.setBounds(20, 20, 150, 20);
        option.setBounds(20, 40, 300, 30);
        
        dvdanak.setBounds(50, 90, 150, 50);
        dvddewasa.setBounds(220, 90, 150, 50);
        dvdlansia.setBounds(390, 90, 150, 50);
        
        logoutButton.setBounds(50, 150, 490, 30);
        
        // Aksi ketika tombol kategori ditekan
        dvdanak.addActionListener(e -> openHalamanPembelian("DVD Anak", 27891.0));
        dvddewasa.addActionListener(e -> openHalamanPembelian("DVD Dewasa", 35396.0));
        dvdlansia.addActionListener(e -> openHalamanPembelian("DVD Lansia", 38550.0));
       
    }
    
    private void openHalamanPembelian(String kategori, double harga) {
        this.setVisible(false);  // Sembunyikan halaman utama
        new HalamanPembelian(kategori, harga).setVisible(true);
    }
}
