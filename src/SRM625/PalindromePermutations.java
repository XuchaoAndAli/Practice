package SRM625;
/**
 * div 1 No 1
 * pure math
 * probability problem
 * @author Yihan
 *
 */
public class PalindromePermutations {

	public double palindromeProbability(String word){
		int n=word.length();
		int[] f=new int[26];
		int[] g=new int[26];
		for (int i=0;i<n;i++){
			f[word.charAt(i)-'a']++;
		}
		double ans=0;
		boolean ok=false;
		int sum=0;
		for (int i=0;i<26;i++){
			if (f[i]%2==1){
				if (ok)return 0;
				ok=true;
				g[i]=f[i]/2;
				
			}else{
				g[i]=f[i]/2;
			}
			sum+=g[i];
		}
		double p=1;
		
		for (int i=0;i<26;i++){
			while(g[i]>0){
			p*=sum--;
			p/=g[i]--;
			}
			
			while(f[i]>0){
				p/=n--;
				p*=f[i]--;
			}
		}
		
		return p;
	}
}
