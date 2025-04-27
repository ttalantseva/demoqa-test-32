package firstExtraJavaLesson;

import org.junit.jupiter.api.Test;

public class Operators {


    //0) применить несколько арифметических операций ( + , -, * , /) над двумя примитивами типа int
    @Test
    void arithmeticOperatorsTest1() {
        int a = 3;
        int b = 9;

        System.out.println(a * b);
        System.out.println(a + b);
        System.out.println(b / a);
    }

    //1) применить несколько арифметических операций над int и double в одном выражении
    @Test
    void arithmeticOperatorsTest2() {
        int a = 5;
        double b = 7.0;
        int c = 3;

        System.out.println(a + b * c);
        System.out.println((a + b) / c);
        System.out.println((a +b) % c);
    }

    //2) применить несколько логических операций ( < , >, >=, <= )
    @Test
    void logicalOperatorsTest() {
        int a = 123;
        int b = 2334;
        double c = 99;

        System.out.println((a +b) >= c);
        System.out.println(a < b);
    }

    //3) прочитать про диапазоны типов данных для чисел с плавающей точкой (какие максимальные и минимальные значения есть, как их получить) и переполнение
    //4) получить переполнение при арифметической операции

    @Test
    void overflowTest() {
        float a = Float.MAX_VALUE;
        float b = 3.0F;

        System.out.println(a);
        System.out.println(a * b);

    }
}
