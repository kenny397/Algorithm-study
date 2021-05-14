package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C7662 {
static PriorityQueue<Integer> maxpq;
static PriorityQueue<Integer> minpq;
static HashMap<Integer,Integer>result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		
		for(int i=0; i<testcase; i++) {
			int opreationcase=sc.nextInt();
			minpq=new PriorityQueue<>();
			maxpq=new PriorityQueue<>(Collections.reverseOrder());
			result=new HashMap<>();
			
			for(int j=0; j<opreationcase; j++) {
				String operate=sc.next();
				int target=sc.nextInt();
				
				operation(operate,target);
			}
			//System.out.println(result);
			ArrayList<Integer> al=new ArrayList<>(result.keySet());
			Collections.sort(al);
			if(al.size()>0) {
				System.out.println(al.get(al.size()-1)+" "+al.get(0));
			}else {
				System.out.println("EMPTY");
			}
		}
	}
	static void operation(String opr, int target) {
		
		if(opr.equals("I")) {
			result.put(target, result.getOrDefault(target, 0)+1);
			minpq.offer(target);
			maxpq.offer(target);
//			System.out.println(result);
		}
		if(result.isEmpty())return;
		if(opr.equals("D")) {
			if(target==1) {
				while(true) {
					int max=maxpq.poll();
					if(result.containsKey(max)) {
					int t=result.get(max);
					if(t==1)result.remove(max);
					else result.put(max, t-1);
					
					break;
				}else {
					continue;
				}
				}
				
			}
			if(target==-1) {
				while(true) {
					int min=minpq.poll();
				if(result.containsKey(min)) {
					int t=result.get(min);
					if(t==1)result.remove(min);
					else result.put(min, t-1);
					
					break;
				}else {
					continue;
					}
				}
				
			}
		}
		if(result.isEmpty()) {
			maxpq.clear();
			minpq.clear();
		}
		
	}

}
