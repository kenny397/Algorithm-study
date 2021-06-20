package algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class C13334{
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int i, d, max = -1, n = Integer.parseInt(in.readLine());
		Line line[] = new Line[n];
		String tmp[];
		for(i=0;i<n;i++) {
			tmp = in.readLine().split(" ");
			line[i] = new Line(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
		}
		d = Integer.parseInt(in.readLine());
		
		java.util.Arrays.sort(line);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(i=0;i<n;i++) {
			pq.offer(line[i].left);
			
			while(!pq.isEmpty() && pq.peek() < line[i].right - d) pq.poll();
			
			max = Math.max(max, pq.size());
		}
		
		out.write(max+"");
		out.close();
		in.close();
	}
}

class Line implements Comparable<Line> {
	int left, right;
	public Line(int left, int right) {
		this.left = Math.min(left, right);
		this.right = Math.max(left, right);
	}
	
	@Override
	public int compareTo(Line anotherHo) {
		return Integer.compare(right, anotherHo.right);
	}
}
