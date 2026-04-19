package fifth;

import javax.swing.*;
import java.awt.*;

public class p5d {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CMY Colors");

        JTabbedPane tab = new JTabbedPane();

        JPanel cyan = new JPanel();
        cyan.setBackground(Color.CYAN);

        JPanel magenta = new JPanel();
        magenta.setBackground(Color.MAGENTA);

        JPanel yellow = new JPanel();
        yellow.setBackground(Color.YELLOW);

        tab.add("Cyan", cyan);
        tab.add("Magenta", magenta);
        tab.add("Yellow", yellow);

        frame.add(tab);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}