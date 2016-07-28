package com.base.thread;

public class InterruptedThread {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		//������ζ�Ӧ�ø��߳���һ������,�������ⶨλ
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
			
			//�ڶ��̱߳��ʱ,��סҪ��Ӧinterrupted
			if(Thread.interrupted()) {
				System.out.println("Fuck ,be interrupted.");
				break;
			}
			
			/*
			//�������߽���˯��,���ж�״̬�������(Thread.interrupted()����Ϊtrue),Ҳ����˵����break��ȥ,���������ǻ��յ�һ��InterruptedException
			//�ܶ෽ʽ�����״̬,�ɿ�API�ĵ�
			try {
				Thread.currentThread().sleep(1000l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			*/
		}
	}
}
