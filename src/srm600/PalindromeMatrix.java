package srm600;
unsolved
/**
 * div1 no2
 * @author Yihan
 *
 */
public class PalindromeMatrix {

	boolean[] rows;
	int n;
	int m;
	int rowCount;
	int columnCount;
	public int minChange(String[] a, int rowCount, int columnCount){
		n=a.length;
		this.rowCount=rowCount;
		this.columnCount=columnCount;
		m=a[0].length();
		rows=new boolean[n];
		n=n/2;
		m=m/2;
		go(0);
	}
	private void go(int choosed) {
		if (choosed==rowCount){
			run();
			return;
		}
		for (int i=0;i<n;i++){
			
		}
		
		
	}
}
