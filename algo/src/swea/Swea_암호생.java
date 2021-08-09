package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Swea_암호생 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			Queue<Integer> q=new LinkedList<>();
			int n=sc.nextInt();
			for(int i=0; i<8; i++) {
				q.offer(sc.nextInt());
			}
			boolean flag=false;
			while(true) {
				for(int i=1; i<=5; i++) {
					int temp=q.poll();
					if(temp-i<=0) {
						q.offer(0);
						flag=true;
						break;
					}
					else q.offer(temp-i);
				}
				if(flag)break;
			}
			System.out.print("#"+t+" " );
			String ret="";
			while(!q.isEmpty()) {
				ret+=q.poll()+" ";
			}
			System.out.println(ret.substring(0,ret.length()-1));
		}
	}
	

}
