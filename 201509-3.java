// 70
import java.util.LinkedList;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String [] count = sc.nextLine().split(" ");
		int lineCount = Integer.parseInt(count[0]);
		int varCount = Integer.parseInt(count[1]);
		
		LinkedList<StringBuffer> lines = new LinkedList<>();
		for(int i=0;i<lineCount;i++) {
			lines.add(new StringBuffer(sc.nextLine()));
		}
		
		String [][] vars = new String[varCount][2];
		for(int i=0;i<varCount;i++) {
			String varInfo = sc.nextLine();
			vars[i][0] = varInfo.substring(0, varInfo.indexOf(" ")); // varName
			vars[i][1] = varInfo.substring(varInfo.indexOf("\"")+1,varInfo.lastIndexOf("\""));
		}
		
		// handle
		for(StringBuffer line:lines) {
			String l = line.toString();
			// replace correct var
			for(int i=0;i<vars.length;i++) {
				String varName ="{{ " + vars[i][0] + " }}";
				String varValue = vars[i][1];
				
				if(l.contains(varName)) {
					line.replace(0, line.length(), l.replace(varName, varValue));
				}
				
			}
			// ignore woring var
			l = line.toString();
			while(l.contains("{{") && l.contains("}}")) {
				line.replace(l.indexOf("{{"), l.indexOf("}}")+2, "");
				l = line.toString();
			}
		}
		
		// output
		for(StringBuffer line:lines) {
			System.out.println(line.toString());
		}
		
		// release
		sc.close();
	}
}

/*
11 2
<!DOCTYPE html>
<html>
<head>
<title>User {{ name }}</title>
</head>
<body>
<h1>{{ name }}</h1>
<p>Email: <a href="mailto:{{ email }}">{{ email }}</a></p>
<p>Address: {{ address }}</p>
</body>
</html>
name "David Beckham"
email "david@beckham.com"
*/