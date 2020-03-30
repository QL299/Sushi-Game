package a1adept;

import java.util.Scanner;

public class A1Adept {
	
	// Do not change the main method.	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		process(s);
		
	}
	
	public static void process(Scanner s) {
		// Put your code here.
		int anumber = s.nextInt();
		int sum1 = 0;
		
		for (int i = 0; i < anumber ; i++) {
			sum1 += s.nextInt();
		}
		
		int totalpart = s.nextInt();
		int num_student = s.nextInt();
		
		for (int i = 0; i<= num_student; i++) {
			String firstname = s.next();
			String lastname = s.next();
			double sum2  = 0.0;
			double assignment = 0.0;
			int particip = s.nextInt();
					for(int j = 0;j < anumber ; j++) {
						sum2 += s.nextDouble();
								assignment = (sum2  / sum1)*100;
					}
			double parcip = 0.0;
					if (100 * particip / (totalpart* 0.8) >= 100) {
								parcip = 100;
						}else{
								parcip = 100 * particip /(totalpart* 0.8);
					}
			double mid = s.nextDouble();
			double finalexam = s.nextDouble();
			
			double wa = 0.4* assignment + 0.15 * parcip + 0.2 * mid + 0.25 * finalexam;
			                if (wa >= 94) {
								System.out.println(firstname.charAt(0) + ". " + lastname + " A");
							} else if (wa >= 90) {
								System.out.println(firstname.charAt(0) + ". " + lastname + " A-");
							} else if (wa >= 86) {
								System.out.println(firstname.charAt(0) + ". " + lastname + " B+");
							} else if (wa >= 83) {
								System.out.println(firstname.charAt(0) + ". " + lastname + " B");
							} else if (wa >= 80) {
								System.out.println(firstname.charAt(0) + ". " + lastname + " B-");
							} else if (wa >= 76) {
								System.out.println(firstname.charAt(0) + ". " + lastname + " C+");
							} else if (wa >= 73) {
								System.out.println(firstname.charAt(0) + ". " + lastname + " C");
							} else if (wa >= 70) {
								System.out.println(firstname.charAt(0) + ". " + lastname + " C-");
							} else if (wa >= 65) {
								System.out.println(firstname.charAt(0) + ". " + lastname + " D+");
							} else if (wa >= 60) {
								System.out.println(firstname.charAt(0) + ". " + lastname + " D");
							} else {
								System.out.println(firstname.charAt(0) + ". " + lastname+ " F");
							}

						}
					}

				}
