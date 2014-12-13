package srm632;
/**
 * binary number math
 * @author Yihan
 *
 */
public class PotentialArithmeticSequence {

	int[] f=new int[100];
	int[] ff=new int[100];
	public int numberOfSubsequences(int[] d){
		int n=d.length;
		int ans=0;
		for (int i=0;i<n;i++){
			for (int j=i+1;j<=n;j++){
				if (check(d,i,j))ans++;
				else
					break;
			}
		}
		return ans;
	}
	int [] temp=new int[50];
	private boolean check(int[] d, int i, int j) {
		for (int k=i;k<j;k++){
			temp[k-i]=d[k];
		}
		j=j-i;
		i=0;
		
		while(j>1){
			if (temp[0]==0){
				for (int k=0;k<j;k++){
					if ((k)%2==0){
						if (temp[k]!=0)return false;
					}else{
						temp[k/2]=temp[k]-1;
					}
				}
				j=j/2;
			}else{
				if (temp[1]==0){
					for (int k=0;k<j;k++){
						if ((k)%2==0){
							temp[k/2]=temp[k]-1;
						}else{
							if (temp[k]!=0)return false;
						}
					}
					j=(j+1)/2;
				}else{
					return false;
				}
			}
		}
		if (temp[0]>=0)
		return true;
		return false;
	}
	
	
}
