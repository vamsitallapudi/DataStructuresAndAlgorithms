package main.concepts;

public class InnerClassStaticNestedClassEg
{

    private String name = "Tesla";
    private static String staticName = "SpaceX";

    class InnerClass {
        void setName(String n) {
            name = n;
        }
        String getName() {
            return name; //can directly access outer private variables
        }
    }

    static class NestedStaticInnerClass {
        void setName(String n) {
            staticName = n;
        }
        String getName() {
            return staticName; // can directly access outer static private variables
        }
    }

    InnerClass getInnerClassInstance() {
        return new InnerClass();
    }

    public static void main(String[] args) {
//        static methods can directly call static classes
        NestedStaticInnerClass s = new NestedStaticInnerClass();
        s.setName(staticName);
        System.out.println("From Inner Class: " + s.getName());
//        InnerClass i = new InnerClass(); // error -> since inner class cannot be referenced from static context
        InnerClassStaticNestedClassEg mainClass = new InnerClassStaticNestedClassEg(); //creating outer class instance to access inner class
        InnerClass i = mainClass.getInnerClassInstance(); // inner class holds the reference to outer class, hence making it not eligible for gc
        i.setName(staticName);
        System.out.println("From Inner Class: " + i.getName());
    }
}
