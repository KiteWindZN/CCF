import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main_20190303 {

	public String hexXOR(String hex1, String hex2){
	    BigInteger i1 = new BigInteger(hex1, 16);
	    BigInteger i2 = new BigInteger(hex2, 16);
	    BigInteger res = i1.xor(i2);
	    return res.toString(16).toUpperCase();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_20190303 obj=new Main_20190303();
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int s=scan.nextInt();
		int l=scan.nextInt();
		scan.nextLine();
		
		String line=scan.nextLine();
		String[] strs=line.split(" ");
		int index=Integer.parseInt(strs[0]);
		String content=strs[1];
		String[][] disk_strs=new String[n][content.length()/8];
		int[][] label=new int[n][content.length()/8];
		for(int i=0;i<content.length()/8;i++){
			//System.out.println(i +" "+index+" "+(i*8)+" "+content.length());
			disk_strs[index][i]=content.substring(i*8,i*8+8);
		}
		for(int j=1;j<l;j++){
			line=scan.nextLine();
			strs=line.split(" ");
			index=Integer.parseInt(strs[0]);
			content=strs[1];
			for(int i=0;i<content.length()/8;i++){
				disk_strs[index][i]=content.substring(i*8,i*8+8);
			}
		}
		int s_num=content.length()/8/s;
		int p_num=n*(s_num/n+1)-1;
		int start=0;
		for(int i=0;i<s_num;i++){
			for(int j=0;j<n-1;j++){
				index=((p_num+1)%n+j)%n;
				for(int h=0;h<s;h++){
					label[index][i*s+h]=start++;
				}
			}
			for(int h=0;h<s;h++){
				label[p_num%n][i*s+h]=-1;
			}
			p_num--;
		}
		
		int m=scan.nextInt();
		
		int[] visited=new int[start];
		List<Integer> list_index=new ArrayList<Integer>();
		Map<Integer,String> map=new HashMap<Integer,String>();
		for(int i=0;i<m;i++){
			int num=scan.nextInt();
			list_index.add(num);
			if(num<start){
				visited[num]=1;
			}
		}
		
		for(int j=0;j<n;j++){
			for(int h=0;h<content.length()/8;h++){
				int num=label[j][h];
				if(num==-1)
					continue;
				if(visited[num]==1){
					if(disk_strs[j][h]!=null && disk_strs[j][h].length()>0){
						map.put(num, disk_strs[j][h]);
					}else{
						if((n-l)==1){
							String res="00000000";
							for(int g=0;g<n;g++){
								if(g==j)
									continue;
								res=obj.hexXOR(res, disk_strs[g][h]);
							}			
							map.put(num,res);
						}
					}
					
				}
			}
			
		}
		
		for(int i=0;i<list_index.size();i++){
			int num=list_index.get(i);
			if(num>start)
				System.out.println("-");
			else{
				System.out.println(map.get(num));
			}
		}
		scan.close();
	}
	
	

}
