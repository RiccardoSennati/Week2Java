package day3es2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

public static void main(String[] args) throws InterruptedException {
		
		Random numR = new Random();
		List<Integer> l1 = new ArrayList<>(3000);
		
		for(int i = 0; i < 3000; i++) {
			int casuale = numR.nextInt();
			l1.add(casuale);
		}
			
		NumeriArray thread1 =  new NumeriArray(l1, 0, 999);
		Thread t1 = new Thread(thread1);
		NumeriArray thread2 =  new NumeriArray(l1, 1000, 1999);
		Thread t2 = new Thread(thread2);
		NumeriArray thread3 =  new NumeriArray(l1, 2000, 2999);
		Thread t3 = new Thread(thread3);
		
		
			t1.start();
			
				t1.join();
			
			t2.start();
			
				t2.join();
			
			t3.start();
			
				t3.join();
			
			
			System.out.println("Thread 1: " + thread1.ottieniSommaParziale());
			System.out.println("Thread 2: " + thread2.ottieniSommaParziale());
			System.out.println("Thread 3: " +  thread3.ottieniSommaParziale());
			
			
			long sommaTotale = thread1.ottieniSommaParziale() + thread2.ottieniSommaParziale() + thread3.ottieniSommaParziale();
			
			System.out.println("La somma totale e': " + sommaTotale);
		
	}

}

class NumeriArray implements Runnable {
	private List<Integer> l1;
	private int startIndex;
	private int endIndex;
	private long sommaParziale;
	
	public NumeriArray(List<Integer> l1, int startIndex, int endIndex) {
		this.l1 = l1;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}
	
	public long ottieniSommaParziale() {
		return sommaParziale;
	}
	
	
	@Override
	public void run() {
		
		for(int i = startIndex; i <= endIndex; i++) {
			sommaParziale += l1.get(i);
		}
		
	}

}
