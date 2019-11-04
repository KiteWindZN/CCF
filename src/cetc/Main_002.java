package cetc;

import java.util.Scanner;

public class Main_002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int M=n*n;
		int[][] row=new int[1024][1025];
		int[][] cloumn=new int[1024][1025];
		int[][] rbd=new int[1024][1025];
		for(int i=0;i<M;i++){
			for(int j=0;j<M;j++){
				int num=scan.nextInt();
				row[i][num]++;
				if(row[i][num]>1){
					System.out.println("no");
					return;
				}
				
				cloumn[j][num]++;
				if(cloumn[j][num]>1){
					System.out.println("no");
					return;
				}
				
				int c=i/n*n+j/n;
				rbd[c][num]++;
				if(rbd[c][num]>1){
					System.out.println("no");
					return;
				}
			}
		}
		System.out.println("yes");
		scan.close();
	}

}
