package srm639;

public class BoardFolding {

	public int howMany(int N, int M, String[] compressedPaper){
		int[][] paper=new int[N][M];
		for (int i=0 ; i<N; i++)
		    for (int j=0;j<M ;j++)
		        paper[i][j] = (tonumber(compressedPaper[i].charAt(j/6)) >> (j%6))%2;
		int s=0;
		
		for (int i=0;i<N;i++){
			for (int j=0;j<M;j++){
				System.out.print(paper[i][j]);
			}
			System.out.println("");
		}
		
		
		int[][] row=new int[N][N];
		rows(row,paper);
		int[][] col=new int[M][M];
		cols(col,paper);
		
		
		for (int i=0;i<N;i++){
			for (int j=0;j<N;j++){
				System.out.print(row[i][j]);
			}
			System.out.println("");
		}
		
		for (int i=0;i<M;i++){
			for (int j=0;j<M;j++){
				System.out.print(col[i][j]);
			}
			System.out.println("");
		}
		System.out.println(cal(M,col));
		return cal(M,col)*cal(N,row);
	}
	
	private void rows(int[][] row, int[][] paper) {
		int n=row.length;
		int m=paper[0].length;
		for (int i=0;i<n;i++)
			for (int j=0;j<n;j++){
				int k=0;
				for (k=0;k<m;k++){
					if (paper[i][k]!=paper[j][k]){
						break;
					}
				}
				if (k==m){
					row[i][j]=1;
				}
			}
	}
	
	private void cols(int[][] col, int[][] paper) {
		int n=paper.length;
		int m=paper[0].length;
		for (int i=0;i<m;i++)
			for (int j=0;j<m;j++){
				int k=0;
				for (k=0;k<n;k++){
					if (paper[k][i]!=paper[k][j]){
						break;
					}
				}
				if (k==n){
					col[i][j]=1;
				}
			}
	}

	private int cal(int M, int[][] cols){
		int[][] f=new int[M][M];
		for(int gap=0;gap<M;gap++){
			for(int i=0;i<M-gap;i++){
				int l=-1,r=M;
				int j=i+gap;
				for (l=i;;l++){
					if ((i+j+1)/2<=l){
						l=-1;
						break;
					}
					if (check(cols,i,l)){
						break;
					}
				}
				for (r=j;;r--){
					if ((i+j)/2>=r){
						r=M;
						break;
					}
					if (check(cols,r+r-j-1,r-1)){
						break;
					}
				}
				if (l!=-1){
					if (r!=M){
						f[i][j]=1+f[i][r-1]+f[l+1][j]-f[l+1][r-1];
					}else{
						f[i][j]=1+f[l+1][j];
					}
				}else{
					if (r!=M){
						f[i][j]=1+f[i][r-1];
						
					}else{
						f[i][j]=1;
					}
				}
			}
		}
		
		return f[0][M-1];
		
	}

	private boolean check(int[][] data, int i, int j) {
		for (int k=i;k<=j;k++){
			if (data[k][j+j+1-k]==0){
				return false;
			}
		}
		return true;
	}

	private int tonumber(char c) {
		if (c>='0' && c<='9')
			return c-'0';
		if (c>='a' && c<='z')
			return c-'a'+10;
		if (c>='A' && c<='Z')
			return c-'A'+36;
		if (c=='@')
			return 63;
		return 62;
	}
	
	public static void main(String[] args) {
		BoardFolding p=new BoardFolding();
		String[] c={"@@","@@"};
		p.howMany(2, 7, c);
	}
	
	
}
