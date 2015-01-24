package com.project.security.scrypt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.security.scrypt.model.Person;
import com.project.security.scrypt.repository.PersonRepository;

/**
 * @author Yvau
 *
 */
@Controller
@Secured({"ROLE_USER"})
@RequestMapping("/")
public class HomeController {
	
	@Autowired
    private PersonRepository personRepository;
	
	/**
	 * @return
	 */
	@ModelAttribute("title")
	public String getTitle() {
		String title = "Spring security scrypt :: Welcome Home";
		
		return title;
    }
    
	@RequestMapping(method = RequestMethod.GET, produces = "text/html")
    public String homeAction(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Person person = personRepository.findByUsername(auth.getName());
		model.addAttribute("person", person);
        
		return "home";
    }

}
