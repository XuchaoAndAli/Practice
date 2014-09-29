package srm631;

import java.util.Arrays;

/**
 * div1 no3
 * amazing thought!
 * compress the height of tree to reduce the calculating steps in every query.
 * @author Yihan
 *
 */
public class TaroTreeRequests {

	int curValue;
	int N;
	int maxValue,maxHeight;
	int[] value;
	int[] parent;
	int[] queryU;
	int[] queryV;
	int M;
	
	public int genNextRandom(){
	    curValue = (curValue * 1999 + 17)% 1000003;
	    return curValue;
	}
	public void generateTree(){
		value=new int[N];
		parent=new int[N];
		value[0]=parent[0]=-1;
	    for (int i=1;i<N;i++){
	        value[i] = genNextRandom()%maxValue;
	        parent[i] = Math.max( 0, i - 1 - (genNextRandom() % maxHeight) );
	       // in our tree, the parent of vertex i is parent[i]
	        //the edge between i and parent[i] has the label value[i]
	    }
	}
	public void generateQueries(){
		queryU=new int[M];
		queryV=new int[M];
	    for (int i=0;i<M;i++){
	        queryU[i] = genNextRandom() % N;
	        queryV[i] = genNextRandom() % N;
	       
	        if (queryU[i] > queryV[i]){
				int t=queryU[i];
				queryU[i]=queryV[i];
				queryV[i]=t;
					
			//swap queryU[i] and queryV[i]
	        //process the query with u=queryU[i] and v=queryV[i]
			}
//	        System.out.println(queryU[i]);
//	        System.out.println(queryV[i]);
	    }
	}
	
	public long getNumber(int N, int M, int startValue, int maxValue, int maxHeight){
		this.N=N;
		this.M=M;
		curValue=startValue;
		this.maxHeight=maxHeight;
		this.maxValue=maxValue;
		
		generateTree();
		generateQueries();
		//go
		long ans=0;
		for (int i=0;i<M;i+=1000){
			int start=i;
			int end=Math.min(M, i+1000);
			boolean[] marked=new boolean[N];
			for (int j=start;j<end;j++){
				marked[queryU[j]]=true;
				marked[queryV[j]]=true;
			}
			marked[0]=true;
			int[] tp=new int[N];
			int[] ts=new int[N];
			int[] tv=new int[N];
			int[] tc=new int[N];
			Arrays.fill(tc, -1);
			tp[0]=-1;
			for (int j=1;j<N;j++){
				ts[j]=tc[parent[j]];
				tc[parent[j]]=j;
			}
			int[] queue=new int[N];
			int qs=0;
			int qt=1;
			queue[0]=0;
			while(qs<qt){
				int cur=queue[qs++];
				for (int j=tc[cur];j!=-1;j=ts[j]){
					if (marked[cur]){
						tv[j]=value[j];
						tp[j]=cur;
					}else{
						tv[j]=Math.max(value[j],tv[cur]);
						tp[j]=tp[cur];
					}
					if (tc[j]!=-1)queue[qt++]=j;
				}
			}
			for (int j=start;j<end;j++){
				if (queryU[j]==queryV[j]){
					//System.out.println("   ");
					ans+=-1;
					continue;
					
				}
				int tt=queryV[j];
				int ttt=0;
				while(tp[tt]!=-1 && tp[tt]!=queryU[j]){
					
					ttt=Math.max(tv[tt], ttt);
					tt=tp[tt];
					//System.out.println(ttt);
				}
				ttt=Math.max(tv[tt], ttt);
				if (tp[tt]==queryU[j]){
					ans+=ttt;
				}else{
					tp[queryU[j]]=queryV[j];
					parent[queryU[j]]=queryV[j];
					tv[queryU[j]]=value[queryU[j]];
				}
			}
		}
		return ans;
		
	}
	public static void main(String[] a){
		TaroTreeRequests p=new TaroTreeRequests();
		
		int N=7;
		int M=10;
		int startValue=74;
		int maxValue=7;
		int maxHeight=3;
		System.out.println(p.getNumber(N, M, startValue, maxValue, maxHeight));
	}
	
}

/*
Problem Statement
    
Please note that this problem has a non-standard time limit: 10 seconds.

Cat Taro has a rooted tree with N nodes. Nodes are numbered from 0 to N-1, inclusive. Node with the index 0 is the root of the tree. Each edge has some positive integer value written on it.

Taro wants to process M queries. Each query consists of two nodes u and v. Queries should be processed in the following way:
If u equals v, print -1.
Otherwise, if the node v is in the subtree of the node u, print the maximum value written on the edges that belong to the simple path from u to v.
Otherwise, remove the edge between u and its parent. Instead, add a new edge (with the same value) that makes u the child of v. (Note that the entire subtree rooted at u is now a part of the subtree rooted at v.) Do not print anything.
Return the sum of all values that were printed during the process.

You are given the ints N and M. You are also given ints startValue, maxValue, and maxHeight. These are used in the following pseudocode that generates the initial tree and the sequence of queries you should process.

initialize():
    curValue = startValue

genNextRandom():
    curValue = (curValue * 1999 + 17) modulo 1,000,003
    return curValue

generateTree():
    for i=1 to N-1:
        value[i] = genNextRandom() modulo maxValue;
        parent[i] = max( 0, i - 1 - (genNextRandom() modulo maxHeight) );
        in our tree, the parent of vertex i is parent[i]
        the edge between i and parent[i] has the label value[i]

generateQueries():
    for i=0 to M-1:
        queryU[i] = genNextRandom() modulo N
        queryV[i] = genNextRandom() modulo N
	if queryU[i] > queryV[i]:
		swap queryU[i] and queryV[i]
        process the query with u=queryU[i] and v=queryV[i]

To generate the input, call initialize(), then generateTree(), and finally generateQueries().
Definition
    
Class:
TaroTreeRequests
Method:
getNumber
Parameters:
int, int, int, int, int
Returns:
long
Method signature:
long getNumber(int N, int M, int startValue, int maxValue, int maxHeight)
(be sure your method is public)
Limits
    
Time limit (s):
10.000
Memory limit (MB):
256
Notes
-
The intended solution should work within the given time limit for an arbitrary tree and an arbitrary sequence of queries. It does not depend on any special properties of the pseudorandom generator.
Constraints
-
N will be between 1 and 200,000, inclusive.
-
M will be between 1 and 200,000, inclusive.
-
startValue will be between 0 and 1,000,002, inclusive.
-
maxValue will be between 1 and 1,000,003, inclusive.
-
maxHeight will be between 1 and 1,000,003, inclusive.
*/