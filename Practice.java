import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
        System.out.println("=== Function Practice ===\n");        
        // testIsValid();
        // testLongestNonRepeatingSubstring();
        // longestRepeatingCharacterReplacement("AAB", 1);
        int[] numbers = {1, 2, 0, 3, 4, -5};
        System.out.println(Arrays.toString(productExceptSelf(numbers)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        
        // First pass: Calculate prefix products (products of all elements to the left)
        // answer[i] will contain product of all elements to the left of index i
        answer[0] = 1; // No elements to the left of index 0
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        
        // Second pass: Multiply by suffix products (products of all elements to the right)
        // Use a variable to track suffix product as we go from right to left
        int suffix = 1; // Start with 1 (no elements to the right of last index)
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffix; // Multiply prefix by suffix
            suffix = suffix * nums[i]; // Update suffix for next iteration
        }
        
        return answer;
    }

    public static int longestRepeatingCharacterReplacement(String s, int k) {

        // s = AABAC, k = 2
        // s.length = 5
    
        Map<Character, Integer> frequency = new HashMap<>();

        int biggestWindow = 0;

        for (char c : s.toCharArray()) {
            // If the character is already in the map, increment its count
            if (frequency.containsKey(c)) {
                frequency.put(c, frequency.get(c) + 1);
            } else {
                // If the character is not in the map, add it with a count of 1
                frequency.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }


        return biggestWindow;
    }
    
    public static int longestNonRepeatingSubstring(String s) {

        int maxLength = 1;

        if (s.length() == 0) return 0;

        HashSet<Character> currentCharacter = new HashSet<>();
        currentCharacter.add(s.charAt(0));

        int left = 0;

        for(int right = 1; right < s.length(); right++) {
            while (currentCharacter.contains(s.charAt(right))) {
                currentCharacter.remove(s.charAt(left));
                left++;    
            }

            currentCharacter.add(s.charAt(right));

            maxLength = Math.max(maxLength, right - left +1);
        }
        
        return maxLength;
    }


    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    
        Deque<Character> stack = new ArrayDeque<>();
    
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
    
            if (map.containsKey(c)) {  // closing bracket
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {  // opening bracket
                stack.push(c);
            }
        }
    
        return stack.isEmpty();
    }    
    
    public static boolean isOpeningBracket(char c) {
        return c == '(' || c == '{' || c == '[';
    }
    
    // Test functions (you can add more test cases)
    public static void testIsValid() {
        System.out.println("Testing isValid:");
        String test1 = "()";
        boolean result1 = isValid(test1);
        System.out.println("Input: " + test1 + " -> Output: " + result1);
        System.out.println();

        String test2 = "(){}[]";
        boolean result2 = isValid(test2);
        System.out.println("Input: " + test2 + " -> Output: " + result2);
        System.out.println();

        String test3 = "}()[]";
        boolean result3 = isValid(test3);
        System.out.println("Input: " + test3 + " -> Output: " + result3);
        System.out.println();

        String test4 = "([{(())}])";
        boolean result4 = isValid(test4);
        System.out.println("Input: " + test4 + " -> Output: " + result4);
        System.out.println();
    }

    public static void testLongestNonRepeatingSubstring() {
        System.out.println("Testing longestNonRepeatingSubstring:");
        String test1 = "abcabcbb";
        int result1 = longestNonRepeatingSubstring(test1);
        System.out.println("Input: " + test1 + " -> Output: " + result1);
        System.out.println();

        String test2 = "bbbbb";
        int result2 = longestNonRepeatingSubstring(test2);
        System.out.println("Input: " + test2 + " -> Output: " + result2);
        System.out.println();

        String test3 = "pwwkew";
        int result3 = longestNonRepeatingSubstring(test3);
        System.out.println("Input: " + test3 + " -> Output: " + result3);
        System.out.println();

        String test4 = "";
        int result4 = longestNonRepeatingSubstring(test4);
        System.out.println("Input: " + test4 + " -> Output: " + result4);
        System.out.println();

        String test5 = "a";
        int result5 = longestNonRepeatingSubstring(test5);
        System.out.println("Input: " + test5 + " -> Output: " + result5);
        System.out.println();

        String test6 = "abba";
        int result6 = longestNonRepeatingSubstring(test6);
        System.out.println("Input: " + test6 + " -> Output: " + result6);
        System.out.println();

        String test7 = "a!b@c#a";
        int result7 = longestNonRepeatingSubstring(test7);
        System.out.println("Input: " + test7 + " -> Output: " + result7);
        System.out.println();

        String test8 = "dvdf";
        int result8 = longestNonRepeatingSubstring(test8);
        System.out.println("Input: " + test8 + " -> Output: " + result8);
        System.out.println();
    }
}

