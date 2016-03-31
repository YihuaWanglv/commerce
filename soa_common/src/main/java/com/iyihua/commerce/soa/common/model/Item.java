package com.iyihua.commerce.soa.common.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Item implements Serializable {

	private static final long serialVersionUID = 7525327812218241962L;

	private Long item_id;
	private Long user_id;
	private Date date;
	private Long category_id;
	private Long location_id;
	private Long project_id;
	private String tags;
	private BigDecimal duration;
	private String year;
	private String month;
	private String day;
	private String week;
	private String user_name;
	private String category_name;
	private String project_name;
	private String location_name;

	public Item() {
		super();
	}
	public Item(Long item_id, Long user_id, Date date, Long category_id, Long location_id, Long project_id, String tags, BigDecimal duration, String year, String month, String day, String week,
			String user_name, String category_name, String project_name, String location_name) {
		super();
		this.item_id = item_id;
		this.user_id = user_id;
		this.date = date;
		this.category_id = category_id;
		this.location_id = location_id;
		this.project_id = project_id;
		this.tags = tags;
		this.duration = duration;
		this.year = year;
		this.month = month;
		this.day = day;
		this.week = week;
		this.user_name = user_name;
		this.category_name = category_name;
		this.project_name = project_name;
		this.location_name = location_name;
	}
	@Override
	public String toString() {
		return "Item [item_id=" + item_id + ", user_id=" + user_id + ", date=" + date + ", category_id=" + category_id + ", location_id=" + location_id + ", project_id=" + project_id + ", tags="
				+ tags + ", duration=" + duration + ", year=" + year + ", month=" + month + ", day=" + day + ", week=" + week + ", user_name=" + user_name + ", category_name=" + category_name
				+ ", project_name=" + project_name + ", location_name=" + location_name + "]";
	}
	public Long getItem_id() {
		return item_id;
	}
	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	public Long getLocation_id() {
		return location_id;
	}
	public void setLocation_id(Long location_id) {
		this.location_id = location_id;
	}
	public Long getProject_id() {
		return project_id;
	}
	public void setProject_id(Long project_id) {
		this.project_id = project_id;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public BigDecimal getDuration() {
		return duration;
	}
	public void setDuration(BigDecimal duration) {
		this.duration = duration;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getLocation_name() {
		return location_name;
	}
	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}

}
