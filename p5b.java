package fifth;

import javax.swing.*;
import java.awt.*;

public class p5b {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tabbed Colors");

        JTabbedPane tab = new JTabbedPane();

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN);

        tab.add("RED", redPanel);
        tab.add("BLUE", bluePanel);
        tab.add("GREEN", greenPanel);

        frame.add(tab);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}