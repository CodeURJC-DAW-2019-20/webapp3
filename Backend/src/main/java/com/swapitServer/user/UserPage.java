package com.swapitServer.user;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public class UserPage {

	private List<User> userList ;
	private Boolean last;
	private int totalPages;
	private long totalElements;
	private Sort sort;
	private int numberOfElements;
	private Boolean first;
	private int size;
	private int number;
	
	public UserPage (Page<User> page, List<User> list) {
		this.userList=list;
		this.last=page.isLast();
		this.totalPages=page.getTotalPages();
		this.totalElements=page.getTotalElements();
		this.sort=page.getSort();
		this.numberOfElements=page.getNumberOfElements();
		this.first=page.isFirst();
		this.size=page.getSize();
		this.number=page.getNumber();
	}

	public List<User> getUserList() {
		return userList;
	}

	public Boolean getLast() {
		return last;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public Sort getSort() {
		return sort;
	}

	public int getNumberOfElements() {
		return numberOfElements;
	}

	public Boolean getFirst() {
		return first;
	}

	public int getSize() {
		return size;
	}

	public int getNumber() {
		return number;
	}
	
	
}
