/**
 * 这道题比较奇怪，LinkedList排序的时候，直接用linkedList.sort(new MyComparator)编译不通过
 *  用Collections.sort(list,new MyComparator)就可以...
 */
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

class MyComparator implements Comparator<Node>{
	public int compare(Node o1, Node o2) {
		return (o2.getOuterMaxPath() - o1.getOuterMaxPath());
	}
}

class Node{
	public int num;
	
	public LinkedList<Node> subNodes = new LinkedList<>();
	
	// 内部最大距离=该点到左子树的最大path + 右子树最大path
	private int innerMaxPath = 0; 
	// 外部最大距离=以该点作为根节点的子树的最大path = 子节点outerMaxPath+1
	private int outerMaxPath = 0; 
	
	public Node(int num){
		this.num = num;
	}
	
	public void add(Node ChildNode){
		subNodes.add(ChildNode);
	}
	
	/**
	 * 这是一个递归方法，所有数据添加完成之后，由根节点启动刷新，否则系统效率极低，产生大量重复计算
	 */
	public void refresh(){
		for(Node node:subNodes){
			node.refresh();
		}
		compute();
	}
	
	public void compute(){
		Collections.sort(subNodes,new MyComparator());
		
		// compute outerMaxPath
		if(!subNodes.isEmpty()){
			outerMaxPath = subNodes.getFirst().getOuterMaxPath() + 1;
		}
		
		// compute innerMaxPath
		if(subNodes.size()==1){
			innerMaxPath = subNodes.getFirst().getOuterMaxPath() + 1;
		}
		if(subNodes.size()>=2){
			innerMaxPath = subNodes.get(0).outerMaxPath + subNodes.get(1).outerMaxPath + 2;
		}
	}
	
	public int getInnerMaxPath(){
		return innerMaxPath;
	}
	public int getOuterMaxPath(){
		return outerMaxPath;
	}
	
	// 遍历以该节点为根节点的子树，找到所有节点中最大的innerMaxPath
	public int FindMaxInnerPath(){
		int max = 0;
		for(Node node:subNodes){
			int result = node.FindMaxInnerPath();
			if(max < result ){
				max = result;
			}
		}
		
		return innerMaxPath>max?innerMaxPath:max;
	}
}

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// input
		int switchCount = sc.nextInt();
		int pcCount = sc.nextInt();
		int nodeCount = switchCount + pcCount;
		
		Node [] nodes = new Node[nodeCount+1];
		Node root = new Node(1);
		nodes[0]=null;nodes[1] = root;
		
		for(int i=2;i<=nodeCount;i++){
			Node node = new Node(i);
			nodes[i] = node;
			// 表示node[i] 是 node[parent]的子节点
			int parent = sc.nextInt();
			nodes[parent].add(node);
		}
		
		root.refresh();
		
		// 遍历树，找到最大的innerMaxPath
		int max = root.FindMaxInnerPath();
		
		System.out.println(max);
		
		sc.close();
	}  
}