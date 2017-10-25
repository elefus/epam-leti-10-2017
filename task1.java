public class task1 {
	public static void main(String...args) {
		String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };

		int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };
		
		int i_first = 0, i_second = 0;
		for(int i = 1, first = times[0], second = times[0]; i < names.length; i++)
			if(times[i] < first) {	
				second = first;
				first = times[i];
				i_second = i_first;
				i_first = i;
			}
		
		System.out.println("Первым прибежал(а) " + names[i_first] + " за " + times[i_first]);
		System.out.println("Вторым прибежал(а) " + names[i_second] + " за " + times[i_second]);
	}
}
