package com.project.security.scrypt.scrypto;

import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.lambdaworks.crypto.SCryptUtil;

/**
 * @author MOBIOT
 *
 */
public class SCryptPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence arg0)  throws DataAccessException {
		// TODO Auto-generated method stub
		 return SCryptUtil.scrypt(arg0.toString(), 16, 16, 16);
	}

	@Override
	public boolean matches(CharSequence arg0, String arg1) throws DataAccessException {
		// TODO Auto-generated method stub
		return SCryptUtil.check(arg0.toString(), arg1);
	}
}