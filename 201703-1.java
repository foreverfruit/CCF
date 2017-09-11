// 12:55 - 13:05
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n,k,result=0;
		n = sc.nextInt();
		k = sc.nextInt();

		int [] cakes = new int[n];
		for(int i=0;i<n;i++){
			cakes[i] = sc.nextInt();
		}

		int weigh = 0;
		for(int i=0;i<n;i++){
			if(cakes[i]+weigh >= k){
				result++;
				weigh=0;
			}else{
				weigh+=cakes[i];
			}
		}
		if(weigh>0){
			result++;
		}

		System.out.println(result);

		sc.close();
	}
}