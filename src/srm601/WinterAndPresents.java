package srm601;
/**
 * div1 no1
 * @author Yihan
 *
 */
public class WinterAndPresents {

	public long getNumber(int[] apple, int[] orange){
		int n=apple.length;
		int min=Integer.MAX_VALUE;
		for (int i=0;i<n;i++){
			min=Math.min(apple[i]+orange[i], min);
		}
		long ans=0;
		for (int i=0;i<=min;i++){
			int minA=0;
			int maxA=0;
			for (int j=0;j<n;j++){
				minA+=orange[j]>=i?0:i-orange[j];
				maxA+=apple[j]<=i?apple[j]:i;
			}
			ans+=maxA-minA+1;
		}
		return ans;
	}
}
