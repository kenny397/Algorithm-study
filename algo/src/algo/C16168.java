package algo;

import java.util.ArrayList;
import java.util.Scanner;

public class C16168 {
static ArrayList<ArrayList<Integer>>al=new ArrayList<>();
static String answer="NO";
static int[][] circuit;
static int e;
public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		e=sc.nextInt();
		for(int i=0; i<=v; i++) {
			al.add(new ArrayList<>());
		}
		circuit=new int[v+1][v+1];
		for(int i=0; i<e; i++) {
			int start=sc.nextInt();
			int end=sc.nextInt();
			al.get(start).add(end);
			al.get(end).add(start);
		}
		for(int i=1; i<=v; i++) {
			dfs(i,0,i);
		}
		System.out.println(answer);
		
	}
	static void dfs(int start,int count, int num ) {
		if(count==e) {
			answer="YES";
			return;
		}
		for(int i: al.get(start)) {
			if(circuit[i][start]==num||circuit[start][i]==num) {
				continue;
			}
			circuit[i][start]=num;
			circuit[start][i]=num;
			dfs(i,count+1,num);
		}
	}

}
