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

}
