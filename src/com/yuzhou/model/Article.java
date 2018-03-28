package com.yuzhou.model;

import java.util.List;

public class Article {
	private String title;
	
	private String autho;
	
	private List<String> tags;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAutho() {
		return autho;
	}

	public void setAutho(String autho) {
		this.autho = autho;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Article(String title, String autho, List<String> tags) {
		super();
		this.title = title;
		this.autho = autho;
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Article [title=" + title + ", autho=" + autho + ", tags=" + tags + "]";
	}
}
