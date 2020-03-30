package a3jedi;

import java.util.Scanner;

public class A3Jedi {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		// ingredient
		int Ing_number = s.nextInt();

		boolean[] vegetarian = new boolean[Ing_number];
		double[] price = new double[Ing_number];
		double[] cp = new double[Ing_number];
		int[] calories = new int[Ing_number];
		String[] I_name = new String[Ing_number];

		for (int i = 0; i < Ing_number; i++) {
			I_name[i] = s.next();
			price[i] = s.nextDouble();
			vegetarian[i] = s.nextBoolean();
			calories[i] = s.nextInt();
			cp[i] = calories[i] / price[i];
		}

		// menu
		int Menu_number = s.nextInt();

		String[] Mname = new String[Menu_number];
		double[][] ounce = new double[Menu_number][Ing_number];

		for (int i = 0; i < Menu_number; i++) {

			Mname[i] = s.next();
			int n = s.nextInt();

			for (int j = 0; j < n; j++) {
				String ingredient = s.next();
				double ounce2 = s.nextDouble();

				for (int k = 0; k < Ing_number; k++) {
					if (ingredient.equals(I_name[k])) {
						ounce[i][k] = ounce2;
					}
				}
			}
		}

		// order
		double[] final_I = new double[Ing_number];
		String order = s.next();
		while (!order.equals("EndOrder")) {
			for (int i = 0; i < Menu_number; i++) {
				if (order.equals(Mname[i])) {
					for (int j = 0; j < Ing_number; j++) {
						final_I[j] = final_I[j] + ounce[i][j];
						final_I[j] = ((int) ((final_I[j] * 100.0) + 0.5)) / 100.0;
					}
				}
			}
			order = s.next();
		}

		System.out.println("The order will require:");
		for (int i = 0; i < Ing_number; i++) {
			System.out.println(final_I[i] + " ounces of " + I_name[i]);
		}
	}
}
