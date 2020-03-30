package a2adept;

import java.util.Scanner;

public class A2Adept {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		// Your code goes here.

		int Ing_number = s.nextInt();

		boolean[] vegetarian = new boolean[Ing_number];
		double[] price = new double[Ing_number];
		double[] cp = new double[Ing_number];
		int[] cal = new int[Ing_number];
		String[] Ing_name = new String[Ing_number];

		for (int i = 0; i < Ing_number; i++) {
			Ing_name[i] = s.next();
			price[i] = s.nextDouble();
			vegetarian[i] = s.nextBoolean();
			cal[i] = s.nextInt();
			cp[i] = cal[i] / price[i];
		}


		int Menu_number = s.nextInt();

		String[] Mname = new String[Menu_number];

		for (int i = 0; i < Menu_number; i++) {

			Mname[i] = s.next();
			int n = s.nextInt();

			double cal2 = 0;
			double price2 = 0;
			boolean v2 = true;
			int finalC = 0;
			double finalP = 0;
			String finalV = null;

			for (int j = 0; j < n; j++) {
				String ingredient = s.next();
				double ounce = s.nextDouble();


				for (int a = 0; a < Ing_number; a++) {
					if (ingredient.equals(Ing_name[a])) {
						cal2 = cal2 + cal[a] * ounce;
						finalC = ((int) (cal2 + 0.5));
					}
				}

			
				for (int a = 0; a < Ing_number; a++) {
					if (ingredient.equals(Ing_name[a])) {
						price2 = price2 + price[a] * ounce;
						finalP = ((int) ((price2 * 100.0) + 0.5)) / 100.0;
					}
				}

			
				for (int a = 0; a < Ing_number; a++) {
					if (ingredient.equals(Ing_name[a])) {
						if (vegetarian[a] == false) {
							v2 = false;
						}
					}
				}

			
				if (v2 == true) {
					finalV = "Vegetarian";
				} else if (v2 == false) {
					finalV = "Non-Vegetarian";
				}

			}
			System.out.println(Mname[i] + ":\n" + finalC + " calories\n$" + finalP + "\n" + finalV);
		}
	}
}
