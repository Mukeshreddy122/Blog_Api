package com.demo.Backend.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@NoArgsConstructor
@Setter
@Getter

public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="Id",nullable=false)
	private int id;
	@Column(name="Name",nullable=false,length=100)
	private String name;
	@Column(name="Email",nullable=false,length=100)
	private String email;
	@Column(name="Password",nullable=false)
	private String password;
	private String about;
	
	
}
