package srm630;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
/**
 * shortest path problem
 * 
 * @author Yihan
 *
 */
public class Egalitarianism3 {
	
	int[][] w;
	boolean[] used;
	ArrayList<Integer>[] adj;
	public int maxCities(int n, int[] a, int[] b, int[] len){
		adj=new ArrayList[n+1];
		if (n<=2)return n;
		for (int i=1;i<=n;i++){
			adj[i]=new ArrayList<Integer>();
		}
		w=new int[n+1][n+1];
		for (int i=0;i<n-1;i++){
			adj[a[i]].add(b[i]);
			adj[b[i]].add(a[i]);
			w[a[i]][b[i]]=w[b[i]][a[i]]=len[i];
		}
		HashSet<Integer> hs;
		int mm=0;
		for (int i=1;i<=n;i++){
			
			HashMap<Integer,Integer> t=new HashMap<Integer,Integer>();
			for (int j=0;j<adj[i].size();j++){
				hs=new HashSet<Integer>();
				//hs[j].add(w[adj[i].get(j)][i]);
				used=new boolean[n+1];
				used[i]=true;
				dfs(adj[i].get(j),hs,w[adj[i].get(j)][i]);
				for (int key:hs){
					if (t.containsKey(key))t.put(key, t.get(key)+1);
					else t.put(key, 1);
				}
			}
			
			for (int key:t.keySet()){
				mm=Math.max(t.get(key), mm);
			}
		}
		return mm>2?mm:2;
		
		
	}

	private void dfs(Integer j, HashSet<Integer> hs,int we) {
		used[j]=true;
		hs.add(we);
		for (int next:adj[j]){
			if (!used[next]){
				dfs(next,hs,we+w[next][j]);
			}
		}
		
		
	}
	public static void main(String[] s){
//		int n=6;
//		int[] a={1,2,3,2,3};
//		int[] b={2,3,4,5,6};
//		int len[]={2,1,3,2,3};
		int n=10;
				int[] a={1,1,1,1,1,1,1,1,1};
		int[] b={2,3,4,5,6,7,8,9,10};
		int[] len={1000,1000,1000,1000,1000,1000,1000,1000,1000};
		Egalitarianism3 p=new Egalitarianism3();
		System.out.println(p.maxCities(n, a, b, len));
	}
}
