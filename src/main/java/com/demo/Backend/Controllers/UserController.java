package com.demo.Backend.Controllers;

import java.util.List;

import javax.swing.plaf.basic.BasicListUI.ListDataHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
}
//PUT edit user 
@PutMapping("/{userId}")
public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable("userId") Integer uid){
	UserDto updateUser=this.userservice.updateUser(userDto,uid);
	return ResponseEntity.ok(updateUser);
}
//DELETE user 
@DeleteMapping("/{userId}")
public <ApiResponse> ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
	this.userservice.deleteUser(uid);
	return new ResponseEntity<ApiResponse>(HttpStatus.OK);
}
@GetMapping("/all")
public ResponseEntity<List<UserDto>> getAllUsers(){
	return ResponseEntity.ok(this.userservice.getAllUsers());
}
// GET user
@GetMapping("/{userId}")
public ResponseEntity<UserDto> getSingleUsers(@PathVariable("userId") Integer uid){
	return ResponseEntity.ok(this.userservice.getUserById(uid));
}
}
