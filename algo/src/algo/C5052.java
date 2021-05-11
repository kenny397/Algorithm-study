package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class C5052 {
static String[] s;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0; i<t; i++) {
			int n=sc.nextInt();
			s=new String[n];	
			
			for(int j=0; j<n; j++) {
				String z=sc.next();
				s[j]=z;
			}boolean flag=false;
			Arrays.sort(s,new Comparator<String>() {
				@Override
				public int compare(String o1,String o2) {
					return o1.compareTo(o2);
				}
				
			});
			for(int j=1; j<n; j++) {
				if(s[j].startsWith(s[j-1])) {
					flag=true;
					break;
				}
			}
			
			
			if(!flag)System.out.println("YES");
			if(flag)System.out.println("NO");
			
		}
	}
	

}
