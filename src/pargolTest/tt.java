package pargolTest;

import java.util.Scanner;

public class tt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter the number of lines (odd number): ");
	        int n = scanner.nextInt();

	        if (n % 2 == 0) {
	            System.out.println("Please enter an odd number.");
	        } else {
	            for (int i = 1; i <= n; i++) {
	                for (int j = 1; j <= Math.abs(n / 2 - i); j++) {
	                    System.out.print(" ");
	                }

	                int num = i;
	                for (int k = 1; k <= i * 2 - 1; k++) {
	                    System.out.print(num);
	                    if (k < i) {
	                        num--;
	                    } else {
	                        num++;
	                    }
	                }

	                System.out.println();
	            }
	        }

	        scanner.close();
	}

}
