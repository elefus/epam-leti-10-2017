package com.epam.jf.vasiliev.homework;

public class Task11 extends com.epam.jf.common.homework.Task11 {

    /**
     * Создает число, в котором порядок цифр обратный по отношению к исходному с использованием рекурсии.
     * Ведущие нули отбрасываются.
     * Передаваемое число ограничено 8 разрядами
     * @param value исходное значение.
     * @return Число, содержащее цифры в порядке обратном исходному.
     */
    @Override
    public int reverse(int value) {
        return reverseWithRecursion(value, 0);
    }

    private static int reverseWithRecursion(int value, int reversed) {
        return value == 0 ? reversed : reverseWithRecursion(value / 10, reversed * 10 + value % 10);
    }
}
