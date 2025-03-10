/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latkuis;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;

/**
 *
 * @author lenovo
 */
public class HalamanPembelian extends JFrame implements ActionListener {
    JLabel lblKategori, lblHarga, lblTotalHarga, lblPPN, lblFinalTotal;
    JTextField txtQty;
    JButton beliButton, logoutButton;
    DecimalFormat formatter = new DecimalFormat("#,###");
    final double PPN = 0.11;
    double hargaPcs;
    String username;
    JLabel lblQty = new JLabel("Jumlah:");

    public HalamanPembelian(String kategori, double harga) {
        this.hargaPcs = harga;
        
        //Setting Frame
        setTitle("Halaman Pembelian");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2, 10, 10));

        lblKategori = new JLabel("Kategori: " + kategori);
        lblHarga = new JLabel("Harga: Rp" + formatter.format(harga) + " /pcs");
        
        txtQty = new JTextField();
        beliButton = new JButton("Beli");
        logoutButton = new JButton("Kembali");

        lblTotalHarga = new JLabel("Rp 0");
        lblPPN = new JLabel("Rp 0");
        lblFinalTotal = new JLabel("Rp 0");

        add(lblKategori);
        add(new JLabel(""));
        add(lblHarga);
        add(new JLabel(""));
        add(lblQty);
        add(txtQty);
        add(beliButton);
        add(logoutButton);
        add(new JLabel("Harga Satuan:"));
        add(lblTotalHarga);
        add(new JLabel("PPN (11%):"));
        add(lblPPN);
        add(new JLabel("Total Harga:"));
        add(lblFinalTotal);
        
        // Tombol beli
        beliButton.addActionListener(e -> prosesPembelian());

        // Tombol kembali ke halaman utama
        logoutButton.addActionListener(this);
        
        
    }
    
     private void prosesPembelian() {
        try {
            int qty = Integer.parseInt(txtQty.getText());
            double totalSebelumPPN = hargaPcs * qty;
            double ppn = totalSebelumPPN * PPN;
            double totalHarga = totalSebelumPPN + ppn;
            
            lblHarga.setText("Rp" + formatter.format(hargaPcs));
            lblTotalHarga.setText("Rp" + formatter.format(hargaPcs * qty));
            lblPPN.setText("Rp" + formatter.format(ppn));
            lblFinalTotal.setText("Rp" + formatter.format(totalHarga));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Masukkan jumlah yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        try {
            if (e.getSource() == logoutButton) {
                    new HomePage(username); //Open Frame
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Masih Mau Lanjut?");
                }
        } 
        catch (Exception err) {
            
        }
               
    }
}
