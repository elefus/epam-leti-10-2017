
public class Task2 {
    public static void main(String[] args) {
        
        if (args.length == 0) {
            System.out.println("Error,args is empty");
        } else {
			String str = args[0];
			String str2 = args[0];
			
            for (int i = 0; i < args.length; ++i) {
                if (str.length() <= args[i].length()) {
                    str = args[i];
                }
                if (str2.length() >= args[i].length()) {
                    str2 = args[i];
                }

            }
            System.out.println("Minimum " + str2);
            System.out.println("Maximum " + str);
        }


    }
}
