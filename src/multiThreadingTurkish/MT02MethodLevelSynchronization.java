package multiThreadingTurkish;
/*
	=========================================   SYNCHRONIZED  ==========================================================
	multi-threading çalışma koşullarında birden fazla thread'in aynı kaynağa (değişken metot, class, bellek vb)
	erişimi (okuma veya yazma) sırasında verinin güncellenmesi ve tutarlılığı ile ilgili sorunlar çıkabilir.
	Bu tutarsızlığı engellemek için synchronized keywordu kullanılabilir.
	Kısaca, Syncronization bir kaynağın tread'ler tarafından eş zamanlı kullanımına kapatılması (Lock) işlemidir.
	
	Synchronized keywordunun farklı kullanımları bulunmaktadır.
	1- Eğer bir metot "synronized" yapılırsa (Method-Level Syncronization) bu metota aynı andan birden fazla thread'in
	  erişimine izin verilmez.
	
	2- Eğer bir metot yerine o metodun ait olduğu class'ı aynı anda birden fazla thread'in kullanımına kapatmak
	  (class-level Syncronization) istersek o zaman "synchronized static" kullanmalıyız.
	3- Eğer bir metot içerisinde belirli bir kismin eş zamanlı thread kullanımına kapatılmasını ister isek o zaman
	  "synchronized block" (block-level Syncronization) kullanmalıyız.
	  */
	
public class MT02MethodLevelSynchronization {
	// Her iki thread tarafindan ortak kullanilacak degisken
	public static int counter = 0;
	public static void main(String[] args) throws InterruptedException {
		
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				Counter.count("th1");
			}
			
		});
		
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				Counter.count("th2");
			}
			
		});
		
		thread1.start();
//		thread1.join(); // bu ornek icin multithreading'i devre disi birakmis olur
		thread2.start();
	}
	
}
/*
  	Metodu synchronized yaparak her iki thread'in ayni anda (es-zamanli, concurrently) metoda erisimini engellemis olduk.
  	Eger boyle yapmasaydik es zamanli olarak thread1 ve thread2 count() metoduna erisim count'in degerini arttirabilirdi.
  	Bu sikinti join metodu ile de giderilebilirdi. Ancak ikisi arasinda nuanslar bulunmaktadir.
  	join() metodu bir thread'in tamamiyla bitmesinin beklemesini saglarken, synchronization ayni anda bir kaynaga
  	erisimi engellemektedir.
  	Hangisinin daha elverisli olacagi uygulamanin gereksinimlerine ve kosullara gore degisebilir.
 */

class Counter{
	synchronized public static void count(String thread) {
		for(int i = 1; i <= 20 ; i++) {
			MT02MethodLevelSynchronization.counter++;
			System.out.println("Counter-" + thread + " " + MT02MethodLevelSynchronization.counter);
		}
	}
}













