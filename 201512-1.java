// 12:45 - 12:50
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();
		int result = 0;

		for(int i=0;i<str.length();i++){
			char a = str.charAt(i);
			result += a - '0';
		}
		System.out.println(result);

		sc.close();
	}
}