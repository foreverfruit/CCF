import java.util.Scanner;

/**
 * @ClassName    N20161202 
 * @Description  工资扣税逆问题, 如s=10000工资：  10000-3500 = 6500,t=3500 + 1500*0.97 + 3000*0.9 + 2000*0.8
 * 				 A = s - 3500;
 *               A<=1500       3%     
 *               1500<A<=4500  10%
 *               4500<A<=9000  20%
 *               9000<A<=35000 25%
 *               35000<A<=55000 30%
 *               55000<A<=80000 35%
 *               80000<A        45%
 *               S - W = T;已知T求S
 * @author       HeYuFeng 
				 foreverfruit@126.com
 * @date         2017年8月6日 下午10:15:23
 */
public class N20161202 {

	public static int a1 = 3500;
	public static int a2 = (int) (3500 + 0.97*1500);
	public static int a3 = (int) (3500 + 0.97*1500 + 0.9*3000);
	public static int a4 = (int) (3500 + 0.97*1500 + 0.9*3000 + 0.8*4500);
	public static int a5 = (int) (3500 + 0.97*1500 + 0.9*3000 + 0.8*4500 + 0.75*26000);
	public static int a6 = (int) (3500 + 0.97*1500 + 0.9*3000 + 0.8*4500 + 0.75*26000 + 0.7*20000);
	public static int a7 = (int) (3500 + 0.97*1500 + 0.9*3000 + 0.8*4500 + 0.75*26000 + 0.7*20000 + 0.65*25000);
	
	public static void main_N20161202(String [] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int s = 0;
		if(t<=3000) {
			s = t;
		}else if(t>a1 && t<=a2) { // a1 + (s-3500)*0.97 = t
			s = (int) ((t-a1)/0.97+ 3500);
		}else if(t>a2 && t<=a3) { // a2 + (s-5000)*0.9 = t
			s = (int) ((t-a2)/0.9 + 5000);
		}else if(t>a3 && t<=a4) { // a3 + (s-8000)*0.8 = t
			s = (int) ((t-a3)/0.8 + 8000);
		}else if(t>a4 && t<=a5) { // a4 + (s-12500)*0.75 = t
			s = (int) ((t-a4)/0.75+ 12500);
		}else if(t>a5 && t<=a6) { // a5 + (s-38500)*0.7 = t
			s = (int) ((t-a5)/0.7 + 38500);
		}else if(t>a6 && t<=a7) { // a6 + (s-58500)*0.65 = t
			s = (int) ((t-a6)/0.65+ 58500); 
		}else { // a7 + (s-83000)*0.55 = t
			s = (int) ((t-a7)/0.55+ 83500);
		}
		System.out.println(s);
		sc.close();
	}
}
