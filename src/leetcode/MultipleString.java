package leetcode;

public class MultipleString {

	public String multiply(String num1, String num2) {
		// num1 | num2 =null
		// num1 =0
		// pre: valid number
		// pre: non-negative

		int n = num1.length();
		int m = num2.length();
		if (n == 0 || m == 0)
			return "0";
		// int [] ans=new int[n+m+1];
		// int temp[]=new int[m+1];
		// for (int i=n-1;i>=0;i--){
		// int plus=0;
		// int a=(num1.charAt(i)-'0');
		// for (int j=m-1;j>=0;j--){
		// temp[j+1]=plus+a*(num2.charAt(j)-'0');
		// plus=temp[j+1]/10;
		// temp[j+1]=temp[j+1]%10;
		// }
		// temp[0]=plus;
		// plus=0;
		// for (int j=m;j>=0;j--){
		// ans[i+1+j]=ans[i+1+j]+temp[j]+plus;
		// plus=ans[i+1+j]/10;
		// ans[i+1+j]=ans[i+1+j]%10;
		// }
		// int ii=i;
		// while(plus>0){
		// ans[ii]+=plus;
		// plus=ans[ii]/10;
		// ans[ii]=ans[ii]%10;
		// }
		// }
		// StringBuffer sb=new StringBuffer();
		// boolean ok=false;
		// for (int i=0;i<=n+m;i++){
		// if (!ok && ans[i]==0)continue;
		// ok=true;
		// sb.append((char)(ans[i]+'0'));
		// }
		// if (ok)
		// return sb.toString();
		// return "0";

		return dfs(num1, num2);
	}

	private String dfs(String a, String b) {
		int al = a.length();
		int bl = b.length();
		if (a.equals("0") || b.equals("0"))
			return "0";

		int n = Math.max(al, bl);
		int m = n >> 1;
		if (n < 10) {
			return Long.toString((long) Integer.parseInt(a)
					* (long) Integer.parseInt(b));
		}
		String a1 = al < m ? "0" : a.substring(0, al - m);
		String a0 = al < m ? a : a.substring(al - m, al);
		String b1 = bl < m ? "0" : b.substring(0, bl - m);
		String b0 = bl < m ? b : b.substring(bl - m, bl);

		String a10 = add(a1, a0);
		String b10 = add(b1, b0);
		String ab10 = multi(a10, b10);
		String ab11 = multi(a1, b1);
		String ab00 = multi(a0, b0);
		return add(ab11, ab10, ab00, m);
	}

	private String add(String a, String b) {
		int al = a.length();
		int bl = b.length();
		int[] f = new int[Math.max(al, bl) + 1];
		int plus = 0;
		int k = f.length - 1;
		al--;
		bl--;
		while (k >= 0) {
			f[k] = (al >= 0 ? a.charAt(al) : '0') - '0'
					+ (bl >= 0 ? b.charAt(al) : '0') - '0' + plus;
			plus = f[k] / 10;
			f[k] = f[k] % 10;
			al--;
			bl--;
			k--;
		}
		StringBuffer sb = new StringBuffer();
		boolean ok = false;
		for (int i = 0; i < f.length; i++) {
			if (!ok && f[i] == 0)
				continue;
			ok = true;
			sb.append((char) (f[i] + '0'));
		}
		if (!ok)
			return "0";
		return sb.toString();

	}

	private String multi() {

	}

}
