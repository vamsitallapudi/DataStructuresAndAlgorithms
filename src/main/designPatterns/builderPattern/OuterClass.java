package main.designPatterns.builderPattern;

public class OuterClass {
    private static String msg = "Hello Vamsi";
    private String myNewMsg = "Krishna";

//    static nested class
    public static class NestedStaticClass {
//
        public void printMessage() {
            System.out.println("Message from nested static class: " + msg);
        }
    }
    public class InnerClass {
        public void message() {
            System.out.println("Message from inner class: " + msg + myNewMsg);
        }
    }
}

class Main {
    public static void main(String[] args) {
        OuterClass.NestedStaticClass myStaticClass = new OuterClass.NestedStaticClass();
        myStaticClass.printMessage();
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass myInnerclass = outerClass.new InnerClass();
        myInnerclass.message();
    }
}
