package com.yuzhou.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class TestArticle {

	public static void main(String[] args) {
		List<Article> articleList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			List<String> stringList = new ArrayList<>(Arrays.asList("javaTest", "testjava"));
			Article article = new Article("test" + i, "yuzhou" + i, stringList);
			articleList.add(article);
		}
		getFirstJavaArticle1(articleList);
		getFirstJavaArticle2(articleList);
		getAllJavaArticles1(articleList);
		getAllJavaArticle2(articleList);
		groupByAuthor1(articleList);
		groupByAuthor2(articleList);
		getDsitinctTags1(articleList);
		getDistinctTags2(articleList);
	}

	// ------------------------------------------------------------------------------------------
	private static void getDsitinctTags1(List<Article> articleList) {
		Set<String> tagSet = new HashSet<>();
		for (Article article : articleList) {
			tagSet.addAll(article.getTags());
		}
		System.out.println("set distinct exec ..." + tagSet.size());
	}

	/**
	 * 集合元素去重
	 * 
	 * @param articleList
	 */
	private static void getDistinctTags2(List<Article> articleList) {
		Set<String> tags = articleList.stream().flatMap(article -> article.getTags().stream())
				.collect(Collectors.toSet());
		System.out.println("set distinct java8 exec ..." + tags.size());
	}

	// ------------------------------------------------------------------------------------------
	private static void groupByAuthor1(List<Article> articleList) {
		Map<String, List<Article>> target = new HashMap<>();
		for (Article article : articleList) {
			if (target.containsKey(article.getTitle())) {
				target.get(article.getTitle()).add(article);
			} else {
				List<Article> list = new ArrayList<>();
				list.add(article);
				target.put(article.getTitle(), list);
			}
		}
		System.out.println("groupby exec ..." + target.size());
	}

	/**
	 * 分组api
	 * 
	 * @param articleList
	 */
	private static void groupByAuthor2(List<Article> articleList) {
		Map<String, List<Article>> target = articleList.stream().collect(Collectors.groupingBy(Article::getTitle));
		System.out.println("groupby java8 exec ..." + target.size());
	}

	// ------------------------------------------------------------------------------------------
	private static void getAllJavaArticles1(List<Article> articleList) {
		List<Article> result = new ArrayList<>();
		for (Article article : articleList) {
			if (article.getTags().contains("javaTest")) {
				result.add(article);
			}
		}
		System.out.println("mutil exec..." + result.get(0).toString());
	}

	/**
	 * 获取满足某一条件的集合
	 * 
	 * @param articleList
	 */
	private static void getAllJavaArticle2(List<Article> articleList) {
		List<Article> target = articleList.stream()
				.filter(article -> article.getTags().contains("javaTest") || article.getTags().contains("testjava"))
				.collect(Collectors.toList());
		for (Article article : target) {
			System.out.println("mutil java8 exec..." + article);
		}
	}

	// ------------------------------------------------------------------------------------------

	public static Article getFirstJavaArticle1(List<Article> articleList) {
		for (Article article : articleList) {
			if (article.getTags().contains("javaTest")) {
				System.out.println("single exec..." + article.getTitle());
				return article;
			}
		}
		return null;
	}

	/**
	 * 集合里面查找集合里面的值，返回这个值对应的这个对象
	 * 
	 * @param articleList
	 * @return
	 */
	public static Optional<Article> getFirstJavaArticle2(List<Article> articleList) {
		Optional<Article> target = articleList.stream().filter(article -> article.getTags().contains("javaTest"))
				.findFirst();
		System.out.println("single java8 exec" + target.get());
		return target;
	}

}
