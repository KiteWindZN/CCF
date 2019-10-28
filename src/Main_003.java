import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_003 {
	
	public String hexXOR(String hex1, String hex2){
	    BigInteger i1 = new BigInteger(hex1, 16);
	    BigInteger i2 = new BigInteger(hex2, 16);
	    BigInteger res = i1.xor(i2);
	    return res.toString(16).toUpperCase();
	}
	
	public String solve(char[][] disk_strs,int n,int s,int l,int num){
		String res="";
		int disk_num=(num%(s*n))/s;
		int turn=num/((n-1)*s);
		
		int delta=num%s;
		int start_index=(turn)*s+delta;
		start_index*=8;
		if(disk_strs[disk_num][0]=='\u0000'){
			res="00000000";
			if((n-l)==1){
				for(int i=0;i<n;i++){
					if(i==disk_num)
						continue;
					
					String tmp=new String(disk_strs[i],start_index,8);
					res=hexXOR(res,tmp);
				}
			}else{
				res="-";
			}
		}else{
			res=new String(disk_strs[disk_num],start_index,8);;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_003 obj=new Main_003();
		Scanner scan=new Scanner(System.in);
		//BufferedReader scan=new BufferedReader(new InputStreamReader(System.in));
		int n=scan.nextInt();
		int s=scan.nextInt();
		int l=scan.nextInt();
		scan.nextLine();
		
		String line=scan.nextLine();
		String[] strs=line.split(" ");
		int index=Integer.parseInt(strs[0]);
		
		char[][] disk_strs=new char[n][strs[1].length()];
		disk_strs[index]=strs[1].toCharArray();
		for(int i=1;i<l;i++){
			line=scan.nextLine();
			strs=line.split(" ");
			index=Integer.parseInt(strs[0]);
			disk_strs[index]=strs[1].toCharArray();
		}
		int m=scan.nextInt();
		List<String> list_res=new ArrayList<String>();
		int max=(disk_strs[0].length/8) * (n-1);
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
/*
3 2 2
0 000102030405060710111213141516172021222324252627
1 A0A1A2A3A4A5A6A7B0B1B2B3B4B5B6B7C0C1C2C3C4C5C6C7
2
2
5

2 1 2
0 000102030405060710111213141516172021222324252627
1 000102030405060710111213141516172021222324252627
2
0
1
 */
