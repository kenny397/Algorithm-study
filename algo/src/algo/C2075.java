package algo;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C2075 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				pq.offer(sc.nextInt());
			}
		}
		for(int i=0; i<n-1; i++) {
			pq.poll();
		}
		System.out.println(pq.poll());
	}

}
