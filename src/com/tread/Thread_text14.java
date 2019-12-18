package com.tread;

import org.apache.commons.math3.analysis.solvers.NewtonRaphsonSolver;

class DeadLockThread implements Runnable{
	static Object chopsticks=new Object();
	static Object KnifeAndFork=new Object();
	private boolean flag;
	DeadLockThread(boolean flag){
		this.flag=flag;
	}
	@Override
	public void run() {
		if(flag) {
			while(true) {
				synchronized (chopsticks) {
					System.out.println(Thread.currentThread().getName()+"---if---chopsticks");
				}
				synchronized (KnifeAndFork) {
					System.out.println(Thread.currentThread().getName()+"---if---KnifeAndFork");
				}
			}
		}else {
		while(true) {
			synchronized (KnifeAndFork) {
				System.out.println(Thread.currentThread().getName()+"---if---KnifeAndFork");
	
			synchronized (chopsticks) {
				System.out.println(Thread.currentThread().getName()+"---if---chopsticks");
			}
			}
		}
		}
	}
}
public class Thread_text14 {

	public static void main(String[] args) {
		//创建两个对象
		DeadLockThread thread1=new DeadLockThread(true);
		DeadLockThread thread2=new DeadLockThread(false);
		//创建并开启两个路程
		new Thread(thread1,"Chinese").start();
		new Thread(thread2,"American").start();
	}

}
