
package poke;

public class SimpleQueue {
    BattleAction[] data;
    int front;
    int rear;
    int count;

    SimpleQueue(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }

        data = new BattleAction[size];
        front = 0;
        rear = 0;
        count = 0;
    }

    boolean isFull() {
        return count == data.length;
    }

    boolean isEmpty() {
        return count == 0;
    }

    void enqueue(BattleAction value) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }

        data[rear] = value;
        rear = (rear + 1) % data.length;
        count++;
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
        data[front] = null;
        front = (front + 1) % data.length;
        count--;

        return value;
    }

    void showqueue() {
        for (int i = 0; i < count; i++) {
            int index = (front + i) % data.length;
            System.out.print(data[index] + " ");
        }
        System.out.println();
    }
}
