package SRM629;

import java.util.Arrays;
/**
 * div 1 No 1
 * easy one
 * @author Yihan
 *
 */
public class RectangleCovering {

	public int minimumNumber(int holeH, int holeW, int[] boardH, int[] boardW){
		int min=again(holeH,holeW,boardH,boardW);
		int min1=again(holeW,holeH,boardH,boardW);
		if (min==-1 && min1==-1)return -1;
		if (min==-1)return min1;
		if (min1==-1)return min;
		return Math.min(min, min1);
	}
	public int again(int holeH, int holeW, int[] boardH, int[] boardW){
		int n=boardH.length;
		Item1[] b=new Item1[n];
		for (int i=0;i<n;i++){
			
			if (boardH[i]>holeH){
				if (boardW[i]>holeH){
					if (boardH[i]<boardW[i]){
						
					}else{
						int t=boardH[i];
						boardH[i]=boardW[i];
						boardW[i]=t;
					}
					
				}else{
					
				}
				b[i]=new Item1(boardH[i], boardW[i]);
			}else{
				if (boardW[i]>holeH){
					int t=boardH[i];
					boardH[i]=boardW[i];
					boardW[i]=t;
					b[i]=new Item1(boardH[i], boardW[i]);
				}else{
					b[i]=new Item1(0, 0);
				}
			}
		}
		Arrays.sort(b);
		int d=0;
		int i=n-1;
		while(i>=0 && b[i].h>holeH && d<holeW){
			d+=b[i--].w;
		}
		int ans=-1;
		if (d>=holeW)ans=n-1-i;
		return ans;
		
		
		
	}
}
class Item1 implements Comparable<Item1>{
	int h;
	int w;
	public Item1(int hh, int ww) {
		h=hh;
		w=ww;
	}
	@Override
	public int compareTo(Item1 o) {
		if (w<o.w)return -1;
		if (w>o.w)return 1;
		return 0;
	}
	
}