package algo;

import java.util.*;

public class C14569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		ArrayList<ArrayList<Integer>> students=new ArrayList<>();
		ArrayList<ArrayList<Integer>> subjects=new ArrayList<>();
		int n=sc.nextInt();
		
		for(int i=0; i<n; i++) {
			int k=sc.nextInt();
			ArrayList<Integer>al=new ArrayList<>();
			for(int j=0; j<k; j++) {
				int t=sc.nextInt();
				al.add(t);
			}
			subjects.add(al);
			
		}
		int m=sc.nextInt();
		
		for(int i=0; i<m; i++) {
			int k=sc.nextInt();
			ArrayList<Integer>al=new ArrayList<>();
			for(int j=0; j<k; j++) {
				int t=sc.nextInt();
				al.add(t);
			}
			students.add(al);
		}
		for(int i=0; i<m; i++) {
			int count =0; 
			for(int j=0; j<subjects.size();j++) {
				if(students.get(i).containsAll(subjects.get(j))) {
					count++;
				}
			}
			System.out.println(count);
		}
		
			int q=1<<1;
			System.out.println(q);
			
		}
	}


