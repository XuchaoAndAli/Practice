package srm606;

import java.util.Arrays;
/**
 * div 1 no 1
 * straight
 * special cases
 * check condition in loop and before return
 * @author Yihan
 *
 */
public class EllysNumberGuessing {

	public int getNumber(int[] guesses, int[] answers){
		int n=guesses.length;
		PQ[] pq=new PQ[n];
		for (int i=0;i<n;i++){
			pq[i]=new PQ(guesses[i],answers[i]);
		}
		Arrays.sort(pq);
		int max=1000000000;
		int pa=guesses[0]-answers[0]>0?guesses[0]-answers[0]:0;
		int pb=(long)guesses[0]+(long)answers[0]<=(long)max?guesses[0]+answers[0]:max+1;
		
		for (int i=1;i<n;i++){
			if (guesses[i]-answers[i]>0 && guesses[i]-answers[i]==pa){
				if (guesses[i]+answers[i]<=max && guesses[i]+answers[i]==pb){
					continue;
				}else{
					pb=max+1;
				}
			}else if(guesses[i]-answers[i]>0 && guesses[i]-answers[i]==pb){
				pa=0;
			}else if(guesses[i]+answers[i]<=max && guesses[i]+answers[i]==pb){
				pa=0;
			}else if(guesses[i]+answers[i]<=max && guesses[i]+answers[i]==pa) {
				pb=max+1;
			}else{
				return -2;
			}
			if (pa==0 && pb==max+1){
				return -2;
			}
		}
		if (pa==0 && pb==max+1){
			return -2;
		}
		if (pa==0){
			return pb;
		}
		if (pb==max+1){
			return pa;
			
		}
		return -1;
		
	}
	
	class PQ implements Comparable<PQ>{
		int g;
		int a;
		public PQ(int guesses, int answers) {
			g=guesses;
			a=answers;
		}
		@Override
		public int compareTo(PQ o) {
			if (g<o.g){
				return -1;
			}
			if (g>o.g){
				return 1;
			}
			return 0;
		}
	}
}
