package com.douzone.container.user;

import java.util.List;

public class User {
	
	private int no = 0;
	private String name = "김정석";
	private Friend friend;
	private List<String> friends;
	
	public User() {
		// 빈 에서 기본 생성자를 만들기 때문에 디폴트생성자 선언
	}
	
	public User(String name){
		this.name = name;
	}
	
	public User(int no,String name){
		this.no = no;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	

	public Friend getFriend() {
		return friend;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}
	

	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", friend=" + friend + ", friends=" + friends + "]";
	}

}
