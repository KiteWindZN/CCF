package cetc;

import java.util.Scanner;

public class Main_004_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int a=scan.nextInt();
		int b=scan.nextInt();
		int[] nums=new int[N];
		int[][] weight=new int[N][N];
		for(int i=0;i<N;i++){
			nums[i]=scan.nextInt();
			weight[i][i]=nums[i];
		}
		for(int i=0;i<N;i++){
			for(int j=i+1;j<N;j++){
				weight[i][j]=weight[i][j-1]+nums[j];
			}
		}
		long[][] dp=new long[N][N];
		for(int i=2;i<=N;i++){//dis
			for(int j=0;j<=N-i;j++){//start
				int end=j+i-1;
				long min=Integer.MAX_VALUE;
				for(int k=j;k<end;k++){
					min=Math.min(min, dp[j][k]+dp[k+1][end]+weight[j][k]*a+weight[k+1][end]*b);
				}
				dp[j][end]=min;
			}
		}
		System.out.println(dp[0][N-1]);
		scan.close();
	}

}
