import java.util.LinkedList;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// input
		String options = sc.nextLine();
		int instructionCount = Integer.parseInt(sc.nextLine());
		LinkedList<String [] > instructions = new LinkedList<>();
		for(int i=0;i<instructionCount;i++) {
			instructions.add(sc.nextLine().split(" "));
		}
		
		// handle
		for(int i=0;i<instructionCount;i++) {
			String outStr = "Case "+(i+1)+":";
			String [] instruction = instructions.get(i);
			
			if(instruction.length<=1) { // without options
				System.out.println(outStr);
			}else {
			
				for(int index=1;index<instruction.length;index++) {
					String option = instruction[index];
					
					if(!option.startsWith("-")) {
						break;
					}
					
					boolean hasParameter = false;
					String test = "" + option.charAt(1) + ":";
					
					if(options.contains(test)) {
						hasParameter = true;
					}else if(options.contains("" + option.charAt(1))) {
						hasParameter = false;
					}else {
						break;
					}
					
					if(!hasParameter) {
						if(!outStr.contains(option)) {
							outStr += " " + option; 
						}
					}else {
						String parameter = instruction[++index];
						if(parameter.startsWith("-")) {
							// error!
							break;
						}else {
							if(!outStr.contains(option)) {
								outStr += " " + option + " " + parameter; 
							}else {
								String [] temp = outStr.split("-");
								for(int k=1;k<temp.length;k++) {
									if(temp[k].startsWith(option.charAt(1) + " ")) {
										temp[k] = option.charAt(1) + " " + parameter + " ";
									}
								}
								outStr = temp[0];
								for(int k=1;k<temp.length;k++) {
									outStr +="-" + temp[k];
								}
							}
						}
					}
					
				}
			    System.out.println(outStr);
			}
		}
		
		// release
		sc.close();
	}
}