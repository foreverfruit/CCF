import java.util.LinkedList;
import java.util.Scanner;

class Rect{
    public int height;
    
    public Rect(int height) {
    	this.height = height;
    }
    
    // higher or equal
    public boolean isHigherOrEqual(int height) {
    	return this.height>=height;
    }
}

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// input
		int matrixCount = sc.nextInt();
		LinkedList<Rect> rects = new LinkedList<>();
		for(int i=0;i<matrixCount;i++) {
			rects.add(new Rect(sc.nextInt()));
		}	
		
		// handle
		int maxArea = 0;
		int width = 1;
		for(int i=0;i<matrixCount;i++) {
			int height = rects.get(i).height;
			width = 1;
			
			// forward width
			for(int f=i+1;f<matrixCount;f++) {
				if(rects.get(f).isHigherOrEqual(height)) {
					width++;
				}else {
					break;
				}
			}
			
			// backward width
			for(int b=i-1;b>=0;b--) {
				if(rects.get(b).isHigherOrEqual(height)) {
					width++;
				}else {
					break;
				}
			}
			
			int curArea = height*width;
			if(curArea>maxArea) {
				maxArea = curArea;
				// Test
				// System.out.println("Num:" + (i+1) + ", Height:" + height + ",Area:" + maxArea);
			}
		}
		
		// output
		System.out.println(maxArea);
		
		// release
		sc.close();
	}
}