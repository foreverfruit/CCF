import java.util.Scanner;

public class Main{

	public static boolean isRun(int year){
		return (year%400==0 || (year%4==0 && year%100!=0) );
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int [] ping = {0,31,59,90,120,151,181,212,243,273,304,334,365};
		int [] run = {0,31,60,91,121,152,182,213,244,274,305,335,366};

		// input 
		int year = sc.nextInt();
		int day = sc.nextInt();

		boolean isrun = isRun(year);

		int month = 1,dayindex;
		if(isrun){
			for(int i=2;i<=12;i++){
				if(day>run[i-1] && day<=run[i]){
					month=i;
					break;
				}
			}
			dayindex = day - run[month-1];
		}else{
			for(int i=2;i<=12;i++){
				if(day>ping[i-1] && day<=ping[i]){
					month=i;
					break;
				}
			}
			dayindex = day - ping[month-1];
		}

		System.out.println(month + "\n" + dayindex);

		sc.close();
	}
}