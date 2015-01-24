package com.project.security.scrypt.model;

import org.springframework.data.jpa.domain.AbstractPersistable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Yvau
 *
 */
@Entity
@Table(name = "person")
public class Person extends AbstractPersistable<Integer> {

    /**
	 * 
	 */
	private static final long serialVersionUID = -575268260622905154L;

	private String username;
    
    private String password;
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
