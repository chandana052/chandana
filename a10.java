package third;

public class a10 {
    public static int countWords(String str) {
        if (str == null || str.trim().isEmpty()) return 0;
        return str.trim().split("\\s+").length;
    }

    public static void main(String[] args) {
        System.out.println(countWords("Java is easy to learn"));
    }
}
