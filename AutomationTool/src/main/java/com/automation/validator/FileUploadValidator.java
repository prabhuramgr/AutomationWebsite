package com.automation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.automation.model.FileUpload;

public class FileUploadValidator implements Validator {

	public boolean supports(Class clazz) {
		// TODO Auto-generated method stub
		return FileUpload.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
        FileUpload file = (FileUpload)target;
		
		if(file.getFile().getSize()==0){
			errors.rejectValue("file", "required.fileUpload");
		}
		
	}
	
}


