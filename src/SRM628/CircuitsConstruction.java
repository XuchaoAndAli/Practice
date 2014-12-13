package SRM628;

/**
 * div1 no.2
 * tree with greedy
 */

import java.util.Arrays;
import java.util.Stack;

public class CircuitsConstruction {

	public int maximizeResistance(String circuit, int[] conductors){
		Stack<Node> s=new Stack<Node>();
		char[] c=circuit.toCharArray();
		for (int i=0;i<c.length;i++){
			if (c[i]=='A'){
				s.push(new Node('A'));
			}else if (c[i]=='B'){
				s.push(new Node('B'));
			}else{
				s.push(new Node('X'));
				s.peek().ok=true;
				s.peek().size=1;
				while (s.peek().ok){
					Node t=s.pop();
					if (s.isEmpty() || !s.peek().ok){
						s.push(t);
						break;
					}
					Node l=s.pop();
					Node p=s.peek();
					p.left=l;
					p.right=t;
					p.ok=true;
					if (p.val=='A'){
						p.size=p.left.size+p.right.size;
					}else{
						p.size=Math.max(p.left.size,p.right.size);
					}
				}
				
			}
		}
		int all=s.peek().size;
		Arrays.sort(conductors);
		int res=0;
		for (int i=conductors.length-1;i>=conductors.length-all;i--){
			res+=conductors[i];
		}
		return res;
		
		
		
		
	}
}

class Node{
	int size;
	Node left,right;
	char val;
	boolean ok;
	public Node(char a) {
		val=a;
		ok=false;
	}
}
