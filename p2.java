package first;

import java.util.*;

public class p2 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Blue");
        colors.add("Red");
        colors.add("Green");
        colors.add("Yellow");

        colors.remove(1); // remove 2nd element
        colors.remove("Blue"); // remove "Blue"

        System.out.println(colors);
    }
}