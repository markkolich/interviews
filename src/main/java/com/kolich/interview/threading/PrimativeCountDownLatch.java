package com.kolich.interview.threading;

public class PrimativeCountDownLatch {
	
	private final Object o_;
	private int count_;
	
	public PrimativeCountDownLatch(int count) {
		o_ = new Object();
		count_ = count;
	}
	
	public final void await() throws InterruptedException {
		synchronized(o_) {
			while(count_ > 0) {
				// Even though we're waiting in a "synchronized" block,
				// this thread lies dormant until notified.  Wait here
				// releases the "monitor".
				o_.wait();
			}
		}
	}
	
	public final void countDown() {
		synchronized(o_) {
			if(--count_ <= 0) {
				o_.notifyAll();
			}
		}
	}
	
	public static final void main(String[] args) {
		
		final PrimativeCountDownLatch latch = new PrimativeCountDownLatch(5);
		
		// This thread waits.
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("I'm waiting!");
				try {
					latch.await();
				} catch (InterruptedException e) {
					System.err.println(e);
				}
				System.out.println("Done!");
			}
		}).start();
		
		// This thread counts down using the latch.
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 5; i++) {
					try {
						Thread.sleep(1000L);
					} catch (InterruptedException e) {
						System.err.println(e);
					}
					System.out.println("Counting down... " + (i+1));
					latch.countDown();					
				}
			}
		}).start();
		
	}

}