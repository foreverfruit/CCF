import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String original = sc.nextLine();
		char [] chars = original.toCharArray();

		int sum=0,j=1;
		for(int i=0;i<chars.length-1;i++){
			if(chars[i]>='0' && chars[i]<='9'){
				sum += (chars[i]-'0')*j;
				j++;
			}
		}

		int mod = sum%11;
		if( (mod==10 && chars[chars.length-1]=='X') || (mod!=10 && mod==chars[chars.length-1]-'0')){
			System.out.println("Right");
		}else{
			if(mod==10){
				chars[chars.length-1] = 'X';
			}else{
				chars[chars.length-1] = (char)(mod+'0');
			}
			System.out.println(String.valueOf(chars));
		}

		sc.close();
	}
}