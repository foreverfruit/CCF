import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();
		int [] arr = new int[size];
		for(int i=0;i<size;i++){
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		
		int lastX = arr[0];
		int count = 1;
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=1;i<size;i++){
			if(arr[i]!=lastX){
				map.put(lastX,count);
				lastX = arr[i];
				count = 1;
			}else{
				count++;
			}

			if(i==size-1){
				map.put(lastX,count);
			}
		}

		ArrayList<Map.Entry<Integer,Integer>> resultList = new ArrayList<>(map.entrySet());
		Collections.sort(resultList,new Comparator<Map.Entry<Integer,Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				int i = o2.getValue()-o1.getValue();
				return i==0?(o1.getKey()-o2.getKey()):i;
			}
            
        });
		
		for(Map.Entry<Integer,Integer> en : resultList) {
			System.out.println(en.getKey() + " " + en.getValue());
		}
		
		sc.close();
	}
}