package com.demo.Backend.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.Backend.Payloads.UserDto;
import com.demo.Backend.Repositories.UserRepo;
import com.demo.Backend.Services.UserService;
import com.demo.Backend.Payloads.*;
import com.demo.Backend.Models.User;
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	@Override
	public UserDto createUser(UserDto user) {
		
		return null;
	}

	@Override
	public UserDto updateUser(UserDto user, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub

	}

}
