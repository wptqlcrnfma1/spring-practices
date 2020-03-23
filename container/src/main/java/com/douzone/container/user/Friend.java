package com.douzone.container.user;

public class Friend {
	private String name;
	
	public Friend(String name) {
		System.out.println("friend 생성자 호출");
		this.name = name;
	}

	@Override
	public String toString() {
		return "Friend [name=" + name + "]";
	}
}
