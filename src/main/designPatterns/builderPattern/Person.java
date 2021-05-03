package main.designPatterns.builderPattern;

public class Person {

    private String firstName;
    private String lastname;
    private String mobileNo;

    public static class PersonBuilder {

        private static String firstName;
        private static String lastname;
        private static String mobileNo;


        public PersonBuilder(String firstName) {
            this.firstName = firstName;
        }
        public PersonBuilder lastName(String lastName) {
            this.lastname = lastName;
            return this;
        }

        public PersonBuilder mobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
            return this;
        }
        public Person build() {
            Person person = new Person();
            person.firstName = firstName;
            person.lastname = lastname;
            return person;
        }
    }
}
