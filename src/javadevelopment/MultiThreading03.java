package javadevelopment;

public class MultiThreading03 {

	public static void main(String[] args) {
		
		Brackets obj1 = new Brackets();
		obj1.generateBrackets();
	}
}

class Brackets{
	
	public void generateBrackets() {
		
		for(int i = 1; i<=10 ; i++) {
			if(i<=5) {
				System.out.print("[");
			}else {
				System.out.print("]");
			}
		}
		System.out.println();
	}
}
