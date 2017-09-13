import java.util.LinkedList;
import java.util.Scanner;

class Node{
	// number
	public int num;
	// value
	public int data;
	// parent node
	public Node parent;
	// children
	public LinkedList<Node> subNodes = new LinkedList<>();
	
	public Node(int num,int data) {
		this.num = num;
		this.data = data;
	}
	
	public void add(Node node) {
		subNodes.add(node);
		if(node!=null) {
			node.parent = this;
		}
	}

	// get longest path , current node as root
	public int maxPath() {
		int max = 0;
		for(Node node:subNodes) {
			int subMax = node.maxPath();
			if(subMax>max) {
				max = subMax;
			}
		}
		if(subNodes.size()>0) {
			max++;
		}
		return max;
	}
	
	// 后序遍历，先遍历子节点，再当前节点(左 - 右 - 父)
	public void traverse() {
		// traverse print child nodes
		for(Node node : subNodes) {
			node.traverse();
		}
		// print current node
		System.out.println(num + "-" + data);
	}
}

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int count = sc.nextInt();
		Node [] nodes = new Node[count+1];
		
		// 根节点，第一个节点的父节点num=0，故data值= sc.nextInt()+sc.nextInt()
		Node root = new Node(sc.nextInt(), sc.nextInt()+sc.nextInt());
		nodes[1] = root;
		nodes[0] = null;
		
		for(int i=2;i<=count;i++) {
			int num = sc.nextInt();
			int parent = sc.nextInt();
			int data = sc.nextInt();
			Node node = new Node(num, data);
			nodes[i] = node;
			nodes[parent].add(node);
		}
		
		root.traverse();
		System.out.println("maxPath:" + root.maxPath());
		
		sc.close();
	}  
}

// 测试数据
/*
16
1	0	1
2	1	3
3	1	5
4	2	10
5	2	8
6	3	10
7	3	12
8	5	72
9	5	80
10	7 	20
11	7 	30
12	10	31
13	12	50
14	13	16
15	13	17
16	7 	18 
*/