import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// input
		int n = sc.nextInt();
		int [][] matrix = new int [n+1][n+1];

		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				matrix[i][j] = sc.nextInt();
			}
		}

		// handle
		for(int sum=2;sum<=n*2;sum++){
			if(sum%2==0){
				// ou
				for(int row=sum-1;row>=1;row--){
					if(row<=n && (sum-row)<=n)
					 System.out.print(matrix[row][sum-row] + " ");
				}
			}else{
				// ji 
				for(int row=1;row<sum;row++){
					if(row<=n && (sum-row)<=n)
					 System.out.print(matrix[row][sum-row] + " ");
				}
			}
		}

		sc.close();
	}  
}