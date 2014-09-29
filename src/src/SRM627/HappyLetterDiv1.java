package src.SRM627;

public class HappyLetterDiv1 {

	public String getHappyLetters(String letters){
		int n=letters.length();
		int[] f=new int[26];
		for (int i=0;i<n;i++){
			f[letters.charAt(i)-'a']++;
		}
		String res="";
		for (int i=0;i<26;i++){
			int max=0;
			int sum=0;
			for (int j=0;j<26;j++){
				if (j!=i){
					max=Math.max(f[j], max);
					sum+=f[j];
				}
			}
			sum-=max;
			int gap;
			if (max>=sum){
				gap=max-sum;
			}else{
				sum+=max;
				if (sum%2==0)gap=0;
				else gap=1;
			}
			if (f[i]>gap){
				res=res+(char)('a'+i);
			}
		}
		return res;
	}
}
