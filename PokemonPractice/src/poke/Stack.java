package poke;

import java.util.ArrayList;

import 

public class Stack {
	int position;
	int size;
	private　ArrayList<Integer> hp;
	
	public Stack(int n) {
		size = n;
		this.position = -1;
		hp = new ArrayList<Integer>();
		
	}
	
	public boolean isFull() {
		return hp.size() == this.size;
		
	}
	
	public int size() {
		return hp.size();
		
	}
	
	public int peek() {
		if(size()>0) {
			int k = hp.get(position);
			return k;
		}else {
			return Integer.MIN_VALUE;
		}
	}
	
	public int pop() {
		if(size()>0) {
			int k = hp.remove(position);
			this.position--;
			return k;
		}else {
			return Integer.MIN_VALUE;
		}
	}
	
	public void push(int element) {
		if(!isFull()) {
			hp.add(element);
			this.position++;
		}
	}
	
	public static void main(String[] args) {
		Stack stack1 = new Stack(5);
		
		stack1.push(100);
		stack1.push(70);
		stack1.push(40);
		
		System.out.println(stack1.size());
		System.out.println(stack1.peek());
		System.out.println(stack1.size());
		System.out.println(stack1.pop());
		System.out.println(stack1.size());
	}
}
