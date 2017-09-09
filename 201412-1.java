// 21:35 - 21:45
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();
		int [][] arr = new int[2][size];

		for(int i=0;i<size;i++){
			arr[0][i] = sc.nextInt();
		}

		boolean hasFind = false;
		for(int i=0;i<size;i++){
			for(int j=i-1;j>=0;j--){
				if(arr[0][i] == arr[0][j]){
					arr[1][i] = arr[1][j]+1;
					hasFind = true;
					break;
				}
			}

			if(!hasFind){
				arr[1][i] = 1;
			}
			hasFind = false;
		}
		
		for(int i=0;i<size;i++){
			if(i==size-1){
				System.out.println(arr[1][i]);
			}else{
				System.out.print(arr[1][i] + " ");
			}
		}

		sc.close();
	}
}