package ch01.변수;

class Person2 {
    private final String name;
    private final int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Type {

    public static void main(String[] args) {
    }

    public static void printAgeIfPerson(Object obj) {
        if (obj instanceof Person) {
            Person2 person = (Person2) obj;
            System.out.println(person.getAge());
        }
    }

}