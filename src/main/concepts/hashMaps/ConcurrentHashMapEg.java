package main.concepts.hashMaps;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapEg {

    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1, "India");
        concurrentHashMap.put(2, "USA");
        concurrentHashMap.put(3, "Australia");

//        reading requires no synchronization
        System.out.println(concurrentHashMap.get(1));

        Iterator<Map.Entry<Integer, String>> iter = concurrentHashMap.entrySet().iterator();

//        use synchronization so that other threads can see the changes applied by one thread
        synchronized (concurrentHashMap) {
            while(iter.hasNext()) {
                System.out.println(iter.next().getValue());
            }
        }
    }
}
