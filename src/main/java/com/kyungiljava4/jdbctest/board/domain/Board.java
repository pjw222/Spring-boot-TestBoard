package com.kyungiljava4.jdbctest.board.domain;

// POJO
// Plain Old Java Object
// 특정 규약에 종속되지 않는다. << 확실하게 정해진 규칙이 없다.
// 특정 환경에 종속되지 않는다.
public class Board {
	private int id;
	private String user;
	private String title;
	private String content;

	public Board() {
	}

	public Board(String user, String title, String content) {
		this.user = user;
		this.title = title;
		this.content = content;
	}

	public Board(int id, String user, String title, String content) {
		this.id = id;
		this.user = user;
		this.title = title;
		this.content = content;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUser() {
		return user;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

}