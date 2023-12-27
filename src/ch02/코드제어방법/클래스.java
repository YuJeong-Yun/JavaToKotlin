package ch02.코드제어방법;

class JavaPerson {
    private final String name;
    private int age;

    public JavaPerson(String name, int age) {
        if (age <= 0) {
            throw new IllegalArgumentException(String.format("나이는 %s일 수 없습니다", age));
        }
        this.name = name;
        this.age = age;
    }

    public JavaPerson(String name) {
        this(name, 1);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdult() {
        return this.age >= 20;
    }

}

public class 클래스 {

    public static void main(String[] args) {

    }

}
