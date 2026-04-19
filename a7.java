package third;

public class a7 {
    public static String truncate(String str, int length) {
        if (str.length() <= length) return str;
        return str.substring(0, length) + "...";
    }

    public static void main(String[] args) {
        System.out.println(truncate("Hello Java Programming", 10));
    }
}