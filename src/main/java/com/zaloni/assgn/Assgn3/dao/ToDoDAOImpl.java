package com.zaloni.assgn.Assgn3.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zaloni.assgn.Assgn3.entity.ToDo;
import com.zaloni.assgn.Assgn3.entity.Users;

@Repository
public class ToDoDAOImpl implements ToDoDAO{
	
	// define field for entitymanager	
		private EntityManager entityManager;
			
		// set up constructor injection
		@Autowired
		public ToDoDAOImpl(EntityManager theEntityManager) {
			entityManager = theEntityManager;
		}
	@Override
	public Users saveUser(Users user) {
		entityManager.persist(user);
		return user;
	}
	@Override
	public void saveToDo(ToDo toDo) {
		entityManager.persist(toDo);
	}
	@Override
	public Users checkLogin(String id, String pass) {
		
		Users user1 = entityManager.find(Users.class, id);
		if(pass.equals(user1.getPassword())) {
			return user1;
		}
		else {
			return null;
		}
	}
	@Override
	public List<ToDo> getToDoByUser(Users users) {
		
		String hql = "SELECT TD FROM" + " ToDo TD WHERE" + " users =:uId";

        TypedQuery<ToDo> query = entityManager.createQuery(hql, ToDo.class);
        query.setParameter("uId", users);
        List<ToDo> list = query.getResultList();
		//Query query = entityManager.createQuery( "Select * " + "from ToDo e " + "where e.users=" + users);  
	    //List<ToDo> list=(List<ToDo>) query.getResultList( );
		return list;
	}
	@Override
	public void deleteToDo(int toDoId) {
		ToDo toDo1=entityManager.find(ToDo.class, toDoId);
		entityManager.remove(toDo1);
	}
	@Override
	public ToDo getToDoById(int toDoId) {
		ToDo toDo1=entityManager.find(ToDo.class, toDoId);
		return toDo1;
	}
	@Override
	public void updateToDo(ToDo toDo) {
		entityManager.merge(toDo);
	}

}
