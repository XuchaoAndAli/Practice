package SRM628;
/**
 * div1 No.1
 * brute force
 * @author Yihan
 *
 */
public class DivisorsPower {

	public long findArgument(long n){
		for (int div=50;div>=2;div--){
			double x=Math.pow(n, 1.0/div);
			long t=(int)x-1;
			boolean ok=false;
			
			while(pow(t,div)>n){
				t--;
				ok=true;
			}
			if (!ok){
				while(pow(t,div)<n){
					t++;
				}
			}
			if (pow(t,div)==n){
				
				if (check(t,div)){
					return t;
				}
			}
		}
		return -1;
	}

	private boolean check(long t, int div) {
		long tt=t;
		for (int i=2;i*i<=tt;i++){
			int tk=0;
			while(t%i==0){
				t=t/i;
				tk++;
			}
			if (div%(tk+1)==0){
				div/=tk+1;
			}else{
				return false;
			}
		}
		if (div==1 && t==1){
			return true;
		}else{
			if (div==2 && t>1){return true;}
			return false;
		}
	}

	private long pow(long t, int div) {
		long res=1;
		for (int i=0;i<div;i++){
			res*=t;
		}
		return res;
	}
	
	public static void main(String[] args){
		DivisorsPower p=new DivisorsPower();
		p.findArgument(10000);
	}
}
