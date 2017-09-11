import java.util.Scanner;
import java.util.LinkedList;

class Rect{
	public int leftBottomX;
	public int leftBottomY;
	public int rightTopX;
	public int rightTopY;

	public Rect(int leftBottomX,int leftBottomY,int rightTopX,int rightTopY ){
		this.leftBottomX = leftBottomX;
		this.leftBottomY = leftBottomY;
		this.rightTopX = rightTopX;
		this.rightTopY = rightTopY;
	}

	public boolean containPonint(int x,int y){
		return (x>=leftBottomX && x<=rightTopX && y>=leftBottomY && y<=rightTopY);
	}
}

class Window{
	public Rect rect;
	public int number;

	public Window(int number,Rect rect){
		this.number = number;
		this.rect = rect;
	}

	public boolean clickInWindow(int x,int y){
		return rect.containPonint(x,y);
	}
}

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int windowCount = sc.nextInt();
		int clickCount = sc.nextInt();

		LinkedList<Window> windows = new LinkedList<>();
		for(int i=1;i<=windowCount;i++){
			windows.add(0,new Window(i,new Rect(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt())));
		}

		int [][] clickPoint = new int[clickCount][2];
		for(int i=0;i<clickCount;i++){
			clickPoint[i][0] = sc.nextInt();
			clickPoint[i][1] = sc.nextInt();
		}

		int clickedWindowNum = 0;
		for(int i=0;i<clickCount;i++){
			int x = clickPoint[i][0];
			int y = clickPoint[i][1];
			for(int j=0;j<windows.size();j++){
				Window w = windows.get(j);
				if(w.clickInWindow(x,y)){
					clickedWindowNum = w.number;
					w = windows.remove(j);
					windows.add(0,w);
					break;
				}
			}
			if(clickedWindowNum==0){
				System.out.println("IGNORED");
			}else{
				System.out.println(clickedWindowNum);
			}
			clickedWindowNum = 0;
		}

		sc.close();
	}
}