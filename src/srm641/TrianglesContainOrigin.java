package srm641;

import java.util.ArrayList;
/**
 * div1 no1
 * brute force
 * done
 * @author Yihan
 *
 */
public class TrianglesContainOrigin {

	public long count(int[] x, int[] y){
		ArrayList<Pair641> s1=new ArrayList<Pair641>();
		ArrayList<Pair641> s2=new ArrayList<Pair641>();
		ArrayList<Pair641> s3=new ArrayList<Pair641>();
		ArrayList<Pair641> s4=new ArrayList<Pair641>();
		int n=x.length;
		for (int i=0;i<n;i++){
			if (x[i]>=0){
				if (x[i]>0 && y[i]<0){
					s4.add(new Pair641(x[i], y[i]));
				}else if (y[i]>=0){
					s1.add(new Pair641(x[i], y[i]));
				}else{
					s3.add(new Pair641(x[i], y[i]));
				}
			}else{
				if (y[i]>0){
					s2.add(new Pair641(x[i], y[i]));
				}else{
					s3.add(new Pair641(x[i], y[i]));
				}
			}
		}
		
		long ans=0;
		ans+=count(s1,s3,s4,s2);
		ans+=count(s3,s1,s4,s2);
		ans+=count(s2,s4,s3,s1);
		ans+=count(s4,s2,s3,s1);
		return ans/2;
	}
	
	
	private long count(ArrayList<Pair641> s1, ArrayList<Pair641> s3,
			ArrayList<Pair641> s4, ArrayList<Pair641> s2) {
		long ans=0;
		long g1;
		long g2;
		for (int i=0;i<s1.size();i++){
			g1=g2=0;
			for (int j=0;j<s3.size();j++){
				if (intersect(s1.get(i),s3.get(j))>0){
					ans+=s4.size();
					g1++;
				}else{
					ans+=s2.size();
					g2++;
				}
			}
			ans+=g1*g2*2;
		}
		return ans;
	}


	private int intersect(Pair641 p1, Pair641 p2) {
		double ans=((double)p2.y-p1.y)/(p2.x-p1.x);
		ans=(double)p1.y-ans*p1.x;
		if (ans>0)return 1;
		return -1;
	}


	class Pair641{
		int x;
		int y;
		public Pair641(int xx,int yy) {
			// TODO Auto-generated constructor stub
			x=xx;
			y=yy;
		}
		
	}
}