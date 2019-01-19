package com.bindu.todolist.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="todolist")
public class ToDoList {
	
	private int id;
	private int priority;
	private String title;
	private String content;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "ToDoList [id=" + id + ", priority=" + priority + ", title=" + title + ", content=" + content + "]";
	}
	
	
	

}
