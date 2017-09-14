import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

// order by item's price , small to big
class MyComparator implements Comparator<Item>{
	@Override
	public int compare(Item o1, Item o2) {
		return (int) (o1.price*100 - o2.price*100);
	}
}

enum Type{
	BUY,SELL,CANCEL
}

class Item{
	public Type type;
	public float price;
	public long amount;
	public boolean available;
	
	public Item(Type type,float price,long amount) {
		this.type = type;
		this.price = price;
		this.amount = amount;
		this.available = true;
	}
}

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// input
		LinkedList<Item> items = new LinkedList<>();
		while(sc.hasNext()){
			String str = sc.nextLine();
			String [] data = str.split(" ");
			Item item = null;
			if(data[0].equals("buy")) {
				item = new Item(Type.BUY, Float.parseFloat(data[1]), Long.parseLong(data[2]));
			}else if(data[0].equals("sell")){
				item = new Item(Type.SELL, Float.parseFloat(data[1]), Long.parseLong(data[2]));
			}else if(data[0].equals("cancel")) {
				item = new Item(Type.BUY, 0, 0);
				int cancelIndex = Integer.parseInt(data[1]);
				items.get(cancelIndex-1).available = false;
			}
			items.add(item);
		}
		
		Collections.sort(items,new MyComparator());
		
		float price = 0F;
		long amount = 0L;
		for(int i=0;i<items.size();i++) {
			Item item = items.get(i);
			float currentPrice = item.price;
			long currentAmount,amountSell=0,amountBuy=0;
			for(int j=i;j<items.size();j++) {
				Item x = items.get(j);
				if(x.available==true && x.type==Type.BUY) {
					amountBuy+=x.amount;
				}
			}
			for(int j=0;j<=i;j++) {
				Item x = items.get(j);
				if(x.available==true && x.type==Type.SELL) {
					amountSell+=x.amount;
				}
			}
			currentAmount = Math.min(amountSell, amountBuy);
			if(currentAmount>=amount) {
				amount = currentAmount;
				price = currentPrice;
			}
		}
		
		System.out.println(String.format("%.2f", price) + " " + amount);
		
		// handle
		sc.close();
	}
}
