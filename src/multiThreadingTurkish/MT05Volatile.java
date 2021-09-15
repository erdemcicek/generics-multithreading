package multiThreadingTurkish;

/*  
 ============================================= VOLATILE =====================================================
 
 	Volatile keyword'u bir degiskenin farkli threadler tarefindan kullanilirken degerinin degismesini saglamak icin
 	kullanilmaktadir. Ayni zamanda bir class'i thread-safe yapmak icin de kullanilir. Yani diger bir degisle bir class
 	yada nesneyi farkli thread'lerin es zamanli olarak problemin kullanimina olanak saglar.
 	
 	Volatile keyword'u sadece degiskenler ile (primitif veya non-primitif) kullanilabilir. Nesne ve Class'lara konulmaz.
 	
 	Volatile keyword'u kullanilan bir degiskenin degeri cache bellege saklanmaz. Her defasinda ilgili class'in bellegi
 	(MAIN MEMORY) den okunur. Dolayisiyla farkli thread'ler degiskeni guncellese de her defasinda en guncel deger okunmus olur.
 	
 	Bu ozellikleri sayesinde synchronization yonteminin daha iyi bir alternatifi olarak dusunulebilir.
 
 */

public class MT05Volatile {
	
	public static volatile int age = 0;
	
	public static void main(String[] args) {
		
		Thread th1 = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true){
					if ( age == 0 ) System.out.println("TH1 is running...");
					else break;
					
				}
			}
			
		});
		
		Thread th2 = new Thread(new Runnable() {

			@Override
			public void run() {
//				try {
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				age = 1;
				System.out.println("Age has been updated...");
			}
			
		});
		
		th1.start();
		th2.start();
		
	}
	
	

}




















