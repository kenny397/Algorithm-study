package algo;
import java.util.*;
public class C1052 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int result=0;
		int bitcount=countBit(n);
		while(bitcount>k) {
			n=n+1;
			result++;
			bitcount=countBit(n);
		}
		System.out.println(result);
	}
	static int countBit(int value) {
		int count =0;
		while(value!=0) {
			count+=(value&1);
			value=value>>>1;
		}
		return count;
	}

}
