package algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class C5430 {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		StringTokenizer z;
		ArrayDeque<Integer> dq=new ArrayDeque<>();
		int t=sc.nextInt();
		for(int i=0; i<t; i++) {
			String fuc=sc.next();
			fuc.replace("RR","");
			int n=sc.nextInt();
			z = new StringTokenizer(sc.next(), "[],");
			for(int j = 0; j < n; j++) {
				dq.add(Integer.parseInt(z.nextToken()));
			}
			boolean flag=false;
			boolean front=true;
			for(int j=0; j<fuc.length(); j++) {
				if(fuc.charAt(j)=='R') {
					front=!front;
				}
				if(fuc.charAt(j)=='D') {
					if(dq.isEmpty()) {
						flag=true; 
						break;
					}
					if(front)dq.removeFirst();
					else dq.removeLast();
					
				}
			}
			if(flag)sb.append("error\n");
			
			else {
				sb.append('[');	// 여는 대괄호 먼저 StringBuilder에 저장
				
				if(dq.size() > 0) {
				
				 if(front) {
					 sb.append(dq.pollFirst());
					while(!dq.isEmpty()) {
						sb.append(',').append(dq.pollFirst());
						
					}
					
					
				}
				else {
					 sb.append(dq.pollLast());
						while(!dq.isEmpty()) {
							sb.append(',').append(dq.pollLast());
							
						
					} 
				}
					
			}
			sb.append(']').append('\n');
		}
		
		
	}
		System.out.println(sb);
	
	
	}
}
