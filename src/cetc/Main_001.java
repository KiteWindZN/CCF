package cetc;

import java.util.Scanner;

public class Main_001 {

	public int gdc(int a,int b){
		while(b!=0){
			int tmp=b;
			b=a%b;
			a=tmp;
		}
		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_001 obj=new Main_001();
		Scanner scan=new Scanner(System.in);
		int total=scan.nextInt();
		int[] nums=new int[total];
		for(int i=0;i<total;i++){
			nums[i]=scan.nextInt();
		}
		
		for(int i=0;i<total;i++){
			for(int j=i+1;j<total;j++){
				int tmp=0;
				if(nums[i]>nums[j])
					tmp=obj.gdc(nums[i], nums[j]);
				else tmp=obj.gdc(nums[j], nums[i]);	
				if(tmp!=1){
					System.out.println("N");
					return ;
				}
			}
		}
		System.out.println("Y");
		scan.close();
	}

}
