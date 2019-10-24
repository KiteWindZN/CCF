import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_03 {
	
	public String hexXOR(String hex1, String hex2){
	    BigInteger i1 = new BigInteger(hex1, 16);
	    BigInteger i2 = new BigInteger(hex2, 16);
	    BigInteger res = i1.xor(i2);
	    return res.toString(16).toUpperCase();
	}
	
	public String solve(String[] disk_strs,int n,int s,int l,int num){
		String res="";
		int disk_num=(num%(s*n))/s;
		int turn=num/((n-1)*s);
		
		int delta=num%s;
		int start_index=(turn)*s+delta;
		start_index*=8;
		if(disk_strs[disk_num]==null){
			res="00000000";
			if((n-l)==1){
				for(int i=0;i<n;i++){
					if(i==disk_num)
						continue;
					res=hexXOR(res,disk_strs[i].substring(start_index,start_index+8));
				}
			}else{
				res="-";
			}
		}else{
			res=disk_strs[disk_num].substring(start_index,start_index+8);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_03 obj=new Main_03();
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int s=scan.nextInt();
		int l=scan.nextInt();
		scan.nextLine();
		String[] disk_strs=new String[n];
		for(int i=0;i<l;i++){
			String line=scan.nextLine();
			String[] strs=line.split(" ");
			int index=Integer.parseInt(strs[0]);
			disk_strs[index]=strs[1];
		}
		int m=scan.nextInt();
		List<Integer> list=new ArrayList<Integer>();
		List<String> list_res=new ArrayList<String>();
		int max=(disk_strs[0].length()/8) * (n-1);
		for(int i=0;i<m;i++){
			int num=scan.nextInt();
			if(num>=max){
				list_res.add("-");
				continue;
			}
			String tmp=obj.solve(disk_strs, n, s,l,num);
			list_res.add(tmp);
		}
		for(int i=0;i<list_res.size();i++){
			System.out.println(list_res.get(i));
		}
		scan.close();
	}

}
