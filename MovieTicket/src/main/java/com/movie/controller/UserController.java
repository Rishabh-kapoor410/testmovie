package com.movie.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.common.Constants;
import com.movie.common.Response;
import com.movie.entity.User;
import com.movie.entity.vo.JwtAuthenticationResponse;
import com.movie.entity.vo.UserVO;
import com.movie.security.JwtTokenProvider;
import com.movie.security.auth.JwtAuthenticationToken;
import com.movie.security.auth.ajax.AjaxAuthenticationProvider;
import com.movie.security.auth.ajax.LoginRequest;
import com.movie.security.auth.jwt.JwtAuthenticationProvider;
import com.movie.security.model.token.JwtTokenFactory;
import com.movie.service.IUserService;
import com.movie.user.repository.RoleRepository;
import com.movie.user.repository.UserRepository;

@RestController()
@RequestMapping(value = "/users")
public class UserController {

	static Logger logger = Logger.getLogger(UserController.class);
	static Marker confidentialMarker = MarkerFactory.getMarker("UserController");

	@Autowired
	IUserService userService;

	@PostMapping()
	@RequestMapping("/signUp")
	public Response<?> postUser(JwtAuthenticationToken token, @RequestBody UserVO userVO) {
		Collection<UserVO> colUserVO = new ArrayList<>();
		try {

			UserVO rsltUserVO = userService.save(userVO);
			if (rsltUserVO.getId() != null) {
				colUserVO.add(rsltUserVO);
				return new Response<UserVO>("User Saved Successfull", colUserVO, Constants.success);
			}
			return new Response<UserVO>("User Save Unsuccessfull", Collections.EMPTY_LIST);
		} catch (Exception e) {
			logger.info(confidentialMarker + ",Exception in the class{} ," + e.getLocalizedMessage());
			return new Response<UserVO>("User Save Unsuccessfull " + e.getLocalizedMessage(), Collections.EMPTY_LIST);
		}

	}

}
