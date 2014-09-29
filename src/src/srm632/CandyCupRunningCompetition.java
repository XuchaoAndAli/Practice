package srm632;

/**
 * a special case for max flow in undirected graph.
 * use the specific feature of the edges' weight to simplify the problem
 * use union-find
 * @author Yihan
 *
 */
public class CandyCupRunningCompetition {

	
	public int findMaximum(int N, int[] A, int[] B){
	
		int M=A.length;
		if (M==0)return 0;
		int[] value=new int[M];
		parent=new int[N];
		for (int i=0;i<N;i++)parent[i]=i;
		value[0]=1;
		for (int i=1;i<M;i++){
			value[i]=(int)(((long)value[i-1]*3) % 1000000007);
		}
		int ans=0;
		for (int i=M-1;i>=0;i--){
			int ap=find(A[i]);
			int bp=find(B[i]);
			int p0=find(0);
			int pn=find(N-1);
			if ((ap==p0 && bp==pn) || (ap==pn && bp==p0)){
				ans=(ans+value[i]) % 1000000007;
			}else{
				link(ap,bp);
			}
		
		}
		
		
		return ans;
	}
	
	private void link(int a, int b){
		parent[a]=b;
	}
	
	int parent[];
	private int find(int cur){
		while(parent[cur]!=cur){
			cur=parent[cur];
		}
		return cur;
	}
	public static void main(String[] s){
		CandyCupRunningCompetition p=new CandyCupRunningCompetition();
		int N=6;
		int[] A={1,1,2,0,4,3,0,1,4};
		int[] B={3,2,3,1,5,5,2,4,3};
		System.out.println(p.findMaximum(N, A, B));
		
	}
	
}
