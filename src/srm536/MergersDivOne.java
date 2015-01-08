package srm536;

import java.util.Arrays;
/**
 * dp
 * @author Yihan
 *
 */
public class MergersDivOne {

	public double findMaximum(int[] revenues){
		Arrays.sort(revenues);
		int n=revenues.length;
		double[] max=new double[n];
		max[0]=revenues[0];
		for (int i=1;i<n;i++){
			max[i]=Integer.MIN_VALUE;
			double sum=0;
			for (int j=i-1;j>=0;j--){
				sum+=revenues[j+1];
				max[i]=Math.max(max[i], (sum+max[j])/(i-j+1));
			}
		}
		return max[n-1];
		
	}
}
