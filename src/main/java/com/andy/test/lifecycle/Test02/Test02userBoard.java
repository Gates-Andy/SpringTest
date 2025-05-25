package com.andy.test.lifecycle.Test02;

public class Test02userBoard {

	private String title;
	private String user;
	private String content;

	Test02userBoard(String title, String user, String content) {
		this.title = title;
		this.user = user;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	// 마우스 오른쪽 source 그리고 generate getter setter 근데 왜 어떤건 setter 밖에 없는가
	@Override
	public String toString() {
		return "제목 : " + title + " 작성자 : " + user + "내용 : " + content;
	}
}
