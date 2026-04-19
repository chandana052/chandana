package first;

import java.util.*;

public class p5 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Blue");
        colors.add("Red");
        colors.add("Green");

        int n = 1; // delete 2nd element
        colors.remove(n);

        System.out.println(colors);
    }
}