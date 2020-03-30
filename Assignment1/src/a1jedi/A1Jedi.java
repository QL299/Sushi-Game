package a1jedi;

import java.util.Scanner;

public class A1Jedi {

	// Do not change the main method.

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process(s);
		
	}
	

	public static double c (double normal) {
		double c;
		if (normal >= 2.0) {
			c = 100;
		} else if (normal >= 1.0) {
			c = (normal- 1.0)/(1.0-0.0) * (100-94) + 94;
		} else if (normal >= 0.0) {
			c = (normal- 0)/(0.0+1.0) * (94-85) + 85;
		} else if (normal >= -1.0) {
			c = (normal+ 1)/1 * (85-75) + 75;
		} else if (normal >= -1.5) {
			c = (normal + 1.5)/(0.5) * (75-65) + 65;
		} else if (normal >= -2.0) {
			c = (normal + 2)/(0.5) * (65-55) + 55;
		} else if (normal >= -3.0) {
			c = (normal + 3)/(1) * (55-30) + 30;
		} else {
			c= 0.0;
		}
		return c;
	}

	
	public static void process(Scanner s) {
		// Put your code here.
		Scanner s1 = new Scanner(System.in);
		
		int anumber = s1.nextInt();
		int sum1 = 0;
		for (int i = 0; i < anumber; i++) {
			sum1 += s1.nextInt();
		}

		int total_p = s1.nextInt();
		int student = s1.nextInt();

        double[] p = new double[student];
		double[] a = new double[student];
		double[] m = new double[student];
		double[] f = new double[student];

		for (int i = 0; i < student; i++) {
			String firstname = s1.next();
			String lastname = s1.next();
			
			p[i] = s1.nextInt();
			if (100 * p[i] / (total_p* 0.8) >= 100) {
				p[i] = 100 ;
		       }else{
			    p[i] = 100 * p[i] /(total_p* 0.8);
	         }
            
			a[i] = 0;
            for(int j = 0;j < anumber ; j++) {
            	    a[i] += s1.nextDouble();
				}
            a[i] = (a[i] * 100) / sum1;
            

	        m[i] = s1.nextDouble();
	        f[i] = s1.nextDouble();
	        
		}
	
		//mid
		double sumOfmid = 0;
		for (int k = 0; k < student; k++) {
			sumOfmid = sumOfmid + m[k];
		}
		double average1 = 0;
		average1 = sumOfmid / student;
		
		double sumOfsquare_m = 0;
		for (int i = 0; i < student; i++) {
			sumOfsquare_m += ((m[i] - average1) * (m[i] - average1))/student;
		}
		double sd1 = 0;
		sd1 = Math.sqrt(sumOfsquare_m);
	

		//final
		double sumOfFinal = 0;
		for (int k = 0; k < student; k++) {
			sumOfFinal = sumOfFinal + f[k];
		}
		double averagef = 0;
		averagef = sumOfFinal / student;

		double sumOfsquare_f = 0;
		for (int i = 0; i < student; i++) {
			sumOfsquare_f += ((f[i] - averagef) * (f[i] - averagef))/student;
		}
		double sdf = 0;
		sdf = Math.sqrt(sumOfsquare_f);

		
		double []n_mid = new double [student];
		double []n_final = new double [student];
		double []curved_mid = new double [student];
		double []curved_f = new double [student];
		
		for(int i = 0;i < student;i++) {
			n_mid[i] = (m[i]-average1)/sd1;
			n_final[i] = (f[i]-averagef)/sdf;
			curved_mid[i] = c(n_mid[i]);
			curved_f[i] = c(n_final[i]);
		}

		double[] wa = new double [student];
		int [] gArray = new int [11];
		for (int i = 0; i < student; i++) {
			wa[i] = (0.40 * a[i] + 0.15 * p[i] + 0.20 *curved_mid[i] + 0.25 * curved_f[i])/100;
			if (wa[i] >= 0.94) {
				gArray[0] += 1;
			} else if (wa[i]>= 0.90) {
				gArray[1] += 1;
			} else if (wa[i] >= 0.86) {
				gArray[2] += 1;
			} else if (wa[i] >= 0.83) {
				gArray[3] += 1;
			} else if (wa[i] >= 0.80) {
				gArray[4] += 1;
			} else if (wa[i] >= 0.76) {
				gArray[5] += 1;
			} else if (wa[i] >= 0.73) {
				gArray[6] += 1;
			} else if (wa[i] >= 0.70) {
				gArray[7] += 1;
			} else if (wa[i]>= 0.65) {
				gArray[8] += 1;
			} else if (wa[i] >= 0.60) {
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


}


