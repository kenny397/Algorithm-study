package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class C1038 {
static ArrayList<Long>al;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		al=new ArrayList<>();
		if(n<=10) {
			System.out.println(n);
		}else if(n>1022){
				System.out.println(-1);
			
		}
		
		else {	for(int i=0; i<10; i++) {
				Cal(i,1);
			}
			Collections.sort(al);
			System.out.println(al.get(n));
			
		}
		
	}
	static void Cal(long num, int depth) {
		if(depth>10) {
			return;
		}
		al.add(num);
		for(int i=0; i<10; i++) {
			if(num%10>i) {
				Cal((num*10)+i,depth+1);
			}
		}
		return;
	}

}
