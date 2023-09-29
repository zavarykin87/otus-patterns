package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareRootTest {

    private final SquareRoot squareRoot = new SquareRoot();

    // Написать тест, который проверяет, что для уравнения x^2+1 = 0 корней нет (возвращается пустой массив)
    @Test
    void noRoots() {
        assertEquals(0, squareRoot.solve(1, 0, 1).length);
    }

    // Написать тест, который проверяет, что для уравнения x^2-1 = 0 есть два корня кратности 1 (x1=1, x2=-1)
    @Test
    void hasTwoRoots() {
        assertAll(
                () -> assertEquals(1, squareRoot.solve(1,0,-1)[0]),
                () -> assertEquals(-1, squareRoot.solve(1,0,-1)[1])
        );
    }

    // Написать тест, который проверяет, что для уравнения x^2+2x+1 = 0 есть один корень кратности 2 (x1= x2 = -1).
    @Test
    void hasOneRoot() {
        assertAll(
                () -> assertEquals(-1, squareRoot.solve(1,2,1)[0]),
                () -> assertEquals(-1, squareRoot.solve(1, 2, 1)[1])
        );

    }

    /*
    Написать тест, который проверяет, что коэффициент a не может быть равен 0.
    В этом случае solve выбрасывает исключение.
    Примечание. Учесть, что a имеет тип double и сравнивать с 0 через == нельзя.
    */
    @Test
    void firstCoefficientIsNotZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> squareRoot.solve(0,2,1));
        assertEquals("first coefficient can not be zero", exception.getMessage());
    }

    // Посмотреть какие еще значения могут принимать числа типа double, кроме числовых и написать тест с их использованием
    // на все коэффициенты. solve должен выбрасывать исключение.
    @Test
    void firstArgNotNaN() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> squareRoot.solve(Double.NaN, 1,1));
        assertEquals("argument can not be NaN", exception.getMessage());
    }

    @Test
    void secondArgNotNaN() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> squareRoot.solve(1, Double.NaN,1));
        assertEquals("argument can not be NaN", exception.getMessage());
    }

    @Test
    void thirdArgNotNaN() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> squareRoot.solve(1, 1,Double.NaN));
        assertEquals("argument can not be NaN", exception.getMessage());
    }

    @Test
    void firstArgNotPosInfiniti() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> squareRoot.solve(Double.POSITIVE_INFINITY, 1,1));
        assertEquals("argument can not be positive infinity", exception.getMessage());
    }

    @Test
    void secondArgNotPosInfiniti() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> squareRoot.solve(1, Double.POSITIVE_INFINITY,1));
        assertEquals("argument can not be positive infinity", exception.getMessage());
    }

    @Test
    void thirdArgNotPosInfiniti() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> squareRoot.solve(1, 1,Double.POSITIVE_INFINITY));
        assertEquals("argument can not be positive infinity", exception.getMessage());
    }

    @Test
    void firstArgNotNegInfiniti() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> squareRoot.solve(Double.NEGATIVE_INFINITY, 1,1));
        assertEquals("argument can not be negative infinity", exception.getMessage());
    }

    @Test
    void secondArgNotNegInfiniti() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> squareRoot.solve(1, Double.NEGATIVE_INFINITY,1));
        assertEquals("argument can not be negative infinity", exception.getMessage());
    }

    @Test
    void thirdArgNotNegInfiniti() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> squareRoot.solve(1, 1,Double.NEGATIVE_INFINITY));
        assertEquals("argument can not be negative infinity", exception.getMessage());
    }


}