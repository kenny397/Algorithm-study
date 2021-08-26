package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class PS_무지의먹방라이브 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]f= {1,1,1,1};
		int k= 4;
		System.out.println(solution(f,k));
	}
	public static int solution(int[] food_times, long k) {
		boolean v[]=new boolean[food_times.length];
		
		LinkedList<Food>al=new LinkedList<>();
		long sum=0;
        for(int i=0; i<food_times.length; i++) {
        	al.add(new Food(i,food_times[i]));
        	sum+=food_times[i];
        }
        if(sum<=k)return -1;
        long min=0; 
        int n=food_times.length;
        Collections.sort(al,(o1,o2)->o1.remain-o2.remain);
        while(!al.isEmpty()) {
        	if(n*(al.get(0).remain-min)<=k) {	
        		k-=n*(al.get(0).remain-min);
        		min=al.get(0).remain;
        		al.remove(0);
        		n--;
        	}else {
        		break;
        	}        	
        }
        Collections.sort(al,(o1,o2)->o1.idx-o2.idx);
        return al.get((int)(k%n)).idx+1;
        
        
    }
	static class Food{
		int idx;
		int remain;
		public Food(int idx, int remain) {
			super();
			this.idx = idx;
			this.remain = remain;
		}
		
	}
}
