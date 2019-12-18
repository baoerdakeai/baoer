package com.tread;
class TicketWindow4 implements Runnable{
	private int tickets=10;
	public void run(){
		while(true) {
			maipiao();
		}
}
	private synchronized void maipiao() {
		if(tickets>0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (tickets>0) {
			System.out.println(Thread.currentThread().getName()+"正在发售第"+tickets--+"张票");
		}
	}
}
public class Thread_text12 {

	public static void main(String[] args) {
		TicketWindow4 tw=new TicketWindow4();
		new Thread(tw,"窗口1").start();
		new Thread(tw,"窗口2").start();
		new Thread(tw,"窗口3").start();
		new Thread(tw,"窗口4").start();

	}

}
