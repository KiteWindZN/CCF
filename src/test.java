import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer, List<Integer>> my_map = new TreeMap<Integer, List<Integer>>(new Comparator<Integer>() {
			public int compare(Integer obj1, Integer obj2) {
				// 降序排序
				return obj2.compareTo(obj1);
			}
		});

		my_map.put(3, new ArrayList<Integer>());
		my_map.put(1, new ArrayList<Integer>());
		my_map.put(4, new ArrayList<Integer>());
		my_map.put(2, new ArrayList<Integer>());

		Set<Integer> keySet = my_map.keySet();
		Iterator<Integer> it = keySet.iterator();
		for (int i = 0; i < keySet.size(); i++) {
			System.out.print(keySet);
		}
		while (it.hasNext()) {
			System.out.print(it.next());
		}
		
		System.out.println();
		int key = 3;
		// System.out.print(key);
		List<Integer> tmp = my_map.get(key);
		tmp.add(5);
		tmp.add(3);
		tmp.add(31);
		
		Collections.sort(tmp);
		int[][] array = new int[3][3];

		Arrays.sort(array[0]);
		for (int i = 0; i < tmp.size(); i++) {
			System.out.println(tmp.get(i));
		}

		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		queue.add(4);
		queue.add(3);
		queue.add(12);
		queue.add(0);
		queue.add(1);
		System.out.println("aaaa "+queue.peek());
		queue.remove(3);
		int len=queue.size();
		
		Iterator<Integer> iit=queue.iterator();
		while(it.hasNext()){
			System.out.println("bbbb "+it.next());
		}
		for(int i=0;i<len;i++){
			System.out.println("cccc "+queue.poll());
		}
	}

}
