package srm604;

import java.util.ArrayList;

public class PowerOfThree {

	public String ableToGet(int x, int y){
		if (x==0 && y==0)return "Possible";
		ArrayList<Integer> x1=get(Math.abs(x));
		ArrayList<Integer> y1=get(Math.abs(y));
		if (x1==null || y1==null)return "Impossible";
		//ArrayList<Integer> ans=new ArrayList<Integer>();
		int i=x1.size()-1;
		int j=y1.size()-1;
		int k=0;
		boolean ok=false;
		while(i>=0 || j>=0){
			ok=false;
			if (i>=0 && x1.get(i)==k){
				i--;
				k++;
				ok=true;
			}
			if (j>=0 && y1.get(j)==k){
				j--;
				k++;
				ok=true;
			}
			if (!ok)return "Impossible";
		}
		return "Possible";
	}

	private ArrayList<Integer> get(int xx) {
		long x=xx;
		
		ArrayList<Integer> ans=new ArrayList<Integer>();
		if (x==0)return ans;
		int k=0;
		long t=1;
		long pre=0;
		long limit=1;
		while(limit<x){
			k++;
			t=t*3;
			pre=limit;
			limit=limit+t;
		}
		
		while(true){
			if (t>=x){
				x=t-x;
			}else{
				x=x-t;
			}
			limit=limit-t;
			t=t/3;
			pre=pre-t;
			k--;
			ans.add(k+1);
			if (x>limit)return null;
			if (x==0)return ans;
			while(x<=pre){
				limit=limit-t;
				t=t/3;
				pre=pre-t;
				k--;
			}
		}
		
	}
}
