import java.util.Scanner;

class MyString{
	public String str;
	
	public MyString(String str) {
		this.str = str;
	}
	
	public boolean match(boolean ignore,String matchStr) {
		if(ignore) {
			String s1 = this.str.toUpperCase();
			String s2 = matchStr.toUpperCase();
			return s1.contains(s2);
		}else {
			return this.str.contains(matchStr);
		}
	}
	
	public void print() {
		System.out.println(this.str);
	}
}

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// input
		String matchStr = sc.nextLine();
		boolean  ignore = Integer.parseInt(sc.nextLine()) == 0 ? true:false;
		int strCount = Integer.parseInt(sc.nextLine());
		MyString [] strings = new MyString[strCount];
		
		for(int i=0;i<strCount;i++) {
			strings[i] = new MyString(sc.nextLine());
		}
		
		for(int i=0;i<strCount;i++) {
			if(strings[i].match(ignore, matchStr)) {
				strings[i].print();
			}
		}
		
		// release
		sc.close();
	}
}