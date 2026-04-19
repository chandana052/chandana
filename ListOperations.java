package first;

import java.util.*;

public class ListOperations {

    // 1. Adding elements
    public static void addElements(List<String> list) {
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
    }

    // 2. Adding element at specific index
    public static void addAtIndex(List<String> list) {
        list.add(1, "Mango");
    }

    // 3. Adding multiple elements
    public static void addMultiple(List<String> list) {
        List<String> extra = Arrays.asList("Grapes", "Pineapple");
        list.addAll(extra);
    }

    // 4. Accessing elements
    public static void accessElements(List<String> list) {
        System.out.println("Element at index 2: " + list.get(2));
    }

    // 5. Updating elements
    public static void updateElements(List<String> list) {
        list.set(0, "Green Apple");
    }

    // 6. Removing elements
    public static void removeElements(List<String> list) {
        list.remove("Banana");
    }

    // 7. Searching elements
    public static void searchElements(List<String> list) {
        System.out.println("Contains Orange? " + list.contains("Orange"));
    }

    // 8. List size
    public static void listSize(List<String> list) {
        System.out.println("Size: " + list.size());
    }

    // 9. Iterating over list
    public static void iterateList(List<String> list) {
        System.out.println("Using for-each:");
        for (String item : list) {
            System.out.println(item);
        }
    }

    // 10. Using Iterator
    public static void useIterator(List<String> list) {
        System.out.println("Using Iterator:");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    // 11. Sorting
    public static void sortList(List<String> list) {
        Collections.sort(list);
    }

    // 12. Sublist
    public static void subList(List<String> list) {
        List<String> sub = list.subList(0, Math.min(2, list.size()));
        System.out.println("Sublist: " + sub);
    }

    // 13. Clearing the list
    public static void clearList(List<String> list) {
        list.clear();
        System.out.println("List cleared. Size: " + list.size());
    }

    public static void main(String[] args) {

        // ArrayList
        System.out.println("=== ArrayList Operations ===");
        List<String> arrayList = new ArrayList<>();
        performOperations(arrayList);

        // LinkedList
        System.out.println("\n=== LinkedList Operations ===");
        List<String> linkedList = new LinkedList<>();
        performOperations(linkedList);
    }

    public static void performOperations(List<String> list) {
        addElements(list);
        addAtIndex(list);
        addMultiple(list);

        accessElements(list);
        updateElements(list);
        removeElements(list);
        searchElements(list);
        listSize(list);

        iterateList(list);
        useIterator(list);

        sortList(list);
        System.out.println("Sorted List: " + list);

        subList(list);
        clearList(list);
    }
}
