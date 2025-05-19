package com.andy.test.Test02;

public class Post {
	private String title;
	private String user;
	private String content;

	Post(String title, String user, String content) {
		this.title = title;
		this.user = user;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public String getUser() {
		return user;
	}

	public String getContnent() {
		return content;
	}


	@Override
	public String toString() {
		return "제목 : " + title + " 작성자 : " + user + "내용 : " + content;
	}
}
