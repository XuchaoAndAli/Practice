package srm644;
/**
 * div 1 no 1
 * dp
 * 
 */
import java.util.Arrays;

public class OkonomiyakiParty {

	public int count(int[] osize, int m, int l){
		int n=osize.length;
		Arrays.sort(osize);
		int MAX=1000000007;
		int c[][][] = new int[n][n][m+1];
		for (int i=0;i<n;i++){
			c[i][i][1]=1;
			c[i][i][0]=1;
		}
		for (int g=1;g<n;g++){
			for (int s=0;s<n;s++){
				int e=s+g;
				if (e>=n)break;
				if (osize[e]-osize[s]>l)continue;
				for (int k=2;k<=m;k++){
					for (int kk=s;kk<e;kk++){
						c[s][e][k]=(c[s][kk][k-1]+c[s][e][k])%MAX;
					}
					//System.out.println(s+" "+e+" "+c[s][e][k]);
					
				}
			}
		}
		
		int ans=0;
		for (int i=0;i<n;i++){
			for (int j=i+m-1;j<n;j++){
				ans=(ans+c[i][j][m])%MAX;
			}
		}
		return ans;
		
	}
	
	public static void main(String[] args) {
		OkonomiyakiParty p=new OkonomiyakiParty();
		int[] osize={1,4,6,7,9};
		int m=2;
		int l=3;
		p.count(osize, m, l);
	}
}
