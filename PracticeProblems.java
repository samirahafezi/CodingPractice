import java.lang.reflect.*;
import java.util.Objects;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class PracticeProblems {

    public static void main(String[] args) {
        System.out.println("Result: " + firstNonRepeatingCharacter("Swiss"));
        //runAllTests();
    }

    public static int runAllTests() {
        int failedTests = 0;
        Method[] methods = PracticeProblems.class.getDeclaredMethods();
        for (Method method : methods) {
            if (Modifier.isStatic(method.getModifiers()) && method.getName().startsWith("test")) {
                try {
                    method.invoke(null);
                    System.out.println(method.getName() + " passed.");
                } catch (InvocationTargetException e) {
                    failedTests++;
                    System.out.println(method.getName() + " failed: " + e.getTargetException().getMessage());
                } catch (Exception e) {
                    failedTests++;
                    System.out.println(method.getName() + " failed: " + e.getMessage());
                }
            }
        }
        return failedTests;
    }

    // Simple assertion helpers
    public static void assertEquals(Object expected, Object actual) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionError("Expected: " + expected + " but was: " + actual);
        }
    }

    public static void assertTrue(boolean condition) {
        if (!condition) throw new AssertionError("Condition is false");
    }

    // 1. Two Sum
    // Given an array of integers and a target value, return the indices of the two numbers that add up to the target.
    public boolean twoSum(int[] nums, int target) {
        //nums = [2,7,11,15], target = 18

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return true;
                }
            }
        } 

        return false;
    }

    public static void testTwoSum() {
        PracticeProblems pp = new PracticeProblems();
        assertEquals(true, pp.twoSum(new int[]{2, 7, 11, 15}, 9));
        assertEquals(true, pp.twoSum(new int[]{3, 2, 4}, 6));
        assertEquals(true, pp.twoSum(new int[]{3, 3}, 6));
        assertEquals(false, pp.twoSum(new int[]{3, 3}, 8));
    }

    // 2. Reverse a Linked List
    // Reverse a singly linked list and return the new head.
    public ListNode reverseList(ListNode head) {
        LinkedList<Integer> reversedList = new LinkedList<>();
        while(head != null){
            reversedList.addFirst(head.val);
            head = head.next;
        }
        return null;
    }

    // 3. Valid Parentheses
    // Given a string of parentheses '()[]{}', determine if it is valid and properly balanced.
    public boolean isValid(String s) {
        return false;
    }

    // 4. Merge Two Sorted Lists
    // Merge two sorted linked lists and return the head of the new sorted list.
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return null;
    }

    // 5. Longest Substring Without Repeating Characters
    // Return the length of the longest substring without repeating characters.
    public int lengthOfLongestSubstring(String s) {
        return 0;
    }

    // 6. LRU Cache
    // Implement an LRU Cache with get() and put() in O(1) time.
    class LRUCache {

        public LRUCache(int capacity) {

        }

        public int get(int key) {
            return -1;
        }

        public void put(int key, int value) {

        }
    }

    // 7. Binary Search
    // Given a sorted array and a target value, return the index of the target or -1 if not found.
    public int binarySearch(int[] nums, int target) {
        return -1;
    }

    // 8. Level-Order Traversal of a Binary Tree
    // Return the level-order (BFS) traversal of a binary tree as a list of levels.
    public java.util.List<java.util.List<Integer>> levelOrder(TreeNode root) {
        return new java.util.ArrayList<>();
    }

    // 9. Find All Anagrams in a String
    // Given a string s and a pattern p, return all starting indices of p's anagrams in s.
    public java.util.List<Integer> findAnagrams(String s, String p) {
        return new java.util.ArrayList<>();
    }

    // 10. Product of Array Except Self
    // Return an array where each element is the product of all other elements except itself, without using division.
    public int[] productExceptSelf(int[] nums) {
        return new int[0];
    }

    public int countNumberOfVowelsInString(String s) {
        
        char[] vowelArray = {'a', 'e', 'i', 'o', 'u'};
        int count = 0;

        s = s.toLowerCase();

        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < vowelArray.length; j++) {
                if(s.charAt(i) == vowelArray[j]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public int returnSumOfEvenIntegers(int[] arr) {
        int sum = 0;

        for (int value : arr) {
            if(value % 2 == 0)
                sum += value;
        }

        return sum;
    }

    public static char firstNonRepeatingCharacter(String s) {
        Map<Character, Integer> orderedMap = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            orderedMap.put(s.charAt(i), orderedMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : orderedMap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            
            if(value == 1) {
                return key;
            }
        }

        return ' ';
    }
}
