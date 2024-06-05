public class Queue {
    private int front, rear, capacity;
    private int queue[];

    public Queue(int capacity) {
        this.capacity = capacity;
        front = this.rear = 0;
        queue = new int[this.capacity];
    }

    // Method to add an element to the queue (enqueue)
    void enqueue(int item) {
        // Check if the queue is full
        if (capacity == rear) {
            System.out.println("Queue is full");
            return;
        }

        // Add the item to the queue
        queue[rear] = item;
        rear++;
    }

    // Method to remove an element from the queue (dequeue)
    void dequeue() {
        // Check if the queue is empty
        if (front == rear) {
            System.out.println("Queue is empty");
            return;
        }

        // Shift all elements one position to the left
        for (int i = 0; i < rear - 1; i++) {
            queue[i] = queue[i + 1];
        }

        // Decrease rear and reset the last element to 0
        if (rear < capacity)
            queue[rear - 1] = 0;

        rear--;
    }

    // Method to get the front element of the queue
    int front() {
        // Check if the queue is empty
        if (front == rear) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    // Method to check if the queue is empty
    boolean isEmpty() {
        return front == rear;
    }

    // Method to display the elements of the queue
    void display() {
        if (front == rear) {
            System.out.println("Queue is empty");
            return;
        }

        for (int i = front; i < rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);

        // Enqueue elements
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        // Display elements
        System.out.print("Queue elements: ");
        q.display();

        // Dequeue elements
        q.dequeue();
        q.dequeue();

        // Display elements
        System.out.print("Queue elements after two dequeues: ");
        q.display();

        // Get front element
        System.out.println("Front element: " + q.front());

        // Check if queue is empty
        System.out.println("Is queue empty? " + q.isEmpty());
    }
}
