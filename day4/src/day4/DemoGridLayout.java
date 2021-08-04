/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day4;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author dangd
 */
public class DemoGridLayout extends JFrame {
    private JButton[] list;

    public DemoGridLayout() {
        GridLayout gridLayout  = new GridLayout(4, 5, 5, 5);
        this.getContentPane().setLayout(gridLayout);
        this.setLocationRelativeTo(null);
        
        this.list = new JButton[10];
        for (int i = 0; i < 10; i++) {
            JButton button = new JButton("" + i);
            this.list[i] = button;
            this.getContentPane().add(button);
        }
        
        JButton button1 = new JButton("+");
        JButton button2 = new JButton("-");
        JButton button3 = new JButton("*");
        JButton button4 = new JButton("/");
        JButton button5 = new JButton("=");
        JButton button6 = new JButton("C");
        this.getContentPane().add(button1);
        this.getContentPane().add(button2);
        this.getContentPane().add(button3);
        this.getContentPane().add(button4);
        this.getContentPane().add(button5);
        this.getContentPane().add(button6);
        

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        JFrame frame = new DemoGridLayout();
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}
