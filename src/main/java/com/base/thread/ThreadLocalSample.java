package com.base.thread;

/**
 * 每个线程维护着一个Map,Map的key为ThreadLocal<T>对象,Value为该线程对应的T类型的值
 * 使用该种方式存储值得好处是查询的速度比较快,Map的size为该线程的ThreadLocal对象的个数
 * 
 * 如果使用在ThreadLocal中存储这么一个Map,Key为线程对象,Value为该线程对应的T类型的值
 * 那么该Map就会比较大,Map的大小为使用该ThreadLocal对象的线程的个数,这样效率会小很多
 * 
 * @author haiswang
 *
 */
public class ThreadLocalSample {
	
	public static void main(String[] args) {
		
		TestThreadLocal testThreadLocal = new TestThreadLocal();
		
		for(int i=0; i<5; i++) {
			//所有的线程都是使用的同一个实现Runnable接口的类的实例对象testThreadLocal,
			//但是每个线程获取到的address对象是不一样的
			//同时也发现Address的构造函数被调用了5次
			Thread t1 = new Thread(testThreadLocal);
			t1.start();
		}
		
	}
}

class TestThreadLocal implements Runnable {
	
	//调用ThreadLocal的get()方法时,如果没有获取到值,那么就会调用initialValue()这个方法
	//这个方法为protecked,默认返回值为null,需要我们从写
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

