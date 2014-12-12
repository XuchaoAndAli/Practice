package srm639;

public class AliceGame {

	public long findMinimumValue(long x, long y){
		if (x==2 || y==2)
			return -1;
		long sum=x+y;
		long s=(long)Math.sqrt(sum);
		if (s*s!=sum)
			return -1;
		long ans=0;
		while(x>=s*2-1 && s>=1){
			x-=s*2-1;
			s--;
			ans+=1;
		}
		
		if (x==0)
			return ans;
		if (x%2==1){
			return ans+1;
			
		}else{
			return ans+2;
		}
	}
}
