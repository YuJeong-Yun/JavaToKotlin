package ch01.변수;

class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class 변수 {
    public static void main(String[] args) {
        long number1 = 10L; // (1)
        final long number2 = 10L; // (2)

        Long number3 = 1_000L; // (3)
        Person person = new Person("최태현"); // (4)
    }
}

