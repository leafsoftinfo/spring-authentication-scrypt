package com.project.security.scrypt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Yvau
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET, produces = "text/html")
    public String loginAction(ModelMap model) {
    	model.addAttribute("title", "Spring security scrypt :: Login form");
        return "login";
    }
}
