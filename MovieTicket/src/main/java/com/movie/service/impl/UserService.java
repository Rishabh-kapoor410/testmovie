package com.movie.service.impl;

import java.util.Optional;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.movie.assembler.EntityTOVOAssembler;
import com.movie.assembler.VOToEntityAssembler;
import com.movie.entity.User;
import com.movie.entity.vo.UserVO;
import com.movie.security.auth.JwtAuthenticationToken;
import com.movie.service.IUserService;
import com.movie.user.repository.UserRepository;

@Service
@Qualifier("userService2")
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepo;

	@Override

	// @Secured("ADMIN")
	public UserVO save(UserVO userVO) {

		User user = new User();
		User dBuser = userRepo.save(VOToEntityAssembler.fillUser(userVO, user));
		return EntityTOVOAssembler.fillUserVO(dBuser);

	}

	@Override
	public Optional<User> getByUsername(String username) {
		Optional<User> user = userRepo.findByUsername(username);

		if (user.isPresent())
			return user;
		return null;
	}

}
