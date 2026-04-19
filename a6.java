package third;

public class a6 {
    public static String capitalizeWords(String str) {
        String[] words = str.split(" ");
        String result = "";
        for (String word : words) {
            if (word.length() > 0)
                result += Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ";
        }
        return result.trim();
    }

    public static void main(String[] args) {
        System.out.println(capitalizeWords("java programming language"));
    }
}