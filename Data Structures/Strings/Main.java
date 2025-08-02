import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Java Strings Tutorial ===\n");
        
        // ==========================================
        // 1. STRING DECLARATION
        // ==========================================
        System.out.println("1. STRING DECLARATION:");
        
        // Method 1: String literal (most common)
        String str1 = "Hello World";
        System.out.println("String literal: " + str1);
        
        // Method 2: Using new keyword
        String str2 = new String("Hello World");
        System.out.println("Using new keyword: " + str2);
        
        // Method 3: Empty string
        String str3 = "";
        String str4 = new String();
        System.out.println("Empty strings: '" + str3 + "' and '" + str4 + "'");
        
        // Method 4: From character array
        char[] charArray = {'J', 'a', 'v', 'a'};
        String str5 = new String(charArray);
        System.out.println("From char array: " + str5);
        
        System.out.println();
        
        // ==========================================
        // 2. TAKING INPUT AS STRING
        // ==========================================
        System.out.println("2. TAKING INPUT AS STRING:");
        
        Scanner scanner = new Scanner(System.in);
        
        // Reading a single word (stops at whitespace)
        System.out.print("Enter a single word: ");
        String singleWord = scanner.next();
        System.out.println("You entered: " + singleWord);
        
        // Clear the buffer
        scanner.nextLine();
        
        // Reading a full line (includes spaces)
        System.out.print("Enter a full sentence: ");
        String fullSentence = scanner.nextLine();
        System.out.println("You entered: " + fullSentence);
        
        System.out.println();
        
        // ==========================================
        // 3. STRING CONCATENATION
        // ==========================================
        System.out.println("3. STRING CONCATENATION:");
        
        String firstName = "John";
        String lastName = "Doe";
        
        // Method 1: Using + operator
        String fullName1 = firstName + " " + lastName;
        System.out.println("Using + operator: " + fullName1);
        
        // Method 2: Using concat() method
        String fullName2 = firstName.concat(" ").concat(lastName);
        System.out.println("Using concat() method: " + fullName2);
        
        // Method 3: Using String.format()
        String fullName4 = String.format("%s %s", firstName, lastName);
        System.out.println("Using String.format(): " + fullName4);
        
        System.out.println();
        
        // ==========================================
        // 4. LENGTH OF A STRING
        // ==========================================
        System.out.println("4. LENGTH OF A STRING:");
        
        String sampleText = "Java Programming";
        int length = sampleText.length();
        System.out.println("String: '" + sampleText + "'");
        System.out.println("Length: " + length + " characters");
        
        // Empty string length
        String emptyStr = "";
        System.out.println("Empty string length: " + emptyStr.length());
        
        // String with spaces
        String stringWithSpaces = "   Hello World   ";
        System.out.println("String with spaces: '" + stringWithSpaces + "' has length: " + stringWithSpaces.length());
        
        System.out.println();
        
        // ==========================================
        // 5. ACCESSING SPECIFIC CHARACTERS
        // ==========================================
        System.out.println("5. ACCESSING SPECIFIC CHARACTERS:");
        
        String word = "Programming";
        System.out.println("String: '" + word + "'");
        
        // charAt() method - gets character at specific index (0-based)
        char firstChar = word.charAt(0);
        char lastChar = word.charAt(word.length() - 1);
        char middleChar = word.charAt(word.length() / 2);
        
        System.out.println("First character (index 0): " + firstChar);
        System.out.println("Last character (index " + (word.length() - 1) + "): " + lastChar);
        System.out.println("Middle character (index " + (word.length() / 2) + "): " + middleChar);
        
        // Converting string to character array
        char[] charArr = word.toCharArray();
        System.out.print("All characters: ");
        for (int i = 0; i < charArr.length; i++) {
            System.out.print(charArr[i] + " ");
        }
        System.out.println();
        
        System.out.println();
        
        // ==========================================
        // 6. STRING COMPARISON
        // ==========================================
        System.out.println("6. STRING COMPARISON:");
        
        String str6 = "Hello";
        String str7 = "hello";
        String str8 = "Hello";
        String str9 = new String("Hello");
        
        // Method 1: equals() - case sensitive
        System.out.println("str6.equals(str7): " + str6.equals(str7)); // false
        System.out.println("str6.equals(str8): " + str6.equals(str8)); // true
        System.out.println("str6.equals(str9): " + str6.equals(str9)); // true
        
        // Method 2: equalsIgnoreCase() - case insensitive
        System.out.println("str6.equalsIgnoreCase(str7): " + str6.equalsIgnoreCase(str7)); // true
        
        // Method 3: compareTo() - lexicographic comparison
        System.out.println("str6.compareTo(str7): " + str6.compareTo(str7)); // negative (H < h in ASCII)
        System.out.println("str6.compareTo(str8): " + str6.compareTo(str8)); // 0 (equal)
        
        // Method 4: compareToIgnoreCase() - case insensitive lexicographic comparison
        System.out.println("str6.compareToIgnoreCase(str7): " + str6.compareToIgnoreCase(str7)); // 0
        
        // DON'T use == for string comparison (compares references, not content)
        System.out.println("str6 == str8: " + (str6 == str8)); // true (string pool)
        System.out.println("str6 == str9: " + (str6 == str9)); // false (different objects)
        
        System.out.println();
        
        // ==========================================
        // 7. SUBSTRING METHODS
        // ==========================================
        System.out.println("7. SUBSTRING METHODS:");
        
        String text = "Java Programming Language";
        System.out.println("Original string: '" + text + "'");
        
        // substring(int beginIndex) - from beginIndex to end
        String sub1 = text.substring(5);
        System.out.println("substring(5): '" + sub1 + "'");
        
        // substring(int beginIndex, int endIndex) - from beginIndex to endIndex-1
        String sub2 = text.substring(5, 16);
        System.out.println("substring(5, 16): '" + sub2 + "'");
        
        // Additional useful string methods
        System.out.println("\nAdditional String Methods:");
        
        // contains() - checks if string contains substring
        System.out.println("Contains 'Program': " + text.contains("Program"));
        
        // startsWith() and endsWith()
        System.out.println("Starts with 'Java': " + text.startsWith("Java"));
        System.out.println("Ends with 'Language': " + text.endsWith("Language"));
        
        // indexOf() and lastIndexOf() - find position of substring
        System.out.println("Index of 'a': " + text.indexOf('a'));
        System.out.println("Last index of 'a': " + text.lastIndexOf('a'));
        System.out.println("Index of 'Program': " + text.indexOf("Program"));
        
        // replace() methods
        String replaced = text.replace('a', '@');
        System.out.println("Replace 'a' with '@': " + replaced);
        
        String replacedWord = text.replace("Programming", "Development");
        System.out.println("Replace 'Programming' with 'Development': " + replacedWord);
        
        // trim() - removes leading and trailing whitespace
        String stringWithSpaces2 = "   Hello World   ";
        System.out.println("Before trim: '" + stringWithSpaces2 + "'");
        System.out.println("After trim: '" + stringWithSpaces2.trim() + "'");
        
        // toUpperCase() and toLowerCase()
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println("Lowercase: " + text.toLowerCase());
        
        // split() - splits string into array
        String[] words = text.split(" ");
        System.out.print("Split by space: ");
        for (String word1 : words) {
            System.out.print("'" + word1 + "' ");
        }
        System.out.println();
        
        scanner.close();
        
        System.out.println("\n=== End of Strings Tutorial ===");
    }
}