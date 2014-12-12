package srm638;

public class ShadowSculpture {

	int n;
	boolean[][][] used;
	boolean[][][] cube;
	char[][] xy;
	char[][] yz;
	char[][] zx;
	public String possible(String[] XY, String[] YZ, String[] ZX){
		n=XY.length;
		xy=new char[n][n];
		yz=new char[n][n];
		zx=new char[n][n];
		cube=new boolean[n][n][n];
		boolean ok=false;
		for (int i=0;i<n;i++)for (int j=0;j<n;j++)for (int k=0;k<n;k++){
			if (XY[i].charAt(j)=='Y' || YZ[j].charAt(k)=='Y' || ZX[k].charAt(i)=='Y'){
				ok=true;
			}
		}
		
		if (!ok)return "Possible";
		
		for (int x=0;x<n;x++){
			for (int y=0;y<n;y++){
				if (XY[x].charAt(y)=='N'){
					for (int z=0;z<n;z++){
						
						cube[x][y][z]=true;
					}
				}
			}
		}
		
		for (int y=0;y<n;y++){
			for (int z=0;z<n;z++){
				if (YZ[y].charAt(z)=='N'){
					for (int x=0;x<n;x++){
						cube[x][y][z]=true;
					}
				}
			}
		}
		for (int z=0;z<n;z++){
			for (int x=0;x<n;x++){
				if (ZX[z].charAt(x)=='N'){
					for (int y=0;y<n;y++){
						cube[x][y][z]=true;
					}
				}
			}
		}
		used=new boolean[n][n][n];
		int count=0;
		
		for (int x=0;x<n;x++){
			for (int y=0;y<n;y++){
				for (int z=0;z<n;z++){
					if (!used[x][y][z] && !cube[x][y][z]){
						
						dfs(x,y,z);
						if (check(XY,YZ,ZX))return "Possible";
						xy=new char[n][n];
						yz=new char[n][n];
						zx=new char[n][n];
					}
				}
			}
		}
		return "Impossible";
		
		
	}
	private boolean check(String[] xY2, String[] yZ2, String[] zX2) {
		int n=xy.length;
		for (int i=0;i<n;i++)for (int j=0;j<n;j++)for (int k=0;k<n;k++){
			if (xY2[i].charAt(j)=='Y' && xy[i][j]!='y')return false;
			if (yZ2[j].charAt(k)=='Y' && yz[j][k]!='y')return false;
			if (zX2[k].charAt(i)=='Y' && zx[k][i]!='y')return false;
		}
		return true;
	}
	private void dfs(int x, int y, int z) {
		if (x<0 || x>=n || y<0 || y>=n || z<0 || z>=n){
			return;
		}
		if (cube[x][y][z] || used[x][y][z]){
			return;
		}
		used[x][y][z]=true;
		xy[x][y]='y';
		yz[y][z]='y';
		zx[z][x]='y';
		dfs(x+1,y,z);
		dfs(x-1,y,z);
		dfs(x,y+1,z);
		dfs(x,y-1,z);
		dfs(x,y,z+1);
		dfs(x,y,z-1);
	}
}
