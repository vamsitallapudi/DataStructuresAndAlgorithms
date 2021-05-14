package main.concepts.references;

import java.lang.ref.WeakReference;

public class WeakReferenceEg {
    public static void main(String[] args) {
        Person p = new Person();
        WeakReference<Person> personWeakReference = new WeakReference<>(p);
        p = personWeakReference.get(); // making this p which is strongly referenced, now point to weak reference
        if (p != null) { // null check because garbage collector might have collected it.
            System.out.println(p.getName());
        }
    }
    static class Person {
        String getName() {
            return "Krishna";
        }
    }
}