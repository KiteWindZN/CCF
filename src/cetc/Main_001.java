package cetc;
import java.util.HashMap;
import java.util.Map;
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
	
	public boolean is_sushu(int num){
	    if (num <= 3) {
	        return num > 1;
	    }
	    if (num % 6 != 1 && num % 6 != 5) {
	        return false;
	    }
		for(int i=2;i<=Math.sqrt(num);i++){
			if(num%i==0){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_001 obj=new Main_001();
		Scanner scan=new Scanner(System.in);
		int total=scan.nextInt();
		int[] nums=new int[total];
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<total;i++){
			nums[i]=scan.nextInt();
			if(obj.is_sushu(nums[i])){
				if(map.containsKey(nums[i])){
					map.put(nums[i], map.get(nums[i])-1);
				}else
					map.put(nums[i], -1);
			}
			else map.put(nums[i], 1);
		}
		
		for(int i=0;i<total;i++){
			if(map.get(nums[i])!=1){
				if(map.get(nums[i])<-1){
					System.out.println("N");
					return ;
				}
				continue;
			}
			
			for(int j=0;j<total;j++){
				if(j==i)
					continue;
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
