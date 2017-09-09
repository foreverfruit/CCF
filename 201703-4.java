// TODO
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

class GNode{
	public int pointer;
	public int value;
	public GNode(int p,int v) {
		pointer = p;
		value = v;
	}
}

/**
 * 
 * @ClassName    N2017034 
 * @Description  第四题，交通图搜索问题。TODO 思路：构造一个图，然后做DFS，图的构造存储法，DFS非递归法。 
 * @author       HeYuFeng 
				 foreverfruit@126.com
 * @date         2017年8月2日 下午7:55:09
 */
public class N2017034 {

	@SuppressWarnings("unused")
	public static void main_N2017034(String[] args) {
		// load data
		Scanner sc = new Scanner(System.in);
		int pointer,edges;
		pointer = sc.nextInt();
		edges = sc.nextInt();
		
		// create graph double-direction
		Map<Integer,LinkedList<GNode>> graph = new HashMap<Integer,LinkedList<GNode>>();
		int p1,p2,value,count = 0;
		while( (count++) < edges ) {
			p1 = sc.nextInt();
			p2 = sc.nextInt();
			value = sc.nextInt();
			
			if(null == graph.get(p1)) {
				LinkedList<GNode> list = new LinkedList<GNode>();
				graph.put(p1, list);
			}
			if(null == graph.get(p2)) {
				LinkedList<GNode> list = new LinkedList<GNode>();
				graph.put(p2, list);
			}
			
			graph.get(p1).add(new GNode(p2,value));
			graph.get(p2).add(new GNode(p1,value));
		}
		
		// search path , deep first
		int cost = searchByDeep(graph);
		
		// print
		System.out.print(cost);
		
		sc.close();
	}

	// depth-first-search
	public static int searchByDeep(Map<Integer, LinkedList<GNode>> graph) {
		return 0;
	}

}
