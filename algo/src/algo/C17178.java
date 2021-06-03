package algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class C17178 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String[][] line=new String[n][5];
		String[]answer=new String[n*5];
		for(int i=0; i<n; i++) {
			for(int j=0; j<5; j++) {
				String a=sc.next();
				line[i][j]=a;
				answer[(i*5)+j]=a;
			}
		}
		
		Arrays.sort(answer,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if(o1==null||o2==null) {
					return 1;
				}
				if(o1.charAt(0)-o2.charAt(0)==0) {
					return Integer.parseInt(o1.substring(2))- Integer.parseInt(o2.substring(2));
				}else {
					return o1.charAt(0)-o2.charAt(0);
				}
			}
			
		});
		
		int index=0;
		Stack<String>wating=new Stack<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<5; j++) {
				wating.add(line[i][j]);
				while(!wating.isEmpty()&&wating.peek().equals(answer[index])) {
					index++;
					wating.pop();
				}
			}
		}
		if(wating.isEmpty()) {
			System.out.println("GOOD");
		}else {
			System.out.println("BAD");
		}
	}

}
