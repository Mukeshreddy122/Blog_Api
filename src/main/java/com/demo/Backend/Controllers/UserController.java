package com.demo.Backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Backend.Payloads.UserDto;
import com.demo.Backend.Services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
@Autowired
private UserService userservice;
//POST create user 
@PostMapping("/")
public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
	UserDto createUserDto =this.userservice.createUser(userDto);
	return new ResponseEntity<>(createUserDto,HttpStatus.CREATED); 
};
//PUT edit user 
	
//DELETE user 
	
// GET user 
}
