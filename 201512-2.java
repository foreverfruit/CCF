// 70, 3 check-points fail
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// input 
		int row = sc.nextInt();
		int column = sc.nextInt();
		int [][] plate = new int[row+1][column+1];
		for(int i=1;i<=row;i++){
			for(int j=1;j<=column;j++){
				plate[i][j] = sc.nextInt();
			}
		}

		// handle row
		for(int i=1;i<=row;i++){
			int samecount = 1;
			for(int j=2;j<=column;j++){
				if(plate[i][j]==plate[i][j-1]){
					if(j==column && samecount>=2) {
						int value = -plate[i][j];
						for(int k=j;k>=j-samecount;k--){
							plate[i][k] = value;
						}
						samecount = 1;
					}else {
						samecount++;
					}
				}else{
					if(samecount>=3){
						int value = -plate[i][j-1];
						for(int k=j-1;k>=j-samecount;k--){
							plate[i][k] = value;
						}
					}
					samecount = 1;
				}
			}
		}

		// handle column
		for(int i=1;i<=column;i++){
			int samecount = 1;
			for(int j=2;j<=row;j++){
				if(plate[j][i]==plate[j-1][i] | plate[j][i]==-plate[j-1][i]){
					if(j==row && samecount>=2) {
						int value = -plate[j][i];
						for(int k=j;k>=j-samecount;k--){
							plate[k][i] = value;
						}
						samecount = 1;
					}else {
						samecount++;
					}
				}else{
					if(samecount>=3){
						int value = plate[j-1][i] < 0 ? plate[j-1][i] : -plate[j-1][i];
						for(int k=j-1;k>=j-samecount;k--){
							plate[k][i] = value;
						}
					}
					samecount = 1;
				}
			}
		}
		
		for(int i=1;i<=row;i++){
			for(int j=1;j<=column;j++){
				if(plate[i][j]<0)
					plate[i][j]=0;
			}
		}

		// output
		for(int i=1;i<=row;i++){
			for(int j=1;j<=column;j++){
				System.out.print(plate[i][j] + " ");
			}
			System.out.println();
		}

		sc.close();
	}
}