package second;

import java.util.*;

public class StringOperations {
    public static void main(String[] args) {

        // 1. String Creation and Basic Operations
        String str = " Hello Java Programming ";
        System.out.println("Original String: " + str);

        // 2. Length and Character Access
        System.out.println("Length: " + str.length());
        System.out.println("Character at index 2: " + str.charAt(2));

        // 3. String Comparison
        String str2 = "Hello Java Programming";
        System.out.println("Equals: " + str.equals(str2));
        System.out.println("Equals Ignore Case: " + str.trim().equalsIgnoreCase(str2));

        // 4. String Searching
        System.out.println("Contains 'Java': " + str.contains("Java"));
        System.out.println("Index of 'Java': " + str.indexOf("Java"));

        // 5. Substring Operations
        System.out.println("Substring (6 to 10): " + str.substring(6, 10));

        // 6. String Modification
        System.out.println("Replace Java with Python: " + str.replace("Java", "Python"));
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Lowercase: " + str.toLowerCase());

        // 7. Whitespace Handling
        String trimmed = str.trim();
        System.out.println("Trimmed String: '" + trimmed + "'");

        // 8. String Concatenation
        String concat = trimmed.concat(" Language");
        System.out.println("Concatenated String: " + concat);

        // 9. String Splitting
        String sentence = "Java is fun to learn";
        String[] words = sentence.split(" ");
        System.out.println("Split words:");
        for (String word : words) {
            System.out.println(word);
        }

        // 10. StringBuilder Demo
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println("StringBuilder: " + sb);

        // 11. String Formatting
        String formatted = String.format("Name: %s, Age: %d", "Chandana", 20);
        System.out.println("Formatted String: " + formatted);

        // 12. Validate Email
        String email = "example@gmail.com";
        if (email.contains("@") && email.startsWith("example") && email.endsWith(".com")) {
            System.out.println("Valid Email");
        } else {
            System.out.println("Invalid Email");
        }
    }
}