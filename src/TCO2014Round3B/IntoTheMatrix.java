package TCO2014Round3B;
/**
 * No.1
 * interesting strategy problem
 * about math thinking
 * @author Yihan
 *
 */

/*
 * Problem Statement
����
You have N bags of pills. Each bag contains a potentially infinite supply of pills. Each bag has a different label, so you can tell them apart. All pills inside all bags look exactly the same. Within each bag, all pills have the same effect. N-1 of the bags contain placebo pills (i.e., pills that have no effect). The last bag contains magic pills. If you take a magic pill, it will take you away from this world and into the Matrix. This is a one-way process: once somebody gets transported to the Matrix, they stay there forever. You have no idea which of the N bags is the one with the magic pills. In order to find it out, you decided to invite some friends and feed them some pills. The experiment will be divided into turns. In each turn, you give some pills to each of your friends who are still present. You can assign the pills to friends arbitrarily. For example, some friends may get zero pills while another friend gets pills from multiple bags. Also, multiple friends may get pills from the same bag in each turn. Once you distributed the pills among the friends, each of them eats all the pills they received. The friends who ate a magic pill disappear into the Matrix. The turn ends. Note that once somebody disappeared, they are gone for the rest of the experiment. You cannot give them more pills in the next rounds. You are given the int N. You are also given an int turns: the maximum number of turns you may take. You are looking for a strategy that will guarantee that you will find the bag with magic pills within the given number of turns. The strategy may be adaptive: When distributing the pills in any given round, you know the results of the previous rounds and you may use that information to decide who gets which pills. Compute and return the smallest number F such that if you invite F friends there will be such a strategy.
Definition
����
Class:
IntoTheMatrix
Method:
takePills
Parameters:
int, int
Returns:
int
Method signature:
int takePills(int turns, int N)
(be sure your method is public)
Limits
����
Time limit (s):
2.000
Memory limit (MB):
256
Constraints
-
turns will be between 1 and 10 inclusive.
-
N will be between 1 and 10^6 inclusive.
 */
public class IntoTheMatrix {

	int[][] f;
	public int takePills(int turns, int N){
		
		f=new int[turns+1][N];
		int k=0;
		if (turns==1 && N==1)return 0;
		f[1][0]=1;
		for (int i=1;i<N;i++){
			
			f[1][i]=2*f[1][i-1];
			if (f[1][i]>=N)break;
		}
		while(true){
			k++;
			if (run(turns,k)>=N)return k;
		}
	}
	private int run(int turns, int k) {
		if (f[turns][k]>0)return f[turns][k];
		if (k==0)return 1;
		f[turns][k]=run(turns-1,k);
		for (int i=1;i<=k;i++){
			f[turns][k]+=run(turns-1,k-i)*c(k,i);
		}
		return f[turns][k];
	}
	private int c(int k, int i) {
		int ans=1;
		for (int j=1;j<=i;j++){
			ans=ans*(k+1-j)/j;
		}
		return ans;
	}
}
