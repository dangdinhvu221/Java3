/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day3;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPasswordField;

/**
 *
 * @author dangd
 */
public class DEMOJPASS extends JFrame {

    private JPasswordField pwd;

    public DEMOJPASS() {
        pwd = new JPasswordField();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new FlowLayout());

        this.pwd.setEchoChar('?');
        this.pwd.setColumns(10);
        this.getContentPane().add(this.pwd);
        this.addAction();
    }

    public void addAction() {
        DEMOJPASS that = this;
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
    }

    public static void main(String[] args) {
        DEMOJPASS d = new DEMOJPASS();
        d.setSize(400, 400);
        d.setVisible(true);
        d.setLocationRelativeTo(null);
    }

}
