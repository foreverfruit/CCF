import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class N2017031 {
	
	public static void main_N2017031(String [] args) {
		// input
		int n,k,count=0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<n;i++){
			list.add(sc.nextInt());
		}
		
		// sort
		Collections.sort(list);
		
		// distribute cake
		int total = 0;
		while(!list.isEmpty()) {
			total += list.remove(0);
			if(total>k) {
				count++;
				total = 0;
			}
		}
		if(total!=0) {
			count++;
		}
		
		// output result
		System.out.print(count);
		sc.close();
	}
	
}


