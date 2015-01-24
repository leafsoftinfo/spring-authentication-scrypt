package com.project.security.scrypt.form;


/**
 * @author Yvau
 *
 */
public class PersonForm {

	private String username;
	
	private String pwd;
	
	private String rePwd;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRePwd() {
		return rePwd;
	}

	public void setRePwd(String rePwd) {
		this.rePwd = rePwd;
	}
	
}