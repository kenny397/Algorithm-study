package algo;

import java.util.Arrays;
import java.util.Scanner;

public class C2304 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Box[]warehouse=new Box[n];
		int max=0;
		for(int i=0; i<n; i++) {
			warehouse[i]=new Box(sc.nextInt(),sc.nextInt());
			if(max<=warehouse[i].height) {
				max=warehouse[i].height;
			}
		}
		
		Arrays.sort(warehouse);
		int htemp=0;
		int ret=0;
		int mid=0;
		int idx=0;
		for(int i=0; i<n; i++) {
			if(max==warehouse[i].height) {
			//	System.out.println((warehouse[i].idx-idx)*htemp);
				
				ret+=(warehouse[i].idx-idx)*htemp;
				htemp=warehouse[i].height;
				idx=i;
				mid=warehouse[i].idx;
				break;
			}else {
				if(htemp<warehouse[i].height) {
				//	System.out.println((warehouse[i].idx-idx)*htemp);
		
					ret+=(warehouse[i].idx-idx)*htemp;
					htemp=warehouse[i].height;
					idx=warehouse[i].idx;
				}
			}
		}
		htemp=0;
		int idx2=1000;
		for(int i= n-1; i>=idx; i--) {
			if(warehouse[i].height==max) {
			//	System.out.println((idx2-warehouse[i].idx)*htemp);
				ret+=(idx2-warehouse[i].idx)*htemp;
				
			//	System.out.println((warehouse[i].idx+1-mid)*max);
				ret+=(warehouse[i].idx+1-mid)*max;
				break;
			}
			
			
			if(htemp<warehouse[i].height) {
	
				ret+=(idx2-warehouse[i].idx)*htemp;
				htemp=warehouse[i].height;
				idx2=warehouse[i].idx;
			}
		}
		
		System.out.println(ret);
	}

	static class Box implements Comparable<Box>{
		int idx;
		int height;
		public Box(int idx, int height) {
			this.idx = idx;
			this.height = height;
		}
		
		@Override
		public int compareTo(Box o) {
			// TODO Auto-generated method stub
			return this.idx-o.idx;
		}
	}
}
