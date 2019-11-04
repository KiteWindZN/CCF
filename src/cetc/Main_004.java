package cetc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int a=scan.nextInt();
		int b=scan.nextInt();
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<N;i++){
			int tmp=scan.nextInt();
			if(tmp==0)
				continue;
			list.add(tmp);
		}
		N=list.size();
		if(N==0||N==1){
			System.out.println(0);
			return;
		}
		int[][] dp=new int[N][N+1];
		int[][] weight=new int[N][N+1];
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N+1;j++){
				dp[i][j]=Integer.MAX_VALUE;
			}
		}
		for(int i=N-1;i>=0;i--){
			dp[i][1]=list.get(i);
			weight[i][1]=list.get(i);
			for(int j=2;j<=N-i;j++){
				for(int h=1;h<j;h++){
					int tmp=weight[i][h]*a+weight[i+h][j-h]*b;
					if(h>1){
						tmp+=dp[i][h];
					}
					if(j-h>1){
						tmp+=dp[i+h][j-h];
					}
					dp[i][j]=Math.min(dp[i][j], tmp);
					weight[i][j]=weight[i][h]+weight[i+h][j-h];
				}
			}
		}
		System.out.println(dp[0][N]);
		scan.close();
	}

}
