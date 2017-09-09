// 21:05 - 

import java.util.Scanner;
import java.util.Arrays;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();
		int [] arr = new int[size];

		for(int i=0;i<size;i++){
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int result=arr[0],maxcount=1,curcount=1;
		for(int i=1;i<size;i++){
			if(arr[i]!=arr[i-1]){
				if(curcount>maxcount){
					maxcount = curcount;
					result = arr[i-1];
				}
				curcount = 1;
			}else{
				curcount++;
			}
		}

		System.out.println(result);

		sc.close();
	}
}