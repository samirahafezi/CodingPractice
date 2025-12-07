import java.lang.reflect.*;
import java.util.LinkedList;
import java.util.Objects;

public class Tests2 {
    public static void main(String[] args) {
        runAllTests();
    }

    public static int runAllTests() {
        int failedTests = 0;
        Method[] methods = Tests2.class.getDeclaredMethods();
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

    // Sample tests - add your own static test methods prefixed with "test"
    public static void testAddition() {
        assertEquals(4, add(2, 2));
        // assertEquals(4, add(2, 3));
    }

    public static void testStringConcat() {
        assertEquals("HelloWorld", concat("Hello", "World"));
    }

    public static void testFindLargestInt() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(2);
        assertEquals(4, findLargestInt(list));
    }

    // Code under test - replace or extend these methods with code you want to test
    public static int add(int a, int b) {
        return a + b;
    }

    public static String concat(String a, String b) {
        return a + b;
    }

    public static int findLargestInt(LinkedList<Integer> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }
        int largest = list.get(0);
        for (int num : list) {
            if (num > largest) {
                largest = num;
            }
        }
        return largest;
    }
}