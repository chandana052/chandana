package fifth;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.util.HashMap;

public class p5c {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Country Capitals");

        String countries[] = {"USA","India","Vietnam","Canada","Denmark",
                "France","Great Britain","Japan","Africa","Greenland","Singapore"};

        JList<String> list = new JList<>(countries);

        HashMap<String, String> capitals = new HashMap<>();
        capitals.put("USA", "Washington D.C.");
        capitals.put("India", "New Delhi");
        capitals.put("Vietnam", "Hanoi");
        capitals.put("Canada", "Ottawa");
        capitals.put("Denmark", "Copenhagen");
        capitals.put("France", "Paris");
        capitals.put("Great Britain", "London");
        capitals.put("Japan", "Tokyo");
        capitals.put("Africa", "No Single Capital");
        capitals.put("Greenland", "Nuuk");
        capitals.put("Singapore", "Singapore");

        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                String country = list.getSelectedValue();
                System.out.println("Capital: " + capitals.get(country));
            }
        });

        frame.add(new JScrollPane(list));
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}