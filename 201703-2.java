import java.util.Scanner;

public class N2017032 {

	public static void main_N2017032(String[] args) {
		// init data
		int n,m;
		DoubleLinkedList students = new DoubleLinkedList();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			students.append(i);
		}
		
		int value,step;
		while((m--)!=0) {
			value = sc.nextInt();
			step = sc.nextInt();
			students.move(value, step);
		}
		
		sc.close();
		students.print();
	}
}

class Node{
	public int value;
	public Node next;
	public Node previous;
	
	public Node(int value,Node last,Node next) {
		this.value = value;
		this.next = next;
		this.previous = last;
	}
}

/**
 * double-linkedlist with header and without tail-node
 * @author Administrator
 */
class DoubleLinkedList{
	
	public Node header; // linkedlist's length = header.value
	public Node tail;
	
	public DoubleLinkedList() {
		header = new Node(0,null,null);
		tail = header;
	}
	
	public void append(int value) {
		Node node = new Node(value,tail,null);
		tail.next = node;
		tail = node;
		header.value++;
	}
	
	public Node find(int value) {
		Node p = header.next;
		while(p!=null) {
			if(p.value == value) {
				break;
			}
			p = p.next;
		}
		return p;
	}
	
	public void move(int value,int step) {
		Node element = find(value);
		Node dest = null;
		boolean movetail = false; // the situation move to tail will be different
		
		// find Node dest, element will be move into the gap of dest and dest.next
		dest = element;
		int i = 0;
		if(step>0) {
			while(i<step) {
				dest = dest.next;
				i++;
			}
			if(dest == tail) {
				movetail = true;
			}
		}else if(step<0) {
			while(i>step) {
				dest = dest.previous;
				i--;
			}
			dest = dest.previous;
		}else {
			return;
		}
		
		// move:3 situation: move to tail;element==tail;other
		if(movetail) {
			element.next.previous = element.previous;
			element.previous.next = element.next;
			tail.next = element;
			element.previous = tail;
			element.next = null;
			tail = element;
		}else if(element==tail) {
			// delete element
			element.previous.next = null;
			tail = element.previous;
			// insert
			element.next = dest.next;
			element.previous = dest;
			dest.next.previous = element;
			dest.next = element;
		}else {
			// delete element
			element.next.previous = element.previous;
			element.previous.next = element.next;
			// insert
			element.next = dest.next;
			element.previous = dest;
			dest.next.previous = element;
			dest.next = element;
		}
	}
	
	public void print() {
		Node p = header.next;
		while(p!=null) {
			System.out.print(p.value);
			if(p!=tail) {
				System.out.print(" ");
			}
			p = p.next;
		}
	}
}
