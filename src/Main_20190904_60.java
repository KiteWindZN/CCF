
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main_20190904_60 {

	public void add_good(List<Map<Integer,List<Integer>>> goods_list,int index,int id,int score){
		if(goods_list.get(index).containsKey(score)){
			goods_list.get(index).get(score).add(id);
		}else{
			List<Integer> tmp=new ArrayList<Integer>();
			tmp.add(id);
			goods_list.get(index).put(score, tmp);
		}
	}
	
	public void delete_good(List<Map<Integer,List<Integer>>> goods_list,int index,int id){
		Map<Integer,List<Integer>> map=goods_list.get(index);
		for(Integer key:map.keySet()){
			List<Integer> list=map.get(key);
		for(int i=0;i<list.size();i++){
			if(list.get(i)==id){
				list.remove(i);
				if(list.size()==0){
					goods_list.remove(list);
					
				}
			}
		}
		}
	}
	
	public void delete_good_1(List<Map<Integer,List<Integer>>> goods_list,int index,int id,int score){
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
	
	public void solve(List<Map<Integer,List<Integer>>> goods_list,int total,int[] every,List<List<Integer>> res_list){
		int m=every.length;
		int[] score_list=new int[m];
		List<Iterator<Integer>> it_list=new ArrayList<Iterator<Integer>>();
		int flag=1;
		for(int i=0;i<m;i++){
			Iterator it=goods_list.get(i).keySet().iterator();
			it_list.add(it);
			score_list[i]=(int) it.next();
		}
		
		while(total>0&&flag==1){
			flag=0;
			int choose=-1;
			int max=0;
			for(int i=0;i<m;i++){
				if(max<score_list[i] && every[i]>0){
					max=score_list[i];
					choose=i;
					flag=1;
				}
			}
			if(flag==0){
				break;
			}
			
			int tmp_num=goods_list.get(choose).get(max).size();
			if(tmp_num<=every[choose]){
				if(tmp_num<=total){
					total-=tmp_num;
					every[choose]-=tmp_num;
					res_list.get(choose).addAll(goods_list.get(choose).get(max));
					if(it_list.get(choose).hasNext())
						score_list[choose] = it_list.get(choose).next();
					else 
						score_list[choose] = -1;
				}else{
					for(int i=0;i<total;i++){
						res_list.get(choose).add(goods_list.get(choose).get(max).get(i));
					}
					total=0;
				}
			}else{
				if(every[choose]>total){
					//total
					for(int i=0;i<total;i++){
						res_list.get(choose).add(goods_list.get(choose).get(max).get(i));
					}
					total=0;
				}else{
					//every[choose]
					for(int i=0;i<every[choose];i++){
						res_list.get(choose).add(goods_list.get(choose).get(max).get(i));
					}
					total-=every[choose];
					every[choose]=0;
				}
			}
		}
	}
	
	void my_sort(Map<Integer,List<Integer>> change_map,List<Map<Integer,List<Integer>>> goods_list){
		for(Integer key:change_map.keySet()){
			List<Integer> valueList=change_map.get(key);
			for(int value:valueList){
				Collections.sort(goods_list.get(key).get(value));
			}
		}
	}
	
	void print(List<List<Integer>> res_list){
		for(int i=0;i<res_list.size();i++){
			if(res_list.get(i).size()==0){
				System.out.println(-1);
				continue;
			}
			System.out.print(res_list.get(i).get(0));
			for(int j=1;j<res_list.get(i).size();j++){
				System.out.print(" "+res_list.get(i).get(j));
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Main_20190904_60 obj=new Main_20190904_60();
		int m,n;
		Scanner scan=new Scanner(System.in);
		List<Map<Integer,List<Integer>>> goods_list=new ArrayList<Map<Integer,List<Integer>>>();
		
		m=scan.nextInt();
		n=scan.nextInt();
		//int[][] label=new int[m][1000000000];
		List<Map<Integer,Integer>> label_map=new ArrayList<Map<Integer,Integer>>();
		for(int i=0;i<m;i++){
			Map<Integer,List<Integer>> my_map=new TreeMap<Integer,List<Integer>>(
					new Comparator<Integer>() {
						public int compare(Integer id1,Integer id2){
							return id2.compareTo(id1);
						}
					});
			goods_list.add(my_map);
			Map<Integer,Integer> tmp_map=new HashMap<Integer,Integer>();
			label_map.add(tmp_map);
			
		}
		for(int i=0;i<n;i++){
			int id=scan.nextInt();
			int score=scan.nextInt();
			for(int j=0;j<m;j++){
				//label[j][id]=score;
				label_map.get(j).put(id, score);
				obj.add_good(goods_list, j, id, score);
				Collections.sort(goods_list.get(j).get(score));
			}
		}
		
		int task_num=scan.nextInt();
		Map<Integer,List<Integer>> change_map=new HashMap<Integer,List<Integer>>();
		for(int i=0;i<task_num;i++){
			int type=scan.nextInt();
			switch(type){
			case 1:
				int num1=scan.nextInt();
				int num2=scan.nextInt();
				int num3=scan.nextInt();
				obj.add_good(goods_list, num1, num2, num3);
				//Collections.sort(goods_list.get(num1).get(num3));
				if(change_map.containsKey(num1)){
					change_map.get(num1).add(num3);
				}else{
					change_map.put(num1, new ArrayList<Integer>());
					change_map.get(num1).add(num3);
				}
				//label[num1][num2]=num3;
				label_map.get(num1).put(num2, num3);
				break;
			case 2:
				int num4=scan.nextInt();
				int num5=scan.nextInt();
				//int ss=label[num4][num5];
				int ss=label_map.get(num4).get(num5);
				obj.delete_good_1(goods_list, num4, num5,ss);
				//label[num4][num5]=0;
				label_map.get(num4).put(num5, -1);
				break;
			case 3:
				int total=scan.nextInt();
				int[] every=new int[m];
				List<List<Integer>> res_list=new ArrayList<List<Integer>>();
				for(int j=0;j<m;j++){
					every[j]=scan.nextInt();
					res_list.add(new ArrayList<Integer>());
				}
				obj.my_sort(change_map,goods_list);
				
				obj.solve(goods_list, total, every,res_list);
				obj.print(res_list);
				change_map.clear();
				break;
			}
		}

	}

}

