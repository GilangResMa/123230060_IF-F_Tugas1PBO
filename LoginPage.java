/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latkuis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author lenovo
 */

public class LoginPage extends JFrame implements ActionListener {
    //Instansiasi Komponen GUI
    JLabel tulisan = new JLabel("Login Page");
    
    JLabel usernameLabel = new JLabel("Username");
    JTextField usernameTextField = new JTextField();
    
    JLabel passwordLabel = new JLabel("Password");
    JPasswordField passwordField = new JPasswordField();
    
    JButton loginButton = new JButton("Login");

        LoginPage(){
        //Setting Frame
        setVisible(true);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(600, 320);
        setTitle("Toko DVD");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Add Komponen GUI
        add(tulisan);
        add(usernameLabel);
        add(passwordLabel);
        add(usernameTextField);
        add(passwordField);
        add(loginButton);
        
        //Set Bounds
        tulisan.setBounds(260, 35, 150, 20);
        usernameLabel.setBounds(75, 75, 440, 20);
        usernameTextField.setBounds(75, 100, 440, 30);
        passwordLabel.setBounds(75, 140, 440, 20);
        passwordField.setBounds(75, 165, 440, 30);
        loginButton.setBounds(220, 220, 150, 30);
        loginButton.addActionListener(this);  
    }
    
    //EventHandling
    @Override
    public void actionPerformed(ActionEvent e){
        try {
            if (e.getSource() == loginButton) {
                String username = usernameTextField.getText();
                char[] passChar = passwordField.getPassword();
                String password = new String(passChar);
                
                if (username.equals("123230060") && password.equals("060032321")) {
                    System.out.println("Selamat Datang, " + username);
                    
                    new HomePage(username); //Open Frame
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Who Are You?");
                }
            } else {
                
            }
        } 
        catch (Exception err) {
            
        }
    }
}
