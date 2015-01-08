package srm643;

import java.util.ArrayList;
/**
 * bugy
 * div 1 no1
 * @author Yihan
 *
 */
public class TheKingsFactorization {

	public long[] getVector(long N, long[] primes){
		int m=primes.length;
		ArrayList<Long> ans=new ArrayList<Long>();
		long rest=N;
		double limit[]=new double[m-1];
		for (int i=0;i<m;i++){
			rest=rest/primes[i];
			
		}
		
		
		
		double max=rest;
		for (int i=0;i<m-1;i++)max=max/primes[i];
		if (max<primes[m-1])max=1;
		for (int i=0;i<m-1;i++){
			ans.add(primes[i]);
			
			limit[i]=rest;
			for (int j=i+1;j<m-1;j++){
				limit[i]=limit[i]/primes[j];
			}
			double min=rest;
			for (int j=i+2;j<m;j++){
				min=min/primes[j];
			}
			min=min/max;
			
			for (long j=Math.max(primes[i],(long)min);j<=Math.min(primes[i+1],(long)limit[i]);j++){
				if (rest%j==0){
					rest=rest/j;
					ans.add(j);
					break;
				}
				
			}
		}
		ans.add(primes[m-1]);
		if (rest!=1)ans.add(rest);
		long[] a=new long[ans.size()];
		for (int i=0;i<a.length;i++)a[i]=ans.get(i);
		return a;
		
		
	}
}
