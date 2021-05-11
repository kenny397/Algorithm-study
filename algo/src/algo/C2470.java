package algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class C2470 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ex = new int[n];
		for (int i = 0; i < n; i++) {
			ex[i] = sc.nextInt();
		}
		Arrays.sort(ex);

		int ret1 = 0;
		int ret2 = 0;
		
		int left=0;
			int right=n-1;
			int min=Integer.MAX_VALUE;
			while(left<right) {
				int mix2=ex[left]+ex[right];
				int mix=Math.abs(mix2);
				if(mix<min) {
				min=mix;
				ret1=left;
				ret2=right;
		
				}
				if(mix2>0) {
					right--;
				}else {
					left++;
				}
				
			
		}
		
		System.out.println(ex[ret1]+" "+ex[ret2]);

	}

}
