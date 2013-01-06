package com.kolich.interview.queues;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CustomBlockingQueue<T> {
	
	private final List<T> queue_;
	
	public CustomBlockingQueue() {
		queue_ = new LinkedList<T>();
	}
	
	public void put(T t) {
		synchronized(queue_) {
			queue_.add(t);
			queue_.notifyAll();
		}
	}
	
	public T take() {
		synchronized(queue_) {
			while(queue_.isEmpty()) {
				try {
					queue_.wait();
				} catch (InterruptedException e) { }
			}
			// Remove the head of the list.
			return queue_.remove(0);
		}
	}
	
	public static void main(String[] args) {
		
		final CustomBlockingQueue<String> queue = new CustomBlockingQueue<String>();
		
		// Producer
		new Thread(new Runnable() {
			private Random random_ = new Random();
			@Override
			public void run() {
				while(true) {
					queue.put(Long.toString(System.currentTimeMillis()));
					//System.out.println("Sleeping....");
					try {
						// Random sleep.
						Thread.sleep(random_.nextInt(4000));
					} catch (InterruptedException e) { }
				}				
			}
		}).start();
		
		// Consumer
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					System.out.println(queue.take());
				}
			}
		}).start();
		
	}

}
