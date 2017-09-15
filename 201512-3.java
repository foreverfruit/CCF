// 未完成，没有找到合适的算法实现字符填充
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int width = sc.nextInt();
		int height = sc.nextInt();
		int operator = sc.nextInt();

		sc.nextLine(); // consume line delimiter

		char [][] panel =  new char[height][width];
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				panel[i][j] = '.';
			}
		}

		for(int i=0;i<operator;i++){
			String str = sc.nextLine();
			String [] data = str.split(" ");
			
			// draw line
			if(data[0].equals("0")){
				int x1 = Integer.parseInt(data[1]);
				int y1 = Integer.parseInt(data[2]);
				int x2 = Integer.parseInt(data[3]);
				int y2 = Integer.parseInt(data[4]);
				if(x1==x2){
					// vertical
					int yStart = y1<y2?y1:y2;
					int yEnd = y1==yStart?y2:y1;
					for(int j=yStart;j<=yEnd;j++){
						if(panel[j][x1]=='-'){
							panel[j][x1]='+';
						}else{
							panel[j][x1]='|';
						}
					}
				}
				if(y1==y2){
					// horizontal
					int xStart = x1<x2?x1:x2;
					int xEnd = x1==xStart?x2:x1;
					for(int j=xStart;j<=xEnd;j++){
						if(panel[y1][j]=='|'){
							panel[y1][j]='+';
						}else{
							panel[y1][j]='-';
						}
					}
				}
			}

			// filling
			if(data[0].equals("1")){
				int x1 = Integer.parseInt(data[1]);
				int y1 = Integer.parseInt(data[2]);
				char fillChar = data[3].charAt(0);
				for(int x=x1;x<width;x++){

				}
			}
		}
		
		// output
		for(int y=height-1;y>=0;y--) {
			for(int x=0;x<width;x++){
				System.out.print(panel[y][x]);
			}
			System.out.println();
		}

		// release
		sc.close();
	}
}

/*
16 13 9
0 3 1 12 1
0 12 1 12 3
0 12 3 6 3
0 6 3 6 9
0 6 9 12 9
0 12 9 12 11
0 12 11 3 11
0 3 11 3 1
1 4 2 C 
*/