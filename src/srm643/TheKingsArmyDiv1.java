package srm643;


/**
 * dp
 * correctness provement is not easy
 * div 1 no 2
 * @author Yihan
 *
 */
public class TheKingsArmyDiv1 {

	public int getNumber(String[] state){
		int n=state[0].length();
		int[][] f1=new int[n][n];
		int[][] f2=new int[n][n];
		int[][]f=new int[n][n];
		int MAX=Integer.MAX_VALUE/2-10;
		for (int i=0;i<n;i++){
			if (state[0].charAt(i)=='H'){
				f1[i][i]=0;
			}else{
				f1[i][i]=MAX;
			}
			if (state[1].charAt(i)=='H'){
				f2[i][i]=0;
			}else{
				f2[i][i]=MAX;
			}
			if (f1[i][i]==0){
				if (f2[i][i]==0){
					f[i][i]=0;
				}else{
					f[i][i]=1;
				}
			}else{
				if (f2[i][i]==0){
					f[i][i]=1;
				}else{
					f[i][i]=MAX;
				}
			}
			
			
		}
		
		for (int g=1;g<n;g++){
			for (int i=0;i<n-g;i++){
				
				int j=i+g;
				
				f[i][j]=MAX;
				
				f1[i][j]=MAX;
				for (int k=i;k<j;k++){
					if (f1[i][k]==MAX || f1[k+1][j]==MAX){
						if (f1[i][k]!=MAX){
							f1[i][j]=Math.min(f1[i][j], f1[i][k]+(j-k));
						}
						if (f1[k+1][j]!=MAX){
							f1[i][j]=Math.min(f1[i][j], f1[k+1][j]+(k-i+1));
						}
					}else{
						f1[i][j]=Math.min(f1[i][j], f1[i][k]+f1[k+1][j]);
					}
				}
				f2[i][j]=MAX;
				for (int k=i;k<j;k++){
					if (f2[i][k]==MAX || f2[k+1][j]==MAX){
						if (f2[i][k]!=MAX){
							f2[i][j]=Math.min(f2[i][j], f2[i][k]+(j-k));
						}
						if (f2[k+1][j]!=MAX){
							f2[i][j]=Math.min(f2[i][j], f2[k+1][j]+(k-i+1));
						}
					}else{
						f2[i][j]=Math.min(f2[i][j], f2[i][k]+f2[k+1][j]);
					}
				}
				
				for (int k=i;k<j;k++){
					f[i][j]=Math.min(f[i][j], f[i][k]+f[k+1][j]);
					if (f[i][k]!=MAX){
						f[i][j]=Math.min(f[i][j], f[i][k]+j-k);
					}
					if (f[k+1][j]!=MAX){
						f[i][j]=Math.min(f[i][j], f[k+1][j]+k-i+1);
					}
					
				}
				
				
				f[i][j]=Math.min(f[i][j], f1[i][j]+1);
				f[i][j]=Math.min(f[i][j], f2[i][j]+1);
				f2[i][j]=Math.min(f2[i][j], f1[i][j]+1);
				f1[i][j]=Math.min(f1[i][j], f2[i][j]+1);
				
				
//				if (f1[i][j]!=MAX && f2[i][j]<f1[i][j]+1){
//					
//				}
//			System.out.println(i+" "+j);
//				System.out.println(state[0].substring(i,j+1)+"   "+f1[i][j]);
//				System.out.println(state[1].substring(i,j+1)+"   "+f2[i][j]);
//				System.out.println();
				
				
			}
		}
		if (f[0][n-1]==MAX){
			return -1;
		}
		return f[0][n-1];
	}
	
	public static void main(String[] args) {
		String[] s={"HHHSHSHSHSSSSSS", "HSSSSSHHSSHHHSS"};
		TheKingsArmyDiv1 p=new TheKingsArmyDiv1();
		p.getNumber(s);
	}
}
