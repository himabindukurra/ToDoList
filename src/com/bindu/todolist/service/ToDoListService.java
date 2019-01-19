package com.bindu.todolist.service;

import com.bindu.todolist.model.ToDoList;
import com.bindu.todolist.model.Response;


public interface ToDoListService {

	public Response addList(ToDoList p);
	
	public Response deleteList(int id);
	
	public ToDoList getList(int id);
	
	public ToDoList[] getAllLists();

}