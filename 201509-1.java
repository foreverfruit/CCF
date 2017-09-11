// 13:10 - 13:20
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int [] array = new int[size];
		for(int i=0;i<size;i++){
			array[i] = sc.nextInt();
		}

		int result = 1;
		for(int i=1;i<size;i++){
			if(array[i]!=array[i-1]){
				result++;
			}
		}

		System.out.println(result);

		sc.close();
	}
}