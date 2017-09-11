// 90�֣����һ�����Ե������������Ʊû�п��ǣ������ݣ�
// 21
// 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4 4
// ���ۿ��У����Ǵ��������һ���˹���ʧ��
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int iCount = sc.nextInt();
		int [] instructions = new int[iCount];

		int [][] pos = new int[20][6];

		for(int i=0;i<iCount;i++){
			instructions[i] = sc.nextInt();
		}

		// kua hang distribution situation ignored
		for(int i=0;i<iCount;i++){
			
			int tickets = instructions[i];
			
			for(int j=0;j<20;j++){
				if(tickets<=5-pos[j][0]){
					for(int k=pos[j][0]+1;k<=pos[j][0]+tickets;k++){
						pos[j][k] = i+1;
					}
					pos[j][0] += tickets;
					break;
				}
			}
		}

		// output
		for(int i=0;i<iCount;i++){
			for(int j=0;j<20;j++){
				for(int k=1;k<6;k++){
					if((i+1)==pos[j][k]){
						System.out.print( (j*5+k) + " ");
					}
				}
			}
			System.out.println();
		}

		sc.close();
	}  
}