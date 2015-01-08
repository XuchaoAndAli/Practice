package leetcode;

import java.util.Stack;

class MinStack {
    Stack<Integer> stack=new Stack<Integer>();
    Stack<Integer> min=new Stack<Integer>();
    public void push(int x) {
        if (min.isEmpty() || x<=min.peek())
            min.push(x);
        stack.push(x);
        
    }

    public void pop() {
        if (!min.isEmpty() && stack.peek().equals(min.peek()))
            min.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
    
    public static void main(String[] args) {
		MinStack p=new MinStack();
		p.push(512);
		p.push(-1024);
		p.push(-1024);
		p.push(512);
		p.pop();
		System.out.println(p.min);
		p.pop();
		System.out.println(p.min);
		p.pop();
		System.out.println(p.min);
		
		
	}
}