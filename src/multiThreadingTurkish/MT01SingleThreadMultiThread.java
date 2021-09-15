package multiThreadingTurkish;

	/*
	 ====================================== THREAD, PROCESS =============================================
	 Thread: IT alaninda is parcacigi olarak adlandirilir
	 Thread, Process olarak adlandirilan ve her bir calisan programin alt is parcacigi olarak dusunulebilir
	 Single-Thread: Tek bir is parcacigi vardir. Ve tum isler sirayla yapilir
	 Multi-Thread: Birden fazla is parcacigi vardir ve bu isler ayni anda yapilabilir ( farkli islemciler yardimiyla )
	 
	 	Java'da 2 yontem ile Thread olusturmak mumkundur
	 	1-) Thread classi'ndan bir class extends (tureterek)
	 	2-) Runnable Interface'inden implements ederek
	 	
	 	Thread class'inin yaygin kullanilan metotlari:
	 	-----------------------------------------------------
	 	public void run() : Bir thread'in calistiracagi islemleri tanimlamak amaciyla kullanilir.
	 	public void start() : Bir thread'in baslatilmasini saglar. JVM, thread'in run() metodunu calistirir.
	 	public void sleep(long miliseconds) : Bir thread'in belirtilen sure (ms) boyunca bekletilmesini saglar.
	 	public void join() : Bir thread olmesini (bitmesi) beklemek icin kullanilir.
	 	public int getPriority() : Bir thread'in onceligini dondurur.
	 	public void setPriority(int priority) : Bir thread icin oncelik ayarlamaya yarar.
	 	public String getName() : Bir threadçin adini dondurur.
	 	public void setName() : Bir thread'e isim vermeye yarar.
	 	public Thread currentThread() : Su an calisan thread'in referansini dondurur.
	 	public int getId() : Bir thread'in id numarasini dondurur.
	 	public Thread.State getState() : Bir thread'in state (durum)'ini dondurur.
	 	public boolean isAlive() : Bir thread'in canli (alive) olup olmadigini soyler.
	 	public void yield() : Aktif olan bir thread'in gecici olarak durdurulmasini ve baska thread'lerin calistirilmasini saglar.
	 	public boolean isDaemon() : Bir thread'in Deamon thread olup olmadini test eder.
	 	public void setDeamon(boolean b) : Bir thread'i deamon thread olarak isaretler.
	 	public void interrupt() : Thread kesintiye ugratir.
	 	public boolean isInterrupted() : Bir thread'in kesilip kesilmedigini test eder.
	 */

public class MT01SingleThreadMultiThread {
	
	public static void main(String[] args) throws InterruptedException {
		
		long startSingleThr = System.currentTimeMillis();
		
		System.out.println("============ SINGLE-THREAD ================");
		CounterSingleThread s1 = new CounterSingleThread(1);
		s1.counter();
		CounterSingleThread s2 = new CounterSingleThread(2);
		s2.counter();
		
		long endSingleThr = System.currentTimeMillis();
		
		System.out.println("Single-Thread Interval: " + (endSingleThr - startSingleThr));
		
		System.out.println("============= MULTI-THREAD ================");
		
		long startMultiThr = System.currentTimeMillis();
		
		CounterMultiThread s3 = new CounterMultiThread(3);
		s3.start();
		
		CounterMultiThread s4 = new CounterMultiThread(4);
		s4.start();
		
		// Bir thread'in bitmesini beklemek icin join() metodu kullanilir
		s4.join(); // ==> s4 thread'i bittikten sonra geri kalan komutlari calistir
		
		long endMultiThr = System.currentTimeMillis();
		
		System.out.println("Multi-Thread Interval: " + (endMultiThr - startMultiThr));
	}
	

}

class CounterSingleThread {
	
	private int threadNo;
	
	public CounterSingleThread(int threadNo) {
		this.threadNo = threadNo;
	}
	
	public void counter() {
		for(int i = 1; i < 10 ; i++) {
			System.out.println("i: " + i + " Thread No: " + threadNo);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class CounterMultiThread extends Thread{
	
	private int threadNo;
	
	public CounterMultiThread(int threadNo) {
		this.threadNo = threadNo;
	}
	
	public void counter() {
		for(int i = 1; i < 10 ; i++) {
			System.out.println("i: " + i + " Thread No: " + threadNo);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		counter();
	}
}
