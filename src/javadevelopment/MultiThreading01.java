package javadevelopment;

public class MultiThreading01 {

	
	public static void main(String[] args) throws InterruptedException {
		//We run the code without using MultiThreading
		long startingTime00 = System.currentTimeMillis();
		
		CounterWithoutMultiThread obj1 = new CounterWithoutMultiThread(1);
		obj1.countMe();
		
		System.out.println("===================");
		
		CounterWithoutMultiThread obj2 = new CounterWithoutMultiThread(2);
		obj2.countMe();
		
		long endingTime00 = System.currentTimeMillis();
		
		System.out.println("Duration without Thread " + (endingTime00 - startingTime00));
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		// We will run the same code by using MultiThreading
		long startingTime01 = System.currentTimeMillis();
		CounterWithMultiThread obj3 = new CounterWithMultiThread(3);
		obj3.start();
		System.out.println("===================");
		CounterWithMultiThread obj4 = new CounterWithMultiThread(4);
		obj4.start();
		/*
		 	This way is not appropriate solution
		 */
		//Thread.sleep(2000);
		
		obj4.join();
		long endingTime01 = System.currentTimeMillis();
		System.out.println("Duration with Thread " + (endingTime01 - startingTime01));
	}
	
}

class CounterWithoutMultiThread{
	
	private int threadNum;
	
	public CounterWithoutMultiThread(int threadNum) {
		this.threadNum = threadNum;
	}
	
	public void countMe() {
		for(int i = 1 ; i <= 9 ; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("i: " + i + " Thread Number:" + threadNum);
		}
	}
}


class CounterWithMultiThread extends Thread{
	
	private int threadNum;
	
	public CounterWithMultiThread(int threadNum) {
		this.threadNum = threadNum;
	}
	
	public void countMe() {
		for(int i = 1 ; i <= 9 ; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("i: " + i + " Thread Number:" + threadNum);
		}
	}

	@Override
	public void run() {
		countMe();
	}
}























/*
 		1) Why do we need Generic Concept?
 		2) How to use Generic Concept for a Class?
 		3) How to use Generic Concept for a Method?
 		4) How to put restrictions (Parameter Type Bounding) in Generic Concept?
 		5) Naming Convention of Type Parameters (T,E,N,K,V)
 		
 */
