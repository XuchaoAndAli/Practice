package srm637;

import java.util.Arrays;

public class GreaterGame {

	public double calc(int[] hand, int[] sothe){
		int n=hand.length;
		double ans=0;
		Arrays.sort(hand);
		Arrays.sort(sothe);
		int j=n-1;
		int k=n-1;
		int[] ok=new int[n+n+1];
		for (int i=n+n;i>=1;i--){
			
			if (j>=0 && hand[j]==i){
				j--;
				continue;
			}
			
			if (k>=0 && sothe[k]==i){
				k--;
				continue;
			}
			ok[i]=1;
		}
		k=n-1;
		
		for (int i=n-1;i>=0;i--){
			if (sothe[i]!=-1){
				k=n-1;
				while(k>=0 && hand[k]>sothe[i])k--;
				k++;
				if (k<n && hand[k]!=-1){
					hand[k]=-1;
					ans+=1;
					k--;
				}else{
					int o=0;
					while(hand[o]==-1)o++;
					hand[o]=-1;
					k--;
				}
				Arrays.sort(hand);
			}else{
				break;
			}
		}
		Arrays.sort(hand);
		
		for (int i=1;i<=n+n;i++){
			ok[i]+=ok[i-1];
		}
		for (int i=n-1;i>=0 && hand[i]!=-1;i--){
			ans+=(double)ok[hand[i]]/ok[n+n];
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		GreaterGame p=new GreaterGame();
		int[] hand={4,2};
		int[] sothe={-1,-1};
		p.calc(hand, sothe);
	}
}
