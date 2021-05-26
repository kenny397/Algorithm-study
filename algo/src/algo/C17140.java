package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

//이차원 배열과 연산
public class C17140 {
static int count=0;
static int r;
static int c;
static int k;
static int row=3;
static int col=3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		r=sc.nextInt();
		c=sc.nextInt();
		k=sc.nextInt();
		int[][]map=new int[1000][1000];
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				map[i][j]=sc.nextInt();
			}
			
		}
		int time=-1;
		while(true) {
			
			time++;
			if(checkrck(map))break;
			if(time>100) {
				time=-1;
				break;
			}
			if(row>100||col>100) {
				time=-1;
				break;
			}
			if(col<=row) {
				operateR(map);
				
			}else {
				operateC(map);
			}
			
		}
		System.out.println(time);
//		operateR(map);
//		operateC(map);
//		for(int i=0; i<col; i++) {
//			for(int j=0; j<row; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
	}
	
	static boolean checkrck(int[][]map) {
		if(map[r-1][c-1]==k)return true;
		return false;
	}
	static void operateR(int[][]map) {
		HashMap<Integer,Integer>hm=new HashMap<>();
		int l=0;
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++)
			{
				if(map[i][j]==0)continue;
				hm.put(map[i][j], hm.getOrDefault(map[i][j], 0)+1);
				map[i][j]=0;
				
			}ArrayList<form>al=new ArrayList<>();
			for(int x : hm.keySet()) {
				al.add(new form(x,hm.get(x)));
			}
			Collections.sort(al);
			int index=0;
			for(int j=0; j<al.size(); j++) {
				map[i][index]=al.get(j).num;
				map[i][index+1]=al.get(j).count;
				index+=2;
			}
				l=Math.max(l, hm.size()*2);
				hm=new HashMap<>();
				
			
		}
		col=l;
		
		
	}
	static void operateC(int[][]map) {
		HashMap<Integer,Integer>hm=new HashMap<>();
		int l=0;
		for(int i=0; i<col; i++) {
			for(int j=0; j<row; j++)
			{	if(map[j][i]==0)continue;
				hm.put(map[j][i], hm.getOrDefault(map[j][i], 0)+1);
				map[j][i]=0;
				
			}ArrayList<form>al=new ArrayList<>();
			for(int x : hm.keySet()) {
				al.add(new form(x,hm.get(x)));
			}
			Collections.sort(al);
			int index=0;
			for(int j=0; j<al.size(); j++) {
				map[index][i]=al.get(j).num;
				map[index+1][i]=al.get(j).count;
				index+=2;
			}
				l=Math.max(l, hm.size()*2);
				hm=new HashMap<>();
				
			
		}
		row=l;
	}
	
}
class form implements Comparable<form>{
	int num;
	int count;
	form(int num, int count){
		this.num=num;
		this.count=count;
	}
	@Override
	public int compareTo(form o) {
		int r= this.count-o.count;
		if(r==0)r=this.num-o.num;
		return r;
	}
}
