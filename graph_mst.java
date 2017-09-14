import java.util.Scanner;
import java.util.Stack;

class Vertex{
	// 点编号
	public int num;
	// visited flag
	public boolean wasVisited;
	
	public Vertex(int num) {
		this.num = num;
		wasVisited = false;
	}
}

/**
 * 带权图
 */
class Graph{
	// 构成图的最大顶点数
	public int maxVerts;
	// 顶点集合
	private Vertex [] vertexList;
	// 图的邻接矩阵
	private int [][] adjMat;
	// 当前图的顶点数
	private int nVerts;
	
	private Stack<Integer> stack;
	
	public Graph(int maxVerts) {
		this.maxVerts = maxVerts;
		vertexList = new Vertex[maxVerts];
		adjMat = new int[maxVerts][maxVerts];
		stack = new Stack<>();
		nVerts = 0;
	}
	
	public void addVertex(int num) {
		vertexList[nVerts++] = new Vertex(num);
	}
	
	public void addEdge(int start,int end,int value) {
		adjMat[start][end] = value;
		adjMat[end][start] = value;
	}
	
	public void displayVertex(int v) {
		System.out.print(vertexList[v].num);
	}
	
	/**
	 * 带权图的搜索时，搜索的是权值最小的边上的邻近顶点,此处便于计算，权值都是大于0的整数
	 */
	public int getAdjUnvisitedVertex(int v) {
		for(int i=0;i<nVerts;i++) {
			int value = adjMat[v][i];
			if(value!=0 && vertexList[i].wasVisited==false) {
				return i;
			}
		}
		return -1;
	}
	
	// 无权图的最小生成树
	public int mst(int start) {
		int mstValue = 0;
		vertexList[start].wasVisited = true;
		stack.push(start);
		while(!stack.isEmpty()) {
			int currentVertex = stack.peek();
			// get next unvisited neighbor 
			int v = getAdjUnvisitedVertex(currentVertex);
			if(v == -1) {
				// no more neighbors
				stack.pop();
			}else {
				vertexList[v].wasVisited = true; // mark visited
				stack.push(v);	// push it 
				
				// display edge
				displayVertex(currentVertex); // from currentVertex
				displayVertex(v); 			  // to v
				System.out.print(" ");
			}
		}
		
		// reset flags
		for(int i=0;i<nVerts;i++) {
			vertexList[i].wasVisited = false;
		}
		
		return mstValue;
	}
}

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nVers = sc.nextInt();
		int nEdges = sc.nextInt();
		
		Graph graph = new Graph(nVers);
		for(int i=0;i<nVers;i++) {
			graph.addVertex(i+1);
		}
		for(int i=0;i<nEdges;i++) {
			int start = sc.nextInt()-1;
			int end = sc.nextInt()-1;
			int value = sc.nextInt();
			graph.addEdge(start, end, value);
		}
		
		System.out.println(graph.mst(1-1));
		
		sc.close();
	}
}

/*
	5 6
	1 2 10
	1 4 8
	2 3 3
	3 4 2
	3 5 5
	4 5 7 

*/