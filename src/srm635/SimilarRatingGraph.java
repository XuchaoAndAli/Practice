package srm635;

import java.util.Arrays;

public class SimilarRatingGraph {

	public double maxLength(int[] date, int[] rating){
		int n=date.length;
		Pair635[] f=new Pair635[n*n];
		int j=0;
		int k=0;
		
		
		
		for (int i=0;i<n-1;i++){
			for (j=i+1;j<n;j++){
				double s=((double)rating[j]-rating[i])/(date[j]-date[i]);
				int jj=0;
				for (jj=0;jj<j;jj++){
					if (jj!=i){
						double ss=((double)rating[jj]-rating[i])/(date[jj]-date[i]);
						if (ss==s){
							break;
						}
					}
				}
				if (jj<j)continue;
				int start1=i;
				int start2=j;
				int end1=j;
				int end2=i;
				
				for (jj=j+1;jj<n;jj++){
					double ss=((double)rating[jj]-rating[i])/(date[jj]-date[i]);
					if (ss==s){
						end2=end1;
						end1=jj;
					}
				}
				
				f[k++]=new Pair635(s, start1, start2,end2, end1);
				
			}
				
		}
		Pair635[] g=Arrays.copyOf(f, k);
		Arrays.sort(g);
		double ans=0;
		for (int i=0;i<k;i++){
			if (i+1<k && g[i].a==g[i+1].a){
				double l=(rating[g[i].s1]-rating[g[i].t1])*(rating[g[i].s1]-rating[g[i].t1])+
						(date[g[i].s1]-date[g[i].t1])*
							(date[g[i].s1]-date[g[i].t1]);
				l=Math.sqrt(l);
				ans=Math.max(l, ans);
				l=(rating[g[i+1].s1]-rating[g[i+1].t1])*(rating[g[i+1].s1]-rating[g[i+1].t1])+
						(date[g[1+i].s1]-date[g[i+1].t1])*
							(date[g[i+1].s1]-date[g[i+1].t1]);
				l=Math.sqrt(l);
				ans=Math.max(l, ans);
			}else{
				double l=(rating[g[i].s2]-rating[g[i].t1])*(rating[g[i].s2]-rating[g[i].t1])+
						(date[g[i].s2]-date[g[i].t1])*
						(date[g[i].s2]-date[g[i].t1]);
				l=Math.sqrt(l);
			ans=Math.max(l, ans);
			l=(rating[g[i].s1]-rating[g[i].t2])*(rating[g[i].s1]-rating[g[i].t2])+
					(date[g[i].s1]-date[g[i].t2])*
						(date[g[i].s1]-date[g[i].t2]);
			l=Math.sqrt(l);
			ans=Math.max(l, ans);
			}
		}
		return ans;
	}
}

class Pair635 implements Comparable<Pair635>{
	double a;
	int s1;
	int t1;
	int s2;
	int t2;
	
	public Pair635(double aa, int s1,int s2,int t2, int t1) {
		a=aa;
		this.s1=s1;
		this.s2=s2;
		this.t2=t2;
		this.t1=t1;
	}
	@Override
	public int compareTo(Pair635 o) {
		if (a<o.a)return -1;
		if (a>o.a)return 1;
		return 0;
	}
	
}