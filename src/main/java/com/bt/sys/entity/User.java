package com.bt.sys.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String age;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public User(Integer id, String name, String age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
