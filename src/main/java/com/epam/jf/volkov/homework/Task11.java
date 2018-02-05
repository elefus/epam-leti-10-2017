package com.epam.jf.volkov.homework;

public class Task11 extends com.epam.jf.common.homework.Task11 {

    /**
     * Создает число, в котором порядок цифр обратный по отношению к исходному с использованием рекурсии.
     * Ведущие нули отбрасываются.
     * @param value исходное значение.
     * @return Число, содержащее цифры в порядке обратном исходному.
     */
    public int reverse(int value) {
        if (value >= 0) {
            int length = String.valueOf(value)  // Если верить Logic-1 с codingbat, не самый плохой способ считать цифры
                .length();                      // F L U E N T (нет)
            int ret = 0;
            for (int i = 0; i < length; i++) {  //int last = value % 10; //последняя цифра
                ret *= 10;                      //value /= 10; //оставшиеся
                ret += value % 10;              //ret *= 10; //пододвинем
                value /= 10;                    //ret += last; //запишем
            }
            return ret;
        } else {
            return -1 * reverse(-value);
        }
    }
}
