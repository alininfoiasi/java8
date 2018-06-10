package main.java.misc.interfaces;

@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);

    class StringOperations {
        String startsWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }

    class Person {
        public String firstName;
        public String lastName;

        public Person() {

        }

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return firstName + ", " + lastName;
        }

    }

    interface PersonFactory<P extends Person> {
        P create(String firstName, String lastName);
    }

    public static void main(String[] args) {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Converter<String, String> trimmer = (from) -> from.trim();
        Integer converted = converter.convert("123");
        System.out.println(converted);
        String stringValue = trimmer.convert("\n 1 \t 23  \r  \t");
        System.out.println(stringValue);


        // static method references
        Converter<String, Integer> converter2 = Integer::valueOf;
        Integer converted2 = converter2.convert("777");
        System.out.println(converted2);

        // instance method reference
        StringOperations stringOperations = new StringOperations();
        Converter<String, String> converter3 = stringOperations::startsWith;
        String converted3 = converter3.convert("Java");
        System.out.println(converted3);

        // constructor reference
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");

    }

}