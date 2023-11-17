import java.util.ArrayList;
import java.util.List;

public class QueueADTImpl<T> implements QueueADT<T> {

    private int capacity; // kich thuoc toi da
    private List<T> items;

    public QueueADTImpl(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    @Override
    public void enqueue(T t) {
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        items.add(t);
    }

    @Override
    public T dequeue() {
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        else{
            T t = items.get(0);
            items.remove(0);
            return t;
        }
    }

    @Override
    public T peek() {
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        else{
            T t = items.get(0);
            return t;
        }
    }

    @Override
    public boolean isEmpty() {
        if (items.size() == 0) return true;
        return false;
    }

    @Override
    public boolean isFull() {
        if (items.size() == capacity) return true;
        return false;
    }

    @Override
    public void printQueue() {

    }
}
