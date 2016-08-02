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
			//��߽����쳣,��������̵߳�,�Ǹ��߳���,����Ҫ�ĸ��߳̽���,����UnlockThread����߳�ѹ����û��ȡ����,���unlock�ͻ��׳�Exception
			this.lock.unlock();
		}
	} 
}
