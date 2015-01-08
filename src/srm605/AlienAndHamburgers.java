package srm605;
/**
 * div 1 no 1
 * greedy
 */
import java.util.Arrays;

public class AlienAndHamburgers {

	public int getNumber(int[] type, int[] taste){
		int n=type.length;
		int[] t=new int[101];
		Arrays.fill(t, Integer.MIN_VALUE);
		for (int i=0;i<n;i++){
			if (t[type[i]]==Integer.MIN_VALUE)t[type[i]]=taste[i];
			else if (t[type[i]]<0 && taste[i]>t[type[i]])t[type[i]]=taste[i];
			else if (t[type[i]]>=0 && taste[i]>0)t[type[i]]+=taste[i];
		}
		int total=0;
		int k=0;
		for (int i=1;i<101;i++){
			if (t[i]>=0){total+=t[i];k++;}
		}
		Arrays.sort(t);
		for (int i=100;i>=0;i--){
			if (t[i]!=Integer.MIN_VALUE && t[i]<0){
				if ((total+t[i])*(k+1)>total*k){
					total+=t[i];
					k++;
				}else{
					break;
				}
			}
		}
		return total*k;
		
		
		
	}
}
