package srm602;
/**
 * div 1 no 1
 * dp with a little trick
 * @author Yihan
 *
 */
public class TypoCoderDiv1 {

	public int getmax(int[] d, int x){
		int n=d.length;
		final int limit=2200;
		int[][][] f=new int[n][limit][2];
		
		for (int i=0;i<limit;i++){
			f[0][i][0]=f[0][i][1]=-1;
		}
		if (x+d[0]<limit)f[0][x+d[0]][0]=0;
		else f[0][x][1]=1;
		if (x-d[0]>=0)f[0][x-d[0]][0]=0;
		else f[0][0][0]=0;
		
		for (int i=1;i<n;i++){
			f[i][0][0]=-1;
			f[i][0][1]=-1;
			for (int j=0;j<limit;j++){
				if (d[i]>=j && f[i-1][j][0]!=-1 ){
					f[i][0][0]=Math.max(f[i][0][0], f[i-1][j][0]);
				}
				if (j+d[i-1]>=limit && j+d[i-1]<=d[i] && f[i-1][j][1]!=-1){
					f[i][0][0]=Math.max(f[i][0][0], f[i-1][j][1]+1);
				}
				if (d[i]>=limit && f[i-1][0][0]!=-1)f[i][0][1]=f[i-1][0][0]+1;
				
				
			}
			for (int j=1;j<limit;j++){
				f[i][j][0]=-1;
				f[i][j][1]=f[i][j][0];
				if (j-d[i]>=0 && f[i-1][j-d[i]][0]!=-1 )
					f[i][j][0]=Math.max(f[i][j][0],f[i-1][j-d[i]][0]);
				if (j+d[i]<limit && f[i-1][j+d[i]][0]!=-1)
					f[i][j][0]=Math.max(f[i][j][0],f[i-1][j+d[i]][0]);
				if (j+d[i]-d[i-1]>=0 && j+d[i]-d[i-1]<limit && j+d[i]>=limit &&
						f[i-1][j+d[i]-d[i-1]][1]!=-1)
					f[i][j][0]=Math.max(f[i][j][0],f[i-1][j+d[i]-d[i-1]][1]+1);
				if (j+d[i]>=limit && f[i-1][j][0]!=-1)
					f[i][j][1]=f[i-1][j][0]+1;
			}
		}
		int ans=0;
		for (int i=0;i<limit;i++){
			ans=Math.max(ans, f[n-1][i][0]);
			ans=Math.max(ans, f[n-1][i][1]);
		}
		return ans;
		
	}
}
