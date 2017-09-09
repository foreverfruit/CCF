import java.util.Arrays;
import java.util.Scanner;

public class N20161201 {

	public static void main_N20161201(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt();
		int [] arr = new int[count];
		for(int i=0;i<count;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int result=-1,x=0,y=0;
		int mid = arr[count/2];
		
		for(int i=count/2;i>=0;i--) {
			if(arr[i]==mid)
				x++;
			else
				break;
		}
		for(int i=count/2+1;i<count;i++) {
			if(arr[i]==mid)
				y++;
			else
				break;
		}
		
		if( (count-x-y)%2==0 )
			result = mid;
		
		System.out.println(result);
		sc.close();
	}
}
