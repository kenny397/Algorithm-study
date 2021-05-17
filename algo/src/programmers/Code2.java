package programmers;

public class Code2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(sol(7));
	}
	static long sol(long input){
        long idx=(input+1)&(~input);
        input=input|idx;
        input=input&~(idx>>1);
        return input;
}
}
