import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int row = sc.nextInt();
		int column = sc.nextInt();

		int [][] arr = new int[row][column];

		for(int i=0;i<row;i++){
			for(int j=0;j<column;j++)
				arr[i][j] = sc.nextInt();
		}

		for(int i=column-1;i>=0;i--){
			for(int j=0;j<row;j++){
				System.out.print(arr[j][i] + " ");
			}
			System.out.println();
		}

		sc.close();
	}
}