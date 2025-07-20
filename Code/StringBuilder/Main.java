import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Java StringBuilder Tutorial ===\n");

        // ==========================================
        // 1. STRINGBUILDER DECLARATION & INITIALIZATION
        // ==========================================
        System.out.println("1. STRINGBUILDER DECLARATION & INITIALIZATION:");

        // Method 1: Default constructor (initial capacity of 16)
        StringBuilder sb1 = new StringBuilder();
        System.out.println("Default constructor - Initial capacity: " + sb1.capacity());
        System.out.println("Default constructor - Initial length: " + sb1.length());

        // Method 2: Constructor with initial capacity
        StringBuilder sb2 = new StringBuilder(50);
        System.out.println("With capacity 50 - Initial capacity: " + sb2.capacity());

        // Method 3: Constructor with initial string
        StringBuilder sb3 = new StringBuilder("Hello World");
        System.out.println("With initial string - Content: '" + sb3.toString() + "'");
        System.out.println("With initial string - Length: " + sb3.length());
        System.out.println("With initial string - Capacity: " + sb3.capacity());

        // Method 4: Constructor with CharSequence
        String initialStr = "Java Programming";
        StringBuilder sb4 = new StringBuilder(initialStr);
        System.out.println("From CharSequence - Content: '" + sb4.toString() + "'");

        System.out.println();

        // ==========================================
        // 2. APPEND OPERATIONS
        // ==========================================
        System.out.println("2. APPEND OPERATIONS:");

        StringBuilder appendDemo = new StringBuilder("Start");
        System.out.println("Initial: '" + appendDemo.toString() + "'");

        // Append string
        appendDemo.append(" -> String");
        System.out.println("After append(String): '" + appendDemo.toString() + "'");

        // Append char
        appendDemo.append(' ').append('X');
        System.out.println("After append(char): '" + appendDemo.toString() + "'");

        // Append int
        appendDemo.append(" -> ").append(42);
        System.out.println("After append(int): '" + appendDemo.toString() + "'");

        // Append boolean
        appendDemo.append(" -> ").append(true);
        System.out.println("After append(boolean): '" + appendDemo.toString() + "'");

        // Append float/double
        appendDemo.append(" -> ").append(3.14f).append(" -> ").append(2.718);
        System.out.println("After append(float/double): '" + appendDemo.toString() + "'");

        // Append long
        appendDemo.append(" -> ").append(123456789L);
        System.out.println("After append(long): '" + appendDemo.toString() + "'");

        // Append char array
        char[] chars = {'A', 'B', 'C'};
        appendDemo.append(" -> ").append(chars);
        System.out.println("After append(char[]): '" + appendDemo.toString() + "'");

        // Append substring from char array
        char[] moreChars = {'X', 'Y', 'Z', 'W'};
        appendDemo.append(" -> ").append(moreChars, 1, 2); // Start at index 1, length 2
        System.out.println("After append(char[], offset, len): '" + appendDemo.toString() + "'");

        System.out.println();

        // ==========================================
        // 3. INSERT OPERATIONS
        // ==========================================
        System.out.println("3. INSERT OPERATIONS:");

        StringBuilder insertDemo = new StringBuilder("Hello World");
        System.out.println("Initial: '" + insertDemo.toString() + "'");

        // Insert string at specific position
        insertDemo.insert(5, " Java");
        System.out.println("After insert(5, ' Java'): '" + insertDemo.toString() + "'");

        // Insert char
        insertDemo.insert(0, '[');
        insertDemo.insert(insertDemo.length(), ']');
        System.out.println("After insert chars at start/end: '" + insertDemo.toString() + "'");

        // Insert int
        insertDemo.insert(1, 2024).insert(5, ' ');
        System.out.println("After insert(int): '" + insertDemo.toString() + "'");

        // Insert boolean
        insertDemo.insert(10, true).insert(14, ' ');
        System.out.println("After insert(boolean): '" + insertDemo.toString() + "'");

        // Insert float/double
        insertDemo.insert(15, 3.14f).insert(19, ' ');
        System.out.println("After insert(float): '" + insertDemo.toString() + "'");

        // Insert char array
        char[] insertChars = {'(', ')', '!'};
        insertDemo.insert(insertDemo.length(), insertChars);
        System.out.println("After insert(char[]): '" + insertDemo.toString() + "'");

        System.out.println();

        // ==========================================
        // 4. DELETE OPERATIONS
        // ==========================================
        System.out.println("4. DELETE OPERATIONS:");

        StringBuilder deleteDemo = new StringBuilder("Hello Java Programming World");
        System.out.println("Initial: '" + deleteDemo.toString() + "'");

        // Delete range of characters
        deleteDemo.delete(5, 10); // Delete " Java"
        System.out.println("After delete(5, 10): '" + deleteDemo.toString() + "'");

        // Delete single character
        deleteDemo.deleteCharAt(deleteDemo.length() - 1); // Delete last character
        System.out.println("After deleteCharAt(last): '" + deleteDemo.toString() + "'");

        deleteDemo.deleteCharAt(0); // Delete first character
        System.out.println("After deleteCharAt(0): '" + deleteDemo.toString() + "'");

        // Delete all content (make it empty)
        StringBuilder clearDemo = new StringBuilder("This will be cleared");
        System.out.println("Before clear: '" + clearDemo.toString() + "'");
        clearDemo.delete(0, clearDemo.length());
        System.out.println("After clear: '" + clearDemo.toString() + "' (length: " + clearDemo.length() + ")");

        System.out.println();

        // ==========================================
        // 5. REPLACE OPERATIONS
        // ==========================================
        System.out.println("5. REPLACE OPERATIONS:");

        StringBuilder replaceDemo = new StringBuilder("Hello Java Programming");
        System.out.println("Initial: '" + replaceDemo.toString() + "'");

        // Replace range with new string
        replaceDemo.replace(6, 10, "Python"); // Replace "Java" with "Python"
        System.out.println("After replace(6, 10, 'Python'): '" + replaceDemo.toString() + "'");

        // Replace part of string
        replaceDemo.replace(0, 5, "Hi"); // Replace "Hello" with "Hi"
        System.out.println("After replace(0, 5, 'Hi'): '" + replaceDemo.toString() + "'");

        // Replace with longer string
        replaceDemo.replace(3, 9, "JavaScript"); // Replace "Python" with "JavaScript"
        System.out.println("After replace with longer string: '" + replaceDemo.toString() + "'");

        // Replace with shorter string
        replaceDemo.replace(3, 13, "C++"); // Replace "JavaScript" with "C++"
        System.out.println("After replace with shorter string: '" + replaceDemo.toString() + "'");

        System.out.println();

        // ==========================================
        // 6. REVERSE OPERATION
        // ==========================================
        System.out.println("6. REVERSE OPERATION:");

        StringBuilder reverseDemo = new StringBuilder("Hello World 123");
        System.out.println("Original: '" + reverseDemo.toString() + "'");

        reverseDemo.reverse();
        System.out.println("After reverse(): '" + reverseDemo.toString() + "'");

        // Reverse back to original
        reverseDemo.reverse();
        System.out.println("Reversed back: '" + reverseDemo.toString() + "'");

        // Reverse with special characters and numbers
        StringBuilder specialReverse = new StringBuilder("A1B2C3!@#");
        System.out.println("Special chars original: '" + specialReverse.toString() + "'");
        specialReverse.reverse();
        System.out.println("Special chars reversed: '" + specialReverse.toString() + "'");

        System.out.println();

        // ==========================================
        // 7. CAPACITY AND LENGTH OPERATIONS
        // ==========================================
        System.out.println("7. CAPACITY AND LENGTH OPERATIONS:");

        StringBuilder capacityDemo = new StringBuilder("Hello");
        System.out.println("Initial string: '" + capacityDemo.toString() + "'");
        System.out.println("Length: " + capacityDemo.length());
        System.out.println("Capacity: " + capacityDemo.capacity());

        // Ensure capacity
        capacityDemo.ensureCapacity(100);
        System.out.println("After ensureCapacity(100) - Capacity: " + capacityDemo.capacity());

        // Trim to size
        capacityDemo.trimToSize();
        System.out.println("After trimToSize() - Capacity: " + capacityDemo.capacity());
        System.out.println("Length remains: " + capacityDemo.length());

        // Set length (truncate or extend with null characters)
        capacityDemo.setLength(10);
        System.out.println("After setLength(10): '" + capacityDemo.toString() + "' (length: " + capacityDemo.length() + ")");

        capacityDemo.setLength(3);
        System.out.println("After setLength(3): '" + capacityDemo.toString() + "' (length: " + capacityDemo.length() + ")");

        System.out.println();

        // ==========================================
        // 8. CHARACTER ACCESS AND MODIFICATION
        // ==========================================
        System.out.println("8. CHARACTER ACCESS AND MODIFICATION:");

        StringBuilder charDemo = new StringBuilder("Hello World");
        System.out.println("Original: '" + charDemo.toString() + "'");

        // Get character at specific index
        char ch = charDemo.charAt(6);
        System.out.println("Character at index 6: '" + ch + "'");

        // Set character at specific index
        charDemo.setCharAt(6, 'w');
        System.out.println("After setCharAt(6, 'w'): '" + charDemo.toString() + "'");

        // Get characters in range
        char[] buffer = new char[5];
        charDemo.getChars(0, 5, buffer, 0); // Copy chars 0-4 to buffer starting at index 0
        System.out.print("getChars(0, 5) result: ");
        for (char c : buffer) {
            System.out.print(c);
        }
        System.out.println();

        System.out.println();

        // ==========================================
        // 9. SUBSTRING OPERATIONS
        // ==========================================
        System.out.println("9. SUBSTRING OPERATIONS:");

        StringBuilder subDemo = new StringBuilder("Java Programming Language");
        System.out.println("Original: '" + subDemo.toString() + "'");

        // Get substring from index to end
        String sub1 = subDemo.substring(5);
        System.out.println("substring(5): '" + sub1 + "'");

        // Get substring from start index to end index
        String sub2 = subDemo.substring(5, 16);
        System.out.println("substring(5, 16): '" + sub2 + "'");

        // Note: substring() returns a new String, doesn't modify the StringBuilder
        System.out.println("StringBuilder unchanged: '" + subDemo.toString() + "'");

        System.out.println();

        // ==========================================
        // 10. SEARCH OPERATIONS
        // ==========================================
        System.out.println("10. SEARCH OPERATIONS:");

        StringBuilder searchDemo = new StringBuilder("Hello Java Programming Java");
        System.out.println("String: '" + searchDemo.toString() + "'");

        // Find first occurrence
        int firstJava = searchDemo.indexOf("Java");
        System.out.println("First 'Java' at index: " + firstJava);

        // Find first occurrence starting from specific index
        int firstJavaFrom10 = searchDemo.indexOf("Java", 10);
        System.out.println("First 'Java' from index 10: " + firstJavaFrom10);

        // Find last occurrence
        int lastJava = searchDemo.lastIndexOf("Java");
        System.out.println("Last 'Java' at index: " + lastJava);

        // Find last occurrence before specific index
        int lastJavaBefore20 = searchDemo.lastIndexOf("Java", 20);
        System.out.println("Last 'Java' before index 20: " + lastJavaBefore20);

        // Search for character
        int firstL = searchDemo.indexOf("l");
        int lastL = searchDemo.lastIndexOf("l");
        System.out.println("First 'l' at index: " + firstL);
        System.out.println("Last 'l' at index: " + lastL);

        System.out.println();

        // ==========================================
        // 11. CONVERSION OPERATIONS
        // ==========================================
        System.out.println("11. CONVERSION OPERATIONS:");

        StringBuilder convertDemo = new StringBuilder("Hello World 123");
        System.out.println("StringBuilder: '" + convertDemo.toString() + "'");

        // Convert to String
        String convertedString = convertDemo.toString();
        System.out.println("Converted to String: '" + convertedString + "'");

        // Convert to char array
        char[] charArray = new char[convertDemo.length()];
        convertDemo.getChars(0, convertDemo.length(), charArray, 0);
        System.out.print("Converted to char array: ");
        for (char c : charArray) {
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.println();

        // ==========================================
        // 12. PRACTICAL EXAMPLES AND PERFORMANCE
        // ==========================================
        System.out.println("12. PRACTICAL EXAMPLES AND PERFORMANCE:");

        // Example 1: Building a formatted string
        StringBuilder formatted = new StringBuilder();
        formatted.append("Name: ").append("John Doe").append("\n");
        formatted.append("Age: ").append(25).append("\n");
        formatted.append("Score: ").append(95.5).append("\n");
        formatted.append("Passed: ").append(true);
        System.out.println("Formatted string:\n" + formatted.toString());

        // Example 2: Building HTML
        StringBuilder html = new StringBuilder();
        html.append("<html>\n");
        html.append("  <head>\n");
        html.append("    <title>").append("My Page").append("</title>\n");
        html.append("  </head>\n");
        html.append("  <body>\n");
        html.append("    <h1>").append("Welcome!").append("</h1>\n");
        html.append("  </body>\n");
        html.append("</html>");
        System.out.println("\nHTML example:\n" + html.toString());

        // Example 3: Processing user input
        Scanner scanner = new Scanner(System.in);
        StringBuilder userInput = new StringBuilder();

        System.out.print("\nEnter words (type 'done' to finish): ");
        String word;
        while (!(word = scanner.next()).equals("done")) {
            if (userInput.length() > 0) {
                userInput.append(" ");
            }
            userInput.append(word);
        }

        System.out.println("You entered: '" + userInput.toString() + "'");
        System.out.println("Word count: " + (userInput.length() > 0 ? userInput.toString().split(" ").length : 0));

        // Example 4: Performance demonstration
        System.out.println("\nPerformance comparison (time in milliseconds):");

        // String concatenation (inefficient)
        long startTime = System.currentTimeMillis();
        String stringConcat = "";
        for (int i = 0; i < 1000; i++) {
            stringConcat += "a";
        }
        long stringTime = System.currentTimeMillis() - startTime;

        // StringBuilder (efficient)
        startTime = System.currentTimeMillis();
        StringBuilder sbConcat = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sbConcat.append("a");
        }
        String sbResult = sbConcat.toString();
        long sbTime = System.currentTimeMillis() - startTime;

        System.out.println("String concatenation time: " + stringTime + "ms");
        System.out.println("StringBuilder time: " + sbTime + "ms");
        System.out.println("StringBuilder is " + (stringTime > sbTime ? (stringTime - sbTime) : 0) + "ms faster");

        // Example 5: Method chaining
        StringBuilder chained = new StringBuilder("Start")
                .append(" -> ")
                .append("Method")
                .append(" -> ")
                .append("Chaining")
                .append(" -> ")
                .append("End");
        System.out.println("\nMethod chaining result: '" + chained.toString() + "'");

        scanner.close();

        System.out.println("\n=== End of StringBuilder Tutorial ===");
    }
}