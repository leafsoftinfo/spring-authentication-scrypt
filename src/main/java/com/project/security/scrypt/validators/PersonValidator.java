package com.project.security.scrypt.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.security.scrypt.form.PersonForm;
import com.project.security.scrypt.model.Person;
import com.project.security.scrypt.repository.PersonRepository;

/**
 * @author Yvau
 *
 */
@Component
public class PersonValidator implements Validator{
	
	private static final int MINIMUM_PASSWORD_LENGTH = 6;  
	
	@Autowired
	private PersonRepository personRepository;


	@Override
	public boolean supports(Class<?> c) {
		//just validate the profiler instances
	        return Person.class.isAssignableFrom(c);
	}
	
	@Override
	public void validate(Object obj, Errors errors) {
		
		PersonForm personForm = (PersonForm)obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd",  
			    "required.password", "the password is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rePwd",  
			    "required.password", "the password is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username",  
			    "required.username", "the username is required.");
		
		
		// password validation 
		if (!(personForm.getPwd().isEmpty())) {  
			  if (personForm.getPwd().trim().length() < MINIMUM_PASSWORD_LENGTH) {  
				  errors.rejectValue("pwd", "length.password", "the password is to short."); 
			  }
			  else if(!(personForm.getPwd().equals(personForm.getRePwd()))){
					errors.rejectValue("rePwd", "match.password", "the password is not matching.");
			}
		  }

		String username = personForm.getUsername();
		
		// username validation  
		if (!(personForm.getUsername().isEmpty())) {  	   
		   if(personRepository.findByUsername(username) != null){
			errors.rejectValue( "username", "exist.username", "The username already exist");
		   }
		 }
	}
	
}