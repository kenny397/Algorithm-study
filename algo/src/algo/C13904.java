package algo;

import java.util.Arrays;
import java.util.Scanner;

public class C13904 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		boolean[] work=new boolean[1001];
		Work[] works=new Work[n];
		for(int i=0; i<n; i++) {
			works[i]=new Work(sc.nextInt(),sc.nextInt());
		}
		Arrays.sort(works);
		int answer=0;
		for(int i=0; i<n; i++) {
			int day=works[i].dday;
			int s=works[i].score;
			while(day!=0) {
				if(!work[day]) {
					work[day]=true;
					answer+=s;
					break;
				}else {
					day--;
				}
			}
			
		}
		System.out.println(answer);
		
	}
	static class Work implements Comparable<Work>{
		int dday;
		int score;
		Work(int dday,int score){
			this.dday=dday;
			this.score=score;
		}
		@Override
		public int compareTo(Work o) {
			// TODO Auto-generated method stub
			if(this.score==o.score) {
				return o.dday-this.dday;
			}
			return o.score-this.score;
		}
		
	}

}
