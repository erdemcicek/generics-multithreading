package multiThreadingTurkish;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

/* 
 	========================================== THREAD POOL ================================================
 	
 		Thread Pool, ExecutorService interface'i yardimiyla olusturulan bir Thread havuzudur. Hizmet gorecek olan
 		thread'ler bastan bir kere olusturulur sonrasinda ise kuyrukta (TaskQueue) siranin ona gelmesini bekler.
 		Havuzun kapasitesi olcusunde thread'ler es zamanli hizmet gorurler.
 		
 		Bu yontem bastan thread'lerin olusturulmasini, belirli sayida thread'in es-zamanli calistirilmasini ve 
 		gerektiginde tekrar kullanilmasini saglamaktadir. Boylece, surekli Thread olusturmak ve kaldirmak gibi ciddi
 		is yuku getiren islemlerin runtime sirasinda yapilmasina gerek kalmaz. Bu da onemli olcude performans artisi
 		saglar.
 		
 		Ozellikle web sunucu ortamlari icin elverisli bir metot sunar.
 */

public class MT07ThreadPool {
	
	public static void main(String[] args) {
		
		// Thread havuzunu olustur
		ExecutorService service = Executors.newFixedThreadPool(4);
		
		
		// Tum thread'leri bastan olustur
		Thread th1 = new GenerateThread("Thread 1");
		Thread th2 = new GenerateThread("Thread 2");
		Thread th3 = new GenerateThread("Thread 3");
		Thread th4 = new GenerateThread("Thread 4");
		Thread th5 = new GenerateThread("Thread 5");
		Thread th6 = new GenerateThread("Thread 6");
		Thread th7 = new GenerateThread("Thread 7");
		Thread th8 = new GenerateThread("Thread 8");
		Thread th9 = new GenerateThread("Thread 9");
		Thread th10 = new GenerateThread("Thread 10");
		
		
		// Var olan thread'lerin calistirilmasi
		service.execute(th1);
		service.execute(th2);
		service.execute(th3);
		service.execute(th4);
		service.execute(th5);
		service.execute(th6);
		service.execute(th7);
		service.execute(th8);
		service.execute(th9);
		service.execute(th10);
		
		// ExecutorService nesnesinin kapatilmasi
		service.shutdown();
	}

}

class GenerateThread extends Thread {
	
	private String threadName;
	
	public GenerateThread(String threadName) {
		this.threadName = threadName;
	}

	@Override
	public void run() {
		System.out.println(threadName + " started running");
		
		try {
			// Her bir thread'in islem suresi rastgele olarak belirlensin ( 500 - 3000 ) 
			Integer randomTime = ThreadLocalRandom.current().nextInt(500, 3000);
			Thread.sleep(randomTime);
			// System.out.println(randomTime + " " + threadName);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(threadName + " has stopped running");
		
	}
}
