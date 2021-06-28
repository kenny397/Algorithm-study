package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class C2212 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int[]sensors=new int[n];
		for(int i=0; i<n; i++) {
			sensors[i]=sc.nextInt();
		}
		Arrays.sort(sensors);
		int[]distance=new int[n-1];
		for(int i=0; i<n-1; i++) {
			distance[i]=sensors[i+1]-sensors[i];
		}
		Arrays.sort(distance);
		int ret=0;
		for(int i=0; i<n-1-k+1; i++) {
			ret+=distance[i];
		}
		System.out.println(ret);
	}

}
