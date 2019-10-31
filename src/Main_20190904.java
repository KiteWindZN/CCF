import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main_20190904 {

	public void add_good(List<Map<Integer,List<Integer>>> goods_list,int index,int id,int score){
		if(goods_list.get(index).containsKey(score)){
			goods_list.get(index).get(score).add(id);
		}else{
			List<Integer> tmp=new ArrayList<Integer>();
			tmp.add(id);
			goods_list.get(index).put(score, tmp);
		}
	}
	
	public void delete_good(List<Map<Integer,List<Integer>>> goods_list,int index,int id,int score){
		List<Integer> list=goods_list.get(index).get(score);
		for(int i=0;i<list.size();i++){
			if(list.get(i)==id){
				list.remove(i);
				if(list.size()==0){
					goods_list.remove(list);
					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Main_20190904 obj=new Main_20190904();
		int m,n;
		Scanner scan=new Scanner(System.in);
		List<Map<Integer,List<Integer>>> goods_list=new ArrayList<Map<Integer,List<Integer>>>();
		
		m=scan.nextInt();
		n=scan.nextInt();
		int[][] label=new int[m][1000000000];
		for(int i=0;i<m;i++){
			Map<Integer,List<Integer>> my_map=new TreeMap<Integer,List<Integer>>(
					new Comparator<Integer>() {
						public int compare(Integer id1,Integer id2){
							return id1.compareTo(id2);
						}
					});
			goods_list.add(my_map);
		}
		for(int i=0;i<n;i++){
			int id=scan.nextInt();
			int score=scan.nextInt();
			for(int j=0;j<m;j++){
				label[j][id]=score;
				obj.add_good(goods_list, j, id, score);
			}
		}
		int task_num=scan.nextInt();
		for(int i=0;i<task_num;i++){
			int type=scan.nextInt();
			switch(type){
			case 1:
				int num1=scan.nextInt();
				int num2=scan.nextInt();
				int num3=scan.nextInt();
				obj.add_good(goods_list, num1, num2, num3);
				
				label[num1][num2]=num3;
				break;
			case 2:
				int num4=scan.nextInt();
				int num5=scan.nextInt();
				int ss=label[num4][num5];
				obj.delete_good(goods_list, num4, num5, ss);
				break;
			case 3:
				break;
			}
		}

	}

}
