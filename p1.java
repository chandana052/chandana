package first;

import java.util.*;

public class p1 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Blue");
        colors.add("Red");
        colors.add("Green");
        colors.add("Yellow");

        if (colors.contains("Red")) {
            System.out.println("Red is available in the list");
        } else {
            System.out.println("Red is not available");
        }
    }
}