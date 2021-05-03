package main.concepts.vectors;

import java.util.Vector;

public class VectorsDemo {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();
        v.add(1);
        v.add(2);
        v.add(2);
        v.add(2);
        v.add(2);
        v.add(2);
        v.add(2);
        v.add(2);
        v.add(2);
        v.add(2);
        v.add(2);
        System.out.println(v.capacity());
    }
}
