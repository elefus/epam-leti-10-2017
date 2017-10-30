public class Task3 {

    public static void switchSolution(Integer nowTime){
        nowTime %= 10;

        switch (nowTime){
            case 0:
                System.out.println("Green");
                break;
            case 1:
                System.out.println("Green");
                break;
            case 2:
                System.out.println("Green");
                break;
            case 3:
                System.out.println("Green");
                break;
            case 4:
                System.out.println("Yellow");
                break;
            case 5:
                System.out.println("Yellow");
                break;
            default:
                System.out.println("Red");

        }
    }

    public static void ifSolution(Integer nowTime){
        nowTime %= 10;

        if (nowTime >= 0 && nowTime <= 3)
            System.out.println("Green");
        else if(nowTime >= 4 && nowTime <= 5)
            System.out.println("Yellow");
        else System.out.println("Red");
    }

    public static void main(String...args) {

        Integer nowTime = Integer.parseUnsignedInt(args[0]);

        switchSolution(nowTime);
        ifSolution(nowTime);
    }
}
