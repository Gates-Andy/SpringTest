package com.andy.test.Test02;

public class Test02userBoard {

	private String title;
	private String user;
	private String content;
	
	Test02userBoard(String title, String user, String content){
		this.title = title;
		this.user = user;
		this.content = content;
	}
	
	public String getTitle() {
		return title;
	}
	public String getuser() {
		return user;
	}
	public String getContnent() {
		return content;
	}
	
}
