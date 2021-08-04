/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day4;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author dangd
 */
public class DemoFlowLayout extends JFrame {

    private JButton[] list;

    public DemoFlowLayout() {
        //
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.RIGHT);
        this.getContentPane().setLayout(fl);
        this.setLocationRelativeTo(null);
        this.list = new JButton[10];
        for (int i = 0; i < 10; i++) {
            JButton button = new JButton("Button" + i);
            this.list[i] = button;
            this.getContentPane().add(button);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new DemoFlowLayout();
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
