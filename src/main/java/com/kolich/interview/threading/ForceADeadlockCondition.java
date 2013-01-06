package com.kolich.interview.threading;

public class ForceADeadlockCondition {
		
	public static void main(String[] args) {
		
		final Object resource1 = new Object();
		final Object resource2 = new Object();
		
		// Thread 1
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized(resource1) {
					// Do some things ...
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) { }
					synchronized(resource2) {
						// Do more cool things ...
					}
				}
			}
		}).start();
		
		// Thread 2
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized(resource2) {
					// Do some things ...
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) { }
					synchronized(resource1) {
						// Do more cool things ...
					}
				}
			}
		}).start();
		
	}

}
