package com.base.lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockInTwoThread {
	
	public final static ReentrantLock lock = new ReentrantLock();
	
	
	public static void main(String[] args) {
		lock.lock();
		Thread t1 = new Thread(new UnlockThread(lock));
		t1.start();
	}
	
	static class UnlockThread implements Runnable {
		private ReentrantLock lock;
		
		public UnlockThread(ReentrantLock lock) {
			this.lock = lock;
		}
		
		public void run() {
			//这边解锁异常,锁是针对线程的,那个线程锁,就需要哪个线程解锁,所以UnlockThread这个线程压根就没获取到锁,这边unlock就会抛出Exception
			this.lock.unlock();
		}
	} 
}
