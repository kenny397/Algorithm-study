package algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C11000 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[][]room=new int[n][2];
		for(int i=0; i<n; i++) {
			room[i][0]=sc.nextInt();
			room[i][1]=sc.nextInt();
		}
		Arrays.sort(room,new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0])return o1[1]-o2[1];
				return o1[0]-o2[0];
			}
		});
		PriorityQueue<Integer>pq=new PriorityQueue<>();
		pq.add(room[0][1]);
		for(int i=1; i<n; i++) {
			if(pq.peek()<=room[i][0])pq.poll();
			
			pq.add(room[i][1]);
		}
		System.out.println(pq.size());
	}

}
