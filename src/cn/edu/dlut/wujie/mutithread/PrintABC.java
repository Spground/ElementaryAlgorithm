package cn.edu.dlut.wujie.mutithread;
/**
 * 控制三个线程依次顺序打印ABC
 * @author asus
 *
 */
public class PrintABC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] chars = new char[] {'A', 'B', 'C', 'D'};
		Mutex mutex = new Mutex(chars);
		for(int i = 0; i < chars.length; i++) {
			Thread print = new PrintThread(chars[i], mutex);
			print.start();
		}
	}

}

class PrintThread extends Thread {
	char ch;
	Mutex mutex;
	public PrintThread(char ch, Mutex mutex) {
		this.ch = ch;
		this.mutex = mutex;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true) {
			synchronized (mutex) {
				if(mutex.next() != ch)
					try {
						mutex.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				else {
					try {
						Thread.sleep(1 * 1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("\n" + mutex.nextPrint());
					mutex.notifyAll();
				}
			}
		}
	}
}

/**
 * 互斥量
 * @author asus
 *
 */
class Mutex {
	char[] chars;
	int i = 0;
	
	public Mutex(char[] chars) {
		// TODO Auto-generated constructor stub
		this.chars = chars;
	}
	
	public char next() {
		return chars[i % chars.length];
	}
	
	public char nextPrint() {
		return chars[i++ % chars.length];
	}
}