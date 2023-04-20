package com.demo.Backend.Exceptions;

public class ResourceNotFound extends RuntimeException {
	String resourceName;
	String feildName;
	int fieldValue;
	
	public ResourceNotFound(String resourceName, String feildName, int fieldValue) {
		super(String.format("%s not found with %s:%i", resourceName,feildName,fieldValue));
		this.resourceName = resourceName;
		this.feildName = feildName;
		this.fieldValue = fieldValue;
	}
}
