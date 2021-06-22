package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class C2668 {
static boolean[] v;
static int[]map;
static int[][]m;
static int max;
static ArrayList<Integer>al=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		map=new int[n+1];
		
		v=new boolean[n+1];
		for(int i=1; i<=n; i++) {
			map[i]=sc.nextInt();
		}
		for(int i=1; i<=n; i++) {
			dfs(map[i],i);
		}
		Collections.sort(al);
		System.out.println(al.size());	
		for(int i : al) {
			System.out.println(i);
		}		
	}
	static void dfs(int start,int ret) {
		if(start==ret) {
			al.add(ret);
			return;
		}
		if(v[start])return;
		v[start]=true;
		dfs(map[start],ret);
		v[start]=false;
		
	}

}
