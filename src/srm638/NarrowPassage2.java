package srm638;

public class NarrowPassage2 {

	long MOD=1000000007;
	public int count(int[] size, int maxSizeSum){
		int n=size.length;
		return (int)dfs(size,maxSizeSum,0,n);
	}
	private long dfs(int[] size, int sum,int s, int e){
		if (e-s<=1)return 1;
		int max=0;
		int p=-1;
		for (int i=s;i<e;i++){
			if (size[i]>max){
				max=size[i];
				p=i;
			}
		}
		
		int lk=0;
		int rk=0;
		for (int i=s;i<p;i++){
			if (size[i]+size[p]>sum){
				lk++;
			}
		}
		for (int i=p+1;i<e;i++){
			if (size[i]+size[p]>sum){
				rk++;
			}
		}
		
		int[] size1=new int[lk];
		int[] size2=new int[rk];
		lk=0;
		rk=0;
		for (int i=s;i<e;i++){
			if (size[i]+size[p]>sum){
				if (i<p){
					size1[lk++]=size[i];
				}else if (i>p){
					size2[rk++]=size[i];
				}
			}
		}
		long left=dfs(size1,sum, 0,lk);
		long right=dfs(size2,sum,0,rk);
		
		long ans=1;
		ans=left*right%MOD;
		for (int i=lk+rk+2;i<=e-s;i++){
			ans=ans*i%MOD;
		}
		return ans;
	}
}
