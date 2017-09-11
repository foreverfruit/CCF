// 12:30 - 12:45

import java.util.Scanner;

public class PointCount{

	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		int total = sc.nextInt();
		int [] data = new int[total];
		for(int i=0;i<total;i++){
			data[i] = sc.nextInt();
		}		

		// handle
		int count = 0;
		int lastgap = 0;
		int nextgap = 0;

		int i,j,k;
		i=0;j=i+1;k=j+1;
		for(;k<total;i++,j++,k++){
			lastgap = data[j] - data[i];
			nextgap = data[k] - data[j];
			if(lastgap*nextgap<0){
				count++;
			}
		}

		System.out.println(count);
		
		// release
		sc.close();
	}
}