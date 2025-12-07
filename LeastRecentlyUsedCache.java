import java.util.LinkedHashMap;

public class LeastRecentlyUsedCache {
    private static LinkedHashMap<Integer, Integer> cache;
    private final static int maxCacheSize = 5;
    public static void main(String[] args){
        cache = new LinkedHashMap<Integer, Integer>();
        putInCache(1, 111);
        putInCache(2, 222);
        putInCache(3, 333);
        putInCache(4, 444);
        printCache();
        System.out.println("*************************");
        putInCache(5, 555);
        printCache();
        System.out.println("*************************");
        putInCache(6, 666);
        printCache();
        System.out.println("*************************");

        putInCache(1, 777);
        printCache();
        System.out.println("*************************");

        putInCache(8, 888);
        printCache();
        System.out.println("*************************");

    }

    public int get(int key) {
        int value = 0;
        
        if(cache.containsKey(key)) {
            value = cache.get(key);
            cache.remove(key);
            putInCache(key, value);
        } 
        else {
            value = -1;
        }

        return value;
    }

    public static void putInCache(int key, int value) {
        if(cache.size() == maxCacheSize && !cache.containsKey(key)) {
            // Remove the eldest entry (first key in insertion order)
            Integer firstKey = cache.keySet().iterator().next();
            cache.remove(firstKey);
        }

        cache.put(key, value);
    }

    private static void printCache() {
        for (int key : cache.keySet()) {
            System.out.println("Key: " + key + ", Value: " + cache.get(key));
        }
    }
}