package com.movie.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.movie.entity.User;
import com.movie.entity.vo.UserVO;
import com.movie.service.IUserService;
import com.movie.user.repository.UserRepository;

/**
 * Mock implementation.
 * 
 * @author rishabh.kapoor
 */
@Service
@Qualifier("userService3")
public class DatabaseUserService implements IUserService {
    private final UserRepository userRepository;
    
    @Autowired
    public DatabaseUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

	@Override
	public UserVO save(UserVO userVO) {
		// TODO Auto-generated method stub
		return null;
	}
}
