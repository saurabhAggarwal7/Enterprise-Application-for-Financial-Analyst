package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/Getuser", method = RequestMethod.GET)
	public List getAllUsers() {
		return userService.getAllUsers();

	}

	@RequestMapping(value = "/Getuser/{id}", method = RequestMethod.GET)
	public Users getUsers(@PathVariable String id) {
		return userService.getUsers(id);
	}

	@RequestMapping(value = "/Postuser", method = RequestMethod.POST)
	public void addUsers(@RequestBody Users user) {
		System.out.println("--Inside the controller--");
		System.out.println("--username--"+user.getFirstname());
		System.out.println("--password--"+user.getPassword());
		System.out.println("--Lastname--"+user.getLastname());
		if(user.getFlag().equalsIgnoreCase("linkedln")) {
			
			
		}else {
			user.setFlag("1");
			System.out.println("to string :: "+user.toString());
		}
		
		userService.addUsers(user);

	}

	@RequestMapping(value = "/Putuser/{id}", method = RequestMethod.PUT)
	public void updateUsers(@RequestBody Users user, @PathVariable int id) {
		user.setFirstname("sound.amtha@gmail.com");
		user.setFlag("2");
		userService.updateUsers(id, user);
	}

	@RequestMapping(value = "/Deleteuser/{id}", method = RequestMethod.DELETE)
	public void deleteUsers(@PathVariable String id) {
		userService.deleteUsers(id);
	}
	
	
	@RequestMapping(value = "/reqperm", method = RequestMethod.POST)
	public HashMap reqperm(@RequestBody Users user) {
		
		HashMap<String, String> hmap = new HashMap<String, String>();
		
		
		System.out.println(hmap.toString());
		
		return hmap;

	}
	
	
	@RequestMapping(value= "/reqvalues", method = RequestMethod.POST)
	public String reqvalues(@RequestBody Users user,Model model) {
		System.out.println("insidee"+user.getFirstname());
		if(user.getFirstname().equalsIgnoreCase("Rahul")) {
			return "dashboard";
			
		}
			return "sound";
			
		
	
	
	}
	
	

}
