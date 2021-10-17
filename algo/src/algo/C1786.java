package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class C1786 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] t=br.readLine().toCharArray();
		char[] p=br.readLine().toCharArray();
		int tl=t.length;
		int pl=p.length;
		int[]pi=new int[pl];
		
		for(int i=1,j=0; i<pl; i++) {
			
			while(j>0&& p[i]!=p[j]) {
				j=pi[j-1];
			}
			
			if(p[i]==p[j]) {
				pi[i]=++j;
			}
			
		}
		
		int cnt=0;
		ArrayList<Integer> list =new ArrayList<>();
		for(int i=0,j=0; i<tl; i++) {
			
			while(j>0&& t[i]!=p[j]) {
				j=pi[j-1];
			}
			
			if(t[i]==p[j]) {
				if(j==pl-1) {
					cnt++;
					list.add(i+2-pl);
					j=pi[j];
				}else {
					j++;
				}
			}
			
		}
		System.out.println(cnt);
		if(cnt>0) {
			for(int q: list) {
				System.out.print(q+" ");
			}
		}
		
	}

}
