import java.util.Scanner;

public class N20160901 {

	public static void main(String [] argvs) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int curbo = Math.abs(y-x);
		x = y;
		for(int i=2;i<count;i++) {
			y = sc.nextInt();
			int bo = Math.abs(y-x);
			if(bo>curbo) {
				curbo = bo;
			}
			x = y;
		}
		System.out.println(curbo);
		sc.close();
	}
}
