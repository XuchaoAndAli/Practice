package srm633;

public class PeriodicJumping {

	public int minimalTime(int x, int[] jumps) {
		int n = jumps.length;
		x = Math.abs(x);
		int i = 0;
		int k = 0;
		if (x == 0)
			return 0;
		long sum = 0;
		for (i = 0; i < n; i++) {
			sum += (long) jumps[i];
		}
		i = 0;
		if (sum < x) {
			long o = ((long) x - sum) / sum;
			x -= (int) (o * sum);
			k += (int) o * n;
		}
		long mindis = (long) Math.abs(x);
		long maxdis = mindis;

		while (true) {
			if ((long) jumps[i] >= mindis && (long) jumps[i] <= maxdis) {
				return k + 1;
			} else {
				mindis = Math.min(Math.abs((long) jumps[i] - mindis),
						Math.abs((long) jumps[i] - maxdis));
				maxdis = maxdis + (long) jumps[i];
				k++;
			}
			i++;
			if (i == n) {
				i = 0;

			}
		}
	}
}