package fifth;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class p5a {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Country List");

        String countries[] = {"USA","India","Vietnam","Canada","Denmark",
                "France","Great Britain","Japan","Africa","Greenland","Singapore"};

        JList<String> list = new JList<>(countries);

        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                System.out.println("Selected: " + list.getSelectedValue());
            }
        });

        frame.add(new JScrollPane(list));
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}