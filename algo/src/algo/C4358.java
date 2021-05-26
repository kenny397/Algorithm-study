package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class C4358 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		double total=0;
		HashMap<String,Double>hm=new HashMap<>();
		

		while(sc.hasNextLine()) {
			String tree=sc.nextLine();
			hm.put(tree, hm.getOrDefault(tree, 0.0)+1.0);
			total++;
		}
		
		List<String> tr = new ArrayList<>(hm.keySet());
		Collections.sort(tr);
		
		for (int i = 0; i < tr.size(); i++) {
            double cnt = hm.get(tr.get(i));
            System.out.print(tr.get(i) + " ");
            System.out.println(String.format("%.4f", cnt/total));
        }
		sc.close();


	}

}
