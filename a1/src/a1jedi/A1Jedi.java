package a1jedi;

import java.util.Scanner;

public class A1Jedi {

	// Do not change the main method.
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process(s);

	}

	public static void process(Scanner s) {
		// Put your code here.

		int anumber = s.nextInt();
		int sum1 = 0;
		for (int i = 0; i < anumber; i++) {
			int point = s.nextInt();
			sum1 = sum1 + point;
		}

		int student = s.nextInt();

		double[] r = new double[student];
		double[] a = new double[student];
		double[] m1 = new double[student];
		double[] m2 = new double[student];
		double[] f = new double[student];

		for (int i = 0; i < student; i++) {
			s.next();
			s.next();
			double recitation = s.nextDouble();
			double Precitation = recitation / 15;
			double Grade1;
			if (Precitation >= 0.95) {
				Grade1 = 4.0;
			} else if (Precitation >= 0.9) {
				Grade1 = 3.5 + (Precitation - 0.9) * 5.0;
			} else if (Precitation >= 0.8) {
				Grade1 = 2.5 + (Precitation - 0.8) * 10.0;
			} else if (Precitation >= 0.7) {
				Grade1 = 1.5 + (Precitation - 0.7) * 10.0;
			} else if (Precitation >= 0.4) {
				Grade1 = 0.0 + (Precitation - 0.4) * 5.0;
			} else {
				Grade1 = 0.0;
			}

			double sum2 = 0.0;
			for (int j = 0; j < anumber; j++) {
				double assignment = s.nextDouble();
				sum2 = sum2 + assignment;
			}

			double Passignment = sum2 / sum1;
			double Grade2;
			if (Passignment >= 0.95) {
				Grade2 = 4.0;
			} else if (Passignment >= 0.9) {
				Grade2 = 3.5 + (Passignment - 0.9) * 5.0;
			} else if (Passignment >= 0.8) {
				Grade2 = 2.5 + (Passignment - 0.8) * 10.0;
			} else if (Passignment >= 0.7) {
				Grade2 = 1.5 + (Passignment - 0.7) * 10.0;
			} else if (Passignment >= 0.4) {
				Grade2 = 0.0 + (Passignment - 0.4) * 5.0;
			} else {
				Grade2 = 0.0;
			}

			r[i] = Grade1;
			a[i] = Grade2;
			m1[i] = s.nextDouble();
			m2[i] = s.nextDouble();
			f[i] = s.nextDouble();
		}

		// m1
		double sum3 = 0;
		double average1 = 0;
		for (int i = 0; i < student; i++) {
			sum3 = sum3 + m1[i];
		}
		average1 = sum3 / student;

		double sumOfsquare1 = 0;
		double sd1 = 0;
		for (int i = 0; i < student; i++) {
			sumOfsquare1 = sumOfsquare1 + (m1[i] - average1) * (m1[i] - average1);
			double varience1 = sumOfsquare1 / student;
			sd1 = Math.sqrt(varience1);
		}
		for (int i = 0; i < student; i++) {
			m1[i] = (m1[i] - average1) / sd1;
		}

		for (int i = 0; i < student; i++) {
			if (m1[i] >= 1.0) {
				m1[i] = 4.0;
			} else if (m1[i] >= 0.0) {
				m1[i] = 3.0 + (m1[i] - 0.0) * 1.0;
			} else if (m1[i] >= -1.0) {
				m1[i] = 2.0 + (m1[i] - (-1.0)) * 1.0;
			} else if (m1[i] >= -1.5) {
				m1[i] = 1.0 + (m1[i] - (-1.5)) * 2.0;
			} else if (m1[i] >= -2.0) {
				m1[i] = 0.0 + (m1[i] - (-2.0)) * 2.0;
			} else {
				m1[i] = 0.0;
			}
		}

		// m2

		double sum4 = 0;
		double average2 = 0;
		for (int i = 0; i < student; i++) {
			sum4 = sum4 + m2[i];
		}
		average2 = sum4 / student;

		double sumOfsquare2 = 0;
		double sd2 = 0;
		for (int i = 0; i < student; i++) {
			sumOfsquare2 = sumOfsquare2 + (m2[i] - average2) * (m2[i] - average2);
			double varience2 = sumOfsquare2 / student;
			sd2 = Math.sqrt(varience2);
		}
		for (int i = 0; i < student; i++) {
			m2[i] = (m2[i] - average2) / sd2;
		}

		for (int i = 0; i < student; i++) {
			if (m2[i] >= 1.0) {
				m2[i] = 4.0;
			} else if (m2[i] >= 0.0) {
				m2[i] = 3.0 + (m2[i] - 0.0) * 1.0;
			} else if (m2[i] >= -1.0) {
				m2[i] = 2.0 + (m2[i] - (-1.0)) * 1.0;
			} else if (m2[i] >= -1.5) {
				m2[i] = 1.0 + (m2[i] - (-1.5)) * 2.0;
			} else if (m2[i] >= -2.0) {
				m2[i] = 0.0 + (m2[i] - (-2.0)) * 2.0;
			} else {
				m2[i] = 0.0;
			}
		}

		// final
		double sumf = 0;
		double averagef = 0;
		for (int i = 0; i < student; i++) {
			sumf = sumf + f[i];
		}
		averagef = sumf / student;

		double sumOfsquaref = 0;
		double sdf = 0;
		for (int i = 0; i < student; i++) {
			sumOfsquaref = sumOfsquaref + (f[i] - averagef) * (f[i] - averagef);
			double variencef = sumOfsquaref / student;
			sdf = Math.sqrt(variencef);
		}
		for (int i = 0; i < student; i++) {
			f[i] = (f[i] - averagef) / sdf;
		}

		for (int i = 0; i < student; i++) {
			if (f[i] >= 1.0) {
				f[i] = 4.0;
			} else if (f[i] >= 0.0) {
				f[i] = 3.0 + (f[i] - 0.0) * 1.0;
			} else if (f[i] >= -1.0) {
				f[i] = 2.0 + (f[i] - (-1.0)) * 1.0;
			} else if (f[i] >= -1.5) {
				f[i] = 1.0 + (f[i] - (-1.5)) * 2.0;
			} else if (f[i] >= -2.0) {
				f[i] = 0.0 + (f[i] - (-2.0)) * 2.0;
			} else {
				f[i] = 0.0;
			}
		}

		// letter
		int[] gArray = new int[11];
		for (int i = 0; i < student; i++) {
			double wa = 0.4 * a[i] + 0.1 * r[i] + 0.15 * m1[i] + 0.15 * m2[i] + 0.2 * f[i];
			if (wa >= 3.85) {
				gArray[0] += 1;
			} else if (wa >= 3.5) {
				gArray[1] += 1;
			} else if (wa >= 3.15) {
				gArray[2] += 1;
			} else if (wa >= 2.85) {
				gArray[3] += 1;
			} else if (wa >= 2.5) {
				gArray[4] += 1;
			} else if (wa >= 2.15) {
				gArray[5] += 1;
			} else if (wa >= 1.85) {
				gArray[6] += 1;
			} else if (wa >= 1.5) {
				gArray[7] += 1;
			} else if (wa >= 1.15) {
				gArray[8] += 1;
			} else if (wa >= 0.85) {
				gArray[9] += 1;
			} else {
				gArray[10] += 1;
			}
		}

		System.out.println("A : " + gArray[0]);
		System.out.println("A-: " + gArray[1]);
		System.out.println("B+: " + gArray[2]);
		System.out.println("B : " + gArray[3]);
		System.out.println("B-: " + gArray[4]);
		System.out.println("C+: " + gArray[5]);
		System.out.println("C : " + gArray[6]);
		System.out.println("C-: " + gArray[7]);
		System.out.println("D+: " + gArray[8]);
		System.out.println("D : " + gArray[9]);
		System.out.println("F : " + gArray[10]);

	}

	double []curved_mid = new double [num_student];
	double []curved_f = new double [num_student];
	
	
	for (int i = 0; i < num_student; i++) {
		if (n_mid[i] >= 2.0) {
			curved_mid[i] = (n_mid[i]- 1.0)/(2.0-1.0) * 100 + 1.00;
		} else if (n_mid[i] >= 1.0) {
			curved_mid[i] = (n_mid[i]- 0.0)/(1.0-0.0) * (100-94) + 94;
		} else if (n_mid[i] >= 0.0) {
			curved_mid[i] = (n_mid[i]- -1.0)/(0.0+1.0) * (94-85) + 85;
		} else if (n_mid[i] >= -1.0) {
			curved_mid[i] = (n_mid[i]- -1.5)/(-1.0+1.5) * (85-75) + 75;
		} else if (n_mid[i] >= -1.5) {
			curved_mid[i] = (n_mid[i]- -2.0)/(-1.5+2.0) * (75-65) + 65;
		} else if (n_mid[i] >= -2.0) {
			curved_mid[i] = (n_mid[i]- -3.0)/(-2.0+3.0) * (65-55) + 55;
		} else if (n_mid[i] >= -3.0) {
			curved_mid[i] = (n_mid[i]- -4.0)/(-3.0+4.0) * (55-30) + 30;
		} else {
			curved_mid[i]= 0.0;
		}
	}
	
	for (int i = 0; i < num_student; i++) {
		if (n_final[i] >= 2.0) {
			curved_f[i] = (n_final[i]- 1.0)/(2.0-1.0) * 100 + 1.00;
		} else if (n_final[i] >= 1.0) {
			curved_f[i] = (n_final[i]- 0.0)/(1.0-0.0) * (100-94) + 94;
		} else if (n_final[i] >= 0.0) {
			curved_f[i] = (n_final[i]- -1.0)/(0.0+1.0) * (94-85) + 85;
		} else if (n_final[i] >= -1.0) {
			curved_f[i] = (n_final[i]- -1.5)/(-1.0+1.5) * (85-75) + 75;
		} else if (n_final[i] >= -1.5) {
			curved_f[i] = (n_final[i]- -2.0)/(-1.5+2.0) * (75-65) + 65;
		} else if (n_final[i] >= -2.0) {
			curved_f[i] = (n_final[i]- -3.0)/(-2.0+3.0) * (65-55) + 55;
		} else if (n_final[i] >= -3.0) {
			curved_f[i] = (n_final[i]- -4.0)/(-3.0+4.0) * (55-30) + 30;
		} else {
			curved_f[i]= 0.0;
		}
	}
}
