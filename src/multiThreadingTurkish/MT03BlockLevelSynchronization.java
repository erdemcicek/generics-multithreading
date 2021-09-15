package multiThreadingTurkish;

public class MT03BlockLevelSynchronization {
	
	public static void main(String[] args) throws InterruptedException {
		
		Paranthesis p1 = new Paranthesis();
		
		Thread th1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i = 1 ; i <= 5 ; i++) {
					p1.putParanthesis();
				}
			}
			
		});
		
		Thread th2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i = 1 ; i <= 5 ; i++) {
					p1.putParanthesis();
				}
			}
			
		});
		
		long start = System.currentTimeMillis();
		
		th1.start();
		th2.start();
		
		th1.join(); 
		th2.join();
		long end = System.currentTimeMillis();
		
		System.out.println("Time elapsed: " + (end - start));
		
	}
	
	
}
/*
 		Uygulamalarda bazen tum metodun synchronized yapilmasi gerekmeyebilir.
 		Bu durumda, sadece ilgili kisimlari synchronized yapip diger kisimlarin klasik multi-threading mantigi ile 
 		calismasina izin vermek performans acisindan onemli katki saglayacaktir.
 		
 		Istenilen kisimlarin synchronized yapilmasi icin "synchronized block" kullanilir.
 		Bu durumda blok icersindeki kisima ayni anda birden fazla thread'in erisime izin verilmez iken disinda kalan
 		kisimlara aktif olan threadler tarafindan es zamanli erisim saglanabilir
 */

class Paranthesis {
	
	public void putParanthesis() {
		
		// Block level synchronization
		// Sadece parantez yazdirma kismini es zamanli kullanima kilitliyoruz.
		synchronized (this) {
			for(int i = 1; i <=10 ; i++) {
				if(i<=5) System.out.print("[");
				else System.out.print("]");
			}
			System.out.println();
		}
		
		// Dolayisiyla bir thread yazdirma islemini yaparken diger thread bu kismi yani gecikme kismini calistirabilir.
		// Bu da performans acisindan olumlu etki yapacaktir.
		
		for(int i = 1 ; i <= 10 ; i++) {
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
