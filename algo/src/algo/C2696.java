package algo;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C2696 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0; i<t; i++) {
			int n=sc.nextInt();
			System.out.println((n+1)/2);
			PriorityQueue<Integer> max=new PriorityQueue<>();
			PriorityQueue<Integer> min=new PriorityQueue<>(Collections.reverseOrder());
			for(int j=0; j<n; j++) {
				int a=sc.nextInt();
				if(max.size()==min.size())min.add(a);
				else max.add(a);
				if(!min.isEmpty()&&!max.isEmpty()) {
					if(min.peek()>max.peek()) {
						int t1=min.poll();
						int t2=max.poll();
						min.add(t2);
						max.add(t1);
					}
				}
				if(min.size()!=max.size()) {
					System.out.print(min.peek()+" ");
				}
			}
			System.out.println();
			
			
		}
	}

}
