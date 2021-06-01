package algo;

import java.util.HashMap;
import java.util.Scanner;

public class C2002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		HashMap<String,Integer>hm=new HashMap<>();
		for(int i=0; i<n; i++) {
			String a=sc.next();
			hm.put(a, i);
		}int answer=0;
		int[]out=new int[n];
		for(int i=0; i<n; i++) {
			String a=sc.next();
			out[i]=hm.get(a);
		}
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(out[i]>out[j]) {
					answer++;
					break;
				}
			}
		}
		System.out.println(answer);
	}

}
