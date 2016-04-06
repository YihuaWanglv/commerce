package com.iyihua.commerce.soa.common.model;

import java.io.Serializable;

public class Demo implements Serializable {

	private static final long serialVersionUID = 7525327812218241962L;

	private Integer id;
	private String name;
	
	
	@Override
	public String toString() {
		return "Demo [id=" + id + ", name=" + name + "]";
	}
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

}
