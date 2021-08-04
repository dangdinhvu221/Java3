/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day4;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author dangd
 */
public class DemoBoderLayout extends JFrame {

    public DemoBoderLayout() {
        this.getContentPane().setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        JButton button1 = new JButton("Button - Center");
        JButton button2 = new JButton("Button2 - PAGE_START");
        JButton button3 = new JButton("Button3 - LINE_START");
        JButton button4 = new JButton("Button4 - PAGE_END");
        JButton button5 = new JButton("Button5 - LINE_END");
        
        this.getContentPane().add(button1, BorderLayout.CENTER);
        this.getContentPane().add(button2, BorderLayout.PAGE_START);
        this.getContentPane().add(button3, BorderLayout.LINE_START);
        this.getContentPane().add(button4, BorderLayout.PAGE_END);
        this.getContentPane().add(button5, BorderLayout.LINE_END);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        JFrame frame = new DemoBoderLayout();
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}
