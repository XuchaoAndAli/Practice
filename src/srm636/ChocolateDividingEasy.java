package srm636;
// brute force
public class ChocolateDividingEasy {

	public int findBest(String[] chocolate){
		int n=chocolate.length;
		int m=chocolate[0].length();
		int[][] c=new int[n][m];
		c[0][0]=chocolate[0].charAt(0)-'0';
		for (int i=1;i<m;i++){
			c[0][i]=c[0][i-1]+chocolate[0].charAt(i)-'0';
		}
		for (int i=1;i<n;i++){
			c[i][0]=c[i-1][0]+chocolate[i].charAt(0)-'0';
		}
		
		for (int i=1;i<n;i++){
			for (int j=1;j<m;j++){
				c[i][j]=c[i-1][j]+c[i][j-1]-c[i-1][j-1]+chocolate[i].charAt(j)-'0';
			}
		}
		int ans=0;
		int t=0;
		int t1=0;
		int t2=0;
		for (int i1=0;i1<n-2;i1++){
			for (int i2=i1+1;i2<n-1;i2++){
				for (int j1=0;j1<m-2;j1++){
					t=Math.min(c[i1][j1],c[i2][j1]-c[i1][j1]);
					t=Math.min(t, c[n-1][j1]-c[i2][j1]);
					for (int j2=j1+1;j2<m-1;j2++){
						t1=Math.min(c[i1][j2]-c[i1][j1],c[i2][j2]+c[i1][j1]-c[i2][j1]-c[i1][j2]);
						t1=Math.min(t1, c[n-1][j2]+c[i2][j1]-c[n-1][j1]-c[i2][j2]);
						
						t2=Math.min(c[i1][m-1]-c[i1][j2],c[i2][m-1]+c[i1][j2]-c[i2][j2]-c[i1][m-1]);
						t2=Math.min(t2, c[n-1][m-1]+c[i2][j2]-c[n-1][j2]-c[i2][m-1]);
						
						t2=Math.min(Math.min(t2, t1),t);
						ans=Math.max(t, ans);
					}
				}
			}
		}
		return ans;
		
		
		
	}
}
