package first;

import java.util.*;

public class p8 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Blue");

        list.offerLast("Pink");

        System.out.println(list);
    }
}