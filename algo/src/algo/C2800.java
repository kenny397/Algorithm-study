package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class C2800 {
static ArrayList<Node>al=new ArrayList<>();

static int idx;
static String[]p;
static String s;
static ArrayList<String>answer=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		 s=sc.next();
		p=s.split("");
		find(s);
		idx=0;
		
		for(int i=1; i<1<<al.size(); i++) {
			ArrayList<Integer>al2=new ArrayList<>();
			for(int j=0; j<al.size(); j++) {
				if((1<<j&i)==1<<j) {
				al2.add(j);
					
				}
				
			}for(int j=0; j<al2.size(); j++) {
					p[al.get(al2.get(j)).start]="";
					p[al.get(al2.get(j)).end]="";
			}
			an();
			for(int j=0; j<al2.size(); j++) {
				p[al.get(al2.get(j)).start]=")";
				p[al.get(al2.get(j)).end]="(";
		
			}
		}
		Collections.sort(answer);
		for(int i=0; i<answer.size(); i++) {
			System.out.println(answer.get(i));
		}
	}
	
	static void find(String s) {
		Stack<Integer> st=new Stack<>();
		for(int i=0; i<s.length();i++) {
			if(s.charAt(i)=='(') {
				st.push(i);
			}
			else if(s.charAt(i)==')') {
				int end=st.pop();
				al.add(new Node(i,end));
			}
		}
	}
	static class Node{
		int start;
		int end;
		Node(int start,int end){
			this.start=start;
			this.end=end;
		}
	}
	static void an() {
		String ret="";
		for(int i=0; i<s.length(); i++) {
			ret=ret+p[i];
		}
		if(answer.contains(ret)) {
			return;
		}
		answer.add(ret);
	}

}
