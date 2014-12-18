package srm642;

public class WaitingForBus {

	public double whenWillBusArrive(int[] time, int[] prob, int s){
		int n=time.length;
		double f[][]=new double[s+1][n];
		double[] g=new double[s+1];
		g[0]=1;
		for (int i=0;i<=s;i++){
			for (int j=0;j<n;j++){
				//f[i][j]=f[i-time[k]][k]
				f[i][j]=g[i]*prob[j]/100;
				if (i+time[j]<=s)g[i+time[j]]+=f[i][j];
			}
		}
		double ans=0;
		for (int i=0;i<s;i++){
			for (int j=0;j<n;j++){
				if (i+time[j]>s){
					ans+=f[i][j]*(i+time[j]-s);
				}
			}
		}
		
		return ans;
	}
	
}
