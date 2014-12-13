package SRM626;

public class FixedDiceGameDiv1 {

	public double getExpectation(int a, int b, int c, int d){
		double[] f=cal(a,b);
		double[] g=cal(c,d);
		double p1=0;
		double p2=0;
		if (a*b<=c)return -1;
		for (int i=1;i<f.length;i++){
			for (int j=1;j<i && j<g.length;j++){
				p1+=f[i]*g[j]*i;
				p2+=f[i]*g[j];
			}
		}
		
		return p1/p2;
	}

	private double[] cal(int a, int b) {
		double[] ans=new double[a*b+1];
		ans[0]=1.0;
		for (int i=1;i<=b;i++){
			ans[i]=1.0/b;
		}
		for (int i=2;i<=a;i++){
			for (int j=i*b;j>=1;j--){
				ans[j]=0;
				for (int k=1;k<=b;k++){
					if (j>k)ans[j]+=ans[j-k];
				}
				ans[j]=ans[j]/b;
			}
		}
		return ans;
	}
	public static void main(String[] args){
		FixedDiceGameDiv1 p=new FixedDiceGameDiv1();
		p.getExpectation(1, 5, 1, 1);
	}
}
