package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class C13335 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int w=sc.nextInt();
		int l=sc.nextInt();
		int[]bus=new int[n];
		for(int i=0; i<n; i++) {
			bus[i]=sc.nextInt();
		}
		int idx=0;
		int count=1;
		Queue<Truck> q=new LinkedList<>();
		q.add(new Truck(bus[idx],count));
		l-=bus[idx];
		idx++;
		while(idx<n) {
			count++;
			Truck t=q.peek();
			if(t.timer+w==count) {
				l+=t.weight;
				q.poll();
			}
			if(bus[idx]<=l) {
				q.add(new Truck(bus[idx],count));
				l-=bus[idx];
				idx++;
			}
			
				
		}
		System.out.println(count+w);
		
	}
	 

}class Truck{
	 int weight;
	 int timer;
	public Truck(int weight,int timer){
		this.weight=weight;
		this.timer=timer;
	}
}
