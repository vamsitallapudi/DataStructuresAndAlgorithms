package main.concepts.arraylists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SynchronizedListEg {
    public void performSynchronization() {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

//        synchronizing array list in java
        List<String> syncList = Collections.synchronizedList(list);

        // using synchronize block in order to avoid non-deterministic behavior
        synchronized (this) {
            Iterator<String> listIter = syncList.iterator();
            while(listIter.hasNext()) {
                System.out.println(listIter.next());
            }
        }
    }
    public static void main(String[] args) {
        SynchronizedListEg a = new SynchronizedListEg();
        a.performSynchronization();
    }
}
