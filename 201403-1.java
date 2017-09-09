// 21:18 - 21:23
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();
		int [] arr = new int[size];

		for(int i=0;i<size;i++){
			arr[i] = sc.nextInt();
		}
		
		int result = 0;
		for(int i=0;i<size;i++){
			for(int j=0;j<size ;j++){
				if(0==arr[i]+arr[j]){
					result++;
				}
			}
		}

		System.out.println(result/2);

		sc.close();
	}
}