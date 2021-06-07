package algo;

import java.util.Scanner;

public class C1342 {
static int l;
static int[] alpha;
static int ret;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		alpha=new int[26]; 
		String a=sc.next();
		l=a.length();
		for(int i=0; i<a.length(); i++) {
			char t=a.charAt(i);
			alpha[t-'a']++;
		}
		for(int i=0; i<26; i++) {
			if(alpha[i]!=0) {
				int t=i+'a';
				char t1=(char)t;
				alpha[i]--;
				make(1,""+t1);
				alpha[i]++;
			}
		}
		
		System.out.println(ret);
	}
	static void make(int deep,String ma) {
		if(deep==l) {
			ret++;
		}
		for(int i=0; i<26; i++) {
			if(alpha[i]==0) {
				continue;
			}
			
			if(ma.charAt(ma.length()-1)==(char)i+'a') {
				continue;
			}
			int t=i+'a';
			char t1=(char)t;
			alpha[i]--;
			make(deep+1,ma+t1);
			alpha[i]++;
		}
		
	}
}
