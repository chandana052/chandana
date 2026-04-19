package first;

import java.util.*;

public class p3 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Blue");
        colors.add("Red");
        colors.add("Green");

        Collections.sort(colors);
        System.out.println("Sorted List: " + colors);
    }
}