package srm600;

import java.util.Arrays;
/**
 * div 1 no 1
 * @author Yihan
 *
 */
public class ORSolitaire {

	public int getMinimum(int[] numbers, int goal){
		Arrays.sort(numbers);
		int n=numbers.length;
		while(n!=0 && numbers[n-1]>goal)n--;
		int count[]=new int[32];
		
		
		for (int i=0;i<n;i++){
			for (int j=0;j<32;j++){
				if (((1<<j) & goal)==0 && ((1<<j) & numbers[i])>0){
					int tt=numbers[i];
					numbers[i]=numbers[n-1];
					numbers[n-1]=tt;
					n--;
					i--;
					break;
				}
			}
		}
		for (int i=0;i<n;i++){
			int t=goal & numbers[i];
			int k=1;
			for (int j=0;j<32;j++){
				if ((t & (k<<j))!=0 && (goal & (k<<j))!=0){
					count[j]++;
				}
			}
		}
		int ans=500;
		for (int i=0;i<32;i++){
			if ((goal & (1<<i))>0)
			ans=Math.min(ans, count[i]);
		}
		return ans;
		
		
	}
}
