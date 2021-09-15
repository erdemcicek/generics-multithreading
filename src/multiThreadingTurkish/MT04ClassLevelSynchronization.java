package multiThreadingTurkish;

public class MT04ClassLevelSynchronization {
	
	/* 
	 	Thread'ler farkli nesneler kullanirsa durum nasil degisir?
	 	Dolayisiyla metot seviyesi synchronization ise yaramayacaktir.
	 	Cunku her iki thread, farkli nesnelerin putParanthesis() metodunu calistirmaktadir.
	 	Burada cozum icin class seviyesinde blocklama yapmaktir. 
	 	Cunku her iki obje ayni class'dan turetilmektedir.
	 */

	public static void main(String[] args) {
		
		Paranthesis1 p1 = new Paranthesis1();
		Paranthesis1 p2 = new Paranthesis1();
		
		Thread th1 = new Thread(new Runnable() {

			@Override
			public void run() {
				
				for(int i = 1; i <= 5 ; i++) {
					p1.putParanthesis();
				}
				
			}
			
		});
		
		Thread th2 = new Thread(new Runnable() {

			@Override
			public void run() {
				
				for(int i = 1 ; i <= 5 ; i++) {
					p2.putParanthesis();
				}
			}
			
		});
		
		th1.start();
		th2.start();
		
	}
	
	
}

class Paranthesis1 {
	
	synchronized public void putParanthesis() {
		
		for(int i = 1; i <=10 ; i++) {
			if( i <=5 ) System.out.print("[");
			else System.out.print("]");
		}
		System.out.println();
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
