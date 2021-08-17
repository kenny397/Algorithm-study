package algo;

import java.util.Scanner;

public class C2839 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		while (true) {
			if (n < 0) {
				sum = -1;
				break;
			}
			if (n == 0) {
				break;
			}

			if (n % 5 == 0) {
				sum += n / 5;
				break;
			} else {
				n = n - 3;
				sum++;
			}

		}

		System.out.println(sum);
	}

}
