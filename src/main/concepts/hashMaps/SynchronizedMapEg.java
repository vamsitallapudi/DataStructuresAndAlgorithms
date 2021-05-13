package main.concepts.hashMaps;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SynchronizedMapEg {
    public static void main(String[] args) {
        Map<Integer, String> studentsMap = new HashMap<>();
        studentsMap.put(1, "Gowri");
        studentsMap.put(2, "Vamsi");
        studentsMap.put(3, "Krishna");

        Map<Integer, String> syncMap = Collections.synchronizedMap(studentsMap);

//      synchronized block is required to iterate through Synchronized hashmap for consistency of data between threads
        synchronized (syncMap) {
            Iterator<Map.Entry<Integer, String>> studentsEntry = syncMap.entrySet().iterator();

            while(studentsEntry.hasNext()) {
                System.out.println(studentsEntry.next().getValue());
            }
        }
    }
}
