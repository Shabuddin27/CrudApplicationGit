package com.shab.projects.crud_app.service;

import java.util.List;

import com.shab.projects.crud_app.dto.UserDTO;

public interface UserService {

	String addUser(UserDTO userDTO);

	List<UserDTO> getAllUsers();

	String updateUser(int id, UserDTO userDTO);

	String deleteUser(int id);
}
