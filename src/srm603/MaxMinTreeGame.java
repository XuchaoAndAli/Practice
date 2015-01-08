package srm603;
/**
 * div 1 no 1
 * tricky problem.
 * no algorithm needed, but should know max is always in leaf.
 * @author Yihan
 *
 */
public class MaxMinTreeGame {

	public int findend(int[] edges, int[] costs){
		int n=edges.length+1;
		int[] d=new int[n];
		for(int i=0;i<n-1;i++){
			d[i+1]++;
			d[edges[i]]++;
		}
		int ans=Integer.MIN_VALUE;
		for (int i=0;i<n;i++){
			if (d[i]==1)ans=Math.max(ans,costs[i]);
		}
		return ans;
		
		
		
	}
}
