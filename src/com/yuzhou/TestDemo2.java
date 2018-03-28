package com.yuzhou;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 使用predicate条件判断
 * 
 * @author zhangyuzhou
 *
 */
public class TestDemo2 {
	public static void main(String[] args) {
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		System.out.println("language which starts with J:");
		filter(languages, (str) -> str.startsWith("J"));

		System.out.println("language which end with a:");
		filter(languages, (str) -> str.endsWith("a"));

		System.out.println("print all language:");
		filter(languages, (str) -> true);

		System.out.println("print no language:");
		filter(languages, (str) -> false);

		System.out.println("Print language whose length greater than 4:");
		filter(languages, (str) -> str.length() > 4);

		Predicate<String> startWithJ = (n) -> n.startsWith("J");
		Predicate<String> fourLetterLong = (n) -> n.length() == 4;
		languages.stream().filter(startWithJ.and(fourLetterLong))
				.forEach((n) -> System.out.println("nName,which starts startWithJ 'J' and four letter long is :" + n));
	}

	private static void filter(List<String> languages, Predicate<String> condition) {
		for (String name : languages) {
			if (condition.test(name)) {
				System.out.println(name + " ");
			}
		}
	}

}
