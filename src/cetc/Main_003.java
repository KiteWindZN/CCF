package cetc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_003 {
	public int solve(int[][] map,int r,int c,int[][] label){
		int max=0;
		int N=map.length;
		int M=map[0].length;
		int[][] tmp_label=new int[N][M];
		List<Integer> list_value=new ArrayList<Integer>();
		List<Integer> list_row=new ArrayList<Integer>();
		List<Integer> list_column=new ArrayList<Integer>();
		
		list_value.add(map[r][c]);
		list_row.add(r);
		list_column.add(c);
		tmp_label[r][c]=1;
		tmp_label[r][c]=1;
		max++;
		while(list_value.size()>0){
			int i=list_row.get(0);
			int j=list_column.get(0);
			int value=list_value.get(0);
			list_row.remove(0);
			list_column.remove(0);
			list_value.remove(0);
			if(i>0){
				int tmp=map[i-1][j];
				if(tmp_label[i-1][j]==0 && (tmp^value)==1){
					list_value.add(tmp);
					list_row.add(i-1);
					list_column.add(j);
					tmp_label[i-1][j]=1;
					label[i-1][j]=1;
					max++;
				}
			}
			if(i<N-1){
				int tmp=map[i+1][j];
				if(tmp_label[i+1][j]==0 && (tmp^value)==1){
					list_value.add(tmp);
					list_row.add(i+1);
					list_column.add(j);
					tmp_label[i+1][j]=1;
					label[i+1][j]=1;
					max++;
				}
			}
			
			if(j>0){
				int tmp=map[i][j-1];
				if(tmp_label[i][j-1]==0 && (tmp^value)==1){
					list_value.add(tmp);
					list_row.add(i);
					list_column.add(j-1);
					tmp_label[i][j-1]=1;
					label[i][j-1]=1;
					max++;
				}
			}
			
			if(j<M-1){
				int tmp=map[i][j+1];
				if(tmp_label[i][j+1]==0 && (tmp^value)==1){
					list_value.add(tmp);
					list_row.add(i);
					list_column.add(j+1);
					tmp_label[i][j+1]=1;
					label[i][j+1]=1;
					max++;
				}
			}
		}
		
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_003 obj=new Main_003();
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int M=scan.nextInt();
		int[][] map=new int[N][M];
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				map[i][j]=scan.nextInt();
			}
		}
		
		int[][] label=new int[N][M];
		int max=0;
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(label[i][j]==1)
					continue;
				int tmp=obj.solve(map, i, j, label);
				if(max<tmp)
					max=tmp;
			}
		}
		System.out.println(max);
		scan.close();
	}

}
