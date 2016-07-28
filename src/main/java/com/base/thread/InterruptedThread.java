package com.base.thread;

public class InterruptedThread {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		//无论如何都应该给线程起一个名字,方便问题定位
		Thread t1 = new Thread(new Thread1(), "thread-1");
		t1.start();
		
		try {
			Thread.currentThread().sleep(5000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t1.interrupt();
	}

}

class Thread1 implements Runnable {
	
	public void run() {
		
		int count = 0;
		while(true) {
			
			System.out.println(count++);
			
			//在多线程编程时,记住要响应interrupted
			if(Thread.interrupted()) {
				System.out.println("Fuck ,be interrupted.");
				break;
			}
			
			/*
			//如果在这边进行睡眠,则中断状态将被清除(Thread.interrupted()不再为true),也就是说不会break出去,但是它还是会收到一个InterruptedException
			//很多方式会清除状态,可看API文档
			try {
				Thread.currentThread().sleep(1000l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			*/
		}
	}
}
