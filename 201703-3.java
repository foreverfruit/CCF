import java.util.Scanner;

enum Type{
	Paragraph,Title,List,None
}

/**
 * 
 * @ClassName    N2017033 
 * @Description  第三题，markdown解析问题：
 * 				 <p>分成两部分解决：1）解析块。2）解析行类修饰，强调和链接。
 *				 <p>注意：两点：1）结束标签的插入时机。2）StringBuffer在边遍历边修改过程中的坑，循环遍历变量i的值随长度变化要改变
 * 				 <p>得分：100
 * @author       HeYuFeng 
				 foreverfruit@126.com
 * @date         2017年8月2日 下午7:52:49
 */
public class N2017033 {

	public static void main_N2017033(String[] args) {
		// input data
		Scanner sc = new Scanner(System.in);
		String line = null;
		Type curType = Type.None; // current block type;
		String separator = System.getProperty("line.separator","\n");
		
		String result = "";
		boolean lastLineIsBlank = false;
		
		// handle block
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			if(line.startsWith("#")) {
				curType = Type.Title;
				int titleLevel = 0;
				int startIndex = 0;
				for(int i=0;i<line.length();i++) {
					char c = line.charAt(i);
					if(c=='#') {
						titleLevel++;
					}
					if(c!='#' && c!=' ') {
						startIndex = i;
						break;
					}
				}
				result += "<h"+ titleLevel + ">" + line.substring(startIndex) + "</h"+ titleLevel + ">" + separator;
				lastLineIsBlank = false;
			}else if(line.startsWith("*")) {
				if(curType != Type.List) {
					curType = Type.List;
					result += "<ul>" + separator;
				}
				int startIndex = 0;
				for(int i=0;i<line.length();i++) {
					char c = line.charAt(i);
					if(c!='*' && c!=' ') {
						startIndex = i;
						break;
					}
				}
				result += "<li>" + line.substring(startIndex) + "</li>" + separator;
				lastLineIsBlank = false;
			}else if(line.isEmpty()) {
				// blank line
				if(curType == Type.List) {
					result += "</ul>" + separator;
				}
				if(curType == Type.Paragraph) {
					result += "</p>" + separator;
				}
				curType = Type.None;
				lastLineIsBlank = true;
			}else {
				if(curType!=Type.Paragraph) {
					result += "<p>";
					curType = Type.Paragraph;
					result += line;
				}else {
					// mutil-line paragraphs handle
					result += separator + line;
				}
				
				lastLineIsBlank = false;
			}
		}
		
		// ERR!!! end of input is blank-line or not
		if(!lastLineIsBlank){
			if(curType == Type.List) {
				result += "</ul>" + separator;
			}
			if(curType == Type.Paragraph) {
				result += "</p>" + separator;
			}
			curType = Type.None;
		}
		
		// handle inside-line decorate
		result = nextParse(new StringBuilder(result));
		
		// output and release
		sc.close();
		System.out.print(result);
	}

	public static String nextParse(StringBuilder s) {
		String result = null;
		// count_表示下划线_的数量，以区分</em>尾标签位置。istart和iend表示‘[’和‘]’的index
		int count_ = 0,istart = 0,iend = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == '_') {
				count_ ++;
				if(count_ % 2 == 0) {
					s.replace(i, i+1, "&");
				}
			}else if(s.charAt(i) == '[') {
				istart = i;
			}else if(s.charAt(i) == ']'){
				iend = i;
			}else if(s.charAt(i) == ')') {
				String text = s.substring(istart+1, iend);
				String href = s.substring(iend+2,i);
				String replaceStr = "<a href=\""+href+"\">"+text+"</a>";
				s.replace(istart, i+1, replaceStr);
				
				// ERR!!! find the i value before replace
				i -= s.substring(istart, i+1).length() - replaceStr.length();
			}
		}
		result = s.toString().replace("_", "<em>").replace("&", "</em>");
		return result;
	}
}
