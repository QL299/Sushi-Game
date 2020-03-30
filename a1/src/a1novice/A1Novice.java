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
			double recitation = s.nextDouble();
			double midterm1 = s.nextDouble();
			double midterm2 = s.nextDouble();
			double finalexam = s.nextDouble();
			double wa = 0.4 * assignment + 0.1 * recitation + 0.15 * midterm1 + 0.15 * midterm2 + 0.2 * finalexam;

			if (wa >= 3.85) {
				System.out.println(lastname.charAt(0) + ". " + firstname + " A");
			} else if (wa >= 3.5) {
				System.out.println(lastname.charAt(0) + ". " + firstname + " A-");
			} else if (wa >= 3.15) {
				System.out.println(lastname.charAt(0) + ". " + firstname + " B+");
			} else if (wa >= 2.85) {
				System.out.println(lastname.charAt(0) + ". " + firstname + " B");
			} else if (wa >= 2.5) {
				System.out.println(lastname.charAt(0) + ". " + firstname + " B-");
			} else if (wa >= 2.15) {
				System.out.println(lastname.charAt(0) + ". " + firstname + " C+");
			} else if (wa >= 1.85) {
				System.out.println(lastname.charAt(0) + ". " + firstname + " C");
			} else if (wa >= 1.5) {
				System.out.println(lastname.charAt(0) + ". " + firstname + " C-");
			} else if (wa >= 1.15) {
				System.out.println(lastname.charAt(0) + ". " + firstname + " D+");
			} else if (wa >= 0.85) {
				System.out.println(lastname.charAt(0) + ". " + firstname + " D");
			} else {
				System.out.println(lastname.charAt(0) + ". " + firstname + " F");
			}

		}
	}

}
