package algo;

import java.util.PriorityQueue;
import java.util.Scanner;

public class C13975 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int z=0; z<t; z++) {
			
			int n=sc.nextInt();
			PriorityQueue<Long> pq=new PriorityQueue<>();
			long ret=0;
			for(int i=0; i<n; i++) {
				pq.add(sc.nextLong());	
			}
			while(pq.size()>1) {
				long t1=pq.poll();
				long t2=pq.poll();
				long sum=t1+t2;
				pq.add(sum);
				ret+=sum;
			}
			System.out.println(ret);
		}
	}

}
