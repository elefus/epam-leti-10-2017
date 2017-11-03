public class Task1 {
    public static void main(String... args) {
        String[] names = new String[]{"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"};
        int[] times = new int[]{341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};
        int minNumber = Integer.MAX_VALUE;
        int secondNumber = Integer.MAX_VALUE;
        int numbFirst = 0;
        int numbSecond = 0;

        for(int i = 0; i < times.length; ++i) {
            if (times[i] < minNumber) {
                secondNumber = minNumber;
                numbSecond = numbFirst;
                minNumber = times[i];
                numbFirst = i;
            } else if (times[i] < secondNumber) {
                secondNumber = times[i];
                numbSecond = i;
            }
        }

        System.out.println("First: " + names[numbFirst] + " - " + times[numbFirst]);
        System.out.println("Second: " + names[numbSecond] + " - " + times[numbSecond]);
    }
}
