package SRM627;

import java.util.ArrayList;
import java.util.List;

public class GraphInversions {

	boolean[] v;
	int max;
	int size;
	int[] sa;
	int val=0;
	int[] V;
	int min=Integer.MAX_VALUE;
	List<Integer>[] adj;
	@SuppressWarnings("unchecked")
	public int getMinimumInversions(int[] A, int[] B, int[] V, int K){
		int n=A.length;
		this.V=V;
		max=K;
		if (K==1)return 0;
		v=new boolean[n];
		sa=new int[n];
		adj=new List[n];
		for (int i=0;i<n;i++){
			adj[i]=new ArrayList<Integer>();
		}
		for (int i=0;i<n;i++){
			adj[A[i]].add(B[i]);
			adj[B[i]].add(A[i]);
		}
		for (int i=0;i<n;i++){
			size=1;
			val=0;
			sa[0]=V[i];
			dfs(i);
			//System.out.println(min);
		}
		if (min==Integer.MAX_VALUE)return -1;
		return min;
	}
	private void dfs(int cur) {
		if (size==max){
			delete(V[cur]);
			return;
		}
		v[cur]=true;
		for (int next:adj[cur]){
			if (!v[next]){
				insert(V[next]);
				
				dfs(next);
				
			}
		}
		
		delete(V[cur]);
		v[cur]=false;
		
	}
	private void delete(int i) {
		for (int j=0;j<size;j++){
			if (sa[j]==i){
				while(j<size && sa[j]==i)j++;
				j--;
				for (int k=j;k<size-1;k++){
					sa[k]=sa[k+1];
				}
				val-=(size-1-j);
				--size;
				//System.out.println(size+ " " +val+" "+i);
				break;
			}
		}
		
	}
	private void insert(int i) {
		int j=size;
		while(j>0 && sa[j-1]>i){
			sa[j]=sa[j-1];
			--j;
		}
		sa[j]=i;
		val+=size-j;
		++size;
		
		
		//System.out.println(size+ " " +val+" "+i);
		if (size==max){
			min=Math.min(val, min);
		}
	}
	
	public static void main(String[] args){
		GraphInversions t=new GraphInversions();
		int[] A={0,1,2};
		int[] B={1,2,0};
		int[] V={4,5,6};
		int K=3;
		t.getMinimumInversions(A, B, V, K);
	}
	
	
}
