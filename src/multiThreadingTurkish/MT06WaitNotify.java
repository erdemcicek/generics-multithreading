package multiThreadingTurkish;

/*
 	======================================== WAIT, NOTIFY =====================================================
 	
 		Object.wait() metodu bir thread'i suresiz olarak askiya alir. Diger bir ifadeyle
 		bu thread'in kilitlemis (locked) oldugu bir kaynagi salivermesini ve askiya gecmesini saglar.
 		Thread bu durumdan bir baska thread onu bilgilendirirse (notify) cikabilir.
 		
 		Object.notify() metodu ise ayni nesne uzerinde askiya alinan bir thread'in uyanmasini saglar.
 		Object.notifyAll() metodu bir nesne uzerinde askiya alinan tum thread'lerin uyandirilmasini saglar.
 		
 		Bu metotlar, thread'ler arasi iletisim metodu olarak kullanilir.
 */

public class MT06WaitNotify {

	public static double balance = 0.0;
	public static void main(String[] args) {
		
		MT06WaitNotify tran = new MT06WaitNotify();
		
		Thread withdrawThread = new Thread(new Runnable() {

			@Override
			public void run() {
				tran.withdraw(200);
			}
			
		});
		
		Thread depositThread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				tran.deposit(500);
			}
			
		});
		
		withdrawThread.start();
		depositThread.start();
		
	}
	
	public void withdraw(double amount) {
		
		synchronized (this) {
			if ( balance < 0 || balance < amount ) {
				System.out.println("Balance is not sufficient. Please deposit first...");
				try {
					// withdrawThread'i bir baska thread notify() veya notifyAll() metoduna cagirana kadar
					// askiya alinir. Ancak bunun olabilmesi icin nesnenin kendine ait bir gozlemcisini olmasi
					// gerekir. Synchronized block, synchronized static veya synchronized nesnenin gozlemlenmesini
					// saglamaktadir.
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			balance -= amount;
			System.out.println("Amount has been successfully withdrawn.\nYour new balance: " + balance);
		}
	}
	
	public void deposit(double amount) {
		
		balance += amount;
		System.out.println("Amount has been successfully deposited.\nYour new balance: " + balance);
		
		synchronized (this) {
			notify();
		}
	}
}
