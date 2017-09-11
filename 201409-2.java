import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// input
		int rectCount = sc.nextInt();
		int [][] rects = new int [rectCount][4];

		for(int i=0;i<rectCount;i++){
			for(int j=0;j<4;j++){
				rects[i][j] = sc.nextInt();
			}
		}

		// handle
		int [][] matrix = new int [101][101];
		for(int i=0;i<rectCount;i++){
			int leftbottomX = rects[i][0];
			int leftbottomY = rects[i][1];
			int righttopX = rects[i][2];
			int righttopY = rects[i][3];
			// warning ! edge
			for(int k=leftbottomX+1;k<=righttopX;k++){
				for(int j=leftbottomY+1;j<=righttopY;j++){
					matrix[k][j] = 1;
				}
			}

		}

		int count = 0;
		for(int i=0;i<=100;i++){
			for(int j=0;j<=100;j++){
				if(matrix[i][j]==1)
					count++;
			}
		}

		System.out.println(count);

		sc.close();
	}  
}