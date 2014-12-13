package srm636;
/**
 * question 500
 * probability expectation
 * 
 * 
 * @author Yihan
 *
 */

public class ClosestRabbit {

	public double getExpected(String[] board, int r){
		int n=board.length*board[0].length();
		int[] x=new int[n];
		int[] y=new int[n];
		int k=0;
		for (int i=0;i<board.length;i++){
			for (int j=0;j<board[0].length();j++){
				if (board[i].charAt(j)=='.'){
					x[k]=i;
					y[k++]=j;
				}
			}
		}
		n=k;
		
		int[][] dis=new int[n][n];
		for (int i=0;i<n;i++)
			for (int j=0;j<n;j++){
				dis[i][j]=(x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]);
			}
		
		double [][] c=new double[n+1][n+1];
		for (int i=0;i<=n;i++){
			c[i][0]=1;
		}
		for (int i=1;i<=n;i++){
			for (int j=1;j<=i;j++){
				c[i][j]=c[i-1][j]+c[i-1][j-1];
			}
		}
		
		double ans=0;
		for (int i=0;i<n;i++){
			for (int j=i+1;j<n;j++){
				int num=0;
				for (k=0;k<n;k++){
					if (k==i || k==j){
						continue;
					}
					if (dis[i][k]<dis[i][j] || (dis[i][j]==dis[i][k] && x[k]<x[j]) || 
							(dis[i][j]==dis[i][k] && x[k]==x[j] && y[k]<y[j])){
						num++;
						continue;
					}
					if (dis[j][k]<dis[i][j] || (dis[i][j]==dis[j][k] && x[k]<x[i]) || 
							(dis[i][j]==dis[j][k] && x[k]==x[i] && y[k]<y[i])){
						num++;
						continue;
					}
					
				}
				
				ans+=c[n-2-num][r-2]/c[n][r];
			}
		}
		return ans;
		
	}
}
