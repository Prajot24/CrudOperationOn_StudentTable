package com.example.StudentCrud.ExceptionHand;




public class ResourceNotFound extends RuntimeException {
	
	String ResourceName;
	String FieldName;
	long FieldValue;
	public ResourceNotFound(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s : %S",resourceName,fieldName,fieldValue));
		this.ResourceName = resourceName;
		this.FieldName = fieldName;
		this.FieldValue = fieldValue;
	}
	

}