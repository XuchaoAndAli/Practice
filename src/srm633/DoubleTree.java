
package srm633;

import java.util.ArrayList;

public class DoubleTree {

	ArrayList<Integer>[] ta;
	ArrayList<Integer>[] tb;
	int n;
	public int maximalScore(int[] a, int[] b, int[] c, int[] d, int[] score){
		n=a.length;
		 ta=new ArrayList[n+1];
		 tb=new ArrayList[n+1];
		for (int i=0;i<=n;i++){
			ta[i]=new ArrayList<Integer>();
			tb[i]=new ArrayList<Integer>();
		}
		for (int i=0;i<n;i++){
			ta[a[i]].add(b[i]);
			ta[b[i]].add(a[i]);
			tb[c[i]].add(d[i]);
			tb[d[i]].add(c[i]);
		}
		n++;
		dfs(0);

	}
	private void dfs(int cur){
		max=Math.max(max, run(cur))
	}
}
