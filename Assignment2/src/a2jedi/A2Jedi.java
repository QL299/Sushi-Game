package a2jedi;

import java.util.Scanner;

public class A2Jedi {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int Ing_number = s.nextInt();


		boolean[] vegetarian = new boolean[Ing_number ];
		double[] price = new double[Ing_number ];
		double[] cp = new double[Ing_number ];
		int[] cal = new int[Ing_number ];
		String[] Ing_name = new String[Ing_number ];

		for (int i = 0; i < Ing_number; i++) {
			Ing_name[i] = s.next();
			price[i] = s.nextDouble();
			vegetarian[i] = s.nextBoolean();
			cal[i] = s.nextInt();
			cp[i] = cal[i] / price[i];
		}
		
		
		int Menu_number = s.nextInt();

		String[] M_name = new String[Menu_number];
		double[][] ounce = new double[Menu_number][Ing_number];

		for (int i = 0; i < Menu_number; i++) {

			M_name[i] = s.next();
			int n = s.nextInt();

			for (int j = 0; j < n; j++) {
				String ingredient = s.next();
				double ounce2 = s.nextDouble();

				for (int k = 0; k < Ing_number; k++) {
					if (ingredient.equals(Ing_name[k])) {
						ounce[i][k] = ounce2;
					}
				}
			}
		}

		// order
		double[] finalI = new double[Ing_number];
		String order = s.next();
		while (!order.equals("EndOrder")) {
			for (int i = 0; i < Menu_number; i++) {
				if (order.equals(M_name[i])) {
					for (int j = 0; j < Ing_number; j++) {
						finalI[j] = finalI[j] + ounce[i][j];
						finalI[j] = ((int) ((finalI[j] * 100.0) + 0.5)) / 100.0;
					}
				}
			}
			order = s.next();
		}

		System.out.println("The order will require:");
		for (int i = 0; i < Ing_number; i++) {
			System.out.println(finalI[i] + " ounces of " + Ing_name[i]);
		}
	}
}


