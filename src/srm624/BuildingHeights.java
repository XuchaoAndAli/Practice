package srm624;

import java.util.Arrays;
/**
 * div 1 no1
 * sort+bruteforce
 * @author Yihan
 *
 */
public class BuildingHeights {

	public int minimum(int[] heights){
		int ans=0;
		int n=heights.length;
		Arrays.sort(heights);
		int[] f=new int[n+1];
		for (int i=1;i<=n;i++){
			f[i]=f[i-1]+heights[i-1];
		}
		for (int i=1;i<=n;i++){
			int min=Integer.MAX_VALUE;
			for (int j=0;j<n-i+1;j++){
				min=Math.min(i*heights[j+i-1]-(f[j+i]-f[j]),min);
			}
			ans=ans^min;
		}
		return ans;
		
		
	}
}
