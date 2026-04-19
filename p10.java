package first;

import java.util.*;

public class p10 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Blue");
        list.add("Green");

        Collections.swap(list, 0, 2);

        System.out.println(list);
    }
}