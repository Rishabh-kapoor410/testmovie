package com.movie.assembler;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.movie.entity.User;
import com.movie.entity.vo.UserVO;

public final class VOToEntityAssembler {

	public static User fillUser(UserVO userVO, User user) {
		
	
		Optional.ofNullable(userVO.getUsername()).ifPresent(x -> user.setUsername(x));
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		Optional.ofNullable(userVO.getPassword()).ifPresent(x -> user.setPassword(bcrypt.encode(x)));
		Optional.ofNullable(userVO.getEmail()).ifPresent(x -> user.setEmails(x));
		return user;
	}
	
}
