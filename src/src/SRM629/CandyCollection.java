package SRM629;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * looks like a bigraph
 * actually a dp problem
 * @author Yihan
 *
 */
public class CandyCollection {

	
	public static void main(String[] s){
		CandyCollection p=new CandyCollection();
		int Type1[]={0,0,2,3};
		int[] Number1={1,1,2,2};
			int[]	Type2	={1,1,3,2};	
			int[]	Number2={1,1,2,2};
		p.solve(Type1, Number1, Type2, Number2);
	}
	 
	public int solve(int[] Type1, int[] Number1, int[] Type2, int[] Number2){
		int n=Type1.length;
		boolean used[]=new boolean[n];
		boolean re[]=new boolean[n];
		int[][] f=new int[n][3];
		for (int i=0;i<n;i++){
			f[Type1[i]][++f[Type1[i]][0]]=i;
			
			f[Type2[i]][++f[Type2[i]][0]]=i;
		}
		int res=0;
		for (int i=0;i<n;i++){
			ArrayList<Integer> temp= new ArrayList<Integer>();
			if (!used[i]){
				int a1,a2;
				a1=i;
				while(true){
					//System.out.println(a1);
					used[a1]=true;
					if (f[a1][1]!=-1){
						a2=f[a1][1];
						f[a1][1]=-1;
						System.out.println(a2);
					}else if (f[a1][2]!=-1){
						a2=f[a1][2];
						f[a1][2]=-1;
					}else{
						break;
					}
					if (Type1[a2]==a1){
						temp.add(Number1[a2]);
						temp.add(Number2[a2]);
						a1=Type2[a2];
						if (f[a1][1]==a2){
							f[a1][1]=-1;
						}else{
							f[a1][2]=-1;
						}
					}else{
						temp.add(Number2[a2]);
						temp.add(Number1[a2]);
						a1=Type1[a2];
						if (f[a1][1]==a2){
							f[a1][1]=-1;
						}else{
							f[a1][2]=-1;
						}
					}
				}
				res+=solve(temp);
			}
		}
		return res;
	}
	
	private int solve(ArrayList<Integer> nums){
		//System.out.println(nums);
		int n=nums.size()/2;
		int ans=0;
		int[][] f=new int[n][2];
		f[0][0]=nums.get(2*n-2)+1;
		f[0][1]=Integer.MAX_VALUE/2;
		for (int i=1;i<n-1;i++){
			f[i][0]=Math.min(f[i-1][0]+nums.get(i*2-2)+1,
					f[i-1][1]+Math.max(nums.get(i*2-2), nums.get(i*2-1))-nums.get(i*2-1));
			f[i][1]=Math.min(f[i-1][0], f[i-1][1])+nums.get(i*2+1)+1;
		}
		f[n-1][0]=Math.min(f[n-2][0]+nums.get(n*2-2-2)+1,
				f[n-2][1]+Math.max(nums.get(n*2-2-2), nums.get(n*2-3))-nums.get(n*2-3));
		f[n-1][1]=Math.max(nums.get(n*2-1), nums.get(n*2-2))-nums.get(n*2-2)+
				Math.min(f[n-2][1],f[n-2][0]);
		ans=Math.min(f[n-1][1], f[n-1][0]);
		
		int[][] g=new int[n][2];
		g[0][1]=nums.get(1)+1;
		g[0][0]=Integer.MAX_VALUE/2;
		for (int i=1;i<n;i++){
			g[i][0]=Math.min(g[i-1][0]+nums.get(i*2-2)+1,
					g[i-1][1]+Math.max(nums.get(i*2-2), nums.get(i*2-1))-nums.get(i*2-1));
			g[i][1]=Math.min(g[i-1][0], g[i-1][1])+nums.get(i*2+1)+1;
		}
		ans=Math.min(ans, Math.min(g[n-1][0],g[n-1][1]));
		return ans;
	}
}
