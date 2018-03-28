package com.yuzhou;

import java.util.Arrays;
import java.util.List;

/**
 * 集合元素的运算
 * 
 * @author zhangyuzhou
 *
 */
public class TestDemo3 {
	public static void main(String[] args) {
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		// normal
		for (Integer integer : costBeforeTax) {
			double price = integer + .12 * integer;
			System.out.println(price);
		}
		// Java8
		costBeforeTax.stream().map((cost) -> cost + .12 * cost).forEach(System.out::println);
	}
}
