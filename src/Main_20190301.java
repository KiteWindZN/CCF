import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_20190301 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int[] nums = new int[T];
		for (int i = 0; i < T; i++) {
			nums[i] = scan.nextInt();
		}

		List<Integer> list = new ArrayList<Integer>();
		if (nums[0] > nums[T - 1]) {
			list.add(nums[0]);
			list.add(nums[T - 1]);
		} else {
			list.add(nums[T-1]);
			list.add(nums[0]);
		}
		float mid=0;
		if(T%2==1){
			list.add(1, nums[T/2]);
		}else{
			int num1=nums[T/2 -1];
			int num2=nums[T/2];
			int sum=num1+num2;
			if(sum%2==0)
				list.add(1,sum/2);
			else{
				mid=(float) (sum/2.0);

		        DecimalFormat df = new DecimalFormat("0.0");

		        String result = df.format(mid);
		        mid=Float.parseFloat(result);
			}
		}
		System.out.print(list.get(0));
		if(list.size()==3){
			for(int i=1;i<list.size();i++){
				System.out.print(" "+list.get(i));
			}
		}else{
			System.out.print(" "+mid);
			System.out.print(" "+list.get(1));
		}
		System.out.println();
		scan.close();
	}

}
