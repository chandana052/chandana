package third;

public class a2 {
    public static int countOccurrences(String mainStr, String subStr) {
        int count = 0, index = 0;
        while ((index = mainStr.indexOf(subStr, index)) != -1) {
            count++;
            index += subStr.length();
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countOccurrences("Java Java Java", "Java"));
    }
}