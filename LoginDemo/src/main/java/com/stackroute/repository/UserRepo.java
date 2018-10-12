package com.stackroute.repository;

import java.util.List;

import com.stackroute.model.UserDetails;

public class UserRepo {

	private List<UserDetails> list;

	public List<UserDetails> getUser() {
		return list;
	}

	public void setUser(List<UserDetails> list) {
		this.list = list;
	}
}
