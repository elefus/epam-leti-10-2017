public class Task3 {

    public static void main(String[] args) {

        method_if(args);
        method_switch(args);
    }


    private static void method_if(String[] args) {
        if (args.length==0){
            System.out.println("Error, args is empty");
        }
        else if(args[0]!="1"||args[0]!="2"||args[0]!="3"||args[0]!="4"||args[0]!="5"||
                args[0]!="6"|| args[0]!="7"||args[0]!="8" ||args[0]!="9"||args[0]!="0"){
            System.out.println("Error,incorrect input");
        }
        else {
            int temp = Integer.parseInt(args[0]);

            if (temp >= 0 && temp <= 3) {

                System.out.println("The traffic light is green");

            } else if (temp >= 4 && temp <= 5) {


                System.out.println("The traffic light is yellow");

            } else if (temp >= 6 && temp <= 9) {


                System.out.println("The traffic light is red");
            }
            else {
                System.out.println("Error,you should input a positive number that is not exceeding 9");
            }
        }
    }

    private static void method_switch(String[] args) {
        if (args.length == 0) {
            System.out.println("Error, args is empty");

        } else {
            switch (args[0]) {
                case "0":
                case "1":
                case "2":
                case "3":
                    System.out.println("The traffic light is green");
                    break;
                case "4":
                case "5":
                    System.out.println("The traffic light is yellow");
                    break;
                case "6":
                case "7":
                case "8":
                case "9":
                    System.out.println("The traffic light is red");
                    break;
                default:
                    System.out.println("Error,incorrect input, you should input a positive number that is not exceeding 9");
            }
        }

    }

}
