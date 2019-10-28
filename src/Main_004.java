import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_004 {

	public boolean is_empty(List<List<String>> list) {
		for (List<String> l : list) {
			if (l.size() > 0)
				return false;
		}
		return true;
	}

	public boolean is_empty(int[] send,int[] receive){
		int len=send.length;
		for(int i=0;i<len;i++){
			if(send[i]!=-1 || receive[i]!=-1){
				return false;
			}
		}
		return true;
	}
	public int is_available(List<List<String>> list, int n) {
		int[] send = new int[n];
		int[] receive = new int[n];
		for (int j = 0; j < n; j++) {
			send[j] = -1;
			receive[j] = -1;
		}
		for (int j = 0; j < n; j++) {
			if (list.get(j).size() == 0)
				continue;
			String str = list.get(j).get(0);
			if (str.charAt(0) == 'S') {
				int tmp = Integer.parseInt(str.substring(1));
				send[j] = tmp;
			} else {
				int tmp = Integer.parseInt(str.substring(1));
				receive[j] = tmp;
			}
			list.get(j).remove(0);
		}
		while (!is_empty(send,receive)) {
			
			int flag = 0;
			for (int j = 0; j < n; j++) {
				if (send[j] != -1) {
					int tmp = send[j];
					if (receive[tmp] == j) {
						send[j] = -1;
						receive[tmp] = -1;
						flag = 1;
						if (list.get(j).size() > 0) {
							String str = list.get(j).get(0);
							if (str.charAt(0) == 'S') {
								int tmp_1 = Integer.parseInt(str.substring(1));
								send[j] = tmp_1;
							} else {
								int tmp_1 = Integer.parseInt(str.substring(1));
								receive[j] = tmp_1;
							}
							list.get(j).remove(0);
						}
						if (list.get(tmp).size() > 0) {
							String str = list.get(tmp).get(0);
							if (str.charAt(0) == 'S') {
								int tmp_1 = Integer.parseInt(str.substring(1));
								send[tmp] = tmp_1;
							} else {
								int tmp_1 = Integer.parseInt(str.substring(1));
								receive[tmp] = tmp_1;
							}
							list.get(tmp).remove(0);
						}
					}
				}
			}
			if (flag == 0) {
				return 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_004 obj=new Main_004();
		List<Integer> res_list=new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int n = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < T; i++) {
			List<List<String>> list = new ArrayList<List<String>>();
			for (int j = 0; j < n; j++) {
				list.add(new ArrayList<String>());
				String line = scan.nextLine();
				String[] strs = line.split(" ");
				for (int g = 0; g < strs.length; g++) {
					list.get(j).add(strs[g]);
				}
			}
			int res=obj.is_available(list, n);
			res_list.add(res);
		}
		
		for(int i=0;i<res_list.size();i++){
			System.out.println(res_list.get(i));
		}
		scan.close();
	}

}
