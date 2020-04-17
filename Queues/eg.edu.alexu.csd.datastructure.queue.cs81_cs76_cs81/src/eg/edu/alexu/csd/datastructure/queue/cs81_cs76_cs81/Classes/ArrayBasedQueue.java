package eg.edu.alexu.csd.datastructure.queue.cs81_cs76_cs81;

public class ArrayBasedQueue implements IArrayBased,IQueue {
   
	private int size;
	private int front,rear;
	private Object[] queue;
	private int count;
	
	ArrayBasedQueue(final int size)
	{
		this.size=size;
		queue= new Object[this.size];
	} 
	
	
	
	@Override
	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		if(count==size) throw new RuntimeException("Queue is full");
		queue[rear]=item;
		count++;
		if(rear==size-1)
		    rear=0;
		else
			rear++;
		
		
	}

	@Override
	public Object dequeue() {
		if(isEmpty()) throw new RuntimeException("Queue is empty");
		Object item=queue[front];
		queue[front]=null;
		count--;
		if(front==size-1) front=0;
		else
		front++;
		return item;
	}

	@Override
	public boolean isEmpty() {
        return count==0?true:false;
	}

	@Override
	public int size() {
		return count;
	}

}
