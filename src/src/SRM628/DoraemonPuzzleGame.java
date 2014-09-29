package src.SRM628;
unsolved
/**
 * div1
 * No 3
 * dp with probability
 * hard
 */
public class DoraemonPuzzleGame {

	public double solve(int[] x, int[] y, int m){
		int n=x.length;
		double[][] f=new double[n+1][2*n+1];
		double[][] g=new double[n+1][2*n+1];
		f[0][0]=1;
		for (int i=1;i<=n;i++){
			for (int j=i;j<=i*2;j++){
				f[i][j]=f[i-1][j-1]*x[i-1]/(x[i-1]+y[i-1]);
				if (j>=2)f[i][j]+=f[i-1][j-2]*y[i-1]/(x[i-1]+y[i-1]);
				if (j>=2)g[i][j]=f[i-1][j-2]/(f[i-1][j-2]+f[i-1][j-1])*(g[i-1][j-2]+1000.0/(y[i-1]));
				if (j>=2)g[i][j]+=f[i-1][j-1]/(f[i-1][j-2]+f[i-1][j-1])*x[i-1]/(y[i-1]+x[i-1])*(g[i-1][j-1]+1000.0/(x[i-1]+y[i-1]));
				else g[i][j]+=x[i-1]/(y[i-1]+x[i-1])*(g[i-1][j-1]+1000.0/(x[i-1]+y[i-1]));
				
			}
		}
		double res=0;
		double s=0;
		for (int i=m;i<=2*n;i++)s+=f[n][i];
		for (int i=m;i<=2*n;i++)res+=f[n][i]/s*g[n][i];
		return res;
	}
	public static void main(String[] args){
		DoraemonPuzzleGame test=new DoraemonPuzzleGame();
		int[] x={250,250,250,250};
		int[] y={250,250,250,250};
		int m=5;
		System.out.println(test.solve(x, y, m));
		
	}
}
