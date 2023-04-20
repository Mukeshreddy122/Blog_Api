package com.demo.Backend.ServicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Backend.Payloads.UserDto;
import com.demo.Backend.Repositories.UserRepo;
import com.demo.Backend.Services.UserService;
import com.demo.Backend.Payloads.*;
import com.demo.Backend.Exceptions.ResourceNotFound;
import com.demo.Backend.Models.User;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	@Override
	public UserDto createUser(UserDto userDto) {
		User user =this.dtoToUser(userDto);
		User savedUser=this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto user, Integer userId) {
		User userOne=this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFound("User","Id",userId));
		userOne.setName(user.getName());
		userOne.setPassword(user.getPassword());
		userOne.setAbout(user.getAbout());
		userOne.setEmail(user.getEmail());
		User updatedUser=this.userRepo.save(userOne);
		UserDto userDto=this.userToDto(userOne);
		return userDto;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user=this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFound("User","Id",userId));
		
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users=this.userRepo.findAll();
		List<UserDto> userDto=users.stream().map(user->userToDto(user)).collect(Collectors.toList());
		return userDto;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user=this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFound("User","Id",userId));
		this.userRepo.delete(user);
	}
	private User dtoToUser(UserDto userDto) {
		 User user=new User();
		 user.setId(userDto.getId());
		 user.setName(userDto.getName());
		 user.setEmail(userDto.getEmail());
		 user.setPassword(userDto.getPassword());
		 user.setAbout(userDto.getAbout());
		 return user;
	}
	private UserDto userToDto(User user) {
		 UserDto userDto=new UserDto();
		 userDto.setId(user.getId());
		 userDto.setName(user.getName());
		 userDto.setEmail(user.getEmail());
		 userDto.setPassword(user.getPassword());
		 userDto.setAbout(user.getAbout());
		 return userDto;
	}

}
