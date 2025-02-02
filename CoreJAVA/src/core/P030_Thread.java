package core;

import java.time.Duration;
class ByRunnable implements Runnable{

	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		for(int i=1;i<=5;i++) {
			try {
				System.out.println(i);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("total time : "+(endTime-startTime));
	}
	
}
class BYThreadClass extends Thread{
	public void run() {
		long startTime = System.currentTimeMillis();
		for(int i=1;i<=5;i++) {
			try {
				System.out.println(i);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("total time : "+(endTime-startTime));
	}
}
public class P030_Thread {
	public static void main(String[] args) {
		Thread t = new Thread();
		System.out.println(t.currentThread());
		t.setName("MyThread");
		System.out.println(t);
		long startTime = System.currentTimeMillis();
		for(int i=1;i<=5;i++) {
			try {
				System.out.println(i+" : "+t);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("total time : "+(endTime-startTime));
		
		BYThreadClass b = new BYThreadClass();
		b.run();
		
		ByRunnable q = new ByRunnable();
		q.run();
	}
}
