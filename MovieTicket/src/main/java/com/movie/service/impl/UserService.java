package com.movie.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.movie.entity.User;
import com.movie.entity.vo.UserVO;
import com.movie.security.auth.JwtAuthenticationToken;
import com.movie.service.IUserService;
import com.movie.user.repository.UserRepository;

@Service
@Qualifier("userService2")
public class UserService implements IUserService{

	@Autowired
	UserRepository userRepo;

	@Override
	public UserVO save( UserVO userVO) {
		
		User user = new User();
		Optional.ofNullable(userVO.getName()).ifPresent(x ->user.setUsername(x));
		BCryptPasswordEncoder bcrypt  = new BCryptPasswordEncoder();
		Optional.ofNullable(userVO.getPassword()).ifPresent(x ->bcrypt.encode(x));
		Optional.ofNullable(userVO.getEmail()).ifPresent(x ->user.setEmails(x));
		User dBuser = userRepo.save(user);
		userVO.setId(dBuser.getId());
		return userVO;
	}

	@Override
	public Optional<User> getByUsername(String username) {
		Optional<User> user = userRepo.findByUsername(username);
		
		if(user.isPresent())
			return user;
		return null;
	}

}
