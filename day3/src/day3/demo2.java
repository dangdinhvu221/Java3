/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day3;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

/**
 *
 * @author dangd
 */
public class demo2 extends JFrame {

    private JRadioButton rdoCat, rdoDog;
    private ImageIcon iconCat, iconDog;

    public demo2() {
        this.getContentPane().setLayout(new FlowLayout());
        this.rdoCat = new JRadioButton("Cat");
        this.rdoDog = new JRadioButton("Dog");

        this.iconCat = new ImageIcon(getClass().getResource("/day3/10207-man-student-light-skin-tone-icon-16.png"));
        this.iconDog = new ImageIcon(getClass().getResource("/day3/Actions-edit-delete-icon-16.png"));

//        this.rdoDog.setIcon(this.iconDog);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rdoCat);
        bg.add(rdoDog);

        this.rdoCat.setSelected(true);
        this.rdoCat.setIcon(this.iconCat);
        this.getContentPane().add(this.rdoCat);
        this.getContentPane().add(this.rdoDog);
        this.addAction();
        this.setLocationRelativeTo(null);
    }

    public void addAction() {
        demo2 that = this;
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String click = e.getActionCommand();
                if (click.equals("Cat")) {
                    that.rdoCat.setIcon(that.iconCat);
                    that.rdoDog.setIcon(null);
                } else {
                    that.rdoDog.setIcon(that.iconDog);
                    that.rdoCat.setIcon(null);
                }
            }
        };
        this.rdoCat.addActionListener(listener);
        this.rdoDog.addActionListener(listener);
    }

    public static void main(String[] args) {
        demo2 d3 = new demo2();
        d3.setSize(400, 400);
        d3.setVisible(true);
    }
}
