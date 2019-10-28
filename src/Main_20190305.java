import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_20190305 {

	static class node{
		int id;
		int label;
		List<Integer> nabor_list;
		public node(int id,int label){
			this.id=id;
			this.label=label;
			nabor_list=new ArrayList<Integer>();
		}
	}
	public int[][] solve(int[][] map,node[] nodes,List<Integer> list_index){
		int len=map.length;
		int[][] dis=new int[len][len];
		for(int i=0;i<len;i++){
			for(int j=0;j<=i;j++){
				if(i==j){
					dis[i][j]=0;
					continue;
				}
				dis[i][j]=-1;
				dis[j][i]=-1;
			}
		}
		
		for(int i=0;i<list_index.size();i++){
			int start=list_index.get(i);
			dijkstra(map,nodes,start,dis[start]);
		}
		
		return dis;
	}
	
	public void dijkstra(int[][] map,node[] nodes,int start,int[] dis){
		int len=map.length;
		int[] visited=new int[len];
		visited[start]=1;
		List<Integer> list=new ArrayList<Integer>();
		list.add(start);
		while(list.size()<len){
			int choose = -1;
			int cur=Integer.MAX_VALUE;
			int top=list.get(list.size()-1);
			List<Integer> tmp_list=nodes[top].nabor_list;
			for(int num : tmp_list){
				if(dis[num]==-1 || dis[top]+map[top][num] < dis[num]){
					dis[num]=dis[top]+map[top][num];
				}
				if(visited[num]==0 && cur>dis[num]){
					choose = num;
					cur=dis[num];
				}
			}
			if(choose==-1)
				break;
			list.add(choose);
			visited[choose]=1;
		}
	}
	
	public int[] resolve(int[][] dis,int[] list,List<Integer> list_index,int k){
		int len=dis.length;
		int[] res=new int[len];
		for(int i=0;i<len;i++){
			if(list_index.contains(i)){
				int min=Integer.MAX_VALUE;
				for(int ii: list_index){
					if(ii==i)
						continue;
					if(dis[i][ii]!=-1){
						if(dis[i][ii]<min){
							min=dis[i][ii];
						}
					}
				}
				if(min!=Integer.MAX_VALUE){
					res[i]+=min;
				}
			}else{
				int min1=Integer.MAX_VALUE;
				int min2=Integer.MAX_VALUE;
				
				for(int ii:list_index){
					if(dis[ii][i]!=-1 && dis[ii][i] <min2){
						if(min1>dis[ii][i]){
							min2=min1;
							min1=dis[ii][i];
						}else{
							min2=dis[ii][i];
						}
					}
				}
				
				if(min1!=Integer.MAX_VALUE){
					res[i]+=min1;
				}
				if(min2!=Integer.MAX_VALUE){
					res[i]+=min2;
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_20190305 obj=new Main_20190305();
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int m=scan.nextInt();
		int k=scan.nextInt();
		int[] list=new int[n];
		node[] nodes=new node[n];
		List<Integer> list_index=new ArrayList<Integer>();
		int[][] map=new int[n][n];
		for(int i=0;i<n;i++){
			int num=scan.nextInt();
			if(num!=0)
				list_index.add(i);
			list[i]=num;
			nodes[i]=new node(i,num);
		}
		for(int i=0;i<m;i++){
			int u=scan.nextInt();
			int v=scan.nextInt();
			int w=scan.nextInt();
			map[u-1][v-1]=w;
			map[v-1][u-1]=w;
			nodes[u-1].nabor_list.add(v-1);
			nodes[v-1].nabor_list.add(u-1);
			
		}
		
		int[][] dis=obj.solve(map,nodes,list_index);
		int[] res=obj.resolve(dis, list, list_index, k);
		for(int i=0;i<n;i++){
			System.out.println(res[i]);
		}
		scan.close();
	}

}
