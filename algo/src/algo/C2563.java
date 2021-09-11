package algo;

import java.util.PriorityQueue;
import java.util.Scanner;

public class C2563 {
static int[][]paper;
static int ret;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		PriorityQueue<Student> q=new PriorityQueue<>((o1,o2)->
			Integer.compare(o1.score,o2.score)
		);
		q.offer(new Student(5,10));
		q.offer(new Student(3,50));
		q.offer(new Student(4,20));
		q.offer(new Student(2,70));
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
	}

	static class Student{
		int no;
		int score;
		public Student(int no, int score) {
			super();
			this.no = no;
			this.score = score;
		}
		@Override
		public String toString() {
			return "Student [no=" + no + ", score=" + score + "]";
		}
		
	}
}
