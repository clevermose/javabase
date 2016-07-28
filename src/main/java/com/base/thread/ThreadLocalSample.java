package com.base.thread;

/**
 * ÿ���߳�ά����һ��Map,Map��keyΪThreadLocal<T>����,ValueΪ���̶߳�Ӧ��T���͵�ֵ
 * ʹ�ø��ַ�ʽ�洢ֵ�úô��ǲ�ѯ���ٶȱȽϿ�,Map��sizeΪ���̵߳�ThreadLocal����ĸ���
 * 
 * ���ʹ����ThreadLocal�д洢��ôһ��Map,KeyΪ�̶߳���,ValueΪ���̶߳�Ӧ��T���͵�ֵ
 * ��ô��Map�ͻ�Ƚϴ�,Map�Ĵ�СΪʹ�ø�ThreadLocal������̵߳ĸ���,����Ч�ʻ�С�ܶ�
 * 
 * @author haiswang
 *
 */
public class ThreadLocalSample {
	
	public static void main(String[] args) {
		
		TestThreadLocal testThreadLocal = new TestThreadLocal();
		
		for(int i=0; i<5; i++) {
			//���е��̶߳���ʹ�õ�ͬһ��ʵ��Runnable�ӿڵ����ʵ������testThreadLocal,
			//����ÿ���̻߳�ȡ����address�����ǲ�һ����
			//ͬʱҲ����Address�Ĺ��캯����������5��
			Thread t1 = new Thread(testThreadLocal);
			t1.start();
		}
		
	}
}

class TestThreadLocal implements Runnable {
	
	//����ThreadLocal��get()����ʱ,���û�л�ȡ��ֵ,��ô�ͻ����initialValue()�������
	//�������Ϊprotecked,Ĭ�Ϸ���ֵΪnull,��Ҫ���Ǵ�д
	static ThreadLocal<Address> address = new ThreadLocal<Address>() {
		protected Address initialValue() {
			return new Address();
		}
	};
	
	public void run() {
		System.out.println("threadId : " + Thread.currentThread().getId() + " ,address hashCode : " + address.get().hashCode());
	}
}

/**
 * 
 * @author haiswang
 *
 */
class Address {
	public Address() {
		System.out.println("someone call me.");
	}
}

