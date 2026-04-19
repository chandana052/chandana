package fourth;

import javax.swing.*;
import java.awt.*;

public class SwingHello {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello Swing");
        JLabel label = new JLabel("Hello! VI C , Welcome to Swing Programming");

        label.setForeground(Color.BLUE);
        label.setFont(new Font("Arial", Font.PLAIN, 32));
        label.setHorizontalAlignment(JLabel.CENTER);

        frame.add(label);
        frame.setSize(700, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
