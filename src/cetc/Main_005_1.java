package cetc;

import java.util.Scanner;

public class Main_005_1 {

	public int cal_n(int n,int m,int p){
		int[][] c=new int[n+1][m+1];
		for(int i=0;i<=m;i++){
			c[0][i]=0;
			c[i][0]=1;
		}
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				c[i][j]=(c[i-1][j-1]+c[i-1][j])%p;
			}
		}
		return c[n][m];
	}
	
	
	public int jiecheng_n(int n,int p){
		if(n>=p)
			return 0;
		int res=1;
		for(int i=2;i<=n;i++){
			res=(res*i)%p;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_005_1 obj=new Main_005_1();
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int m=scan.nextInt();
		int s=scan.nextInt();
		int p=scan.nextInt();
		
		if(n==0||m==0||s==0){
			System.out.println(0);
			scan.close();
			return;
		}
		if(m>=p){
			System.out.println(0);
			scan.close();
			return ;
		}
		int res=obj.cal_n(n, s,p)%p;
		res=res*(obj.cal_n(m-1, s-1,p)%p)%p;
		res=res*obj.jiecheng_n(m,p)%p;
		System.out.println(res);
		scan.close();
	}

}
