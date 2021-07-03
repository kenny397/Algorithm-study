package algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class C1700 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		ArrayList<ArrayList<Integer>>al=new ArrayList<>();
		int[]sch=new int[k];
		ArrayList<Integer>multi=new ArrayList<>();
		for(int i=0; i<=k; i++) {
			al.add(new ArrayList<>());
		}
		int ans=0;
		for(int i=0; i<k; i++) {
			sch[i]=sc.nextInt();
			al.get(sch[i]).add(i);
		}
		
		for(int z=0; z<k; z++) {
			if(multi.contains(sch[z])) {
				al.get(sch[z]).remove(0);
				continue;
			}
			if(multi.size()<n) {
			multi.add(sch[z]);
			al.get(sch[z]).remove(0);
	//		System.out.println("플러그 개수가 적음"+sch[z]);
			}else {
			boolean flag=false;
			int last=0;
			int lastidx=0;
			for(int i=0; i<multi.size(); i++) {
				if(al.get(multi.get(i)).size()==0) {
					multi.remove(i);
					ans++;
					multi.add(sch[z]);
					al.get(sch[z]).remove(0);
		//			System.out.println("플러그 0이 보임"+sch[z]);
					flag=true;
					break;
				}else {
					if(last<al.get(multi.get(i)).get(0)) {
						lastidx=i;
						last=al.get(multi.get(i)).get(0);
					}
				}
				
			}
			if(!flag) {
				multi.remove(lastidx);
				ans++;
				multi.add(sch[z]);
		//		System.out.println("뒤에 나올만한거 ㅒㅃ기"+sch[z]);
				al.get(sch[z]).remove(0);
				
			}
		}
		}
		
		System.out.println(ans);
		
	}
	static class Node implements Comparable<Node>{
		int num;
		int cnt;
		Node(int num,int cnt){
			this.num=num;
			this.cnt=cnt;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cnt;
		}
	}

}