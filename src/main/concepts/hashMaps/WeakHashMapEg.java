package main.concepts.hashMaps;

import java.util.WeakHashMap;

public class WeakHashMapEg {
    public static void main(String[] args) throws Exception {
        WeakHashMap<Person, Integer> hm = new WeakHashMap<>();
        Person p = new Person();
        Person q = new Person();

        hm.put(p, 1);
        hm.put(q, 1);
        p = null; // making the person object eligible for gc
        System.out.println("before: " + hm);
        System.gc(); //calling garbage collector
        Thread.sleep(1000);
        System.out.println("after: " + hm);

    }

    static class Person {
        @Override
        protected void finalize() throws Throwable {
            System.out.println("Calling finalize method");
            super.finalize();
        }
    }
    /* OUTPUT:
        before: {main.concepts.hashMaps.WeakHashMapEg$Person@1fb3ebeb=1, main.concepts.hashMaps.WeakHashMapEg$Person@548c4f57=1}
        Calling finalize method
        after: {main.concepts.hashMaps.WeakHashMapEg$Person@548c4f57=1}
    */
}
