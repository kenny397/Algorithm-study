package algo;

import java.util.HashMap;
import java.util.Scanner;

public class C2531 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int d=sc.nextInt();
		int k=sc.nextInt();
		int c=sc.nextInt();
		int[]belt=new int[n];
		HashMap<Integer,Integer>hm=new HashMap<>();
		for(int i=0; i<n; i++) {
			belt[i]=sc.nextInt();
		}
		hm.put(c,1);
		for(int i=0; i<k; i++) {
			hm.put(belt[i], hm.getOrDefault(belt[i],0)+1);
		}
		int result=hm.keySet().size();
		for(int i=1; i<n; i++) {
			hm.put(belt[i-1], hm.getOrDefault(belt[i-1],0)-1);
			hm.remove(belt[i-1],0);
			if(i+k-1>=n) {
				hm.put(belt[i+k-1-n], hm.getOrDefault(belt[i+k-1-n],0)+1);
			}
			else {
				hm.put(belt[i+k-1], hm.getOrDefault(belt[i+k-1],0)+1);
			}
			
			result=Math.max(result, hm.keySet().size());
		}
		System.out.println(result);
		
		
	}
	
}
