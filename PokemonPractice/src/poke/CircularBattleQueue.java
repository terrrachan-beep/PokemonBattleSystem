package poke;

public class CircularBattleQueue {
    BattleAction[] data;
    int front;
    int rear;
    int count;

    public CircularBattleQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }

        data = new BattleAction[capacity];
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
    

    void enqueue(BattleAction action) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }

        data[rear] = action;
        rear = (rear + 1) % data.length;
        count++;
    }

    BattleAction dequeue() {
        if (isEmpty()) {
            return null;
        }

        BattleAction action = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        count--;

        return action;
    }

    BattleAction peek() {
        if (isEmpty()) {
            return null;
        }

        return data[front];
    }
    
    int size() {
        return count;
    }
    
}