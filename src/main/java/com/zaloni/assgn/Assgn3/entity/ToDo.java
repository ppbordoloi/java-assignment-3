package com.zaloni.assgn.Assgn3.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="to_do")
public class ToDo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "t_id", unique = true, nullable = false)
	int id;
	@Column(name="t_name")
	String name;
	@Column(name="t_desc")
	String descrp;
	@Temporal(TemporalType.DATE)
	@Column(name="t_date")
	Date date;
	@Column(name="t_time")
	Time time;
	public Date getDate() {
		return date;
	}
	
	

	public void setDate(Date date) {
		this.date = date;
	}
	@ManyToOne
	Users users;
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDescrp() {
		return descrp;
	}
	public void setDescrp(String descrp) {
		this.descrp = descrp;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	
	

}
