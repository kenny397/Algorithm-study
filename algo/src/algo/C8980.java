package algo;

import java.util.Arrays;
import java.util.Scanner;

public class C8980 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int capacity=sc.nextInt();
		int m=sc.nextInt();
		Delivery[] map=new Delivery[m]; 
		int[] max=new int[n-1];
		Arrays.fill(max, capacity);
		for(int i=0; i<m; i++) {
			map[i]=new Delivery(sc.nextInt(),sc.nextInt(),sc.nextInt());
		}
		Arrays.sort(map);
		int ans=0;
		for(int i=0; i<m; i++) {
			int start=map[i].start;
			int end=map[i].end;
			int cnt=map[i].cnt;
			int min=Integer.MAX_VALUE;
			for(int j=start-1; j<end-1; j++) {
				min=Math.min(max[j], min);
			}
			if(cnt<=min) {
				for(int j=start-1; j<end-1; j++) {
					max[j]-=cnt;
				}
				ans+=cnt;
			}else {
				for(int j=start-1; j<end-1; j++) {
					max[j]-=min;
				}
				ans+=min;
			}
			
		}
		System.out.println(ans);
	}
	static class Delivery implements Comparable<Delivery>{
		int start,end,cnt;
		Delivery(int start,int end,int cnt){
			this.start=start;
			this.end=end;
			this.cnt=cnt;
		}
		@Override
		public int compareTo(Delivery o) {
			// TODO Auto-generated method stub
			if(o.end==this.end) {
				return o.start-this.start;
			}else {
				return this.end-o.end;
			}
		}
	}

}
