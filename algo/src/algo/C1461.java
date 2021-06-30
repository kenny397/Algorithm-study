package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.border.MatteBorder;

public class C1461 {
static int[]bookinfo;
static int m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		m=sc.nextInt();
		ArrayList<Integer> left=new ArrayList<>();
		ArrayList<Integer> right=new ArrayList<>();
		for(int i=0; i<n; i++) {
			int t=sc.nextInt();
			if(t>0) {
				right.add(t);
			}if(t<0) {
				left.add(t);
			}
		}
		Collections.sort(left);
		Collections.sort(right,Comparator.reverseOrder());
		
		int rmax=0;
		int lmax=0;
		if(!right.isEmpty()) {
			rmax=right.get(0);
		}
		if(!left.isEmpty()) {
			lmax=left.get(0);
		}
		int max=Math.max(rmax, Math.abs(lmax));
		int idx=0;
		int ret=0;
		while(!right.isEmpty()) {
			ret+=right.get(0)*2;
			if(right.size()<m) {
				int count=right.size();
				
				for(int i=0; i<count; i++) {
					
					right.remove(0);
				}
			}else {
				for(int i=0; i<m; i++) {
					
					right.remove(0);
				}
			}
		}
		while(!left.isEmpty()) {
			ret+=left.get(0)*-2;
			if(left.size()<m) {
				int count=left.size();
				for(int i=0; i<count; i++) {
					left.remove(0);
				}
			}else {
				for(int i=0; i<m; i++) {
					left.remove(0);
				}
			}
		}
		System.out.println(ret-max);
	}

}
