import java.util.Scanner;
import java.util.Stack;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int pathCount = sc.nextInt();
		sc.nextLine();
		
		// use for relative path
		String [] curPath = sc.nextLine().split("/");
		
		Stack<String> curStack = new Stack<>();
		for(String i:curPath) {
			if(i==null | i.equals("") ) {
				continue;
			}
			curStack.push(i);
		}
		
		// use for absolute path
		Stack<String> abStack = new Stack<>();
		
		for(int i=0;i<pathCount;i++) {
			String path = sc.nextLine();
			boolean isAbsolutePath = false;
			if(path.startsWith("/")) {
				isAbsolutePath = true;
			}
			
			for(String s:path.split("/")) {
				if(s==null | s.equals("") ) {
					continue;
				}
				if(isAbsolutePath) {
					if(s.equals("..")) {
						if(!abStack.isEmpty())
							abStack.pop();
					}else if(s.equals(".")) {
					}else {
						abStack.push(s);
					}
				}else {
					if(s.equals("..")) {
						if(!curStack.isEmpty())
							curStack.pop();
					}else if(s.equals(".")) {
					}else {
						curStack.push(s);
					}
				}
			}
			
			// output and recovery
			String result = "";
			if(isAbsolutePath) {
				while(!abStack.isEmpty()) {
					result = "/" + abStack.pop() + result;
				}
				if(!result.startsWith("/")) {
					result = "/" + result;
				}
				System.out.println(result);
			}else {
				while(!curStack.isEmpty()) {
					result = "/" + curStack.pop() + result;
				}
				if(!result.startsWith("/")) {
					result = "/" + result;
				}
				System.out.println(result);
				
				// recovery
				for(String j:curPath) {
					if(j==null | j.equals("") ) {
						continue;
					}
					curStack.push(j);
				}
			}
			
		}
		
		// release
		sc.close();
	}
}