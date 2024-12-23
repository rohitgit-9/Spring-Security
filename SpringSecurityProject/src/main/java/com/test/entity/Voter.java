package com.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Voter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String candidate;

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getCandidate() {
		return candidate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}

	@Override
	public String toString() {
		return "Voter [id=" + id + ", username=" + username + ", candidate=" + candidate + "]";
	}

}
