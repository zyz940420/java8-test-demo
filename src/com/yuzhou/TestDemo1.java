package com.yuzhou;

import java.util.Arrays;
import java.util.List;

/**
 * java8 的线程创建已经集合的forEach
 * 
 * @author zhangyuzhou
 *
 */
public class TestDemo1 {
	public static void main(String[] args) {
		// java8之前实现runnable接口
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("java8 before start...");
			}
		});
		thread.start();

		// java8之后的线程实现
		Thread thread2 = new Thread(() -> System.out.println("java8 after start..."));
		thread2.start();

		Thread thread3 = new Thread();
		thread3.start();

		testForEach1();
		testForEach2();
	}

	private static void testForEach1() {
		List<String> targer = Arrays.asList("Lambdas", "default method", "stream api", "date and time");
		for (String string : targer) {
			System.out.println("for each exec ..." + string);
		}
	}

	/**
	 * java8 集合的循环
	 */
	private static void testForEach2() {
		List<String> targer = Arrays.asList("Lambdas", "default method", "stream api", "date and time");
		targer.forEach(n -> System.out.println("java8 exec ..." + n));
	}
}
