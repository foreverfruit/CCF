import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// input 
		int [][] plate = new int[16][11];
		for(int i=1;i<=15;i++){
			String str = sc.nextLine();
			for(int j=1;j<=10;j++){
				plate[i][j] = str.charAt((j-1)*2)-'0';
			}
		}

		int [][] block = new int[5][5];
		for(int i=1;i<=4;i++){
			String str = sc.nextLine();
			for(int j=1;j<=4;j++){
				block[i][j] = str.charAt((j-1)*2)-'0';
			}
		}

		int beginPlateColumn = sc.nextInt();

		// handle
		int maxBlockRow = 0;
		for(int i=4;i>=1;i--){
			for(int j=1;j<=4;j++){
				if(block[i][j]==1){
					maxBlockRow = i;
				}
			}
			if(maxBlockRow!=0){
				break;
			}
		}

		// 对比方案：将block块与plate中对应的列上，依次从最上面的行相加到最后一行，相加后有元素为2则失败（方块重叠），否则就是成功
		// 若成功，则进行下一次尝试，直到找到最后一次成功
		for(int row=1;row<=15-maxBlockRow+1;row++){
			// try add
			for(int adrow=row;adrow<=row+maxBlockRow-1;adrow++){
				for(int adcolumn=beginPlateColumn;adcolumn<=beginPlateColumn+3;adcolumn++){
					plate[adrow][adcolumn] = plate[adrow][adcolumn] + block[adrow-row+1][adcolumn-beginPlateColumn+1];
				}
			}

			// check
			boolean succ = true;
			for(int adrow=row;adrow<=row+maxBlockRow-1;adrow++){
				for(int adcolumn=beginPlateColumn;adcolumn<=beginPlateColumn+3;adcolumn++){
					if(plate[adrow][adcolumn]>1){
						succ = false;
					}
				}
			}

			// recovery
			for(int adrow=row;adrow<=row+maxBlockRow-1;adrow++){
				for(int adcolumn=beginPlateColumn;adcolumn<=beginPlateColumn+3;adcolumn++){
					plate[adrow][adcolumn] = plate[adrow][adcolumn] - block[adrow-row+1][adcolumn-beginPlateColumn+1];
				}
			}	
				
			// 退出条件2：这是最后一次尝试（方块到plate底部了），且尝试正确，结果取本次尝试
			if(row==15-maxBlockRow+1 && succ==true) {
				for(int adrow=row;adrow<=row+maxBlockRow-1;adrow++){
					for(int adcolumn=beginPlateColumn;adcolumn<=beginPlateColumn+3;adcolumn++){
						plate[adrow][adcolumn] = plate[adrow][adcolumn] + block[adrow-row+1][adcolumn-beginPlateColumn+1];
					}
				}
				break;			
			}

			// 退出条件1：本次尝试失败，结果取上次尝试（上次一定是正确的）
			if(succ==false){
				row--;
				for(int adrow=row;adrow<=row+maxBlockRow-1;adrow++){
					for(int adcolumn=beginPlateColumn;adcolumn<=beginPlateColumn+3;adcolumn++){
						plate[adrow][adcolumn] = plate[adrow][adcolumn] + block[adrow-row+1][adcolumn-beginPlateColumn+1];
					}
				}
				break;
			}
			
		}

		for(int i=1;i<=15;i++){
			for(int j=1;j<=10;j++){
				System.out.print(plate[i][j] + " ");
			}
			System.out.println();
		}

		sc.close();
	}
}