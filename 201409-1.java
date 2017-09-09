// 21:25 - 21:35
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
				int d = arr[i]-arr[j];
				if(d==1 | d==-1){
					result++;
				}
			}
		}

		System.out.println(result/2);

		sc.close();
	}
}