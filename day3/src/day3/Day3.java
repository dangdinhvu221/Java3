/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day3;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

/**
 *
 * @author dangd
 */
public class Day3 extends JFrame {

    private JCheckBox chkC, chkCs, chkPHP, chkJava;
    private ImageIcon chkedIcon, uncheckedIcon;

    public Day3() {
        this.getContentPane().setLayout(new FlowLayout());
        this.chkC = new JCheckBox("C/C++");
        this.chkCs = new JCheckBox("Cs");
        this.chkJava = new JCheckBox("Java");
        this.chkPHP = new JCheckBox("Java");

        this.chkedIcon = new ImageIcon("");
        this.uncheckedIcon = new ImageIcon("");

        this.chkJava.setIcon(this.uncheckedIcon);

        this.getContentPane().add(chkC);
        this.getContentPane().add(chkCs);
        this.getContentPane().add(chkPHP);
        this.getContentPane().add(chkCs);

        Day3 that = this;
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isChecked = that.chkJava.isSelected();
                if (isChecked) {
                    that.chkJava.setIcon(that.chkedIcon);
                } else {
                    that.chkJava.setIcon(that.uncheckedIcon);
                }
            }
        };
    }
    public static void main(String[] args) {
        Day3 d3 = new Day3();
        d3.setSize(400, 400);
        d3.setVisible(true);
    }
}
