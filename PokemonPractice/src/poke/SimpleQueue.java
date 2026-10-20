package poke;

public class SimpleQueue {
	BattleAction[]data;
	int front;
	int rear;
	
	SimpleQueue(int size){
		data = new BattleAction[size];
		front = 0;
		rear = 0;
		
	}
	
	boolean isFull() {
		return rear == data.length;
	}

	boolean isEmpty() {
		return front == rear;
	}
	void enqueue(BattleAction value) {
		if (isFull()) {
			System.out.println("Queue is full!");
			return;
		}
		
		data[rear] = value;
		rear++;
	}
	
	BattleAction peek() {
		if (isEmpty()) {
			return null;
		}
		return data[front];
	}
	
	BattleAction dequeue() {
		if (isEmpty()) {
			return null;
			
		}
		BattleAction value = data[front];
		front++;
		return value;
	}
	
	void showqueue() {
		for (int i= front;i<rear;i++) {
			System.out.print(""+data[i]+" ");
		}
		System.out.println();
	}
	
}