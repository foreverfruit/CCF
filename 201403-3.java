import java.util.LinkedList;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// input
		String optionChars = sc.nextLine();
		int instructionCount = Integer.parseInt(sc.nextLine());
		String [] instructions = new String[instructionCount];
		for(int i=0;i<instructionCount;i++) {
			instructions[i] = sc.nextLine();
		}
		
		// handle
		for(int i=0;i<instructionCount;i++){
			String [] options = instructions[i].split(" ");
			String outStr = "Case " + (i+1) + ":";

			if(options.length==1){
				// have command only,without options
				System.out.println(outStr);
				continue;
			}

			// analysis options
			for(int j=1;j<options.length;j++){
				String str = options[j];

				if(!str.startsWith("-")){
					// isn't a options
					for(int k=j;k<options.length;k++){
						options[k] = "";
					}
					break;
				}

				boolean hasParameter = false;
				if( optionChars.contains(str.charAt(1) + ":") ){
					hasParameter = true;
				}else if( !optionChars.contains("" + str.charAt(1)) ){
					// have no this options
					for(int k=j;k<options.length;k++){
						options[k] = "";
					}
					break;
				}

				if(hasParameter){
					String parameter = options[j+1];
					
					boolean parameterError = false;
					for(int x=0;x<parameter.length();x++){
						char c = parameter.charAt(x);
						if( !( (c>='a' && c<='z') || (c>='0' && c<='9') || c=='-' ) ){
							// parameter error!
							parameterError = true;
							break;
						}
					}

					if(parameterError){
						for(int k=j;k<options.length;k++){
							options[k] = "";
						}
						break;
					}

					for(int k=1;k<j;k++){
						if(options[k].equals(str)){
							options[k+1] = parameter;
							options[j] = options[j+1] = "";
							break;
						}
					}
					j++;
				}else{
					for(int k=1;k<j;k++){
						if(options[k].equals(str)){
							options[j] = "";
							break;
						}
					}
				}
			}

			for(int j=1;j<options.length;j++){
				if(!options[j].equals("")){
					outStr += " " + options[j];
				}
			}

			System.out.println(outStr);
		}
		
		// release
		sc.close();
	}
}