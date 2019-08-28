package com.zaloni.assgn.Assgn3.dao;

import java.util.List;

import com.zaloni.assgn.Assgn3.entity.ToDo;
import com.zaloni.assgn.Assgn3.entity.Users;


public interface ToDoDAO {
	
	public Users saveUser(Users user);
	public void saveToDo(ToDo toDo);
	public Users checkLogin(String id, String pass);
	public List<ToDo> getToDoByUser(Users users);
	public void deleteToDo(int toDoId);
	public ToDo getToDoById(int toDoId);
	public void updateToDo(ToDo toDo);
}
