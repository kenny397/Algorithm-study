package algo;

import java.util.Arrays;
import java.util.Scanner;

public class C9576 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int test=0; test<t; test++) {
			int n=sc.nextInt();
			boolean[]v=new boolean[n+1];
			Arrays.fill(v, false);
			int k=sc.nextInt();
			Point[]points=new Point[k];
			for(int i=0; i<k; i++) {
				points[i]=new Point(sc.nextInt(),sc.nextInt());
			}
			Arrays.sort(points);
			for(int i=0; i<k; i++) {
				System.out.println(points[i].start+""+points[i].end);
			}
			int answer=0;
			for(int i=0; i<k; i++) {
				int startbook=points[i].start;
				int endbook=points[i].end;
				for(int j=startbook; j<=endbook; j++) {
					if(!v[j]) {
						v[j]=true;
						answer++;
						break;
					}
				}
			}
			System.out.println(answer);
		}
	}
	
	static class Point implements Comparable<Point>{
		int start;
		int end;
		Point(int start,int end){
			this.start=start;
			this.end=end;
			
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			if(this.end==o.end) {
				return this.start-o.start;
			}
			return this.end-o.end;
		}
	}

}
