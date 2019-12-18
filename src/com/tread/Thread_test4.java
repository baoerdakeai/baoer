package com.tread;
class TicKedWindow extends Thread{

	public TicKedWindow(String name) {
		super(name);
		// TODO 自动生成的构造函数存根
	}
	private int tickets=100;
	public void run() {
		while(true) {
			if(tickets>0) {
				System.out.println(Thread.currentThread());
			}
		}
	}
}
public class Thread_test4 {
	public static void main(String[] args) {
		new TicKedWindow("窗口1").start();
		new TicKedWindow("窗口2").start();
		new TicKedWindow("窗口3").start();
		new TicKedWindow("窗口4").start();
	}
}
