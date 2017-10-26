public class task2 {
	public static void main(String...args) {
		if(args.length != 0) {
			String minS = args[0], maxS = args[0];
			for(int i = 1; i < args.length; i++) {
				if(args[i].length() <= minS.length())
					minS = args[i];
				if(args[i].length() >= maxS.length())
					maxS = args[i];
			}
			System.out.println("Минимальная строка среди представленных: " + minS  + '\n' + "Максимальная строка среди представленных: " + maxS);
		}
		else
			System.out.println("Нет аргументов");
	}
}
