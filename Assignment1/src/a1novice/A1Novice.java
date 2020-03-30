package a1novice;

import java.util.Scanner;

public class A1Novice {

	// Do not change the main method.	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		process(s);
	}
	
	public static void process(Scanner s) {
		// Put your code here.
		int number = s.nextInt();

		for (int i = 0; i < number; i++) {
			String lastname = s.next();
			String firstname = s.next();
			double assignment = s.nextDouble();
			double participation = s.nextDouble();
			double midterm = s.nextDouble();
			double finalexam = s.nextDouble();
			double wa = (0.4 * assignment + 0.15 * participation + 0.20 * midterm + 0.25 * finalexam)/100;

			if (wa >= 0.94) {
				System.out.println(lastname.charAt(0) + ". " + firstname + " A");
			} else if (wa >= 0.90) {
				System.out.println(lastname.charAt(0) + ". " + firstname + " A-");
			} else if (wa >= 0.86) {
				System.out.println(lastname.charAt(0) + ". " + firstname + " B+");
			} else if (wa >= 0.83) {
				System.out.println(lastname.charAt(0) + ". " + firstname + " B");
			} else if (wa >= 0.80) {
				System.out.println(lastname.charAt(0) + ". " + firstname + " B-");
			} else if (wa >= 0.76) {
				System.out.println(lastname.charAt(0) + ". " + firstname + " C+");
			} else if (wa >= 0.73) {
				System.out.println(lastname.charAt(0) + ". " + firstname + " C");
			} else if (wa >= 0.70) {
				System.out.println(lastname.charAt(0) + ". " + firstname + " C-");
			} else if (wa >= 0.65) {
				System.out.println(lastname.charAt(0) + ". " + firstname + " D+");
			} else if (wa >= 0.60) {
				System.out.println(lastname.charAt(0) + ". " + firstname + " D");
			} else {
				System.out.println(lastname.charAt(0) + ". " + firstname + " F");
			}

		}
	}

}