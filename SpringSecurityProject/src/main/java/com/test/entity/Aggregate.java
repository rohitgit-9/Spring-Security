package com.test.entity;

public class Aggregate {
	private String name;
	private String count;
	public String getName() {
		return name;
	}
	public String getCount() {
		return count;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCount(String count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Aggregate [name=" + name + ", count=" + count + "]";
	}

}
