import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_20190302 {
	public boolean solve(String str){
		List<Integer> list_nums=new ArrayList<Integer>();
		List<Character> list_sign=new ArrayList<Character>();
		int res=0;
		int top=0;
		int num2=0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)>='1' && str.charAt(i)<='9'){
				list_nums.add(str.charAt(i)-'0');
			}else{
				switch(str.charAt(i)){
				case '+':
					list_sign.add('+');
					break;
				case '-':
					list_sign.add('-');
					break;
				case 'x':
					top=list_nums.get(list_nums.size()-1);
					list_nums.remove(list_nums.size()-1);
					num2=str.charAt(i+1)-'0';
					i++;
					list_nums.add(top*num2);
					break;
				case '/':
					top=list_nums.get(list_nums.size()-1);
					list_nums.remove(list_nums.size()-1);
					num2=str.charAt(i+1)-'0';
					i++;
					list_nums.add(top/num2);
					break;
				default:
					break;
				}
			}
		}
		res=list_nums.get(0);
		for(int i=1;i<list_nums.size();i++){
			int tmp=list_nums.get(i);
			char ch=list_sign.get(i-1);
			switch(ch){
			case '+':
				res+=tmp;
				break;
			case '-':
				res-=tmp;
				break;
			default:
				break;
			}
		}
		
		
		if(res==24)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		Main_20190302 obj=new Main_20190302();
		int T=scan.nextInt();
		scan.nextLine();
		List<String> list=new ArrayList<String>();
		for(int i=0;i<T;i++){
			String line=scan.nextLine();
			
			
			if(obj.solve(line))
				list.add("Yes");
			else
				list.add("No");
				
		}
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		scan.close();
	}

}


