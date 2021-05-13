package algo;

import java.util.PriorityQueue;
import java.util.Scanner;

public class C1715 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		PriorityQueue<Long> pq =new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			pq.offer((long)sc.nextInt());
		}
		
		long cost=0;
		if(pq.size()==1)cost=pq.poll();
		while(!pq.isEmpty()) {
			long t=pq.poll();
			long t2=pq.poll();
			
			long sum=t+t2;
			cost+=sum;
			if(pq.isEmpty())break;
			pq.offer(sum);
			
		}
		System.out.println(cost);
			
	}

}
