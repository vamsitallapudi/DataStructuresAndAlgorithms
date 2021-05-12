package main.concepts.arraylists;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListEg {

    private void performSynchronization() {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Java");
        System.out.println(list.hashCode());
        list.add("Python");
        System.out.println(list.hashCode());
        list.add("C++");
        System.out.println(list.hashCode());

        //No explicit synchronization is needed during iteration
        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }


    public static void main(String[] args) {
        CopyOnWriteArrayListEg copyOnWriteArrayListEg = new CopyOnWriteArrayListEg();
        copyOnWriteArrayListEg.performSynchronization();
    }
}
