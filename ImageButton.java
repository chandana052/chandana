package fourth;

import javax.swing.*;
import java.awt.event.*;

public class ImageButton {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Button");

        // Replace with your image paths
        ImageIcon digitalIcon = new ImageIcon("digital_clock.png");
        ImageIcon hourGlassIcon = new ImageIcon("hour_glass.png");

        JButton btn1 = new JButton("Digital Clock", digitalIcon);
        JButton btn2 = new JButton("Hour Glass", hourGlassIcon);
        JLabel label = new JLabel();

        btn1.setBounds(30, 30, 200, 80);
        btn2.setBounds(250, 30, 200, 80);
        label.setBounds(150, 130, 250, 30);

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Digital Clock is pressed");
            }
        });

        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Hour Glass is pressed");
            }
        });

        frame.add(btn1);
        frame.add(btn2);
        frame.add(label);

        frame.setSize(500, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}