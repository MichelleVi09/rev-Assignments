package labPractice;
import java.util.Arrays;

public class JavaBasicPracticeSolutions {

    public static void main(String[] args) throws InterruptedException {
        // LEVEL 1: BEGINNER
        // Q1. Reverse a number without converting it to a String
        System.out.println("Q1: " + reverseNumber(12345)); // 54321
        System.out.println("Q1: " + reverseNumber(908));   // 809
        System.out.println("Q1: " + reverseNumber(-120));  // -21
        System.out.println("Q1 overflow: " + reverseNumber(1534236469)); // overflow detected

        // Q2. Type casting
        int a = 10;
        double b = 3.5;
        int result = (int) (a + b);
        System.out.println("\nQ2:");
        System.out.println(result); // 13
        char ch = 'A';
        int value = ch + 5;
        System.out.println(value);       // 70
        System.out.println((char) value); // F

        // Q3. Count vowels and consonants
        System.out.println("\nQ3:");
        countVowelsAndConsonants("Programming");

        // Q4. Convert String to wrapper classes
        System.out.println("\nQ4:");
        convertWrapperValues("25", "45000.75", "true");

        // Q5. Anagrams
        System.out.println("\nQ5:");
        System.out.println(areAnagrams("listen", "silent")); // Anagram
        System.out.println(areAnagrams("hello", "world"));   // Not Anagram

        // LEVEL 2: INTERMEDIATE
        // Q6. Swap without a third variable
        System.out.println("\nQ6:");
        swapArithmetic(10, 20);
        swapXor(10, 20);

        // Q7. Pass by value
        System.out.println("\nQ7:");
        int primitive = 10;
        int[] numbers = {10, 20, 30};
        modify(primitive);
        modifyArray(numbers);
        System.out.println(primitive);  // 10
        System.out.println(numbers[0]); // 100
        int[] original = {1, 2, 3};
        reassignArray(original);
        System.out.println(Arrays.toString(original)); // [1, 2, 3]

        // Q8. Remove duplicate characters without Set or Map
        System.out.println("\nQ8:");
        System.out.println(removeDuplicates("programming")); // progamin

        // Q9. First non-repeated character
        System.out.println("\nQ9:");
        System.out.println(firstNonRepeated("swiss"));  // w
        System.out.println(firstNonRepeated("aabbcc")); // No non-repeated character

        // Q10. Predict String output
        System.out.println("\nQ10:");
        stringBehaviorDemo();

        // LEVEL 3: ADVANCED
        // Q11. Longest substring without repeating characters
        System.out.println("\nQ11:");
        System.out.println(longestUniqueSubstringLength("abcabcbb")); // 3
        System.out.println(longestUniqueSubstringLength("pwwkew"));   // 3
        System.out.println(longestUniqueSubstringLength(""));         // 0

        // Q12. String compression
        System.out.println("\nQ12:");
        System.out.println(compress("aaabbccccd")); // a3b2c4d1
        System.out.println(compress("abc"));        // a1b1c1

        // Q13. Reverse word order without split()
        System.out.println("\nQ13:");
        System.out.println(reverseWords("Java is easy to learn"));
        System.out.println(reverseWords("  Java   is easy  "));

        // Q14. StringBuilder vs StringBuffer and threads
        System.out.println("\nQ14:");
        stringBuilderVsBufferDemo();

        // Q15. Employee salary processing
        System.out.println("\nQ15:");
        processEmployee("101", "Rahul", "60000", "20", "true");
    }

    //Q1
    //Returns -1 if the reversed value cannot fit in a long? For an int input,
    //a reversed int can fit in long, so long is used to avoid int overflow.
    public static long reverseNumber(int number) {
        long n = number;
        boolean negative = n < 0;
        if (negative) {
            n = -n;
        }
        long reversed = 0;
        while (n > 0) {
            long digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }
        return negative ? -reversed : reversed;
    }

