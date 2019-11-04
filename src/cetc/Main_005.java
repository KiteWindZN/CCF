package cetc;

import java.util.Scanner;

public class Main_005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int m=scan.nextInt();
		int s=scan.nextInt();
		int p=scan.nextInt();
		if(m==0){
			System.out.println(1);
			return;
		}
		if(n==0 || s==0){
			System.out.println(0);
			return;
		}
		int res=1;
		int tmp=m;
		while(tmp>0){
			res=res*s%p;
			tmp--;
		}
		tmp=1;
		int start=n;
		int num=1;
		if(s>(n/2))
			s=n-s;
		for(int i=0;i<s;i++){
			num=num*(n-i);
			tmp=tmp*(s-i);
			if(num%tmp==0){
				num=num/tmp;
				tmp=1;
			}
		}
		num=num/tmp;
		num=num%p;
		res=(res*num)%p;
		System.out.println(res);
		scan.close();
		
	}

}
