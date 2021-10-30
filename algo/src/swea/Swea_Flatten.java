package swea;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Swea_Flatten {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			int count=sc.nextInt();
			int[]box=new int[100];
			for(int i=0; i<box.length; i++) {
				box[i]=sc.nextInt();
			}
			Arrays.sort(box);
			PriorityQueue<Integer> minpq=new PriorityQueue<>();
			PriorityQueue<Integer> maxpq=new PriorityQueue<>(Collections.reverseOrder());
			for(int i=0; i<50; i++) {
				minpq.add(box[i]);
				maxpq.add(box[99-i]);
			}
			//System.out.println(maxpq.peek()+" "+minpq.peek());
			
			while(count-->0) {
				if(Math.abs(minpq.peek()-maxpq.peek())<=1)break;
				int min=minpq.poll()+1;
				int max=maxpq.poll()-1;
				//System.out.println(min+" "+max);
				minpq.add(min);
				maxpq.add(max);
			}
			
			
		//	System.out.println(maxpq.peek()-minpq.peek());
//			for(int i=0; i<count; i++) {
//				Arrays.sort(box);
//				box[0]+=1;
//				box[99]-=1;
//			}
//			Arrays.sort(box);
			System.out.println("#"+t+" "+Math.abs(maxpq.peek()-minpq.peek()));
//			
			
		}
		
	}

}
