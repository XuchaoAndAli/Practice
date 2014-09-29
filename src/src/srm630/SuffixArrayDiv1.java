package srm630;
/**
 * div1 No2
 * about string suffix array
 * actually a greedy algorithm
 * @author Yihan
 *
 */
public class SuffixArrayDiv1 {

	public int minimalCharacters(int[] a){
		int n=a.length;
		int[] r=new int [n+1];
		int[] sa=new int[n+1];
		for (int i=0;i<n;i++)sa[i]=a[i];
		sa[n]=n;
		for (int i=0;i<n;i++){
			r[sa[i]]=i;
		}
		r[n]=-1;
		int k=0;
		
		for (int i=0;i<n-1;i++){
			
			if (r[sa[i]+1]<r[sa[i+1]+1]){
				
			}else if(r[sa[i]+1]>r[sa[i+1]+1]){
				k++;
			}
		}
		return k+1;
	}
}
