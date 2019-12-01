package com.movie.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.movie.entity.User;
import com.movie.entity.vo.UserVO;

@Service
@Qualifier("userService")
public interface IUserService
{
	public UserVO save(UserVO userVO);

	Optional<User> getByUsername(String username);
}