    //Q3
    public static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = Character.toLowerCase(text.charAt(i));
            if (c >= 'a' && c <= 'z') {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowels++;
                }else {
                    consonants++;
                }
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    //Q4
    public static void convertWrapperValues(String ageText, String salaryText, String activeText) {
        try {
            Integer age = Integer.valueOf(ageText);
            Double salary = Double.valueOf(salaryText);
            Boolean active = Boolean.valueOf(activeText);
            double increasedSalary = salary * 1.10;
            System.out.println("Age: " + age + " (Integer)");
            System.out.println("Salary: " + salary + " (Double)");
            System.out.println("Active: " + active + " (Boolean)");
            System.out.println("Salary after 10% increment: " + increasedSalary);
        } catch (NumberFormatException ex) {
            System.out.println("Invalid age or salary: " + ex.getMessage());
        }
    }

    //Q5
    public static boolean areAnagrams(String first, String second) {
        int[] frequency = new int[Character.MAX_VALUE + 1];
        for (int i = 0; i < first.length(); i++) {
            char c = Character.toLowerCase(first.charAt(i));
            if (!Character.isWhitespace(c)) {
                frequency[c]++;
            }
        }
        for (int i = 0; i < second.length(); i++) {
            char c = Character.toLowerCase(second.charAt(i));
            if (!Character.isWhitespace(c)) {
                frequency[c]--;
            }
        }
        for (int count : frequency) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
    //Q6
    public static void swapArithmetic(int a, int b) {
        // This arithmetic method can overflow for some int values.
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("Arithmetic swap: a=" + a + ", b=" + b);
    }
    public static void swapXor(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("XOR swap: a=" + a + ", b=" + b);
    }

    // Q7
    public static void modify(int x) {
        x = 100;
    }
    public static void modifyArray(int[] arr) {
        arr[0] = 100;
    }
    public static void reassignArray(int[] arr) {
        arr = new int[]{7, 8, 9};
        //This only changes the local copy of the array reference.
    }

    // Q8
    public static String removeDuplicates(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            boolean alreadyExists = false;
            for (int j = 0; j < result.length(); j++) {
                if (result.charAt(j) == current) {
                    alreadyExists = true;
                    break;
                }
            }
            if (!alreadyExists) {
                result.append(current);
            }
        }
        return result.toString();
    }

