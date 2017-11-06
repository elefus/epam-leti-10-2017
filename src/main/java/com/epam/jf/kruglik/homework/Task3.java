package com.epam.jf.kruglik.homework;

public class Task3 {

    public static Colors switchSolution(Integer nowTime){

        switch (nowTime){
            case 0:
            case 1:
            case 2:
            case 3:
                return Colors.Green;
            case 4:
            case 5:
                return Colors.Yellow;
            default:
                return Colors.Red;
        }
    }

    public static Colors ifSolution(Integer nowTime){

        if (nowTime >= 0 && nowTime <= 3){
            return Colors.Green;
        }
        else{
            if(nowTime >= 4 && nowTime <= 5){
                return Colors.Yellow;
            } else {
                return Colors.Red;
            }
        }
    }

    public static void main(String...args) {

        Integer nowTime = Integer.parseUnsignedInt(args[0]);
        nowTime %= 10;
        System.out.println(switchSolution(nowTime));
        System.out.println(ifSolution(nowTime));
    }
}

enum Colors {Green, Yellow, Red}
