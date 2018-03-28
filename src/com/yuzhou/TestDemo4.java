package com.yuzhou;

import java.util.Arrays;
import java.util.List;

/**
 * 集合元素的sum运算 Map和Reduce
 * 
 * @author zhangyuzhou
 *
 */
public class TestDemo4 {

	public static void main(String[] args) {
		List<Integer> target = Arrays.asList(100, 200, 300, 400, 500);
		double total = 0;
		for (Integer integer : target) {
			double single = integer + .12 * integer;
			total += single;
		}
		System.out.println("sum exec ..." + total);

		double bill = target.stream().map((cost) -> cost + .12 * cost).reduce((sum, cost) -> sum + cost).get();
		System.out.println("sum java8 exec ..." + bill);
	}
}
