package first;

import java.util.*;

public class p6 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Blue");
        list.add("Green");

        Iterator<String> it = list.listIterator(1);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}