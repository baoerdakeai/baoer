package com.tread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TicketWindow5 implements Runnable{
	private int tickets=10;
	//定义锁
	Lock lock=new ReentrantLock();
	public void run(){
		while(true) {
			//同步代码块
			lock.lock();
				if(tickets>0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}finally {
						//线程卖完后解锁
						lock.unlock();
					}
				}
				if(tickets>0) {
					System.out.println(Thread.currentThread().getName()+"正在发售第"+tickets--+"张票");
				}else {
					break;
					}
				}
		}
			}
		


public class Thread_text13 {

	public static void main(String[] args) {
		TicketWindow5 tw=new TicketWindow5();
		new Thread(tw,"窗口1").start();
		new Thread(tw,"窗口2").start();
		new Thread(tw,"窗口3").start();
		new Thread(tw,"窗口4").start();

	}

}