    // Q9
    public static String firstNonRepeated(String text) {
        int[] frequency = new int[Character.MAX_VALUE + 1];
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (frequency[c] == 1) {
                return String.valueOf(c);
            }
        }
        return "No non-repeated character";
    }

    // Q10
    public static void stringBehaviorDemo() {
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");
        System.out.println(s1 == s2);      // true
        System.out.println(s1 == s3);      // false
        System.out.println(s1.equals(s3)); // true
        StringBuilder sb = new StringBuilder("Java");
        sb.append(" Programming");
        System.out.println(sb); // Java Programming
        System.out.println(s1); // Java
    }

    // Q11: Sliding window; O(n) time and O(character-set size) space.
    public static int longestUniqueSubstringLength(String text) {
        int[] lastSeen = new int[Character.MAX_VALUE + 1];
        Arrays.fill(lastSeen, -1);
        int left = 0;
        int longest = 0;
        for (int right = 0; right < text.length(); right++) {
            char c = text.charAt(right);
            if (lastSeen[c] >= left) {
                left = lastSeen[c] + 1;
            }
            lastSeen[c] = right;
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }

    // Q12
    public static String compress(String text) {
        if (text.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= text.length(); i++) {
            if (i < text.length() && text.charAt(i) == text.charAt(i - 1)) {
                count++;
            } else {
                result.append(text.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        return result.toString();
    }

    // Q13: No String.split().
    public static String reverseWords(String sentence) {
        StringBuilder result = new StringBuilder();
        int i = sentence.length() - 1;
        while (i >= 0) {
            //Skip spaces.
            while (i >= 0 && Character.isWhitespace(sentence.charAt(i))) {
                i--;
            }
            if (i < 0) {
                break;
            }
            int end = i;
            //Move to the beginning of the current word.
            while (i >= 0 && !Character.isWhitespace(sentence.charAt(i))) {
                i--;
            }
            int start = i + 1;
            if (result.length() > 0) {
                result.append(' ');
            }
            result.append(sentence, start, end + 1);
        }
        return result.toString();
    }

    // Q14
    public static void stringBuilderVsBufferDemo() throws InterruptedException {
        StringBuilder builder = new StringBuilder();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 1000; i++) {
            builder.append("Java");
            buffer.append("Java");
        }
        System.out.println("StringBuilder length: " + builder.length());
        System.out.println("StringBuffer length: " + buffer.length());
        System.out.println("Outputs equal: " + builder.toString().equals(buffer.toString()));
        //Two threads share the same StringBuilder.
        StringBuilder sharedBuilder = new StringBuilder();
        Thread builderThread1 = new Thread(() -> appendMany(sharedBuilder, "A"));
        Thread builderThread2 = new Thread(() -> appendMany(sharedBuilder, "B"));
        builderThread1.start();
        builderThread2.start();
        builderThread1.join();
        builderThread2.join();
        System.out.println("Shared StringBuilder length (not thread-safe): " + sharedBuilder.length());
        //Two threads share the same StringBuffer.
        StringBuffer sharedBuffer = new StringBuffer();
        Thread bufferThread1 = new Thread(() -> appendMany(sharedBuffer, "A"));
        Thread bufferThread2 = new Thread(() -> appendMany(sharedBuffer, "B"));
        bufferThread1.start();
        bufferThread2.start();
        bufferThread1.join();
        bufferThread2.join();
        System.out.println("Shared StringBuffer length (synchronized): "
                + sharedBuffer.length());
    }
    private static void appendMany(StringBuilder builder, String text) {
        for (int i = 0; i < 10000; i++) {
            builder.append(text);
        }
    }
    private static void appendMany(StringBuffer buffer, String text) {
        for (int i = 0; i < 10000; i++) {
            buffer.append(text);
        }
    }
    // Q15
    public static void processEmployee(String idText, String name,
                                       String salaryText, String bonusText,
                                       String activeText) {
        try {
            Integer employeeId = Integer.valueOf(idText);
            Double basicSalary = Double.valueOf(salaryText);
            Double bonusPercentage = Double.valueOf(bonusText);
            Boolean active = Boolean.valueOf(activeText);
            double bonus = basicSalary * bonusPercentage / 100.0;
            double finalSalary = basicSalary + bonus;
            String upperName = name.toUpperCase();
            String reversedName = new StringBuilder(name).reverse().toString();
            // Assigning a reference copies the reference; both point to the same object.
            StringBuilder employeeName1 = new StringBuilder(name);
            StringBuilder employeeName2 = employeeName1;
            // Creating a new object creates a separate object.
            StringBuilder employeeName3 = new StringBuilder(name);
            System.out.println("Employee ID: " + employeeId);
            System.out.println("Employee Name: " + upperName);
            System.out.println("Basic Salary: " + basicSalary);
            System.out.println("Bonus: " + bonus);
            System.out.println("Final Salary: " + finalSalary);
            System.out.println("Active: " + active);
            System.out.println("Reversed Name: " + reversedName);
            System.out.println("Salary above 75000: " + (finalSalary > 75000 ? "Yes" : "No"));

            //Demonstrate shared reference vs independent object.
            employeeName2.append(" (updated)");
            System.out.println("Shared reference sees: " + employeeName1);
            System.out.println("Separate object remains: " + employeeName3);
        } catch (NumberFormatException ex) {
            System.out.println("Invalid employee ID, salary, or bonus percentage.");
        }
    }

    //BONUS: Longest palindromic substring, expanding around each centre.
    public static String longestPalindromicSubstring(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        int bestStart = 0;
        int bestLength = 1;
        for (int center = 0; center < text.length(); center++) {
            int oddLength = expandAroundCenter(text, center, center);
            int evenLength = expandAroundCenter(text, center, center + 1);
            int length = Math.max(oddLength, evenLength);

            if (length > bestLength) {
                bestLength = length;
                bestStart = center - (length - 1) / 2;
            }
        }
        return text.substring(bestStart, bestStart + bestLength);
    }

    private static int expandAroundCenter(String text, int left, int right) {
        while (left >= 0 && right < text.length()
                && text.charAt(left) == text.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
