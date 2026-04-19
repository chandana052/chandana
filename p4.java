package first;

import java.util.*;

public class p4 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Blue");
        colors.add("Red");
        colors.add("Green");

        List<String> sub = colors.subList(0, 2);
        System.out.println("SubList: " + sub);
    }
}