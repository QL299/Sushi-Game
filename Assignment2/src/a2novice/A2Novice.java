package a2novice;

import java.util.Scanner;

public class A2Novice {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		// Your code goes here.
		int number = s.nextInt();

		boolean[] vegetarian = new boolean[number];
		double[] cal = new double[number];
		String[] a = new String[number];

		for (int i = 0; i < number; i++) {
			a[i] = s.next();
			double p = s.nextDouble();
			vegetarian[i] = s.nextBoolean();
			int calories = s.nextInt();
			cal[i] = calories / p;
		}
		
		int num_vegeterian = 0;
		for (int i = 0; i < number; i++) {
			if (vegetarian[i] == true) {
				num_vegeterian = num_vegeterian + 1;
			}
		}
		
		
		double High_number = cal[0];
		double Low_number = cal[0];
		String high = a[0];
		String low = a[0];
		
		for (int i = 0; i < a.length - 1; i++) {
			if (High_number < cal[i + 1]) {
				High_number = cal[i + 1];
				high = a[i + 1];
			}
		}
		for (int i = 0; i < a.length - 1; i++) {
			if (Low_number > cal[i + 1]) {
				Low_number = cal[i + 1];
				low = a[i + 1];
			}
		}

		System.out.println("Number of vegetarian ingredients: " + num_vegeterian);
		System.out.println("Highest cals/$: " + high);
		System.out.println("Lowest cals/$: " + low);
	}
}

