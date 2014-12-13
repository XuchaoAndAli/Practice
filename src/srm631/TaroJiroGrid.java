package srm631;
/**
 * div1 no1
 * find a feature of the problem, then know its 
 * only possible turn is 0,1,2
 * brute search
 * 
 * @author Yihan
 *
 */

public class TaroJiroGrid {

	int n;
	public int getNumber(String[] grid){
		n=grid.length;
		
		int[][] f=new int[n][n];
		for (int i=0;i<n;i++){
			for (int j=0;j<n;j++){
				f[i][j]=grid[i].charAt(j)=='W'?1:0;
			}
		}
		if (check(f))return 0;
		for (int i=0;i<n;i++){
			for (int j=0;j<n;j++){
				f[i][j]=1;
			}
			if (check(f))return 1;
			for (int j=0;j<n;j++){
				f[i][j]=0;
			}
			if (check(f))return 1;
			for (int j=0;j<n;j++){
				f[i][j]=grid[i].charAt(j)=='W'?1:0;
			}
		}
		
		if (n%2==0)return 2;
		for (int j=0;j<n;j++){
			f[n/2][j]=0;
		}
		
		for (int j=0;j<n;j++){
			f[n/2+1][j]=1;
		}
		if (check(f))return 2;
		for (int j=0;j<n;j++){
			f[n/2+1][j]=grid[n/2+1].charAt(j)=='W'?1:0;
		}
		
		for (int j=0;j<n;j++){
			f[n/2-1][j]=1;
		}
		if (check(f))return 2;
		for (int j=0;j<n;j++){
			f[n/2-1][j]=grid[n/2-1].charAt(j)=='W'?1:0;
		}
		


		for (int j=0;j<n;j++){
			f[n/2][j]=1;
		}
		
		for (int j=0;j<n;j++){
			f[n/2+1][j]=0;
		}
		if (check(f))return 2;
		for (int j=0;j<n;j++){
			f[n/2+1][j]=grid[n/2+1].charAt(j)=='W'?1:0;
		}
		
		for (int j=0;j<n;j++){
			f[n/2-1][j]=0;
		}
		if (check(f))return 2;
		return 3;
		
	}

	private boolean check(int[][] f) {
		for (int j=0;j<n;j++){
			int i=0;
			while(i<n){
				int pre=i;
				while(i<n-1 && f[i][j]==f[i+1][j]){
					i++;
				}
				if (i-pre+1>n/2)return false;
				i++;
			}
		}
		return true;
	}
	
	public static void main(String[] s){
		String[] t={"BWWWW","BWWWW","BWWWW","BWWWW","BWWWW"};
		TaroJiroGrid p=new TaroJiroGrid();
		System.out.println(p.getNumber(t));
	}
}
