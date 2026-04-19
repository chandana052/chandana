package fourth;

import javax.swing.*;
import java.awt.event.*;

public class CountryButton {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Country Button");

        JButton btn1 = new JButton("Srilanka");
        JButton btn2 = new JButton("India");
        JLabel label = new JLabel();

        btn1.setBounds(50, 50, 100, 30);
        btn2.setBounds(200, 50, 100, 30);
        label.setBounds(100, 120, 200, 30);

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Srilanka is pressed");
            }
        });

        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("India is pressed");
            }
        });

        frame.add(btn1);
        frame.add(btn2);
        frame.add(label);

        frame.setSize(400, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}