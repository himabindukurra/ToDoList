package com.bindu.todolist.service;

import java.util.HashMap;

import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bindu.todolist.model.ToDoList;
import com.bindu.todolist.model.Response;

@Path("/person")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)

public class ToDoListImpl implements ToDoListService {

	private static Map<Integer,ToDoList> lists = new HashMap<Integer,ToDoList>();
	
	@Override
	@POST
    @Path("/add")
	public Response addList(ToDoList p) {
		Response response = new Response();
		if(lists.get(p.getId()) != null){
			response.setStatus(false);
			response.setMessage("List Already Exists");
			return response;
		}
		lists.put(p.getId(), p);
		response.setStatus(true);
		response.setMessage("List created successfully");
		return response;
	}

	@Override
	@GET
    @Path("/{id}/delete")
	public Response deleteList(@PathParam("id") int id) {
		Response response = new Response();
		if(lists.get(id) == null){
			response.setStatus(false);
			response.setMessage("Lists Doesn't Exists");
			return response;
		}
		lists.remove(id);
		response.setStatus(true);
		response.setMessage("List deleted successfully");
		return response;
	}

	@Override
	@GET
	@Path("/{id}/get")
	public ToDoList getList(@PathParam("id") int id) {
		return lists.get(id);
	}
	
	@GET
	@Path("/{id}/getDummy")
	public ToDoList getDummyPerson(@PathParam("id") int id) {
		ToDoList p = new ToDoList();
		p.setId(99);
		p.setTitle("Dummy title");
		p.setContent("Dummy content");
		p.setPriority(0);
		
		return p;
	}

	@Override
	@GET
	@Path("/getAll")
	public ToDoList[] getAllLists() {
		Set<Integer> ids = lists.keySet();
		ToDoList[] p = new ToDoList[ids.size()];
		int i=0;
		for(Integer id : ids){
			p[i] = lists.get(id);
			i++;
		}
		return p;
	}

	
}

