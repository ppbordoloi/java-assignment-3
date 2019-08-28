package com.zaloni.assgn.Assgn3.controller;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zaloni.assgn.Assgn3.dao.ToDoDAO;
import com.zaloni.assgn.Assgn3.entity.ToDo;
import com.zaloni.assgn.Assgn3.entity.Users;

@Controller
public class AppController{
	
	@Autowired
	ToDoDAO toDoDAO;
	Users user2;
	ToDo toDoins;
	
	@RequestMapping("/")
	public String logIn() {
		return "login.jsp";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "register.jsp";
	}
	
	@RequestMapping("/showToDoAddForm")
	public String addToDo() {
		if(user2 == null) {
			return "redirect:/login.jsp";
		}
		return "ToDoAdd.jsp";
	}
	
	@RequestMapping("/saveToDo")
	@Transactional
	public String saveToDo(HttpServletRequest req) throws ParseException {
		ToDo toDo2 = new ToDo();
		toDo2.setUsers(user2);
		toDo2.setName(req.getParameter("name"));
		toDo2.setDescrp(req.getParameter("descrp"));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(req.getParameter("tdate"));  
		System.out.println(date);
		toDo2.setDate(date);
		Integer hh = Integer.parseInt(req.getParameter("hh"));
		Integer mm = Integer.parseInt(req.getParameter("mm"));
		Time time = new Time(hh,mm,00);
		toDo2.setTime(time);
		toDoDAO.saveToDo(toDo2);
		return "redirect:/showToDo";
	}
	
	@PostMapping("/registered")
	@Transactional
	public String registered(HttpServletRequest req, HttpServletResponse res) {
		Users user = new Users();
		user.setId(req.getParameter("id"));
		user.setName(req.getParameter("name"));
		user.setPassword(req.getParameter("pass"));
		toDoDAO.saveUser(user);
		return "login.jsp";
	}
	
	@RequestMapping("/loginCheck")
	@Transactional
	public String login(HttpServletRequest req,HttpServletResponse res,Model model) {
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		Users users = toDoDAO.checkLogin(id,pass);
		if(users == null) {
			return "redirect:/login.jsp";
		}
		else {
			this.user2=users;
			model.addAttribute("user1",users);
			return "showToDo";
		}
		
	}
	
	@RequestMapping("/showToDo")
	@Transactional
	public String showToDo(Model model) {
		if(user2 == null) {
			return "redirect:/login.jsp";
		}
		List<ToDo> list= toDoDAO.getToDoByUser(user2);
		model.addAttribute("ToDos",list);
		return "showToDo.jsp";
		
	}
	
	@RequestMapping("deleteLink")
	@Transactional
	public String removeToDo(HttpServletRequest req)
	{
		if(user2 == null) {
			return "redirect:/login.jsp";
		}
		Integer a = Integer.parseInt(req.getParameter("TDId"));
		toDoDAO.deleteToDo(a);
		return "showToDo";
	}

	@RequestMapping("/showFormForUpdate")
	@Transactional
	public String updateToDo1(HttpServletRequest req,Model model) {
		if(user2 == null) {
			return "redirect:/login.jsp";
		}
		Integer a = Integer.parseInt(req.getParameter("TDId"));
		ToDo toDo1 = toDoDAO.getToDoById(a);
		toDoins=toDo1;
		model.addAttribute("toDo1", toDo1);
		return "updateForm.jsp";
	}
	
	@RequestMapping("/updateToDo")
	@Transactional
	public String updateToDo(HttpServletRequest req) throws ParseException {
		if(user2 == null) {
			return "redirect:/login.jsp";
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(req.getParameter("tdate"));
		toDoins.setDate(date);
		toDoins.setName(req.getParameter("name"));
		toDoins.setDescrp(req.getParameter("descrp"));
		String timeString = req.getParameter("time");
		int hr = Integer.parseInt(timeString.substring(0, 1))*10+Integer.parseInt(timeString.substring(1, 2));
		int mins = Integer.parseInt(timeString.substring(3, 4))*10+Integer.parseInt(timeString.substring(4, 5));
		Time time = new Time(hr, mins, 00);
		toDoins.setTime(time);
		toDoDAO.updateToDo(toDoins);
		return "redirect:/showToDo";
	}
	
	@RequestMapping("/logout")
	@Transactional
	public String logoutUser() {
		user2=null;
		return "redirect:/login.jsp";
	}
	
	@RequestMapping("/searchById")
	@Transactional
	public String grtTdById(@RequestParam String id,Model model) {
		if(user2 == null) {
			return "redirect:/login.jsp";
		}
		ToDo td = toDoDAO.getToDoById(Integer.parseInt(id));
		model.addAttribute("todo22",td);
		return "showToDoById.jsp";
	}
	
	@RequestMapping("/indras")
	public String indd() {
		return "indddddd";
	}
	
}
