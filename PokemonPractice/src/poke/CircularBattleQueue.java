package poke;

public class CircularBattleQueue {
    BA[] data;
    int front;
    int rear;
    int count;

    public CircularBattleQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }

        	data = new BA[size];
        front = 0;
        rear = 0;
        count = 0;
    }

    boolean isEmpty() {
        return count == 0;
    }

    boolean isFull() {
        return count == data.length;
    }
    

    void enqueue(BA action) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }

        data[rear] = value;
        rear = (rear + 1) % data.length;
        count++;
    }

    BA peek() {
	    if (isEmpty()) {
	        return null;
	    }
	    return data[front];
	}

	
	BA dequeue() {
	    if (isEmpty()) {
	        return null;
	    }

	    BA value = data[front];
	    front=(front+1)%data.length;
	    count--;
	    return value;
	}
}