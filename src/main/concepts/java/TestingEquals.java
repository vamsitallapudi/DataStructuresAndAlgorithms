package main.concepts.java;

import main.designPatterns.builderPattern.Person;

public class TestingEquals {
    public static void main(String[] args) {
        String a = new String("Hello");
        String b = new String ("Hello");

        Person c = new Person();
        Person d = new Person();
        System.out.println(a==b); // false
        System.out.println("hashcode of a: " + a.hashCode());
        System.out.println("hashcode of b: " + b.hashCode());
        System.out.println(a.equals(b)); // true

        System.out.println(c == d);
        System.out.println(c.equals(d));
    }
}
