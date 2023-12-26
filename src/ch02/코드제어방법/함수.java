package ch02.코드제어방법;

public class 함수 {

    public static void main(String[] args) {

    }

    public static void printAll(String... strings) {
        for (String str : strings) {
            System.out.println(str);
        }
    }

}