package com.zaloni.assgn.Assgn3.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user1")
public class Users {

	@Id
	@Column(name="u_id")
	String id;
	@Column(name="u_name")
	String name;
	@Column(name="u_pass")
	String password;
	@OneToMany(cascade=CascadeType.ALL)
    private List<ToDo> toDo;
	
	public List<ToDo> getToDo() {
		return toDo;
	}
	public void setToDo(List<ToDo> toDo) {
		this.toDo = toDo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
