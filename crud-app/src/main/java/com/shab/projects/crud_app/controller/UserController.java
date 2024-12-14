package com.shab.projects.crud_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shab.projects.crud_app.dto.UserDTO;
import com.shab.projects.crud_app.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/adduser")
	public String addUser(@RequestBody UserDTO userDto) {

		return userService.addUser(userDto);

	}

	@GetMapping("/getusers")
	public List<UserDTO> getAllUsers() {

		return userService.getAllUsers();
	}

	@PutMapping("/updateuser/{id}")
	public String updateUser(@PathVariable int id, @RequestBody UserDTO user) {
		return userService.updateUser(id, user);

	}

	@DeleteMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable int id) {

		return userService.deleteUser(id);

	}

}
