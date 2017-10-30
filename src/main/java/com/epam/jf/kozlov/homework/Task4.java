package com.epam.jf.kozlov.homework;

/**
 * На вход программе подается несколько строк (через параметры командной строки args).
 * Каждая строка представляет собой одно слово, состоящие из символов английского алфавита.
 * Необходимо найти слово, в котором число различных символов минимально.
 *
 * Символы верхнего и нижнего регистра считать различными.
 * Если таких слов несколько, найти первое из них.
 *
 * В результате выполнения в выходной поток должно быть выведено слово, содержащее наименьшее число различных символов.
 * Наиболее эффективное с точки зрения скорости и потребляемой памяти решение - реализация с использованием битовых операций.
 * Желающие могут попробовать придумать, как их можно применить в этой задаче.
 */
public class Task4 {

    /**
     * @param args анализируемые строки.
     */
    public static void main(String[] args) {
        // Номер элемента с минимальным числом различных симоволов
        int num = -1;
        // Минимальное количество различных симоволов в строке
        int min = -1;
        int TempMin;
        for (int i = 0; i < args.length; i++) {
            try {
                // Эта проверка осуществляется, пока мы не найдём строку полностью состоящую из символов англ. алфавита
                if(min == -1) {
                    min = StringAnalyze(args[i]);
                    num = i;
                }
                else{
                    TempMin = StringAnalyze(args[i]);
                    if(min > TempMin){
                        min = TempMin;
                        num = i;
                    }
                }
            }
            catch (IllegalArgumentException e){
                System.out.println("Warning:String number " + (i+1) + " contains invalid symbols");
            }
        }
        if(num == -1)
            System.out.println("Error:No valid arguments was given");
        else
            System.out.println("String with minimum amount of different characters:" + args[num]);

    }

    private static int StringAnalyze(String Str) throws IllegalArgumentException{
        // Биты с 0 до 25 - uppercase
        // Биты с 26 до 51 - lowercase
        long Bitmap = 0;
        int DiffCharNum = 0;
        int CharIntValue;
        for (int i = 0; i < Str.length(); i++){
            CharIntValue = (int)Str.charAt(i);
            // Если uppercase
            if (CharIntValue >= 65 && CharIntValue <= 90){
                CharIntValue -= 65;
                // Если символ ещё не учитывался
                if((Bitmap & (1L<<CharIntValue)) == 0){
                    DiffCharNum++;
                    // Учитываем символ в битовой карте
                    Bitmap |= 1L<<CharIntValue;
                }
            }
            // Если lowercase
            else if (CharIntValue >= 97 && CharIntValue <= 122){
                CharIntValue -= 71;
                // Если символ ещё не учитывался
                if((Bitmap & (1L<<CharIntValue)) == 0){
                    DiffCharNum++;
                    // Учитываем символ в битовой карте
                    Bitmap |= 1L<<CharIntValue;
                }
            }
            // Если строка содержит недопустимые символы
            else{
                throw new IllegalArgumentException();
            }
        }
        return DiffCharNum;
    }
}
