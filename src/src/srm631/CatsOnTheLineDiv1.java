package srm631;

import java.util.Arrays;
/**
 * div1 no2
 * sort then greedy
 * @author Yihan
 *
 */
public class CatsOnTheLineDiv1 {
	public int getNumber(int[] position, int[] count, int time){
		int n=position.length;
		Item1[] data=new Item1[n];
		for (int i=0;i<n;i++)data[i]=new Item1(position[i],count[i]);
		Arrays.sort(data);
		int pre=data[0].p-time;
		int i=0;
		int sum=0;
		boolean ok=false;
		while(i<n){
			if (pre<data[i].p-time){
				pre=data[i].p-time;
				ok=false;
			}
			if (ok){
				i++;
				continue;
			}
			
			if (data[i].c+pre<=data[i].p+time+1){
				pre=data[i].c+pre;
				i++;
			}else{
				pre=data[i].p+time;
				ok=true;
				sum++;
				i++;
			}
		}
		return sum;
	}
}
class Item1 implements Comparable<Item1>{

	int p;
	int c;
	public Item1(int a,int b) {
		p=a;
		c=b;
	}
	@Override
	public int compareTo(Item1 o) {
		if (p<o.p)return -1;
		if (p>o.p)return 1;
		return 0;
	}
	
}
