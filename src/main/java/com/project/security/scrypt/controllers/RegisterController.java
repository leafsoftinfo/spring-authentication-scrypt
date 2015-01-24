package com.project.security.scrypt.controllers;

import java.util.ArrayList;
import java.util.List;

import com.lambdaworks.crypto.SCryptUtil;
import com.project.security.scrypt.form.PersonForm;
import com.project.security.scrypt.model.Person;
import com.project.security.scrypt.repository.PersonRepository;
import com.project.security.scrypt.validators.PersonValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * @author Yvau
 *
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonValidator personValidator;
    
    /**
	 * @return
	 */
	@ModelAttribute("title")
	public String getTitle() {
		String title = "Spring security scrypt :: Registration form";
		
		return title;
    }
    

    @RequestMapping(method = RequestMethod.GET)
    public String registerForm(ModelMap model) {
    	PersonForm personForm = new PersonForm();
    	model.addAttribute("personForm", personForm);
    	return "register";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String registerAction(@Valid @ModelAttribute("personForm") PersonForm personForm, BindingResult bindingResult, ModelMap model) {
    	personValidator.validate(personForm, bindingResult);
    	//validation handling
    	if (bindingResult.hasErrors() ){
    		return "register";
    	}else{
    		Person person = new Person();
            
            
            //process data
    		person.setUsername(personForm.getUsername());
            String passwordHash = SCryptUtil.scrypt(personForm.getPwd(), 16, 16, 16);
    		person.setPassword(passwordHash);              
            personRepository.save(person);
            authorizeUser(person);
    		return "redirect:/";
    		
    	
    	}
    }

	private void authorizeUser(Person person) { 	
    	List<GrantedAuthority> role = new ArrayList<GrantedAuthority>();
    	role.add(new SimpleGrantedAuthority("ROLE_USER"));
    	
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth =  new UsernamePasswordAuthenticationToken(person, null, role);
        context.setAuthentication(auth);
    }
}
