package com.yuzhou;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestDemo5 {
	public static void main(String[] args) {
		List<String> target = Arrays.asList("abc", "bcd", "defg", "jk");
		List<String> filter = target.stream().filter(x -> x.length() > 2).collect(Collectors.toList());
		System.out.printf("Original List : %s, filtered list : %s %n", target, filter);
		
		
	}

}
