package algo;

import java.util.*;

public class C1713 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		
		int[] count = new int[101];
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < c; i++) {
			int st = sc.nextInt();			
			int index=101;
			int max=1001;
			int remove=0;
			if (al.size() == n) {
				if (al.contains(st)) {
					count[st]++;
				} else {
					for(int j=0; j<al.size(); j++) {
						int a=al.get(j);
						if(count[a]<max) {
							max=count[a];
							remove=a;
							index=j;			
						}
					}
					al.remove(index);
					count[remove]=0;
					al.add(st);
					count[st]++;
					
				}
			} else {
				if (al.contains(st)) {
					count[st]++;
				} else {
					al.add(st);
					count[st]++;
				}
			}
			System.out.print(al);
		}
		Collections.sort(al);
		for(int i=0; i<al.size(); i++) {
			System.out.print(al.get(i));
			if(i!=al.size()-1) {
				System.out.print(" ");
			}
		}
		
	
	}

	

}
