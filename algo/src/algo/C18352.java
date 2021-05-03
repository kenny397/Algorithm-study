package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class C18352 {
static boolean[] isVisit;
static int[] distance;
static ArrayList<ArrayList<Integer>> roads=new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int k=sc.nextInt();
		int x=sc.nextInt();
		for(int i=0; i<n; i++) {
			roads.add(new ArrayList<>());
		}
		for(int i=0; i<m; i++) {
			int start=sc.nextInt();
			int end=sc.nextInt();
			roads.get(start-1).add(end-1);
		}
		distance=new int[n];
		isVisit=new boolean[n];
		isVisit[x-1]=true;
		distance[x-1]=0;
		Queue<Integer>q=new LinkedList<>();
		q.add(x-1);
		while(!q.isEmpty()) {
			int current=q.poll();
			for(int i : roads.get(current)) {
				if(!isVisit[i]) {
					q.offer(i);
					isVisit[i]=true;
					distance[i]=distance[current]+1;
				}
			}
			
		}
		ArrayList<Integer>answer=new ArrayList<>();
		for(int i=0; i<n; i++) {
			if(distance[i]==k) {
				answer.add(i+1);
			}
		}
		if(answer.size()==0) {
			System.out.println(-1);
		}else {
			for(int j:answer) {
				System.out.println(j);
			}
		}
	}
	//다익스트라 시간초과
		/*for(int i=0; i<n; i++) {
			roads.add(new ArrayList<>());
		}
		for(int i=0; i<m; i++) {
			int start=sc.nextInt();
			int end=sc.nextInt();
			roads.get(start-1).add(end-1);
		}
		distance=new int[n];
		isVisit=new boolean[n];
		Arrays.fill(distance,Integer.MAX_VALUE);
		dj(x-1);
		
		
		
		
		
		//플로이드워셜로 찾기 메모리 초과
		/*	long [][] city=new long[n+1][n+1];
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(i==j)continue;
				city[i][j]=Integer.MAX_VALUE;
				
			}
		}
		
		for(int i=0; i<m; i++) {
			int start=sc.nextInt();
			int end=sc.nextInt();
			city[start][end]=1;
		}
		for(int z=1; z<n+1; z++ ) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					city[i][j]=Math.min(city[i][j], city[i][k]+city[k][j]);
				}
			}
		}
		ArrayList<Integer>answer=new ArrayList<>();
		for(int i=0; i<n; i++) {
			if(distance[i]==k) {
				answer.add(i+1);
			}
		}
		if(answer.size()==0) {
			System.out.println(-1);
		}else {
			for(int j:answer) {
				System.out.println(j);
			}
		}
		
		
	}
	static void dj(int start) {
		distance[start]=0;
		isVisit[start]=true;
		
		for(int i : roads.get(start))
		{	
				distance[i]=distance[start]+1;	
		}
		for(int i=0; i<distance.length-1; i++) {
			int min=Integer.MAX_VALUE;
			int minIdx=-1;
			for(int j=0; j<distance.length; j++) {
				if(!isVisit[j]&&distance[j]!=Integer.MAX_VALUE) {
					if(distance[j]<min) {
						min=distance[j];
						minIdx=j;
					}
				}
			}
			isVisit[minIdx]= true;
			for(int j : roads.get(minIdx)) {
				if(!isVisit[j]) {
					if(distance[j]>distance[minIdx]+1) {
						distance[j]=distance[minIdx]+1;
					}
				}
			}
			
			
		}
	}*/

}
