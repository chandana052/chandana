package third;

public class a1 {
    public static boolean isNullOrEmpty(String str) {
        return (str == null || str.trim().isEmpty());
    }

    public static void main(String[] args) {
        String str = "   ";
        System.out.println(isNullOrEmpty(str));
    }
}