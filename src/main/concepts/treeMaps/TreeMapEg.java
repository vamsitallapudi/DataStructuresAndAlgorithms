package main.concepts.treeMaps;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapEg {
    public static void main(String[] args) {

        Map<Integer, String> registry = new TreeMap<>();
        registry.put(10, "Vamsi");
        registry.put(1, "Krishna");
        registry.put(5, "Tallapudi");
        Iterator<Map.Entry<Integer, String>> iterator = registry.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, String> registryEntry = iterator.next();
            System.out.println("Name: " + registryEntry.getValue() + ", Roll No: " + registryEntry.getKey());
        }

        /*  OUTPUT:
            Name: Krishna, Roll No: 1
            Name: Tallapudi, Roll No: 5
            Name: Vamsi, Roll No: 10
        */

    }
}
