package srm641;

import java.util.LinkedList;
import java.util.Queue;
/**
 * div1 no2
 * @author Yihan
 *
 */
public class ShufflingCardsDiv1 {

	public int shuffle(int[] permutation){
		int n=permutation.length/2;
		for (int i=0;i<permutation.length;i++){
			if (permutation[i]!=i+1){
				break;
			}
			if (i==n*2-1){
				return 0;
			}
		}
		int count=0;
		for (int i=0;i<n+n;i+=2){
			if (permutation[i]<=n){
				count++;
			}
		}
		int[] f=new int[n+1];
		f[count]=1;
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(count);
		
		while(!q.isEmpty()){
			int c=q.remove();
			if (c==n)
				return f[n];
			if (c<=n/2){
				for (int i=0;i<=n/2+c;i++){
					if (f[i]==0){
						f[i]=f[c]+1;
						q.add(i);
					}
				}
			}else{
				for (int i=c-n/2;i<=n-c+(n+1)/2;i++){
					if (f[i]==0){
						f[i]=f[c]+1;
						q.add(i);
					}
				}
			}
			
		}
		return -1;
	}
}
