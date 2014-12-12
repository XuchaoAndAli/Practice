package leetcode;

public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
        int n=s.length();
        char[] f=new char[n*2+1];
        for (int i=0;i<(n*2+1);i++){
            if (i%2==0)f[i]='~';
            else f[i]=s.charAt(i>>1);
        }
        
        n=n*2+1;
        int g[]=new int[n];
        g[0]=0;
        int cur=0;
        int i=0;
        int max=0;
        int mid=0;
        while(cur+i<n-1){
            if (i==0){
                cur=cur+1;
                int j=1;
                while(cur-j>=0 && cur+j<n && f[cur-j]==f[cur+j])j++;
                i=g[cur]=j-1;
                if (i>max){max=i;mid=cur;}
                System.out.println(0+" "+cur+" "+ i);
                continue;
            }
            for (int j=1;j<=i;j++){
                if (g[cur-j]+cur+j<g[cur]+cur){
                    g[cur+j]=g[cur-j];
                }else{
                    int t=g[cur]-j+1;
                    j=j+cur;
                    while(j+t<n && j-t>=0 && f[j+t]==f[j-t])t++; 
                    g[j]=t-1;
                    cur=j;
                    i=g[cur];
                    if (i>max){max=i;mid=cur;}
                    System.out.println(1+" "+cur+" "+ i);
                    break;
                }
            }
        }
        
        return s.substring((mid-max)/2,(mid+max)/2);

    }
	
	public static void main(String[] args) {
		LongestPalindromicSubstring p=new LongestPalindromicSubstring();
		p.longestPalindrome("ccd");
	}
}
