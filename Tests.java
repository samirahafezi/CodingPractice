import java.lang.reflect.*;
import java.util.Objects;

public class Tests {
    public static void main(String[] args) {
        int passed = 0, failed = 0;
        for (Method m : Tests.class.getDeclaredMethods()) {
            if (Modifier.isStatic(m.getModifiers()) && m.getName().startsWith("test")) {
                try {
                    m.setAccessible(true);
                    m.invoke(null);
                    System.out.println(m.getName() + " PASSED");
                    passed++;
                } catch (InvocationTargetException e) {
                    System.out.println(m.getName() + " FAILED: " + e.getTargetException());
                    failed++;
                } catch (Exception e) {
                    System.out.println(m.getName() + " ERROR: " + e);
                    failed++;
                }
            }
        }
        System.out.printf("Results: %d passed, %d failed%n", passed, failed);
        if (failed > 0) System.exit(1);
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

    public static void testSubtraction() {
        assertEquals(2, substract(5, 3));
    }

    // Code under test - replace or extend these methods with code you want to test
    public static int add(int a, int b) {
        return a + b;
    }

    public static String concat(String a, String b) {
        return a + b;
    }

    public static int substract(int a, int b) {
        return a - b;
    }   
}