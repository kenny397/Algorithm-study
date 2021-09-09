package algo;

import java.util.*;
public class C1158 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		ArrayList<Integer> al=new ArrayList<>();
		Queue<Integer> q=new LinkedList<>();
		for(int i=1; i<=n;i++) {
			q.add(i);
			al.add(i);		
		}
		int idx=0;
		while(!al.isEmpty()) {
			idx=(idx+k-1)%al.size();
			System.out.println(al.remove(idx));
			
		}
		System.out.print("<");
		while(!q.isEmpty()) {
			for(int i=0; i<k-1;i++) {
				q.add(q.poll());
			}
			if(q.size()==1) {
				System.out.print(q.poll());
			}else {
				System.out.print(q.poll()+", ");
			}
			
		}
		System.out.print(">");
	}

}