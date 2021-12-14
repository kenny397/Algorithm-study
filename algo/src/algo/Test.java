package algo;

import java.util.Set;
import java.util.HashSet;

class Sup{
	String x= "sup";
	public void method() {
		System.out.println("supmethod");
	}
}
class Sub extends Sup{
	String x="sub";
	@Override
	public void method() {
		System.out.println("submethod");
	}
}

public class Test {
	public static void main(String[] args) {
		Sub sub=new Sub();
		System.out.println(sub.x);
		sub.method();
		Sup sup=new Sub();
		System.out.println(sup.x);
		sup.method();
		

	}
}